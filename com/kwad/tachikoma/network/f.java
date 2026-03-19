package com.kwad.tachikoma.network;

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
            return "getCurrentNetworkType";
        }
        if (i == 1) {
            return "addNetworkChangeListener";
        }
        if (i != 2) {
            return null;
        }
        return "removeNetworkChangeListener";
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
        return "8#getCurrentNetworkType#0,8#addNetworkChangeListener#1,4#removeNetworkChangeListener#2";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ e b(NativeModuleInitParams nativeModuleInitParams) {
        return u(nativeModuleInitParams);
    }

    private static e u(NativeModuleInitParams nativeModuleInitParams) {
        return new e(nativeModuleInitParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -847478735(0xffffffffcd7c8031, float:-2.6476622E8)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = -587408338(0xffffffffdcfcdc2e, float:-5.6939027E17)
            if (r0 == r1) goto L21
            r1 = 1897786693(0x711ded45, float:7.820158E29)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "getCurrentNetworkType"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 0
            goto L36
        L21:
            java.lang.String r0 = "removeNetworkChangeListener"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 2
            goto L36
        L2b:
            java.lang.String r0 = "addNetworkChangeListener"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 1
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3e
            if (r6 == r4) goto L3e
            if (r6 == r3) goto L3d
            return r2
        L3d:
            return r4
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.network.f.h(java.lang.String):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r6, java.lang.String r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            com.kwad.tachikoma.network.e r6 = (com.kwad.tachikoma.network.e) r6
            int r0 = r7.hashCode()
            r1 = -847478735(0xffffffffcd7c8031, float:-2.6476622E8)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L2d
            r1 = -587408338(0xffffffffdcfcdc2e, float:-5.6939027E17)
            if (r0 == r1) goto L23
            r1 = 1897786693(0x711ded45, float:7.820158E29)
            if (r0 == r1) goto L19
            goto L37
        L19:
            java.lang.String r0 = "getCurrentNetworkType"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L23:
            java.lang.String r0 = "removeNetworkChangeListener"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 2
            goto L38
        L2d:
            java.lang.String r0 = "addNetworkChangeListener"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 1
            goto L38
        L37:
            r0 = -1
        L38:
            if (r0 == 0) goto L76
            if (r0 == r3) goto L67
            r1 = 0
            if (r0 == r2) goto L59
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKNetworkManager"
            android.util.Log.e(r7, r6)
        L58:
            return r1
        L59:
            java.lang.Object r7 = com.tk.core.o.a.c(r8, r4)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = com.tk.core.manager.a.f.h(r7)
            r6.cf(r7)
            return r1
        L67:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Function r7 = (com.tkruntime.v8.V8Function) r7
            int r6 = r6.u(r7)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        L76:
            int r6 = r6.iM()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.network.f.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
