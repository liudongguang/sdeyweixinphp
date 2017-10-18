package com.sdey.api.service;

public interface PhpWXService {

	String getKSEWM(String hospitalid, String officeid);

	int saveKSEWM(String hospitalid, String officeid, String getEWMByTicketUrl);

	String getHospitalEWM(String hospitalid);

	int saveHospitalEWM(String hospitalid, String getEWMByTicketUrl);

}
