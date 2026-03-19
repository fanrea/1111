package com.bytedance.adsdk.d.d;

import com.bytedance.adsdk.d.d.d.tt;
import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d extends b<com.bytedance.adsdk.d.d.d.hc> {
    public d(com.bytedance.adsdk.d.d.b.hc hcVar) {
        super(hcVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.d.d.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.d.d.d.hc hc(com.bytedance.adsdk.d.d.b.hc hcVar, tt.d dVar) {
        return new com.bytedance.adsdk.d.d.d.hc(hcVar, dVar);
    }

    public static d d(final ByteBuffer byteBuffer) {
        return new d(new com.bytedance.adsdk.d.d.b.d() { // from class: com.bytedance.adsdk.d.d.d.1
            @Override // com.bytedance.adsdk.d.d.b.d
            public ByteBuffer d() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }
}
