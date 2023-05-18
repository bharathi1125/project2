package com.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Day1 {

	public static void main(String[] args) {
		RequestSpecification reqSpec;
		reqSpec = RestAssured.given();
		reqSpec = reqSpec.header("Content-Type", "application/json");
		reqSpec = reqSpec.pathParam("Fno", "6267");
		Response response = reqSpec.get("https://www.omrbranch.com/api/flight/{Fno}");
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		String asString = response.asString();
		System.out.println(asString);

		String asPrettyString = response.asPrettyString();
		System.out.println(asPrettyString);

	}

}
