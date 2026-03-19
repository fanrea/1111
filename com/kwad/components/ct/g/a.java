package com.kwad.components.ct.g;

import com.kwad.components.ct.e.b;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.core.d.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private List<KsContentPage.SubShowItem> aVr = new ArrayList();
    private Map<String, KsContentPage.SubShowItem> aVs = new HashMap();

    private void a(KsContentPage.SubShowItem subShowItem) {
        if (this.aVr.contains(subShowItem)) {
            return;
        }
        this.aVr.add(subShowItem);
    }

    public final void P(List<KsContentPage.SubShowItem> list) {
        if (list == null) {
            return;
        }
        Iterator<KsContentPage.SubShowItem> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public final KsContentPage.SubShowItem bg(CtAdTemplate ctAdTemplate) {
        return this.aVs.get(ctAdTemplate.mUniqueId);
    }

    public final int r(CtAdTemplate ctAdTemplate, int i) {
        if (ctAdTemplate == null) {
            return 0;
        }
        String str = ctAdTemplate.mUniqueId;
        if (this.aVs.containsKey(str)) {
            return 3;
        }
        if (ctAdTemplate.contentType == 3) {
            c.d("ThirdModelManager", "检测到第三方广告位，开始尝试插入,position:" + i);
            if (this.aVr.size() > 0) {
                this.aVs.put(str, this.aVr.remove(0));
                c.d("ThirdModelManager", "检测到第三方广告位，插入成功,position:" + i);
                return 3;
            }
            if (ctAdTemplate.adInfoList.size() > 0 && ctAdTemplate.adInfoList.get(0) != null) {
                ctAdTemplate.realShowType = 2;
                c.d("ThirdModelManager", "检测到第三方广告位，插入失败使用默认广告兜底,position:" + i);
                return 2;
            }
            c.d("ThirdModelManager", "检测到第三方广告位，插入失败丢弃该位置，position:" + i);
            b.JK().S(ctAdTemplate);
        }
        return 0;
    }
}
