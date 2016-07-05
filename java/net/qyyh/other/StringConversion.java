package net.qyyh.other;

public class StringConversion {
	
	public static String to(String s){
		String a[]=s.split("_");
		for (int i = 1; i < a.length; i++) {
			a[i]=a[i].replaceFirst(a[i].substring(0, 1),a[i].substring(0, 1).toUpperCase());
		}
		StringBuilder sb=new StringBuilder();
		for (String temp : a) {
			sb.append(temp);
		}
		return sb.toString();
	}
}
