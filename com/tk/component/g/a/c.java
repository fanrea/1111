package com.tk.component.g.a;

import android.os.Build;
import android.view.View;
import com.tk.core.o.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class c {
    public static void a(View view, Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        if (map.containsKey("scaleX")) {
            view.setScaleX(getFloat(map.get("scaleX")));
        }
        if (map.containsKey("scaleY")) {
            view.setScaleY(getFloat(map.get("scaleY")));
        }
        if (map.containsKey("translateX")) {
            view.setTranslationX(o.P(getFloat(map.get("translateX"))));
        }
        if (map.containsKey("translateY")) {
            view.setTranslationY(o.P(getFloat(map.get("translateY"))));
        }
        if (map.containsKey("translateZ")) {
            float f = getFloat(map.get("translateZ"));
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(o.P(f));
            }
        }
        if (map.containsKey("rotateX")) {
            view.setRotationX(getFloat(map.get("rotateX")));
        }
        if (map.containsKey("rotateY")) {
            view.setRotationY(getFloat(map.get("rotateY")));
        }
        if (map.containsKey("rotate")) {
            view.setRotation(getFloat(map.get("rotate")));
        }
        if (map.containsKey("pivotX")) {
            view.setPivotX(o.P(getFloat(map.get("pivotX"))));
        }
        if (map.containsKey("pivotY")) {
            view.setPivotY(o.P(getFloat(map.get("pivotY"))));
        }
        if (map.containsKey("alpha")) {
            view.setAlpha(getFloat(map.get("alpha")));
        }
    }

    public static Map<Float, com.tk.component.g.a.a.b> m(List<Map> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map map2 : list) {
            if (map2 != null && !map2.isEmpty() && map2.containsKey("position")) {
                float f = getFloat(map2.get("position"));
                com.tk.component.g.a.a.b bVarF = f(map2);
                if (bVarF != null) {
                    map.put(Float.valueOf(f), bVarF);
                }
            }
        }
        return map;
    }

    private static com.tk.component.g.a.a.b f(Map map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        com.tk.component.g.a.a.b bVar = new com.tk.component.g.a.a.b();
        if (map.containsKey("scaleX")) {
            bVar.XQ = Float.valueOf(getFloat(map.get("scaleX")));
        }
        if (map.containsKey("scaleY")) {
            bVar.XR = Float.valueOf(getFloat(map.get("scaleY")));
        }
        if (map.containsKey("translateX")) {
            bVar.XS = Float.valueOf(o.P(getFloat(map.get("translateX"))));
        }
        if (map.containsKey("translateY")) {
            bVar.XT = Float.valueOf(o.P(getFloat(map.get("translateY"))));
        }
        if (map.containsKey("translateZ")) {
            float f = getFloat(map.get("translateZ"));
            if (Build.VERSION.SDK_INT >= 21) {
                bVar.XU = Float.valueOf(o.P(f));
            }
        }
        if (map.containsKey("rotateX")) {
            bVar.XV = Float.valueOf(getFloat(map.get("rotateX")));
        }
        if (map.containsKey("rotateY")) {
            bVar.XW = Float.valueOf(getFloat(map.get("rotateY")));
        }
        if (map.containsKey("rotate")) {
            bVar.XX = Float.valueOf(getFloat(map.get("rotate")));
        }
        if (map.containsKey("pivotX")) {
            bVar.XY = Float.valueOf(o.P(getFloat(map.get("pivotX"))));
        }
        if (map.containsKey("pivotY")) {
            bVar.XZ = Float.valueOf(o.P(getFloat(map.get("pivotY"))));
        }
        if (map.containsKey("alpha")) {
            bVar.Ya = Float.valueOf(getFloat(map.get("alpha")));
        }
        return bVar;
    }

    private static float getFloat(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).floatValue();
        }
        return 0.0f;
    }

    static Float a(Float f, Float f2, float f3) {
        if (f == null) {
            if (f2 == null) {
                return null;
            }
            return Float.valueOf(f3 - f2.floatValue());
        }
        if (f2 == null) {
            return Float.valueOf(f.floatValue() - f3);
        }
        return Float.valueOf(f.floatValue() - f2.floatValue());
    }

    static void a(View view, com.tk.component.g.a.a.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.XQ != null) {
            view.setScaleX(bVar.XQ.floatValue());
        }
        if (bVar.XR != null) {
            view.setScaleY(bVar.XR.floatValue());
        }
        if (bVar.XS != null) {
            view.setTranslationX(bVar.XS.floatValue());
        }
        if (bVar.XT != null) {
            view.setTranslationY(bVar.XT.floatValue());
        }
        if (bVar.XU != null && Build.VERSION.SDK_INT >= 21) {
            view.setTranslationZ(bVar.XU.floatValue());
        }
        if (bVar.XV != null) {
            view.setRotationX(bVar.XV.floatValue());
        }
        if (bVar.XW != null) {
            view.setRotationY(bVar.XW.floatValue());
        }
        if (bVar.XX != null) {
            view.setRotation(bVar.XX.floatValue());
        }
        if (bVar.XY != null) {
            view.setPivotX(bVar.XY.floatValue());
        }
        if (bVar.XZ != null) {
            view.setPivotY(bVar.XZ.floatValue());
        }
        if (bVar.Ya != null) {
            view.setAlpha(bVar.Ya.floatValue());
        }
    }
}
