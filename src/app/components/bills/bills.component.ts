import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { BillsService } from '../../services/bills.service';
import { Bill } from '../../bills';  // Import Bill interface

@Component({
  selector: 'app-bills',
  standalone: false,
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.css']
})
export class BillsComponent {
  customerBills: Bill[] = [];  // Array to store the customer's bills
  customerId: number | null = null;  // Store the customer ID for the logged-in user

  constructor(
    private authService: AuthService,  // AuthService to get logged-in customer
    private billsService: BillsService  // BillsService to fetch bills
  ) {}

  ngOnInit(): void {
    // Get the logged-in customer and fetch their bills
    this.authService.getLoggedInCustomer().subscribe((customer) => {
      this.customerId = customer.customerId;
      this.loadCustomerBills();  // Fetch bills for the logged-in customer
    });
  }

  loadCustomerBills(): void {
    // Fetch bills for the logged-in customer using the customer ID
    if (this.customerId !== null) {
      this.billsService.getBillsByCustomerId(this.customerId).subscribe(
        (bills: Bill[]) => {
          this.customerBills = bills;  // Set customer bills to the response data
        },
        (error) => {
          console.error('Error fetching bills:', error);
        }
      );
    }
  }
}
