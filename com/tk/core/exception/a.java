package com.tk.core.exception;

import com.tk.core.a.m;
import com.tk.core.bridge.b;
import com.tk.core.d.c;
import com.tk.core.o.ad;
import com.tk.core.o.t;
import com.tkruntime.v8.V8ScriptExecutionException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private static m ahW;

    public static void a(m mVar) {
        ahW = mVar;
    }

    @Deprecated
    public static void a(Throwable th, int i) {
        b((b) null, th);
        m mVar = ahW;
        if (mVar != null) {
            mVar.handleException(i, th, (String) null);
        }
    }

    @Deprecated
    public static void b(Throwable th, int i) {
        b((b) null, th);
        m mVar = ahW;
        if (mVar == null || th == null) {
            return;
        }
        mVar.handleException(i, th, (String) null);
    }

    public static void a(b bVar, Throwable th) {
        b(th, bVar != null ? bVar.hashCode() : -1);
    }

    public static void a(b bVar, Throwable th, String str) {
        int iHashCode = bVar != null ? bVar.hashCode() : -1;
        b(bVar, th);
        m mVar = ahW;
        if (mVar != null) {
            mVar.handleException(iHashCode, th, str);
        }
    }

    public static void a(String str, Throwable th, String str2) {
        b((b) null, th);
        m mVar = ahW;
        if (mVar != null) {
            mVar.handleException(str, th, (String) null);
        }
    }

    private static void b(b bVar, Throwable th) {
        if (th == null || com.tk.core.a.oP().isReleaseMode()) {
            return;
        }
        com.tk.core.i.a.a("showExceptionInDevMode", th.getMessage(), th);
        if ((th instanceof V8ScriptExecutionException) && bVar != null && bVar.pl() != null && ad.isV8Valid(bVar.pl().get())) {
            bVar.pl().get().executeJSFunction("error", th.toString());
        }
        if (!c.rA().rz() && !rM() && t.isDebug()) {
            throw new RuntimeException(th.getMessage(), th);
        }
    }

    private static boolean rM() {
        if (com.tk.core.a.oP().getTKSwitch() != null) {
            return com.tk.core.a.oP().getTKSwitch().oY();
        }
        return false;
    }
}
