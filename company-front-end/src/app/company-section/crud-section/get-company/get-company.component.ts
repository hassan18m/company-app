import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/api.service';

@Component({
  selector: 'app-get-company',
  templateUrl: './get-company.component.html',
  styleUrls: ['./get-company.component.css']
})
export class GetCompanyComponent implements OnInit{
  company: any = { };
  id: string = '';
  error: string | null = null;

  constructor(private apiService: ApiService) { };

  ngOnInit(): void {
    this.company = null;
  }

  getCompany() {
    this.apiService.getCompanyById(this.id).subscribe({
      next: (response: any) => {
        this.company = response;
        this.error = null;
      },
      error: (error: any) => {
        this.company = null;
        this.error = 'Company not found or an error occured';
      }
    });
  }
}
