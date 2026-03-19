package com.kuaishou.security.kste.logic.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class ForwardBiz {
    public String appkey;
    public String bizId;
    public String kpn;

    public ForwardBiz(String str, String str2, String str3) {
        this.bizId = str;
        this.appkey = str2;
        this.kpn = str3;
    }

    public String getAppkey() {
        return this.appkey;
    }

    public String getBizId() {
        return this.bizId;
    }

    public String getKpn() {
        return this.kpn;
    }

    public void setAppkey(String str) {
        this.appkey = str;
    }

    public void setBizId(String str) {
        this.bizId = str;
    }

    public void setKpn(String str) {
        this.kpn = str;
    }
}
