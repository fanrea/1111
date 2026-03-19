package com.tk.component.scroll;

import android.util.Log;
import com.alibaba.fastjson.parser.JSONLexer;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.luck.picture.lib.config.CustomIntentKey;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d implements com.tk.core.manager.a.a<c> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "onMomentumScrollEnd";
            case 1:
                return "nativeID";
            case 2:
                return "softInputMode";
            case 3:
                return "onScrollStateChanged";
            case 4:
                return "overScrollMode";
            case 5:
                return "scrollEnabled";
            case 6:
                return "onPress";
            case 7:
                return "disallowParentInterceptTouchEvent";
            case 8:
                return "scrollEventThrottle";
            case 9:
                return "onScroll";
            case 10:
                return "onContentSizeChange";
            case 11:
                return "onEndDrag";
            case 12:
                return "pivotPoint";
            case 13:
                return "enabled";
            case 14:
                return "onReachStart";
            case 15:
                return CustomIntentKey.EXTRA_OFFSET_Y;
            case 16:
                return CustomIntentKey.EXTRA_OFFSET_X;
            case 17:
                return "onReachEnd";
            case 18:
                return "onLongPress";
            case 19:
                return "pagingEnabled";
            case 20:
                return "style";
            case 21:
                return "disable";
            case 22:
                return "showScrollIndicator";
            case 23:
                return "onMomentumScrollBegin";
            case 24:
                return "onBeginDrag";
            case 25:
                return "layout";
            case 26:
                return "observeNextLayout";
            case 27:
                return "replaceChild";
            case 28:
                return "scrollTo";
            case 29:
                return "removeAll";
            case 30:
                return "setVisibility";
            case 31:
                return "insertBefore";
            case 32:
                return "getLocationOnScreen";
            case 33:
                return "addEventListener";
            case 34:
                return "setRotate";
            case 35:
                return "getOrigin";
            case 36:
                return "scrollElementToCenter";
            case 37:
                return "invokeNativeFunctionWithJSONString";
            case 38:
                return "removeAllAnimation";
            case 39:
                return "resumeAnimations";
            case 40:
                return "scrollToElement";
            case 41:
                return "setTranslateX";
            case 42:
                return "getElementById";
            case 43:
                return "startViewAnimation";
            case 44:
                return "pauseAnimations";
            case 45:
                return "setRotateX";
            case 46:
                return "addAnimation";
            case 47:
                return "setTranslateY";
            case 48:
                return "setGradientBgColor";
            case 49:
                return "_setVNode";
            case 50:
                return "removeChild";
            case 51:
                return "appendChild";
            case 52:
                return "invokeVoidNativeFunctionWithJSONString";
            case 53:
                return "removeAnimation";
            case 54:
                return "setRotateY";
            case 55:
                return "removeEventListener";
            case 56:
                return "setBackgroundColor";
            case 57:
                return "getSize";
            case 58:
                return "setScaleX";
            case 59:
                return "removeSelf";
            case 60:
                return "setScaleY";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#onMomentumScrollEnd#0,2#nativeID#1,2#softInputMode#2,2#onScrollStateChanged#3,2#overScrollMode#4,2#scrollEnabled#5,2#onPress#6,2#disallowParentInterceptTouchEvent#7,2#scrollEventThrottle#8,2#onScroll#9,2#onContentSizeChange#10,2#onEndDrag#11,2#pivotPoint#12,2#enabled#13,2#onReachStart#14,2#offsetY#15,2#offsetX#16,2#onReachEnd#17,2#onLongPress#18,2#pagingEnabled#19,2#style#20,2#disable#21,2#showScrollIndicator#22,2#onMomentumScrollBegin#23,2#onBeginDrag#24,4#layout#25,4#observeNextLayout#26,4#replaceChild#27,4#scrollTo#28,4#removeAll#29,4#setVisibility#30,4#insertBefore#31,8#getLocationOnScreen#32,4#addEventListener#33,4#setRotate#34,8#getOrigin#35,4#scrollElementToCenter#36,8#invokeNativeFunctionWithJSONString#37,4#removeAllAnimation#38,4#resumeAnimations#39,4#scrollToElement#40,4#setTranslateX#41,8#getElementById#42,4#startViewAnimation#43,4#pauseAnimations#44,4#setRotateX#45,4#addAnimation#46,4#setTranslateY#47,4#setGradientBgColor#48,4#_setVNode#49,4#removeChild#50,4#appendChild#51,4#invokeVoidNativeFunctionWithJSONString#52,4#removeAnimation#53,4#setRotateY#54,4#removeEventListener#55,4#setBackgroundColor#56,8#getSize#57,4#setScaleX#58,4#removeSelf#59,4#setScaleY#60";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return aa(nativeModuleInitParams);
    }

    private static c aa(NativeModuleInitParams nativeModuleInitParams) {
        return new c(nativeModuleInitParams);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.scroll.d.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0125  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.scroll.d.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ab  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.scroll.d.h(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        c cVar = (c) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -2039481915:
                    if (str.equals("onMomentumScrollBegin")) {
                        c = 23;
                        break;
                    }
                    break;
                case -1771288082:
                    if (str.equals("onReachStart")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1609594047:
                    if (str.equals("enabled")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1548407259:
                    if (str.equals(CustomIntentKey.EXTRA_OFFSET_X)) {
                        c = 16;
                        break;
                    }
                    break;
                case -1548407258:
                    if (str.equals(CustomIntentKey.EXTRA_OFFSET_Y)) {
                        c = 15;
                        break;
                    }
                    break;
                case -1396530953:
                    if (str.equals("onMomentumScrollEnd")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1339721308:
                    if (str.equals("onPress")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1321236988:
                    if (str.equals("overScrollMode")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1221113672:
                    if (str.equals("disallowParentInterceptTouchEvent")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1151046732:
                    if (str.equals("scrollEnabled")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1104094626:
                    if (str.equals("onBeginDrag")) {
                        c = 24;
                        break;
                    }
                    break;
                case -502352363:
                    if (str.equals("pagingEnabled")) {
                        c = 19;
                        break;
                    }
                    break;
                case -271432240:
                    if (str.equals("onEndDrag")) {
                        c = 11;
                        break;
                    }
                    break;
                case 83417096:
                    if (str.equals("onLongPress")) {
                        c = 18;
                        break;
                    }
                    break;
                case 109780401:
                    if (str.equals("style")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1056207947:
                    if (str.equals("onContentSizeChange")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1191457029:
                    if (str.equals("showScrollIndicator")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1281290862:
                    if (str.equals("pivotPoint")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 1299792015:
                    if (str.equals("onScrollStateChanged")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1490730380:
                    if (str.equals("onScroll")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1551256451:
                    if (str.equals("softInputMode")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1671308008:
                    if (str.equals("disable")) {
                        c = 21;
                        break;
                    }
                    break;
                case 1782490647:
                    if (str.equals("scrollEventThrottle")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1902051687:
                    if (str.equals("onReachEnd")) {
                        c = 17;
                        break;
                    }
                    break;
                case 2045685618:
                    if (str.equals("nativeID")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    cVar.av((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 1:
                    cVar.bk((String) obj2);
                    break;
                case 2:
                    cVar.aW((String) obj2);
                    break;
                case 3:
                    cVar.ap((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 4:
                    cVar.aS((String) obj2);
                    break;
                case 5:
                    cVar.N(((Boolean) obj2).booleanValue());
                    break;
                case 6:
                    cVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 7:
                    cVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case '\b':
                    cVar.setScrollEventThrottle(com.tk.core.manager.a.f.i((Number) obj2));
                    break;
                case '\t':
                    cVar.at((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\n':
                    cVar.aA((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 11:
                    cVar.az((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\f':
                    cVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\r':
                    cVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case 14:
                    cVar.aw((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 15:
                    cVar.Vp = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case 16:
                    cVar.Vo = com.tk.core.manager.a.f.h((Number) obj2);
                    break;
                case 17:
                    cVar.ax((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 18:
                    cVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 19:
                    cVar.ak(((Boolean) obj2).booleanValue());
                    break;
                case 20:
                    cVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 21:
                    cVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case 22:
                    cVar.ac(((Boolean) obj2).booleanValue());
                    break;
                case 23:
                    cVar.au((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 24:
                    cVar.ay((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKScrollView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKScrollView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0125  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.scroll.d.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        c cVar = (c) obj;
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
                        c = '\f';
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 1;
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
                        c = 18;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 23;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 5;
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
                        c = '\n';
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
                        c = '\"';
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = '!';
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 22;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = 3;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 21;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = 28;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 20;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = 7;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 31;
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
                        c = 24;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 19;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 25;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 27;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 29;
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
                        c = 17;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = ' ';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    cVar.A(obj2);
                    return;
                case 1:
                    cVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 2:
                    cVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 3:
                    cVar.bq((String) obj2);
                    return;
                case 4:
                    cVar.bt((String) obj2);
                    return;
                case 5:
                    cVar.by((String) obj2);
                    return;
                case 6:
                    cVar.bn((String) obj2);
                    return;
                case 7:
                    cVar.bg((String) obj2);
                    return;
                case '\b':
                    cVar.aB((String) obj2);
                    return;
                case '\t':
                    cVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\n':
                    cVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 11:
                    cVar.br((String) obj2);
                    return;
                case '\f':
                    cVar.bx((String) obj2);
                    return;
                case '\r':
                    cVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 14:
                    cVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 15:
                    cVar.bs((String) obj2);
                    return;
                case 16:
                    cVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 17:
                    cVar.bm((String) obj2);
                    return;
                case 18:
                    cVar.bw((String) obj2);
                    return;
                case 19:
                    cVar.bp((String) obj2);
                    return;
                case 20:
                    cVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 21:
                    cVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 22:
                    cVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 23:
                    cVar.bo((String) obj2);
                    return;
                case 24:
                    cVar.bA((String) obj2);
                    return;
                case 25:
                    cVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 26:
                    cVar.bv((String) obj2);
                    return;
                case 27:
                    cVar.bf((String) obj2);
                    return;
                case 28:
                    cVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 29:
                    cVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 30:
                    cVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 31:
                    cVar.bu((String) obj2);
                    return;
                case ' ':
                    cVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '!':
                    cVar.bz((String) obj2);
                    return;
                case '\"':
                    cVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKScrollView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKScrollView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01af  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 1202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.scroll.d.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
