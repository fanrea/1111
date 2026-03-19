package com.baidu.mobads.container.nativecpu.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.components.g.f;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.IDManager;
import com.baidu.mobads.container.util.ap;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final String a = "\\{@([()\\w]+)\\}";
    private static c b;

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private c() {
    }

    public String a(Context context, String str, JSONObject jSONObject) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile(a).matcher(str);
            while (matcher.find()) {
                try {
                    str = str.replaceFirst(a, b(context, matcher.group(1), jSONObject));
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
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.replaceAll("\\)*$", "").split("\\(");
        for (int length = strArrSplit.length - 1; length >= 0; length--) {
            if (TextUtils.isEmpty(strArrSplit[length])) {
                strA = a(context, strArrSplit[length], strA, jSONObject);
            }
        }
        return strA;
    }

    private String a(Context context, String str, String str2, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has(str)) {
            return jSONObject.optString(str);
        }
        String strA = a(context, str);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        return a(str, str2);
    }

    private String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
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

    private String a(Context context, String str) {
        if (Config.CUSTOM_USER_ID.equals(str)) {
            return IDManager.getInstance().c(context);
        }
        if ("uidtype".equals(str)) {
            return "2";
        }
        if (g.ae.equals(str)) {
            return "";
        }
        if (j.s.equals(str)) {
            return "" + System.currentTimeMillis();
        }
        if ("pid".equals(str)) {
            return DeviceUtils.getInstance().l(context);
        }
        return g.s.equals(str) ? "mobads" : "";
    }

    public void a(Context context, List<String> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    new f(1, a().a(context, str, null)).a();
                }
            }
        }
    }
}
