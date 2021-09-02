import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-thong-ke',
  templateUrl: './thong-ke.component.html',
  styleUrls: ['./thong-ke.component.css']
})
export class ThongKeComponent implements OnInit {
  public duLieu: number[] = [181, 222, 135, 101, 76];

  public thang: string[] = ['Tháng 5', 'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9'];

  constructor() {
  }

  ngOnInit(): void {
  }

}
