export class Report {
    constructor(
        public id: number,
        public day: Date,
        public bpLevel1: number,
        public bpLevel2: number,
        public sugarLevel: number
    ) { }
}