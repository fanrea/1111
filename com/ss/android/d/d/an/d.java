package com.ss.android.d.d.an;

import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.sigmob.sdk.base.n;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.socialbase.appdownloader.an.u;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    public static boolean d(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if (mq.tt().optInt("market_url_opt", 1) == 0) {
            return "market".equals(scheme);
        }
        return "market".equals(scheme) || "appmarket".equals(scheme) || "oaps".equals(scheme) || "oppomarket".equals(scheme) || "mimarket".equals(scheme) || "vivomarket".equals(scheme) || "vivoMarket".equals(scheme) || "gomarket".equals(scheme) || "goMarket".equals(scheme) || "mstore".equals(scheme) || "samsungapps".equals(scheme) || "honormarket".equals(scheme) || "prizeappcenter".equals(scheme);
    }

    public static String hc(Uri uri) {
        String scheme = uri.getScheme();
        List<String> pathSegments = uri.getPathSegments();
        if (mq.tt().optInt("market_scheme_opt") == 1 && u.h() && "samsungapps".equals(scheme) && pathSegments != null && pathSegments.size() == 1) {
            return pathSegments.get(0);
        }
        return hc.d(uri.getQueryParameter("id"), uri.getQueryParameter("packagename"), uri.getQueryParameter(Config.INPUT_DEF_PKG), uri.getQueryParameter(n.p), uri.getQueryParameter("appId"));
    }

    public static Uri d(Context context, String str) {
        String string = Settings.System.getString(context.getContentResolver(), "persit.sys.tid");
        Uri.Builder builder = new Uri.Builder();
        if (u.w() && mq.tt().optInt("enable_honor_market_scheme_opt", 1) == 1) {
            return builder.scheme("honormarket").authority("details").appendQueryParameter("id", str).build();
        }
        if (!TextUtils.isEmpty(string) && mq.tt().optInt("enable_persit_market_scheme_opt", 1) == 1) {
            return builder.scheme("prizeappcenter").authority("details").appendQueryParameter(Config.INPUT_DEF_PKG, str).build();
        }
        return Uri.parse("market://details?id=".concat(String.valueOf(str)));
    }
}
