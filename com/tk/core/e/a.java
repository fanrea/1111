package com.tk.core.e;

import com.baidu.mobstat.forbes.Config;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    static a ahN = new a();
    private static HashMap<String, String> ahO;

    static {
        ahO.put("tap", "TKTapEvent");
        ahO.put("down", "TKDownEvent");
        ahO.put("up", "TKUpEvent");
        ahO.put("longPress", "TKLongPressEvent");
        ahO.put("swipe", "TKSwipeEvent");
        ahO.put("pinch", "TKPinchEvent");
        ahO.put("pan", "TKPanEvent");
        ahO.put("scroll", "TKScrollEvent");
        ahO.put(Config.INPUT_PART, "TKInputEvent");
        ahO.put("switch", "TKSwitchEvent");
        ahO.put("dispatch", "TKDispatchEvent");
    }

    private a() {
        ahO = new HashMap<>();
    }

    public static a rC() {
        return ahN;
    }

    public static String cx(String str) {
        String str2 = ahO.get(str);
        return str2 != null ? str2 : "Event";
    }
}
