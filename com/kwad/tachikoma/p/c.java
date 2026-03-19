package com.kwad.tachikoma.p;

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
public final class c implements com.tk.core.manager.a.a<b> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "style";
            case 1:
                return "nativeID";
            case 2:
                return "onLongPress";
            case 3:
                return "disable";
            case 4:
                return "disallowParentInterceptTouchEvent";
            case 5:
                return "enabled";
            case 6:
                return "pivotPoint";
            case 7:
                return "onPress";
            case 8:
                return "setTranslateY";
            case 9:
                return "layout";
            case 10:
                return "setRotateY";
            case 11:
                return "_setVNode";
            case 12:
                return "resumeAnimations";
            case 13:
                return "setBackgroundColor";
            case 14:
                return "removeEventListener";
            case 15:
                return "setScaleY";
            case 16:
                return "setVisibility";
            case 17:
                return "addEventListener";
            case 18:
                return "removeAnimation";
            case 19:
                return "invokeNativeFunctionWithJSONString";
            case 20:
                return "setScaleX";
            case 21:
                return "setTranslateX";
            case 22:
                return "removeAllAnimation";
            case 23:
                return "removeSelf";
            case 24:
                return "getSize";
            case 25:
                return "setGradientBgColor";
            case 26:
                return "getLocationOnScreen";
            case 27:
                return "addAnimation";
            case 28:
                return "setRotateX";
            case 29:
                return "startViewAnimation";
            case 30:
                return "invokeVoidNativeFunctionWithJSONString";
            case 31:
                return "observeNextLayout";
            case 32:
                return "pauseAnimations";
            case 33:
                return "getOrigin";
            case 34:
                return "setRotate";
            case 35:
                return "updateProgress";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#style#0,2#nativeID#1,2#onLongPress#2,2#disable#3,2#disallowParentInterceptTouchEvent#4,2#enabled#5,2#pivotPoint#6,2#onPress#7,4#setTranslateY#8,4#layout#9,4#setRotateY#10,4#_setVNode#11,4#resumeAnimations#12,4#setBackgroundColor#13,4#removeEventListener#14,4#setScaleY#15,4#setVisibility#16,4#addEventListener#17,4#removeAnimation#18,8#invokeNativeFunctionWithJSONString#19,4#setScaleX#20,4#setTranslateX#21,4#removeAllAnimation#22,4#removeSelf#23,8#getSize#24,4#setGradientBgColor#25,8#getLocationOnScreen#26,4#addAnimation#27,4#setRotateX#28,4#startViewAnimation#29,4#invokeVoidNativeFunctionWithJSONString#30,4#observeNextLayout#31,4#pauseAnimations#32,8#getOrigin#33,4#setRotate#34,4#updateProgress#35";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ b b(NativeModuleInitParams nativeModuleInitParams) {
        return B(nativeModuleInitParams);
    }

    private static b B(NativeModuleInitParams nativeModuleInitParams) {
        return new b(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.p.c.f(java.lang.String):boolean");
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
            r4 = 3
            goto L5b
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 6
            goto L5b
        L28:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 0
            goto L5b
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 2
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
            r4 = 7
            goto L5b
        L50:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 5
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.p.c.g(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.p.c.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        b bVar = (b) obj;
        try {
            switch (str) {
                case "style":
                    bVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "nativeID":
                    bVar.bk((String) obj2);
                    break;
                case "onLongPress":
                    bVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disable":
                    bVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "disallowParentInterceptTouchEvent":
                    bVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "enabled":
                    bVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "pivotPoint":
                    bVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onPress":
                    bVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKCircleProgress", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKCircleProgress apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.kwad.tachikoma.p.b r2 = (com.kwad.tachikoma.p.b) r2
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
            r0 = 3
            goto L5b
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 6
            goto L5b
        L28:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 0
            goto L5b
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 2
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
            r0 = 7
            goto L5b
        L50:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 5
            goto L5b
        L5a:
            r0 = -1
        L5b:
            switch(r0) {
                case 0: goto L99;
                case 1: goto L96;
                case 2: goto L93;
                case 3: goto L8c;
                case 4: goto L85;
                case 5: goto L7e;
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
            java.lang.String r3 = "TKCircleProgress"
            android.util.Log.e(r3, r2)
            goto L9c
        L78:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L7b:
            java.util.HashMap r2 = r2.aaQ
            return r2
        L7e:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L85:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L8c:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L93:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L96:
            java.lang.String r2 = r2.aaG
            return r2
        L99:
            java.util.HashMap r2 = r2.style
            return r2
        L9c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.p.c.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 3;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 11;
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
                        c = 22;
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
                        c = 20;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = 23;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 31;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 15;
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
                        c = 25;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 16;
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
                        c = 1;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 29;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 27;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = '!';
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
                        c = 5;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 2;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 30;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 28;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = '\"';
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
                        c = 24;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 6;
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
                        c = 21;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    bVar.by((String) obj2);
                    return;
                case 1:
                    bVar.bv((String) obj2);
                    return;
                case 2:
                    bVar.aB((String) obj2);
                    return;
                case 3:
                    bVar.bs((String) obj2);
                    return;
                case 4:
                    bVar.A(obj2);
                    return;
                case 5:
                    bVar.bg((String) obj2);
                    return;
                case 6:
                    bVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 7:
                    bVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\b':
                    bVar.bw((String) obj2);
                    return;
                case '\t':
                    bVar.bf((String) obj2);
                    return;
                case '\n':
                    bVar.bx((String) obj2);
                    return;
                case 11:
                    bVar.br((String) obj2);
                    return;
                case '\f':
                    bVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\r':
                    bVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 14:
                    bVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 15:
                    bVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 16:
                    bVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 17:
                    bVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 18:
                    bVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 19:
                    bVar.bn((String) obj2);
                    return;
                case 20:
                    bVar.bo((String) obj2);
                    return;
                case 21:
                    bVar.bm((String) obj2);
                    return;
                case 22:
                    bVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 23:
                    bVar.bt((String) obj2);
                    return;
                case 24:
                    bVar.bp((String) obj2);
                    return;
                case 25:
                    bVar.bz((String) obj2);
                    return;
                case 26:
                    bVar.bq((String) obj2);
                    return;
                case 27:
                    bVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 28:
                    bVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 29:
                    bVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 30:
                    bVar.bu((String) obj2);
                    return;
                case 31:
                    bVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case ' ':
                    bVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '!':
                    bVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    bVar.bA((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKCircleProgress", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKCircleProgress setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
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
            Method dump skipped, instructions count: 908
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.p.c.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
