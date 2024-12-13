import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bill } from '../bills';
import { Payment } from '../payment';

@Injectable({
  providedIn: 'root'
})
export class BillsService {

  private apiUrl = 'http://localhost:8090/api/bills';
  private apiUrl2 = 'http://localhost:8090/api/payments';

  constructor(private http: HttpClient) {}

  getBillsByCustomerId(customerId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}`);
  }
 addBill(bill:any,customerId:any)
 {
  return this.http.post(`${this.apiUrl}/create/${customerId}`,bill);
 }
 
 getBillById(billId: any): Observable<Bill> {
  return this.http.get<Bill>(`${this.apiUrl}/${billId}`);
}

// Update the bill and its payment status
updateBill(payment: Payment): Observable<Payment> {
  // Assuming the payment info is sent to update the bill's payment status
  return this.http.post<Payment>(`${this.apiUrl2}`, payment);
}
 
  
}
