import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-conference',
  templateUrl: './conference.component.html',
  styleUrl: './conference.component.css'
})
export class ConferenceComponent implements OnInit{

  constructor(private http : HttpClient) {}
  conferences:any;

  ngOnInit(): void {
    this.http.get("http://localhost:8082/api/bank-agencies")
      .subscribe({
        next : data => {
          console.log('in conference')
          this.conferences = data;
        },
        error : err => {
          console.log(err);
        }
      });
  }







}
