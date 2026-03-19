package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXOrder {
    public DJXCombo combo;
    public String desc;
    public DJXDrama drama;
    public String name;
    public String orderId;
    public int status;
    public long time;

    public String toString() {
        return "DJXOrder{orderId='" + this.orderId + "', status=" + this.status + ", name='" + this.name + "', desc='" + this.desc + "', time=" + this.time + ", combo=" + this.combo + ", drama=" + this.drama + '}';
    }
}
