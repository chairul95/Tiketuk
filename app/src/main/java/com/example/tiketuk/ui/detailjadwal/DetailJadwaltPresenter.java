package com.example.tiketuk.ui.detailjadwal;


import com.example.tiketuk.response.detailjadwal.DetailResult;
import com.example.tiketuk.response.jadwal.Result;
import com.example.tiketuk.ui.jadwal.Jadwal;
import com.example.tiketuk.ui.jadwal.JadwaltModel;

import java.util.List;

public class DetailJadwaltPresenter implements DetailJadwal.Presenter, DetailJadwal.Model.OnFinishedListener{

    private DetailJadwal.View JadwalView;
    private DetailJadwal.Model JadwalModel;

    public DetailJadwaltPresenter(DetailJadwal.View JadwalView){
        this.JadwalView = JadwalView;
        JadwalModel = new DetailJadwaltModel();
    }

    @Override
    public void onFinished(List<DetailResult> DataJawal) {
        JadwalView.setData(DataJawal);
        if (JadwalView != null) {
            JadwalView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        JadwalView.onResponseFailure(t);
        if (JadwalView != null) {
            JadwalView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        this.JadwalView = null;
    }


    @Override
    public void requestData() {
        if (JadwalView != null) {
            JadwalView.showProgress();
        }
        JadwalModel.getDataList(this);
    }
}
