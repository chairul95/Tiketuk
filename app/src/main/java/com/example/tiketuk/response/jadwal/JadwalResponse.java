
package com.example.tiketuk.response.jadwal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JadwalResponse {

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
