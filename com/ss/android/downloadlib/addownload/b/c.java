package com.ss.android.downloadlib.addownload.b;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.socialbase.downloader.downloader.h;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static volatile c d;
    private long hc = 0;
    private ConcurrentHashMap<String, u> b = new ConcurrentHashMap<>();
    private HashMap<String, Integer> c = new HashMap<>();
    private List<String> u = new CopyOnWriteArrayList();

    public static c d() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    public void d(String str, u uVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.put(str, uVar);
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.remove(str);
    }

    long hc() {
        return this.hc;
    }

    void b() {
        this.hc = System.currentTimeMillis();
    }

    public int hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.c == null) {
            this.c = new HashMap<>();
        }
        if (this.c.containsKey(str)) {
            return this.c.get(str).intValue();
        }
        return 0;
    }

    public static void d(com.ss.android.hc.d.hc.hc hcVar) {
        com.ss.android.socialbase.downloader.h.b bVarGb;
        if (hcVar == null || hcVar.hc() <= 0 || (bVarGb = h.hc(mq.getContext()).gb(hcVar.rf())) == null) {
            return;
        }
        d(bVarGb);
    }

    public static void d(com.ss.android.socialbase.downloader.h.b bVar) {
        if (bVar == null || com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = bVar.mk() + File.separator + bVar.gb();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }
}
