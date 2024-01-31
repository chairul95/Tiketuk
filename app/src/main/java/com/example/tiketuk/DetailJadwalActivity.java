package com.example.tiketuk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tiketuk.adapter.DetailJadwalAdapterRv;
import com.example.tiketuk.adapter.JadwalAdapterRv;
import com.example.tiketuk.response.detailjadwal.DetailResult;
import com.example.tiketuk.response.jadwal.Result;
import com.example.tiketuk.ui.detailjadwal.DetailJadwal;
import com.example.tiketuk.ui.detailjadwal.DetailJadwaltPresenter;

import java.util.ArrayList;
import java.util.List;

public class DetailJadwalActivity extends AppCompatActivity implements DetailJadwal.View {

    String rute[];
    String detailRute;
    String status;
    String jam;
    TextView tvJadwal;
    TextView tvAsal;
    TextView tvTujuan;
    TextView tvStatus;
    TextView tvDetailRute;
    TextView tvJudul;
    LinearLayout lnContent;
    LinearLayout lnBack;
    DetailJadwalAdapterRv detailJadwalAdapterRv;
    private ArrayList<DetailResult> dataDetailJadwal;
    RecyclerView rvDetailJadwal;

    DetailJadwaltPresenter detailJadwaltPresenter;

    private boolean isOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jadwal);

        Intent mIntent = getIntent();
         jam = mIntent.getStringExtra("jam");
         rute = mIntent.getStringExtra("rute").split("-");
         detailRute = mIntent.getStringExtra("detail_rute");
         status = mIntent.getStringExtra("status");

         initUI();
         listener();
        detailJadwaltPresenter = new DetailJadwaltPresenter(this);
        detailJadwaltPresenter.requestData();

    }

    private void listener() {
        tvJudul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    lnContent.setVisibility(View.GONE);
                    rvDetailJadwal.setVisibility(View.GONE);
                    isOpen = false;
                    return;
                }
                else {
                    lnContent.setVisibility(View.VISIBLE);
                    rvDetailJadwal.setVisibility(View.VISIBLE);
                    isOpen = true;
                    return;
                }
            }
        });
        lnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initUI() {
        dataDetailJadwal = new ArrayList<>();

        tvJadwal = findViewById(R.id.tvJadwal);
        tvAsal = findViewById(R.id.tvAsal);
        tvTujuan = findViewById(R.id.tvTujuan);
        tvStatus = findViewById(R.id.tvStatus);
        tvDetailRute = findViewById(R.id.tvJalur);
        lnContent = findViewById(R.id.lnContent);
        lnBack = findViewById(R.id.lnBack);
        tvJudul = findViewById(R.id.tvJudul);
        rvDetailJadwal = findViewById(R.id.rvDetailJadwal);
        detailJadwalAdapterRv = new DetailJadwalAdapterRv(this, dataDetailJadwal);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvDetailJadwal.setLayoutManager(layoutManager);
        rvDetailJadwal.setAdapter(detailJadwalAdapterRv);

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setData(List<DetailResult> JadwalList) {
        tvJadwal.setText(jam);
        tvAsal.setText(rute[0]);
        tvTujuan.setText(rute[1]);
        tvStatus.setText(status);
        tvDetailRute.setText(detailRute);
        dataDetailJadwal.addAll(JadwalList);
        detailJadwalAdapterRv.notifyDataSetChanged();
    }

    @Override
    public void onResponseFailure(Throwable t) {

    }
}