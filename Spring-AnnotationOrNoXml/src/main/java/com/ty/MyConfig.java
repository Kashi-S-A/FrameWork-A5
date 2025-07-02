package com.ty;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.ty", "com.test", "com.demo" })
public class MyConfig {

}
