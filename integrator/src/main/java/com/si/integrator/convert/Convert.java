package com.si.integrator.convert;
import java.io.IOException;

import org.json.JSONObject;
import org.json.XML;


public class Convert {
	
	public  static String jsonToXml(String json) throws IOException {

		JSONObject obj = new JSONObject(json);
		// converting json to xml
		String xml_data = XML.toString(obj);
		System.out.println(xml_data);
		return xml_data;
	}
	

}
