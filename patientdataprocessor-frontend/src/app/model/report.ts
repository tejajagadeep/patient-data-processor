export class Report {
    constructor(
        public id: number,
        public date: Date,
        public systolic: number,
        public diastolic: number,
        public sugarlevel: number,
        public sugarlevel2: number
    ) { }
}