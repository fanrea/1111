package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class ReportModel {
    private String mReportDesc;
    private int mReportType;

    public ReportModel(int i, String str) {
        this.mReportType = i;
        this.mReportDesc = str;
    }

    public int getReportType() {
        return this.mReportType;
    }

    public void setReportType(int i) {
        this.mReportType = i;
    }

    public String getReportDesc() {
        return this.mReportDesc;
    }

    public void setReportDesc(String str) {
        this.mReportDesc = str;
    }
}
