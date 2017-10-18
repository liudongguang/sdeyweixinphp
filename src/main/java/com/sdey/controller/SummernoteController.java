package com.sdey.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ldg.api.vo.ResultMsg;
import com.sdey.api.util.RequestFileUtil;

@Controller
@RequestMapping(value = "/summernot")
public class SummernoteController {
	protected Logger logger = LoggerFactory.getLogger(SummernoteController.class);

	/*
	 * 上传图片
	 */
	@RequestMapping("uploadImg")
	public @ResponseBody ResultMsg uplodaImg(HttpServletRequest request, //
			HttpServletResponse response)//
			throws IllegalStateException, IOException {
		List<MultipartFile> files = RequestFileUtil.getUploadFile(request);
		String fileName = RequestFileUtil.saveToComputer(files, request, "summernote");
		ResultMsg msg = new ResultMsg();
		msg.setData(fileName);
		return msg;
	}

}
