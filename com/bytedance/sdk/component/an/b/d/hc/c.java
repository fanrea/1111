package com.bytedance.sdk.component.an.b.d.hc;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.an.yo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements yo {
    private final yo d;
    private final com.bytedance.sdk.component.an.b.d.hc hc;

    public c(yo yoVar) {
        this(yoVar, null);
    }

    public c(yo yoVar, com.bytedance.sdk.component.an.b.d.hc hcVar) {
        this.d = yoVar;
        this.hc = hcVar;
    }

    @Override // com.bytedance.sdk.component.an.d
    public boolean d(String str, Bitmap bitmap) {
        boolean zD = this.d.d(str, bitmap);
        if (this.hc != null) {
            Boolean.valueOf(zD);
        }
        return zD;
    }

    @Override // com.bytedance.sdk.component.an.d
    public Bitmap d(String str) {
        return this.d.d((yo) str);
    }

    @Override // com.bytedance.sdk.component.an.d
    public boolean hc(String str) {
        return this.d.hc(str);
    }

    @Override // com.bytedance.sdk.component.an.d
    public void d(double d) {
        this.d.d(d);
    }
}
