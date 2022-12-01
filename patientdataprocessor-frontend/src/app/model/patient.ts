import { Report } from "./report";

export class Patient{
    constructor(
    
    public contactNumber: number,
	
	public address: string,
	
	public firstName: string,
	
	public lastName: string,
	
	public gender: string,
	
	public dateOfBirth: Date,
	
	public maritalStatus: string,
	
//	public additioanlNote,
	
	public emergencyContactNumber: number,
	
	public email: string,
	
	public bloodGroup: string,
	
	public diagnosis: string,

	public disease: string,
	
	public dateVisited: Date,
	
	public treatmentStartDate: Date,
	
	public treatmentEndDate: Date,
	
	public prescription: string,
	
	public height: string,
	
	public weight: string,

    public reports: Report[]
    ) {}
}