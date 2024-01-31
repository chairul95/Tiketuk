package com.example.tiketuk.ui.detailjadwal;

import android.util.Log;

import com.example.tiketuk.network.ApiClient;
import com.example.tiketuk.network.ApiInterface;
import com.example.tiketuk.response.detailjadwal.DetailJadwalResponse;
import com.example.tiketuk.response.detailjadwal.DetailResult;
import com.example.tiketuk.response.jadwal.JadwalResponse;
import com.example.tiketuk.response.jadwal.Result;
import com.example.tiketuk.ui.jadwal.Jadwal;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailJadwaltModel implements DetailJadwal.Model {

    private final String TAG = "check DetailJadwalModel";
    @Override
    public void getDataList(OnFinishedListener onFinishedListenerr) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<DetailJadwalResponse> call = apiInterface.getDetailJadwal();
        call.enqueue(new Callback<DetailJadwalResponse>() {
            @Override
            public void onResponse(Call<DetailJadwalResponse> call, Response<DetailJadwalResponse> response) {
                List<DetailResult> jadwalList = response.body().getTiketux().getResult();
                Log.d(TAG, "Data Size: " + jadwalList.size());

                onFinishedListenerr.onFinished(jadwalList);

            }

            @Override
            public void onFailure(Call<DetailJadwalResponse> call, Throwable t) {
                Log.e(TAG,t.toString());
                onFinishedListenerr.onFailure(t);
            }
        });
    }

}
