package org.dullbird.aop.proxy.markdemo;

/**
 * @author cys
 * @date 2019-12-07 15:21
 */

public class ProxyLord implements RentInterface, SellFishInterface{

	private RentInterface lord;

	public ProxyLord(RentInterface lord) {
		this.lord = lord;
	}
	@Override
	public void sellFish() {
		getProxyFee();
		lord.getRent();
		saveLog();

	}
	@Override
	public void getRent() {
		getProxyFee();
		lord.getRent();
		saveLog();
	}

	private void getProxyFee(){
		System.out.println("收代理费");
	}
	private void saveLog(){
		System.out.println("再记个账本");
	}

	public static void main(String[] args) {
		ALandlord landlord = new ALandlord();
		ProxyLord proxyLord = new ProxyLord(landlord);
//		System.out.println("自己收租:");
//		landlord.getRent();
		System.out.println("========================");
		System.out.println("代理收租:");
		proxyLord.getRent();
		BLandlord Blandlord = new BLandlord();
		proxyLord = new ProxyLord(Blandlord);
		System.out.println("========================");
		System.out.println("代理收租:");
		proxyLord.getRent();
	}

}
