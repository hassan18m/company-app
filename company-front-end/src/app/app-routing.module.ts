import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GetEmployeeComponent } from './get-employee/get-employee.component';
import { SubmitEmployeeComponent } from './submit-employee/submit-employee.component';

const routes: Routes = [
  { path:'get-employee', component: GetEmployeeComponent },
  { path: 'submit-employee', component: SubmitEmployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
