package com.sdey.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdey.api.po.ServicePhpQr;
import com.sdey.api.service.PhpWXService;
import com.sdey.impl.mapper.ServicePhpQrMapper;

@Service
public class PhpWXServiceImpl implements PhpWXService {
	@Autowired
	private ServicePhpQrMapper servicePhpQrDao;

	@Override
	public String getKSEWM(String hospitalid, String officeid) {
		ServicePhpQr sp = new ServicePhpQr();
		sp.setHospitalid(hospitalid);
		sp.setOfficeid(officeid);
		return servicePhpQrDao.getKSEWM(sp);
	}

	@Override
	public int saveKSEWM(String hospitalid, String officeid, String getEWMByTicketUrl) {
		ServicePhpQr sp = new ServicePhpQr();
		sp.setHospitalid(hospitalid);
		sp.setOfficeid(officeid);
		sp.setQrCode(getEWMByTicketUrl);
		sp.setState(2);
		return servicePhpQrDao.insertSelective(sp);
	}

	@Override
	public String getHospitalEWM(String hospitalid) {
		return servicePhpQrDao.getHospitalEWM(hospitalid);
	}

	@Override
	public int saveHospitalEWM(String hospitalid, String getEWMByTicketUrl) {
		ServicePhpQr sp = new ServicePhpQr();
		sp.setHospitalid(hospitalid);
		sp.setQrCode(getEWMByTicketUrl);
		sp.setState(1); // 1 表示医院
		return servicePhpQrDao.insertSelective(sp);
	}
}
