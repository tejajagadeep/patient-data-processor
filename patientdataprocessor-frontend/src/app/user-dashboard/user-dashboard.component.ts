import { Component, OnInit } from '@angular/core';
import{Router} from '@angular/router';
import {FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms'
import { Patient } from '../model/patient';
import { PatientDataService } from '../service/data/patient-data.service';


@Component({
  selector: 'app-hospital-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})

export class UserDashboardComponent implements OnInit {
  
  hospitalDetail !: FormGroup;
  hospitalObj !: Patient
  hospitalList!:Patient[];
  patients!: Patient[]
 
  
  searchText:string='';
  
  
  
  constructor(
    private formBuilder : FormBuilder,
    // private hospitalService: HospitalService,
    private patientService: PatientDataService,
    private route : Router) {}

  

  ngOnInit(): void {
    this.patientGetAll()
    this.getAllHospital();
    console.log(this.hospitalList)
    console.log(this.getAllHospital())


    this.hospitalDetail = this.formBuilder.group(
      { 
        // id:[''],
        contactNumber:[''],
        address:[''],
        firstName:[''],
        lastName:[''],
        gender:[''],
        dateOfBirth:[''],
        maritalStatus:[''],
        emergencyContactNumber:[''],
        email:[''],
        bloodGroup:[''],
        disease:[''],
        dateVisited:[''],
        treatmentStartDate:[''],
        treatementEndDate:[''],
        prescription:[''],
        reports:[''],
        height:[''],
        weight:['']
       

      }
    );

   

  }

  get f(){
    return this.hospitalDetail.controls;
  }
  logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    this.route.navigate(['/']);
  }

  addHospital(){

    console.log(this.hospitalDetail);
    // this.hospitalObj.id=this.hospitalDetail.value.id;
    this.hospitalObj.contactNumber=this.hospitalDetail.value.contactNumber;
    this.hospitalObj.address=this.hospitalDetail.value.address;
    this.hospitalObj.firstName=this.hospitalDetail.value.firstName;
    this.hospitalObj.lastName=this.hospitalDetail.value.lastName;
    this.hospitalObj.gender=this.hospitalDetail.value.gender;
    this.hospitalObj.dateOfBirth=this.hospitalDetail.value.dateOfBirth;
    this.hospitalObj.maritalStatus=this.hospitalDetail.value.maritalStatus;
    this.hospitalObj.emergencyContactNumber=this.hospitalDetail.value.emergencyContactNumber;
    this.hospitalObj.email=this.hospitalDetail.value.email;
    this.hospitalObj.bloodGroup=this.hospitalDetail.value.bloodGroup;
    this.hospitalObj.disease=this.hospitalDetail.value.disease;
    this.hospitalObj.dateVisited=this.hospitalDetail.value.dateVisited;
    this.hospitalObj.treatmentStartDate=this.hospitalDetail.value.treatmentStartDate;
    this.hospitalObj.treatmentEndDate=this.hospitalDetail.value.treatmentEndDate;
    this.hospitalObj.prescription=this.hospitalDetail.value.prescription;
    this.hospitalObj.reports=this.hospitalDetail.value.reports;
    this.hospitalObj.height=this.hospitalDetail.value.height;
    this.hospitalObj.weight=this.hospitalDetail.value.weight;
    
   

    this.patientService.registerPatient(this.hospitalObj).subscribe(res=>{
      console.log(res);
     
      this.getAllHospital();
    },err=>{

      console.log(err);

    });

    


  }

  

  getAllHospital(){
    this.patientService.getAllPatient().subscribe(res=>{
      this.hospitalList=res;
    },err=>{

      console.log("error while fetching the data..")
      
    });

  }

  editHospital(hospital: Patient){
    // this.hospitalDetail.controls['id'].setValue(hospital.id);
    this.hospitalDetail.controls['contactNumber'].setValue(hospital.contactNumber);
    this.hospitalDetail.controls['address'].setValue(hospital.address);
    this.hospitalDetail.controls['firstName'].setValue(hospital.firstName);
    this.hospitalDetail.controls['lastName'].setValue(hospital.lastName);
    this.hospitalDetail.controls['gender'].setValue(hospital.gender);
    this.hospitalDetail.controls['dateOfBirth'].setValue(hospital.dateOfBirth);
    this.hospitalDetail.controls['maritalStatus'].setValue(hospital.maritalStatus);
    this.hospitalDetail.controls['emergencyContactNumber'].setValue(hospital.emergencyContactNumber);
    this.hospitalDetail.controls['email'].setValue(hospital.email);
    this.hospitalDetail.controls['bloodGroup'].setValue(hospital.bloodGroup);
    this.hospitalDetail.controls['disease'].setValue(hospital.disease);
    this.hospitalDetail.controls['dateVisited'].setValue(hospital.dateVisited);
    this.hospitalDetail.controls['treatmentStartDate'].setValue(hospital.treatmentStartDate);
    this.hospitalDetail.controls['treatmentEndDate'].setValue(hospital.treatmentEndDate);
    this.hospitalDetail.controls['prescription'].setValue(hospital.prescription);
    this.hospitalDetail.controls['reports'].setValue(hospital.reports);
    this.hospitalDetail.controls['height'].setValue(hospital.height);
    this.hospitalDetail.controls['weight'].setValue(hospital.weight);
   
    

  }

  updateHospital() {

    // this.hospitalObj.id = this.hospitalDetail.value.id;
    this.hospitalObj.contactNumber = this.hospitalDetail.value.contactNumber;
    this.hospitalObj.address = this.hospitalDetail.value.address;
    this.hospitalObj.firstName = this.hospitalDetail.value.firstName;
    this.hospitalObj.lastName = this.hospitalDetail.value.lastName;
    this.hospitalObj.gender = this.hospitalDetail.value.gender;
    this.hospitalObj.dateOfBirth = this.hospitalDetail.value.dateOfBirth;
    this.hospitalObj.maritalStatus=this.hospitalDetail.value.maritalStatus;
    this.hospitalObj.emergencyContactNumber = this.hospitalDetail.value.emergencyContactNumber;
    this.hospitalObj.email = this.hospitalDetail.value.email;
    this.hospitalObj.bloodGroup = this.hospitalDetail.value.bloodGroup;
    this.hospitalObj.disease=this.hospitalDetail.value.disease;
    this.hospitalObj.dateVisited= this.hospitalDetail.value.dateVisited;
    this.hospitalObj.treatmentStartDate = this.hospitalDetail.value.treatmentStartDate;
    this.hospitalObj.treatmentEndDate = this.hospitalDetail.value.treatmentEndDate;
    this.hospitalObj.prescription=this.hospitalDetail.value.prescription;
    this.hospitalObj.reports = this.hospitalDetail.value.reports;
    this.hospitalObj.height= this.hospitalDetail.value.height;
    this.hospitalObj.weight=this.hospitalDetail.value.weight;
   
    

    this.patientService.updatePatientDetails(this.hospitalObj.contactNumber,this.hospitalObj).subscribe(res=>{
      console.log(res);
     
      this.getAllHospital();
    },err=>{
      console.log(err);
    })

  }

  deleteHospital(contactNumber: number) {

    this.patientService.deletePatient(contactNumber).subscribe(res=>{
      console.log(res);
     
      this.getAllHospital();
    },err => {
      console.log(err);
    });

  }
 
 
  
 
  onViewHospital(hospital:Patient){
    // this.hospitalObj.id = hospital.id;
    this.hospitalObj.contactNumber = hospital.contactNumber;
    this.hospitalObj.address = hospital.address;
    this.hospitalObj.firstName = hospital.firstName;
    this.hospitalObj.lastName = hospital.lastName;
    this.hospitalObj.gender = hospital.gender;
    this.hospitalObj.dateOfBirth = hospital.dateOfBirth;
    this.hospitalObj.maritalStatus= hospital.maritalStatus;
    this.hospitalObj.emergencyContactNumber=hospital.emergencyContactNumber;
    this.hospitalObj.email=hospital.email;
    this.hospitalObj.bloodGroup=hospital.bloodGroup;
    this.hospitalObj.disease=hospital.disease;
    this.hospitalObj.dateVisited=hospital.dateVisited;
    this.hospitalObj.treatmentStartDate=hospital.treatmentStartDate;
    this.hospitalObj.treatmentEndDate=hospital.treatmentEndDate;
    this.hospitalObj.prescription=hospital.prescription;
    this.hospitalObj.reports=hospital.reports;
    this.hospitalObj.height=hospital.height;
    this.hospitalObj.weight=hospital.weight;

  }
 
  patientGetAll(){
    this.patientService.getAllPatient().subscribe(
      response=> {this.patients=response,
    console.log(response)

      }
      
    )
  }

}
