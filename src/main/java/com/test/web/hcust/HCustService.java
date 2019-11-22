package com.test.web.hcust;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.web.pxy.Proxy;

@Component
public class HCustService extends Proxy {
	@Autowired HCustMapper hCustMapper;
	
	public String test() {
		
		 Arrays.asList(1,2,5,2,4).stream().forEach(System.out::print);
		IntStream.rangeClosed(101, 200).forEach(System.out::println);
		new Random().ints().limit(5).forEach(System.out::print);
		
	
		for(int i = 1 ;i<10 ;i++) {
			System.out.println(i + "+");
		}
		return this.string(5);
	}
	public String selectAll() {
		List<HCust> ls = hCustMapper.selectAll();
		List<String>ls2 = new ArrayList<>();
		for(int i= 0 ;i < ls.size() ; i++) {
			ls2.add(ls.get(i).getCid());
			
		}
		Stream.of(ls2)
		.sorted()
		.forEach(System.out::println);
		return string("5");
		
	}
	
}
