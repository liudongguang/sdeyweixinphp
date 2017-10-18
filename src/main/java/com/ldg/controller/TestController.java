package com.ldg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldg.api.po.Book;
import com.ldg.api.service.BookService;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	@Autowired
	private BookService BookService;

	@ResponseBody
	@RequestMapping(value = "/mytest1")
	public Book mytest1() {
		System.out.println("----------->" + BookService);
		return BookService.testSV();
	}

	@ResponseBody
	@RequestMapping(value = "/testTransaction")
	public String testTransaction() {
		BookService.saveBookByTransaction();
		return "1";
	}
}
