package com.ats.command;

import lombok.Data;

@Data
public class ChangePasswordCommand {

	private String temail;
	private String tempPwd;
	private String newPwd;
}
