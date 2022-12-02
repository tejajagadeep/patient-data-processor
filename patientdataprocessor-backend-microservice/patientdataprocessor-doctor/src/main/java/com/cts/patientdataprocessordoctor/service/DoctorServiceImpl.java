package com.cts.patientdataprocessordoctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessordoctor.model.Doctor;
import com.cts.patientdataprocessordoctor.repository.DoctorRespository;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorRespository doctorRespository;
	
//	@Autowired
//	UserRepository userRepository;
	
//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	@Override
	public List<Doctor> retrieveAllDoctorDetails() {
		return doctorRespository.findAll();
	}


	@Override
	public Doctor retrieveDoctorDetailsById(String emailId) {
		return doctorRespository.findByEmailId(emailId);
	}
	
	@Override
	public Doctor doctorRegistration(Doctor doctor) {
//		String encryptedPassword = passwordEncoder.encode(doctor.getPassword());
//		doctor.setPassword(encryptedPassword);
//		User user = new User();
//		user.setUserName(doctor.getEmailId());
//		user.setPassword(encryptedPassword);
//		user.setRole("DOCTOR");
//		userRepository.save(user);
		return doctorRespository.save(doctor);
	}


}

