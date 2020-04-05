package com.ats.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


import lombok.Data;
 
@XmlRootElement(name="vehicleInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class VehicleInfo {
	
	OwnerDetailsEntity owner;
	OwnerAddressDetailsEntity ownerAddrs;
	VehicleDetailsEntity vehicle;
	VehicleRegEntity vehicleReg;
	

}
