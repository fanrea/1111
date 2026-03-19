package com.bytedance.sdk.component.an.c;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.an.k;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u extends d {
    private byte[] d;
    private com.bytedance.sdk.component.an.an hc;

    @Override // com.bytedance.sdk.component.an.c.tt
    public String d() {
        return "decode";
    }

    public u(byte[] bArr, com.bytedance.sdk.component.an.an anVar) {
        this.d = bArr;
        this.hc = anVar;
    }

    @Override // com.bytedance.sdk.component.an.c.tt
    public void d(com.bytedance.sdk.component.an.b.b bVar) {
        com.bytedance.sdk.component.an.b.an anVarJh = bVar.jh();
        com.bytedance.sdk.component.an.b.hc.d dVarD = anVarJh.d(bVar);
        try {
            k kVarV = bVar.v();
            if (kVarV != null) {
                kVarV.d(10, null);
            }
            Bitmap bitmapD = dVarD.d(this.d);
            if (bitmapD != null) {
                bVar.d(new uo(bitmapD, this.d, this.hc, false));
                anVarJh.d(bVar.sy()).d(bVar.h(), bitmapD);
            } else {
                d(1002, "decode failed bitmap null", null, bVar);
            }
            if (kVarV != null) {
                kVarV.d(11, bitmapD);
            }
        } catch (Throwable th) {
            d(1002, "decode failed:" + th.getMessage(), th, bVar);
        }
    }

    private void d(int i, String str, Throwable th, com.bytedance.sdk.component.an.b.b bVar) {
        if (this.hc == null) {
            bVar.d(new mk());
        } else {
            bVar.d(new gb(i, str, th));
        }
    }
}
