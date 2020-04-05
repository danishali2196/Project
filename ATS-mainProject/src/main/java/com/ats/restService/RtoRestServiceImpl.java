package com.ats.restService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ats.domain.VehicleInfo;

@Service
public class RtoRestServiceImpl implements RtoRestService {
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public VehicleInfo findVehicleUsingRest(String vehicleRegNo) {
		String url = "http://localhost:7070//rest/vehicleInfo?vehicleRegNo={vehicleRegNo}";
		ResponseEntity<VehicleInfo> resp = null;
		int statusCode = 0;
		VehicleInfo info = null;
		try {
			resp = restTemplate.exchange(url, HttpMethod.GET, null, VehicleInfo.class, vehicleRegNo);

			 statusCode = resp.getStatusCode().value();
			 System.out.println(statusCode);
			if (statusCode == 200) {
				info = (VehicleInfo) resp.getBody();
				return info;
			}
		} 
		catch (Exception e) {
			 System.out.println("RtoRestServiceImpl.findVehicleUsingRest()");
			 
			 return info;
		}
		System.out.println("RtoRestServiceImpl.findV");
		return null;
	}

}
