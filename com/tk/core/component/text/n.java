package com.tk.core.component.text;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.parser.JSONLexer;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class n implements com.tk.core.manager.a.a<m> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "enabled";
            case 1:
                return "onPress";
            case 2:
                return "disallowParentInterceptTouchEvent";
            case 3:
                return "nativeID";
            case 4:
                return "text";
            case 5:
                return "style";
            case 6:
                return "disable";
            case 7:
                return "pivotPoint";
            case 8:
                return "onLongPress";
            case 9:
                return "setText";
            case 10:
                return "observeNextLayout";
            case 11:
                return "invokeNativeFunctionWithJSONString";
            case 12:
                return "addAnimation";
            case 13:
                return "setRotateX";
            case 14:
                return "setTranslateY";
            case 15:
                return "removeEventListener";
            case 16:
                return "getSize";
            case 17:
                return "addEventListener";
            case 18:
                return "setRotateY";
            case 19:
                return "getLocationOnScreen";
            case 20:
                return "setGradientBgColor";
            case 21:
                return "resumeAnimations";
            case 22:
                return "invokeVoidNativeFunctionWithJSONString";
            case 23:
                return "setBackgroundColor";
            case 24:
                return "removeSelf";
            case 25:
                return "setRotate";
            case 26:
                return "startViewAnimation";
            case 27:
                return "removeAnimation";
            case 28:
                return "layout";
            case 29:
                return "pauseAnimations";
            case 30:
                return "setTranslateX";
            case 31:
                return "_setVNode";
            case 32:
                return "setVisibility";
            case 33:
                return "getOrigin";
            case 34:
                return "setScaleX";
            case 35:
                return "removeAllAnimation";
            case 36:
                return "setScaleY";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#enabled#0,2#onPress#1,2#disallowParentInterceptTouchEvent#2,2#nativeID#3,2#text#4,2#style#5,2#disable#6,2#pivotPoint#7,2#onLongPress#8,4#setText#9,4#observeNextLayout#10,8#invokeNativeFunctionWithJSONString#11,4#addAnimation#12,4#setRotateX#13,4#setTranslateY#14,4#removeEventListener#15,8#getSize#16,4#addEventListener#17,4#setRotateY#18,8#getLocationOnScreen#19,4#setGradientBgColor#20,4#resumeAnimations#21,4#invokeVoidNativeFunctionWithJSONString#22,4#setBackgroundColor#23,4#removeSelf#24,4#setRotate#25,4#startViewAnimation#26,4#removeAnimation#27,4#layout#28,4#pauseAnimations#29,4#setTranslateX#30,4#_setVNode#31,4#setVisibility#32,8#getOrigin#33,4#setScaleX#34,4#removeAllAnimation#35,4#setScaleY#36";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ m b(NativeModuleInitParams nativeModuleInitParams) {
        return ao(nativeModuleInitParams);
    }

    private static m ao(NativeModuleInitParams nativeModuleInitParams) {
        return new m(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c2  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.n.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
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
                case -1609594047: goto L5b;
                case -1339721308: goto L51;
                case -1221113672: goto L47;
                case 3556653: goto L3d;
                case 83417096: goto L32;
                case 109780401: goto L28;
                case 1281290862: goto L1e;
                case 1671308008: goto L14;
                case 2045685618: goto La;
                default: goto L9;
            }
        L9:
            goto L65
        La:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 3
            goto L66
        L14:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 6
            goto L66
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 7
            goto L66
        L28:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 5
            goto L66
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 8
            goto L66
        L3d:
            java.lang.String r0 = "text"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 4
            goto L66
        L47:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 2
            goto L66
        L51:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 1
            goto L66
        L5b:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 0
            goto L66
        L65:
            r4 = -1
        L66:
            switch(r4) {
                case 0: goto L6a;
                case 1: goto L6a;
                case 2: goto L6a;
                case 3: goto L6a;
                case 4: goto L6a;
                case 5: goto L6a;
                case 6: goto L6a;
                case 7: goto L6a;
                case 8: goto L6a;
                default: goto L69;
            }
        L69:
            return r2
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.n.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014b  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 512
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.n.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        m mVar = (m) obj;
        try {
            switch (str) {
                case "enabled":
                    mVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "onPress":
                    mVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    mVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    mVar.bk((String) obj2);
                    break;
                case "text":
                    mVar.setText((String) obj2);
                    break;
                case "style":
                    mVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disable":
                    mVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "pivotPoint":
                    mVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onLongPress":
                    mVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKMarqueeText", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKMarqueeText apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            r1 = this;
            com.tk.core.component.text.m r2 = (com.tk.core.component.text.m) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L5b;
                case -1339721308: goto L51;
                case -1221113672: goto L47;
                case 3556653: goto L3d;
                case 83417096: goto L32;
                case 109780401: goto L28;
                case 1281290862: goto L1e;
                case 1671308008: goto L14;
                case 2045685618: goto La;
                default: goto L9;
            }
        L9:
            goto L65
        La:
            java.lang.String r0 = "nativeID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 3
            goto L66
        L14:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 6
            goto L66
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 7
            goto L66
        L28:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 5
            goto L66
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 8
            goto L66
        L3d:
            java.lang.String r0 = "text"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 4
            goto L66
        L47:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 2
            goto L66
        L51:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 1
            goto L66
        L5b:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 0
            goto L66
        L65:
            r0 = -1
        L66:
            switch(r0) {
                case 0: goto La3;
                case 1: goto La0;
                case 2: goto L99;
                case 3: goto L96;
                case 4: goto L93;
                case 5: goto L90;
                case 6: goto L89;
                case 7: goto L86;
                case 8: goto L83;
                default: goto L69;
            }
        L69:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto Laa
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKMarqueeText"
            android.util.Log.e(r3, r2)
            goto Laa
        L83:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L86:
            java.util.HashMap r2 = r2.aaQ
            return r2
        L89:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L90:
            java.util.HashMap r2 = r2.style
            return r2
        L93:
            java.lang.String r2 = r2.KE
            return r2
        L96:
            java.lang.String r2 = r2.aaG
            return r2
        L99:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La0:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        La3:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Laa:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.n.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        m mVar = (m) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals("borderRightColor")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 27;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = '#';
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 21;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 30;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = '%';
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 29;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 22;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 17;
                        break;
                    }
                    break;
                case -734428249:
                    if (str.equals("fontWeight")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 6;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 4;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 24;
                        break;
                    }
                    break;
                case 94842723:
                    if (str.equals(TypedValues.Custom.S_COLOR)) {
                        c = 0;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 20;
                        break;
                    }
                    break;
                case 365601008:
                    if (str.equals("fontSize")) {
                        c = 23;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 25;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = 18;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 5;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 31;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 28;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 16;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = '!';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    mVar.aj((String) obj2);
                    return;
                case 1:
                    mVar.br((String) obj2);
                    return;
                case 2:
                    mVar.bs((String) obj2);
                    return;
                case 3:
                    mVar.bA((String) obj2);
                    return;
                case 4:
                    mVar.bq((String) obj2);
                    return;
                case 5:
                    mVar.aB((String) obj2);
                    return;
                case 6:
                    mVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 7:
                    mVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\b':
                    mVar.A(obj2);
                    return;
                case '\t':
                    mVar.bw((String) obj2);
                    return;
                case '\n':
                    mVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 11:
                    mVar.bp((String) obj2);
                    return;
                case '\f':
                    mVar.bv((String) obj2);
                    return;
                case '\r':
                    mVar.bf((String) obj2);
                    return;
                case 14:
                    mVar.bx((String) obj2);
                    return;
                case 15:
                    mVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 16:
                    mVar.bm((String) obj2);
                    return;
                case 17:
                    mVar.bz((String) obj2);
                    return;
                case 18:
                    mVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 19:
                    mVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 20:
                    mVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 21:
                    mVar.bo((String) obj2);
                    return;
                case 22:
                    mVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 23:
                    mVar.dF(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 24:
                    mVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 25:
                    mVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 26:
                    mVar.bg((String) obj2);
                    return;
                case 27:
                    mVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 28:
                    mVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 29:
                    mVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 30:
                    mVar.by((String) obj2);
                    return;
                case 31:
                    mVar.bu((String) obj2);
                    return;
                case ' ':
                    mVar.bS((String) obj2);
                    return;
                case '!':
                    mVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    mVar.bt((String) obj2);
                    return;
                case '#':
                    mVar.bn((String) obj2);
                    return;
                case '$':
                    mVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '%':
                    mVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKMarqueeText", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKMarqueeText setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014e  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.n.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
