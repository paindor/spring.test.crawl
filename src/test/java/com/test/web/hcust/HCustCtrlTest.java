package com.test.web.hcust;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.web.ctx.ServletConfig;
import com.test.web.pxy.Calculator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletConfig.class}, loader=AnnotationConfigWebContextLoader.class
		)
@WebAppConfiguration
public class HCustCtrlTest {
	@Autowired HCustCtrl custCtrl;
	
	@Test
	public void testCount() {
		assertThat(custCtrl.count(), not(equalTo(0)));
	}
	

}
