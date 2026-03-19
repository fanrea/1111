package com.kwad.tachikoma.live.message;

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
public final class g implements com.tk.core.manager.a.a<f> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "enabled";
            case 1:
                return "pivotPoint";
            case 2:
                return "onPress";
            case 3:
                return "disable";
            case 4:
                return "onLongPress";
            case 5:
                return "style";
            case 6:
                return "disallowParentInterceptTouchEvent";
            case 7:
                return "nativeID";
            case 8:
                return "setBackgroundColor";
            case 9:
                return "invokeNativeFunctionWithJSONString";
            case 10:
                return "setGradientBgColor";
            case 11:
                return "setRotateX";
            case 12:
                return "addLiveMessage";
            case 13:
                return "setRotateY";
            case 14:
                return "startViewAnimation";
            case 15:
                return "removeAllAnimation";
            case 16:
                return "setRotate";
            case 17:
                return "invokeVoidNativeFunctionWithJSONString";
            case 18:
                return "getSize";
            case 19:
                return "setTranslateX";
            case 20:
                return "observeNextLayout";
            case 21:
                return "addEventListener";
            case 22:
                return "setTranslateY";
            case 23:
                return "addAnimation";
            case 24:
                return "setScaleX";
            case 25:
                return "setVisibility";
            case 26:
                return "removeEventListener";
            case 27:
                return "_setVNode";
            case 28:
                return "setScaleY";
            case 29:
                return "resumeAnimations";
            case 30:
                return "removeSelf";
            case 31:
                return "layout";
            case 32:
                return "removeAnimation";
            case 33:
                return "getOrigin";
            case 34:
                return "getLocationOnScreen";
            case 35:
                return "pauseAnimations";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#enabled#0,2#pivotPoint#1,2#onPress#2,2#disable#3,2#onLongPress#4,2#style#5,2#disallowParentInterceptTouchEvent#6,2#nativeID#7,4#setBackgroundColor#8,8#invokeNativeFunctionWithJSONString#9,4#setGradientBgColor#10,4#setRotateX#11,4#addLiveMessage#12,4#setRotateY#13,4#startViewAnimation#14,4#removeAllAnimation#15,4#setRotate#16,4#invokeVoidNativeFunctionWithJSONString#17,8#getSize#18,4#setTranslateX#19,4#observeNextLayout#20,4#addEventListener#21,4#setTranslateY#22,4#addAnimation#23,4#setScaleX#24,4#setVisibility#25,4#removeEventListener#26,4#_setVNode#27,4#setScaleY#28,4#resumeAnimations#29,4#removeSelf#30,4#layout#31,4#removeAnimation#32,8#getOrigin#33,8#getLocationOnScreen#34,4#pauseAnimations#35";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ f b(NativeModuleInitParams nativeModuleInitParams) {
        return r(nativeModuleInitParams);
    }

    private static f r(NativeModuleInitParams nativeModuleInitParams) {
        return new f(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.message.g.f(java.lang.String):boolean");
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
            r4 = 7
            goto L5b
        L14:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 3
            goto L5b
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 1
            goto L5b
        L28:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 5
            goto L5b
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 4
            goto L5b
        L3c:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 6
            goto L5b
        L46:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 2
            goto L5b
        L50:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 0
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.message.g.g(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.message.g.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        f fVar = (f) obj;
        try {
            switch (str) {
                case "enabled":
                    fVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "pivotPoint":
                    fVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onPress":
                    fVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disable":
                    fVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "onLongPress":
                    fVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "style":
                    fVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    fVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    fVar.bk((String) obj2);
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TkLiveMessage", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TkLiveMessage apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.kwad.tachikoma.live.message.f r2 = (com.kwad.tachikoma.live.message.f) r2
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
            r0 = 7
            goto L5b
        L14:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 3
            goto L5b
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 1
            goto L5b
        L28:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 5
            goto L5b
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 4
            goto L5b
        L3c:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 6
            goto L5b
        L46:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 2
            goto L5b
        L50:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 0
            goto L5b
        L5a:
            r0 = -1
        L5b:
            switch(r0) {
                case 0: goto L95;
                case 1: goto L92;
                case 2: goto L8f;
                case 3: goto L88;
                case 4: goto L85;
                case 5: goto L82;
                case 6: goto L7b;
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
            java.lang.String r3 = "TkLiveMessage"
            android.util.Log.e(r3, r2)
            goto L9c
        L78:
            java.lang.String r2 = r2.aaG
            return r2
        L7b:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L82:
            java.util.HashMap r2 = r2.style
            return r2
        L85:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L88:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L8f:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L92:
            java.util.HashMap r2 = r2.aaQ
            return r2
        L95:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L9c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.message.g.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 30;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = '!';
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
                        c = 6;
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
                        c = 31;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = 14;
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
                        c = 11;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = '\f';
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
                        c = 18;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 15;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 1;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = 24;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 19;
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
                        c = 25;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = 0;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 16;
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
                        c = ' ';
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 27;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 21;
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
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = '\b';
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
                        c = 23;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 29;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    fVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 1:
                    fVar.bq((String) obj2);
                    return;
                case 2:
                    fVar.by((String) obj2);
                    return;
                case 3:
                    fVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 4:
                    fVar.bn((String) obj2);
                    return;
                case 5:
                    fVar.aB((String) obj2);
                    return;
                case 6:
                    fVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 7:
                    fVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\b':
                    fVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\t':
                    fVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case '\n':
                    fVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 11:
                    fVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\f':
                    fVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\r':
                    fVar.bf((String) obj2);
                    return;
                case 14:
                    fVar.bt((String) obj2);
                    return;
                case 15:
                    fVar.bz((String) obj2);
                    return;
                case 16:
                    fVar.bg((String) obj2);
                    return;
                case 17:
                    fVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 18:
                    fVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 19:
                    fVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 20:
                    fVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 21:
                    fVar.bA((String) obj2);
                    return;
                case 22:
                    fVar.A(obj2);
                    return;
                case 23:
                    fVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 24:
                    fVar.bv((String) obj2);
                    return;
                case 25:
                    fVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 26:
                    fVar.bp((String) obj2);
                    return;
                case 27:
                    fVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 28:
                    fVar.bx((String) obj2);
                    return;
                case 29:
                    fVar.bm((String) obj2);
                    return;
                case 30:
                    fVar.bs((String) obj2);
                    return;
                case 31:
                    fVar.bo((String) obj2);
                    return;
                case ' ':
                    fVar.bu((String) obj2);
                    return;
                case '!':
                    fVar.br((String) obj2);
                    return;
                case '\"':
                    fVar.bw((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TkLiveMessage", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TkLiveMessage setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.message.g.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
