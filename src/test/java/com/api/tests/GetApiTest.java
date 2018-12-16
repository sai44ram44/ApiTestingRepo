package com.api.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.base.TestBase;
import com.api.client.RestClient;

public class GetApiTest extends TestBase {
	TestBase testbase;
	String uri;
	RestClient restClient;
	
	@BeforeMethod
	public void setup() {
		
		testbase = new TestBase();
		String url = prop.getProperty("URL");
		String serviceUrl = prop.getProperty("serviceURL");
		uri = url+serviceUrl;
	}
	
	@Test
	public void apiGetCall() throws ClientProtocolException, IOException, JSONException {
		
		restClient = new RestClient();
		restClient.get(uri);
	}
	
	
	
}
