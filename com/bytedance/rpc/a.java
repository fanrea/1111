package com.bytedance.rpc;

import com.bytedance.rpc.serialize.SerializeType;
import java.util.Iterator;
import java.util.Map;

/* compiled from: RequestModifier.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class a extends RpcRequestModifier {
    private int a;

    a() {
        super(null);
        this.a = 0;
    }

    void a(RpcRequestModifier rpcRequestModifier) {
        int i = this.a;
        if (i != 0) {
            if ((i & 2) == 2 && !this.mOperatorHeader.isEmpty()) {
                a(this.mOperatorHeader, rpcRequestModifier.mOperatorHeader);
            }
            if ((this.a & 1) == 1 && !this.mOperatorQuery.isEmpty()) {
                a(this.mOperatorQuery, rpcRequestModifier.mOperatorQuery);
            }
            if ((this.a & 4) == 4 && !this.mOperatorField.isEmpty()) {
                a(this.mOperatorField, rpcRequestModifier.mOperatorField);
            }
            if ((this.a & 8) == 8) {
                rpcRequestModifier.mParamsNeed = this.mParamsNeed;
            }
            if ((this.a & 16) == 16) {
                rpcRequestModifier.mRequestGzip = this.mRequestGzip;
            }
            if ((this.a & 32) == 32) {
                rpcRequestModifier.setBaseUrl(this.mUrls[0]);
            }
            if ((this.a & 64) == 64) {
                rpcRequestModifier.setPathUrl(this.mUrls[1]);
            }
            if ((this.a & 128) == 128) {
                rpcRequestModifier.mConnectTimeout = this.mConnectTimeout;
                rpcRequestModifier.mReadTimeout = this.mReadTimeout;
                rpcRequestModifier.mWriteTimeout = this.mWriteTimeout;
            }
            if ((this.a & 256) == 256 && this.mSerializeType != null) {
                rpcRequestModifier.mSerializeType = this.mSerializeType;
            }
        }
        this.a = 0;
    }

    private void a(Map<Integer, Map<String, String>> map, Map<Integer, Map<String, String>> map2) {
        Iterator<String> it = get(0, map).keySet().iterator();
        while (it.hasNext()) {
            put(map2, it.next(), null);
        }
        for (Map.Entry<String, String> entry : get(1, map).entrySet()) {
            put(map2, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setTimeout(long j, long j2, long j3) {
        super.setTimeout(j, j2, j3);
        this.a |= 128;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setBaseUrl(String str) {
        super.setBaseUrl(str);
        this.a |= 32;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setPathUrl(String str) {
        super.setPathUrl(str);
        this.a |= 64;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void addHeader(String str, String str2) {
        super.addHeader(str, str2);
        this.a |= 2;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setSerializeType(SerializeType serializeType) {
        super.setSerializeType(serializeType);
        this.a |= 256;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setParamsNeed(boolean z) {
        super.setParamsNeed(z);
        this.a |= 8;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void setRequestGzip(boolean z) {
        super.setRequestGzip(z);
        this.a |= 16;
    }

    @Override // com.bytedance.rpc.RpcRequestModifier
    public void addQuery(String str, String str2) {
        super.addQuery(str, str2);
        this.a |= 1;
    }

    public boolean a() {
        return this.a != 0;
    }
}
