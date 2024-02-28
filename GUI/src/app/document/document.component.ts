import { Component, OnInit } from '@angular/core';
import { DocumentService } from "../document.service";

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.scss']
})
export class DocumentComponent implements OnInit {
  documents: any[] = [];

  constructor(private documentService: DocumentService) {}

  ngOnInit(): void {
    this.showDocuments();
  }

  showDocuments(): void {
    this.documentService.fetchData().subscribe(data => {
      this.documents = data;
      console.log('documents')
      console.log(this.documents)
    });
  }
}
