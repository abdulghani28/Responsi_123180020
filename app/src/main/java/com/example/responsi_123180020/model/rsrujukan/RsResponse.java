package com.example.responsi_123180020.model.rsrujukan;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RsResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private List<DataItem> data;

	public int getStatusCode(){
		return statusCode;
	}

	public List<DataItem> getData(){
		return data;
	}
}