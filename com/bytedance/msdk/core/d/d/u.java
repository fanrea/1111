package com.bytedance.msdk.core.d.d;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.zw.mk;
import com.kwai.video.player.PlayerProps;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class u {
    private static String d = "dex";

    public static int d(String str, int i) {
        if (d(str) && i > 0) {
            if (i == 1) {
                return 20012;
            }
            if (i == 2) {
                return 20013;
            }
            if (i == 3) {
                return 20014;
            }
            if (i == 4) {
                return 20015;
            }
        }
        return 20016;
    }

    public static Integer d(String str, Function<SparseArray<Object>, Object> function) {
        if (function != null) {
            if (d(str)) {
                Object objApply = function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8271).d(Integer.class).hc());
                switch (objApply instanceof Integer ? ((Integer) objApply).intValue() : -1) {
                    case PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_PACKETS /* 20009 */:
                        return 2;
                    case PlayerProps.FFP_PROP_INT64_AUDIO_CACHED_PACKETS /* 20010 */:
                        return 3;
                    case 20011:
                        return 4;
                    default:
                        return 1;
                }
            }
            Integer numD = com.bytedance.sdk.openadsdk.core.ba.d.d.d(function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8121).d(20068, 1).d(Object.class).hc()));
            if (numD != null) {
                return numD;
            }
        }
        return 1;
    }

    public static boolean d(String str) {
        return (str == null || c(str) == null) ? false : true;
    }

    public static Function<SparseArray<Object>, Object> hc(String str) {
        Function<SparseArray<Object>, Object> functionC = c(str);
        if (functionC == null) {
            return null;
        }
        try {
            return (Function) functionC.apply(com.bytedance.sdk.openadsdk.w.c.d().d(10000).d(Function.class).hc());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Function<SparseArray<Object>, Object> hc(String str, int i) {
        Function<SparseArray<Object>, Object> functionC = c(str);
        if (functionC == null) {
            return null;
        }
        try {
            return (Function) functionC.apply(com.bytedance.sdk.openadsdk.w.c.d().d(i).d(Function.class).hc());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Function<SparseArray<Object>, Object> c(String str) {
        an anVarD = d.d(str);
        if (anVarD == null) {
            com.bytedance.msdk.d.u.b.hc(d, "strategy is null");
            return null;
        }
        if (!anVarD.d()) {
            com.bytedance.msdk.d.u.b.hc(d, "can not use dex load adn ad");
            return null;
        }
        if (!mk.h("com.byted.mixed")) {
            com.bytedance.msdk.d.u.b.hc(d, "dex is not installed");
            return null;
        }
        if (!mk.an("com.byted.mixed")) {
            com.bytedance.msdk.d.u.b.hc(d, "dex is not loaded");
            return null;
        }
        Function<SparseArray<Object>, Object> functionAn = anVarD.an();
        return functionAn != null ? functionAn : d(anVarD);
    }

    private static Function<SparseArray<Object>, Object> d(an anVar) {
        if (anVar == null) {
            com.bytedance.msdk.d.u.b.hc(d, "strategy is null");
            return null;
        }
        if (TextUtils.isEmpty(anVar.gb())) {
            com.bytedance.msdk.d.u.b.hc(d, "adn name is empty");
            return null;
        }
        String strB = anVar.b();
        if (TextUtils.isEmpty(strB)) {
            com.bytedance.msdk.d.u.b.hc(d, "adn classname is empty");
            return null;
        }
        String strC = anVar.c();
        if (TextUtils.isEmpty(strC)) {
            com.bytedance.msdk.d.u.b.hc(d, "adn versionListKey is empty");
            return null;
        }
        return d(anVar, strC, strB);
    }

    private static Function<SparseArray<Object>, Object> d(an anVar, String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject jSONObjectU = mk.u("com.byted.mixed");
            if (jSONObjectU != null) {
                if (!jSONObjectU.has("adn_version") || (jSONObjectOptJSONObject = jSONObjectU.optJSONObject("adn_version")) == null || !jSONObjectOptJSONObject.has(str)) {
                    return null;
                }
                JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray(str);
                String strU = anVar.u();
                if (TextUtils.isEmpty(strU) || jSONArray.length() <= 0) {
                    return null;
                }
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= jSONArray.length()) {
                        break;
                    }
                    if (TextUtils.equals(jSONArray.getString(i), strU)) {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                    if (!jSONObjectU.has(str2)) {
                        return null;
                    }
                    String strOptString = jSONObjectU.optString(str2);
                    if (TextUtils.isEmpty(strOptString)) {
                        return null;
                    }
                    Object objNewInstance = Class.forName(strOptString).newInstance();
                    if (!(objNewInstance instanceof Function)) {
                        return null;
                    }
                    anVar.d((Function<SparseArray<Object>, Object>) objNewInstance);
                    return anVar.an();
                }
                anVar.d(strU);
                return null;
            }
            com.bytedance.msdk.d.u.b.hc(d, "adn config json is null");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Function<SparseArray<Object>, Object> b(String str) {
        an anVarD = d.d(str);
        if (anVarD != null) {
            return anVarD.hc();
        }
        return null;
    }

    public static void d(Map<String, Object> map) {
        if (map != null) {
            d.d(map);
        }
    }

    public static Function<SparseArray<Object>, Object> d(String str, int i, int i2) {
        try {
            if (!d.hc(str)) {
                return null;
            }
            switch (i) {
                case 1:
                    return hc(str, 20001);
                case 2:
                    return hc(str, 20004);
                case 3:
                    return hc(str, PlayerProps.FFP_PROP_INT64_VIDEO_CACHED_BYTES);
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                    if (i2 == 4) {
                        return hc(str, 20005);
                    }
                    if (i2 == 3) {
                        return hc(str, 20001);
                    }
                    if (i2 == 5) {
                        return hc(str, 20002);
                    }
                    return hc(str, 20005);
                case 7:
                    return hc(str, 20006);
                case 8:
                    return hc(str, 20003);
                case 9:
                    return hc(str, 20002);
                case 10:
                    if (i2 == 1) {
                        return hc(str, 20004);
                    }
                    if (i2 == 2) {
                        return hc(str, 20003);
                    }
                    return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    public static com.bytedance.msdk.core.d.d.d.d hc(String str, int i, int i2) {
        if (!TextUtils.equals(str, "gdt")) {
            return null;
        }
        switch (i) {
            case 1:
                return new com.bytedance.msdk.core.d.d.hc.d.d.d();
            case 2:
                return new com.bytedance.msdk.core.d.d.hc.d.u.d();
            case 3:
                return new com.bytedance.msdk.core.d.d.hc.d.h.d();
            case 4:
            case 6:
            default:
                return null;
            case 5:
                if (i2 == 4) {
                    return new com.bytedance.msdk.core.d.d.hc.d.b.d();
                }
                if (i2 == 3) {
                    return new com.bytedance.msdk.core.d.d.hc.d.d.d();
                }
                if (i2 == 5) {
                    return new com.bytedance.msdk.core.d.d.hc.d.hc.d();
                }
                return new com.bytedance.msdk.core.d.d.hc.d.b.d();
            case 7:
                return new com.bytedance.msdk.core.d.d.hc.d.an.d();
            case 8:
                return new com.bytedance.msdk.core.d.d.hc.d.c.d();
            case 9:
                return new com.bytedance.msdk.core.d.d.hc.d.hc.d();
            case 10:
                if (i2 == 1) {
                    return new com.bytedance.msdk.core.d.d.hc.d.u.d();
                }
                if (i2 == 2) {
                    return new com.bytedance.msdk.core.d.d.hc.d.c.d();
                }
                return null;
        }
    }

    public static String d() {
        return com.bytedance.msdk.h.d.d.d().h() ? "load_plugin_gdt_adapter_v2" : "";
    }

    public static void d(com.bytedance.msdk.api.d.hc hcVar) {
        if (hcVar != null) {
            hcVar.h(1);
        }
    }

    public static void hc(com.bytedance.msdk.api.d.hc hcVar) {
        if (hcVar != null) {
            hcVar.h(3);
        }
    }

    public static int b(com.bytedance.msdk.api.d.hc hcVar) {
        if (hcVar == null) {
            return 4;
        }
        if (com.bytedance.msdk.h.d.d.d().h()) {
            return hcVar.mk() == 1 ? 1 : 2;
        }
        if (com.bytedance.msdk.h.d.d.d().gb() != 1) {
            return 3;
        }
        return hcVar.mk();
    }

    public static int hc() {
        return com.bytedance.msdk.h.d.d.d().gb();
    }
}
