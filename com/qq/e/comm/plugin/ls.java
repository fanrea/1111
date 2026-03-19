package com.qq.e.comm.plugin;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Vector;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ls<T> {
    private final Vector<WeakReference<ms<T>>> a = new Vector<>();

    public void b(T t) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a((ls<T>) t);
        } else {
            xo.a((Runnable) new a(t));
        }
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ Object a;

        a(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            ls.this.a((ls) this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(T t) {
        synchronized (this.a) {
            Iterator<WeakReference<ms<T>>> it = this.a.iterator();
            while (it.hasNext()) {
                WeakReference<ms<T>> next = it.next();
                if (next != null) {
                    ms<T> msVar = next.get();
                    if (msVar != null) {
                        msVar.a(t);
                    } else {
                        it.remove();
                    }
                }
            }
        }
    }

    public void a(ms<T> msVar) {
        this.a.add(new WeakReference<>(msVar));
    }

    public void a() {
        b(null);
    }
}
