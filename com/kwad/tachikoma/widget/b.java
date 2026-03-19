package com.kwad.tachikoma.widget;

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
                return "style";
            case 1:
                return "pivotPoint";
            case 2:
                return "disallowParentInterceptTouchEvent";
            case 3:
                return "onLongPress";
            case 4:
                return "disable";
            case 5:
                return "enabled";
            case 6:
                return "nativeID";
            case 7:
                return "onPress";
            case 8:
                return "removeAnimation";
            case 9:
                return "setGradientBgColor";
            case 10:
                return "pauseAnimations";
            case 11:
                return "setTranslateY";
            case 12:
                return "setScaleX";
            case 13:
                return "addEventListener";
            case 14:
                return "removeEventListener";
            case 15:
                return "resumeAnimations";
            case 16:
                return "setScaleY";
            case 17:
                return "_setVNode";
            case 18:
                return "startViewAnimation";
            case 19:
                return "setRotate";
            case 20:
                return "updateList";
            case 21:
                return "updateItem";
            case 22:
                return "setOnItemClickListener";
            case 23:
                return "setRotateY";
            case 24:
                return "observeNextLayout";
            case 25:
                return "getLocationOnScreen";
            case 26:
                return "layout";
            case 27:
                return "removeSelf";
            case 28:
                return "invokeNativeFunctionWithJSONString";
            case 29:
                return "setRotateX";
            case 30:
                return "setBackgroundColor";
            case 31:
                return "setVisibility";
            case 32:
                return "invokeVoidNativeFunctionWithJSONString";
            case 33:
                return "insertItem";
            case 34:
                return "setOnScrollListener";
            case 35:
                return "addAnimation";
            case 36:
                return "getSize";
            case 37:
                return "removeAllAnimation";
            case 38:
                return "setTranslateX";
            case 39:
                return "getOrigin";
            case 40:
                return "removeItem";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#style#0,2#pivotPoint#1,2#disallowParentInterceptTouchEvent#2,2#onLongPress#3,2#disable#4,2#enabled#5,2#nativeID#6,2#onPress#7,4#removeAnimation#8,4#setGradientBgColor#9,4#pauseAnimations#10,4#setTranslateY#11,4#setScaleX#12,4#addEventListener#13,4#removeEventListener#14,4#resumeAnimations#15,4#setScaleY#16,4#_setVNode#17,4#startViewAnimation#18,4#setRotate#19,4#updateList#20,4#updateItem#21,4#setOnItemClickListener#22,4#setRotateY#23,4#observeNextLayout#24,8#getLocationOnScreen#25,4#layout#26,4#removeSelf#27,8#invokeNativeFunctionWithJSONString#28,4#setRotateX#29,4#setBackgroundColor#30,4#setVisibility#31,4#invokeVoidNativeFunctionWithJSONString#32,4#insertItem#33,4#setOnScrollListener#34,4#addAnimation#35,8#getSize#36,4#removeAllAnimation#37,4#setTranslateX#38,8#getOrigin#39,4#removeItem#40";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return I(nativeModuleInitParams);
    }

    private static a I(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.widget.b.f(java.lang.String):boolean");
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
            r4 = 6
            goto L5b
        L14:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 4
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
            r4 = 0
            goto L5b
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 3
            goto L5b
        L3c:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 2
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.widget.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0186  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.widget.b.h(java.lang.String):int");
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
                case "disallowParentInterceptTouchEvent":
                    aVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "onLongPress":
                    aVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disable":
                    aVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "enabled":
                    aVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    aVar.bk((String) obj2);
                    break;
                case "onPress":
                    aVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKLiveProductListView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKLiveProductListView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.kwad.tachikoma.widget.a r2 = (com.kwad.tachikoma.widget.a) r2
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
            r0 = 6
            goto L5b
        L14:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 4
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
            r0 = 0
            goto L5b
        L32:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 3
            goto L5b
        L3c:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 2
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
                case 2: goto L8f;
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
            java.lang.String r3 = "TKLiveProductListView"
            android.util.Log.e(r3, r2)
            goto L9c
        L78:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L7b:
            java.lang.String r2 = r2.aaG
            return r2
        L7e:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L85:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L8c:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L8f:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L96:
            java.util.HashMap r2 = r2.aaQ
            return r2
        L99:
            java.util.HashMap r2 = r2.style
            return r2
        L9c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.widget.b.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 3;
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
                        c = 14;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 23;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 30;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 16;
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
                        c = '\b';
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 1;
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
                        c = ' ';
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 18;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = 11;
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
                        c = '\n';
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 19;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = '!';
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 6;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = StringUtil.CARRIAGE_RETURN;
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
                        c = '\"';
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 25;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(f.T)) {
                        c = 29;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 21;
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
                        c = 2;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 7;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 31;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar.bw((String) obj2);
                    return;
                case 1:
                    aVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 2:
                    aVar.bf((String) obj2);
                    return;
                case 3:
                    aVar.bs((String) obj2);
                    return;
                case 4:
                    aVar.bu((String) obj2);
                    return;
                case 5:
                    aVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 6:
                    aVar.bg((String) obj2);
                    return;
                case 7:
                    aVar.bm((String) obj2);
                    return;
                case '\b':
                    aVar.by((String) obj2);
                    return;
                case '\t':
                    aVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\n':
                    aVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 11:
                    aVar.bv((String) obj2);
                    return;
                case '\f':
                    aVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\r':
                    aVar.aB((String) obj2);
                    return;
                case 14:
                    aVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 15:
                    aVar.bz((String) obj2);
                    return;
                case 16:
                    aVar.bo((String) obj2);
                    return;
                case 17:
                    aVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 18:
                    aVar.bq((String) obj2);
                    return;
                case 19:
                    aVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 20:
                    aVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 21:
                    aVar.bp((String) obj2);
                    return;
                case 22:
                    aVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 23:
                    aVar.br((String) obj2);
                    return;
                case 24:
                    aVar.bt((String) obj2);
                    return;
                case 25:
                    aVar.bA((String) obj2);
                    return;
                case 26:
                    aVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 27:
                    aVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 28:
                    aVar.bx((String) obj2);
                    return;
                case 29:
                    aVar.A(obj2);
                    return;
                case 30:
                    aVar.bn((String) obj2);
                    return;
                case 31:
                    aVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case ' ':
                    aVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case '!':
                    aVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    aVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKLiveProductListView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKLiveProductListView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
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
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.widget.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
