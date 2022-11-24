import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthService } from 'src/app/service/auth.service';

@Injectable()
export class AuthIntercepter implements HttpInterceptor{
    constructor(private authService : AuthService){
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        let newReq = req;
        let authToken = this.authService.getToken();
        console.log("Intercepter", authToken);
        if(authToken!=null)
        {
            newReq=newReq.clone({setHeaders:{Authorization:`Bearer ${authToken}`}});
            
        }
        //console.log(newReq.headers);
        return next.handle(newReq);
    }
    
}