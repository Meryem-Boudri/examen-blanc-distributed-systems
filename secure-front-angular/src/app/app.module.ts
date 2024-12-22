import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KeynoteComponent } from './keynote/keynote.component';
import { ConferenceComponent } from './conference/conference.component';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';
import {HttpClientModule} from '@angular/common/http';

function initializeKeycloak(keycloak: KeycloakService) {
  return () =>
    keycloak.init({
      config: {
        url: 'http://localhost:8080', // Keycloak base URL
        realm: 'sdia-realm',          // Your realm name
        clientId: 'sdia-customer-client', // Your public client ID
      },
      initOptions: {
        onLoad: 'check-sso', // Check if the user is already logged in
        silentCheckSsoRedirectUri:
          window.location.origin + '/assets/silent-check-sso.html',
      }
    });
}


@NgModule({
  declarations: [
    AppComponent,
    KeynoteComponent,
    ConferenceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
    HttpClientModule, // Add this module



  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      deps: [KeycloakService],
      multi: true, // This will make sure the app waits for Keycloak to initialize
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
