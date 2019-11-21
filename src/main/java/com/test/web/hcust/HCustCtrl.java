package com.test.web.hcust;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.web.pxy.Box;
import com.test.web.pxy.Proxy;

@RestController
@RequestMapping("/hcusts")
public class HCustCtrl {
	
	//private static final Logger logger = LoggerFactory.getLogger(HCustCtrl.class);
	@Autowired HCustMapper hCustMapper;
	@Autowired Box<Integer> box;
	@Autowired Proxy pxy;
	public int count(){
		int count = hCustMapper.countHCusts();
		pxy.printer("count" + count);
		box.put("count", count);
		
		return box.get("count");
		
	}
	
	
	
}