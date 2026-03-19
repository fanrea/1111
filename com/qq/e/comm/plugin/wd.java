package com.qq.e.comm.plugin;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wd {
    private static volatile wd d;
    private final Map<String, b> a = new HashMap();
    private final Map<String, WeakReference<b>> b = new HashMap();
    private final Handler c = new Handler(Looper.getMainLooper());

    /* compiled from: A */
    public interface b {
        void a(String str, int i, Object obj);
    }

    /* compiled from: A */
    public static class c {
        public String a;
        public zw b;
    }

    private wd() {
    }

    public void b(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        this.b.put(str, new WeakReference<>(bVar));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ int b;
        final /* synthetic */ Object c;

        a(String str, int i, Object obj) {
            this.a = str;
            this.b = i;
            this.c = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = (b) wd.this.a.get(this.a);
            if (bVar == null) {
                WeakReference weakReference = (WeakReference) wd.this.b.get(this.a);
                if (weakReference != null) {
                    b bVar2 = (b) weakReference.get();
                    if (bVar2 == null) {
                        wd.this.b.remove(this.a);
                        return;
                    } else {
                        bVar2.a(this.a, this.b, this.c);
                        return;
                    }
                }
                return;
            }
            bVar.a(this.a, this.b, this.c);
        }
    }

    public void a(String str, int i) {
        a(str, i, null);
    }

    public void a(String str, int i, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.post(new a(str, i, obj));
    }

    public void a(String str, b bVar) {
        if (TextUtils.isEmpty(str) || bVar == null) {
            return;
        }
        this.a.put(str, bVar);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.a.remove(str);
        this.b.remove(str);
    }

    public static wd a() {
        if (d == null) {
            synchronized (wd.class) {
                if (d == null) {
                    d = new wd();
                }
            }
        }
        return d;
    }
}
