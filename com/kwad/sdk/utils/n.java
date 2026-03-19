package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class n {
    public static long clB = -1;

    public static void d(List<AdTemplate> list, int i) {
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                AdTemplate adTemplate = list.get(i2);
                if (adTemplate != null) {
                    if (i2 == i) {
                        adTemplate.mOutClickTimeParam = System.currentTimeMillis();
                    } else {
                        adTemplate.mOutClickTimeParam = clB;
                    }
                }
            }
        }
    }

    public static void b(List<AdTemplate> list, AdTemplate adTemplate) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                AdTemplate adTemplate2 = list.get(i);
                if (adTemplate2 != null && (adTemplate2 == adTemplate || adTemplate2.equals(adTemplate))) {
                    adTemplate2.mOutClickTimeParam = System.currentTimeMillis();
                } else if (adTemplate2 != null) {
                    adTemplate2.mOutClickTimeParam = clB;
                }
            }
        }
    }

    public static void fk(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = clB;
            adTemplate.mOutClickTimeParam = clB;
        }
    }

    public static void fl(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    public static void fm(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long fn(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        return adTemplate.mOutClickTimeParam > 0 ? adTemplate.mOutClickTimeParam : adTemplate.mVisibleTimeParam;
    }
}
