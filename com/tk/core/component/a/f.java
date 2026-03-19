package com.tk.core.component.a;

import android.util.Log;
import com.component.a.a.b;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.a.e;
import com.tk.core.o.t;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.util.ArrayList;
import java.util.Map;
import kotlinx.coroutines.DebugKt;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f implements com.tk.core.manager.a.a<e> {
    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
    }

    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "keyframes";
            case 1:
                return "timeFunction";
            case 2:
                return "timingFunction";
            case 3:
                return "needTranformIdentity";
            case 4:
                return "duration";
            case 5:
                return "animType";
            case 6:
                return "animValue";
            case 7:
                return "autoReverse";
            case 8:
                return "repeatCount";
            case 9:
                return b.e.c;
            case 10:
                return "setEndValue";
            case 11:
                return "setAnimations";
            case 12:
                return "setStartValue";
            case 13:
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
        return "2#keyframes#0,2#timeFunction#1,2#timingFunction#2,2#needTranformIdentity#3,2#duration#4,2#animType#5,2#animValue#6,2#autoReverse#7,2#repeatCount#8,2#delay#9,4#setEndValue#10,4#setAnimations#11,4#setStartValue#12,4#on#13";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ e b(NativeModuleInitParams nativeModuleInitParams) {
        return ah(nativeModuleInitParams);
    }

    private static e ah(NativeModuleInitParams nativeModuleInitParams) {
        return new e(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
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
                case -1992012396: goto L67;
                case -1446666299: goto L5d;
                case -795585301: goto L53;
                case -291235277: goto L49;
                case 95467907: goto L3e;
                case 1107788256: goto L34;
                case 1512032515: goto L2a;
                case 1571519540: goto L1f;
                case 1723534789: goto L15;
                case 2045697602: goto Lb;
                default: goto L9;
            }
        L9:
            goto L71
        Lb:
            java.lang.String r0 = "timingFunction"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 2
            goto L72
        L15:
            java.lang.String r0 = "timeFunction"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 1
            goto L72
        L1f:
            java.lang.String r0 = "repeatCount"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 8
            goto L72
        L2a:
            java.lang.String r0 = "needTranformIdentity"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 3
            goto L72
        L34:
            java.lang.String r0 = "animValue"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 6
            goto L72
        L3e:
            java.lang.String r0 = "delay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 9
            goto L72
        L49:
            java.lang.String r0 = "autoReverse"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 7
            goto L72
        L53:
            java.lang.String r0 = "animType"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 5
            goto L72
        L5d:
            java.lang.String r0 = "keyframes"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 0
            goto L72
        L67:
            java.lang.String r0 = "duration"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 4
            goto L72
        L71:
            r4 = -1
        L72:
            switch(r4) {
                case 0: goto L76;
                case 1: goto L76;
                case 2: goto L76;
                case 3: goto L76;
                case 4: goto L76;
                case 5: goto L76;
                case 6: goto L76;
                case 7: goto L76;
                case 8: goto L76;
                case 9: goto L76;
                default: goto L75;
            }
        L75:
            return r2
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.f.g(java.lang.String):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = -1105637327(0xffffffffbe195031, float:-0.14971997)
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == r1) goto L3a
            r1 = -588970024(0xffffffffdce507d8, float:-5.1573115E17)
            if (r0 == r1) goto L30
            r1 = 3551(0xddf, float:4.976E-42)
            if (r0 == r1) goto L26
            r1 = 790453105(0x2f1d5b71, float:1.4311553E-10)
            if (r0 == r1) goto L1c
            goto L44
        L1c:
            java.lang.String r0 = "setAnimations"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L44
            r7 = 1
            goto L45
        L26:
            java.lang.String r0 = "on"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L44
            r7 = 3
            goto L45
        L30:
            java.lang.String r0 = "setEndValue"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L44
            r7 = 0
            goto L45
        L3a:
            java.lang.String r0 = "setStartValue"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L44
            r7 = 2
            goto L45
        L44:
            r7 = -1
        L45:
            if (r7 == 0) goto L4e
            if (r7 == r5) goto L4e
            if (r7 == r4) goto L4e
            if (r7 == r3) goto L4e
            return r2
        L4e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.f.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        e eVar = (e) obj;
        try {
            switch (str) {
                case "keyframes":
                    eVar.a((ArrayList<e.a>) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "timeFunction":
                    eVar.bI((String) obj2);
                    break;
                case "timingFunction":
                    eVar.bJ((String) obj2);
                    break;
                case "needTranformIdentity":
                    eVar.ach = ((Boolean) obj2).booleanValue();
                    break;
                case "duration":
                    eVar.C(com.tk.core.manager.a.f.g((Number) obj2));
                    break;
                case "animType":
                    eVar.bK((String) obj2);
                    break;
                case "animValue":
                    eVar.B(V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "autoReverse":
                    eVar.aq(((Boolean) obj2).booleanValue());
                    break;
                case "repeatCount":
                    eVar.setRepeatCount(com.tk.core.manager.a.f.h((Number) obj2));
                    break;
                case "delay":
                    eVar.setDelay(com.tk.core.manager.a.f.g((Number) obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKKeyframeAnimation", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKKeyframeAnimation apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            r1 = this;
            com.tk.core.component.a.e r2 = (com.tk.core.component.a.e) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1992012396: goto L67;
                case -1446666299: goto L5d;
                case -795585301: goto L53;
                case -291235277: goto L49;
                case 95467907: goto L3e;
                case 1107788256: goto L34;
                case 1512032515: goto L2a;
                case 1571519540: goto L1f;
                case 1723534789: goto L15;
                case 2045697602: goto Lb;
                default: goto L9;
            }
        L9:
            goto L71
        Lb:
            java.lang.String r0 = "timingFunction"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L15:
            java.lang.String r0 = "timeFunction"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 1
            goto L72
        L1f:
            java.lang.String r0 = "repeatCount"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L2a:
            java.lang.String r0 = "needTranformIdentity"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
            goto L72
        L34:
            java.lang.String r0 = "animValue"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L3e:
            java.lang.String r0 = "delay"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 9
            goto L72
        L49:
            java.lang.String r0 = "autoReverse"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L53:
            java.lang.String r0 = "animType"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 5
            goto L72
        L5d:
            java.lang.String r0 = "keyframes"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 0
            goto L72
        L67:
            java.lang.String r0 = "duration"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 4
            goto L72
        L71:
            r0 = -1
        L72:
            switch(r0) {
                case 0: goto Lbe;
                case 1: goto Lbb;
                case 2: goto Lb8;
                case 3: goto Lb1;
                case 4: goto Laa;
                case 5: goto La7;
                case 6: goto La4;
                case 7: goto L9d;
                case 8: goto L96;
                case 9: goto L8f;
                default: goto L75;
            }
        L75:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto Lc1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKKeyframeAnimation"
            android.util.Log.e(r3, r2)
            goto Lc1
        L8f:
            float r2 = r2.abQ
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            return r2
        L96:
            int r2 = r2.repeatCount
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            return r2
        L9d:
            boolean r2 = r2.abU
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La4:
            java.lang.Object r2 = r2.abO
            return r2
        La7:
            java.lang.String r2 = r2.abP
            return r2
        Laa:
            float r2 = r2.abS
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            return r2
        Lb1:
            boolean r2 = r2.ach
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lb8:
            java.lang.String r2 = r2.abT
            return r2
        Lbb:
            java.lang.String r2 = r2.abR
            return r2
        Lbe:
            java.util.ArrayList<com.tk.core.component.a.e$a> r2 = r2.acr
            return r2
        Lc1:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.f.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            r6 = this;
            com.tk.core.component.a.e r7 = (com.tk.core.component.a.e) r7
            int r0 = r8.hashCode()
            r1 = -1105637327(0xffffffffbe195031, float:-0.14971997)
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r0 == r1) goto L3c
            r1 = -588970024(0xffffffffdce507d8, float:-5.1573115E17)
            if (r0 == r1) goto L32
            r1 = 3551(0xddf, float:4.976E-42)
            if (r0 == r1) goto L28
            r1 = 790453105(0x2f1d5b71, float:1.4311553E-10)
            if (r0 == r1) goto L1e
            goto L46
        L1e:
            java.lang.String r0 = "setAnimations"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L46
            r0 = 1
            goto L47
        L28:
            java.lang.String r0 = "on"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L46
            r0 = 3
            goto L47
        L32:
            java.lang.String r0 = "setEndValue"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L46
            r0 = 0
            goto L47
        L3c:
            java.lang.String r0 = "setStartValue"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L46
            r0 = 2
            goto L47
        L46:
            r0 = -1
        L47:
            r1 = 0
            if (r0 == 0) goto L8a
            if (r0 == r4) goto L82
            if (r0 == r3) goto L7a
            if (r0 == r2) goto L6a
            boolean r7 = com.tk.core.o.t.isDebug()
            if (r7 == 0) goto L69
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "can't find method ---> "
            r7.<init>(r9)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "TKKeyframeAnimation"
            android.util.Log.e(r8, r7)
        L69:
            return r1
        L6a:
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r5)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = com.tk.core.o.a.b(r9, r4)
            com.tkruntime.v8.V8Function r9 = (com.tkruntime.v8.V8Function) r9
            r7.m(r8, r9)
            return r1
        L7a:
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r5)
            r7.C(r8)
            return r1
        L82:
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r5)
            r7.G(r8)
            return r1
        L8a:
            java.lang.Object r8 = com.tk.core.o.a.b(r9, r5)
            r7.D(r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.a.f.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
