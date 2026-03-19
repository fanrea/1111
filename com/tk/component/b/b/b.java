package com.tk.component.b.b;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        if (i == 0) {
            return "onSuccess";
        }
        if (i == 1) {
            return "onFail";
        }
        if (i == 2) {
            return "getSize";
        }
        if (i != 3) {
            return null;
        }
        return "load";
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#onSuccess#0,2#onFail#1,8#getSize#2,4#load#3";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return O(nativeModuleInitParams);
    }

    private static a O(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1013362275(0xffffffffc399519d, float:-306.6376)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = -530890460(0xffffffffe05b4124, float:-6.3195794E19)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "onSuccess"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 0
            goto L26
        L1b:
            java.lang.String r0 = "onFail"
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.b.b.g(java.lang.String):boolean");
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
            r1 = -75151241(0xfffffffffb854877, float:-1.3840905E36)
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L1b
            r1 = 3327206(0x32c4e6, float:4.662409E-39)
            if (r0 == r1) goto L11
            goto L25
        L11:
            java.lang.String r0 = "load"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 1
            goto L26
        L1b:
            java.lang.String r0 = "getSize"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L25
            r5 = 0
            goto L26
        L25:
            r5 = -1
        L26:
            if (r5 == 0) goto L2c
            if (r5 == r3) goto L2b
            return r2
        L2b:
            return r3
        L2c:
            r5 = 2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.b.b.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        char c = 65535;
        try {
            int iHashCode = str.hashCode();
            if (iHashCode != -1013362275) {
                if (iHashCode == -530890460 && str.equals("onSuccess")) {
                    c = 0;
                }
            } else if (str.equals("onFail")) {
                c = 1;
            }
            if (c == 0) {
                aVar.N((V8Function) V8ObjectUtilsQuick.getValue(obj2));
            } else if (c == 1) {
                aVar.O((V8Function) V8ObjectUtilsQuick.getValue(obj2));
            } else {
                if (!t.isDebug()) {
                    return false;
                }
                Log.e("TKImageResource", "call applyProp() with unsupported prop: " + str);
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKImageResource apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r4, java.lang.String r5) {
        /*
            r3 = this;
            com.tk.component.b.b.a r4 = (com.tk.component.b.b.a) r4
            int r0 = r5.hashCode()
            r1 = -1013362275(0xffffffffc399519d, float:-306.6376)
            r2 = 1
            if (r0 == r1) goto L1c
            r1 = -530890460(0xffffffffe05b4124, float:-6.3195794E19)
            if (r0 == r1) goto L12
            goto L26
        L12:
            java.lang.String r0 = "onSuccess"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L26
            r0 = 0
            goto L27
        L1c:
            java.lang.String r0 = "onFail"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L26
            r0 = 1
            goto L27
        L26:
            r0 = -1
        L27:
            if (r0 == 0) goto L49
            if (r0 == r2) goto L46
            boolean r4 = com.tk.core.o.t.isDebug()
            if (r4 == 0) goto L44
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r4.<init>(r0)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "TKImageResource"
            android.util.Log.e(r5, r4)
        L44:
            r4 = 0
            return r4
        L46:
            com.tkruntime.v8.V8Function r4 = r4.Pz
            return r4
        L49:
            com.tkruntime.v8.V8Function r4 = r4.Px
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.b.b.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r3, java.lang.String r4, java.lang.Object[] r5) {
        /*
            r2 = this;
            com.tk.component.b.b.a r3 = (com.tk.component.b.b.a) r3
            int r5 = r4.hashCode()
            r0 = -75151241(0xfffffffffb854877, float:-1.3840905E36)
            r1 = 1
            if (r5 == r0) goto L1c
            r0 = 3327206(0x32c4e6, float:4.662409E-39)
            if (r5 == r0) goto L12
            goto L26
        L12:
            java.lang.String r5 = "load"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L26
            r5 = 1
            goto L27
        L1c:
            java.lang.String r5 = "getSize"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L26
            r5 = 0
            goto L27
        L26:
            r5 = -1
        L27:
            if (r5 == 0) goto L4a
            r0 = 0
            if (r5 == r1) goto L46
            boolean r3 = com.tk.core.o.t.isDebug()
            if (r3 == 0) goto L45
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "can't find method ---> "
            r3.<init>(r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "TKImageResource"
            android.util.Log.e(r4, r3)
        L45:
            return r0
        L46:
            r3.mL()
            return r0
        L4a:
            java.util.Map r3 = r3.mM()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.b.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
