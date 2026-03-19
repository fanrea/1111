package com.kwad.tachikoma.o;

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
            return "getBroadcast";
        }
        if (i == 1) {
            return "getService";
        }
        if (i == 2) {
            return "getForegroundService";
        }
        if (i != 3) {
            return null;
        }
        return "getActivity";
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
        return "8#getBroadcast#0,8#getService#1,8#getForegroundService#2,8#getActivity#3";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ e b(NativeModuleInitParams nativeModuleInitParams) {
        return A(nativeModuleInitParams);
    }

    private static e A(NativeModuleInitParams nativeModuleInitParams) {
        return new e(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 0
            r2 = 3
            r3 = 1
            r4 = 2
            switch(r0) {
                case -1628481013: goto L2a;
                case -1273953665: goto L20;
                case 421933189: goto L16;
                case 549395260: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L34
        Lc:
            java.lang.String r0 = "getForegroundService"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 2
            goto L35
        L16:
            java.lang.String r0 = "getActivity"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 3
            goto L35
        L20:
            java.lang.String r0 = "getService"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 1
            goto L35
        L2a:
            java.lang.String r0 = "getBroadcast"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 0
            goto L35
        L34:
            r6 = -1
        L35:
            if (r6 == 0) goto L3e
            if (r6 == r3) goto L3e
            if (r6 == r4) goto L3e
            if (r6 == r2) goto L3e
            return r1
        L3e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.o.f.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r6, java.lang.String r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            com.kwad.tachikoma.o.e r6 = (com.kwad.tachikoma.o.e) r6
            int r0 = r7.hashCode()
            r1 = 3
            r2 = 0
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1628481013: goto L2c;
                case -1273953665: goto L22;
                case 421933189: goto L18;
                case 549395260: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L36
        Le:
            java.lang.String r0 = "getForegroundService"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 2
            goto L37
        L18:
            java.lang.String r0 = "getActivity"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 3
            goto L37
        L22:
            java.lang.String r0 = "getService"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 1
            goto L37
        L2c:
            java.lang.String r0 = "getBroadcast"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 0
            goto L37
        L36:
            r0 = -1
        L37:
            if (r0 == 0) goto Lb7
            if (r0 == r4) goto L98
            if (r0 == r3) goto L79
            if (r0 == r1) goto L5a
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L58
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKNativePendingIntent"
            android.util.Log.e(r7, r6)
        L58:
            r6 = 0
            return r6
        L5a:
            java.lang.Object r7 = com.tk.core.o.a.c(r8, r2)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = com.tk.core.manager.a.f.h(r7)
            java.lang.Object r0 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Object r0 = (com.tkruntime.v8.V8Object) r0
            java.lang.Object r8 = com.tk.core.o.a.c(r8, r3)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = com.tk.core.manager.a.f.h(r8)
            com.tkruntime.v8.V8Object r6 = r6.a(r7, r0, r8)
            return r6
        L79:
            java.lang.Object r7 = com.tk.core.o.a.c(r8, r2)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = com.tk.core.manager.a.f.h(r7)
            java.lang.Object r0 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Object r0 = (com.tkruntime.v8.V8Object) r0
            java.lang.Object r8 = com.tk.core.o.a.c(r8, r3)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = com.tk.core.manager.a.f.h(r8)
            com.tkruntime.v8.V8Object r6 = r6.d(r7, r0, r8)
            return r6
        L98:
            java.lang.Object r7 = com.tk.core.o.a.c(r8, r2)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = com.tk.core.manager.a.f.h(r7)
            java.lang.Object r0 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Object r0 = (com.tkruntime.v8.V8Object) r0
            java.lang.Object r8 = com.tk.core.o.a.c(r8, r3)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = com.tk.core.manager.a.f.h(r8)
            com.tkruntime.v8.V8Object r6 = r6.c(r7, r0, r8)
            return r6
        Lb7:
            java.lang.Object r7 = com.tk.core.o.a.c(r8, r2)
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = com.tk.core.manager.a.f.h(r7)
            java.lang.Object r0 = com.tk.core.o.a.b(r8, r4)
            com.tkruntime.v8.V8Object r0 = (com.tkruntime.v8.V8Object) r0
            java.lang.Object r8 = com.tk.core.o.a.c(r8, r3)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = com.tk.core.manager.a.f.h(r8)
            com.tkruntime.v8.V8Object r6 = r6.b(r7, r0, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.o.f.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
