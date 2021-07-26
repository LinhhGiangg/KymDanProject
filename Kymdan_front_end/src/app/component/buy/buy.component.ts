import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/Product';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {
  private productID;
  private product = new Product();

  constructor(
    private activedRouter: ActivatedRoute,
    protected productService: ProductService,
    public router: Router,
  ) { }

  ngOnInit(): void {
    this.activedRouter.params.subscribe(data => {
      this.productID = data.productID;
    });

    this.productService.findProductByID(this.productID).subscribe(
      (data) => {
        this.product = data;
      },
      () => {
      },
      () => {
      });
  }

}
