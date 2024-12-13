import { Injectable } from '@angular/core';
import { jsPDF } from 'jspdf';
import autoTable from 'jspdf-autotable';

@Injectable({
  providedIn: 'root',
})
export class PdfService {
  generatePdf(billList: any[]) {
    const doc = new jsPDF();

    // Title
    doc.setFontSize(18);
    doc.text('Electricity Bill Summary', 14, 20);

    // Table Headers
    const headers = [['Bill ID', 'Customer ID', 'Bill Number', 'Description', 'Units', 'Amount (₹)']];

    // Table Data
    const data = billList.map(bill => [
      bill.BillId,
      bill.BillCustId,
      bill.BillNum,
      bill.BillDesc,
      bill.BillUnits,
      bill.BillAmount,
    ]);

    // Add Table
    autoTable(doc, {
      head: headers,
      body: data,
      startY: 30,
      theme: 'striped',
    });

    // Save PDF
    doc.save('Electricity_Bill_Summary.pdf');
  }
}
