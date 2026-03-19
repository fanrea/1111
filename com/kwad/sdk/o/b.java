package com.kwad.sdk.o;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.sdk.utils.bq;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static boolean b(a aVar) {
        if (aVar == null || !"recommend".equals(aVar.getType())) {
            return false;
        }
        return aVar.ig(Config.PUSH);
    }

    public static boolean c(a aVar) {
        if (aVar == null || !"share".equals(aVar.getType())) {
            return false;
        }
        return aVar.ig("mediashare");
    }

    public static String au(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String queryParameter = Uri.parse(str).getQueryParameter(str2);
        if (queryParameter == null) {
            return queryParameter;
        }
        try {
            return URLEncoder.encode(queryParameter, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return queryParameter;
        }
    }

    public static String ih(String str) {
        return bq.aF(str, "kscu://share/?mediashare=");
    }
}
