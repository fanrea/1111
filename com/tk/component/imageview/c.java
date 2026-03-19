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
public final class c implements com.tk.core.manager.a.a<b> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "disallowParentInterceptTouchEvent";
            case 1:
                return "enabled";
            case 2:
                return "disable";
            case 3:
                return "src";
            case 4:
                return "onPress";
            case 5:
                return "nativeID";
            case 6:
                return "pivotPoint";
            case 7:
                return ContentProviderManager.PROVIDER_URI;
            case 8:
                return "style";
            case 9:
                return "onLongPress";
            case 10:
                return "observeNextLayout";
            case 11:
                return "getLocationOnScreen";
            case 12:
                return "invokeVoidNativeFunctionWithJSONString";
            case 13:
                return "setVisibility";
            case 14:
                return "onAnimationImagesDidLoaded";
            case 15:
                return "removeAllAnimation";
            case 16:
                return "setRotateX";
            case 17:
                return "setRotate";
            case 18:
                return "getSize";
            case 19:
                return "setBackgroundColor";
            case 20:
                return "setUrlAndPlaceHolder";
            case 21:
                return "_setVNode";
            case 22:
                return "getOrigin";
            case 23:
                return "removeAnimation";
            case 24:
                return "setSrc";
            case 25:
                return "setScaleY";
            case 26:
                return "setUriWith";
            case 27:
                return "setUrls";
            case 28:
                return "setScaleX";
            case 29:
                return "resumeAnimations";
            case 30:
                return "setTranslateX";
            case 31:
                return "onAnimationDidStop";
            case 32:
                return "getIsAnimating";
            case 33:
                return "setPlayNow";
            case 34:
                return "setAutoPlay";
            case 35:
                return "stopImageAnimation";
            case 36:
                return "setCDNUrls";
            case 37:
                return "setGradientBgColor";
            case 38:
                return "onAnimationDidException";
            case 39:
                return "setAnimationRepeatCount";
            case 40:
                return "layout";
            case 41:
                return "onAnimationDidRepeat";
            case 42:
                return "setAnimationImages";
            case 43:
                return "setPlaceholder";
            case 44:
                return "startViewAnimation";
            case 45:
                return "pauseAnimations";
            case 46:
                return "setRotateY";
            case 47:
                return "startImageAnimation";
            case 48:
                return "removeEventListener";
            case 49:
                return "setTranslateY";
            case 50:
                return "removeSelf";
            case 51:
                return "invokeNativeFunctionWithJSONString";
            case 52:
                return "onAnimationDidStart";
            case 53:
                return "addEventListener";
            case 54:
                return "setUri";
            case 55:
                return "addAnimation";
            case 56:
                return "setStayFrameEnd";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#disallowParentInterceptTouchEvent#0,2#enabled#1,2#disable#2,2#src#3,2#onPress#4,2#nativeID#5,2#pivotPoint#6,2#uri#7,2#style#8,2#onLongPress#9,4#observeNextLayout#10,8#getLocationOnScreen#11,4#invokeVoidNativeFunctionWithJSONString#12,4#setVisibility#13,4#onAnimationImagesDidLoaded#14,4#removeAllAnimation#15,4#setRotateX#16,4#setRotate#17,8#getSize#18,4#setBackgroundColor#19,4#setUrlAndPlaceHolder#20,4#_setVNode#21,8#getOrigin#22,4#removeAnimation#23,4#setSrc#24,4#setScaleY#25,4#setUriWith#26,4#setUrls#27,4#setScaleX#28,4#resumeAnimations#29,4#setTranslateX#30,4#onAnimationDidStop#31,8#getIsAnimating#32,4#setPlayNow#33,4#setAutoPlay#34,4#stopImageAnimation#35,4#setCDNUrls#36,4#setGradientBgColor#37,4#onAnimationDidException#38,4#setAnimationRepeatCount#39,4#layout#40,4#onAnimationDidRepeat#41,4#setAnimationImages#42,4#setPlaceholder#43,4#startViewAnimation#44,4#pauseAnimations#45,4#setRotateY#46,4#startImageAnimation#47,4#removeEventListener#48,4#setTranslateY#49,4#removeSelf#50,8#invokeNativeFunctionWithJSONString#51,4#onAnimationDidStart#52,4#addEventListener#53,4#setUri#54,4#addAnimation#55,4#setStayFrameEnd#56";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ b b(NativeModuleInitParams nativeModuleInitParams) {
        return R(nativeModuleInitParams);
    }

    private static b R(NativeModuleInitParams nativeModuleInitParams) {
        return new b(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01aa  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.c.f(java.lang.String):boolean");
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
                case 114148: goto L49;
                case 116076: goto L3f;
                case 83417096: goto L34;
                case 109780401: goto L29;
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
            r4 = 5
            goto L72
        L15:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 2
            goto L72
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 6
            goto L72
        L29:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 8
            goto L72
        L34:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 9
            goto L72
        L3f:
            java.lang.String r0 = "uri"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 7
            goto L72
        L49:
            java.lang.String r0 = "src"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 3
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
            r4 = 4
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L71
            r4 = 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.c.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:146:0x022f  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 854
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.c.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        b bVar = (b) obj;
        try {
            switch (str) {
                case "disallowParentInterceptTouchEvent":
                    bVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "enabled":
                    bVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "disable":
                    bVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "src":
                    bVar.ar((String) obj2);
                    break;
                case "onPress":
                    bVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "nativeID":
                    bVar.bk((String) obj2);
                    break;
                case "pivotPoint":
                    bVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "uri":
                    bVar.at((String) obj2);
                    break;
                case "style":
                    bVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onLongPress":
                    bVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKAnimatedImage", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKAnimatedImage apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.tk.component.imageview.b r2 = (com.tk.component.imageview.b) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L67;
                case -1339721308: goto L5d;
                case -1221113672: goto L53;
                case 114148: goto L49;
                case 116076: goto L3f;
                case 83417096: goto L34;
                case 109780401: goto L29;
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
            r0 = 5
            goto L72
        L15:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 2
            goto L72
        L1f:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 6
            goto L72
        L29:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 8
            goto L72
        L34:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 9
            goto L72
        L3f:
            java.lang.String r0 = "uri"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 7
            goto L72
        L49:
            java.lang.String r0 = "src"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 3
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
            r0 = 4
            goto L72
        L67:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L71
            r0 = 1
            goto L72
        L71:
            r0 = -1
        L72:
            switch(r0) {
                case 0: goto Lb2;
                case 1: goto Lab;
                case 2: goto La4;
                case 3: goto La1;
                case 4: goto L9e;
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
            java.lang.String r3 = "TKAnimatedImage"
            android.util.Log.e(r3, r2)
            goto Lb9
        L8f:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L92:
            java.util.HashMap r2 = r2.style
            return r2
        L95:
            java.lang.String r2 = r2.QJ
            return r2
        L98:
            java.util.HashMap r2 = r2.aaQ
            return r2
        L9b:
            java.lang.String r2 = r2.aaG
            return r2
        L9e:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        La1:
            java.lang.String r2 = r2.QI
            return r2
        La4:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lab:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lb2:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lb9:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.c.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        b bVar = (b) obj;
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
                        c = 20;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 29;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 27;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = '#';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = '!';
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = ' ';
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
                        c = 25;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 7;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 16;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = '\b';
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
                        c = 1;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 2;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 31;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = '\f';
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
                        c = 24;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = 22;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 17;
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
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 23;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    bVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 1:
                    bVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 2:
                    bVar.bg((String) obj2);
                    return;
                case 3:
                    bVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 4:
                    bVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 5:
                    bVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 6:
                    bVar.br((String) obj2);
                    return;
                case 7:
                    bVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case '\b':
                    bVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\t':
                    bVar.bm((String) obj2);
                    return;
                case '\n':
                    bVar.bv((String) obj2);
                    return;
                case 11:
                    bVar.bs((String) obj2);
                    return;
                case '\f':
                    bVar.bu((String) obj2);
                    return;
                case '\r':
                    bVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 14:
                    bVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 15:
                    bVar.by((String) obj2);
                    return;
                case 16:
                    bVar.bq((String) obj2);
                    return;
                case 17:
                    bVar.bp((String) obj2);
                    return;
                case 18:
                    bVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 19:
                    bVar.bw((String) obj2);
                    return;
                case 20:
                    bVar.bx((String) obj2);
                    return;
                case 21:
                    bVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    bVar.A(obj2);
                    return;
                case 23:
                    bVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 24:
                    bVar.bA((String) obj2);
                    return;
                case 25:
                    bVar.bz((String) obj2);
                    return;
                case 26:
                    bVar.bf((String) obj2);
                    return;
                case 27:
                    bVar.bo((String) obj2);
                    return;
                case 28:
                    bVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 29:
                    bVar.bn((String) obj2);
                    return;
                case 30:
                    bVar.aA((String) obj2);
                    return;
                case 31:
                    bVar.aB((String) obj2);
                    return;
                case ' ':
                    bVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '!':
                    bVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\"':
                    bVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '#':
                    bVar.bt((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKAnimatedImage", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKAnimatedImage setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0235  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r9, java.lang.String r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 1538
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.c.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
