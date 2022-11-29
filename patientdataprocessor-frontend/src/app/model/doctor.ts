export class Doctor{
    constructor(

        public emailId: string,
        public password: string,
        public name: string,
        public dateOfBirth: Date,
        public specialization: string,
        public contactNumber: number

    ) {}
}