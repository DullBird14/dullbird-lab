package org.dullbird.aop.proxy.markdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cys
 * @date 2019-12-07 16:09
 */

public class ProxyMethodHandler implements InvocationHandler {
	/**
	 * 实际代理的对象，不管你卖鱼，还是收租，
	 * 如果同样是 找我代理收代理费，并且记录的都可以
	 */
	private Object client;

	public ProxyMethodHandler(Object client) {
		this.client = client;
	}

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
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		getProxyFee();
		//还可以对指定的方法过滤
		Object result = method.invoke(client, args);
		saveLog();
		return result;
	}

	public static void main(String[] args) {
		ALandlord landlord = new ALandlord();
		ProxyMethodHandler proxyMethodHandler = new ProxyMethodHandler(landlord);
		//仔细观察这个方法的参数。需要接口，所以jdk动态代理。一定需要接口
		RentInterface rentProxy = (RentInterface)Proxy.newProxyInstance(landlord.getClass().getClassLoader(),
				landlord.getClass().getInterfaces(),
				proxyMethodHandler);
		FishManC fishMan = new FishManC();
		proxyMethodHandler = new ProxyMethodHandler(fishMan);
		SellFishInterface fishtProxy = (SellFishInterface)Proxy.newProxyInstance(fishMan.getClass().getClassLoader(),
				fishMan.getClass().getInterfaces(),
				proxyMethodHandler);
		rentProxy.getRent();
		fishtProxy.sellFish();
		System.out.println(rentProxy.getClass());
		System.out.println(fishtProxy.getClass());
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
