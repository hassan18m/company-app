import { Component } from '@angular/core';
import { ApiService } from '../../../api.service';

@Component({
  selector: 'app-submit-employee',
  templateUrl: './submit-employee.component.html',
  styleUrls: ['./submit-employee.component.css']
})
export class SubmitEmployeeComponent {
  employee: any = { };

  constructor(private apiService: ApiService) { }

  createEmployee() {
    this.apiService.createEmployee(this.employee).subscribe({
      next: (response: any) => {
        console.log('New employee persisted: ', response);
      },
      error: (error: any) => {
        console.error('Error creating employee: ', error);
      }
    });
  }
}
