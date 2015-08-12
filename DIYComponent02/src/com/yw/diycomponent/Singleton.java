package com.yw.diycomponent;

import java.util.HashMap;
import java.util.Map;

public class Singleton {

//	private static final Singleton singleton = new Singleton();//��ʽ1
//	private static Singleton singleton = null;//��ʽ2
	
	private Singleton() {
		
	}
	
//	public static Singleton getInstance() {//��ʽ1
//		return singleton;
//	}
	
//	public static Singleton getInstance() {//��ʽ2
//		if(singleton == null) {
//			synchronized (Singleton.class) {
//				if(singleton == null) {
//					singleton = new Singleton();
//				}
//			}
//		}
//		return singleton;
//	}
	
//	public static Singleton getInstance() {//��ʽ3
//		return  SingletonInner.mSingleton;
//	}
//	
//	public static class SingletonInner {//��ʽ3
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
