
package com.example.tiketuk.response.detailjadwal;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailResult {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("rute")
    @Expose
    private String rute;
    @SerializedName("tarif")
    @Expose
    private Integer tarif;
    @SerializedName("tarif_str")
    @Expose
    private String tarifStr;
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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getRute() {
        return rute;
    }

    public void setRute(String rute) {
        this.rute = rute;
    }

    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
    }

    public String getTarifStr() {
        return tarifStr;
    }

    public void setTarifStr(String tarifStr) {
        this.tarifStr = tarifStr;
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
