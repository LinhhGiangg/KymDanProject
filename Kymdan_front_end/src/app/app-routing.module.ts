import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {ProductComponent} from './component/product/product.component';
import {LoginComponent} from './component/login/login.component';
import {RegisterComponent} from './component/register/register.component';
import {InformationComponent} from './component/information/information.component';
import {BuyComponent} from './component/buy/buy.component';
import {NoticePageComponent} from './component/notice-page/notice-page.component';
import {ProductManagementComponent} from './component/product-management/product-management.component';
import {OrderProductComponent} from './component/order-product/order-product.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'product', component: ProductComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'information', component: InformationComponent},
  {path: 'buy', component: BuyComponent},
  {path: 'notice', component: NoticePageComponent},
  {path: 'product-management', component: ProductManagementComponent},
  {path: 'order-product', component: OrderProductComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
