package org.dullbird.aop.proxy.markdemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author cys
 * @date 2019-12-07 20:00
 */

public class ProxyInterceptor implements MethodInterceptor {
	/**
	 * 代理要额外做的事情
	 */
	private void getProxyFee(){
		System.out.println("收代理费");
	}
	private void saveLog(){
		System.out.println("再记个账本");
	}
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		getProxyFee();
		Object result = methodProxy.invokeSuper(o, objects);
		saveLog();
		return result;
	}
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		ProxyInterceptor proxyInterceptor = new ProxyInterceptor();
		//需要执行的代理方法
		enhancer.setCallback(proxyInterceptor);
		//指定代理类型
		enhancer.setSuperclass(FishManC.class);
		FishManC fishManC = (FishManC) enhancer.create();
		//enhancer 是不能复用的。
		enhancer = new Enhancer();
		enhancer.setCallback(proxyInterceptor);
		enhancer.setSuperclass(ALandlord.class);
		ALandlord aLandlord = (ALandlord) enhancer.create();
		fishManC.sellFish();
		aLandlord.getRent();
		System.out.println(fishManC.getClass());
		System.out.println(aLandlord.getClass());
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
