package com.ss.android.socialbase.appdownloader.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.mobstat.forbes.Config;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class uo extends d {
    public uo(Context context, com.ss.android.socialbase.downloader.uo.d dVar, String str) {
        super(context, dVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.d.u
    public Intent hc() {
        String strB = this.hc.b("s");
        String strD = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b("bb"), strB);
        if (!TextUtils.isEmpty(strD) && strD.split(",").length == 2) {
            String strD2 = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b("bc"), strB);
            if (!TextUtils.isEmpty(strD2) && strD2.split(",").length == 2) {
                String[] strArrSplit = strD.split(",");
                String[] strArrSplit2 = strD2.split(",");
                String strD3 = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b(Config.DEVICE_BRAND), strB);
                String strD4 = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b("be"), strB);
                String strD5 = com.ss.android.socialbase.appdownloader.an.b.d(this.hc.b("bf"), strB);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strD3, this.b);
                Intent intent = new Intent();
                intent.setAction(strD5);
                intent.setData(Uri.parse(strD4 + d(map)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }

    public static String d(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append(a.n);
        }
        String string = stringBuffer.toString();
        return string.endsWith(a.n) ? string.substring(0, string.length() - 1) : string;
    }
}
