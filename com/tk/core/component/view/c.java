package com.tk.core.component.view;

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
public final class c implements com.tk.core.manager.a.a<TKView> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "disallowParentInterceptTouchEvent";
            case 1:
                return "nativeID";
            case 2:
                return "pivotPoint";
            case 3:
                return "onPress";
            case 4:
                return "clipChildren";
            case 5:
                return "onLongPress";
            case 6:
                return "enabled";
            case 7:
                return "style";
            case 8:
                return "keyboardDismissMode";
            case 9:
                return "disable";
            case 10:
                return "removeChild";
            case 11:
                return "invokeVoidNativeFunctionWithJSONString";
            case 12:
                return "startViewAnimation";
            case 13:
                return "addAnimation";
            case 14:
                return "pauseAnimations";
            case 15:
                return "removeAnimation";
            case 16:
                return "setGradientBgColor";
            case 17:
                return "setScaleX";
            case 18:
                return "setBackgroundColor";
            case 19:
                return "setRotate";
            case 20:
                return "setScaleY";
            case 21:
                return "appendChild";
            case 22:
                return "invokeNativeFunctionWithJSONString";
            case 23:
                return "getOrigin";
            case 24:
                return "insertBefore";
            case 25:
                return "setTranslateY";
            case 26:
                return "_setVNode";
            case 27:
                return "setVisibility";
            case 28:
                return "addEventListener";
            case 29:
                return "removeAllAnimation";
            case 30:
                return "getLocationOnScreen";
            case 31:
                return "getElementById";
            case 32:
                return "removeEventListener";
            case 33:
                return "setTranslateX";
            case 34:
                return "removeSelf";
            case 35:
                return "layout";
            case 36:
                return "resumeAnimations";
            case 37:
                return "observeNextLayout";
            case 38:
                return "setRotateY";
            case 39:
                return "removeAll";
            case 40:
                return "setRotateX";
            case 41:
                return "replaceChild";
            case 42:
                return "getSize";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#disallowParentInterceptTouchEvent#0,2#nativeID#1,2#pivotPoint#2,2#onPress#3,2#clipChildren#4,2#onLongPress#5,2#enabled#6,2#style#7,2#keyboardDismissMode#8,2#disable#9,4#removeChild#10,4#invokeVoidNativeFunctionWithJSONString#11,4#startViewAnimation#12,4#addAnimation#13,4#pauseAnimations#14,4#removeAnimation#15,4#setGradientBgColor#16,4#setScaleX#17,4#setBackgroundColor#18,4#setRotate#19,4#setScaleY#20,4#appendChild#21,8#invokeNativeFunctionWithJSONString#22,8#getOrigin#23,4#insertBefore#24,4#setTranslateY#25,4#_setVNode#26,4#setVisibility#27,4#addEventListener#28,4#removeAllAnimation#29,8#getLocationOnScreen#30,8#getElementById#31,4#removeEventListener#32,4#setTranslateX#33,4#removeSelf#34,4#layout#35,4#resumeAnimations#36,4#observeNextLayout#37,4#setRotateY#38,4#removeAll#39,4#setRotateX#40,4#replaceChild#41,8#getSize#42";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ TKView b(NativeModuleInitParams nativeModuleInitParams) {
        return as(nativeModuleInitParams);
    }

    private static TKView as(NativeModuleInitParams nativeModuleInitParams) {
        return new TKView(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.view.c.f(java.lang.String):boolean");
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
                case -764307226: goto L48;
                case 83417096: goto L3e;
                case 109780401: goto L34;
                case 1090721135: goto L2a;
                case 1281290862: goto L20;
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
            r4 = 9
            goto L72
        L20:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 2
            goto L72
        L2a:
            java.lang.String r0 = "clipChildren"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 4
            goto L72
        L34:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 7
            goto L72
        L3e:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 5
            goto L72
        L48:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 8
            goto L72
        L53:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 0
            goto L72
        L5d:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 3
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 6
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.view.c.g(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.view.c.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        TKView tKView = (TKView) obj;
        try {
            switch (str) {
                case "disallowParentInterceptTouchEvent":
                    tKView.ap(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    tKView.bk((String) obj2);
                    break;
                case "pivotPoint":
                    tKView.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onPress":
                    tKView.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "clipChildren":
                    tKView.setClipChildren(((Boolean) obj2).booleanValue());
                    break;
                case "onLongPress":
                    tKView.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "enabled":
                    tKView.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "style":
                    tKView.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "keyboardDismissMode":
                    tKView.aq((String) obj2);
                    break;
                case "disable":
                    tKView.ao(((Boolean) obj2).booleanValue());
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.tk.core.component.view.TKView r2 = (com.tk.core.component.view.TKView) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L67;
                case -1339721308: goto L5d;
                case -1221113672: goto L53;
                case -764307226: goto L48;
                case 83417096: goto L3e;
                case 109780401: goto L34;
                case 1090721135: goto L2a;
                case 1281290862: goto L20;
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
            r0 = 9
            goto L72
        L20:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L2a:
            java.lang.String r0 = "clipChildren"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 4
            goto L72
        L34:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L3e:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 5
            goto L72
        L48:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L53:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 0
            goto L72
        L5d:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L71:
            r0 = -1
        L72:
            switch(r0) {
                case 0: goto Lb6;
                case 1: goto Lb3;
                case 2: goto Lb0;
                case 3: goto Lad;
                case 4: goto La6;
                case 5: goto La3;
                case 6: goto L9c;
                case 7: goto L99;
                case 8: goto L96;
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
            java.lang.String r3 = "TKView"
            android.util.Log.e(r3, r2)
            goto Lbd
        L8f:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L96:
            java.lang.String r2 = r2.PT
            return r2
        L99:
            java.util.HashMap r2 = r2.style
            return r2
        L9c:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La3:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        La6:
            boolean r2 = r2.XE
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lad:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        Lb0:
            java.util.HashMap r2 = r2.aaQ
            return r2
        Lb3:
            java.lang.String r2 = r2.aaG
            return r2
        Lb6:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lbd:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.view.c.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        TKView tKView = (TKView) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals("borderRightColor")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 16;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 21;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 24;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 23;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 31;
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
                        c = 25;
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
                        c = '\t';
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 30;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 1;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = 20;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 3;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 7;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 19;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 4;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(f.T)) {
                        c = JSONLexer.EOI;
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
                        c = 27;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = '!';
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 14;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 18;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    tKView.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 1:
                    tKView.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 2:
                    tKView.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 3:
                    tKView.bg((String) obj2);
                    return;
                case 4:
                    tKView.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 5:
                    tKView.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 6:
                    tKView.bo((String) obj2);
                    return;
                case 7:
                    tKView.aB((String) obj2);
                    return;
                case '\b':
                    tKView.bA((String) obj2);
                    return;
                case '\t':
                    tKView.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\n':
                    tKView.bt((String) obj2);
                    return;
                case 11:
                    tKView.bs((String) obj2);
                    return;
                case '\f':
                    tKView.by((String) obj2);
                    return;
                case '\r':
                    tKView.bv((String) obj2);
                    return;
                case 14:
                    tKView.bm((String) obj2);
                    return;
                case 15:
                    tKView.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 16:
                    tKView.bx((String) obj2);
                    return;
                case 17:
                    tKView.bf((String) obj2);
                    return;
                case 18:
                    tKView.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 19:
                    tKView.bu((String) obj2);
                    return;
                case 20:
                    tKView.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 21:
                    tKView.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 22:
                    tKView.bp((String) obj2);
                    return;
                case 23:
                    tKView.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 24:
                    tKView.bw((String) obj2);
                    return;
                case 25:
                    tKView.bq((String) obj2);
                    return;
                case 26:
                    tKView.A(obj2);
                    return;
                case 27:
                    tKView.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 28:
                    tKView.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 29:
                    tKView.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 30:
                    tKView.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 31:
                    tKView.bz((String) obj2);
                    return;
                case ' ':
                    tKView.bn((String) obj2);
                    return;
                case '!':
                    tKView.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    tKView.br((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0189  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.view.c.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
