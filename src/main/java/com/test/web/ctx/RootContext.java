package com.test.web.ctx;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages= {"com.test.web"})
@Import({
	ServletContext.class
})
public class RootContext {

}
