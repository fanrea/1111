package com.kwad.tachikoma;

import com.kuaishou.tk.export.NativeModuleInitParams;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements com.tk.core.manager.a.a<c> {
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
            return "callAdBridge";
        }
        if (i != 1) {
            return null;
        }
        return "callTKBridge";
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
        return "4#callAdBridge#0,4#callTKBridge#1";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return d(nativeModuleInitParams);
    }

    private static c d(NativeModuleInitParams nativeModuleInitParams) {
        return new c();
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
            r1 = -2123868662(0xffffffff8168560a, float:-4.26734E-38)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = 212001086(0xca2e13e, float:2.5095615E-31)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "callTKBridge"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L1b:
            java.lang.String r0 = "callAdBridge"
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
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.d.h(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r5, java.lang.String r6, java.lang.Object[] r7) throws org.json.JSONException {
        /*
            r4 = this;
            com.kwad.tachikoma.c r5 = (com.kwad.tachikoma.c) r5
            int r0 = r6.hashCode()
            r1 = -2123868662(0xffffffff8168560a, float:-4.26734E-38)
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1d
            r1 = 212001086(0xca2e13e, float:2.5095615E-31)
            if (r0 == r1) goto L13
            goto L27
        L13:
            java.lang.String r0 = "callTKBridge"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L27
            r0 = 1
            goto L28
        L1d:
            java.lang.String r0 = "callAdBridge"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L27
            r0 = 0
            goto L28
        L27:
            r0 = -1
        L28:
            r1 = 0
            if (r0 == 0) goto L51
            if (r0 == r2) goto L47
            boolean r5 = com.tk.core.o.t.isDebug()
            if (r5 == 0) goto L46
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "can't find method ---> "
            r5.<init>(r7)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "KsAdTkJSBridge"
            android.util.Log.e(r6, r5)
        L46:
            return r1
        L47:
            java.lang.Object r6 = com.tk.core.o.a.b(r7, r3)
            com.tkruntime.v8.V8Object r6 = (com.tkruntime.v8.V8Object) r6
            r5.c(r6)
            return r1
        L51:
            java.lang.Object r6 = com.tk.core.o.a.b(r7, r3)
            com.tkruntime.v8.V8Object r6 = (com.tkruntime.v8.V8Object) r6
            r5.b(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.d.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
