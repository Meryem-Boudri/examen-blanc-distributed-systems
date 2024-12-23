import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-keynote',
  templateUrl: './keynote.component.html',
  styleUrls: ['./keynote.component.css']  // Fixed styleUrls (plural)
})
export class KeynoteComponent implements OnInit {
  keynotes: any;  // Declare the type of keynotes if you know the structure, like: keynotes: Keynote[];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    console.log('KeynoteComponent initialized');
    this.http.get("http://localhost:8083/keynotes/")
      .subscribe({
        next: (data) => {
          this.keynotes = data;
          console.log('data', data);
        },
        error: (err) => {
          console.error('Error fetching keynotes:', err);
        }
      });
  }
}
