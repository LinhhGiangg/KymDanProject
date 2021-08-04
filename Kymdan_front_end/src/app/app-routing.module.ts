import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './component/config/home/home.component';
import {ViewProductTypeComponent} from './component/product/view-product-type/view-product-type.component';
import {LoginComponent} from './component/config/login/login.component';
import {RegisterComponent} from './component/config/register/register.component';
import {InformationComponent} from './component/individual/information/information.component';
import {BuyComponent} from './component/customer/buy/buy.component';
import {NoticePageComponent} from './component/config/notice-page/notice-page.component';
import {ProductTypeManagementComponent} from './component/product/product-type-management/product-type-management.component';
import {OrderProductComponent} from './component/shipper/order-product/order-product.component';
import {AddProductTypeComponent} from './component/product/add-product-type/add-product-type.component';
import {EditProductTypeComponent} from './component/product/edit-product-type/edit-product-type.component';
import {DeleteProductTypeComponent} from './component/product/delete-product-type/delete-product-type.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'view-product-type', component: ViewProductTypeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'information', component: InformationComponent},
  {path: 'buy', component: BuyComponent},
  {path: 'notice', component: NoticePageComponent},
  {path: 'product-type-management', component: ProductTypeManagementComponent},
  {path: 'order-product', component: OrderProductComponent},
  {path: 'add-product-type', component: AddProductTypeComponent},
  {path: 'edit-product-type', component: EditProductTypeComponent},
  {path: 'delete-product-type', component: DeleteProductTypeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule {
}
