package com.kwad.tachikoma.e;

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
            return "registerReceiver";
        }
        if (i == 1) {
            return "sendBroadcast";
        }
        if (i == 2) {
            return "getPackageManager";
        }
        if (i == 3) {
            return "unregisterReceiver";
        }
        if (i == 4) {
            return "startPage";
        }
        if (i != 5) {
            return null;
        }
        return "getContentResolver";
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
        return "8#registerReceiver#0,4#sendBroadcast#1,8#getPackageManager#2,4#unregisterReceiver#3,4#startPage#4,8#getContentResolver#5";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ e b(NativeModuleInitParams nativeModuleInitParams) {
        return m(nativeModuleInitParams);
    }

    private static e m(NativeModuleInitParams nativeModuleInitParams) {
        return new e(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 0
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -2129421807: goto L40;
                case -1411698151: goto L36;
                case -1039717966: goto L2c;
                case 482608509: goto L22;
                case 1102112331: goto L18;
                case 1618976105: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "getContentResolver"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 2
            goto L4b
        L18:
            java.lang.String r0 = "unregisterReceiver"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 4
            goto L4b
        L22:
            java.lang.String r0 = "getPackageManager"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 1
            goto L4b
        L2c:
            java.lang.String r0 = "registerReceiver"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 0
            goto L4b
        L36:
            java.lang.String r0 = "sendBroadcast"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 3
            goto L4b
        L40:
            java.lang.String r0 = "startPage"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 5
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L59
            if (r8 == r6) goto L59
            if (r8 == r5) goto L59
            if (r8 == r4) goto L58
            if (r8 == r3) goto L58
            if (r8 == r2) goto L58
            return r1
        L58:
            return r6
        L59:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.e.f.h(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r9, java.lang.String r10, java.lang.Object[] r11) {
        /*
            r8 = this;
            com.kwad.tachikoma.e.e r9 = (com.kwad.tachikoma.e.e) r9
            int r0 = r10.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            switch(r0) {
                case -2129421807: goto L42;
                case -1411698151: goto L38;
                case -1039717966: goto L2e;
                case 482608509: goto L24;
                case 1102112331: goto L1a;
                case 1618976105: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L4c
        L10:
            java.lang.String r0 = "getContentResolver"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 5
            goto L4d
        L1a:
            java.lang.String r0 = "unregisterReceiver"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 3
            goto L4d
        L24:
            java.lang.String r0 = "getPackageManager"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 2
            goto L4d
        L2e:
            java.lang.String r0 = "registerReceiver"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 0
            goto L4d
        L38:
            java.lang.String r0 = "sendBroadcast"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 1
            goto L4d
        L42:
            java.lang.String r0 = "startPage"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L4c
            r0 = 4
            goto L4d
        L4c:
            r0 = -1
        L4d:
            if (r0 == 0) goto Laa
            r7 = 0
            if (r0 == r5) goto L96
            if (r0 == r4) goto L91
            if (r0 == r3) goto L83
            if (r0 == r2) goto L79
            if (r0 == r1) goto L74
            boolean r9 = com.tk.core.o.t.isDebug()
            if (r9 == 0) goto L73
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "can't find method ---> "
            r9.<init>(r11)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "TKNativeContext"
            android.util.Log.e(r10, r9)
        L73:
            return r7
        L74:
            com.tkruntime.v8.V8Object r9 = r9.ig()
            return r9
        L79:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            com.tkruntime.v8.V8Object r10 = (com.tkruntime.v8.V8Object) r10
            r9.h(r10)
            return r7
        L83:
            java.lang.Object r10 = com.tk.core.o.a.c(r11, r6)
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = com.tk.core.manager.a.f.h(r10)
            r9.bX(r10)
            return r7
        L91:
            com.tkruntime.v8.V8Object r9 = r9.m463if()
            return r9
        L96:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            com.tkruntime.v8.V8Object r10 = (com.tkruntime.v8.V8Object) r10
            java.lang.Object r11 = com.tk.core.o.a.d(r11, r5)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            r9.a(r10, r11)
            return r7
        Laa:
            java.lang.Object r10 = com.tk.core.o.a.b(r11, r6)
            com.tkruntime.v8.V8Object r10 = (com.tkruntime.v8.V8Object) r10
            java.lang.Object r0 = com.tk.core.o.a.b(r11, r5)
            com.tkruntime.v8.V8Function r0 = (com.tkruntime.v8.V8Function) r0
            java.lang.Object r11 = com.tk.core.o.a.d(r11, r4)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            int r9 = r9.a(r10, r0, r11)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.e.f.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
