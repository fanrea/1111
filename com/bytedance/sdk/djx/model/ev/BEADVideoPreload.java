package com.bytedance.sdk.djx.model.ev;

import com.bytedance.sdk.djx.utils.bus.BusEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class BEADVideoPreload extends BusEvent {
    private String mKey;
    private long mSize;
    private String mUrl;

    public static BEADVideoPreload build(String str, String str2, long j) {
        return new BEADVideoPreload(str, str2, j);
    }

    public BEADVideoPreload(String str, String str2, long j) {
        this.mKey = str;
        this.mUrl = str2;
        this.mSize = j;
    }

    public String getKey() {
        return this.mKey;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public long getSize() {
        return this.mSize;
    }
}
