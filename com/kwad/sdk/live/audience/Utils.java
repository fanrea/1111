package com.kwad.sdk.live.audience;

import com.kwad.sdk.live.audience.model.KSLiveCDNUrl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Utils {
    public static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public static <T> boolean isEmpty(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static List<String> getPlayUrls(List<KSLiveCDNUrl> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<KSLiveCDNUrl> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().mUrl);
        }
        return arrayList;
    }

    public static void checkNoNull(Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                throw new IllegalArgumentException("null object not support");
            }
        }
    }
}
