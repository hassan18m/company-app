import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CompanySectionComponent } from './company-section/company-section.component';
import { EmployeeSectionComponent } from './employee-section/employee-section.component';
import { GetEmployeeComponent } from './employee-section/crud-section/get-employee/get-employee.component';
import { SubmitEmployeeComponent } from './employee-section/crud-section/submit-employee/submit-employee.component';
import { GetCompanyComponent } from './company-section/crud-section/get-company/get-company.component';
import { SubmitCompanyComponent } from './company-section/crud-section/submit-company/submit-company.component';

const routes: Routes = [
  { path:'employee', component: EmployeeSectionComponent, children: [
    { path: 'get', component: GetEmployeeComponent },
    { path: 'submit', component: SubmitEmployeeComponent}
  ]},
  { path: 'company', component: CompanySectionComponent, children: [
    { path: 'get', component: GetCompanyComponent },
    { path: 'submit', component: SubmitCompanyComponent }
  ] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
