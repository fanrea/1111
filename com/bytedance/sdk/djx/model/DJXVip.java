package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXVip {
    public boolean isVip = false;
    public long startTime = 0;
    public long endTime = 0;
    public int renewalStatus = 0;
    public long nextRenewalTime = 0;
    public String comboName = "";
    public long renewalId = 0;

    public String toString() {
        return "DJXVip{isVip=" + this.isVip + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", renewalStatus=" + this.renewalStatus + ", nextRenewalTime=" + this.nextRenewalTime + ", comboDesc='" + this.comboName + "', renewalId=" + this.renewalId + '}';
    }
}
