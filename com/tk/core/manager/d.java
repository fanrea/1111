package com.tk.core.manager;

import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    private volatile boolean aij;
    private volatile String[] aik;
    private volatile String[] ail;
    private volatile String[] aim;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
        this.aij = false;
        this.aik = null;
        this.ail = null;
        this.aim = null;
    }

    public static d rZ() {
        return a.ain;
    }

    public static void registerExtraLib(String... strArr) {
        e.registerExtraLib(strArr);
    }

    public final synchronized void aE(boolean z) {
        e.init(z);
        this.aij = true;
        si();
        sj();
        sk();
    }

    private boolean sa() {
        return this.aij;
    }

    private synchronized String[] sb() {
        se();
        return e.sb();
    }

    public final synchronized Map<String, com.tk.core.manager.a.a<?>> sc() {
        se();
        return e.sc();
    }

    public final synchronized Map<String, com.tk.core.manager.a.a<?>> sd() {
        se();
        return e.sd();
    }

    public final synchronized Map<String, Object> b(String str, Object obj) {
        se();
        return e.b(str, obj);
    }

    public final synchronized int a(String str, Object obj, Map<String, Object> map) {
        int i;
        se();
        com.tk.core.manager.a.a aVarCN = e.cN(str);
        i = 0;
        if (com.tachikoma.core.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (!aVarCN.f(it.next())) {
                    i++;
                }
            }
        }
        aVarCN.a(obj, map);
        return i;
    }

    public final synchronized com.tk.core.manager.a.a cN(String str) {
        se();
        return e.cN(str);
    }

    private synchronized void se() {
        if (!sa()) {
            aE(false);
        }
    }

    public final synchronized String[] sf() {
        if (this.aik == null) {
            si();
        }
        return this.aik;
    }

    public final synchronized String[] sg() {
        if (this.ail == null) {
            sj();
        }
        return this.ail;
    }

    public final synchronized String[] sh() {
        if (this.aim == null) {
            sk();
        }
        return this.aim;
    }

    private void si() {
        String[] strArr = (String[]) sc().keySet().toArray(new String[0]);
        int length = strArr.length;
        String[] strArr2 = new String[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                strArr2[i] = strArr[i] + "_stub";
            }
        }
        this.aik = strArr2;
    }

    private void sj() {
        String[] strArr = (String[]) sd().keySet().toArray(new String[0]);
        int length = strArr.length;
        String[] strArr2 = new String[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                strArr2[i] = strArr[i] + "_stub";
            }
        }
        this.ail = strArr2;
    }

    private void sk() {
        String[] strArrSb = sb();
        int length = strArrSb.length;
        int length2 = this.aik.length;
        int length3 = this.ail.length;
        int i = length + length2;
        String[] strArr = new String[i + length3];
        System.arraycopy(strArrSb, 0, strArr, 0, length);
        System.arraycopy(this.aik, 0, strArr, length, length2);
        System.arraycopy(this.ail, 0, strArr, i, length3);
        this.aim = strArr;
    }

    static final class a {
        private static final d ain = new d(0);
    }
}
