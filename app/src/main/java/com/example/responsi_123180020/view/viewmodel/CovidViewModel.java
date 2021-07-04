package com.example.responsi_123180020.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi_123180020.model.datakasus.ContentItem;
import com.example.responsi_123180020.model.datakasus.KasusResponse;
import com.example.responsi_123180020.model.rsrujukan.DataItem;
import com.example.responsi_123180020.model.rsrujukan.RsResponse;
import com.example.responsi_123180020.service.ApiMain;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<List<ContentItem>> listCovid = new MutableLiveData<>();
    private MutableLiveData<List<DataItem>> listRsrujukan = new MutableLiveData<>();

    public void setCovid() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiCovid().getKasus().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse responseKasus = response.body();
                if (responseKasus != null ){
                    List<ContentItem> kasusItem = responseKasus.getData().getContent();
                    listCovid.postValue(kasusItem);
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {

            }
        });
    }

    public void setRsrujukan() {
        if (this.apiMain == null) {
            apiMain = new ApiMain();
        }

        apiMain.getApiCovid().getRs().enqueue(new Callback<RsResponse>() {
            @Override
            public void onResponse(Call<RsResponse> call, Response<RsResponse> response) {
                RsResponse responseRs = response.body();
                if (responseRs != null ){
                    List<DataItem> rsItem = responseRs.getData();
                    listRsrujukan.postValue(rsItem);
                }

            }

            @Override
            public void onFailure(Call<RsResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<List<ContentItem>> getKasus(){
        return listCovid;
    }
    public LiveData<List<DataItem>> getData(){
        return listRsrujukan;
    }

}
