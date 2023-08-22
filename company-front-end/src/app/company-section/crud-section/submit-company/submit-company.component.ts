import { Component } from '@angular/core';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-submit-company',
  templateUrl: './submit-company.component.html',
  styleUrls: ['./submit-company.component.css']
})
export class SubmitCompanyComponent {

  company: any = { };
  
  constructor(private apiService: ApiService) { };

  createCompany() {
    this.apiService.createCompany(this.company).subscribe(
    {
      next: (response: any) => {
        console.log('New company persisted:', response);
      },
      error: (error: any) => {
        console.log('Error creating company: ', error);
      }
    }
    );
  }
}
