package org.viewtrol.energy.core.utils;

import java.io.StringWriter;

import org.apache.sling.commons.json.JSONException;
import org.apache.sling.commons.json.io.JSONWriter;

public class JSONBuilder {

	public String SampleJSON() {

		String json = null;
		StringWriter sw = new StringWriter();
		JSONWriter writer = new JSONWriter(sw);

		try {
			writer.object();
			writer.key("shopping cart");
			writer.value("sample shopping cart");
			
			writer.key("client");
			writer.value("mr. customer");
			
			writer.key("address");
			writer.value("18436 awesome trail NE");
			
			writer.key("city_state");
			writer.value("some city, MN");
			
			writer.key("zip");
			writer.value("38978");
						
			writer.key("items");
			writer.array();
			for (int count = 0; count < 3; count++) {
				writer.object();
				writer.key("name");
				writer.value("item_" + count);
				writer.key("description");
				writer.value("item_" + count + "_description");
				
				writer.key("quantity");
				writer.value("item_" + count + "_quantity");
				writer.endObject();
			}

			writer.endArray();

			writer.endObject();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		json = sw.toString();

		return json;
	}

}
