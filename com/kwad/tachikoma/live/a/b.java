package com.kwad.tachikoma.live.a;

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
                return "nativeID";
            case 1:
                return "disable";
            case 2:
                return "style";
            case 3:
                return "disallowParentInterceptTouchEvent";
            case 4:
                return "enabled";
            case 5:
                return "pivotPoint";
            case 6:
                return "onPress";
            case 7:
                return "onLongPress";
            case 8:
                return "initWithUserInfo";
            case 9:
                return "setScaleX";
            case 10:
                return "resume";
            case 11:
                return "setOnMuteChange";
            case 12:
                return "setOnProgress";
            case 13:
                return "resumeAnimations";
            case 14:
                return "invokeVoidNativeFunctionWithJSONString";
            case 15:
                return "addAnimation";
            case 16:
                return "removeEventListener";
            case 17:
                return "startViewAnimation";
            case 18:
                return "removeAnimation";
            case 19:
                return "getSize";
            case 20:
                return "setOnLiveShopInfo";
            case 21:
                return "setOnFinish";
            case 22:
                return "setVisibility";
            case 23:
                return "setOnFailed";
            case 24:
                return "setBackgroundColor";
            case 25:
                return "setMuted";
            case 26:
                return "addEventListener";
            case 27:
                return "setRotate";
            case 28:
                return "removeSelf";
            case 29:
                return "removeAllAnimation";
            case 30:
                return "setGradientBgColor";
            case 31:
                return "getOrigin";
            case 32:
                return "_setVNode";
            case 33:
                return "pause";
            case 34:
                return "setScaleY";
            case 35:
                return "setOnStatusCallback";
            case 36:
                return "setOnLiveMessageData";
            case 37:
                return "setTranslateX";
            case 38:
                return com.component.feed.a.e;
            case 39:
                return "setOnLiveEnd";
            case 40:
                return "setForceGetAudioFocus";
            case 41:
                return "setTranslateY";
            case 42:
                return "setRotateX";
            case 43:
                return "layout";
            case 44:
                return "setOnFirstFrame";
            case 45:
                return "initAdLivePlayer";
            case 46:
                return "observeNextLayout";
            case 47:
                return "pauseAnimations";
            case 48:
                return "setRotateY";
            case 49:
                return "invokeNativeFunctionWithJSONString";
            case 50:
                return "getLocationOnScreen";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#nativeID#0,2#disable#1,2#style#2,2#disallowParentInterceptTouchEvent#3,2#enabled#4,2#pivotPoint#5,2#onPress#6,2#onLongPress#7,4#initWithUserInfo#8,4#setScaleX#9,4#resume#10,4#setOnMuteChange#11,4#setOnProgress#12,4#resumeAnimations#13,4#invokeVoidNativeFunctionWithJSONString#14,4#addAnimation#15,4#removeEventListener#16,4#startViewAnimation#17,4#removeAnimation#18,8#getSize#19,4#setOnLiveShopInfo#20,4#setOnFinish#21,4#setVisibility#22,4#setOnFailed#23,4#setBackgroundColor#24,4#setMuted#25,4#addEventListener#26,4#setRotate#27,4#removeSelf#28,4#removeAllAnimation#29,4#setGradientBgColor#30,8#getOrigin#31,4#_setVNode#32,4#pause#33,4#setScaleY#34,4#setOnStatusCallback#35,4#setOnLiveMessageData#36,4#setTranslateX#37,4#stop#38,4#setOnLiveEnd#39,4#setForceGetAudioFocus#40,4#setTranslateY#41,4#setRotateX#42,4#layout#43,4#setOnFirstFrame#44,4#initAdLivePlayer#45,4#observeNextLayout#46,4#pauseAnimations#47,4#setRotateY#48,8#invokeNativeFunctionWithJSONString#49,8#getLocationOnScreen#50";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return s(nativeModuleInitParams);
    }

    private static a s(NativeModuleInitParams nativeModuleInitParams) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.a.b.f(java.lang.String):boolean");
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
            r4 = 0
            goto L5b
        L14:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 1
            goto L5b
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 5
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
            r4 = 7
            goto L5b
        L3c:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 3
            goto L5b
        L46:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 6
            goto L5b
        L50:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L5a
            r4 = 4
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.a.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01ff  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 782
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.a.b.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        try {
            switch (str) {
                case "nativeID":
                    aVar.bk((String) obj2);
                    break;
                case "disable":
                    aVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "style":
                    aVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    aVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "enabled":
                    aVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "pivotPoint":
                    aVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onPress":
                    aVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onLongPress":
                    aVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("LivePlayer", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("LivePlayer apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            com.kwad.tachikoma.live.a.a r2 = (com.kwad.tachikoma.live.a.a) r2
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
            r0 = 0
            goto L5b
        L14:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 1
            goto L5b
        L1e:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 5
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
            r0 = 7
            goto L5b
        L3c:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 3
            goto L5b
        L46:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 6
            goto L5b
        L50:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L5a
            r0 = 4
            goto L5b
        L5a:
            r0 = -1
        L5b:
            switch(r0) {
                case 0: goto L99;
                case 1: goto L92;
                case 2: goto L8f;
                case 3: goto L88;
                case 4: goto L81;
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
            java.lang.String r3 = "LivePlayer"
            android.util.Log.e(r3, r2)
            goto L9c
        L78:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        L7b:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        L7e:
            java.util.HashMap r2 = r2.aaQ
            return r2
        L81:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L88:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L8f:
            java.util.HashMap r2 = r2.style
            return r2
        L92:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        L99:
            java.lang.String r2 = r2.aaG
            return r2
        L9c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.a.b.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 14;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 4;
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
                        c = 23;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = 25;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 31;
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
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 24;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 2;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = '\n';
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
                        c = 1;
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
                        c = 0;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = '\"';
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
                        c = 15;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 28;
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
                        c = ' ';
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 30;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(f.T)) {
                        c = '\f';
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
                        c = 6;
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
                        c = 27;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 21;
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
                        c = '\t';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 1:
                    aVar.bv((String) obj2);
                    return;
                case 2:
                    aVar.bz((String) obj2);
                    return;
                case 3:
                    aVar.bo((String) obj2);
                    return;
                case 4:
                    aVar.bw((String) obj2);
                    return;
                case 5:
                    aVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 6:
                    aVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 7:
                    aVar.bm((String) obj2);
                    return;
                case '\b':
                    aVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\t':
                    aVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\n':
                    aVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 11:
                    aVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\f':
                    aVar.A(obj2);
                    return;
                case '\r':
                    aVar.bx((String) obj2);
                    return;
                case 14:
                    aVar.bs((String) obj2);
                    return;
                case 15:
                    aVar.bg((String) obj2);
                    return;
                case 16:
                    aVar.bu((String) obj2);
                    return;
                case 17:
                    aVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 18:
                    aVar.bq((String) obj2);
                    return;
                case 19:
                    aVar.br((String) obj2);
                    return;
                case 20:
                    aVar.bf((String) obj2);
                    return;
                case 21:
                    aVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    aVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 23:
                    aVar.bn((String) obj2);
                    return;
                case 24:
                    aVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 25:
                    aVar.bt((String) obj2);
                    return;
                case 26:
                    aVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 27:
                    aVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 28:
                    aVar.aB((String) obj2);
                    return;
                case 29:
                    aVar.bp((String) obj2);
                    return;
                case 30:
                    aVar.bA((String) obj2);
                    return;
                case 31:
                    aVar.by((String) obj2);
                    return;
                case ' ':
                    aVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '!':
                    aVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    aVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("LivePlayer", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("LivePlayer setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0204  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r9, java.lang.String r10, java.lang.Object[] r11) {
        /*
            Method dump skipped, instructions count: 1364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.tachikoma.live.a.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
