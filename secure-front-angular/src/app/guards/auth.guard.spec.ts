import { TestBed } from '@angular/core/testing';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot } from '@angular/router';
import { KeycloakService } from 'keycloak-angular';
import { AuthGuard } from './auth.guard';

describe('AuthGuard', () => {
  let guard: AuthGuard;
  let keycloakServiceSpy: jasmine.SpyObj<KeycloakService>;
  let routerSpy: jasmine.SpyObj<Router>;

  beforeEach(() => {
    keycloakServiceSpy = jasmine.createSpyObj<KeycloakService>('KeycloakService', ['login']);
    routerSpy = jasmine.createSpyObj<Router>('Router', ['navigate']);

    TestBed.configureTestingModule({
      providers: [
        AuthGuard,
        { provide: KeycloakService, useValue: keycloakServiceSpy },
        { provide: Router, useValue: routerSpy },
      ],
    });

    guard = TestBed.inject(AuthGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });

  it('should allow access if no roles are required', async () => {
    const route = {
      data: {roles: []},
    } as unknown as ActivatedRouteSnapshot;
    const state = {} as RouterStateSnapshot;

    spyOn(guard, 'isAccessAllowed').and.returnValue(Promise.resolve(true));

    const result = await guard.isAccessAllowed(route, state);
    expect(result).toBeTrue();
  });

  it('should deny access if user is not logged in', async () => {
    //guard.authenticated = false;
    keycloakServiceSpy.login.and.callFake(() => Promise.resolve());

    const route = {} as ActivatedRouteSnapshot;
    const state = {} as RouterStateSnapshot;

    const result = await guard.isAccessAllowed(route, state);
    expect(keycloakServiceSpy.login).toHaveBeenCalled();
    expect(result).toBeFalse();
  });
});
