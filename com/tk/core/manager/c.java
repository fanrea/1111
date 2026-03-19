package com.tk.core.manager;

import android.net.Uri;
import android.text.TextUtils;
import com.tk.core.a.k;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class c {
    static volatile c aih;
    HashMap<com.tk.core.bridge.a, k> aii = new HashMap<>();

    private c() {
    }

    public static c rY() {
        if (aih == null) {
            synchronized (c.class) {
                if (aih == null) {
                    aih = new c();
                }
            }
        }
        return aih;
    }

    public final void a(com.tk.core.bridge.a aVar, k kVar) {
        if (aVar != null) {
            this.aii.put(aVar, kVar);
        }
    }

    public final void a(com.tk.core.bridge.a aVar, String str) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            return;
        }
        try {
            this.aii.get(aVar).navigateTo(Uri.parse(str));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public final void b(com.tk.core.bridge.a aVar) {
        if (aVar != null) {
            this.aii.remove(aVar);
        }
    }
}
