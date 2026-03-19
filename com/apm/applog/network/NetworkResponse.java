package com.apm.applog.network;

import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class NetworkResponse {
    public Map<String, String> headers;
    public byte[] responseBytes;
    public int statusCode;

    public NetworkResponse(int i, byte[] bArr) {
        this.statusCode = i;
        this.responseBytes = bArr;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public byte[] getResponseBytes() {
        return this.responseBytes;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public NetworkResponse(int i, Map<String, String> map, byte[] bArr) {
        this.statusCode = i;
        this.headers = map;
        this.responseBytes = bArr;
    }
}
