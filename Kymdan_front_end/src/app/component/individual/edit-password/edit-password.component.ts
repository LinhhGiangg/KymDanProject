import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MatDialog, MatDialogRef} from '@angular/material/dialog';
import {ErrorStateMatcher} from '@angular/material/core';
import {Router} from '@angular/router';
import {LoginService} from '../../../service/login.service';
import {NoticePageComponent} from '../../config/notice-page/notice-page.component';

@Component({
  selector: 'app-edit-password-customer',
  templateUrl: './edit-password.component.html',
  styleUrls: ['./edit-password.component.css']
})
export class EditPasswordComponent implements OnInit {
  public username;
  public message;
  public editForm: FormGroup;

  public matcher = new ErrorStateMatcher();

  constructor(
    public dialogRef: MatDialogRef<EditPasswordComponent>,
    public formBuilder: FormBuilder,
    public el: ElementRef,
    public router: Router,
    public loginService: LoginService,
    public dialog: MatDialog,
  ) {
  }

  ngOnInit() {
    this.username = this.loginService.currentUserValue.username;
    this.editForm = this.formBuilder.group({
      oldPassword: ['', [Validators.required]],
      newPassword: ['', [Validators.required]],
      confirmPassword: ['', [Validators.required]],
    }, {validator: this.ConfirmedValidator('newPassword', 'confirmPassword')});
  }

  ConfirmedValidator(controlName: string, matchingControlName: string) {
    return (formGroup: FormGroup) => {
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];
      if (matchingControl.errors && !matchingControl.errors.confirmedValidator) {
        return;
      }
      if (control.value !== matchingControl.value) {
        matchingControl.setErrors({confirmedValidator: true});
      } else {
        matchingControl.setErrors(null);
      }
    };
  }

  edit() {
    if (this.editForm.valid) {
      this.loginService.editPassword(this.username, this.editForm.value.oldPassword, this.editForm.value.newPassword)
        .subscribe(data => {
          this.message = data.message;
          const dialogRefNotice = this.dialog.open(NoticePageComponent, {
            width: '555px',
            height: '180px',
            data: {message: this.message},
            disableClose: true
          });

          dialogRefNotice.afterClosed().subscribe(() => {
            this.router.navigate(['/information', {message: ''}]).then(() => {
            });
            this.dialogRef.close()
          })
        });
    } else {
      for (const key of Object.keys(this.editForm.controls)) {
        if (this.editForm.controls[key].invalid) {
          const invalidControl = this.el.nativeElement.querySelector('[formControlName="' + key + '"]');
          invalidControl.focus();
          break;
        }
      }
    }
  }
}
