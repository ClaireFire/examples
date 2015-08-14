package com.yw.link;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Collection list = new LinkList();
		for(int i = 0;i<99;i++){
			Object o = new String("µÚ"+(i+1)+"¸ö");
			list.add(o);
		}
		
		System.out.println(list.size());
//		list.getList();
		Iterator c = list.iterator();
		while(c.hasNext()) {
			Link o = (Link)c.next();
			System.out.println(o.getData().toString());
		}
	}

}
