package com.sdey.api.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.Page;
import com.sdey.api.po.WxSucai;
import com.sdey.api.vo.PageParam;

public interface SuCaiService {
    int saveSuCai(HttpServletRequest request,WxSucai sucai) throws IllegalStateException, IOException;

	Page<WxSucai> getSuCaiList(PageParam pageParam);

	int delSCByID(Integer id);

	int guanlianSCByID(Integer id, String cdid);

	Map<String, WxSucai> getMenuMap();
}
