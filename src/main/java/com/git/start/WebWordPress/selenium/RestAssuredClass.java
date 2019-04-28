package com.git.start.WebWordPress.selenium;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredClass {
	
	//@Test
	public void soup()
	{
		Response resp= 
				RestAssured.
				given().
					baseUri("http://192.168.56.1:8080/CreatedProject").
					contentType("text/xml").
					body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:test=\"http://test.com/\">\r\n   <soapenv:Header/>\r\n   <soapenv:Body>\r\n      <test:div>\r\n         <arg0>70</arg0>\r\n         <arg1>7</arg1>\r\n      </test:div>\r\n   </soapenv:Body>\r\n</soapenv:Envelope>").
				when().
					post();
				
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getTime());
		System.out.println(resp.getBody().asString());
	}
	
	@Test
	public void rest()
	{
		Response resp= 
				RestAssured.
				given().
					baseUri("https://applicationrestservice-comedic-porcupine.cfapps.io/register/student").
					contentType("application/json").
					body("{\r\n\t\t\t\"age\":20,\r\n\t\t\t\"name\":\"12334Deepak1234\",\r\n\t\t\t\"registrationNumber\":\"9090\"\r\n}").
				when().
					post();
				
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getTime());
		System.out.println(resp.getBody().asString());
	}

}
