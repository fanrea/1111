package com.kwad.components.ct.home.adx;

import com.kwad.components.adx.api.model.a;
import com.kwad.components.adx.api.model.b;
import com.kwad.components.ct.response.model.CtAdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class AdxAdTemplate extends CtAdTemplate {
    private static final long serialVersionUID = -4674804269125447664L;
    public transient a mAdxAdModel;
    public transient CtAdTemplate mOriginalAdTemplate;

    private AdxAdTemplate() {
    }

    public static AdxAdTemplate create(CtAdTemplate ctAdTemplate, b bVar) {
        CtAdTemplate originalAdTemplate = getOriginalAdTemplate(ctAdTemplate);
        AdxAdTemplate adxAdTemplate = new AdxAdTemplate();
        adxAdTemplate.mAdxAdModel = bVar;
        adxAdTemplate.mOriginalAdTemplate = originalAdTemplate;
        adxAdTemplate.contentType = 3;
        adxAdTemplate.realShowType = 3;
        adxAdTemplate.thirdFromAdx = true;
        adxAdTemplate.mUniqueId = String.valueOf(bVar.getId());
        adxAdTemplate.setShowPosition(originalAdTemplate.getShowPosition());
        adxAdTemplate.setServerPosition(originalAdTemplate.getServerPosition());
        adxAdTemplate.posId = originalAdTemplate.posId;
        adxAdTemplate.type = originalAdTemplate.type;
        adxAdTemplate.needHide = originalAdTemplate.needHide;
        adxAdTemplate.llsid = originalAdTemplate.llsid;
        adxAdTemplate.extra = originalAdTemplate.extra;
        adxAdTemplate.impAdExtra = originalAdTemplate.impAdExtra;
        adxAdTemplate.mAdScene = originalAdTemplate.mAdScene;
        adxAdTemplate.mPcursor = originalAdTemplate.mPcursor;
        adxAdTemplate.mRequestCount = originalAdTemplate.mRequestCount;
        adxAdTemplate.mOutClickTimeParam = originalAdTemplate.mOutClickTimeParam;
        return adxAdTemplate;
    }

    public static CtAdTemplate getOriginalAdTemplate(CtAdTemplate ctAdTemplate) {
        CtAdTemplate ctAdTemplate2 = ctAdTemplate instanceof AdxAdTemplate ? ((AdxAdTemplate) ctAdTemplate).mOriginalAdTemplate : null;
        return ctAdTemplate2 != null ? ctAdTemplate2 : ctAdTemplate;
    }

    public static List<CtAdTemplate> getOriginalAdTemplate(List<CtAdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<CtAdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(getOriginalAdTemplate(it.next()));
        }
        return arrayList;
    }
}
