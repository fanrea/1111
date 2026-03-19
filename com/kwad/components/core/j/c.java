package com.kwad.components.core.j;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    private Object ST;
    private AdTemplate SU;

    public static List<AdTemplate> p(List<c> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<c> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getAdTemplate());
        }
        return arrayList;
    }

    public c(AdTemplate adTemplate, int i) {
        this.ST = null;
        try {
            this.ST = new b(adTemplate, i);
        } catch (Throwable unused) {
            this.SU = adTemplate;
        }
    }

    public final Object getHost() {
        return this.ST;
    }

    public final AdTemplate getAdTemplate() {
        AdTemplate adTemplate;
        Object obj = this.ST;
        if (obj != null) {
            try {
                adTemplate = ((b) obj).getAdTemplate();
            } catch (Exception unused) {
            }
        } else {
            adTemplate = null;
        }
        return adTemplate == null ? this.SU : adTemplate;
    }
}
