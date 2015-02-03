package com.example.gridimagesearch.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageResult implements Serializable {

	public String fullUrl;
	public String thumbUrl;
	public String title;
	public int width;
	public int height;
	
	public ImageResult( JSONObject json) {
		
		try {
			this.fullUrl = json.getString("url");
			this.thumbUrl = json.getString("tbUrl");
			this.title = json.getString("title");
			this.width = json.getInt("width");
			this.height = json.getInt("height");

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static ArrayList<ImageResult> fromJSONArray(JSONArray jsonArray){
		
		ArrayList<ImageResult> results = new ArrayList<ImageResult>();
		for(int i=0; i< jsonArray.length();i++){
			try {	
				ImageResult iR = new ImageResult(jsonArray.getJSONObject(i));
				results.add(iR);
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}
		
		
		return results;
	}
	
	
	
	
	
}
