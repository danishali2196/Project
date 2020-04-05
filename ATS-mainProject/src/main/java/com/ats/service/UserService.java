package com.ats.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.command.ChangePasswordCommand;
import com.ats.command.LoginCmd;
import com.ats.command.UserDetails;
import com.ats.domain.VehicleInfo;
import com.ats.entity.UserDetailsEntity;

@Service
public interface UserService {
	
	public String saveUserRegDetails(UserDetails user);
	public String insertNewPwd(ChangePasswordCommand pwdCmd);
	public String checkCredential(LoginCmd loginCre);
	public String getEntityByEmail(String validEmail);
	
	public String insertAdminForm(UserDetailsEntity userEntity);
	public List<UserDetailsEntity> findAllRecords();
	
	
}
