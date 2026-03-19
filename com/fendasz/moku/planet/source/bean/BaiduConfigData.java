package com.fendasz.moku.planet.source.bean;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BaiduConfigData implements Serializable {
    private static final long serialVersionUID = -245921663311494662L;
    private String appKey;
    private Boolean enable;
    private Integer id;
    private String sk;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String str) {
        this.appKey = str;
    }

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean bool) {
        this.enable = bool;
    }

    public String getSk() {
        return this.sk;
    }

    public void setSk(String str) {
        this.sk = str;
    }
}
