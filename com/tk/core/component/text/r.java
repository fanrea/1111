package com.tk.core.component.text;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.fastjson.parser.JSONLexer;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.o.t;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import io.netty.util.internal.StringUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class r implements com.tk.core.manager.a.a<q> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "fontFace";
            case 1:
                return "pivotPoint";
            case 2:
                return "adjustFontSizeWithSystemChange";
            case 3:
                return "text";
            case 4:
                return "enabled";
            case 5:
                return "richText";
            case 6:
                return "nativeID";
            case 7:
                return "style";
            case 8:
                return "onPress";
            case 9:
                return "disable";
            case 10:
                return "disallowParentInterceptTouchEvent";
            case 11:
                return "onLongPress";
            case 12:
                return "formattedText";
            case 13:
                return "textCopyEnable";
            case 14:
                return "measureText";
            case 15:
                return "setGradientTextColor";
            case 16:
                return "setSpan";
            case 17:
                return "setBackgroundColor";
            case 18:
                return "resumeAnimations";
            case 19:
                return "setScaleY";
            case 20:
                return "removeEventListener";
            case 21:
                return "startViewAnimation";
            case 22:
                return "getOrigin";
            case 23:
                return "invokeNativeFunctionWithJSONString";
            case 24:
                return "setRotateY";
            case 25:
                return "getLocationOnScreen";
            case 26:
                return "setSpanText";
            case 27:
                return "setGradientBgColor";
            case 28:
                return "invokeVoidNativeFunctionWithJSONString";
            case 29:
                return "measureForText";
            case 30:
                return "layout";
            case 31:
                return "observeNextLayout";
            case 32:
                return "setScaleX";
            case 33:
                return "getSize";
            case 34:
                return "removeSelf";
            case 35:
                return "setText";
            case 36:
                return "setTranslateX";
            case 37:
                return "_setVNode";
            case 38:
                return "addAnimation";
            case 39:
                return "pauseAnimations";
            case 40:
                return "addEventListener";
            case 41:
                return "setRotateX";
            case 42:
                return "setVisibility";
            case 43:
                return "setRotate";
            case 44:
                return "setTranslateY";
            case 45:
                return "removeAllAnimation";
            case 46:
                return "removeAnimation";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#fontFace#0,2#pivotPoint#1,2#adjustFontSizeWithSystemChange#2,2#text#3,2#enabled#4,2#richText#5,2#nativeID#6,2#style#7,2#onPress#8,2#disable#9,2#disallowParentInterceptTouchEvent#10,2#onLongPress#11,2#formattedText#12,2#textCopyEnable#13,8#measureText#14,4#setGradientTextColor#15,4#setSpan#16,4#setBackgroundColor#17,4#resumeAnimations#18,4#setScaleY#19,4#removeEventListener#20,4#startViewAnimation#21,8#getOrigin#22,8#invokeNativeFunctionWithJSONString#23,4#setRotateY#24,8#getLocationOnScreen#25,4#setSpanText#26,4#setGradientBgColor#27,4#invokeVoidNativeFunctionWithJSONString#28,8#measureForText#29,4#layout#30,4#observeNextLayout#31,4#setScaleX#32,8#getSize#33,4#removeSelf#34,4#setText#35,4#setTranslateX#36,4#_setVNode#37,4#addAnimation#38,4#pauseAnimations#39,4#addEventListener#40,4#setRotateX#41,4#setVisibility#42,4#setRotate#43,4#setTranslateY#44,4#removeAllAnimation#45,4#removeAnimation#46";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ q b(NativeModuleInitParams nativeModuleInitParams) {
        return aq(nativeModuleInitParams);
    }

    private static q aq(NativeModuleInitParams nativeModuleInitParams) {
        return new q(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:173:0x029a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 1014
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.r.f(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1  */
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
                case -1717326839: goto L96;
                case -1609594047: goto L8c;
                case -1551543255: goto L82;
                case -1387535771: goto L77;
                case -1339721308: goto L6c;
                case -1221113672: goto L61;
                case 3556653: goto L57;
                case 83417096: goto L4c;
                case 109780401: goto L42;
                case 365205324: goto L38;
                case 426656356: goto L2d;
                case 1281290862: goto L22;
                case 1671308008: goto L16;
                case 2045685618: goto Lb;
                default: goto L9;
            }
        L9:
            goto La1
        Lb:
            java.lang.String r0 = "nativeID"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 6
            goto La2
        L16:
            java.lang.String r0 = "disable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 9
            goto La2
        L22:
            java.lang.String r0 = "pivotPoint"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 1
            goto La2
        L2d:
            java.lang.String r0 = "adjustFontSizeWithSystemChange"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 2
            goto La2
        L38:
            java.lang.String r0 = "fontFace"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 0
            goto La2
        L42:
            java.lang.String r0 = "style"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 7
            goto La2
        L4c:
            java.lang.String r0 = "onLongPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 11
            goto La2
        L57:
            java.lang.String r0 = "text"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 3
            goto La2
        L61:
            java.lang.String r0 = "disallowParentInterceptTouchEvent"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 10
            goto La2
        L6c:
            java.lang.String r0 = "onPress"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 8
            goto La2
        L77:
            java.lang.String r0 = "textCopyEnable"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 13
            goto La2
        L82:
            java.lang.String r0 = "richText"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 5
            goto La2
        L8c:
            java.lang.String r0 = "enabled"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 4
            goto La2
        L96:
            java.lang.String r0 = "formattedText"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto La1
            r4 = 12
            goto La2
        La1:
            r4 = -1
        La2:
            switch(r4) {
                case 0: goto La6;
                case 1: goto La6;
                case 2: goto La6;
                case 3: goto La6;
                case 4: goto La6;
                case 5: goto La6;
                case 6: goto La6;
                case 7: goto La6;
                case 8: goto La6;
                case 9: goto La6;
                case 10: goto La6;
                case 11: goto La6;
                case 12: goto La6;
                case 13: goto La6;
                default: goto La5;
            }
        La5:
            return r2
        La6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.r.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0187  */
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.r.h(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        q qVar = (q) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1717326839:
                    if (str.equals("formattedText")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1609594047:
                    if (str.equals("enabled")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1551543255:
                    if (str.equals("richText")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1387535771:
                    if (str.equals("textCopyEnable")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case -1339721308:
                    if (str.equals("onPress")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1221113672:
                    if (str.equals("disallowParentInterceptTouchEvent")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 3556653:
                    if (str.equals("text")) {
                        c = 3;
                        break;
                    }
                    break;
                case 83417096:
                    if (str.equals("onLongPress")) {
                        c = 11;
                        break;
                    }
                    break;
                case 109780401:
                    if (str.equals("style")) {
                        c = 7;
                        break;
                    }
                    break;
                case 365205324:
                    if (str.equals("fontFace")) {
                        c = 0;
                        break;
                    }
                    break;
                case 426656356:
                    if (str.equals("adjustFontSizeWithSystemChange")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1281290862:
                    if (str.equals("pivotPoint")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1671308008:
                    if (str.equals("disable")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 2045685618:
                    if (str.equals("nativeID")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    qVar.i((Map<String, String>) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 1:
                    qVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 2:
                    qVar.ax(((Boolean) obj2).booleanValue());
                    break;
                case 3:
                    qVar.setText((String) obj2);
                    break;
                case 4:
                    qVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case 5:
                    qVar.H(V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 6:
                    qVar.bk((String) obj2);
                    break;
                case 7:
                    qVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\b':
                    qVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\t':
                    qVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case '\n':
                    qVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case 11:
                    qVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\f':
                    qVar.cr((String) obj2);
                    break;
                case '\r':
                    qVar.ay(((Boolean) obj2).booleanValue());
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKText", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKText apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.r.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    @Override // com.tk.core.manager.a.a
    public final void a(Object obj, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            c(obj, entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void c(Object obj, String str, Object obj2) {
        q qVar = (q) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1989576717:
                    if (str.equals("borderRightColor")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = '5';
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = StringUtil.COMMA;
                        break;
                    }
                    break;
                case -1822170841:
                    if (str.equals("lineClamp")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1713121005:
                    if (str.equals("textLetterSpace")) {
                        c = 31;
                        break;
                    }
                    break;
                case -1550943582:
                    if (str.equals("fontStyle")) {
                        c = '0';
                        break;
                    }
                    break;
                case -1547288966:
                    if (str.equals("textLineClamp")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1532393787:
                    if (str.equals("textLineSpace")) {
                        c = 24;
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 17;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = '.';
                        break;
                    }
                    break;
                case -1332194002:
                    if (str.equals("background")) {
                        c = '6';
                        break;
                    }
                    break;
                case -1308858324:
                    if (str.equals("borderBottomColor")) {
                        c = SignatureImpl.SEP;
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = '7';
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 22;
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
                        c = 21;
                        break;
                    }
                    break;
                case -1224696685:
                    if (str.equals("fontFamily")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case -1085484461:
                    if (str.equals("textLineHeightClamp")) {
                        c = 14;
                        break;
                    }
                    break;
                case -1065511464:
                    if (str.equals("textAlign")) {
                        c = 20;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = '4';
                        break;
                    }
                    break;
                case -879295043:
                    if (str.equals("textDecoration")) {
                        c = '/';
                        break;
                    }
                    break;
                case -734428249:
                    if (str.equals("fontWeight")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = '\n';
                        break;
                    }
                    break;
                case -584404152:
                    if (str.equals("textLineHeight")) {
                        c = 23;
                        break;
                    }
                    break;
                case -515807685:
                    if (str.equals("lineHeight")) {
                        c = 2;
                        break;
                    }
                    break;
                case -324669986:
                    if (str.equals("minimumTextScaleFactor")) {
                        c = '\"';
                        break;
                    }
                    break;
                case -293573402:
                    if (str.equals("gradientTextColor")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -292817662:
                    if (str.equals("textVerticalAlign")) {
                        c = '1';
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
                        c = 29;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = ')';
                        break;
                    }
                    break;
                case 94842723:
                    if (str.equals(TypedValues.Custom.S_COLOR)) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case 261414991:
                    if (str.equals("textOverflow")) {
                        c = 6;
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = '!';
                        break;
                    }
                    break;
                case 365601008:
                    if (str.equals("fontSize")) {
                        c = 4;
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = 0;
                        break;
                    }
                    break;
                case 588239831:
                    if (str.equals("borderBottomRightRadius")) {
                        c = 30;
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
                        c = 27;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = 25;
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = '3';
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
                        c = '\t';
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = '%';
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = '2';
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1840272557:
                    if (str.equals("textShadow")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = '+';
                        break;
                    }
                    break;
                case 2020113146:
                    if (str.equals("includeFontPadding")) {
                        c = '(';
                        break;
                    }
                    break;
                case 2111078717:
                    if (str.equals("letterSpacing")) {
                        c = 18;
                        break;
                    }
                    break;
                case 2143243950:
                    if (str.equals("topLeftRadius")) {
                        c = '*';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    qVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 1:
                    qVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 2:
                    qVar.d((Number) obj2);
                    return;
                case 3:
                    qVar.bf((String) obj2);
                    return;
                case 4:
                    qVar.dF(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 5:
                    qVar.cu((String) obj2);
                    return;
                case 6:
                    qVar.bU((String) obj2);
                    return;
                case 7:
                    qVar.br((String) obj2);
                    return;
                case '\b':
                    qVar.bS((String) obj2);
                    return;
                case '\t':
                    qVar.bp((String) obj2);
                    return;
                case '\n':
                    qVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 11:
                    qVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\f':
                    qVar.cv((String) obj2);
                    return;
                case '\r':
                    qVar.bg((String) obj2);
                    return;
                case 14:
                    qVar.c((Number) obj2);
                    return;
                case 15:
                    qVar.ak((String) obj2);
                    return;
                case 16:
                    qVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 17:
                    qVar.bw((String) obj2);
                    return;
                case 18:
                    qVar.setLetterSpacing(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 19:
                    qVar.dD(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 20:
                    qVar.al((String) obj2);
                    return;
                case 21:
                    qVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 22:
                    qVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 23:
                    qVar.b((Number) obj2);
                    return;
                case 24:
                    qVar.a((Number) obj2);
                    return;
                case 25:
                    qVar.bu((String) obj2);
                    return;
                case 26:
                    qVar.aj((String) obj2);
                    return;
                case 27:
                    qVar.aB((String) obj2);
                    return;
                case 28:
                    qVar.dE(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 29:
                    qVar.bv((String) obj2);
                    return;
                case 30:
                    qVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 31:
                    qVar.e((Number) obj2);
                    return;
                case ' ':
                    qVar.bs((String) obj2);
                    return;
                case '!':
                    qVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    qVar.O(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case '#':
                    qVar.A(obj2);
                    return;
                case '$':
                    qVar.bq((String) obj2);
                    return;
                case '%':
                    qVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '&':
                    qVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\'':
                    qVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '(':
                    qVar.setIncludeFontPadding(((Boolean) obj2).booleanValue());
                    return;
                case ')':
                    qVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '*':
                    qVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '+':
                    qVar.bm((String) obj2);
                    return;
                case ',':
                    qVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '-':
                    qVar.bt((String) obj2);
                    return;
                case '.':
                    qVar.bn((String) obj2);
                    return;
                case '/':
                    qVar.ct((String) obj2);
                    return;
                case '0':
                    qVar.bT((String) obj2);
                    return;
                case '1':
                    qVar.cs((String) obj2);
                    return;
                case '2':
                    qVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '3':
                    qVar.bA((String) obj2);
                    return;
                case '4':
                    qVar.bz((String) obj2);
                    return;
                case '5':
                    qVar.bx((String) obj2);
                    return;
                case '6':
                    qVar.bo((String) obj2);
                    return;
                case '7':
                    qVar.by((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKText", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKText setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:104:0x018a  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 1092
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.r.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
