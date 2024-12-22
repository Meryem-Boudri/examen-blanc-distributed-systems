import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { KeycloakService } from 'keycloak-angular';

@Component({
  selector: 'app-keynote',
  templateUrl: './keynote.component.html',
  styleUrls: ['./keynote.component.css']
})
export class KeynoteComponent implements OnInit {

  keynotes: any;

  constructor(private http: HttpClient, private keycloakService: KeycloakService) {}

  ngOnInit(): void {
    // Get the token from Keycloak service
    const token = this.keycloakService.getToken();

    // Set up the authorization header
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',

    });

    // Send the GET request with the authorization header
    this.http.get('http://localhost:9999/keynote-service/keynotes/', { headers: headers })
      .subscribe({
        next: data => {
          this.keynotes = data;
        },
        error: err => {
          console.log(err);
        }
      });
  }
}
