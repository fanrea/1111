package com.duoyou.task.sdk.xutils.image;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class MemCacheKey {
    public final ImageOptions options;
    public final String url;

    public MemCacheKey(String str, ImageOptions imageOptions) {
        this.url = str;
        this.options = imageOptions;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MemCacheKey memCacheKey = (MemCacheKey) obj;
        if (this.url.equals(memCacheKey.url)) {
            return this.options.equals(memCacheKey.options);
        }
        return false;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + this.options.hashCode();
    }

    public String toString() {
        return this.url + this.options.toString();
    }
}
