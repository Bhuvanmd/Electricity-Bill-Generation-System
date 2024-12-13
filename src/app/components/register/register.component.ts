import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { Customer } from '../../customer';
import { Router } from '@angular/router';
@Component({
  selector: 'app-register',   
  standalone: false,
  
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
 customer = new Customer(0,"","","","","","");
  password: string = '';
  

  constructor(private authService: AuthService, private router:Router) {}

  onSignup() {
    
   
    this.authService.signup(this.customer).subscribe(
      (response:any) => {
        
        alert('Registration successful!');
        
        // Redirect to login or other page
        this.router.navigate(['login']);
      },
      
      (error:any) => {
        alert('Registration failed. Please try again.');
      }
    );
    
  }
  


}
