package com.kwad.tachikoma.a;

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
            return "removeAll";
        }
        if (i == 1) {
            return "removeChild";
        }
        if (i != 2) {
            return null;
        }
        return "appendChild";
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
        return "4#removeAll#0,4#removeChild#1,4#appendChild#2";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return f(nativeModuleInitParams);
    }

    private static c f(NativeModuleInitParams nativeModuleInitParams) {
        return new c(nativeModuleInitParams);
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
            r1 = -1912367582(0xffffffff8e039622, float:-1.6219283E-30)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = -319766792(0xffffffffecf0bef8, float:-2.3283522E27)
            if (r0 == r1) goto L21
            r1 = 1282345597(0x4c6f0a7d, float:6.2663156E7)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "removeAll"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 0
            goto L36
        L21:
            java.lang.String r0 = "removeChild"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 1
            goto L36
        L2b:
            java.lang.String r0 = "appendChild"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 2
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3d
            if (r6 == r4) goto L3d
            if (r6 == r3) goto L3d
            return r2
        L3d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.a.d.h(java.lang.String):int");
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
            com.kwad.tachikoma.a.c r6 = (com.kwad.tachikoma.a.c) r6
            int r0 = r7.hashCode()
            r1 = -1912367582(0xffffffff8e039622, float:-1.6219283E-30)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L2d
            r1 = -319766792(0xffffffffecf0bef8, float:-2.3283522E27)
            if (r0 == r1) goto L23
            r1 = 1282345597(0x4c6f0a7d, float:6.2663156E7)
            if (r0 == r1) goto L19
            goto L37
        L19:
            java.lang.String r0 = "removeAll"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L23:
            java.lang.String r0 = "removeChild"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 1
            goto L38
        L2d:
            java.lang.String r0 = "appendChild"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 2
            goto L38
        L37:
            r0 = -1
        L38:
            r1 = 0
            if (r0 == 0) goto L6d
            if (r0 == r3) goto L63
            if (r0 == r2) goto L59
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKContainerView"
            android.util.Log.e(r7, r6)
        L58:
            return r1
        L59:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Object r7 = (com.tkruntime.v8.V8Object) r7
            r6.d(r7)
            return r1
        L63:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Object r7 = (com.tkruntime.v8.V8Object) r7
            r6.e(r7)
            return r1
        L6d:
            r6.removeAll()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.a.d.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
