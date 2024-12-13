import { Customer } from "./customer";

export class Bill {
    billId: number;
    customerId:number;
    billNum: string;
    billDesc: string;
    billUnits:number;
    amount: number;
    
  
    // Constructor to initialize the properties
    constructor(
      billId: number,
      customerId: number,
      billNum: string,
      billDesc: string,
      billUnits:number,
      amount: number
      
    ) {
      this.billId = billId;
      this.customerId = customerId;
      this.billNum = billNum;
      this.billDesc = billDesc;
     this.billUnits=billUnits;
      this.amount = amount;
      
    }
  }
  