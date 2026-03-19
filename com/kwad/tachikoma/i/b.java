package com.kwad.tachikoma.i;

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
                return "onPress";
            case 1:
                return "nativeID";
            case 2:
                return "style";
            case 3:
                return "pivotPoint";
            case 4:
                return "disallowParentInterceptTouchEvent";
            case 5:
                return "onLongPress";
            case 6:
                return "enabled";
            case 7:
                return "disable";
            case 8:
                return "setRotate";
            case 9:
                return "prepareToPlay";
            case 10:
                return "observeNextLayout";
            case 11:
                return "setBackgroundColor";
            case 12:
                return "removeAllAnimation";
            case 13:
                return "setSpeed";
            case 14:
                return "setGradientBgColor";
            case 15:
                return "layout";
            case 16:
                return "startViewAnimation";
            case 17:
                return com.component.feed.a.e;
            case 18:
                return "getLocationOnScreen";
            case 19:
                return "setScaleY";
            case 20:
                return "invokeVoidNativeFunctionWithJSONString";
            case 21:
                return "setDuration";
            case 22:
                return "invokeNativeFunctionWithJSONString";
            case 23:
                return "setTranslateY";
            case 24:
                return "setOnProgress";
            case 25:
                return "addEventListener";
            case 26:
                return "setRotateX";
            case 27:
                return "resumeAnimations";
            case 28:
                return "play";
            case 29:
                return "setHorizontalGravity";
            case 30:
                return "setRotateY";
            case 31:
                return "setImageResize";
            case 32:
                return "removeAnimation";
            case 33:
                return "setOnStatusCallback";
            case 34:
                return "setEnableCache";
            case 35:
                return "_setVNode";
            case 36:
                return "setScaleX";
            case 37:
                return "removeSelf";
            case 38:
                return "setTranslateX";
            case 39:
                return "addAnimation";
            case 40:
                return "setVerticalGravity";
            case 41:
                return "removeEventListener";
            case 42:
                return "resume";
            case 43:
                return "getOrigin";
            case 44:
                return "setURLs";
            case 45:
                return "setOnFinish";
            case 46:
                return "pauseAnimations";
            case 47:
                return "setOnFirstFrame";
            case 48:
                return "pause";
            case 49:
                return "setOnFailed";
            case 50:
                return "setVisibility";
            case 51:
                return "getSize";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#onPress#0,2#nativeID#1,2#style#2,2#pivotPoint#3,2#disallowParentInterceptTouchEvent#4,2#onLongPress#5,2#enabled#6,2#disable#7,4#setRotate#8,4#prepareToPlay#9,4#observeNextLayout#10,4#setBackgroundColor#11,4#removeAllAnimation#12,4#setSpeed#13,4#setGradientBgColor#14,4#layout#15,4#startViewAnimation#16,4#stop#17,8#getLocationOnScreen#18,4#setScaleY#19,4#invokeVoidNativeFunctionWithJSONString#20,4#setDuration#21,8#invokeNativeFunctionWithJSONString#22,4#setTranslateY#23,4#setOnProgress#24,4#addEventListener#25,4#setRotateX#26,4#resumeAnimations#27,4#play#28,4#setHorizontalGravity#29,4#setRotateY#30,4#setImageResize#31,4#removeAnimation#32,4#setOnStatusCallback#33,4#setEnableCache#34,4#_setVNode#35,4#setScaleX#36,4#removeSelf#37,4#setTranslateX#38,4#addAnimation#39,4#setVerticalGravity#40,4#removeEventListener#41,4#resume#42,8#getOrigin#43,4#setURLs#44,4#setOnFinish#45,4#pauseAnimations#46,4#setOnFirstFrame#47,4#pause#48,4#setOnFailed#49,4#setVisibility#50,8#getSize#51";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return p(nativeModuleInitParams);
    }

    private static a p(NativeModuleInitParams nativeModuleInitParams) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.i.b.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
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
                case -1609594047: goto L50;
                case -1339721308: goto L46;
                case -1221113672: goto L3c;
                case 83417096: goto L32;
                case 109780401: goto L28;
                case 1281290862: goto L1e;
                case 1671308008: goto L14;
                case 2045685618: goto La;
                default: goto L9;
            }
        L9:
            goto L5a
        La:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 1
            goto L5b
        L14:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 7
            goto L5b
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 3
            goto L5b
        L28:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 2
            goto L5b
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 5
            goto L5b
        L3c:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 4
            goto L5b
        L46:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 0
            goto L5b
        L50:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 6
            goto L5b
        L5a:
            r4 = -1
        L5b:
            switch(r4) {
                case 0: goto L5f;
                case 1: goto L5f;
                case 2: goto L5f;
                case 3: goto L5f;
                case 4: goto L5f;
                case 5: goto L5f;
                case 6: goto L5f;
                case 7: goto L5f;
                default: goto L5e;
            }
        L5e:
            return r2
        L5f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.i.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:137:0x020b  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.i.b.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        try {
            switch (str) {
                case "onPress":
                    aVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "nativeID":
                    aVar.bk((String) obj2);
                    break;
                case "style":
                    aVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "pivotPoint":
                    aVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    aVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "onLongPress":
                    aVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "enabled":
                    aVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "disable":
                    aVar.ao(((Boolean) obj2).booleanValue());
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKImagePlayer", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKImagePlayer apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            r1 = this;
            com.kwad.tachikoma.i.a r2 = (com.kwad.tachikoma.i.a) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L50;
                case -1339721308: goto L46;
                case -1221113672: goto L3c;
                case 83417096: goto L32;
                case 109780401: goto L28;
                case 1281290862: goto L1e;
                case 1671308008: goto L14;
                case 2045685618: goto La;
                default: goto L9;
            }
        L9:
            goto L5a
        La:
            java.lang.String r0 = "nativeID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 1
            goto L5b
        L14:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 7
            goto L5b
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 3
            goto L5b
        L28:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 2
            goto L5b
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 5
            goto L5b
        L3c:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 4
            goto L5b
        L46:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 0
            goto L5b
        L50:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 6
            goto L5b
        L5a:
            r0 = -1
        L5b:
            switch(r0) {
                case 0: goto L99;
                case 1: goto L96;
                case 2: goto L93;
                case 3: goto L90;
                case 4: goto L89;
                case 5: goto L86;
                case 6: goto L7f;
                case 7: goto L78;
                default: goto L5e;
            }
        L5e:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto L9c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKImagePlayer"
            android.util.Log.e(r3, r2)
            goto L9c
        L78:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L7f:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L86:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L89:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L90:
            java.util.HashMap r2 = r2.aaQ
            return r2
        L93:
            java.util.HashMap r2 = r2.style
            return r2
        L96:
            java.lang.String r2 = r2.aaG
            return r2
        L99:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L9c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.i.b.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 15;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 25;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = '!';
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
                        c = 5;
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
                        c = 18;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 2;
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
                        c = 21;
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
                        c = 19;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 6;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 28;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 27;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = JSONLexer.EOI;
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
                        c = 0;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 23;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 22;
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
                        c = 29;
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
                        c = 16;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 30;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(f.T)) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 31;
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
                        c = 24;
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
                        c = '\t';
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 11;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 1:
                    aVar.br((String) obj2);
                    return;
                case 2:
                    aVar.bo((String) obj2);
                    return;
                case 3:
                    aVar.bt((String) obj2);
                    return;
                case 4:
                    aVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 5:
                    aVar.bw((String) obj2);
                    return;
                case 6:
                    aVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 7:
                    aVar.aB((String) obj2);
                    return;
                case '\b':
                    aVar.bp((String) obj2);
                    return;
                case '\t':
                    aVar.bm((String) obj2);
                    return;
                case '\n':
                    aVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 11:
                    aVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\f':
                    aVar.bv((String) obj2);
                    return;
                case '\r':
                    aVar.A(obj2);
                    return;
                case 14:
                    aVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 15:
                    aVar.bs((String) obj2);
                    return;
                case 16:
                    aVar.bu((String) obj2);
                    return;
                case 17:
                    aVar.bf((String) obj2);
                    return;
                case 18:
                    aVar.bn((String) obj2);
                    return;
                case 19:
                    aVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 20:
                    aVar.bA((String) obj2);
                    return;
                case 21:
                    aVar.by((String) obj2);
                    return;
                case 22:
                    aVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 23:
                    aVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 24:
                    aVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 25:
                    aVar.bx((String) obj2);
                    return;
                case 26:
                    aVar.bq((String) obj2);
                    return;
                case 27:
                    aVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 28:
                    aVar.bz((String) obj2);
                    return;
                case 29:
                    aVar.bg((String) obj2);
                    return;
                case 30:
                    aVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 31:
                    aVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case ' ':
                    aVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '!':
                    aVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\"':
                    aVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKImagePlayer", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKImagePlayer setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:137:0x020e  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 1346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.i.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
