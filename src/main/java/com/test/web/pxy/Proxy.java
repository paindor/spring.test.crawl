package com.test.web.pxy;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component("pxy")
public class Proxy {
	
	public int integer(String t) {
		Function<String, Integer> f = Integer::parseInt;
		
		return f.apply(t);
		
	}
	public boolean equal(String s1, String s2) {
		BiPredicate<String, String> f = String::equals;
		
		return f.test(s1, s2);
	}
	public void printer(Object t) {
		Consumer<Object> f = System.out::println;
		
		f.accept(t);
		
	}
	public String string(Object t) {
		Function<Object, String> f= String::valueOf;
		
		return f.apply(t);
		
		
	}

}
