package com.bytedance.msdk.gb;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.api.SplashAd;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;
import java.util.Map;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class w {
    public static boolean d() {
        Map<String, Object> mapZ = com.bytedance.msdk.core.d.mk().z();
        Map<String, Object> mapUs = com.bytedance.msdk.core.d.mk().us();
        if (mapZ != null) {
            try {
                if (mapZ.get("eefo") instanceof Boolean) {
                    return ((Boolean) mapZ.get("eefo")).booleanValue();
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (mapUs == null || !(mapUs.get("eefo") instanceof Boolean)) {
            return false;
        }
        return ((Boolean) mapUs.get("eefo")).booleanValue();
    }

    public static String d(com.bytedance.msdk.api.b bVar) {
        if (bVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("adn_name", bVar.tt());
            jSONObject.put("custom_adn_name", bVar.tc());
            jSONObject.put("slot_id", bVar.mk());
            jSONObject.put("level_tag", bVar.k());
            jSONObject.put(SplashAd.KEY_BIDFAIL_ECPM, bVar.uo());
            jSONObject.put("bidding_type", bVar.e());
            jSONObject.put("error_msg", bVar.cb());
            jSONObject.put("request_id", bVar.w());
            jSONObject.put("ad_rit_type", bVar.hc());
            jSONObject.put("ad_sub_rit_type", bVar.b());
            jSONObject.put("segment_id", bVar.c());
            jSONObject.put("abtest_id", bVar.h());
            jSONObject.put("channel", bVar.u());
            jSONObject.put("sub_channel", bVar.an());
            jSONObject.put("scenario_id", bVar.gb());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        String string = jSONObject.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            String strD = d(16);
            String strHc = hc(string, strD);
            String strD2 = d(strD, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA7aAsZzOAmVVuIl0EZtpY\nPkJGdr82VIOzPBDYNEOBK0tfk/oSWyY8yZDpeYuhNuSPySmhaN8Apn3HGfL1Eq6t\nSE3OdAovRJjnilU/5ugSM/nr5yMy6WRvJUskvQ9F3PF9MLez8ZJxVDb4tgUXjq2S\n1QKSP+NwAKdY+P/H8SD5evamqCpvzO1IwpqznNI2HGAo/Kdm5OQ+Yq47A31dDUSH\nVF/TTzTfae8j6lanqgz9DmFs+kqoy253aXlz8H0z8J3VpmOGvnOUiS00Hg5SILV0\nsoXtS9JKK/V3gXmbXWyFvZhuIvLqk3C8AdyZuDdy1GAI3GjI4wjtiMd11zSTECrV\ntQIDAQAB");
            return String.format("%04d", Integer.valueOf(strD2.length())) + strD2 + strHc;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String d(String str, String str2) {
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new X509EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            return Base64.encodeToString(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String hc(String str, String str2) {
        try {
            return d.d(str.getBytes(StandardCharsets.UTF_8), str2);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String d(int i) {
        StringBuilder sb = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i2 = 0; i2 < i; i2++) {
            int iNextInt = secureRandom.nextInt(3);
            if (iNextInt == 0) {
                sb.append(secureRandom.nextInt(10));
            } else if (iNextInt == 1) {
                sb.append((char) (secureRandom.nextInt(25) + 65));
            } else if (iNextInt == 2) {
                sb.append((char) (secureRandom.nextInt(25) + 97));
            }
        }
        return sb.toString();
    }
}
