package com.tk.component.listview;

import android.util.Log;
import com.alibaba.fastjson.parser.JSONLexer;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.manager.a.f;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Trace;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c implements com.tk.core.manager.a.a<TKListView2> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "onProgressUpdated";
            case 1:
                return "onSnap";
            case 2:
                return "repeatedItemLayouts";
            case 3:
                return "disable";
            case 4:
                return "onHeaderShow";
            case 5:
                return "snapType";
            case 6:
                return "getItemsType";
            case 7:
                return "disallowParentInterceptTouchEvent";
            case 8:
                return "scrollEnabled";
            case 9:
                return "onFooterShow";
            case 10:
                return "bindData";
            case 11:
                return "onVisibleItemsChanged";
            case 12:
                return "snapInfo";
            case 13:
                return "style";
            case 14:
                return "repeatedItemTypes";
            case 15:
                return "showScrollIndicator";
            case 16:
                return "overScrollMode";
            case 17:
                return "onScrollStateChanged";
            case 18:
                return "pivotPoint";
            case 19:
                return "onLongPress";
            case 20:
                return "getItemsLayout";
            case 21:
                return "onPress";
            case 22:
                return V8Trace.SECTION_CREATE_VIEW;
            case 23:
                return "onScroll";
            case 24:
                return "nativeID";
            case 25:
                return "enabled";
            case 26:
                return "scrollEventThrottle";
            case 27:
                return "notifyAllRemoved";
            case 28:
                return "removeEventListener";
            case 29:
                return "layout";
            case 30:
                return "notifyHeaderChanged";
            case 31:
                return "removeAllAnimation";
            case 32:
                return "notifyItemRangeChanged";
            case 33:
                return "addEventListener";
            case 34:
                return "invokeNativeFunctionWithJSONString";
            case 35:
                return "setRotateX";
            case 36:
                return "setHeader";
            case 37:
                return "notifyItemRangeRemoved";
            case 38:
                return "setScaleY";
            case 39:
                return "resumeAnimations";
            case 40:
                return "pauseAnimations";
            case 41:
                return "removeSelf";
            case 42:
                return "setRotateY";
            case 43:
                return "getSize";
            case 44:
                return "setTranslateX";
            case 45:
                return "setBackgroundColor";
            case 46:
                return "setTranslateY";
            case 47:
                return "startViewAnimation";
            case 48:
                return "stopScroll";
            case 49:
                return "notifyDataSetChanged";
            case 50:
                return "scrollToPositionWithOffset";
            case 51:
                return "setPullRefresh";
            case 52:
                return "notifyItemRangeInserted";
            case 53:
                return "addAnimation";
            case 54:
                return "getOrigin";
            case 55:
                return "notifyItemMoved";
            case 56:
                return "observeNextLayout";
            case 57:
                return "getVisibleItemViewByIndex";
            case 58:
                return "scrollToPosition";
            case 59:
                return "notifyItemInserted";
            case 60:
                return "notifyItemRemoved";
            case 61:
                return "setScaleX";
            case 62:
                return "_setVNode";
            case 63:
                return "getLocationOnScreen";
            case 64:
                return "notifyItemChanged";
            case 65:
                return "scrollBy";
            case 66:
                return "setVisibility";
            case 67:
                return "invokeVoidNativeFunctionWithJSONString";
            case 68:
                return "setFooter";
            case 69:
                return "setRotate";
            case 70:
                return "scrollPositionToCenter";
            case 71:
                return "removeAnimation";
            case 72:
                return "notifyFooterChanged";
            case 73:
                return "setGradientBgColor";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#onProgressUpdated#0,2#onSnap#1,2#repeatedItemLayouts#2,2#disable#3,2#onHeaderShow#4,2#snapType#5,2#getItemsType#6,2#disallowParentInterceptTouchEvent#7,2#scrollEnabled#8,2#onFooterShow#9,2#bindData#10,2#onVisibleItemsChanged#11,2#snapInfo#12,2#style#13,2#repeatedItemTypes#14,2#showScrollIndicator#15,2#overScrollMode#16,2#onScrollStateChanged#17,2#pivotPoint#18,2#onLongPress#19,2#getItemsLayout#20,2#onPress#21,2#createView#22,2#onScroll#23,2#nativeID#24,2#enabled#25,2#scrollEventThrottle#26,4#notifyAllRemoved#27,4#removeEventListener#28,4#layout#29,4#notifyHeaderChanged#30,4#removeAllAnimation#31,4#notifyItemRangeChanged#32,4#addEventListener#33,8#invokeNativeFunctionWithJSONString#34,4#setRotateX#35,4#setHeader#36,4#notifyItemRangeRemoved#37,4#setScaleY#38,4#resumeAnimations#39,4#pauseAnimations#40,4#removeSelf#41,4#setRotateY#42,8#getSize#43,4#setTranslateX#44,4#setBackgroundColor#45,4#setTranslateY#46,4#startViewAnimation#47,4#stopScroll#48,4#notifyDataSetChanged#49,4#scrollToPositionWithOffset#50,4#setPullRefresh#51,4#notifyItemRangeInserted#52,4#addAnimation#53,8#getOrigin#54,4#notifyItemMoved#55,4#observeNextLayout#56,8#getVisibleItemViewByIndex#57,4#scrollToPosition#58,4#notifyItemInserted#59,4#notifyItemRemoved#60,4#setScaleX#61,4#_setVNode#62,8#getLocationOnScreen#63,4#notifyItemChanged#64,4#scrollBy#65,4#setVisibility#66,4#invokeVoidNativeFunctionWithJSONString#67,4#setFooter#68,4#setRotate#69,4#scrollPositionToCenter#70,4#removeAnimation#71,4#notifyFooterChanged#72,4#setGradientBgColor#73";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ TKListView2 b(NativeModuleInitParams nativeModuleInitParams) {
        return Y(nativeModuleInitParams);
    }

    private static TKListView2 Y(NativeModuleInitParams nativeModuleInitParams) {
        return new TKListView2(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01da  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.listview.c.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013d  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.listview.c.g(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.listview.c.h(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        TKListView2 tKListView2 = (TKListView2) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -2133230492:
                    if (str.equals("getItemsType")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1609594047:
                    if (str.equals("enabled")) {
                        c = 25;
                        break;
                    }
                    break;
                case -1586018860:
                    if (str.equals("getItemsLayout")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1541121017:
                    if (str.equals("onVisibleItemsChanged")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1339721308:
                    if (str.equals("onPress")) {
                        c = 21;
                        break;
                    }
                    break;
                case -1321236988:
                    if (str.equals("overScrollMode")) {
                        c = 16;
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
                        c = '\b';
                        break;
                    }
                    break;
                case -1012962743:
                    if (str.equals("onSnap")) {
                        c = 1;
                        break;
                    }
                    break;
                case 83417096:
                    if (str.equals("onLongPress")) {
                        c = 19;
                        break;
                    }
                    break;
                case 109780401:
                    if (str.equals("style")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 283628440:
                    if (str.equals("snapInfo")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 283967012:
                    if (str.equals("snapType")) {
                        c = 5;
                        break;
                    }
                    break;
                case 466165367:
                    if (str.equals("onFooterShow")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 757027868:
                    if (str.equals("repeatedItemLayouts")) {
                        c = 2;
                        break;
                    }
                    break;
                case 939008391:
                    if (str.equals("bindData")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1023115881:
                    if (str.equals("onHeaderShow")) {
                        c = 4;
                        break;
                    }
                    break;
                case 1191457029:
                    if (str.equals("showScrollIndicator")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1281290862:
                    if (str.equals("pivotPoint")) {
                        c = 18;
                        break;
                    }
                    break;
                case 1299792015:
                    if (str.equals("onScrollStateChanged")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1369272769:
                    if (str.equals(V8Trace.SECTION_CREATE_VIEW)) {
                        c = 22;
                        break;
                    }
                    break;
                case 1425640140:
                    if (str.equals("repeatedItemTypes")) {
                        c = 14;
                        break;
                    }
                    break;
                case 1490730380:
                    if (str.equals("onScroll")) {
                        c = 23;
                        break;
                    }
                    break;
                case 1541974511:
                    if (str.equals("onProgressUpdated")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1671308008:
                    if (str.equals("disable")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1782490647:
                    if (str.equals("scrollEventThrottle")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 2045685618:
                    if (str.equals("nativeID")) {
                        c = 24;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    tKListView2.ao((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 1:
                    tKListView2.ah((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 2:
                    V8ObjectUtilsQuick.getValue(obj2);
                    break;
                case 3:
                    tKListView2.ao(((Boolean) obj2).booleanValue());
                    break;
                case 4:
                    tKListView2.ai((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 5:
                    tKListView2.cR(f.h((Number) obj2));
                    break;
                case 6:
                    tKListView2.ak((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 7:
                    tKListView2.ap(((Boolean) obj2).booleanValue());
                    break;
                case '\b':
                    tKListView2.N(((Boolean) obj2).booleanValue());
                    break;
                case '\t':
                    tKListView2.aj((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\n':
                    tKListView2.am((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 11:
                    tKListView2.an((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\f':
                    tKListView2.d((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\r':
                    tKListView2.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 14:
                    tKListView2.k((List) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 15:
                    tKListView2.ac(((Boolean) obj2).booleanValue());
                    break;
                case 16:
                    tKListView2.aS((String) obj2);
                    break;
                case 17:
                    tKListView2.ap((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 18:
                    tKListView2.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 19:
                    tKListView2.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 20:
                    V8ObjectUtilsQuick.getValue(obj2);
                    break;
                case 21:
                    tKListView2.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 22:
                    tKListView2.al((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 23:
                    tKListView2.aq((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 24:
                    tKListView2.bk((String) obj2);
                    break;
                case 25:
                    tKListView2.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case 26:
                    tKListView2.setScrollEventThrottle(f.i((Number) obj2));
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKListView2", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKListView2 apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013d  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.listview.c.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        TKListView2 tKListView2 = (TKListView2) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals("borderRightColor")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 24;
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
                        c = 28;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = '\'';
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case -1439500848:
                    if (str.equals("orientation")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 22;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = '\n';
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
                        c = 17;
                        break;
                    }
                    break;
                case -1269519188:
                    if (str.equals("itemHorizontalSpacing")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 21;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1063962534:
                    if (str.equals("itemVerticalSpacing")) {
                        c = 4;
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
                        c = '\t';
                        break;
                    }
                    break;
                case -669554715:
                    if (str.equals("spanCount")) {
                        c = 1;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = 7;
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
                        c = 16;
                        break;
                    }
                    break;
                case 341443565:
                    if (str.equals("layoutMode")) {
                        c = 6;
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
                        c = 2;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 0;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 3;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = JSONLexer.EOI;
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
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = '#';
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
                        c = 27;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 29;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = '%';
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = '!';
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
                        c = 19;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    tKListView2.aB((String) obj2);
                    return;
                case 1:
                    tKListView2.al(f.h((Number) obj2));
                    return;
                case 2:
                    tKListView2.dx(f.h((Number) obj2));
                    return;
                case 3:
                    tKListView2.bu((String) obj2);
                    return;
                case 4:
                    tKListView2.cP(f.h((Number) obj2));
                    return;
                case 5:
                    tKListView2.bo((String) obj2);
                    return;
                case 6:
                    tKListView2.setLayoutMode(f.h((Number) obj2));
                    return;
                case 7:
                    tKListView2.bv((String) obj2);
                    return;
                case '\b':
                    tKListView2.bz((String) obj2);
                    return;
                case '\t':
                    tKListView2.A(f.g((Number) obj2));
                    return;
                case '\n':
                    tKListView2.bt((String) obj2);
                    return;
                case 11:
                    tKListView2.h(f.f((Number) obj2));
                    return;
                case '\f':
                    tKListView2.cc(f.h((Number) obj2));
                    return;
                case '\r':
                    tKListView2.setOrientation(f.h((Number) obj2));
                    return;
                case 14:
                    tKListView2.bm((String) obj2);
                    return;
                case 15:
                    tKListView2.d(f.f((Number) obj2));
                    return;
                case 16:
                    tKListView2.dw(f.h((Number) obj2));
                    return;
                case 17:
                    tKListView2.g(f.f((Number) obj2));
                    return;
                case 18:
                    tKListView2.cQ(f.h((Number) obj2));
                    return;
                case 19:
                    tKListView2.bZ(f.h((Number) obj2));
                    return;
                case 20:
                    tKListView2.bs((String) obj2);
                    return;
                case 21:
                    tKListView2.dv(f.h((Number) obj2));
                    return;
                case 22:
                    tKListView2.bn((String) obj2);
                    return;
                case 23:
                    tKListView2.f(f.f((Number) obj2));
                    return;
                case 24:
                    tKListView2.bx((String) obj2);
                    return;
                case 25:
                    tKListView2.dy(f.h((Number) obj2));
                    return;
                case 26:
                    tKListView2.a(f.f((Number) obj2));
                    return;
                case 27:
                    tKListView2.bY(f.h((Number) obj2));
                    return;
                case 28:
                    tKListView2.br((String) obj2);
                    return;
                case 29:
                    tKListView2.bf((String) obj2);
                    return;
                case 30:
                    tKListView2.bA((String) obj2);
                    return;
                case 31:
                    tKListView2.by((String) obj2);
                    return;
                case ' ':
                    tKListView2.bg((String) obj2);
                    return;
                case '!':
                    tKListView2.cb(f.h((Number) obj2));
                    return;
                case '\"':
                    tKListView2.bp((String) obj2);
                    return;
                case '#':
                    tKListView2.A(obj2);
                    return;
                case '$':
                    tKListView2.bq((String) obj2);
                    return;
                case '%':
                    tKListView2.ca(f.h((Number) obj2));
                    return;
                case '&':
                    tKListView2.e(f.f((Number) obj2));
                    return;
                case '\'':
                    tKListView2.bw((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKListView2", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKListView2 setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0234  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
            Method dump skipped, instructions count: 1602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.component.listview.c.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
