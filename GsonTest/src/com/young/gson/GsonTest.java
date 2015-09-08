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
		String json = "{'flag':true,'data':[{'name':'����','age':18,'sex':true},"
				+ "{'name':'��x��','age':18,'sex':true},"
				+ "{'name':'��xx��','age':18,'sex':true}]}";
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = parser.parse(json);
		JsonObject root = jsonElement.getAsJsonObject();
		System.out.println(root.getAsJsonPrimitive("flag").getAsBoolean());
		JsonArray jsonArray = root.getAsJsonArray("data");
		List<Student> stus = g.fromJson(jsonArray, new TypeToken<List<Student>>(){}.getType());
		System.out.println(stus);
	}

	private static void jsonToMap() {
		String json = "{'С3':{'name':'С3','age':20,'sex':true},"
				+ "'С4':{'name':'С4','age':21,'sex':false},"
				+ "'С5':{'name':'С5','age':22,'sex':true},"
				+ "'С1':{'name':'С1','age':18,'sex':true},"
				+ "'С2':{'name':'С2','age':19,'sex':false}}";
		
		Map<String ,Student> maps = g.fromJson(json, new TypeToken<Map<String ,Student>>(){}.getType());
		System.out.println(maps);
	}

	private static void jsonToList() {
		String json = "[{'name':'С1','age':18,'sex':true},"
				+ "{'name':'С2','age':19,'sex':false},"
				+ "{'name':'С3','age':20,'sex':true},"
				+ "{'name':'С4','age':21,'sex':false},"
				+ "{'name':'С5','age':22,'sex':true}]";
		
		List<Student> stus= g.fromJson(json, new TypeToken<List<Student>>(){}.getType());
		for (Student s : stus) {
			System.out.println(s);
		}
	}

	private static void jsonToObject() {
		String json = "{'name':'����','age':18,'sex':true}";
		Student s = g.fromJson(json, Student.class);
		System.out.println(s);
	}

	private static void objectToJson() {
		Student stu = new Student("young", 28);
		String s = g.toJson(stu);
		System.out.println(s);
	}

}
