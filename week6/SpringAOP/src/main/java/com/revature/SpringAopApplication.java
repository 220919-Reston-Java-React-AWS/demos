package com.revature;

import com.revature.service.Service1;
import com.revature.service.Service2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringAopApplication implements CommandLineRunner {

	//add a logger as a property - SLF4J (logging included with Spring)
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Service1 service1;
	@Autowired
	private Service2 service2;

	/**
	1. Service1 Method is called
	2. The aspect does its thing (log info)
	3. Dao method fires
	4. Service2 method is called
	5. Aspect fires before the dao method can fire
	6. Dao2 method fires

	Goal is to interpect the methods on the service layer when they make a call to the Dao.
	 */


	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("========================Runner Starting==========================");

		log.info(service1.calculatesSomething());
		log.info(service2.calculatesSomething());

	}

	/**
	 *
	 * 	What is being said is AOP does not replace the logging framework.
	 * 		You will still use your logging framework to log to files just like you always have.
	 * 		What AOP brings to the table is addressing the cross cutting concerns. Say you wanted to log a
	 * 		message every time you entered a method.
	 * 		Typically you would have to write something similar to logger.debug("I am entering a method").
	 * 		Using AOP this can be done without adding this line at the beginning of every method.
	 *
	 */
}
