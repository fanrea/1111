package com.pangrowth.adclog;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ad.android.alog.Alog;
import com.pangrowth.adclog.f;
import com.pangrowth.adclog.t;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a extends Handler {
    public a(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws NoSuchMethodException, SecurityException {
        Alog alog;
        int i = message.what;
        if (i != 1) {
            if (i == 2 && (alog = i.e) != null) {
                alog.a();
                return;
            }
            return;
        }
        Object obj = message.obj;
        if (obj == null || !(obj instanceof f.a)) {
            return;
        }
        f.a aVar = (f.a) obj;
        int i2 = aVar.a - 2;
        String strA = "";
        t.a aVar2 = aVar.e;
        if (aVar2 != null) {
            t.a aVar3 = t.a.BORDER;
            if (aVar2 == aVar3 || aVar2 == (aVar3 = t.a.JSON)) {
                strA = t.a(aVar3, aVar.c);
            } else {
                t.a aVar4 = t.a.BUNDLE;
                if (aVar2 == aVar4) {
                    Bundle bundle = (Bundle) aVar.f;
                    ((o) t.a.get(aVar4)).getClass();
                    strA = i.a(bundle);
                } else {
                    t.a aVar5 = t.a.INTENT;
                    if (aVar2 == aVar5) {
                        strA = ((p) t.a.get(aVar5)).a((Intent) aVar.f);
                    } else {
                        t.a aVar6 = t.a.THROWABLE;
                        if (aVar2 == aVar6) {
                            strA = t.a.get(aVar6).a((Throwable) aVar.f);
                        } else {
                            t.a aVar7 = t.a.THREAD;
                            if (aVar2 == aVar7) {
                                strA = t.a.get(aVar7).a((Thread) aVar.f);
                            } else {
                                t.a aVar8 = t.a.STACKTRACE;
                                if (aVar2 == aVar8) {
                                    strA = t.a.get(aVar8).a((StackTraceElement[]) aVar.f);
                                }
                            }
                        }
                    }
                }
            }
        } else if (aVar.d == null) {
            strA = aVar.c;
        } else {
            strA = (aVar.c == null ? "" : aVar.c + "\n") + i.a(aVar.d);
        }
        String str = strA;
        String str2 = aVar.b;
        long j = aVar.g;
        long j2 = aVar.h;
        Alog alog2 = i.e;
        if (alog2 != null) {
            alog2.a(i2, str2, str, j, j2);
        }
        aVar.b = null;
        aVar.c = null;
        aVar.d = null;
        aVar.e = null;
        aVar.f = null;
        aVar.g = -1L;
        aVar.h = 0L;
        aVar.i = null;
        synchronized (f.a.j) {
            int i3 = f.a.l;
            if (i3 < 50) {
                aVar.i = f.a.k;
                f.a.k = aVar;
                f.a.l = i3 + 1;
            }
        }
    }
}
