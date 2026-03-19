package com.fc.tjcpl.sdk.n;

import android.net.Uri;
import android.webkit.ValueCallback;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class h0 {
    public a a;
    public ValueCallback<Uri> b;
    public ValueCallback<Uri[]> c;
    public final int d = com.fc.tjcpl.sdk.b.a.b().getResources().getDisplayMetrics().widthPixels;

    public h0(a aVar) {
        this.a = aVar;
    }

    public final void a() {
        ValueCallback<Uri> valueCallback = this.b;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.b = null;
        }
        ValueCallback<Uri[]> valueCallback2 = this.c;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
            this.c = null;
        }
    }
}
