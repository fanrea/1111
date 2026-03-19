package com.kwad.components.ct.response.model.cached;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public final com.kwad.components.ct.response.model.a.a aCR;
    public int aUZ;

    public a(com.kwad.components.ct.response.model.a.a aVar) {
        this.aCR = aVar;
    }

    public final void bf(CtAdTemplate ctAdTemplate) {
        if (ctAdTemplate == null || this.aCR.aVj == null) {
            return;
        }
        for (int i = 0; i < this.aCR.aVj.size(); i++) {
            if (ctAdTemplate.equals(this.aCR.aVj.get(i))) {
                this.aUZ = i;
                return;
            }
        }
    }

    public final List<CtAdTemplate> p(SceneImpl sceneImpl) {
        List<CtAdTemplate> list = this.aCR.aVj;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<CtAdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new CacheTemplate(it.next(), sceneImpl));
        }
        return arrayList;
    }
}
