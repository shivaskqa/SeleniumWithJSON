package com.jsonpractice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class FetchDataFromJSONFile {

	public static void main(String[] args)throws ParseException,IOException,FileNotFoundException
	{
		// TODO Auto-generated method stub

		JSONParser parser=new JSONParser();
		
		Object object=parser.parse(new FileReader(".//jsonfiles/employee.json"));
		
		JSONObject jsonObject=(JSONObject)object;
		
		String firstName=(String) jsonObject.get("firstname");
		String lastName=(String) jsonObject.get("lastname");
		
		System.out.println(firstName);
		System.out.println(lastName);
		
		JSONArray array=(JSONArray)jsonObject.get("address");
		
		for(int i=0;i<array.size();i++)
		{
			JSONObject arrObj=(JSONObject)array.get(i);
			String street=(String)arrObj.get("street");
			String city=(String)arrObj.get("city");
			String state=(String)arrObj.get("state");
			
			System.out.println(street);
			System.out.println(city);
			System.out.println(state);
		}
		
		
		Iterator itr=array.iterator();
		
		while(itr.hasNext())
		{
			JSONObject jitrObj=(JSONObject) itr.next();
			System.out.println(jitrObj.get("street")+","+jitrObj.get("city")+","+jitrObj.get("state"));
		}
		
		
	}

}
