package com.tk.component.a;

import android.util.Log;
import com.alibaba.fastjson.parser.JSONLexer;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements com.tk.core.manager.a.a<c> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "onPress";
            case 1:
                return "pivotPoint";
            case 2:
                return "disable";
            case 3:
                return "disallowParentInterceptTouchEvent";
            case 4:
                return "onLongPress";
            case 5:
                return "enabled";
            case 6:
                return "nativeID";
            case 7:
                return "checkVisiblePreDraw";
            case 8:
                return "onSizeChanged";
            case 9:
                return "style";
            case 10:
                return "layerType";
            case 11:
                return "onDraw";
            case 12:
                return "setRotateY";
            case 13:
                return "invokeVoidNativeFunctionWithJSONString";
            case 14:
                return "pauseAnimations";
            case 15:
                return "addAnimation";
            case 16:
                return "layout";
            case 17:
                return "setTranslateX";
            case 18:
                return "setRotate";
            case 19:
                return "setScaleX";
            case 20:
                return "removeEventListener";
            case 21:
                return "invokeNativeFunctionWithJSONString";
            case 22:
                return "resumeAnimations";
            case 23:
                return "getSize";
            case 24:
                return "setRotateX";
            case 25:
                return "_setVNode";
            case 26:
                return "getOrigin";
            case 27:
                return "requestDraw";
            case 28:
                return "setGradientBgColor";
            case 29:
                return "addEventListener";
            case 30:
                return "getLocationOnScreen";
            case 31:
                return "setBackgroundColor";
            case 32:
                return "removeAnimation";
            case 33:
                return "setVisibility";
            case 34:
                return "setTranslateY";
            case 35:
                return "setScaleY";
            case 36:
                return "startViewAnimation";
            case 37:
                return "removeAllAnimation";
            case 38:
                return "observeNextLayout";
            case 39:
                return "removeSelf";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#onPress#0,2#pivotPoint#1,2#disable#2,2#disallowParentInterceptTouchEvent#3,2#onLongPress#4,2#enabled#5,2#nativeID#6,2#checkVisiblePreDraw#7,2#onSizeChanged#8,2#style#9,2#layerType#10,2#onDraw#11,4#setRotateY#12,4#invokeVoidNativeFunctionWithJSONString#13,4#pauseAnimations#14,4#addAnimation#15,4#layout#16,4#setTranslateX#17,4#setRotate#18,4#setScaleX#19,4#removeEventListener#20,8#invokeNativeFunctionWithJSONString#21,4#resumeAnimations#22,8#getSize#23,4#setRotateX#24,4#_setVNode#25,8#getOrigin#26,4#requestDraw#27,4#setGradientBgColor#28,4#addEventListener#29,8#getLocationOnScreen#30,4#setBackgroundColor#31,4#removeAnimation#32,4#setVisibility#33,4#setTranslateY#34,4#setScaleY#35,4#startViewAnimation#36,4#removeAllAnimation#37,4#observeNextLayout#38,4#removeSelf#39";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return K(nativeModuleInitParams);
    }

    private static c K(NativeModuleInitParams nativeModuleInitParams) {
        return new c(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:110:0x019d  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.d.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
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
                case -1725812515: goto L7f;
                case -1664432085: goto L74;
                case -1609594047: goto L6a;
                case -1339721308: goto L60;
                case -1221113672: goto L56;
                case -1013405757: goto L4b;
                case 83417096: goto L41;
                case 109780401: goto L36;
                case 1281290862: goto L2c;
                case 1671308008: goto L22;
                case 1696714772: goto L16;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L89
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 6
            goto L8a
        L16:
            java.lang.String r0 = "onSizeChanged"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 8
            goto L8a
        L22:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 2
            goto L8a
        L2c:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 1
            goto L8a
        L36:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 9
            goto L8a
        L41:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 4
            goto L8a
        L4b:
            java.lang.String r0 = "onDraw"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 11
            goto L8a
        L56:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 3
            goto L8a
        L60:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 0
            goto L8a
        L6a:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 5
            goto L8a
        L74:
            java.lang.String r0 = "layerType"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 10
            goto L8a
        L7f:
            java.lang.String r0 = "checkVisiblePreDraw"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 7
            goto L8a
        L89:
            r4 = -1
        L8a:
            switch(r4) {
                case 0: goto L8e;
                case 1: goto L8e;
                case 2: goto L8e;
                case 3: goto L8e;
                case 4: goto L8e;
                case 5: goto L8e;
                case 6: goto L8e;
                case 7: goto L8e;
                case 8: goto L8e;
                case 9: goto L8e;
                case 10: goto L8e;
                case 11: goto L8e;
                default: goto L8d;
            }
        L8d:
            return r2
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.d.g(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.d.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        c cVar = (c) obj;
        try {
            switch (str) {
                case "onPress":
                    cVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "pivotPoint":
                    cVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disable":
                    cVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "disallowParentInterceptTouchEvent":
                    cVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "onLongPress":
                    cVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "enabled":
                    cVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    cVar.bk((String) obj2);
                    break;
                case "checkVisiblePreDraw":
                    cVar.setCheckVisiblePreDraw(((Boolean) obj2).booleanValue());
                    break;
                case "onSizeChanged":
                    cVar.K((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "style":
                    cVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "layerType":
                    cVar.cz(com.tk.core.manager.a.f.h((Number) obj2));
                    break;
                case "onDraw":
                    cVar.L((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKCanvas2DView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKCanvas2DView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.tk.component.a.c r2 = (com.tk.component.a.c) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L67;
                case -1339721308: goto L5d;
                case -1221113672: goto L53;
                case -1013405757: goto L48;
                case 83417096: goto L3e;
                case 109780401: goto L33;
                case 1281290862: goto L29;
                case 1671308008: goto L1f;
                case 1696714772: goto L15;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L71
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L15:
            java.lang.String r0 = "onSizeChanged"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L1f:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L29:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 1
            goto L72
        L33:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L3e:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 4
            goto L72
        L48:
            java.lang.String r0 = "onDraw"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 9
            goto L72
        L53:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
            goto L72
        L5d:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 0
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
                case 2: goto Lac;
                case 3: goto La5;
                case 4: goto La2;
                case 5: goto L9b;
                case 6: goto L98;
                case 7: goto L95;
                case 8: goto L92;
                case 9: goto L8f;
                default: goto L75;
            }
        L75:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto Lb9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKCanvas2DView"
            android.util.Log.e(r3, r2)
            goto Lb9
        L8f:
            com.tkruntime.v8.V8Function r2 = r2.Oh
            return r2
        L92:
            java.util.HashMap r2 = r2.style
            return r2
        L95:
            com.tkruntime.v8.V8Function r2 = r2.Of
            return r2
        L98:
            java.lang.String r2 = r2.aaG
            return r2
        L9b:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La2:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        La5:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lac:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lb3:
            java.util.HashMap r2 = r2.aaQ
            return r2
        Lb6:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        Lb9:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.d.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        c cVar = (c) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals("borderRightColor")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 31;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 30;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 25;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = '\"';
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
                        c = 19;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 29;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 24;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = '!';
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 27;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 1;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 15;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 5;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = 22;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 28;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 3;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 14;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = JSONLexer.EOI;
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
                        c = 17;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 4;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = 20;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 16;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = StringUtil.CARRIAGE_RETURN;
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
                        c = 0;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 23;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    cVar.bm((String) obj2);
                    return;
                case 1:
                    cVar.bz((String) obj2);
                    return;
                case 2:
                    cVar.bw((String) obj2);
                    return;
                case 3:
                    cVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 4:
                    cVar.bu((String) obj2);
                    return;
                case 5:
                    cVar.bq((String) obj2);
                    return;
                case 6:
                    cVar.bo((String) obj2);
                    return;
                case 7:
                    cVar.bx((String) obj2);
                    return;
                case '\b':
                    cVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\t':
                    cVar.bg((String) obj2);
                    return;
                case '\n':
                    cVar.bA((String) obj2);
                    return;
                case 11:
                    cVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\f':
                    cVar.bp((String) obj2);
                    return;
                case '\r':
                    cVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 14:
                    cVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 15:
                    cVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 16:
                    cVar.bf((String) obj2);
                    return;
                case 17:
                    cVar.aB((String) obj2);
                    return;
                case 18:
                    cVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 19:
                    cVar.bt((String) obj2);
                    return;
                case 20:
                    cVar.A(obj2);
                    return;
                case 21:
                    cVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    cVar.bv((String) obj2);
                    return;
                case 23:
                    cVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 24:
                    cVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 25:
                    cVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 26:
                    cVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 27:
                    cVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 28:
                    cVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 29:
                    cVar.by((String) obj2);
                    return;
                case 30:
                    cVar.br((String) obj2);
                    return;
                case 31:
                    cVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case ' ':
                    cVar.bs((String) obj2);
                    return;
                case '!':
                    cVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    cVar.bn((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKCanvas2DView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKCanvas2DView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014d  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 896
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.a.d.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
