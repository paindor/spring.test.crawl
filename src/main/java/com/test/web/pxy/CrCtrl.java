package com.test.web.pxy;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crwal")
public class CrCtrl {
	
	@GetMapping("/naver")
	public List<String> naverCrawling() {
		System.out.println("naver");
		return null;
		
		
	}
	@GetMapping("/bugs")
	public List<String> bugsCrawling(){
		System.out.println("bugs");
		return null;
		
	}
	@GetMapping("/cgv")
	public List<String> cgvCrawling(){
		System.out.println("cgv");
		return null;
	}

}
