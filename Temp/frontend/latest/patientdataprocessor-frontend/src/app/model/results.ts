export class Results {
    constructor(
        public id: number,
        public contactNumber: number,

        public whiteBloodCells: number,

        public redBloodCells: number,

        public hemoglobin: number,

        public hemotocrit: number,

        public meanCellVolume: number,

        public meanCellHemoglobin: number,

        public platelets: number,

        public reticulocyte: number,

        public date: DateConstructor
    ) { }
}