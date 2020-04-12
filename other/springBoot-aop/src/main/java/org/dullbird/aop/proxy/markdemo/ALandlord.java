package org.dullbird.aop.proxy.markdemo;

/**
 * @author cys
 * @date 2019-12-07 15:20
 */

public class ALandlord implements RentInterface {
	@Override
	public void getRent() {
		System.out.println("A 房东自己收租");
	}
}
