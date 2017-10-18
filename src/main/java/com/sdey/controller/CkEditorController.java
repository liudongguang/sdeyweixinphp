package com.sdey.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/ckeditor")
public class CkEditorController {
	protected Logger logger = LoggerFactory.getLogger(CkEditorController.class);

	/*
	 * 上传图片
	 */
	@RequestMapping("uploadImg")
	public void uplodaImg(@RequestParam("upload") MultipartFile file, //
			HttpServletRequest request, //
			HttpServletResponse response, //
			@RequestParam("CKEditorFuncNum") String CKEditorFuncNum)//
			throws IllegalStateException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String fileName = file.getOriginalFilename();
		String uploadContentType = file.getContentType();
		String expandedName = "";
		if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {
			// IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
			expandedName = ".jpg";
		} else if (uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")) {
			// IE6上传的png图片的headimageContentType是"image/x-png"
			expandedName = ".png";
		} else if (uploadContentType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (uploadContentType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			StringBuilder sb1 = new StringBuilder(
					"<script type=\"text/javascript\"> window.parent.CKEDITOR.tools.callFunction(");
			sb1.append(CKEditorFuncNum).append(",'','文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）'); </script>");
			out.println(sb1.toString());
			return;
		}
		if (file.getSize() > 600 * 1024) {
			StringBuilder sb2 = new StringBuilder(
					"<script type=\"text/javascript\"> window.parent.CKEDITOR.tools.callFunction(");
			sb2.append(CKEditorFuncNum).append(",'','文件大小不得大于600k'); </script>");
			out.println(sb2.toString());
			return;
		}
		// fileName = DateFormatUtils.format(new
		// Date(),CommConstant.DATE_FORMAT_ORDER) + expandedName;
		fileName = UUID.randomUUID().toString() + expandedName;
		StringBuilder newsFilePath = new StringBuilder(request.getSession().getServletContext().getRealPath("newsimg"));
		File mdr = new File(newsFilePath.toString());
		if (!mdr.exists()) {
			mdr.mkdirs();
		}
		newsFilePath.append("/").append(fileName);
		file.transferTo(new File(newsFilePath.toString()));
		// 返回"图像"选项卡并显示图片 request.getContextPath()为web项目名
		StringBuilder sb3 = new StringBuilder(
				"<script type=\"text/javascript\"> window.parent.CKEDITOR.tools.callFunction(");
		sb3.append(CKEditorFuncNum).append(",'newsimg/").append(fileName).append("','') </script>");
		out.println(sb3.toString());
		return;
	}

}
