package com.pandora.ttlicense2.utils;

import com.alipay.sdk.m.l.a;
import com.sigmob.sdk.base.n;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public enum Scheme {
    HTTP(a.r),
    HTTPS("https"),
    FILE(n.z),
    ASSETS("assets"),
    UNKNOWN("");

    private String scheme;
    private String uriPrefix;

    Scheme(String scheme) {
        this.scheme = scheme;
        this.uriPrefix = scheme + "://";
    }

    public static Scheme ofUri(String uri) {
        if (uri != null) {
            for (Scheme scheme : values()) {
                if (scheme.belongsTo(uri)) {
                    return scheme;
                }
            }
        }
        return UNKNOWN;
    }

    private boolean belongsTo(String uri) {
        return uri.startsWith(this.uriPrefix);
    }

    public String wrap(String path) {
        return this.uriPrefix + path;
    }

    public String crop(String uri) {
        if (!belongsTo(uri)) {
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", uri, this.scheme));
        }
        return uri.substring(this.uriPrefix.length());
    }
}
