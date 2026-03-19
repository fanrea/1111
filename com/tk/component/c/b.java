package com.tk.component.c;

import android.util.Log;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "mask";
            case 1:
                return "cancelable";
            case 2:
                return "maskColor";
            case 3:
                return "keyboardDismissMode";
            case 4:
                return "ondismiss";
            case 5:
                return "onmaskclick";
            case 6:
                return "confirm";
            case 7:
                return SchedulerSupport.CUSTOM;
            case 8:
                return "alert";
            case 9:
                return "dismiss";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final boolean f(String str) {
        return false;
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#mask#0,2#cancelable#1,2#maskColor#2,2#keyboardDismissMode#3,2#ondismiss#4,2#onmaskclick#5,8#confirm#6,8#custom#7,8#alert#8,8#dismiss#9";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return Q(nativeModuleInitParams);
    }

    private static a Q(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r8) {
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
                case -2083107043: goto L40;
                case -764307226: goto L36;
                case -77812777: goto L2c;
                case 3344108: goto L22;
                case 1343298507: goto L18;
                case 1889007316: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "cancelable"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 1
            goto L4b
        L18:
            java.lang.String r0 = "ondismiss"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 4
            goto L4b
        L22:
            java.lang.String r0 = "mask"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 0
            goto L4b
        L2c:
            java.lang.String r0 = "maskColor"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 2
            goto L4b
        L36:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 3
            goto L4b
        L40:
            java.lang.String r0 = "onmaskclick"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = 5
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L58
            if (r8 == r6) goto L58
            if (r8 == r5) goto L58
            if (r8 == r4) goto L58
            if (r8 == r3) goto L58
            if (r8 == r2) goto L58
            return r1
        L58:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.c.b.g(java.lang.String):boolean");
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
                case -1349088399: goto L2a;
                case 92899676: goto L20;
                case 951117504: goto L16;
                case 1671672458: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L34
        Lc:
            java.lang.String r0 = "dismiss"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 3
            goto L35
        L16:
            java.lang.String r0 = "confirm"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 0
            goto L35
        L20:
            java.lang.String r0 = "alert"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 2
            goto L35
        L2a:
            java.lang.String r0 = "custom"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.c.b.h(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -2083107043:
                    if (str.equals("onmaskclick")) {
                        c = 5;
                        break;
                    }
                    break;
                case -764307226:
                    if (str.equals("keyboardDismissMode")) {
                        c = 3;
                        break;
                    }
                    break;
                case -77812777:
                    if (str.equals("maskColor")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3344108:
                    if (str.equals("mask")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1343298507:
                    if (str.equals("ondismiss")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1889007316:
                    if (str.equals("cancelable")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                aVar.PP = ((Boolean) obj2).booleanValue();
            } else if (c == 1) {
                aVar.PO = ((Boolean) obj2).booleanValue();
            } else if (c == 2) {
                aVar.ap((String) obj2);
            } else if (c == 3) {
                aVar.aq((String) obj2);
            } else if (c == 4) {
                aVar.P((V8Function) V8ObjectUtilsQuick.getValue(obj2));
            } else if (c == 5) {
                aVar.Q((V8Function) V8ObjectUtilsQuick.getValue(obj2));
            } else {
                if (!t.isDebug()) {
                    return false;
                }
                Log.e("Dialog", "call applyProp() with unsupported prop: " + str);
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Dialog apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8) {
        /*
            r6 = this;
            com.tk.component.c.a r7 = (com.tk.component.c.a) r7
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -2083107043: goto L41;
                case -764307226: goto L37;
                case -77812777: goto L2d;
                case 3344108: goto L23;
                case 1343298507: goto L19;
                case 1889007316: goto Lf;
                default: goto Le;
            }
        Le:
            goto L4b
        Lf:
            java.lang.String r0 = "cancelable"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 1
            goto L4c
        L19:
            java.lang.String r0 = "ondismiss"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 4
            goto L4c
        L23:
            java.lang.String r0 = "mask"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 0
            goto L4c
        L2d:
            java.lang.String r0 = "maskColor"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 2
            goto L4c
        L37:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 3
            goto L4c
        L41:
            java.lang.String r0 = "onmaskclick"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L4b
            r0 = 5
            goto L4c
        L4b:
            r0 = -1
        L4c:
            if (r0 == 0) goto L86
            if (r0 == r5) goto L7f
            if (r0 == r4) goto L7c
            if (r0 == r3) goto L79
            if (r0 == r2) goto L76
            if (r0 == r1) goto L73
            boolean r7 = com.tk.core.o.t.isDebug()
            if (r7 == 0) goto L71
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r7.<init>(r0)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "Dialog"
            android.util.Log.e(r8, r7)
        L71:
            r7 = 0
            return r7
        L73:
            com.tkruntime.v8.V8Function r7 = r7.PS
            return r7
        L76:
            com.tkruntime.v8.V8Function r7 = r7.PR
            return r7
        L79:
            java.lang.String r7 = r7.PT
            return r7
        L7c:
            java.lang.String r7 = r7.PQ
            return r7
        L7f:
            boolean r7 = r7.PO
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        L86:
            boolean r7 = r7.PP
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.c.b.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
            r7 = this;
            r0 = r8
            com.tk.component.c.a r0 = (com.tk.component.c.a) r0
            int r8 = r9.hashCode()
            r1 = 3
            r2 = 0
            r3 = 2
            r4 = 1
            switch(r8) {
                case -1349088399: goto L2d;
                case 92899676: goto L23;
                case 951117504: goto L19;
                case 1671672458: goto Lf;
                default: goto Le;
            }
        Le:
            goto L37
        Lf:
            java.lang.String r8 = "dismiss"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L37
            r8 = 3
            goto L38
        L19:
            java.lang.String r8 = "confirm"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L37
            r8 = 0
            goto L38
        L23:
            java.lang.String r8 = "alert"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L37
            r8 = 2
            goto L38
        L2d:
            java.lang.String r8 = "custom"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L37
            r8 = 1
            goto L38
        L37:
            r8 = -1
        L38:
            if (r8 == 0) goto L82
            if (r8 == r4) goto L77
            if (r8 == r3) goto L60
            if (r8 == r1) goto L5b
            boolean r8 = com.tk.core.o.t.isDebug()
            if (r8 == 0) goto L59
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "can't find method ---> "
            r8.<init>(r10)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "Dialog"
            android.util.Log.e(r9, r8)
        L59:
            r8 = 0
            return r8
        L5b:
            java.lang.Object r8 = r0.mO()
            return r8
        L60:
            java.lang.Object r8 = com.tk.core.o.a.b(r10, r2)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = com.tk.core.o.a.b(r10, r4)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = com.tk.core.o.a.b(r10, r3)
            com.tkruntime.v8.V8Function r10 = (com.tkruntime.v8.V8Function) r10
            java.lang.Object r8 = r0.b(r8, r9, r10)
            return r8
        L77:
            java.lang.Object r8 = com.tk.core.o.a.b(r10, r2)
            com.tkruntime.v8.V8Object r8 = (com.tkruntime.v8.V8Object) r8
            java.lang.Object r8 = r0.s(r8)
            return r8
        L82:
            java.lang.Object r8 = com.tk.core.o.a.b(r10, r2)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = com.tk.core.o.a.b(r10, r4)
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r9 = com.tk.core.o.a.b(r10, r3)
            r3 = r9
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r9 = com.tk.core.o.a.b(r10, r1)
            r4 = r9
            java.lang.String r4 = (java.lang.String) r4
            r9 = 4
            java.lang.Object r9 = com.tk.core.o.a.b(r10, r9)
            r5 = r9
            com.tkruntime.v8.V8Function r5 = (com.tkruntime.v8.V8Function) r5
            r9 = 5
            java.lang.Object r9 = com.tk.core.o.a.b(r10, r9)
            r6 = r9
            com.tkruntime.v8.V8Function r6 = (com.tkruntime.v8.V8Function) r6
            r1 = r8
            java.lang.Object r8 = r0.a(r1, r2, r3, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.c.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
