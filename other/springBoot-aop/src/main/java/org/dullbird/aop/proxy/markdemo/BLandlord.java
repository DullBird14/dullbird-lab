package org.dullbird.aop.proxy.markdemo;

/**
 * @author cys
 * @date 2019-12-07 15:20
 */

public class BLandlord implements RentInterface {
	@Override
	public void getRent() {
		System.out.println("B 房东自己收租");
	}
}
