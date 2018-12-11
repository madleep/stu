package com.jt.search.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.search.pojo.Item;
import com.jt.search.service.SearchService;

@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;
	@RequestMapping("/search")
	public String search(Model model,String q) throws Exception{
		byte[] data=q.getBytes("ISO-8859-1");
		//数据发给dubbo提供者
		//dubbo中消费者发数据给提供者用的编码是utf-8
		String key=new String(data, "UTF-8");
		//通过调用接口的抽象方法去调用微服务的提供者
		List<Item> itemList=
				searchService.findItemByKey(key);
		model.addAttribute("itemList", itemList);
		//转发到search.jsp
		return "search";
	}
}
