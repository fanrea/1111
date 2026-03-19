package com.alliance.ssp.ad.bean;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SAAllianceEngineData {
    private List<SAAllianceAdData> data;
    private String message;
    private boolean flag = false;
    private int code = 0;

    public int getCode() {
        return this.code;
    }

    public List<SAAllianceAdData> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<SAAllianceAdData> list) {
        this.data = list;
    }

    public void setFlag(boolean z) {
        this.flag = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
