package com.bytedance.sdk.component.h.d;

import android.util.Base64;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.c.d.d {
    @Override // com.bytedance.sdk.component.c.d.d
    public int d() {
        return 32;
    }

    @Override // com.bytedance.sdk.component.c.d.d
    public <T> String d(T t) {
        return Base64.encodeToString(t.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.bytedance.sdk.component.c.d.d
    public <T> T hc(T t) {
        return (T) new String(Base64.decode(t.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }
}
