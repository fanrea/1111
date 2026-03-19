package com.tk.core.h;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.alibaba.fastjson.parser.JSONLexer;
import com.baidu.mobads.container.util.animation.j;
import com.kwad.yoga.YogaAlign;
import com.kwad.yoga.YogaDirection;
import com.kwad.yoga.YogaDisplay;
import com.kwad.yoga.YogaEdge;
import com.kwad.yoga.YogaFlexDirection;
import com.kwad.yoga.YogaJustify;
import com.kwad.yoga.YogaOverflow;
import com.kwad.yoga.YogaPositionType;
import com.kwad.yoga.YogaUnit;
import com.kwad.yoga.YogaWrap;
import com.kwad.yoga.c;
import com.luck.picture.lib.config.CustomIntentKey;
import com.sigmob.sdk.base.mta.PointCategory;
import com.tk.core.component.e;
import com.tk.core.o.o;
import com.tk.core.o.u;
import io.netty.util.internal.StringUtil;
import kotlin.text.Typography;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {

    static class a {
        public static b aie = new b(0);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int cC(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1448970769:
                if (str.equals("row-reverse")) {
                    c = 3;
                    break;
                }
                break;
            case -1354837162:
                if (str.equals("column")) {
                    c = 0;
                    break;
                }
                break;
            case 113114:
                if (str.equals("row")) {
                    c = 2;
                    break;
                }
                break;
            case 1272730475:
                if (str.equals("column-reverse")) {
                    c = 1;
                    break;
                }
                break;
        }
        if (c == 0) {
            return YogaFlexDirection.COLUMN.ordinal();
        }
        if (c == 1) {
            return YogaFlexDirection.COLUMN_REVERSE.ordinal();
        }
        if (c == 2) {
            return YogaFlexDirection.ROW.ordinal();
        }
        if (c != 3) {
            return Integer.MAX_VALUE;
        }
        return YogaFlexDirection.ROW_REVERSE.ordinal();
    }

    private static int cD(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -1217487446) {
            if (iHashCode != -907680051) {
                if (iHashCode == 466743410 && str.equals("visible")) {
                    c = 2;
                }
            } else if (str.equals("scroll")) {
                c = 1;
            }
        } else if (str.equals("hidden")) {
            c = 0;
        }
        if (c == 0) {
            return YogaOverflow.HIDDEN.ordinal();
        }
        if (c == 1) {
            return YogaOverflow.SCROLL.ordinal();
        }
        if (c != 2) {
            return Integer.MAX_VALUE;
        }
        return YogaOverflow.VISIBLE.ordinal();
    }

    private static int cE(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -749527969) {
            if (iHashCode != 3657802) {
                if (iHashCode == 2064209110 && str.equals("no-wrap")) {
                    c = 2;
                }
            } else if (str.equals("wrap")) {
                c = 0;
            }
        } else if (str.equals("wrap-reverse")) {
            c = 1;
        }
        if (c == 0) {
            return YogaWrap.WRAP.ordinal();
        }
        if (c == 1) {
            return YogaWrap.WRAP_REVERSE.ordinal();
        }
        if (c != 2) {
            return Integer.MAX_VALUE;
        }
        return YogaWrap.NO_WRAP.ordinal();
    }

    private static int cF(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != 3317767) {
            if (iHashCode != 108511772) {
                if (iHashCode == 1946980603 && str.equals("inherit")) {
                    c = 2;
                }
            } else if (str.equals(j.e)) {
                c = 1;
            }
        } else if (str.equals(j.d)) {
            c = 0;
        }
        if (c == 0) {
            return YogaDirection.LTR.ordinal();
        }
        if (c == 1) {
            return YogaDirection.RTL.ordinal();
        }
        if (c != 2) {
            return Integer.MAX_VALUE;
        }
        return YogaDirection.INHERIT.ordinal();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int cG(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c = 1;
                    break;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    c = 0;
                    break;
                }
                break;
            case 441309761:
                if (str.equals("space-between")) {
                    c = 3;
                    break;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    c = 2;
                    break;
                }
                break;
            case 1937124468:
                if (str.equals("space-around")) {
                    c = 4;
                    break;
                }
                break;
            case 2055030478:
                if (str.equals("space-evenly")) {
                    c = 5;
                    break;
                }
                break;
        }
        if (c == 0) {
            return YogaJustify.FLEX_START.ordinal();
        }
        if (c == 1) {
            return YogaJustify.CENTER.ordinal();
        }
        if (c == 2) {
            return YogaJustify.FLEX_END.ordinal();
        }
        if (c == 3) {
            return YogaJustify.SPACE_BETWEEN.ordinal();
        }
        if (c == 4) {
            return YogaJustify.SPACE_AROUND.ordinal();
        }
        if (c != 5) {
            return Integer.MAX_VALUE;
        }
        return YogaJustify.SPACE_EVENLY.ordinal();
    }

    private static int cH(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -892481938) {
            if (iHashCode != -554435892) {
                if (iHashCode == 1728122231 && str.equals("absolute")) {
                    c = 0;
                }
            } else if (str.equals("relative")) {
                c = 1;
            }
        } else if (str.equals("static")) {
            c = 2;
        }
        if (c == 0) {
            return YogaPositionType.ABSOLUTE.ordinal();
        }
        if (c == 1) {
            return YogaPositionType.RELATIVE.ordinal();
        }
        if (c != 2) {
            return Integer.MAX_VALUE;
        }
        return YogaPositionType.RELATIVE.ordinal();
    }

    private static int cI(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        switch (str) {
        }
        return Integer.MAX_VALUE;
    }

    private static int cJ(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != 3145721) {
            if (iHashCode == 3387192 && str.equals("none")) {
                c = 1;
            }
        } else if (str.equals("flex")) {
            c = 0;
        }
        if (c == 0) {
            return YogaDisplay.FLEX.ordinal();
        }
        if (c != 1) {
            return Integer.MAX_VALUE;
        }
        return YogaDisplay.NONE.ordinal();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final int cK(String str) {
        if (str == null) {
            return Integer.MAX_VALUE;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -2142380876:
                if (str.equals("positionBottom")) {
                    c = '0';
                    break;
                }
                break;
            case -1906103182:
                if (str.equals("marginHorizontal")) {
                    c = JSONLexer.EOI;
                    break;
                }
                break;
            case -1783760955:
                if (str.equals("flexBasis")) {
                    c = 16;
                    break;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    c = '*';
                    break;
                }
                break;
            case -1384764481:
                if (str.equals("positionVertical")) {
                    c = '?';
                    break;
                }
                break;
            case -1383228885:
                if (str.equals(j.g)) {
                    c = '7';
                    break;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    c = '#';
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = 20;
                    break;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    c = 23;
                    break;
                }
                break;
            case -1063257157:
                if (str.equals("alignItems")) {
                    c = 1;
                    break;
                }
                break;
            case -1044810477:
                if (str.equals("marginAll")) {
                    c = 22;
                    break;
                }
                break;
            case -1044806579:
                if (str.equals("marginEnd")) {
                    c = 25;
                    break;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    c = 30;
                    break;
                }
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    c = 17;
                    break;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    c = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case -906066005:
                if (str.equals("maxHeight")) {
                    c = ' ';
                    break;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    c = Typography.amp;
                    break;
                }
                break;
            case -752601676:
                if (str.equals("alignContent")) {
                    c = 0;
                    break;
                }
                break;
            case -359890155:
                if (str.equals("paddingHorizontal")) {
                    c = ')';
                    break;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    c = 24;
                    break;
                }
                break;
            case -137466952:
                if (str.equals("positionAll")) {
                    c = '/';
                    break;
                }
                break;
            case -137463054:
                if (str.equals("positionEnd")) {
                    c = '1';
                    break;
                }
                break;
            case -137448596:
                if (str.equals("positionTop")) {
                    c = '6';
                    break;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    c = '\"';
                    break;
                }
                break;
            case 100571:
                if (str.equals(PointCategory.END)) {
                    c = '8';
                    break;
                }
                break;
            case 115029:
                if (str.equals(j.f)) {
                    c = Typography.less;
                    break;
                }
                break;
            case 3145721:
                if (str.equals("flex")) {
                    c = 15;
                    break;
                }
                break;
            case 3317767:
                if (str.equals(j.d)) {
                    c = '9';
                    break;
                }
                break;
            case 33812688:
                if (str.equals("positionLeft")) {
                    c = '3';
                    break;
                }
                break;
            case 34070531:
                if (str.equals("positionType")) {
                    c = com.alipay.sdk.m.n.a.h;
                    break;
                }
                break;
            case 90111952:
                if (str.equals("paddingAll")) {
                    c = '%';
                    break;
                }
                break;
            case 90115850:
                if (str.equals("paddingEnd")) {
                    c = '(';
                    break;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    c = SignatureImpl.SEP;
                    break;
                }
                break;
            case 108511772:
                if (str.equals(j.e)) {
                    c = ':';
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c = ';';
                    break;
                }
                break;
            case 113126854:
                if (str.equals("width")) {
                    c = '@';
                    break;
                }
                break;
            case 197397973:
                if (str.equals("borderAll")) {
                    c = 4;
                    break;
                }
                break;
            case 197401871:
                if (str.equals("borderEnd")) {
                    c = 6;
                    break;
                }
                break;
            case 197416329:
                if (str.equals("borderTop")) {
                    c = 11;
                    break;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    c = '\'';
                    break;
                }
                break;
            case 400381634:
                if (str.equals("maxWidth")) {
                    c = '!';
                    break;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    c = Typography.dollar;
                    break;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    c = '+';
                    break;
                }
                break;
            case 715094737:
                if (str.equals("paddingStart")) {
                    c = StringUtil.COMMA;
                    break;
                }
                break;
            case 736500048:
                if (str.equals("borderRight")) {
                    c = '\t';
                    break;
                }
                break;
            case 737745814:
                if (str.equals("borderStart")) {
                    c = '\n';
                    break;
                }
                break;
            case 747804969:
                if (str.equals("position")) {
                    c = Typography.greater;
                    break;
                }
                break;
            case 811701616:
                if (str.equals("borderHorizontal")) {
                    c = 7;
                    break;
                }
                break;
            case 904538487:
                if (str.equals("borderBottom")) {
                    c = 5;
                    break;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    c = 28;
                    break;
                }
                break;
            case 976333652:
                if (str.equals("marginStart")) {
                    c = 29;
                    break;
                }
                break;
            case 1031115618:
                if (str.equals("flexShrink")) {
                    c = 19;
                    break;
                }
                break;
            case 1053854323:
                if (str.equals("positionRight")) {
                    c = '4';
                    break;
                }
                break;
            case 1055100089:
                if (str.equals("positionStart")) {
                    c = '5';
                    break;
                }
                break;
            case 1092174483:
                if (str.equals(CustomIntentKey.EXTRA_ASPECT_RATIO)) {
                    c = 3;
                    break;
                }
                break;
            case 1343645351:
                if (str.equals("paddingVertical")) {
                    c = '.';
                    break;
                }
                break;
            case 1431421764:
                if (str.equals("marginVertical")) {
                    c = 31;
                    break;
                }
                break;
            case 1671764162:
                if (str.equals("display")) {
                    c = 14;
                    break;
                }
                break;
            case 1743739820:
                if (str.equals("flexGrow")) {
                    c = 18;
                    break;
                }
                break;
            case 1744216035:
                if (str.equals("flexWrap")) {
                    c = 'A';
                    break;
                }
                break;
            case 1767100401:
                if (str.equals("alignSelf")) {
                    c = 2;
                    break;
                }
                break;
            case 1824690771:
                if (str.equals("borderLeft")) {
                    c = '\b';
                    break;
                }
                break;
            case 1832014786:
                if (str.equals("borderVertical")) {
                    c = '\f';
                    break;
                }
                break;
            case 1860657097:
                if (str.equals("justifyContent")) {
                    c = 21;
                    break;
                }
                break;
            case 1863279149:
                if (str.equals("positionHorizontal")) {
                    c = '2';
                    break;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    c = 27;
                    break;
                }
                break;
        }
        switch (c) {
        }
        return Integer.MAX_VALUE;
    }

    private b() {
    }

    public static b rU() {
        return a.aie;
    }

    public static void a(c cVar, e eVar) {
        if (eVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 17 && eVar.getView().getResources().getConfiguration().getLayoutDirection() == 1) {
            cVar.setDirection(YogaDirection.RTL);
        }
        Drawable background = eVar.getView().getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                cVar.setPadding(YogaEdge.LEFT, r0.left);
                cVar.setPadding(YogaEdge.TOP, r0.top);
                cVar.setPadding(YogaEdge.RIGHT, r0.right);
                cVar.setPadding(YogaEdge.BOTTOM, r0.bottom);
            }
        }
    }

    public static void a(c cVar, int i, Object obj) {
        com.kwad.yoga.e eVarB = b(i, obj);
        if (eVarB == null) {
        }
        boolean z = eVarB.Gg == YogaUnit.PERCENT;
        boolean z2 = eVarB.Gg == YogaUnit.AUTO;
        float f = eVarB.value;
        if (!z && !z2) {
            switch (i) {
                case 0:
                    cVar.setAlignContent(YogaAlign.fromInt(Math.round(f)));
                    break;
                case 1:
                    cVar.setAlignItems(YogaAlign.fromInt(Math.round(f)));
                    break;
                case 2:
                    cVar.setAlignSelf(YogaAlign.fromInt(Math.round(f)));
                    break;
                case 3:
                    cVar.setAspectRatio(f);
                    break;
                case 4:
                    cVar.setBorder(YogaEdge.ALL, f);
                    break;
                case 5:
                    cVar.setBorder(YogaEdge.BOTTOM, f);
                    break;
                case 6:
                    cVar.setBorder(YogaEdge.END, f);
                    break;
                case 7:
                    cVar.setBorder(YogaEdge.HORIZONTAL, f);
                    break;
                case 8:
                    cVar.setBorder(YogaEdge.LEFT, f);
                    break;
                case 9:
                    cVar.setBorder(YogaEdge.RIGHT, f);
                    break;
                case 10:
                    cVar.setBorder(YogaEdge.START, f);
                    break;
                case 11:
                    cVar.setBorder(YogaEdge.TOP, f);
                    break;
                case 12:
                    cVar.setBorder(YogaEdge.VERTICAL, f);
                    break;
                case 13:
                    cVar.setDirection(YogaDirection.fromInt(Math.round(f)));
                    break;
                case 14:
                    cVar.setDisplay(YogaDisplay.fromInt(Math.round(f)));
                    break;
                case 15:
                    cVar.setFlex(f);
                    break;
                case 16:
                    cVar.setFlexBasis(f);
                    break;
                case 17:
                    cVar.setFlexDirection(YogaFlexDirection.fromInt(Math.round(f)));
                    break;
                case 18:
                    cVar.setFlexGrow(f);
                    break;
                case 19:
                    cVar.setFlexShrink(f);
                    break;
                case 20:
                    cVar.setHeight(f);
                    break;
                case 21:
                    cVar.setJustifyContent(YogaJustify.fromInt(Math.round(f)));
                    break;
                case 22:
                    cVar.setMargin(YogaEdge.ALL, f);
                    break;
                case 23:
                    cVar.setMargin(YogaEdge.BOTTOM, f);
                    break;
                case 24:
                    cVar.setMargin(YogaEdge.END, f);
                    break;
                case 25:
                    cVar.setMargin(YogaEdge.HORIZONTAL, f);
                    break;
                case 26:
                    cVar.setMargin(YogaEdge.LEFT, f);
                    break;
                case 27:
                    cVar.setMargin(YogaEdge.RIGHT, f);
                    break;
                case 28:
                    cVar.setMargin(YogaEdge.START, f);
                    break;
                case 29:
                    cVar.setMargin(YogaEdge.TOP, f);
                    break;
                case 30:
                    cVar.setMargin(YogaEdge.VERTICAL, f);
                    break;
                case 31:
                    cVar.setMaxHeight(f);
                    break;
                case 32:
                    cVar.setMaxWidth(f);
                    break;
                case 33:
                    cVar.setMinHeight(f);
                    break;
                case 34:
                    cVar.setMinWidth(f);
                    break;
                case 36:
                    cVar.setPadding(YogaEdge.ALL, f);
                    break;
                case 37:
                    cVar.setPadding(YogaEdge.BOTTOM, f);
                    break;
                case 38:
                    cVar.setPadding(YogaEdge.END, f);
                    break;
                case 39:
                    cVar.setPadding(YogaEdge.HORIZONTAL, f);
                    break;
                case 40:
                    cVar.setPadding(YogaEdge.LEFT, f);
                    break;
                case 41:
                    cVar.setPadding(YogaEdge.RIGHT, f);
                    break;
                case 42:
                    cVar.setPadding(YogaEdge.START, f);
                    break;
                case 43:
                    cVar.setPadding(YogaEdge.TOP, f);
                    break;
                case 44:
                    cVar.setPadding(YogaEdge.VERTICAL, f);
                    break;
                case 45:
                    cVar.setPosition(YogaEdge.ALL, f);
                    break;
                case 46:
                    cVar.setPosition(YogaEdge.BOTTOM, f);
                    break;
                case 47:
                    cVar.setPosition(YogaEdge.END, f);
                    break;
                case 48:
                    cVar.setPosition(YogaEdge.HORIZONTAL, f);
                    break;
                case 49:
                    cVar.setPosition(YogaEdge.LEFT, f);
                    break;
                case 50:
                    cVar.setPosition(YogaEdge.RIGHT, f);
                    break;
                case 51:
                    cVar.setPosition(YogaEdge.START, f);
                    break;
                case 52:
                    cVar.setPosition(YogaEdge.TOP, f);
                    break;
                case 53:
                    cVar.setPositionType(YogaPositionType.fromInt(Math.round(f)));
                    break;
                case 54:
                    cVar.setPosition(YogaEdge.VERTICAL, f);
                    break;
                case 55:
                    cVar.setWidth(f);
                    break;
                case 56:
                    cVar.setWrap(YogaWrap.fromInt(Math.round(f)));
                    break;
            }
        }
        if (z2) {
            if (i == 16) {
                cVar.setFlexBasisAuto();
            } else if (i == 20) {
                cVar.setHeightAuto();
            } else if (i != 55) {
                switch (i) {
                    case 22:
                        cVar.setMarginAuto(YogaEdge.ALL);
                        break;
                    case 23:
                        cVar.setMarginAuto(YogaEdge.BOTTOM);
                        break;
                    case 24:
                        cVar.setMarginAuto(YogaEdge.END);
                        break;
                    case 25:
                        cVar.setMarginAuto(YogaEdge.HORIZONTAL);
                        break;
                    case 26:
                        cVar.setMarginAuto(YogaEdge.LEFT);
                        break;
                    case 27:
                        cVar.setMarginAuto(YogaEdge.RIGHT);
                        break;
                    case 28:
                        cVar.setMarginAuto(YogaEdge.START);
                        break;
                    case 29:
                        cVar.setMarginAuto(YogaEdge.TOP);
                        break;
                    case 30:
                        cVar.setMarginAuto(YogaEdge.VERTICAL);
                        break;
                }
            } else {
                cVar.setWidthAuto();
            }
        }
        if (z) {
            switch (i) {
                case 16:
                    cVar.setFlexBasisPercent(f);
                    break;
                case 20:
                    cVar.setHeightPercent(f);
                    break;
                case 22:
                    cVar.setMarginPercent(YogaEdge.ALL, f);
                    break;
                case 23:
                    cVar.setMarginPercent(YogaEdge.BOTTOM, f);
                    break;
                case 24:
                    cVar.setMarginPercent(YogaEdge.END, f);
                    break;
                case 25:
                    cVar.setMarginPercent(YogaEdge.HORIZONTAL, f);
                    break;
                case 26:
                    cVar.setMarginPercent(YogaEdge.LEFT, f);
                    break;
                case 27:
                    cVar.setMarginPercent(YogaEdge.RIGHT, f);
                    break;
                case 28:
                    cVar.setMarginPercent(YogaEdge.START, f);
                    break;
                case 29:
                    cVar.setMarginPercent(YogaEdge.TOP, f);
                    break;
                case 30:
                    cVar.setMarginPercent(YogaEdge.VERTICAL, f);
                    break;
                case 31:
                    cVar.setMaxHeightPercent(f);
                    break;
                case 32:
                    cVar.setMaxWidthPercent(f);
                    break;
                case 33:
                    cVar.setMinHeightPercent(f);
                    break;
                case 34:
                    cVar.setMinWidthPercent(f);
                    break;
                case 36:
                    cVar.setPaddingPercent(YogaEdge.ALL, f);
                    break;
                case 37:
                    cVar.setPaddingPercent(YogaEdge.BOTTOM, f);
                    break;
                case 38:
                    cVar.setPaddingPercent(YogaEdge.END, f);
                    break;
                case 39:
                    cVar.setPaddingPercent(YogaEdge.HORIZONTAL, f);
                    break;
                case 40:
                    cVar.setPaddingPercent(YogaEdge.LEFT, f);
                    break;
                case 41:
                    cVar.setPaddingPercent(YogaEdge.RIGHT, f);
                    break;
                case 42:
                    cVar.setPaddingPercent(YogaEdge.START, f);
                    break;
                case 43:
                    cVar.setPaddingPercent(YogaEdge.TOP, f);
                    break;
                case 44:
                    cVar.setPaddingPercent(YogaEdge.VERTICAL, f);
                    break;
                case 45:
                    cVar.setPositionPercent(YogaEdge.ALL, f);
                    break;
                case 46:
                    cVar.setPositionPercent(YogaEdge.BOTTOM, f);
                    break;
                case 47:
                    cVar.setPositionPercent(YogaEdge.END, f);
                    break;
                case 48:
                    cVar.setPositionPercent(YogaEdge.HORIZONTAL, f);
                    break;
                case 49:
                    cVar.setPositionPercent(YogaEdge.LEFT, f);
                    break;
                case 50:
                    cVar.setPositionPercent(YogaEdge.RIGHT, f);
                    break;
                case 51:
                    cVar.setPositionPercent(YogaEdge.START, f);
                    break;
                case 52:
                    cVar.setPositionPercent(YogaEdge.TOP, f);
                    break;
                case 54:
                    cVar.setPositionPercent(YogaEdge.VERTICAL, f);
                    break;
                case 55:
                    cVar.setWidthPercent(f);
                    break;
            }
        }
    }

    public static com.kwad.yoga.e b(int i, Object obj) {
        String str;
        int length;
        if (obj instanceof Number) {
            if (3 == i) {
                return new com.kwad.yoga.e(((Number) obj).floatValue(), YogaUnit.POINT);
            }
            return new com.kwad.yoga.e(o.P(((Number) obj).floatValue()), YogaUnit.POINT);
        }
        if (!(obj instanceof String) || (length = (str = (String) obj).length()) == 0) {
            return null;
        }
        int i2 = length - 1;
        char cCharAt = str.charAt(i2);
        if (cCharAt == '%') {
            if (length > 1) {
                try {
                    return new com.kwad.yoga.e(Float.parseFloat(str.substring(0, i2)), YogaUnit.PERCENT);
                } catch (Throwable th) {
                    com.tk.core.exception.a.b(th, -1);
                }
            }
            return null;
        }
        if (cCharAt != 'o') {
            if (cCharAt != 'x') {
                if (cCharAt >= '0' && cCharAt <= '9') {
                    try {
                        return new com.kwad.yoga.e(o.P(Float.parseFloat(str)), YogaUnit.POINT);
                    } catch (Throwable th2) {
                        com.tk.core.exception.a.b(th2, -1);
                        return null;
                    }
                }
            } else if (length > 2) {
                if (str.charAt(length - 2) == 'p') {
                    try {
                        return new com.kwad.yoga.e(u.S(Float.parseFloat(str.substring(0, r2))), YogaUnit.POINT);
                    } catch (Throwable th3) {
                        com.tk.core.exception.a.b(th3, -1);
                        return null;
                    }
                }
            }
        } else if ("auto".equals(str)) {
            return new com.kwad.yoga.e(0.0f, YogaUnit.AUTO);
        }
        if ("unset".equals(obj)) {
            return new com.kwad.yoga.e(Float.NaN, YogaUnit.POINT);
        }
        rU();
        int iC = c(i, obj);
        if (iC == Integer.MAX_VALUE) {
            return null;
        }
        return new com.kwad.yoga.e(iC, YogaUnit.POINT);
    }

    public static int cL(String str) {
        return cK(str);
    }

    private static int c(int i, Object obj) {
        if (i == 0 || i == 1 || i == 2) {
            return cI((String) obj);
        }
        if (i == 13) {
            return cF((String) obj);
        }
        if (i == 14) {
            return cJ((String) obj);
        }
        if (i == 17) {
            return cC((String) obj);
        }
        if (i == 21) {
            return cG((String) obj);
        }
        if (i == 35) {
            return cD((String) obj);
        }
        if (i == 53) {
            return cH((String) obj);
        }
        if (i != 56) {
            return Integer.MAX_VALUE;
        }
        return cE((String) obj);
    }
}
