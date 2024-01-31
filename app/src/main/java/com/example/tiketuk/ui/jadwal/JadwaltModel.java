package com.example.tiketuk.ui.jadwal;

import android.util.Log;

import com.example.tiketuk.response.jadwal.JadwalResponse;
import com.example.tiketuk.response.jadwal.Result;
import com.example.tiketuk.network.ApiClient;
import com.example.tiketuk.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JadwaltModel implements Jadwal.Model {

    private final String TAG = "check JadwalModel";
    @Override
    public void getDataList(OnFinishedListener onFinishedListenerr) {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<JadwalResponse> call = apiInterface.getJadwal();
        call.enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                List<Result> jadwalList = response.body().getTiketux().getResult();
                Log.d(TAG, "Data Size: " + jadwalList.size());

                onFinishedListenerr.onFinished(jadwalList);

            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {
                Log.e(TAG,t.toString());
                onFinishedListenerr.onFailure(t);
            }
        });
    }

}
