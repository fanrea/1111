package com.kwad.sdk.api.model.liveModel;

import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KsLiveShopInfo implements Serializable {
    private static final long serialVersionUID = 3745132899544688647L;
    private boolean haveCoupon;
    private String icon;
    private String name;
    private String originPrice;
    private String price;
    private String volume;

    public boolean isHaveCoupon() {
        return this.haveCoupon;
    }

    public void setHaveCoupon(boolean z) {
        this.haveCoupon = z;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public String getOriginPrice() {
        return this.originPrice;
    }

    public void setOriginPrice(String str) {
        this.originPrice = str;
    }

    public String getVolume() {
        return this.volume;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "KsLiveShopInfo{icon='" + this.icon + "', name='" + this.name + "', price='" + this.price + "', originPrice='" + this.originPrice + "', volume='" + this.volume + "', haveCoupon=" + this.haveCoupon + '}';
    }
}
