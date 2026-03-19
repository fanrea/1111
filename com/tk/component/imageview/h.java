package com.tk.component.imageview;

import android.util.Log;
import com.alibaba.fastjson.parser.JSONLexer;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class h implements com.tk.core.manager.a.a<f> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "style";
            case 1:
                return "pivotPoint";
            case 2:
                return ContentProviderManager.PROVIDER_URI;
            case 3:
                return "enabled";
            case 4:
                return "disallowParentInterceptTouchEvent";
            case 5:
                return "onPress";
            case 6:
                return "onLongPress";
            case 7:
                return "disable";
            case 8:
                return "nativeID";
            case 9:
                return "src";
            case 10:
                return "setRotateX";
            case 11:
                return "getLocationOnScreen";
            case 12:
                return "setUriWith";
            case 13:
                return "invokeVoidNativeFunctionWithJSONString";
            case 14:
                return "observeNextLayout";
            case 15:
                return "setBackgroundColor";
            case 16:
                return "addAnimation";
            case 17:
                return "setLocalSrc";
            case 18:
                return "invokeNativeFunctionWithJSONString";
            case 19:
                return "setRotateY";
            case 20:
                return "setCDNUrls";
            case 21:
                return "layout";
            case 22:
                return "setScaleX";
            case 23:
                return "setUriWithTintColor";
            case 24:
                return "startViewAnimation";
            case 25:
                return "removeAllAnimation";
            case 26:
                return "removeSelf";
            case 27:
                return "setImageIconName";
            case 28:
                return "getOrigin";
            case 29:
                return "setSrc";
            case 30:
                return "_setVNode";
            case 31:
                return "pauseAnimations";
            case 32:
                return "setScaleY";
            case 33:
                return "setUrls";
            case 34:
                return "setUri";
            case 35:
                return "setImageUri";
            case 36:
                return "removeEventListener";
            case 37:
                return "setImageLoadCallback";
            case 38:
                return "addEventListener";
            case 39:
                return "getSize";
            case 40:
                return "removeAnimation";
            case 41:
                return "resumeAnimations";
            case 42:
                return "setTranslateY";
            case 43:
                return "setGradientBgColor";
            case 44:
                return "setRotate";
            case 45:
                return "setTranslateX";
            case 46:
                return "setVisibility";
            case 47:
                return "setPlaceholder";
            case 48:
                return "setBlurRadius";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#style#0,2#pivotPoint#1,2#uri#2,2#enabled#3,2#disallowParentInterceptTouchEvent#4,2#onPress#5,2#onLongPress#6,2#disable#7,2#nativeID#8,2#src#9,4#setRotateX#10,8#getLocationOnScreen#11,4#setUriWith#12,4#invokeVoidNativeFunctionWithJSONString#13,4#observeNextLayout#14,4#setBackgroundColor#15,4#addAnimation#16,4#setLocalSrc#17,8#invokeNativeFunctionWithJSONString#18,4#setRotateY#19,4#setCDNUrls#20,4#layout#21,4#setScaleX#22,4#setUriWithTintColor#23,4#startViewAnimation#24,4#removeAllAnimation#25,4#removeSelf#26,4#setImageIconName#27,8#getOrigin#28,4#setSrc#29,4#_setVNode#30,4#pauseAnimations#31,4#setScaleY#32,4#setUrls#33,4#setUri#34,4#setImageUri#35,4#removeEventListener#36,4#setImageLoadCallback#37,4#addEventListener#38,8#getSize#39,4#removeAnimation#40,4#resumeAnimations#41,4#setTranslateY#42,4#setGradientBgColor#43,4#setRotate#44,4#setTranslateX#45,4#setVisibility#46,4#setPlaceholder#47,4#setBlurRadius#48";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ f b(NativeModuleInitParams nativeModuleInitParams) {
        return T(nativeModuleInitParams);
    }

    private static f T(NativeModuleInitParams nativeModuleInitParams) {
        return new f(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01a9  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.h.f(java.lang.String):boolean");
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
                case 114148: goto L48;
                case 116076: goto L3e;
                case 83417096: goto L34;
                case 109780401: goto L2a;
                case 1281290862: goto L20;
                case 1671308008: goto L16;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L71
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 8
            goto L72
        L16:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 7
            goto L72
        L20:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 1
            goto L72
        L2a:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 0
            goto L72
        L34:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 6
            goto L72
        L3e:
            java.lang.String r0 = "uri"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 2
            goto L72
        L48:
            java.lang.String r0 = "src"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 9
            goto L72
        L53:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 4
            goto L72
        L5d:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 5
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.h.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01cf  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.h.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        f fVar = (f) obj;
        try {
            switch (str) {
                case "style":
                    fVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "pivotPoint":
                    fVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "uri":
                    fVar.at((String) obj2);
                    break;
                case "enabled":
                    fVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "disallowParentInterceptTouchEvent":
                    fVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "onPress":
                    fVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onLongPress":
                    fVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disable":
                    fVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    fVar.bk((String) obj2);
                    break;
                case "src":
                    fVar.ar((String) obj2);
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKImage", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKImage apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.tk.component.imageview.f r2 = (com.tk.component.imageview.f) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L67;
                case -1339721308: goto L5d;
                case -1221113672: goto L53;
                case 114148: goto L48;
                case 116076: goto L3e;
                case 83417096: goto L34;
                case 109780401: goto L2a;
                case 1281290862: goto L20;
                case 1671308008: goto L16;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L71
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L16:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L20:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 1
            goto L72
        L2a:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 0
            goto L72
        L34:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L3e:
            java.lang.String r0 = "uri"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L48:
            java.lang.String r0 = "src"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 9
            goto L72
        L53:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 4
            goto L72
        L5d:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 5
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
            goto L72
        L71:
            r0 = -1
        L72:
            switch(r0) {
                case 0: goto Lb6;
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
            if (r2 == 0) goto Lb9
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKImage"
            android.util.Log.e(r3, r2)
            goto Lb9
        L8f:
            java.lang.String r2 = r2.QI
            return r2
        L92:
            java.lang.String r2 = r2.aaG
            return r2
        L95:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L9c:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L9f:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        La2:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La9:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lb0:
            java.lang.String r2 = r2.QJ
            return r2
        Lb3:
            java.util.HashMap r2 = r2.aaQ
            return r2
        Lb6:
            java.util.HashMap r2 = r2.style
            return r2
        Lb9:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.h.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        f fVar = (f) obj;
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
                        c = 29;
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
                        c = '\b';
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 24;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 27;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = '#';
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 28;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c = 30;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 22;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 19;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = 20;
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
                        c = 6;
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
                        c = 17;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 23;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 18;
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
                        c = 7;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = 16;
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
                        c = '\t';
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 31;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 11;
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
                    fVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 1:
                    fVar.bo((String) obj2);
                    return;
                case 2:
                    fVar.bs((String) obj2);
                    return;
                case 3:
                    fVar.bp((String) obj2);
                    return;
                case 4:
                    fVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 5:
                    fVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 6:
                    fVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 7:
                    fVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\b':
                    fVar.br((String) obj2);
                    return;
                case '\t':
                    fVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\n':
                    fVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 11:
                    fVar.bm((String) obj2);
                    return;
                case '\f':
                    fVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\r':
                    fVar.bA((String) obj2);
                    return;
                case 14:
                    fVar.by((String) obj2);
                    return;
                case 15:
                    fVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 16:
                    fVar.A(obj2);
                    return;
                case 17:
                    fVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 18:
                    fVar.aB((String) obj2);
                    return;
                case 19:
                    fVar.bq((String) obj2);
                    return;
                case 20:
                    fVar.bv((String) obj2);
                    return;
                case 21:
                    fVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    fVar.bz((String) obj2);
                    return;
                case 23:
                    fVar.bg((String) obj2);
                    return;
                case 24:
                    fVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 25:
                    fVar.bu((String) obj2);
                    return;
                case 26:
                    fVar.bw((String) obj2);
                    return;
                case 27:
                    fVar.bn((String) obj2);
                    return;
                case 28:
                    fVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 29:
                    fVar.bx((String) obj2);
                    return;
                case 30:
                    fVar.aA((String) obj2);
                    return;
                case 31:
                    fVar.bf((String) obj2);
                    return;
                case ' ':
                    fVar.bt((String) obj2);
                    return;
                case '!':
                    fVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    fVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case '#':
                    fVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKImage", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKImage setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01d5  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r9, java.lang.String r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.h.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
