package com.example.tiketuk.ui.jadwal;


import com.example.tiketuk.response.jadwal.Result;

import java.util.List;

public class JadwaltPresenter implements Jadwal.Presenter, Jadwal.Model.OnFinishedListener{

    private Jadwal.View JadwalView;
    private Jadwal.Model JadwalModel;

    public JadwaltPresenter(Jadwal.View JadwalView){
        this.JadwalView = JadwalView;
        JadwalModel = new JadwaltModel();
    }

    @Override
    public void onFinished(List<Result> DataJawal) {
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
