export class Doctor{
    constructor(

        public emailId: string,
        public password: string,
        public firstName: string,
        public lastName: string,
        public dateOfBirth: Date,
        public gender: string,
        public address: string,
        public contactNumber: number

    ) {}
}