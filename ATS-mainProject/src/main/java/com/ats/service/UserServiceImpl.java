
package com.ats.service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.mail.internet.AddressException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ats.command.ChangePasswordCommand;
import com.ats.command.LoginCmd;
import com.ats.command.UserDetails;
import com.ats.domain.VehicleDetailsEntity;
import com.ats.domain.VehicleInfo;
import com.ats.entity.UserDetailsEntity; 
import com.ats.generator.TempPwdGenerator;
import com.ats.repository.UserRepository;
 
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	JavaMailSender mailSender;
	

	@Override
	public String saveUserRegDetails(UserDetails user) {

		UserDetailsEntity userEntity = new UserDetailsEntity();
		BeanUtils.copyProperties(user, userEntity);
		String tempPwd = TempPwdGenerator.generateTempPwd();
		userEntity.setPassword(tempPwd);

		UserDetailsEntity entity = userRepo.save(userEntity);

			sendMail(entity);
	
	
		return "check your email";
	}

	@Override
	public String insertNewPwd(ChangePasswordCommand pwdCmd) {
		UserDetailsEntity exists = userRepo.exists(pwdCmd.getTemail(), pwdCmd.getTempPwd());
		if (null != exists) {
			exists.setPassword(pwdCmd.getNewPwd());
			exists.setAccStatus("unlock");
			userRepo.save(exists);
			return "password changed";
		} else {
			return "invalid email and pwd";
		}
	}
 
	@Override
	public String checkCredential(LoginCmd loginCre) {
		UserDetailsEntity exists = userRepo.exists(loginCre.getUname(), loginCre.getPwd());
		String msg;
		if (null != exists) {
			if ("unlock".equals(exists.getAccStatus())) {
				if("active".equals(exists.getActiveSwitch())) {
					msg = exists.getRole();
				}
				else {
					msg = "inactive";
				}
			}
			else {
				msg = "lock";
			}
		}
		else {
			msg = "invalid";
		}
		
		return msg;
	}

	@Override
	public String getEntityByEmail(String validEmail) {
		UserDetailsEntity checkEmail = userRepo.checkEmail(validEmail);
				sendMailForgotPwd(checkEmail);
		return "checkMail";
	}
	
	@Override
	public String insertAdminForm(UserDetailsEntity userEntity) {
		UserDetailsEntity entity = userRepo.save(userEntity);
		sendMail(entity);
		return "check Mail";
	}

	
	@Override
	public List<UserDetailsEntity> findAllRecords() {
		List<UserDetailsEntity> records = userRepo.findAll();
		return records;
	}

	public void sendMail(UserDetailsEntity entity){
		SimpleMailMessage msg = new SimpleMailMessage();
		String email = entity.getEmail();
		String fname = entity.getFname();
		String lname = entity.getLname();
		String tempPwd = entity.getPassword();
		msg.setTo(email);
		msg.setSubject("ATS-Account Registration");
		String line1 = "Hi " + fname + " " + lname
				+ ", welcome to ATS. your registration is almost completed. please unlock your account using below details.";
		String line2 = "Temp Password ::" + tempPwd;
		String line3 = "http://localhost:9090/user/changePwd?email=" + email;

		msg.setText(line1 + "\n" + line2 + "\n" + line3);
		mailSender.send(msg);
	}
	
	public void sendMailForgotPwd(UserDetailsEntity entity){
		SimpleMailMessage msg = new SimpleMailMessage();
		String email = entity.getEmail();
		String fname = entity.getFname();
		String lname = entity.getLname();
		String pwd = entity.getPassword();
		msg.setTo(email);
		msg.setSubject("ATS-Account Registration");
		String line1 = "Hi " + fname + " " + lname
				+ ", welcome to ATS. your password is given below.";
		String line2 = "Password is ::" + pwd;
		String line3 = "http://localhost:9090/home";

		msg.setText(line1 + "\n" + line2 + "\n" + line3);
		mailSender.send(msg);
	}

}
