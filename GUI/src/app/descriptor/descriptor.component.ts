import { Component, OnInit } from '@angular/core';
import { DescriptorService } from "../descriptor.service";

@Component({
  selector: 'app-descriptor',
  templateUrl: './descriptor.component.html',
  styleUrls: ['./descriptor.component.scss']
})
export class DescriptorComponent implements OnInit {
  descriptors: any[] = [];
  newDescriptorName: string = '';
  newDescriptorValue: string = '';

  constructor(private descriptorService: DescriptorService) {
  }

  ngOnInit(): void {
    this.showDescriptors();
  }

  showDescriptors(): void {
    this.descriptorService.fetchData().subscribe(data => {
      this.descriptors = data;
      console.log(this.descriptors)
    });
  }

  addNewDescriptor(): void {
    this.descriptorService.sendDataToBackend(this.newDescriptorName, this.newDescriptorValue)
      .subscribe(data => {
        this.showDescriptors();
      })
  }
}
