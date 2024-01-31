package com.example.tiketuk;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.tiketuk.adapter.JadwalAdapterRv;
import com.example.tiketuk.response.jadwal.Result;
import com.example.tiketuk.listener.AdapterClickListener;
import com.example.tiketuk.ui.jadwal.Jadwal;
import com.example.tiketuk.ui.jadwal.JadwaltPresenter;
import com.example.tiketuk.utils.KeyboardUtils;
import com.example.tiketuk.utils.SearchArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArmadaFragment extends Fragment implements Jadwal.View, AdapterClickListener {


    RecyclerView rvArmada;
    JadwalAdapterRv jadwalAdapterRv;
    private ArrayList<Result> dataJadwal;
    JadwaltPresenter jadwaltPresenter;
    private AutoCompleteTextView edtSearch;
    AdapterClickListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_armada,container, false);

        listener = new AdapterClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent detailIntent = new Intent(getActivity(), DetailJadwalActivity.class);
                detailIntent.putExtra("rute", dataJadwal.get(position).getRute());
                detailIntent.putExtra("detail_rute", dataJadwal.get(position).getDetailRute());
                detailIntent.putExtra("jam", dataJadwal.get(position).getJam());
                detailIntent.putExtra("status", dataJadwal.get(position).getLayanan());
                startActivity(detailIntent);
            }
        };
        initUI(view);
        listener();

        jadwaltPresenter = new JadwaltPresenter(this);
        jadwaltPresenter.requestData();

        return view;
    }

    private void listener() {
        edtSearch.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                edtSearch.requestFocus();
                edtSearch.setText("");
                return false;
            }
        });
        KeyboardUtils.addKeyboardToggleListener(getActivity(), new KeyboardUtils.SoftKeyboardToggleListener() {
            @Override
            public void onToggleSoftKeyboard(boolean isVisible) {
                Log.d("keyboard", "keyboard visible: " + isVisible);
                if (isVisible == false) {
                    edtSearch.clearFocus();
                }
            }
        });

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                }
                return false;
            }
        });

        edtSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (edtSearch.getText().toString().equals("") || edtSearch.getText().toString().equals(null))
                    return;

                if (edtSearch.getText().toString().trim().length() < 3)
                    return;

            }
        });


    }

    private void initUI(View view) {
        dataJadwal = new ArrayList<>();
        rvArmada = view.findViewById(R.id.rvArmada);
        jadwalAdapterRv = new JadwalAdapterRv(getActivity(), dataJadwal,listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvArmada.setLayoutManager(layoutManager);
        rvArmada.setAdapter(jadwalAdapterRv);

        edtSearch = view.findViewById(R.id.edt_search);
        edtSearch.clearFocus();


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setData(List<Result> JadwalList) {
        setSerachView(JadwalList);
        dataJadwal.addAll(JadwalList);
        jadwalAdapterRv.notifyDataSetChanged();

    }

    @Override
    public void onResponseFailure(Throwable t) {

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(getActivity(), DetailJadwalActivity.class);
        detailIntent.putExtra("rute", dataJadwal.get(position).getRute());
        detailIntent.putExtra("detail_rute", dataJadwal.get(position).getDetailRute());
        detailIntent.putExtra("jam", dataJadwal.get(position).getJam());
        detailIntent.putExtra("status", dataJadwal.get(position).getLayanan());
        startActivity(detailIntent);
    }


    protected void setSerachView(List<Result> result) {
        try {
            if (edtSearch == null)
                return;

            List<String> src = new ArrayList<String>();
            for (int i=0;i<result.size();i++){
                src.add(result.get(i).getRute());
            }
            Collections.sort(src);

            SearchArrayAdapter saa = new SearchArrayAdapter(getActivity(), R.layout.cmp_listitem, src);
            edtSearch.setAdapter(saa);
        } finally {

        }
    }
}