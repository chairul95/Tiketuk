package com.example.tiketuk.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tiketuk.R;
import com.example.tiketuk.response.jadwal.Result;
import com.example.tiketuk.listener.AdapterClickListener;
import com.example.tiketuk.network.ApiClient;

import java.util.ArrayList;
import java.util.List;


public class JadwalAdapterRv extends RecyclerView.Adapter<JadwalAdapterRv.CustomViewHolder> {

    ApiClient apiClient;
    private ArrayList<Result> dataList;
    private List<Result> dataListFull;
    private Context context;
    private AdapterClickListener clickListener;


    public JadwalAdapterRv(Context context, ArrayList<Result> dataList,AdapterClickListener clickListener) {

        if (dataList == null) {
            return;
        }
        this.clickListener  = clickListener;
        this.context = context;
        this.dataList = dataList;
        dataListFull = new ArrayList<>(dataList);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        TextView tvJadwal;
        TextView tvAsaL;
        TextView tvTujuan;
        TextView tvStatus;



        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            tvAsaL = itemView.findViewById(R.id.tvAsal);
            tvJadwal = itemView.findViewById(R.id.tvJadwal);
            tvTujuan = itemView.findViewById(R.id.tvTujuan);
            tvStatus = itemView.findViewById(R.id.tvStatus);

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_jadwal, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Result data = dataList.get(position);

        holder.tvJadwal.setText(data.getJam());
        String dataKota[] = data.getRuteKota().split("-");
        holder.tvAsaL.setText(dataKota[0]);
        holder.tvTujuan.setText(dataKota[1]);
        holder.tvStatus.setText(data.getLayanan());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickListener.onItemClick(position);
            }
        });


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

    public void restoreItem(Result item, int position) {
        dataList.add(position, item);
        notifyItemInserted(position);
    }

    public ArrayList<Result> getData() {
        return dataList;
    }

}
