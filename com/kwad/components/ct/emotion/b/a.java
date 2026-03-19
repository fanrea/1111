package com.kwad.components.ct.emotion.b;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.kwad.components.ct.emotion.model.CDNUrl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static String[] c(List<CDNUrl> list, String str) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CDNUrl cDNUrl : list) {
                if (bI(cDNUrl.getUrl()) && !arrayList.contains(cDNUrl.getUrl())) {
                    arrayList.add(cDNUrl.getUrl());
                }
            }
        }
        if (bI(null) && !arrayList.contains(null)) {
            arrayList.add(null);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    private static boolean bI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (URLUtil.isNetworkUrl(str)) {
            return true;
        }
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return TextUtils.equals("content", Uri.parse(str).getScheme()) && TextUtils.equals("media", Uri.parse(str).getHost());
    }
}
