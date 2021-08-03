import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {LoginService} from '../../../service/login.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public loginForm: FormGroup;
  public user;
  public message;

  constructor(
    public formBuilder: FormBuilder,
    public loginService: LoginService,
    public router: Router,
    public el: ElementRef,
    public activatedRouter: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.activatedRouter.params.subscribe(data => {
      this.message = data.message;
    });

    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      this.user = {
        username: this.loginForm.value.email,
        password: this.loginForm.value.password
      };
      this.loginService.authenticate(this.user)
        .subscribe(data => {
          if (data.message) {
            this.message = data.message;
            this.loginService.logout();
          } else {
            this.user = data;
            this.loginService.broadcastLoginChange(this.user);
            if (this.user.role === 'Customer') {
              this.router.navigateByUrl('');
            } else if (this.user.role === 'Employee') {
              this.router.navigateByUrl('/product-type-management');
            } else if (this.user.role === 'Shipper') {
              this.router.navigateByUrl('/order-product');
            }
          }
        }, error => {
          this.message = 'Sai email hoặc password';
        });
    } else {
      for (const key of Object.keys(this.loginForm.controls)) {
        if (this.loginForm.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formControlName="' + key + '"]');
          invalidControl.focus();
          break;
        }
      }
    }
  }
}