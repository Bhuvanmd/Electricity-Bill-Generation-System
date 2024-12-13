export class Customer {
    customerId: number;
    customerName: string;
    address: string;
    contactNo: string;
    email: string;
    meterNo: string;
    password:string;
  
    constructor(
      customerId: number,
      customerName: string,
      address: string,
      contactNo: string,
      email: string,
      meterNo: string,
      password:string
    ) {
      this.customerId = customerId;
      this.customerName = customerName;
      this.address = address;
      this.contactNo = contactNo;
      this.email=email;
      this.meterNo=meterNo;
      this.password=password;
      
  

}
}