package com.example.tiketuk.ui.jadwal;



import com.example.tiketuk.response.jadwal.Result;

import java.util.List;

public interface Jadwal {

    interface Model {
        interface OnFinishedListener{
            void onFinished(List<Result> JadwalList);

            void onFailure(Throwable t);
        }

        void getDataList(OnFinishedListener onFinishedListener);
    }

    interface View {

        void showProgress();
        void hideProgress();
        void setData(List<Result> JadwalList);
        void onResponseFailure(Throwable t);

    }

    interface Presenter{

        void onDestroy();
        void requestData();
    }
}
