package com.tk.core.component.c;

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
public final class e implements com.tk.core.manager.a.a<c> {
    @Override // com.tk.core.manager.a.a
    public final String bM(int i) {
        switch (i) {
            case 0:
                return "enabled";
            case 1:
                return "oncut";
            case 2:
                return "maxlength";
            case 3:
                return "text";
            case 4:
                return "onLongPress";
            case 5:
                return "onpaste";
            case 6:
                return "returntype";
            case 7:
                return "onPress";
            case 8:
                return "onFocus";
            case 9:
                return com.alipay.sdk.m.p0.b.d;
            case 10:
                return "disable";
            case 11:
                return "autofocus";
            case 12:
                return "onblur";
            case 13:
                return "style";
            case 14:
                return "placeholder";
            case 15:
                return "onfocus";
            case 16:
                return "oncopy";
            case 17:
                return "nativeID";
            case 18:
                return "disallowParentInterceptTouchEvent";
            case 19:
                return "oninput";
            case 20:
                return "onkeypress";
            case 21:
                return "types";
            case 22:
                return "onsubmit";
            case 23:
                return "onchange";
            case 24:
                return "pivotPoint";
            case 25:
                return "focused";
            case 26:
                return "readonly";
            case 27:
                return "setRotateX";
            case 28:
                return "resumeAnimations";
            case 29:
                return "setTranslateX";
            case 30:
                return "setTranslateY";
            case 31:
                return "setVisibility";
            case 32:
                return "clearFocus";
            case 33:
                return "blur";
            case 34:
                return "removeSelf";
            case 35:
                return "setScaleY";
            case 36:
                return "_setVNode";
            case 37:
                return "getLocationOnScreen";
            case 38:
                return "setScaleX";
            case 39:
                return "setBackgroundColor";
            case 40:
                return "setRotate";
            case 41:
                return "removeEventListener";
            case 42:
                return "observeNextLayout";
            case 43:
                return "getOrigin";
            case 44:
                return "clear";
            case 45:
                return "layout";
            case 46:
                return "addAnimation";
            case 47:
                return "pauseAnimations";
            case 48:
                return "startViewAnimation";
            case 49:
                return "focus";
            case 50:
                return "invokeNativeFunctionWithJSONString";
            case 51:
                return "removeAnimation";
            case 52:
                return "invokeVoidNativeFunctionWithJSONString";
            case 53:
                return "getSize";
            case 54:
                return "setGradientBgColor";
            case 55:
                return "addEventListener";
            case 56:
                return "setRotateY";
            case 57:
                return "removeAllAnimation";
            default:
                return null;
        }
    }

    @Override // com.tk.core.manager.a.a
    public final String hG() {
        return "2#enabled#0,2#oncut#1,2#maxlength#2,2#text#3,2#onLongPress#4,2#onpaste#5,2#returntype#6,2#onPress#7,2#onFocus#8,2#value#9,2#disable#10,2#autofocus#11,2#onblur#12,2#style#13,2#placeholder#14,2#onfocus#15,2#oncopy#16,2#nativeID#17,2#disallowParentInterceptTouchEvent#18,2#oninput#19,2#onkeypress#20,2#types#21,2#onsubmit#22,2#onchange#23,2#pivotPoint#24,2#focused#25,2#readonly#26,4#setRotateX#27,4#resumeAnimations#28,4#setTranslateX#29,4#setTranslateY#30,4#setVisibility#31,4#clearFocus#32,4#blur#33,4#removeSelf#34,4#setScaleY#35,4#_setVNode#36,8#getLocationOnScreen#37,4#setScaleX#38,4#setBackgroundColor#39,4#setRotate#40,4#removeEventListener#41,4#observeNextLayout#42,8#getOrigin#43,4#clear#44,4#layout#45,4#addAnimation#46,4#pauseAnimations#47,4#startViewAnimation#48,4#focus#49,8#invokeNativeFunctionWithJSONString#50,4#removeAnimation#51,4#invokeVoidNativeFunctionWithJSONString#52,8#getSize#53,4#setGradientBgColor#54,4#addEventListener#55,4#setRotateY#56,4#removeAllAnimation#57";
    }

    @Override // com.tk.core.manager.a.a
    public final String hH() {
        return "1";
    }

