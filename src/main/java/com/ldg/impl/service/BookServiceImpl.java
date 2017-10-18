package com.ldg.impl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ldg.api.po.Book;
import com.ldg.api.service.BookService;
import com.ldg.impl.mapper.BookMapper;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;

	@Override
	public Book testSV() {
		return bookMapper.selectByPrimaryKey(1001);
	}

	@Override
	public void saveBookByTransaction() {
		Book irecord = new Book();
		irecord.setIsbn(1003);
		irecord.setPrice(300.0);
		irecord.setBookName("测试添加");
		//bookMapper.insert(irecord);
		Book record = new Book();
		record.setIsbn(1001);
		record.setPrice(300.0);
		//bookMapper.updateByPrimaryKeySelective(record);
		if (record.getPrice() > 200) {
			throw new RuntimeException("价格高...");
		}
	}
}
