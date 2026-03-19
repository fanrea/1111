package com.kwad.tachikoma.v;

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
public final class e implements com.tk.core.manager.a.a<d> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "nativeID";
            case 1:
                return "clipChildren";
            case 2:
                return "style";
            case 3:
                return "disallowParentInterceptTouchEvent";
            case 4:
                return "enabled";
            case 5:
                return "pivotPoint";
            case 6:
                return "keyboardDismissMode";
            case 7:
                return "disable";
            case 8:
                return "onPress";
            case 9:
                return "onLongPress";
            case 10:
                return "getElementById";
            case 11:
                return "getOrigin";
            case 12:
                return "appendChild";
            case 13:
                return "setScaleX";
            case 14:
                return "observeNextLayout";
            case 15:
                return "insertBefore";
            case 16:
                return "pauseAnimations";
            case 17:
                return "setTouchDownInterceptor";
            case 18:
                return "setRotateY";
            case 19:
                return "getSize";
            case 20:
                return "setTranslateY";
            case 21:
                return "setGradientBgColor";
            case 22:
                return "setRotateX";
            case 23:
                return "removeAllAnimation";
            case 24:
                return "setRotate";
            case 25:
                return "removeAnimation";
            case 26:
                return "replaceChild";
            case 27:
                return "setScaleY";
            case 28:
                return "startViewAnimation";
            case 29:
                return "removeSelf";
            case 30:
                return "layout";
            case 31:
                return "_setVNode";
            case 32:
                return "resumeAnimations";
            case 33:
                return "setTranslateX";
            case 34:
                return "addEventListener";
            case 35:
                return "setBackgroundColor";
            case 36:
                return "addAnimation";
            case 37:
                return "invokeVoidNativeFunctionWithJSONString";
            case 38:
                return "removeEventListener";
            case 39:
                return "getLocationOnScreen";
            case 40:
                return "invokeNativeFunctionWithJSONString";
            case 41:
                return "removeAll";
            case 42:
                return "removeChild";
            case 43:
                return "setVisibility";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#nativeID#0,2#clipChildren#1,2#style#2,2#disallowParentInterceptTouchEvent#3,2#enabled#4,2#pivotPoint#5,2#keyboardDismissMode#6,2#disable#7,2#onPress#8,2#onLongPress#9,8#getElementById#10,8#getOrigin#11,4#appendChild#12,4#setScaleX#13,4#observeNextLayout#14,4#insertBefore#15,4#pauseAnimations#16,4#setTouchDownInterceptor#17,4#setRotateY#18,8#getSize#19,4#setTranslateY#20,4#setGradientBgColor#21,4#setRotateX#22,4#removeAllAnimation#23,4#setRotate#24,4#removeAnimation#25,4#replaceChild#26,4#setScaleY#27,4#startViewAnimation#28,4#removeSelf#29,4#layout#30,4#_setVNode#31,4#resumeAnimations#32,4#setTranslateX#33,4#addEventListener#34,4#setBackgroundColor#35,4#addAnimation#36,4#invokeVoidNativeFunctionWithJSONString#37,4#removeEventListener#38,8#getLocationOnScreen#39,8#invokeNativeFunctionWithJSONString#40,4#removeAll#41,4#removeChild#42,4#setVisibility#43";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ d b(NativeModuleInitParams nativeModuleInitParams) {
        return G(nativeModuleInitParams);
    }

    private static d G(NativeModuleInitParams nativeModuleInitParams) {
        return new d(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.e.f(java.lang.String):boolean");
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
                case -1339721308: goto L5c;
                case -1221113672: goto L52;
                case -764307226: goto L48;
                case 83417096: goto L3d;
                case 109780401: goto L33;
                case 1090721135: goto L29;
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
            r4 = 0
            goto L72
        L15:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 7
            goto L72
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 5
            goto L72
        L29:
            java.lang.String r0 = "clipChildren"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 1
            goto L72
        L33:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 2
            goto L72
        L3d:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 9
            goto L72
        L48:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 6
            goto L72
        L52:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 3
            goto L72
        L5c:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 8
            goto L72
        L67:
            java.lang.String r0 = "enabled"
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.e.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0193  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.e.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        d dVar = (d) obj;
        try {
            switch (str) {
                case "nativeID":
                    dVar.bk((String) obj2);
                    break;
                case "clipChildren":
                    dVar.setClipChildren(((Boolean) obj2).booleanValue());
                    break;
                case "style":
                    dVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    dVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "enabled":
                    dVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "pivotPoint":
                    dVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "keyboardDismissMode":
                    dVar.aq((String) obj2);
                    break;
                case "disable":
                    dVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "onPress":
                    dVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onLongPress":
                    dVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TouchInterceptView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TouchInterceptView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.kwad.tachikoma.v.d r2 = (com.kwad.tachikoma.v.d) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L67;
                case -1339721308: goto L5c;
                case -1221113672: goto L52;
                case -764307226: goto L48;
                case 83417096: goto L3d;
                case 109780401: goto L33;
                case 1090721135: goto L29;
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
            r0 = 0
            goto L72
        L15:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 5
            goto L72
        L29:
            java.lang.String r0 = "clipChildren"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 1
            goto L72
        L33:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L3d:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 9
            goto L72
        L48:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L52:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
            goto L72
        L5c:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 4
            goto L72
        L71:
            r0 = -1
        L72:
            switch(r0) {
                case 0: goto Lba;
                case 1: goto Lb3;
                case 2: goto Lb0;
                case 3: goto La9;
                case 4: goto La2;
                case 5: goto L9f;
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
            java.lang.String r3 = "TouchInterceptView"
            android.util.Log.e(r3, r2)
            goto Lbd
        L8f:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L92:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L95:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L9c:
            java.lang.String r2 = r2.PT
            return r2
        L9f:
            java.util.HashMap r2 = r2.aaQ
            return r2
        La2:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La9:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lb0:
            java.util.HashMap r2 = r2.style
            return r2
        Lb3:
            boolean r2 = r2.XE
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lba:
            java.lang.String r2 = r2.aaG
            return r2
        Lbd:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.e.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        d dVar = (d) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals("borderRightColor")) {
                        c = 3;
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
                        c = 27;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 24;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 22;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 31;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 18;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 30;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 14;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = 17;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 15;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 2;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 0;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = 4;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 5;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 6;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = '!';
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 25;
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
                        c = 29;
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
                        c = 21;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = '\"';
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
                    dVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 1:
                    dVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 2:
                    dVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 3:
                    dVar.bs((String) obj2);
                    return;
                case 4:
                    dVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 5:
                    dVar.bg((String) obj2);
                    return;
                case 6:
                    dVar.aB((String) obj2);
                    return;
                case 7:
                    dVar.bw((String) obj2);
                    return;
                case '\b':
                    dVar.bz((String) obj2);
                    return;
                case '\t':
                    dVar.bt((String) obj2);
                    return;
                case '\n':
                    dVar.bA((String) obj2);
                    return;
                case 11:
                    dVar.bp((String) obj2);
                    return;
                case '\f':
                    dVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\r':
                    dVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 14:
                    dVar.bq((String) obj2);
                    return;
                case 15:
                    dVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 16:
                    dVar.bx((String) obj2);
                    return;
                case 17:
                    dVar.bv((String) obj2);
                    return;
                case 18:
                    dVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 19:
                    dVar.bn((String) obj2);
                    return;
                case 20:
                    dVar.bf((String) obj2);
                    return;
                case 21:
                    dVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    dVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 23:
                    dVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 24:
                    dVar.br((String) obj2);
                    return;
                case 25:
                    dVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 26:
                    dVar.bo((String) obj2);
                    return;
                case 27:
                    dVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 28:
                    dVar.by((String) obj2);
                    return;
                case 29:
                    dVar.A(obj2);
                    return;
                case 30:
                    dVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 31:
                    dVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case ' ':
                    dVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '!':
                    dVar.bu((String) obj2);
                    return;
                case '\"':
                    dVar.bm((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TouchInterceptView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TouchInterceptView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0195  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 1078
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.e.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
