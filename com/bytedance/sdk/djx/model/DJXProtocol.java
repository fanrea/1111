package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXProtocol {
    public static final int TYPE_PAY = 2;
    public static final int TYPE_RENEWAL = 3;
    public static final int TYPE_USER = 1;
    public int id;
    public boolean isSigned;
    public String name;
    public int type;
    public String url;

    public String toString() {
        return "DJXProtocol{id=" + this.id + ", url='" + this.url + "', name='" + this.name + "', type=" + this.type + ", isSigned=" + this.isSigned + '}';
    }
}
