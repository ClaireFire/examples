package com.yw.link;

public class Link {

	private Object data;
	private Link next;
	
	public Link() {
		super();
	}
	public Link(Object data, Link next) {
		super();
		this.data = data;
		this.next = next;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Link getNext() {
		return next;
	}
	public void setNext(Link next) {
		this.next = next;
	}
	
}
