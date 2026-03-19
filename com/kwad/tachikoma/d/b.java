package com.kwad.tachikoma.d;

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
            return "getString";
        }
        if (i == 1) {
            return "removePasteboardWithName";
        }
        if (i != 2) {
            return null;
        }
        return "copyToPasteboard";
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
        return "8#getString#0,4#removePasteboardWithName#1,4#copyToPasteboard#2";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return j(nativeModuleInitParams);
    }

    private static a j(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
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
            r1 = -1388069597(0xffffffffad43bd23, float:-1.11264635E-11)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = -657826456(0xffffffffd8ca5d68, float:-1.7800202E15)
            if (r0 == r1) goto L21
            r1 = 804029191(0x2fec8307, float:4.302125E-10)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "getString"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 0
            goto L36
        L21:
            java.lang.String r0 = "removePasteboardWithName"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 1
            goto L36
        L2b:
            java.lang.String r0 = "copyToPasteboard"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = 2
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3e
            if (r6 == r4) goto L3d
            if (r6 == r3) goto L3d
            return r2
        L3d:
            return r4
        L3e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.d.b.h(java.lang.String):int");
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
            com.kwad.tachikoma.d.a r6 = (com.kwad.tachikoma.d.a) r6
            int r0 = r7.hashCode()
            r1 = -1388069597(0xffffffffad43bd23, float:-1.11264635E-11)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2d
            r1 = -657826456(0xffffffffd8ca5d68, float:-1.7800202E15)
            if (r0 == r1) goto L23
            r1 = 804029191(0x2fec8307, float:4.302125E-10)
            if (r0 == r1) goto L19
            goto L37
        L19:
            java.lang.String r0 = "getString"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L23:
            java.lang.String r0 = "removePasteboardWithName"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 1
            goto L38
        L2d:
            java.lang.String r0 = "copyToPasteboard"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L37
            r0 = 2
            goto L38
        L37:
            r0 = -1
        L38:
            if (r0 == 0) goto L76
            r1 = 0
            if (r0 == r4) goto L72
            if (r0 == r3) goto L59
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKPasteBoard"
            android.util.Log.e(r7, r6)
        L58:
            return r1
        L59:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = com.tk.core.o.a.c(r8, r4)
            java.lang.Number r0 = (java.lang.Number) r0
            com.tk.core.manager.a.f.h(r0)
            java.lang.Object r8 = com.tk.core.o.a.b(r8, r3)
            com.tkruntime.v8.V8Function r8 = (com.tkruntime.v8.V8Function) r8
            r6.e(r7, r8)
            return r1
        L72:
            com.tk.core.o.a.b(r8, r2)
            return r1
        L76:
            java.lang.String r6 = r6.getString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.d.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
