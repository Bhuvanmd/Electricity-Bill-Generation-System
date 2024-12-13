import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { BillsService } from '../../services/bills.service';
import { Bill } from '../../bills';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-generatebill',
  standalone: false,
  templateUrl: './generatebill.component.html',
  styleUrl: './generatebill.component.css'
})
export class GeneratebillComponent implements OnInit {
  noofunits: number = 0;
  customerId: any;
  billData: { units: number; amount: number }[] = [];
  bill = new Bill(0, 0, " ", " ", 0, 0);
  bills: Bill[] = [];
  page: number = 1;  // Pagination page number

  constructor(private router: Router, private auth: AuthService, private activatedRoute: ActivatedRoute, private billsService: BillsService, private http: HttpClient) { }

  ngOnInit(): void {
    this.customerId = this.activatedRoute.snapshot.params['customerId'];
    this.billsService.getBillsByCustomerId(this.customerId).subscribe(
      (Response: any) => {
        console.log(Response);
        this.bills = Response;
      }
    )
    if (!this.customerId) {
      console.error('Customer ID is undefined!');
      this.router.navigate(['home']);
    }
  }

  generateBill() {
    this.router.navigate(['payment']);
  }

  generateAmount(): void {
    if (this.noofunits <= 0) {
      alert('Please enter a valid number of units!');
      return;
    } else {
      console.log(this.noofunits);
      const amount = this.calculateAmount(this.noofunits);
      this.bill.amount = amount;
      this.bill.customerId = this.customerId;
      this.bill.billUnits = this.noofunits;
      this.billsService.addBill(this.bill, this.customerId).subscribe(
        (Response: any) => {
          this.bill = Response;
        },
        (error: any) => {
          console.error('Error adding bill:', error);
        }
      )
      console.log(amount);
    }
  }

  calculateAmount(units: number): number {
    const ratePerUnit = 7;
    return units * ratePerUnit;
  }

  payBill(billId: any) {
    this.router.navigate(['payment', billId]);
  }

  logout(){
    this.router.navigate(['login'])
  }
   bg(){
    this.router.navigate(['generatebill'])
   }
  
   home(){
    this.router.navigate(['home'])
   }
   contact(){
    this.router.navigate(['login'])
   }
  
}
