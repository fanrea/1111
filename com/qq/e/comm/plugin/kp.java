package com.qq.e.comm.plugin;

import android.content.Context;
import com.kuaishou.socket.nano.SocketMessages;
import java.util.concurrent.ConcurrentHashMap;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class kp {
    private tm a;
    private bs b;
    private vm c;
    private ds d;
    private um e;
    private cs f;
    private ConcurrentHashMap<String, Boolean> g;
    private ConcurrentHashMap<String, Integer> h;
    private ConcurrentHashMap<String, Integer> i;
    private boolean j;
    private boolean k;
    private int l;

    /* compiled from: A */
    private static class c {
        private static final kp a = new kp(null);
    }

    static /* synthetic */ ConcurrentHashMap a(kp kpVar) {
        return (ConcurrentHashMap) pro.getobjresult(416, 1, kpVar);
    }

    private int b(String str) {
        return pro.getIresult(SocketMessages.PayloadType.SC_FANS_TOP_OPENED, 0, this, str);
    }

    public static kp b() {
        return (kp) pro.getobjresult(418, 1, new Object[0]);
    }

    static /* synthetic */ um b(kp kpVar) {
        return (um) pro.getobjresult(SocketMessages.PayloadType.SC_POP_COMMODITY, 1, kpVar);
    }

    static /* synthetic */ cs c(kp kpVar) {
        return (cs) pro.getobjresult(420, 1, kpVar);
    }

    static /* synthetic */ vm d(kp kpVar) {
        return (vm) pro.getobjresult(421, 1, kpVar);
    }

    static /* synthetic */ ds e(kp kpVar) {
        return (ds) pro.getobjresult(422, 1, kpVar);
    }

    public int a(String str) {
        return pro.getIresult(423, 0, this, str);
    }

    public int a(String str, Context context) {
        return pro.getIresult(424, 0, this, str, context);
    }

    public void a() {
        pro.getVresult(425, 0, this);
    }

    public void a(int i) {
        pro.getVresult(426, 0, this, Integer.valueOf(i));
    }

    public void a(String str, e2 e2Var) {
        pro.getVresult(SocketMessages.PayloadType.SC_RED_PACK_RAIN_RESOURCE, 0, this, str, e2Var);
    }

    public void b(String str, e2 e2Var) {
        pro.getVresult(428, 0, this, str, e2Var);
    }

    public int c(String str) {
        return pro.getIresult(429, 0, this, str);
    }

    public void c() {
        pro.getVresult(430, 0, this);
    }

    private kp() {
        c();
    }

    /* synthetic */ kp(a aVar) {
        this();
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ StackTraceElement[] b;
        final /* synthetic */ e2 c;

        a(String str, StackTraceElement[] stackTraceElementArr, e2 e2Var) {
            this.a = str;
            this.b = stackTraceElementArr;
            this.c = e2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (kp.a(kp.this).containsKey(this.a)) {
                return;
            }
            int iA = kp.b(kp.this).a(this.b, this.a, this.c);
            if (iA > -1) {
                kp.a(kp.this).put(this.a, Integer.valueOf(iA));
            }
            kp.c(kp.this).a(this.b, this.a, this.c);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ StackTraceElement[] b;
        final /* synthetic */ e2 c;

        b(String str, StackTraceElement[] stackTraceElementArr, e2 e2Var) {
            this.a = str;
            this.b = stackTraceElementArr;
            this.c = e2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (kp.a(kp.this).containsKey(this.a)) {
                return;
            }
            int iA = kp.d(kp.this).a(this.b, this.a, this.c);
            if (iA > -1) {
                kp.a(kp.this).put(this.a, Integer.valueOf(iA));
            }
            kp.e(kp.this).a(this.b, this.a, this.c);
        }
    }
}
