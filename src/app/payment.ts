// src/app/models/payment.model.ts

export class Payment {
    payId: number;
    billId: number;
    amount: number;
    paymentStatus: string;
    billNum:string;
    billUnits:number;

   
    constructor(payId: number, billId: number, amount: number, paymentStatus: string, billNum:string, billUnits:number) {
        this.payId = payId;
        this.billId = billId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.billNum=billNum;
        this.billUnits=billUnits
    }
}
