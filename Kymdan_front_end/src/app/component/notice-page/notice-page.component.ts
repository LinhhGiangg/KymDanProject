import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-notice-page',
  templateUrl: './notice-page.component.html',
  styleUrls: ['./notice-page.component.css']
})
export class NoticePageComponent implements OnInit {
  private message;

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) {
  }

  ngOnInit(): void {
    this.message = this.data.message;
  }

}
