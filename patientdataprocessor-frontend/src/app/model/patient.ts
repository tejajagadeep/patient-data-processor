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
	
	public Disease: string,
	
	public dateVisited: Date,
	
	public treatmentStartDate: Date,
	
	public treatmentEndDate: Date,
	
	public prescription: string,
	
	public reports: string,
	
	public height: string,
	
	public weight: string
    ) {}
}