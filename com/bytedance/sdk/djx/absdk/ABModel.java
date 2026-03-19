package com.bytedance.sdk.djx.absdk;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ABModel {
    private final ABCache mCache = new ABCache();

    public void refresh(String str, String str2) {
        this.mCache.save(str, str2);
    }

    public void clear(String str) {
        this.mCache.clear(str);
    }

    public String getData(String str) {
        return this.mCache.getData(str);
    }
}
