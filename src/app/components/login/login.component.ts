import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Customer } from '../../customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  customer=new Customer(0," "," "," "," "," "," ");
  customer1:any;
  custId: any;

  constructor(private authService: AuthService, private router: Router) {}

  onLogin() {
    this.authService.login(this.customer).subscribe(
      
      (response) => {
        
        if(response!=null){
          console.log(response);
          alert('Login successful!');
          this.customer1=response;
          this.custId=this.customer1.customerId;
          console.log(this.custId);
          this.router.navigate(['home',this.custId]);
        }
        else{
          alert("login failed")
        }
       
        
        // Handle successful login (e.g., store token, navigate)
      },
      (error) => {
        alert('Login failed. Please check your credentials.');
      }
    );
  }

}
