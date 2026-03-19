package com.baidu.mobads.container.o;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.adrequest.n;
import com.component.a.a.b;
import com.component.a.f.e;
import com.component.a.g.c.bm;
import com.kuaishou.socket.nano.SocketMessages;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j {
    public static final String a = "$";
    private static final Map<Integer, String> b = new HashMap();
    private static final Map<String, Integer> c = new HashMap();

    static {
        for (a aVar : a.values()) {
            b.put(Integer.valueOf(aVar.W), aVar.X);
            if (!c.containsKey(aVar.X)) {
                c.put(aVar.X, Integer.valueOf(aVar.W));
            }
        }
    }

    public static boolean a(String str) {
        return c.containsKey(str);
    }

    public static int b(String str) {
        Integer num;
        if (c.containsKey(str) && (num = c.get(str)) != null) {
            return num.intValue();
        }
        return -1;
    }

    public static String a(int i) {
        if (b.containsKey(Integer.valueOf(i))) {
            String str = b.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return "";
        }
        return "";
    }

    public static View a(View view) {
        if (view instanceof com.component.a.c.c) {
            if (a(com.component.a.i.f.c(view).m(""))) {
                return view;
            }
            if (view.getParent() instanceof ViewGroup) {
                return a((ViewGroup) view.getParent());
            }
            return null;
        }
        return null;
    }

    public static String a(String str, View view) {
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return a(str, fVarA.b());
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String a(String str, com.component.a.f.e eVar) {
        JSONObject jSONObjectC;
        if (eVar == null || 1 != eVar.e(1) || (jSONObjectC = eVar.c()) == null) {
            return "";
        }
        return b(str) + a + jSONObjectC.optString("velocity", "7") + a + jSONObjectC.optString("shake_angle", "0");
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf("/") > 0 && str.lastIndexOf("/") + 1 <= str.length()) {
            return str.substring(str.lastIndexOf("/") + 1);
        }
        return str;
    }

    public static String b(String str, View view) {
        String str2 = b(str) + a;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!b(view)) {
            return "";
        }
        com.component.a.i.f fVarA = com.component.a.i.f.a(view);
        if (fVarA != null) {
            return b(str, fVarA.b());
        }
        return str2;
    }

    public static String b(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        try {
            e.h hVarA = a(eVar);
            if (hVarA != null && hVarA.a() != null && hVarA.a().get("image_0") != null) {
                return str2 + c(hVarA.a().get("image_0"));
            }
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String c(String str, View view) {
        String str2 = b(str) + a;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!b(view)) {
            return "";
        }
        com.component.a.i.f fVarA = com.component.a.i.f.a(view);
        if (fVarA != null) {
            return c(str, fVarA.b());
        }
        return str2;
    }

    public static String c(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        try {
            e.h hVarA = a(eVar);
            if (hVarA != null) {
                return (str2 + hVarA.b(0)) + a + c(hVarA.a().get("image_0"));
            }
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String d(String str, View view) {
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return d(str, fVarA.b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    public static String d(String str, com.component.a.f.e eVar) {
        e.h hVarA;
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                List<com.component.a.f.e> listO = eVar.o();
                if (listO != null && !listO.isEmpty() && (hVarA = a(listO.get(0))) != null) {
                    return (str2 + hVarA.c(-1)) + a + hVarA.b(-1);
                }
                return str2;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String e(String str, View view) {
        String str2 = b(str) + a;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!b(view)) {
            return "";
        }
        com.component.a.i.f fVarA = com.component.a.i.f.a(view);
        if (fVarA != null) {
            return e(str, fVarA.b());
        }
        return str2;
    }

    public static String e(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        if (eVar != null) {
            if (1 != eVar.e(1)) {
                return "";
            }
            try {
                e.h hVarA = a(eVar);
                return (str2 + hVarA.c(-1)) + a + hVarA.b(-1);
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String a(JSONObject jSONObject, String str, View view) {
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return a(jSONObject, str, fVarA.b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    public static String a(JSONObject jSONObject, String str, com.component.a.f.e eVar) {
        e.h hVarA;
        e.h hVarA2;
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                if (a(jSONObject, eVar.l("")).contains("coupon_float_card")) {
                    List<com.component.a.f.e> listO = eVar.o();
                    if (listO != null && !listO.isEmpty() && (hVarA2 = a(listO.get(0))) != null && hVarA2.a() != null && hVarA2.a().get("image_24") != null) {
                        str2 = str2 + c(hVarA2.a().get("image_24"));
                    }
                    return str2;
                }
                String str3 = b("coupon_float_icon") + a;
                List<com.component.a.f.e> listO2 = eVar.o();
                if (listO2 != null && listO2.size() > 1 && (hVarA = a(listO2.get(1))) != null && hVarA.a() != null && hVarA.a().get("image_4") != null) {
                    return str3 + c(hVarA.a().get("image_4"));
                }
                return str3;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String f(String str, View view) {
        String str2 = b(str) + a;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!b(view)) {
            return "";
        }
        com.component.a.i.f fVarA = com.component.a.i.f.a(view);
        if (fVarA != null) {
            return f(str, fVarA.b());
        }
        return str2;
    }

    public static String f(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        if (eVar != null) {
            if (1 != eVar.e(1)) {
                return "";
            }
            try {
                e.h hVarA = a(eVar);
                if (hVarA.a() != null && hVarA.a().get("image_6") != null) {
                    return str2 + c(hVarA.a().get("image_6"));
                }
                return str2;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String g(String str, View view) {
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return g(str, fVarA.b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    public static String g(String str, com.component.a.f.e eVar) {
        com.component.a.f.e eVar2;
        e.h hVarA;
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                JSONObject jSONObjectC = eVar.c();
                String str3 = str2 + jSONObjectC.optString("delay_time", "") + a + jSONObjectC.optString(n.m, "");
                List<com.component.a.f.e> listO = eVar.o();
                if (listO != null && !listO.isEmpty() && (eVar2 = listO.get(0)) != null && (hVarA = a(eVar2)) != null) {
                    return str3 + a + c(hVarA.a().get("image_1"));
                }
                return str3;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String h(String str, View view) {
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return h(str, fVarA.b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    public static String h(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                JSONObject jSONObjectC = eVar.c();
                return str2 + jSONObjectC.optString(b.e.c, "") + a + jSONObjectC.optString("duration", "");
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String i(String str, View view) {
        com.component.a.f.e eVarB;
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null && (eVarB = fVarA.b()) != null) {
                if (1 != eVarB.e(1)) {
                    return "";
                }
                String str3 = str2 + eVarB.c().optString("delay_time", "");
                List<com.component.a.f.e> listO = eVarB.o();
                if (listO != null && listO.size() > 1) {
                    com.component.a.f.e eVar = listO.get(1);
                    e.h hVarA = a(eVar);
                    if (eVar != null) {
                        return str3 + a + c(hVarA.a().get("image_0"));
                    }
                    return str3;
                }
                return str3;
            }
            return str2;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String i(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                String str3 = str2 + eVar.c().optString("delay_time", "");
                List<com.component.a.f.e> listO = eVar.o();
                if (listO != null && listO.size() > 1) {
                    com.component.a.f.e eVar2 = listO.get(1);
                    e.h hVarA = a(eVar2);
                    if (eVar2 != null) {
                        return str3 + a + c(hVarA.a().get("image_0"));
                    }
                    return str3;
                }
                return str3;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String j(String str, View view) {
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return j(str, fVarA.b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    public static String j(String str, com.component.a.f.e eVar) {
        com.component.a.f.e eVar2;
        List<com.component.a.f.e> listO;
        com.component.a.f.e eVar3;
        List<com.component.a.f.e> listO2;
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                String str3 = str2 + eVar.c().optString(n.m, "");
                List<com.component.a.f.e> listO3 = eVar.o();
                if (listO3 != null && listO3.size() > 1 && (eVar2 = listO3.get(1)) != null && (listO = eVar2.o()) != null && listO.size() > 1 && (eVar3 = listO.get(1)) != null && (listO2 = eVar3.o()) != null && listO2.size() > 3) {
                    return str3 + a + c(listO2.get(3).o(""));
                }
                return str3;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String k(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                e.C0316e c0316eJ = eVar.j();
                if (c0316eJ != null) {
                    return str2 + c0316eJ.b(0);
                }
                return str2;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String k(String str, View view) {
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return l(str, fVarA.b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    public static String l(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                e.C0316e c0316eJ = eVar.j();
                if (c0316eJ != null) {
                    str2 = str2 + c0316eJ.b(0);
                }
                JSONObject jSONObjectC = eVar.c();
                if (jSONObjectC != null) {
                    return str2 + a + jSONObjectC.optString(n.m, "");
                }
                return str2;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String m(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                JSONObject jSONObjectC = eVar.c();
                if (jSONObjectC != null) {
                    return str2 + jSONObjectC.optString("delay_time", "") + a + jSONObjectC.optString(n.m, "");
                }
                return str2;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String l(String str, View view) {
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return m(str, fVarA.b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    public static String n(String str, com.component.a.f.e eVar) {
        com.component.a.f.e eVar2;
        List<com.component.a.f.e> listO;
        com.component.a.f.e eVar3;
        List<com.component.a.f.e> listO2;
        com.component.a.f.e eVar4;
        List<com.component.a.f.e> listO3;
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                if (1 != eVar.e(1)) {
                    return "";
                }
                List<com.component.a.f.e> listO4 = eVar.o();
                if (listO4 != null && listO4.size() > 1 && (eVar2 = listO4.get(1)) != null && (listO = eVar2.o()) != null && listO.size() > 0 && (eVar3 = listO.get(0)) != null && (listO2 = eVar3.o()) != null && listO2.size() > 0 && (eVar4 = listO2.get(0)) != null && (listO3 = eVar4.o()) != null && listO3.size() > 0) {
                    return str2 + c(listO3.get(0).o(""));
                }
                return str2;
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String m(String str, View view) {
        String str2 = b(str) + a;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return n(str, fVarA.b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return str2;
    }

    public static String o(String str, com.component.a.f.e eVar) {
        String str2 = b(str) + a;
        if (eVar != null) {
            try {
                return str2 + eVar.c().optInt("hint_type", 0) + a + eVar.c().optInt("reward_method", 0);
            } catch (Throwable th) {
                th.printStackTrace();
                return str2;
            }
        }
        return str2;
    }

    public static String n(String str, View view) {
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return p(str, fVarA.b());
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String p(String str, com.component.a.f.e eVar) {
        if (eVar != null) {
            JSONObject jSONObjectC = eVar.c();
            if (jSONObjectC != null) {
                return b(str) + a + jSONObjectC.optString("delay_time", "0") + a + jSONObjectC.optString(n.m, "0");
            }
            return b(str) + a + "0" + a + "0";
        }
        return "";
    }

    public static String o(String str, View view) {
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null) {
                return q(str, fVarA.b());
            }
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String q(String str, com.component.a.f.e eVar) {
        if (eVar != null) {
            JSONObject jSONObjectC = eVar.c();
            if (jSONObjectC != null) {
                return b(str) + a + jSONObjectC.optString("delay_time", "0") + a + jSONObjectC.optString(n.m, "0");
            }
            return b(str) + a + "0" + a + "0";
        }
        return "";
    }

    public static boolean b(View view) {
        com.component.a.f.e eVarB;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA != null && (eVarB = fVarA.b()) != null) {
                return 1 == eVarB.e(1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static e.h a(com.component.a.f.e eVar) {
        if (eVar == null) {
            return null;
        }
        try {
            List<e.h> listL = eVar.l();
            if (listL == null || listL.size() <= 0) {
                return null;
            }
            return listL.get(0);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static e.h c(View view) {
        List<e.h> listL;
        try {
            com.component.a.i.f fVarA = com.component.a.i.f.a(view);
            if (fVarA == null || (listL = fVarA.b().l()) == null || listL.size() <= 0) {
                return null;
            }
            return listL.get(0);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("st_op");
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("amend");
                if (!TextUtils.isEmpty(strOptString) && (jSONArrayOptJSONArray = new JSONObject(strOptString).optJSONArray("increment")) != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.optString("id", "").equals(str)) {
                            String strOptString2 = jSONObjectOptJSONObject2.optString("json_view", "");
                            if (!TextUtils.isEmpty(strOptString2)) {
                                return new JSONObject(strOptString2).optString("id", "");
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "";
    }

    public static String b(com.component.a.f.e eVar) {
        if (eVar != null) {
            eVar.l("");
            String strM = eVar.m("");
            if ((TextUtils.isEmpty(strM) || !strM.endsWith("0")) && !a(strM)) {
                if (TextUtils.equals("cta", eVar.i().a(""))) {
                    return "" + a.BUTTON_VIEW.b();
                }
            }
            return "" + b(strM);
        }
        return "";
    }

    public enum a {
        SHAKE_VIEW("shake_view", 1010),
        FEED_SHAKE_VIEW(bm.b, 1011),
        RENDER_SHAKE_VIEW(bm.c, 1012),
        FRONT_SHAKE_VIEW(bm.d, 1013),
        COVER_SHAKE_VIEW(bm.e, 1014),
        TWIST_SHAKE_VIEW("splash_twist", 1015),
        BLANK_SHAKE_VIEW("native_shake_view_blank", 1016),
        SLIDE_VIEW("slide_view", 1020),
        FRONT_SLIDE_VIEW("front_slide_view", 1021),
        GESTURE_VIEW("gesture_view", 1022),
        TEMPLATE_SLIDE_VIEW("gesture_view", 1023),
        EASTER_EGG("easter_egg", 1030),
        FRONT_EASTER_EGG("front_easter_egg", 1031),
        ATMOSPHERE_VIEW("atmosphere_view", 1040),
        BIG_WHITE_FINGER("big_white_finger", 1050),
        BIG_COC_VIEW("big_coc_view", 1051),
        DC_VIEW("dc_view", 1060),
        PX_CLOSE("pixel_click_view", 1070),
        COUPON_FLOAT("coupon_float", 1080),
        COUPON_FLOAT_ICON("coupon_float_icon", 1081),
        ONE_PURCHASE("one_purchase", 1082),
        COUPON_DISCOUNT("coupon_discount", 1083),
        COUPON_FLIP_PAGE("coupon_flip_page", 1090),
        ANSWER_CARD("answer_card", 1100),
        BUBBLE_WIDGET("bubble_widget", SocketMessages.PayloadType.SC_LIVE_OFFICIAL_PROGRAMME_DUMP_AUDIENCE),
        DYNAMIC_BARRAGE("dynamic_barrage", SocketMessages.PayloadType.SC_INTERACTIVE_CHAT_CANCEL_APPLY),
        FLIP_CARD("flip_card", 1130),
        INTERACT_FRONT_PACK_RAIN("interact_front_pack_rain", SocketMessages.PayloadType.SC_LIVE_AUTHOR_RADAR),
        INTERACT_FRONT_FLIP_CARD("interact_front_flip_card", SocketMessages.PayloadType.SC_LIVE_INTERACTIVE_CHAT_ENTER_ROOM),
        INTERACT_FRONT_LUCKY_BAG("interact_front_lucky_bag", SocketMessages.PayloadType.SC_LIVE_BULLET_PLAY_CHAT_ENTRANCE),
        INTERACT_BACK_WELFARE("interact_back_welfare", 1150),
        INTERACT_BACK_COUPON("interact_back_coupon", 1151),
        BOOKMARK("bookmark", 1160),
        FEED_BOOKMARK("bookmark", 1161),
        SPLASH_MULTIPLE_INTERACTIONS_VIEW("splash_multiple_interactions_view", SocketMessages.PayloadType.SC_GZONE_DISPLAY_FACE_PORTRAIT_LAYOUT),
        SPLASH_FOCUS_ZOOM_OUT("splash_focus_zoom_out", SocketMessages.PayloadType.SC_LIVE_YEAR_CEREMONY23_FINGER_GUESS_QUICK_GIFT_UPDATE),
        SPLASH_FOCUS_CARD("splash_focus_card", SocketMessages.PayloadType.SC_GZONE_CP_PREDICTION_CHANGED),
        SPLASH_ACTION_VIEW("splash_action_view", SocketMessages.PayloadType.SC_LIVE_QUIZ3_SYNC),
        CLICK_CONVERSION_REWARD("click_reward", 1210),
        BUTTON_VIEW("button_view", 1220),
        SEGMENTED_COUNTDOWN_GIFT("segmented_countdown_gift", SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_MAGIC_EFFECT),
        SEGMENTED_COUNTDOWN_TEXT("segmented_countdown_text", SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION),
        VIDEO_VIEW("video_view", SocketMessages.PayloadType.SC_LIVE_QUICK_INTERACT_GIFT_UPDATE),
        GUIDE_SLIDE("guide_slide", 1250),
        BD_MARKETING_TITLE("bdmarketingtitle", SocketMessages.PayloadType.SC_LIVE_VOICE_PARTY_VIDEO_CLOSED),
        MARKETING_PENDENT("marketing_pendent", SocketMessages.PayloadType.SC_LIVE_GIFT_ACHIEVEMENT_NOTICE_USER),
        BARRAGE_VIEW("barrage_view", SocketMessages.PayloadType.SC_LIVE_SMALL_PLAY_BOTTOM_UPDATE),
        DISLIKE_VIEW("dislike_view", SocketMessages.PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE);

        private final int W;
        private final String X;

        public int b() {
            return this.W;
        }

        public String c() {
            return this.X;
        }

        a(String str, int i) {
            this.X = str;
            this.W = i;
        }
    }
}
