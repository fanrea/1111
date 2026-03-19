package com.bytedance.framwork.core.ef;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import androidx.core.location.LocationRequestCompat;
import com.bytedance.framwork.core.ef.a;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: LogSender.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class f extends Thread {
    private final Context a;
    private final Object b;
    private final AtomicBoolean c;
    private final e d;
    private long e;
    private long f;
    private long g;
    private d h;
    private final LinkedList<b> i;
    private int j;

    f(Context context, d dVar, LinkedList<b> linkedList, AtomicBoolean atomicBoolean) {
        super("LogSender");
        this.b = new Object();
        this.e = -1L;
        this.f = 0L;
        this.g = 120000L;
        this.h = dVar;
        this.a = context;
        this.i = linkedList;
        this.c = atomicBoolean;
        this.d = e.a(context);
    }

    private void b() {
        a.b bVarB;
        if (e()) {
            return;
        }
        Map<String, a> mapA = this.h.a();
        if (mapA != null && !mapA.isEmpty()) {
            for (String str : mapA.keySet()) {
                if (e()) {
                    break;
                }
                a aVar = mapA.get(str);
                if (aVar != null && (bVarB = aVar.b()) != null) {
                    this.d.a(str, bVarB.c(), bVarB.f());
                }
            }
        }
        this.d.a(null, -1, 864000000L);
    }

    private boolean c() {
        if (e()) {
            return false;
        }
        synchronized (this.i) {
            if (e()) {
                return false;
            }
            b bVarPoll = this.i.isEmpty() ? null : this.i.poll();
            boolean z = this.i.isEmpty() ? false : true;
            if (bVarPoll != null) {
                try {
                    if (this.d.a(bVarPoll.f, bVarPoll.b) >= LocationRequestCompat.PASSIVE_INTERVAL) {
                        this.d.b();
                    }
                } catch (SQLiteFullException unused) {
                    this.d.b();
                }
            }
            return z;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0165 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0166  */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.bytedance.framwork.core.ef.f] */
    /* JADX WARN: Type inference failed for: r3v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d() {
        /*
            Method dump skipped, instructions count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.framwork.core.ef.f.d():boolean");
    }

    private boolean a(a aVar, String str, byte[] bArr) {
        if (bArr == null || bArr.length <= 0 || aVar == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return aVar.a(str, bArr);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        d.a("LogSender", "LogSender start");
        while (!e()) {
            boolean zC = c();
            if (e()) {
                break;
            }
            boolean z = d() || zC;
            if (e()) {
                break;
            }
            if (!z) {
                synchronized (this.b) {
                    try {
                        long j = this.g;
                        if (j == 0) {
                            this.b.wait();
                        } else {
                            this.b.wait(j);
                        }
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
        d.a("LogSender", "LogSender quit");
    }

    private boolean e() {
        return this.c.get();
    }

    void a() {
        synchronized (this.b) {
            this.b.notify();
        }
    }
}
