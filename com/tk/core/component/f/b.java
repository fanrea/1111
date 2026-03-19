package com.tk.core.component.f;

import android.util.Log;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.mobads.container.n.f;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "style";
            case 1:
                return "pivotPoint";
            case 2:
                return "onLongPress";
            case 3:
                return "disallowParentInterceptTouchEvent";
            case 4:
                return "enabled";
            case 5:
                return "onPress";
            case 6:
                return "nativeID";
            case 7:
                return "checked";
            case 8:
                return "disable";
            case 9:
                return "removeSelf";
            case 10:
                return "removeAllAnimation";
            case 11:
                return "setRotate";
            case 12:
                return "startViewAnimation";
            case 13:
                return "invokeVoidNativeFunctionWithJSONString";
            case 14:
                return "setScaleX";
            case 15:
                return "setGradientBgColor";
            case 16:
                return "setTranslateX";
            case 17:
                return "addEventListener";
            case 18:
                return "removeAnimation";
            case 19:
                return "pauseAnimations";
            case 20:
                return "setRotateY";
            case 21:
                return "setScaleY";
            case 22:
                return "setRotateX";
            case 23:
                return "getSize";
            case 24:
                return "layout";
            case 25:
                return "setTranslateY";
            case 26:
                return "setBackgroundColor";
            case 27:
                return "removeEventListener";
            case 28:
                return "resumeAnimations";
            case 29:
                return "setVisibility";
            case 30:
                return "_setVNode";
            case 31:
                return "observeNextLayout";
            case 32:
                return "getLocationOnScreen";
            case 33:
                return "addAnimation";
            case 34:
                return "getOrigin";
            case 35:
                return "invokeNativeFunctionWithJSONString";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#style#0,2#pivotPoint#1,2#onLongPress#2,2#disallowParentInterceptTouchEvent#3,2#enabled#4,2#onPress#5,2#nativeID#6,2#checked#7,2#disable#8,4#removeSelf#9,4#removeAllAnimation#10,4#setRotate#11,4#startViewAnimation#12,4#invokeVoidNativeFunctionWithJSONString#13,4#setScaleX#14,4#setGradientBgColor#15,4#setTranslateX#16,4#addEventListener#17,4#removeAnimation#18,4#pauseAnimations#19,4#setRotateY#20,4#setScaleY#21,4#setRotateX#22,8#getSize#23,4#layout#24,4#setTranslateY#25,4#setBackgroundColor#26,4#removeEventListener#27,4#resumeAnimations#28,4#setVisibility#29,4#_setVNode#30,4#observeNextLayout#31,8#getLocationOnScreen#32,4#addAnimation#33,8#getOrigin#34,8#invokeNativeFunctionWithJSONString#35";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return am(nativeModuleInitParams);
    }

    private static a am(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.f.b.f(java.lang.String):boolean");
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
                case 83417096: goto L3d;
                case 109780401: goto L33;
                case 742313895: goto L29;
                case 1281290862: goto L1f;
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
            r4 = 6
            goto L66
        L14:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 8
            goto L66
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 1
            goto L66
        L29:
            java.lang.String r0 = "checked"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 7
            goto L66
        L33:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 0
            goto L66
        L3d:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 2
            goto L66
        L47:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 3
            goto L66
        L51:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 5
            goto L66
        L5b:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 4
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.f.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013f  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.f.b.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        try {
            switch (str) {
                case "style":
                    aVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "pivotPoint":
                    aVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onLongPress":
                    aVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    aVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "enabled":
                    aVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "onPress":
                    aVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "nativeID":
                    aVar.bk((String) obj2);
                    break;
                case "checked":
                    aVar.setChecked(((Boolean) obj2).booleanValue());
                    break;
                case "disable":
                    aVar.ao(((Boolean) obj2).booleanValue());
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKSwitch", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKSwitch apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.tk.core.component.f.a r2 = (com.tk.core.component.f.a) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L5b;
                case -1339721308: goto L51;
                case -1221113672: goto L47;
                case 83417096: goto L3d;
                case 109780401: goto L33;
                case 742313895: goto L29;
                case 1281290862: goto L1f;
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
            r0 = 6
            goto L66
        L14:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 8
            goto L66
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 1
            goto L66
        L29:
            java.lang.String r0 = "checked"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 7
            goto L66
        L33:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 0
            goto L66
        L3d:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 2
            goto L66
        L47:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 3
            goto L66
        L51:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 5
            goto L66
        L5b:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 4
            goto L66
        L65:
            r0 = -1
        L66:
            switch(r0) {
                case 0: goto Lab;
                case 1: goto La8;
                case 2: goto La5;
                case 3: goto L9e;
                case 4: goto L97;
                case 5: goto L94;
                case 6: goto L91;
                case 7: goto L8a;
                case 8: goto L83;
                default: goto L69;
            }
        L69:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto Lae
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKSwitch"
            android.util.Log.e(r3, r2)
            goto Lae
        L83:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L8a:
            boolean r2 = r2.aeK
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L91:
            java.lang.String r2 = r2.aaG
            return r2
        L94:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L97:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L9e:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La5:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        La8:
            java.util.HashMap r2 = r2.aaQ
            return r2
        Lab:
            java.util.HashMap r2 = r2.style
            return r2
        Lae:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.f.b.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals("borderRightColor")) {
                        c = 31;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case -1742453971:
                    if (str.equals("thumbColor")) {
                        c = '%';
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1351809852:
                    if (str.equals("onColor")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 29;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = '!';
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 23;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 14;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 27;
                        break;
                    }
                    break;
                case -800022732:
                    if (str.equals("offColor")) {
                        c = 6;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 24;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = 11;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 16;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = '#';
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 21;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 25;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 0;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(f.T)) {
                        c = 4;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 28;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 30;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 1:
                    aVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 2:
                    aVar.bm((String) obj2);
                    return;
                case 3:
                    aVar.bt((String) obj2);
                    return;
                case 4:
                    aVar.A(obj2);
                    return;
                case 5:
                    aVar.bA((String) obj2);
                    return;
                case 6:
                    aVar.cl((String) obj2);
                    return;
                case 7:
                    aVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\b':
                    aVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\t':
                    aVar.bg((String) obj2);
                    return;
                case '\n':
                    aVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 11:
                    aVar.bv((String) obj2);
                    return;
                case '\f':
                    aVar.bq((String) obj2);
                    return;
                case '\r':
                    aVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 14:
                    aVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 15:
                    aVar.bn((String) obj2);
                    return;
                case 16:
                    aVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 17:
                    aVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 18:
                    aVar.ck((String) obj2);
                    return;
                case 19:
                    aVar.br((String) obj2);
                    return;
                case 20:
                    aVar.bx((String) obj2);
                    return;
                case 21:
                    aVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    aVar.bp((String) obj2);
                    return;
                case 23:
                    aVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 24:
                    aVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 25:
                    aVar.bu((String) obj2);
                    return;
                case 26:
                    aVar.aB((String) obj2);
                    return;
                case 27:
                    aVar.bz((String) obj2);
                    return;
                case 28:
                    aVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 29:
                    aVar.bo((String) obj2);
                    return;
                case 30:
                    aVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 31:
                    aVar.bs((String) obj2);
                    return;
                case ' ':
                    aVar.bf((String) obj2);
                    return;
                case '!':
                    aVar.by((String) obj2);
                    return;
                case '\"':
                    aVar.bw((String) obj2);
                    return;
                case '#':
                    aVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '$':
                    aVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '%':
                    aVar.cm((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKSwitch", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKSwitch setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0141  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 874
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.f.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
