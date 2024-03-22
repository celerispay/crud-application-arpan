package com.crudapplication;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.crudapplication.configuration.BatchConfig;

@SpringBootTest
class CrudApplicationTests {

	@Autowired
	private BatchConfig batchConfig;
	@Test
	void contextLoads() {
		  assertNotNull(batchConfig);
	}

}
