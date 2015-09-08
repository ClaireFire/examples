package com.young.gson;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

public class GsonTest {
	public static Gson g = new Gson();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		objectToJson();
//		jsonToObject();
		
//		jsonToList();
//		jsonToMap();
		jsonParserNode();
	}

	private static void jsonParserNode() {
		String json = "{'flag':true,'data':[{'name':'张三','age':18,'sex':true},"
				+ "{'name':'张x三','age':18,'sex':true},"
				+ "{'name':'张xx三','age':18,'sex':true}]}";
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(json);
		JsonObject root = jsonElement.getAsJsonObject();
		System.out.println(root.getAsJsonPrimitive("flag").getAsBoolean());
		JsonArray jsonArray = root.getAsJsonArray("data");
		List<Student> stus = g.fromJson(jsonArray, new TypeToken<List<Student>>(){}.getType());
		System.out.println(stus);
	}

	private static void jsonToMap() {
		String json = "{'小3':{'name':'小3','age':20,'sex':true},"
				+ "'小4':{'name':'小4','age':21,'sex':false},"
				+ "'小5':{'name':'小5','age':22,'sex':true},"
				+ "'小1':{'name':'小1','age':18,'sex':true},"
				+ "'小2':{'name':'小2','age':19,'sex':false}}";
		
		Map<String ,Student> maps = g.fromJson(json, new TypeToken<Map<String ,Student>>(){}.getType());
		System.out.println(maps);
	}

	private static void jsonToList() {
		String json = "[{'name':'小1','age':18,'sex':true},"
				+ "{'name':'小2','age':19,'sex':false},"
				+ "{'name':'小3','age':20,'sex':true},"
				+ "{'name':'小4','age':21,'sex':false},"
				+ "{'name':'小5','age':22,'sex':true}]";
		
		List<Student> stus= g.fromJson(json, new TypeToken<List<Student>>(){}.getType());
		for (Student s : stus) {
			System.out.println(s);
		}
	}

	private static void jsonToObject() {
		String json = "{'name':'张三','age':18,'sex':true}";
		Student s = g.fromJson(json, Student.class);
		System.out.println(s);
	}

	private static void objectToJson() {
		Student stu = new Student("young", 28);
		String s = g.toJson(stu);
		System.out.println(s);
	}

}
