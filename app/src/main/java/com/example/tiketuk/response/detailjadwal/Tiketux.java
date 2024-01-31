
package com.example.tiketuk.response.detailjadwal;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tiketux {

    @SerializedName("result")
    @Expose
    private List<DetailResult> result;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("time")
    @Expose
    private String time;

    public List<DetailResult> getResult() {
        return result;
    }

    public void setResult(List<DetailResult> result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
