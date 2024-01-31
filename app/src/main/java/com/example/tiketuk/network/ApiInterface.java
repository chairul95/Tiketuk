package com.example.tiketuk.network;

import com.example.tiketuk.response.detailjadwal.DetailJadwalResponse;
import com.example.tiketuk.response.jadwal.JadwalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("jadwal.json")
    Call<JadwalResponse> getJadwal();

    @GET("jadwal-tujuan.json")
    Call<DetailJadwalResponse> getDetailJadwal();

}
