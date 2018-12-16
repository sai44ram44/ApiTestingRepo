package com.api.client;


import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {
	
	public void get(String url) throws ClientProtocolException, IOException, JSONException {
		
		//Print the Status
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);//http get request
		CloseableHttpResponse closeableHttpResponse =  httpClient.execute(httpGet);//hit the GET URL
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Get the StatusCode----->"+statusCode);
		
		//Print the Json Response
		String response= EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject jsonResponse = new JSONObject(response);
		System.out.println("Repsonse JSON from API ----->"+ jsonResponse);
		
		//print headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String,String> allHeaders = new HashMap<String, String>();
		
		for(Header header : headersArray) {
			
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers array--->"+ allHeaders);
	}		

}
