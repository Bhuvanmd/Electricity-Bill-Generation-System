import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = "http://localhost:8090/api/customers"; // Replace with your backend's actual URL
  private baseUrl2 = "http://localhost:8090/api/customers/";

  constructor(private http: HttpClient) {}

  /**
   * Login method to authenticate the user
   * @param email - The user's email
   * @param password - The user's password
   * @returns Observable of the HTTP POST request
   */
  login(customer:any) {
 
    return this.http.post(`${this.baseUrl}/signin`, customer);
  }

  /**
   * Signup method to register a new user
   * @param customer - Object containing user registration details
   * @returns Observable of the HTTP POST request
   */
  signup(customer: any) {
    return this.http.post(`${this.baseUrl}/signup`, customer);
  }

  getLoggedInCustomer(): Observable<any> {
    return this.http.get<any>(this.baseUrl);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('authToken');  // Check if user has an auth token stored
  }

  getAllCustomers(){
    return this.http.get(`${this.baseUrl2}`);
  }
  getCustomerById(customerId:any)
  {
    return this.http.get(`${this.baseUrl2}${customerId}`);
  }

  
  
}
