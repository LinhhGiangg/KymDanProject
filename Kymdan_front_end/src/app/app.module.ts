import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MaterialModule} from './material.module';
import {HttpClientModule} from '@angular/common/http';
import {NavBarComponent} from './component/nav-bar/nav-bar.component';
import {FooterComponent} from './component/footer/footer.component';
import {HomeComponent} from './component/home/home.component';
import {ProductComponent} from './component/product/product.component';
import {LoginComponent} from './component/login/login.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatDialogModule} from '@angular/material/dialog';
import {MatButtonModule} from '@angular/material/button';
import {RegisterComponent} from './component/register/register.component';
import {InformationComponent} from './component/information/information.component';
import {EditPasswordComponent} from './component/edit-password/edit-password.component';
import {BuyComponent} from './component/buy/buy.component';
import {NoticePageComponent} from './component/notice-page/notice-page.component';
import {ProductManagementComponent} from './component/product-management/product-management.component';
import {OrderProductComponent} from './component/order-product/order-product.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    FooterComponent,
    HomeComponent,
    ProductComponent,
    LoginComponent,
    RegisterComponent,
    InformationComponent,
    EditPasswordComponent,
    BuyComponent,
    NoticePageComponent,
    ProductManagementComponent,
    OrderProductComponent
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
