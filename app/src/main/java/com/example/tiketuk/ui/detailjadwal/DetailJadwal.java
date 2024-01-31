package com.example.tiketuk.ui.detailjadwal;




import com.example.tiketuk.response.detailjadwal.DetailResult;

import java.util.List;

public interface DetailJadwal {

    interface Model {
        interface OnFinishedListener{
            void onFinished(List<DetailResult> JadwalList);

            void onFailure(Throwable t);
        }

        void getDataList(OnFinishedListener onFinishedListener);
    }

    interface View {

        void showProgress();
        void hideProgress();
        void setData(List<DetailResult> JadwalList);
        void onResponseFailure(Throwable t);

    }

    interface Presenter{

        void onDestroy();
        void requestData();
    }
}
