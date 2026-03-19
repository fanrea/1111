package com.baidu.mobads.container.components.e;

import android.content.Context;
import com.baidu.mobads.container.util.bq;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f {
    public static final String a = "OAdRemoteDownloadManager";
    public static final String b = "";
    private static f d = null;
    protected Context c;
    private com.baidu.mobads.container.components.c.e f;
    private final HashMap<String, b> e = new HashMap<>();
    private AtomicBoolean g = new AtomicBoolean(false);

    protected f(Context context) {
        this.c = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (d == null) {
            d = new f(context);
        }
        return d;
    }

    public Boolean a(String str) {
        synchronized (this.e) {
            this.e.remove(str);
        }
        return true;
    }

    public b b(String str) {
        b bVar;
        synchronized (this.e) {
            bVar = this.e.get(str);
        }
        return bVar;
    }

    public void a(String str, b bVar) {
        synchronized (this.e) {
            this.e.put(str, bVar);
        }
    }

    public void a() {
        synchronized (this.e) {
            this.e.clear();
        }
    }

    public b c(String str) {
        synchronized (this.e) {
            b bVarRemove = this.e.remove(str);
            if (bVarRemove != null) {
                bVarRemove.b();
                return bVarRemove;
            }
            return null;
        }
    }

    public ArrayList<b> b() {
        ArrayList<b> arrayList;
        synchronized (this.e) {
            Collection<b> collectionValues = this.e.values();
            if (collectionValues.size() <= 0) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(collectionValues);
            }
        }
        return arrayList;
    }

    public synchronized b a(URL url, String str, String str2, int i, String str3, boolean z) {
        c cVar;
        cVar = new c(this.c, url, str, str2, i, str3);
        cVar.a(z);
        a(str3, cVar);
        try {
            if (this.f == null) {
                this.f = new com.baidu.mobads.container.components.c.e(this.c);
                this.f.a(new com.baidu.mobads.container.components.c.d(this.f));
                this.f.addEventListener(com.baidu.mobads.container.components.c.e.b, new g(this));
                this.f.b();
            }
        } catch (Exception e) {
            bq.a().a(a, e);
        }
        return cVar;
    }

    public b a(URL url, String str, String str2, boolean z) {
        return new a(url, str, str2, z);
    }
}
