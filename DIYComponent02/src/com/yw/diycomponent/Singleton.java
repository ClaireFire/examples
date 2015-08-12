package com.yw.diycomponent;

import java.util.HashMap;
import java.util.Map;

public class Singleton {

//	private static final Singleton singleton = new Singleton();//方式1
//	private static Singleton singleton = null;//方式2
	
	private Singleton() {
		
	}
	
//	public static Singleton getInstance() {//方式1
//		return singleton;
//	}
	
//	public static Singleton getInstance() {//方式2
//		if(singleton == null) {
//			synchronized (Singleton.class) {
//				if(singleton == null) {
//					singleton = new Singleton();
//				}
//			}
//		}
//		return singleton;
//	}
	
//	public static Singleton getInstance() {//方式3
//		return  SingletonInner.mSingleton;
//	}
//	
//	public static class SingletonInner {//方式3
//		private static final Singleton mSingleton = new Singleton();
//	}
	
	 private static Map<String,Singleton> objMap = new HashMap<String, Singleton>();
	 
	 public static void registerService(String key,Singleton singleton) {
		 if(!objMap.containsKey(key)) {
			 objMap.put(key, singleton);
		 }
	 }
	 
	 public static Singleton getInstance(String key){
		 return objMap.get(key);
	 }
}
