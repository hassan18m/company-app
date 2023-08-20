import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GetEmployeeComponent } from './employee-section/crud-section/get-employee/get-employee.component';
import { SubmitEmployeeComponent } from './employee-section/crud-section/submit-employee/submit-employee.component';
import { EmployeeSectionComponent } from './employee-section/employee-section.component';
import { CompanySectionComponent } from './company-section/company-section.component';
import { GetCompanyComponent } from './company-section/crud-section/get-company/get-company.component';
import { SubmitCompanyComponent } from './company-section/crud-section/submit-company/submit-company.component';

@NgModule({
  declarations: [
    AppComponent,
    GetEmployeeComponent,
    SubmitEmployeeComponent,
    EmployeeSectionComponent,
    CompanySectionComponent,
    GetCompanyComponent,
    SubmitCompanyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
