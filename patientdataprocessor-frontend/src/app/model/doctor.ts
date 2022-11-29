export class Doctor{
    constructor(

        public emailId: string,
        public password: string,
        public firstName: string,
        public lastName: string,
        public dateOfBirth: Date,
        public gender: string,
        public specialization: string,
        public contactNumber: number

    ) {}
}