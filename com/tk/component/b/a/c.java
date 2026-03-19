package com.tk.component.b.a;

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
                return "onOffsetChanged";
            case 1:
                return "pivotPoint";
            case 2:
                return "disable";
            case 3:
                return "enabled";
            case 4:
                return "disallowParentInterceptTouchEvent";
            case 5:
                return "nativeID";
            case 6:
                return "onLongPress";
            case 7:
                return "style";
            case 8:
                return "onPress";
            case 9:
                return "addEventListener";
            case 10:
                return "invokeVoidNativeFunctionWithJSONString";
            case 11:
                return "setRotate";
            case 12:
                return "setRotateY";
            case 13:
                return "setListView";
            case 14:
                return "setGradientBgColor";
            case 15:
                return "_setVNode";
            case 16:
                return "getLocationOnScreen";
            case 17:
                return "setTranslateX";
            case 18:
                return "pauseAnimations";
            case 19:
                return "removeAnimation";
            case 20:
                return "getSize";
            case 21:
                return "addAnimation";
            case 22:
                return "setRotateX";
            case 23:
                return "startViewAnimation";
            case 24:
                return "getOrigin";
            case 25:
                return "setVisibility";
            case 26:
                return "removeSelf";
            case 27:
                return "setBackgroundColor";
            case 28:
                return "layout";
            case 29:
                return "removeAllAnimation";
            case 30:
                return "observeNextLayout";
            case 31:
                return "removeEventListener";
            case 32:
                return "setTranslateY";
            case 33:
                return "resumeAnimations";
            case 34:
                return "invokeNativeFunctionWithJSONString";
            case 35:
                return "setScaleY";
            case 36:
                return "setScaleX";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#onOffsetChanged#0,2#pivotPoint#1,2#disable#2,2#enabled#3,2#disallowParentInterceptTouchEvent#4,2#nativeID#5,2#onLongPress#6,2#style#7,2#onPress#8,4#addEventListener#9,4#invokeVoidNativeFunctionWithJSONString#10,4#setRotate#11,4#setRotateY#12,4#setListView#13,4#setGradientBgColor#14,4#_setVNode#15,8#getLocationOnScreen#16,4#setTranslateX#17,4#pauseAnimations#18,4#removeAnimation#19,8#getSize#20,4#addAnimation#21,4#setRotateX#22,4#startViewAnimation#23,8#getOrigin#24,4#setVisibility#25,4#removeSelf#26,4#setBackgroundColor#27,4#layout#28,4#removeAllAnimation#29,4#observeNextLayout#30,4#removeEventListener#31,4#setTranslateY#32,4#resumeAnimations#33,8#invokeNativeFunctionWithJSONString#34,4#setScaleY#35,4#setScaleX#36";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ b b(NativeModuleInitParams nativeModuleInitParams) {
        return N(nativeModuleInitParams);
    }

    private static b N(NativeModuleInitParams nativeModuleInitParams) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.a.c.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
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
                case -1609594047: goto L5b;
                case -1339721308: goto L50;
                case -1221113672: goto L46;
                case -552616190: goto L3c;
                case 83417096: goto L32;
                case 109780401: goto L28;
                case 1281290862: goto L1e;
                case 1671308008: goto L14;
                case 2045685618: goto La;
                default: goto L9;
            }
        L9:
            goto L65
        La:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 5
            goto L66
        L14:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 2
            goto L66
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 1
            goto L66
        L28:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 7
            goto L66
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 6
            goto L66
        L3c:
            java.lang.String r0 = "onOffsetChanged"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 0
            goto L66
        L46:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 4
            goto L66
        L50:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 8
            goto L66
        L5b:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L65
            r4 = 3
            goto L66
        L65:
            r4 = -1
        L66:
            switch(r4) {
                case 0: goto L6a;
                case 1: goto L6a;
                case 2: goto L6a;
                case 3: goto L6a;
                case 4: goto L6a;
                case 5: goto L6a;
                case 6: goto L6a;
                case 7: goto L6a;
                case 8: goto L6a;
                default: goto L69;
            }
        L69:
            return r2
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.a.c.g(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.a.c.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        b bVar = (b) obj;
        try {
            switch (str) {
                case "onOffsetChanged":
                    bVar.M((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "pivotPoint":
                    bVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disable":
                    bVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "enabled":
                    bVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "disallowParentInterceptTouchEvent":
                    bVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    bVar.bk((String) obj2);
                    break;
                case "onLongPress":
                    bVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "style":
                    bVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onPress":
                    bVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKReboundView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKReboundView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0065  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            r1 = this;
            com.tk.component.b.a.b r2 = (com.tk.component.b.a.b) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L5b;
                case -1339721308: goto L50;
                case -1221113672: goto L46;
                case -552616190: goto L3c;
                case 83417096: goto L32;
                case 109780401: goto L28;
                case 1281290862: goto L1e;
                case 1671308008: goto L14;
                case 2045685618: goto La;
                default: goto L9;
            }
        L9:
            goto L65
        La:
            java.lang.String r0 = "nativeID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 5
            goto L66
        L14:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 2
            goto L66
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 1
            goto L66
        L28:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 7
            goto L66
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 6
            goto L66
        L3c:
            java.lang.String r0 = "onOffsetChanged"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 0
            goto L66
        L46:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 4
            goto L66
        L50:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 8
            goto L66
        L5b:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L65
            r0 = 3
            goto L66
        L65:
            r0 = -1
        L66:
            switch(r0) {
                case 0: goto La7;
                case 1: goto La4;
                case 2: goto L9d;
                case 3: goto L96;
                case 4: goto L8f;
                case 5: goto L8c;
                case 6: goto L89;
                case 7: goto L86;
                case 8: goto L83;
                default: goto L69;
            }
        L69:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto Laa
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKReboundView"
            android.util.Log.e(r3, r2)
            goto Laa
        L83:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L86:
            java.util.HashMap r2 = r2.style
            return r2
        L89:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L8c:
            java.lang.String r2 = r2.aaG
            return r2
        L8f:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L96:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L9d:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La4:
            java.util.HashMap r2 = r2.aaQ
            return r2
        La7:
            com.tkruntime.v8.V8Function r2 = r2.Pq
            return r2
        Laa:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.a.c.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 18;
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
                        c = 1;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 30;
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
                        c = 22;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = 24;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = '!';
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 16;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 7;
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
                        c = 17;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 4;
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
                        c = 11;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 2;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = 21;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = '\f';
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
                        c = 28;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 31;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(f.T)) {
                        c = 20;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 29;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 25;
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
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    bVar.bx((String) obj2);
                    return;
                case 1:
                    bVar.br((String) obj2);
                    return;
                case 2:
                    bVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 3:
                    bVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 4:
                    bVar.bq((String) obj2);
                    return;
                case 5:
                    bVar.bf((String) obj2);
                    return;
                case 6:
                    bVar.aB((String) obj2);
                    return;
                case 7:
                    bVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\b':
                    bVar.bz((String) obj2);
                    return;
                case '\t':
                    bVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\n':
                    bVar.bv((String) obj2);
                    return;
                case 11:
                    bVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\f':
                    bVar.bg((String) obj2);
                    return;
                case '\r':
                    bVar.by((String) obj2);
                    return;
                case 14:
                    bVar.bm((String) obj2);
                    return;
                case 15:
                    bVar.bA((String) obj2);
                    return;
                case 16:
                    bVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 17:
                    bVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 18:
                    bVar.bs((String) obj2);
                    return;
                case 19:
                    bVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 20:
                    bVar.A(obj2);
                    return;
                case 21:
                    bVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    bVar.bo((String) obj2);
                    return;
                case 23:
                    bVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 24:
                    bVar.bt((String) obj2);
                    return;
                case 25:
                    bVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 26:
                    bVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 27:
                    bVar.bn((String) obj2);
                    return;
                case 28:
                    bVar.bu((String) obj2);
                    return;
                case 29:
                    bVar.bp((String) obj2);
                    return;
                case 30:
                    bVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 31:
                    bVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case ' ':
                    bVar.bw((String) obj2);
                    return;
                case '!':
                    bVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\"':
                    bVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKReboundView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKReboundView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
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
            Method dump skipped, instructions count: 902
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.b.a.c.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
