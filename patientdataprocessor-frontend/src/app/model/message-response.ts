import { HttpStatusCode } from "@angular/common/http";

export class MessageResponse {
    //   [x: string]: any;
    //     private timeStamp!: Date ;
    //         private message!:string 
    //         private status!: HttpStatusCode
    constructor(
        public timeStamp: Date,
        public message: string,
        public status: HttpStatusCode
    ) {
        //     this.timeStamp = timeStamp,
        //    this.message = message,
        //    this.status = status
    }
}