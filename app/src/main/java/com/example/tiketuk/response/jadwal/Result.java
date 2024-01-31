
package com.example.tiketuk.response.jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("id_rute")
    @Expose
    private String idRute;
    @SerializedName("kode_jadwal")
    @Expose
    private String kodeJadwal;
    @SerializedName("rute")
    @Expose
    private String rute;
    @SerializedName("rute_kota")
    @Expose
    private String ruteKota;
    @SerializedName("detail_rute")
    @Expose
    private String detailRute;
    @SerializedName("list_outlet_transit")
    @Expose
    private String listOutletTransit;
    @SerializedName("list_outlet_pickup")
    @Expose
    private String listOutletPickup;
    @SerializedName("list_outlet_dropoff")
    @Expose
    private String listOutletDropoff;
    @SerializedName("jam")
    @Expose
    private String jam;
    @SerializedName("keterangan")
    @Expose
    private String keterangan;
    @SerializedName("layanan")
    @Expose
    private String layanan;
    @SerializedName("armada")
    @Expose
    private String armada;
    @SerializedName("kapasitas")
    @Expose
    private Integer kapasitas;
    @SerializedName("terisi")
    @Expose
    private Integer terisi;
    @SerializedName("tersedia")
    @Expose
    private Integer tersedia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdRute() {
        return idRute;
    }

    public void setIdRute(String idRute) {
        this.idRute = idRute;
    }

    public String getKodeJadwal() {
        return kodeJadwal;
    }

    public void setKodeJadwal(String kodeJadwal) {
        this.kodeJadwal = kodeJadwal;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public String getRuteKota() {
        return ruteKota;
    }

    public void setRuteKota(String ruteKota) {
        this.ruteKota = ruteKota;
    }

    public String getDetailRute() {
        return detailRute;
    }

    public void setDetailRute(String detailRute) {
        this.detailRute = detailRute;
    }

    public String getListOutletTransit() {
        return listOutletTransit;
    }

    public void setListOutletTransit(String listOutletTransit) {
        this.listOutletTransit = listOutletTransit;
    }

    public String getListOutletPickup() {
        return listOutletPickup;
    }

    public void setListOutletPickup(String listOutletPickup) {
        this.listOutletPickup = listOutletPickup;
    }

    public String getListOutletDropoff() {
        return listOutletDropoff;
    }

    public void setListOutletDropoff(String listOutletDropoff) {
        this.listOutletDropoff = listOutletDropoff;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getLayanan() {
        return layanan;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    public String getArmada() {
        return armada;
    }

    public void setArmada(String armada) {
        this.armada = armada;
    }

    public Integer getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(Integer kapasitas) {
        this.kapasitas = kapasitas;
    }

    public Integer getTerisi() {
        return terisi;
    }

    public void setTerisi(Integer terisi) {
        this.terisi = terisi;
    }

    public Integer getTersedia() {
        return tersedia;
    }

    public void setTersedia(Integer tersedia) {
        this.tersedia = tersedia;
    }

}
