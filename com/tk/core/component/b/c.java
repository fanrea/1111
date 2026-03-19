package com.tk.core.component.b;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.mobads.container.n.f;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c implements com.tk.core.manager.a.a<b> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "onLongPress";
            case 1:
                return "fontFace";
            case 2:
                return "nativeID";
            case 3:
                return "disable";
            case 4:
                return "style";
            case 5:
                return "onPress";
            case 6:
                return "pressed";
            case 7:
                return "disallowParentInterceptTouchEvent";
            case 8:
                return "pivotPoint";
            case 9:
                return "enabled";
            case 10:
                return "disabled";
            case 11:
                return "text";
            case 12:
                return "invokeNativeFunctionWithJSONString";
            case 13:
                return "startViewAnimation";
            case 14:
                return "removeEventListener";
            case 15:
                return "getSize";
            case 16:
                return "removeAllAnimation";
            case 17:
                return "setGradientBgColor";
            case 18:
                return "resumeAnimations";
            case 19:
                return "setScaleX";
            case 20:
                return "setScaleY";
            case 21:
                return "setRotateY";
            case 22:
                return "observeNextLayout";
            case 23:
                return "setVisibility";
            case 24:
                return "setText";
            case 25:
                return "pauseAnimations";
            case 26:
                return "setRotateX";
            case 27:
                return "removeSelf";
            case 28:
                return "invokeVoidNativeFunctionWithJSONString";
            case 29:
                return "layout";
            case 30:
                return "getLocationOnScreen";
            case 31:
                return "setTranslateX";
            case 32:
                return "setRotate";
            case 33:
                return "addAnimation";
            case 34:
                return "setTranslateY";
            case 35:
                return "removeAnimation";
            case 36:
                return "addEventListener";
            case 37:
                return "_setVNode";
            case 38:
                return "getOrigin";
            case 39:
                return "setBackgroundColor";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#onLongPress#0,2#fontFace#1,2#nativeID#2,2#disable#3,2#style#4,2#onPress#5,2#pressed#6,2#disallowParentInterceptTouchEvent#7,2#pivotPoint#8,2#enabled#9,2#disabled#10,2#text#11,8#invokeNativeFunctionWithJSONString#12,4#startViewAnimation#13,4#removeEventListener#14,8#getSize#15,4#removeAllAnimation#16,4#setGradientBgColor#17,4#resumeAnimations#18,4#setScaleX#19,4#setScaleY#20,4#setRotateY#21,4#observeNextLayout#22,4#setVisibility#23,4#setText#24,4#pauseAnimations#25,4#setRotateX#26,4#removeSelf#27,4#invokeVoidNativeFunctionWithJSONString#28,4#layout#29,8#getLocationOnScreen#30,4#setTranslateX#31,4#setRotate#32,4#addAnimation#33,4#setTranslateY#34,4#removeAnimation#35,4#addEventListener#36,4#_setVNode#37,8#getOrigin#38,4#setBackgroundColor#39";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ b b(NativeModuleInitParams nativeModuleInitParams) {
        return ai(nativeModuleInitParams);
    }

    private static b ai(NativeModuleInitParams nativeModuleInitParams) {
        return new b(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:137:0x020a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 798
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.b.c.f(java.lang.String):boolean");
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
                case -1221113672: goto L6a;
                case -318264286: goto L60;
                case 3556653: goto L55;
                case 83417096: goto L4b;
                case 109780401: goto L41;
                case 270940796: goto L36;
                case 365205324: goto L2c;
                case 1281290862: goto L21;
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
            r4 = 2
            goto L8a
        L16:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 3
            goto L8a
        L21:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 8
            goto L8a
        L2c:
            java.lang.String r0 = "fontFace"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 1
            goto L8a
        L36:
            java.lang.String r0 = "disabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 10
            goto L8a
        L41:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 4
            goto L8a
        L4b:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 0
            goto L8a
        L55:
            java.lang.String r0 = "text"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 11
            goto L8a
        L60:
            java.lang.String r0 = "pressed"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 6
            goto L8a
        L6a:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 7
            goto L8a
        L74:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 5
            goto L8a
        L7e:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L89
            r4 = 9
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.b.c.g(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.b.c.h(java.lang.String):int");
    }

    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        b bVar = (b) obj;
        try {
            switch (str) {
                case "onLongPress":
                    bVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "fontFace":
                    bVar.i((Map<String, String>) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "nativeID":
                    bVar.bk((String) obj2);
                    break;
                case "disable":
                    bVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case "style":
                    bVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "onPress":
                    bVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "pressed":
                    bVar.l((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "disallowParentInterceptTouchEvent":
                    bVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case "pivotPoint":
                    bVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "enabled":
                    bVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case "disabled":
                    bVar.m((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case "text":
                    bVar.setText((String) obj2);
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKButton", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKButton apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.b.c.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 1;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -1822170841:
                    if (str.equals("lineClamp")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1550943582:
                    if (str.equals("fontStyle")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1547288966:
                    if (str.equals("textLineClamp")) {
                        c = '#';
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = '(';
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 22;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 25;
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
                        c = 4;
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = 28;
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
                        c = 0;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = 30;
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = 27;
                        break;
                    }
                    break;
                case -1224696685:
                    if (str.equals("fontFamily")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1065511464:
                    if (str.equals("textAlign")) {
                        c = 7;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -734428249:
                    if (str.equals("fontWeight")) {
                        c = 11;
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
                        c = '\f';
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = '+';
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = '!';
                        break;
                    }
                    break;
                case 94842723:
                    if (str.equals(TypedValues.Custom.S_COLOR)) {
                        c = 29;
                        break;
                    }
                    break;
                case 261414991:
                    if (str.equals("textOverflow")) {
                        c = 5;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = ')';
                        break;
                    }
                    break;
                case 365601008:
                    if (str.equals("fontSize")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 14;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = 15;
                        break;
                    }
                    break;
                case 640435319:
                    if (str.equals("backgroundPosition")) {
                        c = '%';
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
                        c = 21;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 17;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = 31;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(f.T)) {
                        c = 16;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = 20;
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = '\'';
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
                        c = Typography.amp;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = '*';
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = 24;
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
                    bVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 1:
                    bVar.bx((String) obj2);
                    return;
                case 2:
                    bVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 3:
                    bVar.bs((String) obj2);
                    return;
                case 4:
                    bVar.bo((String) obj2);
                    return;
                case 5:
                    bVar.bU((String) obj2);
                    return;
                case 6:
                    bVar.aB((String) obj2);
                    return;
                case 7:
                    bVar.al((String) obj2);
                    return;
                case '\b':
                    bVar.by((String) obj2);
                    return;
                case '\t':
                    bVar.bf((String) obj2);
                    return;
                case '\n':
                    bVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 11:
                    bVar.bS((String) obj2);
                    return;
                case '\f':
                    bVar.bq((String) obj2);
                    return;
                case '\r':
                    bVar.dE(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 14:
                    bVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 15:
                    bVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 16:
                    bVar.A(obj2);
                    return;
                case 17:
                    bVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 18:
                    bVar.bT((String) obj2);
                    return;
                case 19:
                    bVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 20:
                    bVar.bp((String) obj2);
                    return;
                case 21:
                    bVar.bu((String) obj2);
                    return;
                case 22:
                    bVar.bw((String) obj2);
                    return;
                case 23:
                    bVar.bn((String) obj2);
                    return;
                case 24:
                    bVar.bm((String) obj2);
                    return;
                case 25:
                    bVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 26:
                    bVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 27:
                    bVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 28:
                    bVar.bt((String) obj2);
                    return;
                case 29:
                    bVar.aj((String) obj2);
                    return;
                case 30:
                    bVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 31:
                    bVar.bA((String) obj2);
                    return;
                case ' ':
                    bVar.bz((String) obj2);
                    return;
                case '!':
                    bVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\"':
                    bVar.dF(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '#':
                    bVar.dD(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '$':
                    bVar.ak((String) obj2);
                    return;
                case '%':
                    bVar.bg((String) obj2);
                    return;
                case '&':
                    bVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\'':
                    bVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '(':
                    bVar.br((String) obj2);
                    return;
                case ')':
                    bVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '*':
                    bVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '+':
                    bVar.bv((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKButton", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKButton setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.b.c.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
