package com.test.web.hcust;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.web.ctx.ServletConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletConfig.class}, loader=AnnotationConfigWebContextLoader.class
		)
@WebAppConfiguration
public class HCustServiceTest {
	@Autowired HCustService hcustService;
	
	@Ignore
	public void testTest() {
		
		
	}
	@Test
	public void testSelectAll() {
		assertThat(hcustService.selectAll(), is(equalTo("5")));
		
	}

}
