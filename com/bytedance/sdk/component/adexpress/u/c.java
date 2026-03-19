package com.bytedance.sdk.component.adexpress.u;

import android.webkit.JavascriptInterface;
import com.bytedance.sdk.component.d.yi;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private WeakReference<yi> d;

    public c(yi yiVar) {
        this.d = new WeakReference<>(yiVar);
    }

    public void d(yi yiVar) {
        this.d = new WeakReference<>(yiVar);
    }

    @JavascriptInterface
    public void invokeMethod(String str) {
        WeakReference<yi> weakReference = this.d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.d.get().invokeMethod(str);
    }
}
