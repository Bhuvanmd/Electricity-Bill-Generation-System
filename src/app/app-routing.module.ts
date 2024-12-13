import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { BillsComponent } from './components/bills/bills.component';
import { HomeComponent } from './components/home/home.component';
import { generate } from 'rxjs';
import { GeneratebillComponent } from './components/generatebill/generatebill.component';
import { PaymentComponent } from './components/payment/payment.component';



const routes: Routes = [
  {
    path:"", component:LoginComponent
  },
  {
    path:"login", component:LoginComponent
  },
  {
    path:"register", component:RegisterComponent
  },
  {
    path:"bills", component:BillsComponent
  },
  {
    path:"home/:custId", component:HomeComponent
  },
  {
    path:"generatebill/:customerId", component:GeneratebillComponent
  },
  {
    path:"payment/:billId", component:PaymentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
