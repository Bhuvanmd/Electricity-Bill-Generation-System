import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: false,
  
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit{
  isLoggedIn: boolean = false;
  customerList:any;
  customerId:any;
  customer:any;
  constructor(
    private authService: AuthService,
    private router: Router,private activatedRoute:ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isLoggedIn();
this.customerId=this.activatedRoute.snapshot.params['custId'];
    this.authService.getAllCustomers().subscribe(
      (Response:any)=>{
        this.customerList=Response;
      }
    );
    this.authService.getCustomerById(this.customerId).subscribe(
      (Response:any)=>{
this.customer=Response;
      }
    )
  }

  generateBill(customerId:any){
    this.router.navigate(['generatebill',customerId]);

    
  }
  logout(){
    this.router.navigate(['login'])
  }
   bg(customerId:any){
    this.router.navigate(['generatebill', customerId])
   }
  
   home(customerId:any){
    this.router.navigate(['home', customerId])
   }
   contact(){
    this.router.navigate(['login'])
   }


  
}


