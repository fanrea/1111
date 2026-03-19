package com.bytedance.rpc;

import com.bytedance.rpc.serialize.SerializeType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class RpcRequestModifier {
    protected long mConnectTimeout;
    protected long mReadTimeout;
    protected SerializeType mSerializeType;
    protected long mWriteTimeout;
    protected boolean mParamsNeed = true;
    protected boolean mRequestGzip = true;
    protected final String[] mUrls = new String[2];
    protected final Map<Integer, Map<String, String>> mOperatorHeader = new HashMap(2);
    protected final Map<Integer, Map<String, String>> mOperatorQuery = new HashMap(2);
    protected final Map<Integer, Map<String, String>> mOperatorField = new HashMap(2);

    RpcRequestModifier(c cVar) {
        RpcConfig rpcConfigB = cVar == null ? null : cVar.b();
        if (rpcConfigB != null) {
            updateConfig(rpcConfigB);
        }
    }

    void updateConfig(RpcConfig rpcConfig) {
        this.mConnectTimeout = rpcConfig.getConnectTimeout();
        this.mReadTimeout = rpcConfig.getReadTimeout();
        this.mWriteTimeout = rpcConfig.getWriteTimeout();
        this.mRequestGzip = rpcConfig.isRequestGzip();
        this.mUrls[0] = rpcConfig.getBaseUrl();
    }

    RpcRequestModifier reset(j jVar) {
        RpcRequestModifier rpcRequestModifierB = jVar.f().b();
        this.mConnectTimeout = rpcRequestModifierB.getConnectTimeout();
        this.mReadTimeout = rpcRequestModifierB.getReadTimeout();
        this.mWriteTimeout = rpcRequestModifierB.getWriteTimeout();
        this.mUrls[0] = rpcRequestModifierB.getBaseUrl();
        this.mUrls[1] = jVar.b();
        this.mParamsNeed = jVar.d();
        this.mSerializeType = jVar.e();
        this.mRequestGzip = jVar.f().a().isRequestGzip();
        resetOperator(rpcRequestModifierB.mOperatorHeader, this.mOperatorHeader, 0);
        resetOperator(rpcRequestModifierB.mOperatorHeader, this.mOperatorHeader, 1);
        resetOperator(rpcRequestModifierB.mOperatorQuery, this.mOperatorQuery, 0);
        resetOperator(rpcRequestModifierB.mOperatorQuery, this.mOperatorQuery, 1);
        resetOperator(rpcRequestModifierB.mOperatorField, this.mOperatorField, 0);
        resetOperator(rpcRequestModifierB.mOperatorField, this.mOperatorField, 1);
        return this;
    }

    public void setTimeout(long j, long j2, long j3) {
        this.mConnectTimeout = j;
        this.mReadTimeout = j2;
        this.mWriteTimeout = j3;
    }

    public void setBaseUrl(String str) {
        this.mUrls[0] = str;
    }

    public void setPathUrl(String str) {
        this.mUrls[1] = str;
    }

    public void addHeader(String str, String str2) {
        put(this.mOperatorHeader, str, str2);
    }

    public void setSerializeType(SerializeType serializeType) {
        if (serializeType != null) {
            this.mSerializeType = serializeType;
        }
    }

    public void setParamsNeed(boolean z) {
        this.mParamsNeed = z;
    }

    public void setRequestGzip(boolean z) {
        this.mRequestGzip = z;
    }

    public void addField(String str, String str2) {
        put(this.mOperatorField, str, str2);
    }

    public void addQuery(String str, String str2) {
        put(this.mOperatorQuery, str, str2);
    }

    long getConnectTimeout() {
        return this.mConnectTimeout;
    }

    long getReadTimeout() {
        return this.mReadTimeout;
    }

    long getWriteTimeout() {
        return this.mWriteTimeout;
    }

    String getBaseUrl() {
        return this.mUrls[0];
    }

    String getPathUrl() {
        return this.mUrls[1];
    }

    boolean isParamsNeed() {
        return this.mParamsNeed;
    }

    boolean isRequestGzip() {
        return this.mRequestGzip;
    }

    SerializeType getSerializeType() {
        return this.mSerializeType;
    }

    Map<String, String> applyHeader(Map<String, String> map) {
        return apply(this.mOperatorHeader, map);
    }

    Map<String, String> applyQuery(Map<String, String> map) {
        return apply(this.mOperatorQuery, map);
    }

    Map<String, String> applyField(Map<String, String> map) {
        return apply(this.mOperatorField, map);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.Object[] filterArgs(java.lang.Object[] r7, java.lang.annotation.Annotation[][] r8, java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            r6 = this;
            int r0 = r8.length
            r1 = 0
            r2 = r1
            r3 = r2
        L4:
            if (r2 >= r0) goto L31
            r4 = r8[r2]
            if (r4 == 0) goto L23
            int r5 = r4.length
            if (r5 <= 0) goto L23
            r4 = r4[r1]
            boolean r5 = r4 instanceof com.bytedance.rpc.annotation.i
            if (r5 == 0) goto L23
            com.bytedance.rpc.annotation.i r4 = (com.bytedance.rpc.annotation.i) r4
            java.lang.String r4 = r4.a()
            r5 = r7[r2]
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r9.put(r4, r5)
            goto L2e
        L23:
            r4 = r7[r2]
            boolean r5 = r4 instanceof java.lang.Class
            if (r5 != 0) goto L2e
            int r5 = r3 + 1
            r7[r3] = r4
            r3 = r5
        L2e:
            int r2 = r2 + 1
            goto L4
        L31:
            if (r3 > r0) goto L3b
            java.lang.Object[] r8 = new java.lang.Object[r3]
            if (r3 <= 0) goto L3a
            java.lang.System.arraycopy(r7, r1, r8, r1, r3)
        L3a:
            return r8
        L3b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.rpc.RpcRequestModifier.filterArgs(java.lang.Object[], java.lang.annotation.Annotation[][], java.util.Map):java.lang.Object[]");
    }

    protected Map<String, String> get(Integer num, Map<Integer, Map<String, String>> map) {
        Map<String, String> map2 = map.get(num);
        if (map2 != null) {
            return map2;
        }
        HashMap map3 = new HashMap(4);
        map.put(num, map3);
        return map3;
    }

    protected void put(Map<Integer, Map<String, String>> map, String str, String str2) {
        if (com.bytedance.sdk.djx.proguard3.c.d.b(str)) {
            Map<String, String> map2 = get(1, map);
            Map<String, String> map3 = get(0, map);
            if (str2 == null) {
                map2.remove(str);
                map3.put(str, "");
            } else {
                map3.remove(str);
                map2.put(str, str2);
            }
        }
    }

    private void resetOperator(Map<Integer, Map<String, String>> map, Map<Integer, Map<String, String>> map2, int i) {
        Map<String, String> map3 = map.get(Integer.valueOf(i));
        if (map3 == null || map3.isEmpty()) {
            Map<String, String> map4 = map2.get(Integer.valueOf(i));
            if (map4 != null) {
                map4.clear();
                return;
            }
            return;
        }
        Map<String, String> map5 = get(Integer.valueOf(i), map2);
        map5.clear();
        map5.putAll(map3);
    }

    private Map<String, String> apply(Map<Integer, Map<String, String>> map, Map<String, String> map2) {
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        Map<String, String> map3 = map.get(1);
        if (map3 != null && !map3.isEmpty()) {
            map2.putAll(map3);
        }
        Map<String, String> map4 = map.get(0);
        if (map4 != null && !map4.isEmpty()) {
            Iterator<String> it = map4.keySet().iterator();
            while (it.hasNext()) {
                map2.remove(it.next());
            }
        }
        return map2;
    }

    public com.bytedance.rpc.serialize.c applyBodyFromField(com.bytedance.rpc.serialize.c cVar) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.mOperatorField.get(1);
        if (map == null || map.isEmpty()) {
            return cVar;
        }
        if (cVar.a().length > 0) {
            sb.append(com.alipay.sdk.m.s.a.n);
        }
        for (String str : map.keySet()) {
            sb.append(str).append("=").append(map.get(str)).append(com.alipay.sdk.m.s.a.n);
        }
        byte[] bytes = sb.substring(0, sb.length() - 1).getBytes();
        byte[] bArr = new byte[cVar.a().length + bytes.length];
        System.arraycopy(cVar.a(), 0, bArr, 0, cVar.a().length);
        System.arraycopy(bytes, 0, bArr, cVar.a().length, bytes.length);
        return new com.bytedance.rpc.serialize.c(bArr, cVar.b());
    }
}
