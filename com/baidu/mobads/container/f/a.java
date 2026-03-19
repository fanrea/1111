package com.baidu.mobads.container.f;

import android.content.Context;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.ap;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.u;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final String a = "crid";
    private static final String b = "\\{@([()\\w]+)\\}";
    private static a c;

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private a() {
    }

    public String a(Context context, String str, JSONObject jSONObject) {
        if (context != null && com.baidu.mobads.container.util.o.m(str)) {
            Matcher matcher = Pattern.compile(b).matcher(str);
            while (matcher.find()) {
                try {
                    str = str.replaceFirst(b, b(context, matcher.group(1), jSONObject));
                } catch (Throwable th) {
                    bq.a().a(th);
                }
            }
            return str;
        }
        return "";
    }

    private String b(Context context, String str, JSONObject jSONObject) {
        String strA = "";
        if (!com.baidu.mobads.container.util.o.m(str)) {
            return "";
        }
        String[] strArrSplit = str.replaceAll("\\)*$", "").split("\\(");
        for (int length = strArrSplit.length - 1; length >= 0; length--) {
            if (com.baidu.mobads.container.util.o.m(strArrSplit[length])) {
                strA = a(context, strArrSplit[length], strA, jSONObject);
            }
        }
        return strA;
    }

    private String a(Context context, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        String strC = c(context, str, jSONObject);
        if (com.baidu.mobads.container.util.o.m(strC)) {
            return strC;
        }
        return a(str, str2);
    }

    private String a(String str, String str2) {
        if (!com.baidu.mobads.container.util.o.m(str) || !com.baidu.mobads.container.util.o.m(str2)) {
            return "";
        }
        if (TKDownloadReason.KSAD_TK_MD5.equals(str)) {
            return ap.a(str2);
        }
        if ("toUpper".equals(str)) {
            return str2.toUpperCase(Locale.getDefault());
        }
        if ("toLower".equals(str)) {
            return str2.toLowerCase(Locale.getDefault());
        }
        if ("clearColon".equals(str)) {
            return str2.replace(":", "");
        }
        return "clearLine".equals(str) ? str2.replace("-", "") : "";
    }

    private String c(Context context, String str, JSONObject jSONObject) {
        String strL = DeviceUtils.getInstance().l(context);
        if (jSONObject != null) {
            strL = jSONObject.optString("appsid");
        }
        if (Config.CUSTOM_USER_ID.equals(str)) {
            return u.a(IDManager.getInstance().c(context));
        }
        if ("uidtype".equals(str)) {
            return "2";
        }
        if (com.baidu.mobads.container.adrequest.g.ae.equals(str)) {
            return "";
        }
        if (com.baidu.mobads.container.components.command.j.s.equals(str)) {
            return "" + System.currentTimeMillis();
        }
        if ("pid".equals(str)) {
            return strL;
        }
        return com.baidu.mobads.container.adrequest.g.s.equals(str) ? "mobads" : "";
    }
}
