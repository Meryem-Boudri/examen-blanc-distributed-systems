import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { KeycloakService } from 'keycloak-angular';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private keycloakService: KeycloakService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.keycloakService.getKeycloakInstance().token;
    console.log('Token:', token);

    if (token) {
      // Clone the request and add the Authorization header with the token
      const clonedRequest = req.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
      console.log('req before interception ',clonedRequest)

      return next.handle(clonedRequest);
    }
console.log('req after interception ',req)
    // If no token, return the original request
    return next.handle(req);
  }
}
