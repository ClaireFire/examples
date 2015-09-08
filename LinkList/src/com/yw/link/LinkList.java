package com.yw.link;

public class LinkList implements Collection{

	private Link head = null;
	private Link temp = head;
	private int index = 0;
	
	public void add(Object o){
		Link link = new Link(o,null);
		if(head == null) {
			head = link;
			temp = head;
		} else {
			temp.setNext(link);
			temp = link;
		}
		index++;
	}

	public int size() {
		return index;
	}
	
	public void getList(){
		if (head == null) {
			return;
		}
		Link temp = head;
		do {
			System.out.println(temp.getData().toString());
			temp = temp.getNext();
		} while (temp != null);
	}

	public Iterator iterator() {
		return new LinkIterator();
	}
	public class LinkIterator implements Iterator {
		public Link currLink = head;
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return currLink != null;
		}

		public Object next() {
			// TODO Auto-generated method stub
			Link temp = currLink;
			currLink = temp.getNext();
			return temp;
		}
		
	}

}
