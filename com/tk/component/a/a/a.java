package com.tk.component.a.a;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.baidu.mobads.container.util.animation.j;
import com.tk.core.o.o;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    public static int cE(int i) {
        if (i != 1) {
            return i != 2 ? 0 : 2;
        }
        return 1;
    }

    public static void a(RectF rectF, Map map) {
        float fFloatValue = map.containsKey("x") ? ((Number) map.get("x")).floatValue() : 0.0f;
        float fFloatValue2 = map.containsKey("y") ? ((Number) map.get("y")).floatValue() : 0.0f;
        float fFloatValue3 = map.containsKey("width") ? ((Number) map.get("width")).floatValue() + fFloatValue : 0.0f;
        float fFloatValue4 = map.containsKey("height") ? fFloatValue2 + ((Number) map.get("height")).floatValue() : 0.0f;
        rectF.left = o.P(fFloatValue);
        rectF.top = o.P(fFloatValue2);
        rectF.right = o.P(fFloatValue3);
        rectF.bottom = o.P(fFloatValue4);
    }

    public static void a(Rect rect, Map map) {
        float fFloatValue = map.containsKey("x") ? ((Number) map.get("x")).floatValue() : 0.0f;
        float fFloatValue2 = map.containsKey("y") ? ((Number) map.get("y")).floatValue() : 0.0f;
        float fFloatValue3 = map.containsKey("width") ? ((Number) map.get("width")).floatValue() + fFloatValue : 0.0f;
        float fFloatValue4 = map.containsKey("height") ? fFloatValue2 + ((Number) map.get("height")).floatValue() : 0.0f;
        rect.left = o.P(fFloatValue);
        rect.top = o.P(fFloatValue2);
        rect.right = o.P(fFloatValue3);
        rect.bottom = o.P(fFloatValue4);
    }

    public static Paint.Style cF(int i) {
        if (i != 1) {
            return Paint.Style.FILL;
        }
        return Paint.Style.STROKE;
    }

    public static Paint.Cap cG(int i) {
        if (i == 1) {
            return Paint.Cap.ROUND;
        }
        if (i != 2) {
            return Paint.Cap.BUTT;
        }
        return Paint.Cap.SQUARE;
    }

    public static Paint.Join cH(int i) {
        if (i == 1) {
            return Paint.Join.BEVEL;
        }
        if (i != 2) {
            return Paint.Join.MITER;
        }
        return Paint.Join.ROUND;
    }

    public static PorterDuff.Mode cI(int i) {
        switch (i) {
            case 0:
                return PorterDuff.Mode.CLEAR;
            case 1:
                return PorterDuff.Mode.SRC;
            case 2:
                return PorterDuff.Mode.DST;
            case 3:
                return PorterDuff.Mode.SRC_OVER;
            case 4:
                return PorterDuff.Mode.DST_OVER;
            case 5:
                return PorterDuff.Mode.SRC_IN;
            case 6:
                return PorterDuff.Mode.DST_IN;
            case 7:
                return PorterDuff.Mode.SRC_OUT;
            case 8:
                return PorterDuff.Mode.DST_OUT;
            case 9:
                return PorterDuff.Mode.SRC_ATOP;
            case 10:
                return PorterDuff.Mode.DST_ATOP;
            case 11:
                return PorterDuff.Mode.XOR;
            case 12:
            case 13:
            default:
                return null;
            case 14:
                return PorterDuff.Mode.SCREEN;
            case 15:
                return PorterDuff.Mode.OVERLAY;
            case 16:
                return PorterDuff.Mode.DARKEN;
            case 17:
                return PorterDuff.Mode.LIGHTEN;
        }
    }

    public static Paint.Align an(String str) {
        if (TextUtils.isEmpty(str)) {
            return Paint.Align.LEFT;
        }
        char c = 65535;
        int iHashCode = str.hashCode();
        if (iHashCode != -1364013995) {
            if (iHashCode != 3317767) {
                if (iHashCode == 108511772 && str.equals(j.e)) {
                    c = 3;
                }
            } else if (str.equals(j.d)) {
                c = 1;
            }
        } else if (str.equals("center")) {
            c = 2;
        }
        if (c == 2) {
            return Paint.Align.CENTER;
        }
        if (c != 3) {
            return Paint.Align.LEFT;
        }
        return Paint.Align.RIGHT;
    }
}
