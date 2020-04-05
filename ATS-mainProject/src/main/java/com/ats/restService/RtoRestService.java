package com.ats.restService;

import org.springframework.stereotype.Service;

import com.ats.domain.VehicleInfo;

@Service
public interface RtoRestService {
	public VehicleInfo findVehicleUsingRest(String vhclNo);
}
