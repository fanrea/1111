package com.kwad.tachikoma.e;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.sigmob.sdk.base.n;
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
            return "insert";
        }
        if (i == 1) {
            return n.q;
        }
        if (i == 2) {
            return "delete";
        }
        if (i != 3) {
            return null;
        }
        return "query";
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
        return "8#insert#0,8#update#1,8#delete#2,8#query#3";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return k(nativeModuleInitParams);
    }

    private static a k(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
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
                case -1335458389: goto L2a;
                case -1183792455: goto L20;
                case -838846263: goto L16;
                case 107944136: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L34
        Lc:
            java.lang.String r0 = "query"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 3
            goto L35
        L16:
            java.lang.String r0 = "update"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 1
            goto L35
        L20:
            java.lang.String r0 = "insert"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 0
            goto L35
        L2a:
            java.lang.String r0 = "delete"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 2
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.e.b.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            r6 = this;
            r0 = r7
            com.kwad.tachikoma.e.a r0 = (com.kwad.tachikoma.e.a) r0
            int r7 = r8.hashCode()
            r1 = 3
            r2 = 0
            r3 = 2
            r4 = 1
            switch(r7) {
                case -1335458389: goto L2d;
                case -1183792455: goto L23;
                case -838846263: goto L19;
                case 107944136: goto Lf;
                default: goto Le;
            }
        Le:
            goto L37
        Lf:
            java.lang.String r7 = "query"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L37
            r7 = 3
            goto L38
        L19:
            java.lang.String r7 = "update"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L37
            r7 = 1
            goto L38
        L23:
            java.lang.String r7 = "insert"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L37
            r7 = 0
            goto L38
        L2d:
            java.lang.String r7 = "delete"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L37
            r7 = 2
            goto L38
        L37:
            r7 = -1
        L38:
            if (r7 == 0) goto Lc0
            if (r7 == r4) goto L9f
            if (r7 == r3) goto L84
            if (r7 == r1) goto L5b
            boolean r7 = com.tk.core.o.t.isDebug()
            if (r7 == 0) goto L59
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "can't find method ---> "
            r7.<init>(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "TKContentResolver"
            android.util.Log.e(r8, r7)
        L59:
            r7 = 0
            return r7
        L5b:
            java.lang.Object r7 = com.tk.core.o.a.b(r9, r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r4)
            r2 = r8
            com.tkruntime.v8.V8Array r2 = (com.tkruntime.v8.V8Array) r2
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r3)
            r3 = r8
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r1)
            r4 = r8
            com.tkruntime.v8.V8Array r4 = (com.tkruntime.v8.V8Array) r4
            r8 = 4
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r8)
            r5 = r8
            java.lang.String r5 = (java.lang.String) r5
            r1 = r7
            com.tkruntime.v8.V8Object r7 = r0.a(r1, r2, r3, r4, r5)
            return r7
        L84:
            java.lang.Object r7 = com.tk.core.o.a.b(r9, r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r4)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = com.tk.core.o.a.b(r9, r3)
            com.tkruntime.v8.V8Array r9 = (com.tkruntime.v8.V8Array) r9
            int r7 = r0.a(r7, r8, r9)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            return r7
        L9f:
            java.lang.Object r7 = com.tk.core.o.a.b(r9, r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r4)
            com.tkruntime.v8.V8Object r8 = (com.tkruntime.v8.V8Object) r8
            java.lang.Object r2 = com.tk.core.o.a.b(r9, r3)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r9 = com.tk.core.o.a.b(r9, r1)
            com.tkruntime.v8.V8Array r9 = (com.tkruntime.v8.V8Array) r9
            int r7 = r0.a(r7, r8, r2, r9)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            return r7
        Lc0:
            java.lang.Object r7 = com.tk.core.o.a.b(r9, r2)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r4)
            com.tkruntime.v8.V8Object r8 = (com.tkruntime.v8.V8Object) r8
            java.lang.String r7 = r0.b(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.e.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
