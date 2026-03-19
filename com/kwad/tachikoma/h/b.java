package com.kwad.tachikoma.h;

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
            return "decryptLongFromBase64";
        }
        if (i != 1) {
            return null;
        }
        return "encryptLongToBase64";
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
        return "8#decryptLongFromBase64#0,8#encryptLongToBase64#1";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return o(nativeModuleInitParams);
    }

    private static a o(NativeModuleInitParams nativeModuleInitParams) {
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
            r1 = -1886743221(0xffffffff8f8a954b, float:-1.3665356E-29)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = 1885363234(0x70605c22, float:2.777441E29)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "decryptLongFromBase64"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 0
            goto L26
        L1b:
            java.lang.String r0 = "encryptLongToBase64"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.h.b.h(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r4, java.lang.String r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            int r4 = r5.hashCode()
            r0 = -1886743221(0xffffffff8f8a954b, float:-1.3665356E-29)
            r1 = 1
            r2 = 0
            if (r4 == r0) goto L1b
            r0 = 1885363234(0x70605c22, float:2.777441E29)
            if (r4 == r0) goto L11
            goto L25
        L11:
            java.lang.String r4 = "decryptLongFromBase64"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L25
            r4 = 0
            goto L26
        L1b:
            java.lang.String r4 = "encryptLongToBase64"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L25
            r4 = 1
            goto L26
        L25:
            r4 = -1
        L26:
            if (r4 == 0) goto L50
            if (r4 == r1) goto L45
            boolean r4 = com.tk.core.o.t.isDebug()
            if (r4 == 0) goto L43
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "can't find method ---> "
            r4.<init>(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "TKFlowUuid"
            android.util.Log.e(r5, r4)
        L43:
            r4 = 0
            return r4
        L45:
            java.lang.Object r4 = com.tk.core.o.a.b(r6, r2)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = com.kwad.tachikoma.h.a.t(r4)
            return r4
        L50:
            java.lang.Object r4 = com.tk.core.o.a.b(r6, r2)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r4 = com.kwad.tachikoma.h.a.u(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.h.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
