package org.dullbird.aop.proxy.markdemo;

/**
 * @author cys
 * @date 2019-12-07 15:20
 */

public class FishManC implements SellFishInterface {
	@Override
	public void sellFish() {
		System.out.println("我卖鱼 收钱！");
	}
}
