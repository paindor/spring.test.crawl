package com.test.web.ctx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.pxy.CrawlingProxy;
import com.test.web.pxy.Inventory;

@RestController
@RequestMapping("/crwal")
public class CrCtrl {
	@Autowired CrawlingProxy crawler;
	@Autowired Inventory<HashMap<String, String>> inventory;
	
	@GetMapping("/naver")
	public ArrayList<HashMap<String, String>> naverCrawling() {
		System.out.println("naver");
		
		return crawler.engCrawling("https://endic.naver.com/?sLn=kr");
		
		
	}
	@GetMapping("/bugs")
	public List<String> bugsCrawling(){
		System.out.println("bugs");
		return null;
		
	}

	@GetMapping("/cgv")
	public ArrayList<HashMap<String, String>> cgvCrawling() {
		System.out.println("cgv");
		return crawler.cgvCrawl();

	}

}
