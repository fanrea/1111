package com.bytedance.rpc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RpcConfig {
    public static final int BASEURL = 8;
    public static final int GZIP = 16;
    public static final int HEADERS = 2;
    public static final int QUERIES = 4;
    public static final int TIMEOUT = 1;
    private String mBaseUrl;
    private int mChangedFlag;
    private long mConnectTimeout;
    private Map<String, String> mHeaders;
    private Map<String, String> mQueries;
    private long mReadTimeout;
    private boolean mRequestGzip;
    private long mWriteTimeout;

    private RpcConfig(a aVar) {
        this.mChangedFlag = 0;
        this.mConnectTimeout = aVar.d;
        this.mReadTimeout = aVar.e;
        this.mWriteTimeout = aVar.f;
        this.mBaseUrl = aVar.a;
        this.mHeaders = aVar.b;
        this.mQueries = aVar.c;
        this.mRequestGzip = aVar.g;
    }

    public long getConnectTimeout() {
        return this.mConnectTimeout;
    }

    public long getReadTimeout() {
        return this.mReadTimeout;
    }

    public long getWriteTimeout() {
        return this.mWriteTimeout;
    }

    public boolean isRequestGzip() {
        return this.mRequestGzip;
    }

    public String getBaseUrl() {
        return this.mBaseUrl;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public Map<String, String> getQueries() {
        return this.mQueries;
    }

    public a toBuilder() {
        return new a();
    }

    public boolean equals(Object obj) {
        boolean zEquals = super.equals(obj);
        if (zEquals || !(obj instanceof RpcConfig)) {
            return zEquals;
        }
        RpcConfig rpcConfig = (RpcConfig) obj;
        return this.mConnectTimeout == rpcConfig.mConnectTimeout && this.mReadTimeout == rpcConfig.mReadTimeout && this.mWriteTimeout == rpcConfig.mWriteTimeout && this.mRequestGzip == rpcConfig.mRequestGzip && TextUtils.equals(this.mBaseUrl, rpcConfig.mBaseUrl) && equalOfSimpleObject(this.mHeaders, rpcConfig.mHeaders) && equalOfSimpleObject(this.mQueries, rpcConfig.mQueries);
    }

    int computeChangedFlag(RpcConfig rpcConfig, boolean z) {
        if (rpcConfig == null) {
            return 31;
        }
        int i = equalOfSimpleObject(this.mBaseUrl, rpcConfig.mBaseUrl) ? 0 : 8;
        if (!equalOfSimpleObject(this.mHeaders, rpcConfig.mHeaders)) {
            i |= 2;
        }
        if (!equalOfSimpleObject(this.mQueries, rpcConfig.mQueries)) {
            i |= 4;
        }
        if (this.mConnectTimeout != rpcConfig.mConnectTimeout || this.mReadTimeout != rpcConfig.mReadTimeout || this.mWriteTimeout != rpcConfig.mWriteTimeout) {
            i |= 1;
        }
        if (this.mRequestGzip != rpcConfig.mRequestGzip) {
            i |= 16;
        }
        if (z && i != 0) {
            this.mChangedFlag = i;
        }
        return i;
    }

    public final boolean changed(int i) {
        return (i == 0 || (i & this.mChangedFlag) == 0) ? false : true;
    }

    private boolean equalOfSimpleObject(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return (obj == null || obj2 == null || !obj.equals(obj2)) ? false : true;
    }

    public String toString() {
        return "RpcConfig{mBaseUrl='" + this.mBaseUrl + "', mHeaders=" + this.mHeaders + ", mQueries=" + this.mQueries + ", mConnectTimeout=" + this.mConnectTimeout + ", mReadTimeout=" + this.mReadTimeout + ", mWriteTimeout=" + this.mWriteTimeout + ", mRequestGzip=" + this.mRequestGzip + ", mChangedFlag=" + this.mChangedFlag + '}';
    }

    public static class a {
        private String a;
        private Map<String, String> b;
        private Map<String, String> c;
        private long d;
        private long e;
        private long f;
        private boolean g;

        private a a() {
            return this;
        }

        private void b() {
        }

        private a(RpcConfig rpcConfig) {
            this.d = rpcConfig.mConnectTimeout;
            this.e = rpcConfig.mReadTimeout;
            this.f = rpcConfig.mWriteTimeout;
            this.a = rpcConfig.mBaseUrl;
            this.g = rpcConfig.mRequestGzip;
            this.b = new HashMap(rpcConfig.mHeaders);
            this.c = new HashMap(rpcConfig.mQueries);
        }

        a() {
            this.b = new HashMap();
            this.c = new HashMap();
        }

        public a a(boolean z) {
            this.g = z;
            return a();
        }

        public a a(String str) {
            this.a = str;
            return a();
        }

        public RpcConfig a(RpcConfig... rpcConfigArr) {
            b();
            if (rpcConfigArr == null || rpcConfigArr.length == 0) {
                return new RpcConfig(this);
            }
            for (RpcConfig rpcConfig : rpcConfigArr) {
                rpcConfig.mConnectTimeout = this.d;
                rpcConfig.mReadTimeout = this.e;
                rpcConfig.mWriteTimeout = this.f;
                rpcConfig.mBaseUrl = this.a;
                rpcConfig.mHeaders = this.b;
                rpcConfig.mQueries = this.c;
                rpcConfig.mRequestGzip = this.g;
            }
            return rpcConfigArr[0];
        }
    }
}
