package org.dullbird.aop.proxy.demo;

import org.springframework.stereotype.Component;

/**
 * @author cys
 * @date 2018-10-10 下午6:21
 */
@Component
public class Client implements AInterface {
    @Override
    public void hello() {
	    System.out.println("Client say hello!!");
    }

    public void test(){
	    System.out.println("==================Test===================");
    }
}