    @Override // com.tk.core.manager.a.a
    public final /* synthetic */ c b(NativeModuleInitParams nativeModuleInitParams) {
        return aj(nativeModuleInitParams);
    }

    private static c aj(NativeModuleInitParams nativeModuleInitParams) {
        return new c(nativeModuleInitParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:146:0x022d  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean f(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 852
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.c.e.f(java.lang.String):boolean");
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.c.e.g(java.lang.String):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:98:0x016f  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int h(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.c.e.h(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.tk.core.manager.a.a
    public final boolean b(Object obj, String str, Object obj2) {
        c cVar = (c) obj;
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1871959369:
                    if (str.equals("onsubmit")) {
                        c = 22;
                        break;
                    }
                    break;
                case -1609594047:
                    if (str.equals("enabled")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1349047751:
                    if (str.equals("onFocus")) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1339721308:
                    if (str.equals("onPress")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1319495079:
                    if (str.equals("onfocus")) {
                        c = 15;
                        break;
                    }
                    break;
                case -1316741813:
                    if (str.equals("oninput")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1310661612:
                    if (str.equals("onpaste")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1221113672:
                    if (str.equals("disallowParentInterceptTouchEvent")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1072895965:
                    if (str.equals("onkeypress")) {
                        c = 20;
                        break;
                    }
                    break;
                case -1012517178:
                    if (str.equals("onblur")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1012484652:
                    if (str.equals("oncopy")) {
                        c = 16;
                        break;
                    }
                    break;
                case -866730430:
                    if (str.equals("readonly")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -691041417:
                    if (str.equals("focused")) {
                        c = 25;
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
                        c = 4;
                        break;
                    }
                    break;
                case 105886723:
                    if (str.equals("oncut")) {
                        c = 1;
                        break;
                    }
                    break;
                case 109780401:
                    if (str.equals("style")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 110844025:
                    if (str.equals("types")) {
                        c = 21;
                        break;
                    }
                    break;
                case 111972721:
                    if (str.equals(com.alipay.sdk.m.p0.b.d)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 124732746:
                    if (str.equals("maxlength")) {
                        c = 2;
                        break;
                    }
                    break;
                case 598246771:
                    if (str.equals("placeholder")) {
                        c = 14;
                        break;
                    }
                    break;
                case 1281290862:
                    if (str.equals("pivotPoint")) {
                        c = 24;
                        break;
                    }
                    break;
                case 1338160234:
                    if (str.equals("returntype")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1667607689:
                    if (str.equals("autofocus")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1671308008:
                    if (str.equals("disable")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 1952906831:
                    if (str.equals("onchange")) {
                        c = 23;
                        break;
                    }
                    break;
                case 2045685618:
                    if (str.equals("nativeID")) {
                        c = 17;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    cVar.setEnabled(((Boolean) obj2).booleanValue());
                    break;
                case 1:
                    cVar.aO((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 2:
                    cVar.dI(com.tk.core.manager.a.f.h((Number) obj2));
                    break;
                case 3:
                    cVar.setText((String) obj2);
                    break;
                case 4:
                    cVar.aH((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 5:
                    cVar.aP((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 6:
                    cVar.cf((String) obj2);
                    break;
                case 7:
                    cVar.aG((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\b':
                    cVar.aI((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\t':
                    cVar.setValue((String) obj2);
                    break;
                case '\n':
                    cVar.ao(((Boolean) obj2).booleanValue());
                    break;
                case 11:
                    cVar.ar(((Boolean) obj2).booleanValue());
                    break;
                case '\f':
                    cVar.aK((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case '\r':
                    cVar.a((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 14:
                    cVar.as((String) obj2);
                    break;
                case 15:
                    cVar.aJ((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 16:
                    cVar.aN((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 17:
                    cVar.bk((String) obj2);
                    break;
                case 18:
                    cVar.ap(((Boolean) obj2).booleanValue());
                    break;
                case 19:
                    cVar.aL((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 20:
                    cVar.aR((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 21:
                    cVar.ce((String) obj2);
                    break;
                case 22:
                    cVar.aQ((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 23:
                    cVar.aM((V8Function) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 24:
                    cVar.e((HashMap) V8ObjectUtilsQuick.getValue(obj2));
                    break;
                case 25:
                    cVar.setFocused(((Boolean) obj2).booleanValue());
                    break;
                case 26:
                    cVar.setReadOnly(((Boolean) obj2).booleanValue());
                    break;
                default:
                    if (!t.isDebug()) {
                        return false;
                    }
                    Log.e("TKInput", "call applyProp() with unsupported prop: " + str);
                    return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException("TKInput apply " + str + " error: " + e.getLocalizedMessage() + "\narg: " + com.tk.core.bridge.b.z(obj2), e);
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
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.c.e.a(java.lang.Object, java.lang.String):java.lang.Object");
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
                        c = 0;
                        break;
                    }
                    break;
                case -1974639039:
                    if (str.equals("borderRightStyle")) {
                        c = 19;
                        break;
                    }
                    break;
                case -1971292586:
                    if (str.equals("borderRightWidth")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1595747923:
                    if (str.equals("cursorColor")) {
                        c = 22;
                        break;
                    }
                    break;
                case -1576785488:
                    if (str.equals("placeholderColor")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1550943582:
                    if (str.equals("fontStyle")) {
                        c = ' ';
                        break;
                    }
                    break;
                case -1470826662:
                    if (str.equals("borderTopColor")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1455888984:
                    if (str.equals("borderTopStyle")) {
                        c = 28;
                        break;
                    }
                    break;
                case -1452542531:
                    if (str.equals("borderTopWidth")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1370537778:
                    if (str.equals("gradientBgColor")) {
                        c = 25;
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
                        c = '\'';
                        break;
                    }
                    break;
                case -1293920646:
                    if (str.equals("borderBottomStyle")) {
                        c = 18;
                        break;
                    }
                    break;
                case -1290574193:
                    if (str.equals("borderBottomWidth")) {
                        c = 29;
                        break;
                    }
                    break;
                case -1267206133:
                    if (str.equals("opacity")) {
                        c = '\f';
                        break;
                    }
                    break;
                case -1228066334:
                    if (str.equals("borderTopLeftRadius")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1224696685:
                    if (str.equals("fontFamily")) {
                        c = 6;
                        break;
                    }
                    break;
                case -1194415453:
                    if (str.equals("bottomRightRadius")) {
                        c = ')';
                        break;
                    }
                    break;
                case -1065511464:
                    if (str.equals("textAlign")) {
                        c = 11;
                        break;
                    }
                    break;
                case -903579360:
                    if (str.equals("shadow")) {
                        c = StringUtil.COMMA;
                        break;
                    }
                    break;
                case -791400086:
                    if (str.equals("maxLength")) {
                        c = JSONLexer.EOI;
                        break;
                    }
                    break;
                case -734428249:
                    if (str.equals("fontWeight")) {
                        c = 21;
                        break;
                    }
                    break;
                case -731417480:
                    if (str.equals("zIndex")) {
                        c = 15;
                        break;
                    }
                    break;
                case -242276144:
                    if (str.equals("borderLeftColor")) {
                        c = SignatureImpl.SEP;
                        break;
                    }
                    break;
                case -227338466:
                    if (str.equals("borderLeftStyle")) {
                        c = 27;
                        break;
                    }
                    break;
                case -223992013:
                    if (str.equals("borderLeftWidth")) {
                        c = 31;
                        break;
                    }
                    break;
                case 3575610:
                    if (str.equals("type")) {
                        c = '.';
                        break;
                    }
                    break;
                case 94842723:
                    if (str.equals(TypedValues.Custom.S_COLOR)) {
                        c = '%';
                        break;
                    }
                    break;
                case 333432965:
                    if (str.equals("borderTopRightRadius")) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case 365601008:
                    if (str.equals("fontSize")) {
                        c = '+';
                        break;
                    }
                    break;
                case 581268560:
                    if (str.equals("borderBottomLeftRadius")) {
                        c = StringUtil.CARRIAGE_RETURN;
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
                        c = 20;
                        break;
                    }
                    break;
                case 722830999:
                    if (str.equals("borderColor")) {
                        c = 7;
                        break;
                    }
                    break;
                case 737768677:
                    if (str.equals("borderStyle")) {
                        c = '#';
                        break;
                    }
                    break;
                case 741115130:
                    if (str.equals("borderWidth")) {
                        c = 16;
                        break;
                    }
                    break;
                case 743055051:
                    if (str.equals("boxShadow")) {
                        c = '\"';
                        break;
                    }
                    break;
                case 947486441:
                    if (str.equals("returnKeyType")) {
                        c = Typography.dollar;
                        break;
                    }
                    break;
                case 1035364227:
                    if (str.equals("placeholderFontSize")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1287124693:
                    if (str.equals(com.baidu.mobads.container.n.f.T)) {
                        c = 24;
                        break;
                    }
                    break;
                case 1292595405:
                    if (str.equals("backgroundImage")) {
                        c = '(';
                        break;
                    }
                    break;
                case 1349188574:
                    if (str.equals("borderRadius")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 1427464783:
                    if (str.equals("backgroundSize")) {
                        c = 14;
                        break;
                    }
                    break;
                case 1764836665:
                    if (str.equals("topRightRadius")) {
                        c = 17;
                        break;
                    }
                    break;
                case 1770689540:
                    if (str.equals("bottomLeftRadius")) {
                        c = 30;
                        break;
                    }
                    break;
                case 1941332754:
                    if (str.equals("visibility")) {
                        c = '\n';
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
                    cVar.bs((String) obj2);
                    return;
                case 1:
                    cVar.I(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 2:
                    cVar.f(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 3:
                    cVar.e(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 4:
                    cVar.cc((String) obj2);
                    return;
                case 5:
                    cVar.br((String) obj2);
                    return;
                case 6:
                    cVar.ak((String) obj2);
                    return;
                case 7:
                    cVar.aB((String) obj2);
                    return;
                case '\b':
                    cVar.bY(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\t':
                    cVar.dv(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\n':
                    cVar.bm((String) obj2);
                    return;
                case 11:
                    cVar.al((String) obj2);
                    return;
                case '\f':
                    cVar.h(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case '\r':
                    cVar.dy(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 14:
                    cVar.bf((String) obj2);
                    return;
                case 15:
                    cVar.A(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case 16:
                    cVar.a(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 17:
                    cVar.ca(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 18:
                    cVar.by((String) obj2);
                    return;
                case 19:
                    cVar.bx((String) obj2);
                    return;
                case 20:
                    cVar.bg((String) obj2);
                    return;
                case 21:
                    cVar.bS((String) obj2);
                    return;
                case 22:
                    cVar.cd((String) obj2);
                    return;
                case 23:
                    cVar.bo((String) obj2);
                    return;
                case 24:
                    cVar.A(obj2);
                    return;
                case 25:
                    cVar.bn((String) obj2);
                    return;
                case 26:
                    cVar.setMaxLength(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 27:
                    cVar.bv((String) obj2);
                    return;
                case 28:
                    cVar.bw((String) obj2);
                    return;
                case 29:
                    cVar.g(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case 30:
                    cVar.cb(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case 31:
                    cVar.d(com.tk.core.manager.a.f.f((Number) obj2));
                    return;
                case ' ':
                    cVar.bT((String) obj2);
                    return;
                case '!':
                    cVar.dx(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\"':
                    cVar.bA((String) obj2);
                    return;
                case '#':
                    cVar.bu((String) obj2);
                    return;
                case '$':
                    cVar.ca((String) obj2);
                    return;
                case '%':
                    cVar.aj((String) obj2);
                    return;
                case '&':
                    cVar.dw(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '\'':
                    cVar.bt((String) obj2);
                    return;
                case '(':
                    cVar.bp((String) obj2);
                    return;
                case ')':
                    cVar.cc(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '*':
                    cVar.bZ(com.tk.core.manager.a.f.h((Number) obj2));
                    return;
                case '+':
                    cVar.H(com.tk.core.manager.a.f.g((Number) obj2));
                    return;
                case ',':
                    cVar.bz((String) obj2);
                    return;
                case '-':
                    cVar.bq((String) obj2);
                    return;
                case '.':
                    cVar.bX((String) obj2);
                    return;
                default:
                    if (t.isDebug()) {
                        Log.e("TKInput", "call applyAttr() with unsupported attr: " + str);
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            throw new RuntimeException("TKInput setStyle error: " + e.getLocalizedMessage() + " \nstyleName: " + str + " styleValue: " + obj2, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0171  */
    @Override // com.tk.core.manager.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.Object r7, java.lang.String r8, java.lang.Object[] r9) {
        /*
            Method dump skipped, instructions count: 962
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.c.e.a(java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }
}
