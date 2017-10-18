package com.sdey.impl.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sdey.api.po.WxSucai;
import com.sdey.api.service.SuCaiService;
import com.sdey.api.util.RequestFileUtil;
import com.sdey.api.vo.PageParam;
import com.sdey.impl.mapper.WxSucaiMapper;
import com.weixin.util.WX_Util;

@Service
public class SuCaiServiceImpl implements SuCaiService {
	@Autowired
	private WxSucaiMapper wxSucaiMapper;

	@Override
	public int saveSuCai(HttpServletRequest request, WxSucai sucai) throws IllegalStateException, IOException {
		String imgPath = null;
		List<MultipartFile> files = RequestFileUtil.getUploadFile(request);
		if (files != null && files.size() > 0) {
			imgPath = RequestFileUtil.saveToComputer(files, request, "assets/images/wx");
		}

		if (sucai.getId() != null) {
			if (imgPath != null) {
				RequestFileUtil.delFile(request, sucai.getImgpath());
				sucai.setImgpath(imgPath);
			}
			return wxSucaiMapper.updateByPrimaryKeySelective(sucai);
		} else {
			if (imgPath != null) {
				sucai.setImgpath(imgPath);
				sucai.setCreatedata(new Date());
				return wxSucaiMapper.insertSelective(sucai);
			}
		}
		return 0;
	}

	@Override
	public Page<WxSucai> getSuCaiList(PageParam pageParam) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getPageSize(), true);
		return wxSucaiMapper.getSuCaiList();
	}

	@Override
	public int delSCByID(Integer id) {
		return wxSucaiMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int guanlianSCByID(Integer id, String cdid) {
		wxSucaiMapper.clearGuanLian(cdid);
		return wxSucaiMapper.guanlianSCByID(id, cdid);
	}

	@Override
	public Map<String, WxSucai> getMenuMap() {
		Map<String, WxSucai> map = WX_Util.getMenumap();
		if (map.size() == 0) {
			List<WxSucai> scList = wxSucaiMapper.getAllCaidan();
			scList.forEach(item -> {
				String key = item.getMenukey();
				map.put(key, item);
			});
		}
		return map;
	}
}
