import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable, Subject} from 'rxjs';
import {map} from 'rxjs/operators';
import {AppAccount} from '../model/AppAccount';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  readonly API = 'http://localhost:8080/login';

  name: Subject<string> = new Subject();
  public currentUserSubject: BehaviorSubject<AppAccount>;
  public currentUser: Observable<AppAccount>;
  parsingUser;

  broadcastLoginChange(text: string) {
    this.name.next(text);
  }

  constructor(public http: HttpClient) {
    this.parsingUser = JSON.parse(localStorage.getItem('currentUser'));
    this.currentUserSubject = new BehaviorSubject<AppAccount>(this.parsingUser);
    this.currentUser = this.currentUserSubject.asObservable();
  }

  public get currentUserValue(): AppAccount {
    return this.currentUserSubject.value;
  }

  authenticate(account): Observable<any> {
    return this.http.post<any>(this.API + '/authenticate', account)
      .pipe(map(user => {
        // store user details in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
        localStorage.setItem('token', user.token);
        this.currentUserSubject.next(user);
        return user;
      }));
  }

  logout() {
    // remove user from local storage and set current user to null
    localStorage.removeItem('currentUser');
    localStorage.removeItem('token');
    this.currentUserSubject.next(null);
  }

  getInformation(name, role): Observable<any> {
    return this.http.get(this.API + '/information/' + name + '/' + role);
  }

  editInformation(newInformation): Observable<any> {
    return this.http.post(this.API + '/edit-information', newInformation, {headers: {skip: 'true'}});
  }

  editPassword(username, oldPassword, newPassword): Observable<any> {
    return this.http.get(this.API + '/edit-password/' + username + '/' + oldPassword + '/' + newPassword);
  }
}
