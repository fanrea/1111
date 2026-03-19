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
public final class m implements com.tk.core.manager.a.a<l> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "disable";
            case 1:
                return "onPress";
            case 2:
                return "lottieRes";
            case 3:
                return "style";
            case 4:
                return "nativeID";
            case 5:
                return "isAnimationPlaying";
            case 6:
                return "onLongPress";
            case 7:
                return "pivotPoint";
            case 8:
                return "lottiePath";
            case 9:
                return "disallowParentInterceptTouchEvent";
            case 10:
                return "enabled";
            case 11:
                return ContentProviderManager.PROVIDER_URI;
            case 12:
                return "resume";
            case 13:
                return "setTranslateX";
            case 14:
                return "onAnimationRepeat";
            case 15:
                return "setLoop";
            case 16:
                return "setRotateX";
            case 17:
                return "prefetch";
            case 18:
                return "setUri";
            case 19:
                return "getSize";
            case 20:
                return "removeAllAnimation";
            case 21:
                return "onAnimationUpdate";
            case 22:
                return "_setVNode";
            case 23:
                return "setRotate";
            case 24:
                return "setGradientBgColor";
            case 25:
                return "setBackgroundColor";
            case 26:
                return "pauseAnimations";
            case 27:
                return "removeSelf";
            case 28:
                return "observeNextLayout";
            case 29:
                return "onAnimationEnd";
            case 30:
                return "resumeAnimations";
            case 31:
                return "layout";
            case 32:
                return "setRotateY";
            case 33:
                return "setTranslateY";
            case 34:
                return "setImageFolder";
            case 35:
                return "removeAnimation";
            case 36:
                return "setAutoPlay";
            case 37:
                return "setVisibility";
            case 38:
                return "setProgress";
            case 39:
                return "onAnimationStart";
            case 40:
                return "onAnimationCancel";
            case 41:
                return "removeEventListener";
            case 42:
                return "getLocationOnScreen";
            case 43:
                return com.component.feed.a.e;
            case 44:
                return "invokeVoidNativeFunctionWithJSONString";
            case 45:
                return "onAnimationLoaded";
            case 46:
                return "getOrigin";
            case 47:
                return "play";
            case 48:
                return "invokeNativeFunctionWithJSONString";
            case 49:
                return "setScaleY";
            case 50:
                return "addAnimation";
            case 51:
                return "addEventListener";
            case 52:
                return "startViewAnimation";
            case 53:
                return "setScaleX";
            case 54:
                return "pause";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#disable#0,2#onPress#1,2#lottieRes#2,2#style#3,2#nativeID#4,2#isAnimationPlaying#5,2#onLongPress#6,2#pivotPoint#7,2#lottiePath#8,2#disallowParentInterceptTouchEvent#9,2#enabled#10,2#uri#11,4#resume#12,4#setTranslateX#13,4#onAnimationRepeat#14,4#setLoop#15,4#setRotateX#16,4#prefetch#17,4#setUri#18,8#getSize#19,4#removeAllAnimation#20,4#onAnimationUpdate#21,4#_setVNode#22,4#setRotate#23,4#setGradientBgColor#24,4#setBackgroundColor#25,4#pauseAnimations#26,4#removeSelf#27,4#observeNextLayout#28,4#onAnimationEnd#29,4#resumeAnimations#30,4#layout#31,4#setRotateY#32,4#setTranslateY#33,4#setImageFolder#34,4#removeAnimation#35,4#setAutoPlay#36,4#setVisibility#37,4#setProgress#38,4#onAnimationStart#39,4#onAnimationCancel#40,4#removeEventListener#41,8#getLocationOnScreen#42,4#stop#43,4#invokeVoidNativeFunctionWithJSONString#44,4#onAnimationLoaded#45,8#getOrigin#46,4#play#47,8#invokeNativeFunctionWithJSONString#48,4#setScaleY#49,4#addAnimation#50,4#addEventListener#51,4#startViewAnimation#52,4#setScaleX#53,4#pause#54";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ l b(NativeModuleInitParams nativeModuleInitParams) {
        return W(nativeModuleInitParams);
    }

    private static l W(NativeModuleInitParams nativeModuleInitParams) {
        return new l(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.m.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
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
                case -1609594047: goto L7e;
                case -1339721308: goto L74;
                case -1233007276: goto L6a;
                case -1221113672: goto L5f;
                case 116076: goto L54;
                case 83417096: goto L4a;
                case 109780401: goto L40;
                case 467992676: goto L35;
                case 1281290862: goto L2b;
                case 1539119233: goto L21;
                case 1671308008: goto L16;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L89
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 4
            goto L8a
        L16:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 0
            goto L8a
        L21:
            java.lang.String r0 = "lottieRes"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 2
            goto L8a
        L2b:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 7
            goto L8a
        L35:
            java.lang.String r0 = "lottiePath"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 8
            goto L8a
        L40:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 3
            goto L8a
        L4a:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 6
            goto L8a
        L54:
            java.lang.String r0 = "uri"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 11
            goto L8a
        L5f:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 9
            goto L8a
        L6a:
            java.lang.String r0 = "isAnimationPlaying"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 5
            goto L8a
        L74:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 1
            goto L8a
        L7e:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 10
            goto L8a
        L89:
            r4 = -1
        L8a:
            switch(r4) {
                case 0: goto L8e;
                case 1: goto L8e;
                case 2: goto L8e;
                case 3: goto L8e;
                case 4: goto L8e;
                case 5: goto L8e;
                case 6: goto L8e;
                case 7: goto L8e;
                case 8: goto L8e;
                case 9: goto L8e;
                case 10: goto L8e;
                case 11: goto L8e;
                default: goto L8d;
            }
        L8d:
            return r2
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.m.g(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.m.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        l lVar = (l) obj;
        try {
            switch (str) {
                case "disable":
                    lVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "onPress":
                    lVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "lottieRes":
                    lVar.aK((String) obj2);
                    break;
                case "style":
                    lVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "nativeID":
                    lVar.bk((String) obj2);
                    break;
                case "isAnimationPlaying":
                    lVar.RF = ((Boolean) obj2).booleanValue();
                    break;
                case "onLongPress":
                    lVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "pivotPoint":
                    lVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "lottiePath":
                    lVar.aL((String) obj2);
                    break;
                case "disallowParentInterceptTouchEvent":
                    lVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "enabled":
                    lVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "uri":
                    lVar.at((String) obj2);
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKLottieImageView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKLottieImageView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0089  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.m.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        l lVar = (l) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals("borderRightColor")) {
                        c = 27;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 7;
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
                        c = 19;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 18;
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
                        c = '\n';
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 3;
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
                        c = 31;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 5;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 6;
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
                        c = 0;
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
                        c = 25;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = ' ';
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
                        c = 29;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 11;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 22;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 15;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = 21;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 14;
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
                        c = '\b';
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = 24;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    lVar.bq((String) obj2);
                    return;
                case 1:
                    lVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 2:
                    lVar.bA((String) obj2);
                    return;
                case 3:
                    lVar.by((String) obj2);
                    return;
                case 4:
                    lVar.bm((String) obj2);
                    return;
                case 5:
                    lVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 6:
                    lVar.bz((String) obj2);
                    return;
                case 7:
                    lVar.bx((String) obj2);
                    return;
                case '\b':
                    lVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\t':
                    lVar.bw((String) obj2);
                    return;
                case '\n':
                    lVar.bo((String) obj2);
                    return;
                case 11:
                    lVar.bg((String) obj2);
                    return;
                case '\f':
                    lVar.bt((String) obj2);
                    return;
                case '\r':
                    lVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 14:
                    lVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 15:
                    lVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 16:
                    lVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 17:
                    lVar.bv((String) obj2);
                    return;
                case 18:
                    lVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 19:
                    lVar.br((String) obj2);
                    return;
                case 20:
                    lVar.bf((String) obj2);
                    return;
                case 21:
                    lVar.A(obj2);
                    return;
                case 22:
                    lVar.aB((String) obj2);
                    return;
                case 23:
                    lVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 24:
                    lVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 25:
                    lVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 26:
                    lVar.bu((String) obj2);
                    return;
                case 27:
                    lVar.bs((String) obj2);
                    return;
                case 28:
                    lVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 29:
                    lVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 30:
                    lVar.bn((String) obj2);
                    return;
                case 31:
                    lVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case ' ':
                    lVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '!':
                    lVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\"':
                    lVar.bp((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKLottieImageView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKLottieImageView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0202  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 1318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.imageview.m.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
