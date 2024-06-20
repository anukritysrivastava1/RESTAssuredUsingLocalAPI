package com.test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;



public class TestLocalAPI {
	
	@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		
		given().get("/users").then().statusCode(200).log().all();
		
	}
	
	
	@Test
	public void post() {
		
		
		JSONObject req = new JSONObject();
		
		req.put("name", "Asha");
		req.put("department", "Tech");
		req.put("domain", 2);
		
		
		baseURI = "http://localhost:3000";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(req.toJSONString()).when().post("/users").then().statusCode(201);
	}
	
	@Test
	public void put() {
		
		
		
		
		JSONObject req = new JSONObject();
		
		req.put("name", "Richa");
		req.put("domain", 1);
		
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString())
		.when()
		.put("/users/3")
		.then()
		.statusCode(200);
	}
	
	@Test
	public void patch() {
		
		JSONObject req = new JSONObject();
		
		req.put("name", "Piyush");
		req.put("domain", 3);
		
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(req.toJSONString())
		.when()
		.patch("/users/4")
		.then()
		.statusCode(200);
	}
	
	@Test
	public void delete() {
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.delete("/users/4")
		.then()
		.statusCode(200);
	}
	

}
