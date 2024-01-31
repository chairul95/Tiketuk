
package com.example.tiketuk.response.detailjadwal;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailJadwalResponse {

    @SerializedName("tiketux")
    @Expose
    private Tiketux tiketux;

    public Tiketux getTiketux() {
        return tiketux;
    }

    public void setTiketux(Tiketux tiketux) {
        this.tiketux = tiketux;
    }

}
