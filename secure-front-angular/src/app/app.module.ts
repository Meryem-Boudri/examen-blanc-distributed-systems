import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { KeynoteComponent } from './keynote/keynote.component';
import { ConferenceComponent } from './conference/conference.component';
import {KeycloakAngularModule, KeycloakService} from 'keycloak-angular';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { NgZone } from '@angular/core';

import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import {AuthInterceptor} from './interceptors/auth.interceptor';

export function initializeKeycloak(keycloak: KeycloakService) : ()=>Promise<any>
{
  return ():Promise<any> =>
  {
    return new Promise<void>(async (resolve, reject) => {
      try {
        await keycloak.init({
          config: {
            url: 'http://localhost:8080',  // Keycloak base URL
            realm: 'sdia-realm',          // Your realm name
            clientId: 'sdia-customer-client', // Your client ID
          },
          loadUserProfileAtStartUp: false,
          initOptions: {
            checkLoginIframe: false
          },
          enableBearerInterceptor: true,
          bearerExcludedUrls: ['']
        })
          .then(() => {
            console.log('Keycloak initialized successfully');

          })
        resolve();
      }catch (error) {
        console.log("error happened during Keycloak initialization : ", error)
        reject(error);
      }
    });
  };
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
    KeycloakService,
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      deps: [KeycloakService],
      multi: true, // This will make sure the app waits for Keycloak to initialize
    },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
