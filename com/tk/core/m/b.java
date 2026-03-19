package com.tk.core.m;

import com.kuaishou.tk.export.NativeModuleInitParams;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final Object a(Object obj, String str) {
        return null;
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        if (i == 0) {
            return "currentTimeMillis";
        }
        if (i != 1) {
            return null;
        }
        return "elapsedRealtime";
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final boolean g(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "8#currentTimeMillis#0,8#elapsedRealtime#1";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return ax(nativeModuleInitParams);
    }

    private static a ax(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 1555800524(0x5cbba1cc, float:4.2250975E17)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = 2039817991(0x79952707, float:9.680548E34)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "elapsedRealtime"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L1b:
            java.lang.String r0 = "currentTimeMillis"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 0
            goto L26
        L25:
            r5 = -1
        L26:
            if (r5 == 0) goto L2b
            if (r5 == r3) goto L2b
            return r2
        L2b:
            r5 = 2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.m.b.h(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3, java.lang.Object[] r4) {
        /*
            r1 = this;
            int r2 = r3.hashCode()
            r4 = 1555800524(0x5cbba1cc, float:4.2250975E17)
            r0 = 1
            if (r2 == r4) goto L1a
            r4 = 2039817991(0x79952707, float:9.680548E34)
            if (r2 == r4) goto L10
            goto L24
        L10:
            java.lang.String r2 = "elapsedRealtime"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L24
            r2 = 1
            goto L25
        L1a:
            java.lang.String r2 = "currentTimeMillis"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L24
            r2 = 0
            goto L25
        L24:
            r2 = -1
        L25:
            if (r2 == 0) goto L49
            if (r2 == r0) goto L44
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto L42
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "can't find method ---> "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKClock"
            android.util.Log.e(r3, r2)
        L42:
            r2 = 0
            return r2
        L44:
            java.lang.String r2 = com.tk.core.m.a.sw()
            return r2
        L49:
            java.lang.String r2 = com.tk.core.m.a.sx()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.m.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
