package com.kwad.tachikoma.l;

import com.kuaishou.tk.export.NativeModuleInitParams;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f implements com.tk.core.manager.a.a<e> {
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
            return "setBridgeHandler";
        }
        if (i != 1) {
            return null;
        }
        return "callJS";
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
        return "4#setBridgeHandler#0,4#callJS#1";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ e b(NativeModuleInitParams nativeModuleInitParams) {
        return q(nativeModuleInitParams);
    }

    private static e q(NativeModuleInitParams nativeModuleInitParams) {
        return new e(nativeModuleInitParams);
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
            r1 = -1367776217(0xffffffffae796427, float:-5.6705E-11)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = -1176825281(0xffffffffb9db123f, float:-4.178453E-4)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "setBridgeHandler"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 0
            goto L26
        L1b:
            java.lang.String r0 = "callJS"
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
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.l.f.h(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r5, java.lang.String r6, java.lang.Object[] r7) {
        /*
            r4 = this;
            com.kwad.tachikoma.l.e r5 = (com.kwad.tachikoma.l.e) r5
            int r0 = r6.hashCode()
            r1 = -1367776217(0xffffffffae796427, float:-5.6705E-11)
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L1d
            r1 = -1176825281(0xffffffffb9db123f, float:-4.178453E-4)
            if (r0 == r1) goto L13
            goto L27
        L13:
            java.lang.String r0 = "setBridgeHandler"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L27
            r0 = 0
            goto L28
        L1d:
            java.lang.String r0 = "callJS"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L27
            r0 = 1
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
            java.lang.String r6 = "TKJSBridge"
            android.util.Log.e(r6, r5)
        L46:
            return r1
        L47:
            java.lang.Object r6 = com.tk.core.o.a.b(r7, r3)
            java.lang.String r6 = (java.lang.String) r6
            r5.callJS(r6)
            return r1
        L51:
            java.lang.Object r6 = com.tk.core.o.a.b(r7, r3)
            com.tkruntime.v8.V8Function r6 = (com.tkruntime.v8.V8Function) r6
            r5.o(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.l.f.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
