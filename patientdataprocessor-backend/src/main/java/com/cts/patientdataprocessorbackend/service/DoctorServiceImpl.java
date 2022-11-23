package com.cts.patientdataprocessorbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.patientdataprocessorbackend.model.Doctor;
import com.cts.patientdataprocessorbackend.model.User;
import com.cts.patientdataprocessorbackend.repository.DoctorRespository;
import com.cts.patientdataprocessorbackend.repository.UserRepository;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	DoctorRespository doctorRespository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
		String encryptedPassword = passwordEncoder.encode(doctor.getPassword());
		doctor.setPassword(encryptedPassword);
		User user = new User();
		user.setUserName(doctor.getEmailId());
		user.setPassword(encryptedPassword);
		user.setRole("DOCTOR");
		userRepository.save(user);
		return doctorRespository.save(doctor);
	}


}
