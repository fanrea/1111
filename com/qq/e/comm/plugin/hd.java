package com.qq.e.comm.plugin;

import com.qq.e.ads.cfg.VideoOption;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class hd {
    public static void a(String str, VideoOption videoOption) throws JSONException {
        r1.d().f().a("videoOptions", (Object) videoOption.getOptions().toString(), str);
    }

    public static int b(String str) {
        if (su.h() < 630) {
            return -1;
        }
        return r1.d().f().a("sknmaw", str, -1);
    }

    public static JSONObject c(String str) {
        String strC = r1.d().f().c("videoOptions", str);
        try {
            if (strC == null) {
                strC = "{}";
            }
            return new JSONObject(strC);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static int a(String str) {
        return r1.d().f().a("sknmalc", str, 10);
    }
}
