export class Report {
    constructor(
        public id: number,
        public contactNumber: number,
        public date: DateConstructor,
        public systolic: number,
        public diastolic: number,
        public sugarlevel: number,
        public sugarlevel2: number
    ) { }
}