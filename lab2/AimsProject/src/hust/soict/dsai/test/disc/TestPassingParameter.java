package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
		System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle DVD titel: " + jungleDVD.getTitle());
		
		System.out.println("Swap two objects");
		swapTitle(jungleDVD, cinderellaDVD);
		System.out.println("jungle DVD titel: " + jungleDVD.getTitle());
		System.out.println("cinderella DVD title: " + cinderellaDVD.getTitle());
	}
	
	public static void swap (Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	public static void swapTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		String tmp = dvd1.getTitle();
		dvd1.setTitle(dvd2.getTitle());
		dvd2.setTitle(tmp);
	}
}
