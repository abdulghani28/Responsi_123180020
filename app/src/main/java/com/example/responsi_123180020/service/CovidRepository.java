package com.example.responsi_123180020.service;



import com.example.responsi_123180020.model.datakasus.KasusResponse;
import com.example.responsi_123180020.model.rsrujukan.RsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidRepository {
    @GET("api/v1/rekapitulasi_v2/jabar/harian")
    Call<KasusResponse> getKasus();
    @GET("api/v1/sebaran_v2/jabar/faskes")
    Call<RsResponse> getRs();
}
