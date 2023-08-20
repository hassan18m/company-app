import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  getEmployeeByEmail(email: string) {
    return this.http.get(`${this.apiUrl}/employee?email=${email}`);
  }

  createEmployee(employeeData: any) {
    console.log('Employee data before POST request:', employeeData);
    return this.http.post(`${this.apiUrl}/employee`, employeeData);
  }
}
