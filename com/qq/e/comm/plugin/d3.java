package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d3 {
    private ConcurrentHashMap<String, WeakReference<DownloadConfirmListener>> a;

    /* compiled from: A */
    private static class b {
        private static d3 a = new d3();
    }

    public static d3 b() {
        return b.a;
    }

    private d3() {
        this.a = new ConcurrentHashMap<>();
    }

    private void a() {
        Iterator<Map.Entry<String, WeakReference<DownloadConfirmListener>>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, WeakReference<DownloadConfirmListener>> next = it.next();
            WeakReference<DownloadConfirmListener> value = next.getValue();
            if (value == null || value.get() == null) {
                next.getKey();
                it.remove();
            }
        }
    }

    public DownloadConfirmListener a(String str) {
        WeakReference<DownloadConfirmListener> weakReference;
        if (TextUtils.isEmpty(str) || (weakReference = this.a.get(str)) == null) {
            return null;
        }
        return weakReference.get();
    }

    public void a(String str, DownloadConfirmListener downloadConfirmListener) {
        a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.put(str, new WeakReference<>(downloadConfirmListener));
    }
}
