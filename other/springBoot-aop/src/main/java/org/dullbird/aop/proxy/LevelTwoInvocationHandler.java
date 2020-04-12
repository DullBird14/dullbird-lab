package org.dullbird.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author cys
 * @date 2019-12-04 21:20
 */

public class LevelTwoInvocationHandler implements InvocationHandler {
	private Object target;

	public LevelTwoInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.doLevelTwo();
		Object result = method.invoke(target, args);
		return result;

	}
	public void doLevelTwo(){
		System.out.println("第二层包装");
	}
}
