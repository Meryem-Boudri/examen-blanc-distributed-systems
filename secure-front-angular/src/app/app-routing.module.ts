import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {AuthGuard} from './guards/auth.guard';
import {KeynoteComponent} from './keynote/keynote.component';
import {ConferenceComponent} from './conference/conference.component';

const routes: Routes = [
  { path: 'keynote', component: KeynoteComponent, canActivate: [AuthGuard] },
  { path: 'conference', component: ConferenceComponent, canActivate: [AuthGuard] },
  { path: '', redirectTo: '/keynote', pathMatch: 'full' },
  { path: '**', redirectTo: '/keynote' },
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
