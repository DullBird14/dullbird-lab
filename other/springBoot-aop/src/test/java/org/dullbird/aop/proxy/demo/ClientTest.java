package org.dullbird.aop.proxy.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * @author cys
 * @date 2019-12-05 19:19
 */

@SpringBootTest
public class ClientTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private Client client;

	@Test
	public void testHello() {
		client.hello();
	}
}