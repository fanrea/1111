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
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "style";
            case 1:
                return "pivotPoint";
            case 2:
                return "clipChildren";
            case 3:
                return "disable";
            case 4:
                return "nativeID";
            case 5:
                return "onLongPress";
            case 6:
                return "disallowParentInterceptTouchEvent";
            case 7:
                return "onPress";
            case 8:
                return "keyboardDismissMode";
            case 9:
                return "enabled";
            case 10:
                return "removeAllAnimation";
            case 11:
                return "getLocationOnScreen";
            case 12:
                return "setScaleX";
            case 13:
                return "_setVNode";
            case 14:
                return "resumeAnimations";
            case 15:
                return "invokeNativeFunctionWithJSONString";
            case 16:
                return "insertBefore";
            case 17:
                return "getSize";
            case 18:
                return "observeNextLayout";
            case 19:
                return "removeAnimation";
            case 20:
                return "setVisibility";
            case 21:
                return "replaceChild";
            case 22:
                return "appendChild";
            case 23:
                return "setScaleY";
            case 24:
                return "setTranslateX";
            case 25:
                return "setOnWindowFocusChangeListener";
            case 26:
                return "addAnimation";
            case 27:
                return "setRotate";
            case 28:
                return "setGradientBgColor";
            case 29:
                return "setRotateX";
            case 30:
                return "invokeVoidNativeFunctionWithJSONString";
            case 31:
                return "setTranslateY";
            case 32:
                return "layout";
            case 33:
                return "pauseAnimations";
            case 34:
                return "setBackgroundColor";
            case 35:
                return "getOrigin";
            case 36:
                return "addEventListener";
            case 37:
                return "removeSelf";
            case 38:
                return "removeEventListener";
            case 39:
                return "getWindowFocusState";
            case 40:
                return "startViewAnimation";
            case 41:
                return "removeChild";
            case 42:
                return "getElementById";
            case 43:
                return "removeAll";
            case 44:
                return "setRotateY";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#style#0,2#pivotPoint#1,2#clipChildren#2,2#disable#3,2#nativeID#4,2#onLongPress#5,2#disallowParentInterceptTouchEvent#6,2#onPress#7,2#keyboardDismissMode#8,2#enabled#9,4#removeAllAnimation#10,8#getLocationOnScreen#11,4#setScaleX#12,4#_setVNode#13,4#resumeAnimations#14,8#invokeNativeFunctionWithJSONString#15,4#insertBefore#16,8#getSize#17,4#observeNextLayout#18,4#removeAnimation#19,4#setVisibility#20,4#replaceChild#21,4#appendChild#22,4#setScaleY#23,4#setTranslateX#24,4#setOnWindowFocusChangeListener#25,4#addAnimation#26,4#setRotate#27,4#setGradientBgColor#28,4#setRotateX#29,4#invokeVoidNativeFunctionWithJSONString#30,4#setTranslateY#31,4#layout#32,4#pauseAnimations#33,4#setBackgroundColor#34,8#getOrigin#35,4#addEventListener#36,4#removeSelf#37,4#removeEventListener#38,8#getWindowFocusState#39,4#startViewAnimation#40,4#removeChild#41,8#getElementById#42,4#removeAll#43,4#setRotateY#44";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return F(nativeModuleInitParams);
    }

    private static a F(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.b.f(java.lang.String):boolean");
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
                case -1609594047: goto L66;
                case -1339721308: goto L5c;
                case -1221113672: goto L52;
                case -764307226: goto L47;
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
            r4 = 4
            goto L72
        L15:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 3
            goto L72
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 1
            goto L72
        L29:
            java.lang.String r0 = "clipChildren"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 2
            goto L72
        L33:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 0
            goto L72
        L3d:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 5
            goto L72
        L47:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 8
            goto L72
        L52:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 6
            goto L72
        L5c:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 7
            goto L72
        L66:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 9
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:110:0x019f  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.b.h(java.lang.String):int");
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
                case "clipChildren":
                    aVar.setClipChildren(((Boolean) obj2).booleanValue());
                    break;
                case "disable":
                    aVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    aVar.bk((String) obj2);
                    break;
                case "onLongPress":
                    aVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    aVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "onPress":
                    aVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "keyboardDismissMode":
                    aVar.aq((String) obj2);
                    break;
                case "enabled":
                    aVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("FocusInterceptView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("FocusInterceptView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.kwad.tachikoma.v.a r2 = (com.kwad.tachikoma.v.a) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L66;
                case -1339721308: goto L5c;
                case -1221113672: goto L52;
                case -764307226: goto L47;
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
            r0 = 4
            goto L72
        L15:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
            goto L72
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 1
            goto L72
        L29:
            java.lang.String r0 = "clipChildren"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L33:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 0
            goto L72
        L3d:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 5
            goto L72
        L47:
            java.lang.String r0 = "keyboardDismissMode"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L52:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L5c:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L66:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 9
            goto L72
        L71:
            r0 = -1
        L72:
            switch(r0) {
                case 0: goto Lba;
                case 1: goto Lb7;
                case 2: goto Lb0;
                case 3: goto La9;
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
            java.lang.String r3 = "FocusInterceptView"
            android.util.Log.e(r3, r2)
            goto Lbd
        L8f:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L96:
            java.lang.String r2 = r2.PT
            return r2
        L99:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L9c:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La3:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        La6:
            java.lang.String r2 = r2.aaG
            return r2
        La9:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lb0:
            boolean r2 = r2.XE
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lb7:
            java.util.HashMap r2 = r2.aaQ
            return r2
        Lba:
            java.util.HashMap r2 = r2.style
            return r2
        Lbd:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.b.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 24;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = '!';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 27;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 25;
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
                        c = 20;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = JSONLexer.EOI;
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
                        c = 6;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 15;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 23;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 7;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 11;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = 3;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 28;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 5;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 1;
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
                        c = 17;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 30;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 29;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 14;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 19;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 22;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar.bo((String) obj2);
                    return;
                case 1:
                    aVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 2:
                    aVar.bn((String) obj2);
                    return;
                case 3:
                    aVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 4:
                    aVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 5:
                    aVar.bu((String) obj2);
                    return;
                case 6:
                    aVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 7:
                    aVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\b':
                    aVar.bw((String) obj2);
                    return;
                case '\t':
                    aVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\n':
                    aVar.bA((String) obj2);
                    return;
                case 11:
                    aVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\f':
                    aVar.bf((String) obj2);
                    return;
                case '\r':
                    aVar.br((String) obj2);
                    return;
                case 14:
                    aVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 15:
                    aVar.bq((String) obj2);
                    return;
                case 16:
                    aVar.bs((String) obj2);
                    return;
                case 17:
                    aVar.A(obj2);
                    return;
                case 18:
                    aVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 19:
                    aVar.bm((String) obj2);
                    return;
                case 20:
                    aVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 21:
                    aVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    aVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 23:
                    aVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 24:
                    aVar.bx((String) obj2);
                    return;
                case 25:
                    aVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 26:
                    aVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 27:
                    aVar.by((String) obj2);
                    return;
                case 28:
                    aVar.bg((String) obj2);
                    return;
                case 29:
                    aVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 30:
                    aVar.bp((String) obj2);
                    return;
                case 31:
                    aVar.bz((String) obj2);
                    return;
                case ' ':
                    aVar.aB((String) obj2);
                    return;
                case '!':
                    aVar.bt((String) obj2);
                    return;
                case '\"':
                    aVar.bv((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("FocusInterceptView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("FocusInterceptView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a2  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 1106
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.v.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
