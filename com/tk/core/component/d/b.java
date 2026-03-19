package com.tk.core.component.d;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.parser.JSONLexer;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.manager.a.f;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements com.tk.core.manager.a.a<a> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "onPress";
            case 1:
                return "pivotPoint";
            case 2:
                return "style";
            case 3:
                return "disallowParentInterceptTouchEvent";
            case 4:
                return TypedValues.Custom.S_COLOR;
            case 5:
                return "onLongPress";
            case 6:
                return "disable";
            case 7:
                return "progress";
            case 8:
                return "enabled";
            case 9:
                return "animating";
            case 10:
                return "nativeID";
            case 11:
                return "setColor";
            case 12:
                return "observeNextLayout";
            case 13:
                return "_setVNode";
            case 14:
                return "setScaleY";
            case 15:
                return "layout";
            case 16:
                return "removeAllAnimation";
            case 17:
                return "getSize";
            case 18:
                return "invokeNativeFunctionWithJSONString";
            case 19:
                return "setRotateY";
            case 20:
                return "addEventListener";
            case 21:
                return "setRotateX";
            case 22:
                return "pauseAnimations";
            case 23:
                return "setProgress";
            case 24:
                return "removeEventListener";
            case 25:
                return "setTranslateX";
            case 26:
                return "setScaleX";
            case 27:
                return "setTranslateY";
            case 28:
                return "resumeAnimations";
            case 29:
                return "setBackgroundColor";
            case 30:
                return "addAnimation";
            case 31:
                return "removeSelf";
            case 32:
                return "getOrigin";
            case 33:
                return "setVisibility";
            case 34:
                return "invokeVoidNativeFunctionWithJSONString";
            case 35:
                return "setRotate";
            case 36:
                return "startViewAnimation";
            case 37:
                return "getLocationOnScreen";
            case 38:
                return "removeAnimation";
            case 39:
                return "setGradientBgColor";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#onPress#0,2#pivotPoint#1,2#style#2,2#disallowParentInterceptTouchEvent#3,2#color#4,2#onLongPress#5,2#disable#6,2#progress#7,2#enabled#8,2#animating#9,2#nativeID#10,4#setColor#11,4#observeNextLayout#12,4#_setVNode#13,4#setScaleY#14,4#layout#15,4#removeAllAnimation#16,8#getSize#17,8#invokeNativeFunctionWithJSONString#18,4#setRotateY#19,4#addEventListener#20,4#setRotateX#21,4#pauseAnimations#22,4#setProgress#23,4#removeEventListener#24,4#setTranslateX#25,4#setScaleX#26,4#setTranslateY#27,4#resumeAnimations#28,4#setBackgroundColor#29,4#addAnimation#30,4#removeSelf#31,8#getOrigin#32,4#setVisibility#33,4#invokeVoidNativeFunctionWithJSONString#34,4#setRotate#35,4#startViewAnimation#36,8#getLocationOnScreen#37,4#removeAnimation#38,4#setGradientBgColor#39";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "0";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ a b(NativeModuleInitParams nativeModuleInitParams) {
        return al(nativeModuleInitParams);
    }

    private static a al(NativeModuleInitParams nativeModuleInitParams) {
        return new a(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01b5  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.d.b.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
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
                case -1609594047: goto L72;
                case -1339721308: goto L68;
                case -1221113672: goto L5e;
                case -1001078227: goto L54;
                case 83417096: goto L4a;
                case 94842723: goto L40;
                case 109780401: goto L36;
                case 1118509918: goto L2b;
                case 1281290862: goto L21;
                case 1671308008: goto L17;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L7d
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 10
            goto L7e
        L17:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 6
            goto L7e
        L21:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 1
            goto L7e
        L2b:
            java.lang.String r0 = "animating"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 9
            goto L7e
        L36:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 2
            goto L7e
        L40:
            java.lang.String r0 = "color"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 4
            goto L7e
        L4a:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 5
            goto L7e
        L54:
            java.lang.String r0 = "progress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 7
            goto L7e
        L5e:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 3
            goto L7e
        L68:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 0
            goto L7e
        L72:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L7d
            r4 = 8
            goto L7e
        L7d:
            r4 = -1
        L7e:
            switch(r4) {
                case 0: goto L82;
                case 1: goto L82;
                case 2: goto L82;
                case 3: goto L82;
                case 4: goto L82;
                case 5: goto L82;
                case 6: goto L82;
                case 7: goto L82;
                case 8: goto L82;
                case 9: goto L82;
                case 10: goto L82;
                default: goto L81;
            }
        L81:
            return r2
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.d.b.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0157  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.d.b.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        a aVar = (a) obj;
        try {
            switch (str) {
                case "onPress":
                    aVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "pivotPoint":
                    aVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "style":
                    aVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    aVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "color":
                    aVar.aj((String) obj2);
                    break;
                case "onLongPress":
                    aVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disable":
                    aVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "progress":
                    aVar.i(f.f((Number) obj2));
                    break;
                case "enabled":
                    aVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "animating":
                    aVar.as(((Boolean) obj2).booleanValue());
                    break;
                case "nativeID":
                    aVar.bk((String) obj2);
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKProgressBarView", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKProgressBarView apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007d  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            r1 = this;
            com.tk.core.component.d.a r2 = (com.tk.core.component.d.a) r2
            int r0 = r3.hashCode()
            switch(r0) {
                case -1609594047: goto L72;
                case -1339721308: goto L68;
                case -1221113672: goto L5e;
                case -1001078227: goto L54;
                case 83417096: goto L4a;
                case 94842723: goto L40;
                case 109780401: goto L36;
                case 1118509918: goto L2b;
                case 1281290862: goto L21;
                case 1671308008: goto L17;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto L7d
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 10
            goto L7e
        L17:
            java.lang.String r0 = "disable"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 6
            goto L7e
        L21:
            java.lang.String r0 = "pivotPoint"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 1
            goto L7e
        L2b:
            java.lang.String r0 = "animating"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 9
            goto L7e
        L36:
            java.lang.String r0 = "style"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 2
            goto L7e
        L40:
            java.lang.String r0 = "color"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 4
            goto L7e
        L4a:
            java.lang.String r0 = "onLongPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 5
            goto L7e
        L54:
            java.lang.String r0 = "progress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 7
            goto L7e
        L5e:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 3
            goto L7e
        L68:
            java.lang.String r0 = "onPress"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 0
            goto L7e
        L72:
            java.lang.String r0 = "enabled"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L7d
            r0 = 8
            goto L7e
        L7d:
            r0 = -1
        L7e:
            switch(r0) {
                case 0: goto Lcd;
                case 1: goto Lca;
                case 2: goto Lc7;
                case 3: goto Lc0;
                case 4: goto Lbd;
                case 5: goto Lba;
                case 6: goto Lb3;
                case 7: goto Lac;
                case 8: goto La5;
                case 9: goto L9e;
                case 10: goto L9b;
                default: goto L81;
            }
        L81:
            boolean r2 = com.tk.core.o.t.isDebug()
            if (r2 == 0) goto Ld0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = "call getProp() with unsupported prop: "
            r2.<init>(r0)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "TKProgressBarView"
            android.util.Log.e(r3, r2)
            goto Ld0
        L9b:
            java.lang.String r2 = r2.aaG
            return r2
        L9e:
            boolean r2 = r2.aem
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        La5:
            boolean r2 = r2.enabled
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lac:
            double r2 = r2.ael
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            return r2
        Lb3:
            boolean r2 = r2.aaM
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lba:
            com.tkruntime.v8.V8Function r2 = r2.aaJ
            return r2
        Lbd:
            java.lang.String r2 = r2.aei
            return r2
        Lc0:
            boolean r2 = r2.aaN
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            return r2
        Lc7:
            java.util.HashMap r2 = r2.style
            return r2
        Lca:
            java.util.HashMap r2 = r2.aaQ
            return r2
        Lcd:
            com.tkruntime.v8.V8Function r2 = r2.aaH
            return r2
        Ld0:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.d.b.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = '\"';
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 27;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 21;
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
                        c = 5;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 24;
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = 7;
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
                        c = 28;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 16;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = '#';
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = 20;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 11;
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
                        c = 30;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 4;
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
                        c = '!';
                        break;
                    }
                    break;
                case 583595847:
                    if (str.equals("cornerRadius")) {
                        c = 18;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 633138363:
                    if (str.equals("indeterminate")) {
                        c = 17;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = '\n';
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
                        c = 29;
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
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = 3;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 22;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 15;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = Typography.dollar;
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
                    aVar.bq((String) obj2);
                    return;
                case 1:
                    aVar.bo((String) obj2);
                    return;
                case 2:
                    aVar.bY(f.h((Number) obj2));
                    return;
                case 3:
                    aVar.A(obj2);
                    return;
                case 4:
                    aVar.d(f.f((Number) obj2));
                    return;
                case 5:
                    aVar.bw((String) obj2);
                    return;
                case 6:
                    aVar.br((String) obj2);
                    return;
                case 7:
                    aVar.bt((String) obj2);
                    return;
                case '\b':
                    aVar.dx(f.h((Number) obj2));
                    return;
                case '\t':
                    aVar.cb(f.h((Number) obj2));
                    return;
                case '\n':
                    aVar.aB((String) obj2);
                    return;
                case 11:
                    aVar.A(f.g((Number) obj2));
                    return;
                case '\f':
                    aVar.bu((String) obj2);
                    return;
                case '\r':
                    aVar.bg((String) obj2);
                    return;
                case 14:
                    aVar.dv(f.h((Number) obj2));
                    return;
                case 15:
                    aVar.bf((String) obj2);
                    return;
                case 16:
                    aVar.h(f.f((Number) obj2));
                    return;
                case 17:
                    aVar.setIndeterminate(((Boolean) obj2).booleanValue());
                    return;
                case 18:
                    aVar.setCornerRadius(f.g((Number) obj2));
                    return;
                case 19:
                    aVar.bZ(f.h((Number) obj2));
                    return;
                case 20:
                    aVar.bz((String) obj2);
                    return;
                case 21:
                    aVar.f(f.f((Number) obj2));
                    return;
                case 22:
                    aVar.bp((String) obj2);
                    return;
                case 23:
                    aVar.dw(f.h((Number) obj2));
                    return;
                case 24:
                    aVar.bn((String) obj2);
                    return;
                case 25:
                    aVar.bA((String) obj2);
                    return;
                case 26:
                    aVar.e(f.f((Number) obj2));
                    return;
                case 27:
                    aVar.bx((String) obj2);
                    return;
                case 28:
                    aVar.g(f.f((Number) obj2));
                    return;
                case 29:
                    aVar.a(f.f((Number) obj2));
                    return;
                case 30:
                    aVar.bv((String) obj2);
                    return;
                case 31:
                    aVar.by((String) obj2);
                    return;
                case ' ':
                    aVar.ca(f.h((Number) obj2));
                    return;
                case '!':
                    aVar.dy(f.h((Number) obj2));
                    return;
                case '\"':
                    aVar.bs((String) obj2);
                    return;
                case '#':
                    aVar.cc(f.h((Number) obj2));
                    return;
                case '$':
                    aVar.bm((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKProgressBarView", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKProgressBarView setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 936
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.d.b.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
