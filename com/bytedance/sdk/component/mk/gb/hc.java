package com.bytedance.sdk.component.mk.gb;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static JSONObject d(String str) {
        String strDecode;
        int iIndexOf;
        JSONObject jSONObject = new JSONObject();
        try {
            strDecode = URLDecoder.decode(str, "UTF-8");
            iIndexOf = strDecode.indexOf(63);
        } catch (Throwable unused) {
        }
        if (iIndexOf == -1) {
            return jSONObject;
        }
        Matcher matcher = Pattern.compile("([^&=]+)=((?:\\$\\{[^}]+\\})|[^&]+)").matcher(strDecode.substring(iIndexOf + 1));
        while (matcher.find()) {
            jSONObject.put(matcher.group(1), matcher.group(2));
        }
        return jSONObject;
    }
}
