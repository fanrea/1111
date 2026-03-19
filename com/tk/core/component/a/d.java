package com.tk.core.component.a;

import android.util.Log;
import com.component.a.a.b;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.Map;
import kotlinx.coroutines.DebugKt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements com.tk.core.manager.a.a<c> {
    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return b.e.c;
            case 1:
                return "duration";
            case 2:
                return "repeatCount";
            case 3:
                return "animValue";
            case 4:
                return "animType";
            case 5:
                return "autoReverse";
            case 6:
                return "timingFunction";
            case 7:
                return "timeFunction";
            case 8:
                return "setStartValue";
            case 9:
                return "setEndValue";
            case 10:
                return DebugKt.DEBUG_PROPERTY_VALUE_ON;
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
        return "2#delay#0,2#duration#1,2#repeatCount#2,2#animValue#3,2#animType#4,2#autoReverse#5,2#timingFunction#6,2#timeFunction#7,4#setStartValue#8,4#setEndValue#9,4#on#10";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return ag(nativeModuleInitParams);
    }

    private static c ag(NativeModuleInitParams nativeModuleInitParams) {
        return new c(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = 1
            r2 = 0
            switch(r0) {
                case -1992012396: goto L50;
                case -795585301: goto L46;
                case -291235277: goto L3c;
                case 95467907: goto L32;
                case 1107788256: goto L28;
                case 1571519540: goto L1e;
                case 1723534789: goto L14;
                case 2045697602: goto La;
                default: goto L9;
            }
        L9:
            goto L5a
        La:
            java.lang.String r0 = "timingFunction"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 6
            goto L5b
        L14:
            java.lang.String r0 = "timeFunction"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 7
            goto L5b
        L1e:
            java.lang.String r0 = "repeatCount"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 2
            goto L5b
        L28:
            java.lang.String r0 = "animValue"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 3
            goto L5b
        L32:
            java.lang.String r0 = "delay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 0
            goto L5b
        L3c:
            java.lang.String r0 = "autoReverse"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 5
            goto L5b
        L46:
            java.lang.String r0 = "animType"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 4
            goto L5b
        L50:
            java.lang.String r0 = "duration"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 1
            goto L5b
        L5a:
            r4 = -1
        L5b:
            switch(r4) {
                case 0: goto L5f;
                case 1: goto L5f;
                case 2: goto L5f;
                case 3: goto L5f;
                case 4: goto L5f;
                case 5: goto L5f;
                case 6: goto L5f;
                case 7: goto L5f;
                default: goto L5e;
            }
        L5e:
            return r2
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.d.g(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1105637327(0xffffffffbe195031, float:-0.14971997)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2a
            r1 = -588970024(0xffffffffdce507d8, float:-5.1573115E17)
            if (r0 == r1) goto L20
            r1 = 3551(0xddf, float:4.976E-42)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "on"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 2
            goto L35
        L20:
            java.lang.String r0 = "setEndValue"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 1
            goto L35
        L2a:
            java.lang.String r0 = "setStartValue"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L34
            r6 = 0
            goto L35
        L34:
            r6 = -1
        L35:
            if (r6 == 0) goto L3c
            if (r6 == r4) goto L3c
            if (r6 == r3) goto L3c
            return r2
        L3c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.d.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        c cVar = (c) obj;
        try {
            switch (str) {
                case "delay":
                    cVar.setDelay(com.tk.core.manager.a.f.g((Number) obj2));
                    break;
                case "duration":
                    cVar.C(com.tk.core.manager.a.f.g((Number) obj2));
                    break;
                case "repeatCount":
                    cVar.setRepeatCount(com.tk.core.manager.a.f.h((Number) obj2));
                    break;
                case "animValue":
                    cVar.B(V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "animType":
                    cVar.bK((String) obj2);
                    break;
                case "autoReverse":
                    cVar.aq(((Boolean) obj2).booleanValue());
                    break;
                case "timingFunction":
                    cVar.bJ((String) obj2);
                    break;
                case "timeFunction":
                    cVar.bI((String) obj2);
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKBasicAnimation", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKBasicAnimation apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            r1 = this;
            com.tk.core.component.a.c r2 = (com.tk.core.component.a.c) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1992012396: goto L50;
                case -795585301: goto L46;
                case -291235277: goto L3c;
                case 95467907: goto L32;
                case 1107788256: goto L28;
                case 1571519540: goto L1e;
                case 1723534789: goto L14;
                case 2045697602: goto La;
                default: goto L9;
            }
        L9:
            goto L5a
        La:
            java.lang.String r0 = "timingFunction"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 6
            goto L5b
        L14:
            java.lang.String r0 = "timeFunction"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 7
            goto L5b
        L1e:
            java.lang.String r0 = "repeatCount"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 2
            goto L5b
        L28:
            java.lang.String r0 = "animValue"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 3
            goto L5b
        L32:
            java.lang.String r0 = "delay"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 0
            goto L5b
        L3c:
            java.lang.String r0 = "autoReverse"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 5
            goto L5b
        L46:
            java.lang.String r0 = "animType"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 4
            goto L5b
        L50:
            java.lang.String r0 = "duration"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 1
            goto L5b
        L5a:
            r0 = -1
        L5b:
            switch(r0) {
                case 0: goto L99;
                case 1: goto L92;
                case 2: goto L8b;
                case 3: goto L88;
                case 4: goto L85;
                case 5: goto L7e;
                case 6: goto L7b;
                case 7: goto L78;
                default: goto L5e;
            }
        L5e:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto La0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKBasicAnimation"
            android.util.Log.e(r3, r2)
            goto La0
        L78:
            java.lang.String r2 = r2.abR
            return r2
        L7b:
            java.lang.String r2 = r2.abT
            return r2
        L7e:
            boolean r2 = r2.abU
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L85:
            java.lang.String r2 = r2.abP
            return r2
        L88:
            java.lang.Object r2 = r2.abO
            return r2
        L8b:
            int r2 = r2.repeatCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L92:
            float r2 = r2.abS
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            return r2
        L99:
            float r2 = r2.abQ
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            return r2
        La0:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.d.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r6, java.lang.String r7, java.lang.Object[] r8) {
        /*
            r5 = this;
            com.tk.core.component.a.c r6 = (com.tk.core.component.a.c) r6
            int r0 = r7.hashCode()
            r1 = -1105637327(0xffffffffbe195031, float:-0.14971997)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 == r1) goto L2c
            r1 = -588970024(0xffffffffdce507d8, float:-5.1573115E17)
            if (r0 == r1) goto L22
            r1 = 3551(0xddf, float:4.976E-42)
            if (r0 == r1) goto L18
            goto L36
        L18:
            java.lang.String r0 = "on"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 2
            goto L37
        L22:
            java.lang.String r0 = "setEndValue"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 1
            goto L37
        L2c:
            java.lang.String r0 = "setStartValue"
            boolean r0 = r7.equals(r0)
            if (r0 == 0) goto L36
            r0 = 0
            goto L37
        L36:
            r0 = -1
        L37:
            r1 = 0
            if (r0 == 0) goto L70
            if (r0 == r3) goto L68
            if (r0 == r2) goto L58
            boolean r6 = com.tk.core.o.t.isDebug()
            if (r6 == 0) goto L57
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "can't find method ---> "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "TKBasicAnimation"
            android.util.Log.e(r7, r6)
        L57:
            return r1
        L58:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = com.tk.core.o.a.b(r8, r3)
            com.tkruntime.v8.V8Function r8 = (com.tkruntime.v8.V8Function) r8
            r6.m(r7, r8)
            return r1
        L68:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            r6.D(r7)
            return r1
        L70:
            java.lang.Object r7 = com.tk.core.o.a.b(r8, r4)
            r6.C(r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.d.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
