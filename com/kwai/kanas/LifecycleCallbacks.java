package com.kwai.kanas;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.os.SystemClock;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LifecycleCallbacks implements GenericLifecycleObserver {
    private boolean b = true;
    private long c = -1;
    private long d = -1;
    private boolean e = false;
    private volatile String a = UUID.randomUUID().toString();

    public String a() {
        return this.a;
    }

    /* renamed from: com.kwai.kanas.LifecycleCallbacks$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Lifecycle.Event.values().length];

        static {
            try {
                a[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i = AnonymousClass1.a[event.ordinal()];
        if (i == 1) {
            c();
        } else {
            if (i != 2) {
                return;
            }
            d();
        }
    }

    private void c() {
        this.d = SystemClock.elapsedRealtime();
        this.e = true;
        long j = this.c;
        long j2 = j >= 0 ? this.d - j : 0L;
        if (!this.b || j2 <= Kanas.get().getConfig().newSessionBkgIntervalMs()) {
            return;
        }
        this.a = UUID.randomUUID().toString();
        this.d = SystemClock.elapsedRealtime();
    }

    private void d() {
        this.c = SystemClock.elapsedRealtime();
        this.e = false;
    }

    public boolean b() {
        return this.e;
    }

    public void a(boolean z) {
        this.b = z;
    }
}
