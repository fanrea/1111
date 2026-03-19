package com.tk.component.container.round;

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

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "disable";
            case 1:
                return "nativeID";
            case 2:
                return "style";
            case 3:
                return "keyboardDismissMode";
            case 4:
                return "onPress";
            case 5:
                return "enabled";
            case 6:
                return "clipChildren";
            case 7:
                return "disallowParentInterceptTouchEvent";
            case 8:
                return "pivotPoint";
            case 9:
                return "onLongPress";
            case 10:
                return "setRotateY";
            case 11:
                return "resumeAnimations";
            case 12:
                return "removeChild";
            case 13:
                return "setScaleY";
            case 14:
                return "addEventListener";
            case 15:
                return "addAnimation";
            case 16:
                return "_setVNode";
            case 17:
                return "observeNextLayout";
            case 18:
                return "removeEventListener";
            case 19:
                return "setScaleX";
            case 20:
                return "startViewAnimation";
            case 21:
                return "removeAnimation";
            case 22:
                return "layout";
            case 23:
                return "removeSelf";
            case 24:
                return "invokeNativeFunctionWithJSONString";
            case 25:
                return "setBackgroundColor";
            case 26:
                return "removeAll";
            case 27:
                return "setTranslateY";
            case 28:
                return "insertBefore";
            case 29:
                return "removeAllAnimation";
            case 30:
                return "getSize";
            case 31:
                return "setVisibility";
            case 32:
                return "getOrigin";
            case 33:
                return "setRotateX";
            case 34:
                return "getElementById";
            case 35:
                return "pauseAnimations";
            case 36:
                return "setGradientBgColor";
            case 37:
                return "replaceChild";
            case 38:
                return "setRotate";
            case 39:
                return "getLocationOnScreen";
            case 40:
                return "appendChild";
            case 41:
                return "invokeVoidNativeFunctionWithJSONString";
            case 42:
                return "setTranslateX";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#disable#0,2#nativeID#1,2#style#2,2#keyboardDismissMode#3,2#onPress#4,2#enabled#5,2#clipChildren#6,2#disallowParentInterceptTouchEvent#7,2#pivotPoint#8,2#onLongPress#9,4#setRotateY#10,4#resumeAnimations#11,4#removeChild#12,4#setScaleY#13,4#addEventListener#14,4#addAnimation#15,4#_setVNode#16,4#observeNextLayout#17,4#removeEventListener#18,4#setScaleX#19,4#startViewAnimation#20,4#removeAnimation#21,4#layout#22,4#removeSelf#23,8#invokeNativeFunctionWithJSONString#24,4#setBackgroundColor#25,4#removeAll#26,4#setTranslateY#27,4#insertBefore#28,4#removeAllAnimation#29,8#getSize#30,4#setVisibility#31,8#getOrigin#32,4#setRotateX#33,8#getElementById#34,4#pauseAnimations#35,4#setGradientBgColor#36,4#replaceChild#37,4#setRotate#38,8#getLocationOnScreen#39,4#appendChild#40,4#invokeVoidNativeFunctionWithJSONString#41,4#setTranslateX#42";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return P(nativeModuleInitParams);
    }

    private static a P(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:110:0x019e  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 636
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.container.round.b.f(java.lang.String):boolean");
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
                case -1609594047: goto L67;
                case -1339721308: goto L5d;
                case -1221113672: goto L53;
                case -764307226: goto L49;
                case 83417096: goto L3e;
                case 109780401: goto L34;
                case 1090721135: goto L2a;
                case 1281290862: goto L1f;
                case 1671308008: goto L15;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L71
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 1
            goto L72
        L15:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 0
            goto L72
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 8
            goto L72
        L2a:
            java.lang.String r0 = "clipChildren"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 6
            goto L72
        L34:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 2
            goto L72
        L3e:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 9
            goto L72
        L49:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 3
            goto L72
        L53:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 7
            goto L72
        L5d:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 4
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 5
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.container.round.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0187  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.container.round.b.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        try {
            switch (str) {
                case "disable":
                    aVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    aVar.bk((String) obj2);
                    break;
                case "style":
                    aVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "keyboardDismissMode":
                    aVar.aq((String) obj2);
                    break;
                case "onPress":
                    aVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "enabled":
                    aVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "clipChildren":
                    aVar.setClipChildren(((Boolean) obj2).booleanValue());
                    break;
                case "disallowParentInterceptTouchEvent":
                    aVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "pivotPoint":
                    aVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onLongPress":
                    aVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKRoundRectView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKRoundRectView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.tk.component.container.round.a r2 = (com.tk.component.container.round.a) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L67;
                case -1339721308: goto L5d;
                case -1221113672: goto L53;
                case -764307226: goto L49;
                case 83417096: goto L3e;
                case 109780401: goto L34;
                case 1090721135: goto L2a;
                case 1281290862: goto L1f;
                case 1671308008: goto L15;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L71
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 1
            goto L72
        L15:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 0
            goto L72
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L2a:
            java.lang.String r0 = "clipChildren"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L34:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L3e:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 9
            goto L72
        L49:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
            goto L72
        L53:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L5d:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 4
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 5
            goto L72
        L71:
            r0 = -1
        L72:
            switch(r0) {
                case 0: goto Lb6;
                case 1: goto Lb3;
                case 2: goto Lb0;
                case 3: goto Lad;
                case 4: goto Laa;
                case 5: goto La3;
                case 6: goto L9c;
                case 7: goto L95;
                case 8: goto L92;
                case 9: goto L8f;
                default: goto L75;
            }
        L75:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto Lbd
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKRoundRectView"
            android.util.Log.e(r3, r2)
            goto Lbd
        L8f:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L92:
            java.util.HashMap r2 = r2.aaQ
            return r2
        L95:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L9c:
            boolean r2 = r2.XE
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La3:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Laa:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        Lad:
            java.lang.String r2 = r2.PT
            return r2
        Lb0:
            java.util.HashMap r2 = r2.style
            return r2
        Lb3:
            java.lang.String r2 = r2.aaG
            return r2
        Lb6:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lbd:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.container.round.b.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 16;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 23;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = '!';
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 31;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 27;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 29;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 22;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 1;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 21;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 6;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 5;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 28;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(f.T)) {
                        c = 7;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 24;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 30;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 25;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar.bx((String) obj2);
                    return;
                case 1:
                    aVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 2:
                    aVar.by((String) obj2);
                    return;
                case 3:
                    aVar.bp((String) obj2);
                    return;
                case 4:
                    aVar.bn((String) obj2);
                    return;
                case 5:
                    aVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 6:
                    aVar.bg((String) obj2);
                    return;
                case 7:
                    aVar.A(obj2);
                    return;
                case '\b':
                    aVar.bt((String) obj2);
                    return;
                case '\t':
                    aVar.aB((String) obj2);
                    return;
                case '\n':
                    aVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 11:
                    aVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\f':
                    aVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\r':
                    aVar.bv((String) obj2);
                    return;
                case 14:
                    aVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 15:
                    aVar.bf((String) obj2);
                    return;
                case 16:
                    aVar.bs((String) obj2);
                    return;
                case 17:
                    aVar.bo((String) obj2);
                    return;
                case 18:
                    aVar.br((String) obj2);
                    return;
                case 19:
                    aVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 20:
                    aVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 21:
                    aVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    aVar.bq((String) obj2);
                    return;
                case 23:
                    aVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 24:
                    aVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 25:
                    aVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 26:
                    aVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 27:
                    aVar.bz((String) obj2);
                    return;
                case 28:
                    aVar.bA((String) obj2);
                    return;
                case 29:
                    aVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 30:
                    aVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 31:
                    aVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case ' ':
                    aVar.bm((String) obj2);
                    return;
                case '!':
                    aVar.bw((String) obj2);
                    return;
                case '\"':
                    aVar.bu((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKRoundRectView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKRoundRectView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x018a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.container.round.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
