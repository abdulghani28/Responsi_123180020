package com.example.responsi_123180020.model.datakasus;

import com.google.gson.annotations.SerializedName;

public class KasusResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private Data data;

	public int getStatusCode(){
		return statusCode;
	}

	public Data getData(){
		return data;
	}
}