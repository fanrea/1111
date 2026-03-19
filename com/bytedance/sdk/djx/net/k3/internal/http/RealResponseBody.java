package com.bytedance.sdk.djx.net.k3.internal.http;

import com.bytedance.sdk.djx.net.io.BufferedSource;
import com.bytedance.sdk.djx.net.k3.MediaType;
import com.bytedance.sdk.djx.net.k3.ResponseBody;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = bufferedSource;
    }

    @Override // com.bytedance.sdk.djx.net.k3.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.djx.net.k3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // com.bytedance.sdk.djx.net.k3.ResponseBody
    public BufferedSource source() {
        return this.source;
    }
}
