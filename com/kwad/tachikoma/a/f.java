package com.kwad.tachikoma.a;

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
            return "unregisterPageLifeCycleCallback";
        }
        if (i == 1) {
            return "close";
        }
        if (i == 2) {
            return "isActive";
        }
        if (i == 3) {
            return "getTKContainer";
        }
        if (i != 4) {
            return null;
        }
        return "registerPageLifeCycleCallback";
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
        return "4#unregisterPageLifeCycleCallback#0,8#close#1,8#isActive#2,8#getTKContainer#3,8#registerPageLifeCycleCallback#4";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ e b(NativeModuleInitParams nativeModuleInitParams) {
        return g(nativeModuleInitParams);
    }

    private static e g(NativeModuleInitParams nativeModuleInitParams) {
        return new e(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 0
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -2029997059: goto L35;
                case -748916528: goto L2b;
                case 94756344: goto L21;
                case 1106171572: goto L17;
                case 1603663876: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L3f
        Ld:
            java.lang.String r0 = "unregisterPageLifeCycleCallback"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 4
            goto L40
        L17:
            java.lang.String r0 = "getTKContainer"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 2
            goto L40
        L21:
            java.lang.String r0 = "close"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 0
            goto L40
        L2b:
            java.lang.String r0 = "isActive"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 1
            goto L40
        L35:
            java.lang.String r0 = "registerPageLifeCycleCallback"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = 3
            goto L40
        L3f:
            r7 = -1
        L40:
            if (r7 == 0) goto L4c
            if (r7 == r5) goto L4c
            if (r7 == r4) goto L4c
            if (r7 == r3) goto L4c
            if (r7 == r2) goto L4b
            return r1
        L4b:
            return r5
        L4c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.a.f.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
            r7 = this;
            com.kwad.tachikoma.a.e r8 = (com.kwad.tachikoma.a.e) r8
            int r0 = r9.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            switch(r0) {
                case -2029997059: goto L37;
                case -748916528: goto L2d;
                case 94756344: goto L23;
                case 1106171572: goto L19;
                case 1603663876: goto Lf;
                default: goto Le;
            }
        Le:
            goto L41
        Lf:
            java.lang.String r0 = "unregisterPageLifeCycleCallback"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L41
            r0 = 0
            goto L42
        L19:
            java.lang.String r0 = "getTKContainer"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L41
            r0 = 3
            goto L42
        L23:
            java.lang.String r0 = "close"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L41
            r0 = 1
            goto L42
        L2d:
            java.lang.String r0 = "isActive"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L41
            r0 = 2
            goto L42
        L37:
            java.lang.String r0 = "registerPageLifeCycleCallback"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L41
            r0 = 4
            goto L42
        L41:
            r0 = -1
        L42:
            r6 = 0
            if (r0 == 0) goto L8d
            if (r0 == r4) goto L84
            if (r0 == r3) goto L7b
            if (r0 == r2) goto L76
            if (r0 == r1) goto L67
            boolean r8 = com.tk.core.o.t.isDebug()
            if (r8 == 0) goto L66
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "can't find method ---> "
            r8.<init>(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "TKPage"
            android.util.Log.e(r9, r8)
        L66:
            return r6
        L67:
            java.lang.Object r9 = com.tk.core.o.a.b(r10, r5)
            com.tkruntime.v8.V8Function r9 = (com.tkruntime.v8.V8Function) r9
            int r8 = r8.f(r9)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            return r8
        L76:
            java.lang.Object r8 = r8.ic()
            return r8
        L7b:
            boolean r8 = r8.isActive()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            return r8
        L84:
            boolean r8 = r8.ib()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            return r8
        L8d:
            java.lang.Object r9 = com.tk.core.o.a.c(r10, r5)
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = com.tk.core.manager.a.f.h(r9)
            r8.bQ(r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.a.f.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
