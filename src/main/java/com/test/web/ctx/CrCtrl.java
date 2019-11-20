package com.test.web.ctx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.pxy.Box;
import com.test.web.pxy.CrawlingProxy;
import com.test.web.pxy.Inventory;
import com.test.web.pxy.PageProxy;

@RestController
@RequestMapping("/crwal")
public class CrCtrl {
	@Autowired CrawlingProxy crawler;
	@Autowired Inventory<HashMap<String, String>> inventory;
	@Autowired PageProxy pagePX;
	@Autowired Box<Object> box;
	
	
	@GetMapping("/naver")
	public ArrayList<HashMap<String, String>> naverCrawling() {
		System.out.println("naver");
		
		return crawler.engCrawling("https://endic.naver.com/?sLn=kr");
		
		
	}
	@GetMapping("/bugs/{page}")
	public Map<?, ?> bugsCrawling(@PathVariable String page){
		System.out.println("bugs");
		ArrayList<HashMap<String, String>> list = crawler.bugsCrawling();
		
	
		
		
		pagePX.setRowCount(list.size());
		pagePX.setPageSize(10);
		pagePX.setBlockSize(5);
		pagePX.setCurrPage(0);
		pagePX.paging();
		ArrayList<HashMap<String, String>> temp = new ArrayList<>();
		
		for(int i = 0 ;i < list.size(); i++) {
			if(i >= pagePX.getStartRow() && i <= pagePX.getEndRow()) {
				temp.add(list.get(i));
			}
			if(i > pagePX.getEndRow()) {break;}
			
		}
		box.put("pager", pagePX);
		box.put("list", temp);
		System.out.println(box.get("pager").toString());
		return box.get();
		
	}

	@GetMapping("/cgv")
	public ArrayList<HashMap<String, String>> cgvCrawling() {
		System.out.println("cgv");
		return crawler.cgvCrawl();

	}

}
