import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../../api.service';

@Component({
  selector: 'app-get-employee',
  templateUrl: './get-employee.component.html',
  styleUrls: ['./get-employee.component.css']
})
export class GetEmployeeComponent implements OnInit{
  email: string = '';
  employee: any = { };
  error: string | null = null;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.employee = null;
  }

  getEmployee() {
    this.apiService.getEmployeeByEmail(this.email).subscribe(
      (response: any) => {
        this.employee = response;
        this.error = null;
      },
      (error: any) => {
        this.employee = null;
        this.error = 'Employee not found or an error occurred.';
      }
    )
  }
}
