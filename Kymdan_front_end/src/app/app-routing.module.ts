import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './component/home/home.component';
import {ProductTypeComponent} from './component/product-type/product-type.component';
import {LoginComponent} from './component/login/login.component';
import {RegisterComponent} from './component/register/register.component';
import {InformationComponent} from './component/information/information.component';
import {BuyComponent} from './component/buy/buy.component';
import {NoticePageComponent} from './component/notice-page/notice-page.component';
import {ProductTypeManagementComponent} from './component/product-type-management/product-type-management.component';
import {OrderProductComponent} from './component/order-product/order-product.component';
import {AddProductTypeComponent} from './component/add-product-type/add-product-type.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'product-type', component: ProductTypeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'information', component: InformationComponent},
  {path: 'buy', component: BuyComponent},
  {path: 'notice', component: NoticePageComponent},
  {path: 'product-type-management', component: ProductTypeManagementComponent},
  {path: 'order-product', component: OrderProductComponent},
  {path: 'add-product-type', component: AddProductTypeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
