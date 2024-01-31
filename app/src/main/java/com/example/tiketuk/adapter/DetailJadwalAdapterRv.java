package com.example.tiketuk.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tiketuk.R;
import com.example.tiketuk.listener.AdapterClickListener;
import com.example.tiketuk.network.ApiClient;
import com.example.tiketuk.response.detailjadwal.DetailResult;
import com.example.tiketuk.response.jadwal.Result;

import java.util.ArrayList;
import java.util.List;


public class DetailJadwalAdapterRv extends RecyclerView.Adapter<DetailJadwalAdapterRv.CustomViewHolder> {

    ApiClient apiClient;
    private ArrayList<DetailResult> dataList;
    private List<DetailResult> dataListFull;
    private Context context;


    public DetailJadwalAdapterRv(Context context, ArrayList<DetailResult> dataList) {

        if (dataList == null) {
            return;
        }
        this.context = context;
        this.dataList = dataList;
        dataListFull = new ArrayList<>(dataList);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView tvHargas;
        TextView tvTujuans;
        TextView tvKursis;



        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            tvHargas = itemView.findViewById(R.id.tvHarga);
            tvTujuans = itemView.findViewById(R.id.tvTujuan);
            tvKursis = itemView.findViewById(R.id.tvKursi);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_detail_jadwal, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

        DetailResult data = dataList.get(position);

        holder.tvTujuans.setText(data.getNama());
        holder.tvKursis.setText(data.getTersedia().toString());
        holder.tvHargas.setText(data.getTarif().toString());

    }


    @Override
    public int getItemCount() {
        return (dataList == null) ? 0 : dataList.size();
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void removeItem(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(DetailResult item, int position) {
        dataList.add(position, item);
        notifyItemInserted(position);
    }

    public ArrayList<DetailResult> getData() {
        return dataList;
    }

}
