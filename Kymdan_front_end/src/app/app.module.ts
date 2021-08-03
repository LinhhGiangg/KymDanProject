import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './material.module';
import {HttpClientModule} from '@angular/common/http';
import {NavBarComponent} from './component/config/nav-bar/nav-bar.component';
import {FooterComponent} from './component/config/footer/footer.component';
import {HomeComponent} from './component/config/home/home.component';
import {ViewProductTypeComponent} from './component/product/view-product-type/view-product-type.component';
import {LoginComponent} from './component/config/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {RegisterComponent} from './component/config/register/register.component';
import {InformationComponent} from './component/individual/information/information.component';
import {EditPasswordComponent} from './component/individual/edit-password/edit-password.component';
import {BuyComponent} from './component/customer/buy/buy.component';
import {NoticePageComponent} from './component/config/notice-page/notice-page.component';
import {ProductTypeManagementComponent} from './component/product/product-type-management/product-type-management.component';
import {OrderProductComponent} from './component/shipper/order-product/order-product.component';
import {AddProductTypeComponent} from './component/product/add-product-type/add-product-type.component';
import {EditProductTypeComponent} from './component/product/edit-product-type/edit-product-type.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    HomeComponent,
    ViewProductTypeComponent,
    LoginComponent,
    RegisterComponent,
    InformationComponent,
    EditPasswordComponent,
    BuyComponent,
    NoticePageComponent,
    ProductTypeManagementComponent,
    OrderProductComponent,
    AddProductTypeComponent,
    EditProductTypeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDialogModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
