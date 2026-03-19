package com.kwad.components.ct.detail.d;

import com.kwad.components.ct.api.g;
import com.kwad.components.ct.response.a.c;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.response.model.CtPhotoInfo;
import com.kwad.sdk.api.KsContentPage;
import com.kwad.sdk.components.d;
import com.kwad.sdk.utils.al;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    public static KsContentPage.ContentItem m(int i, CtAdTemplate ctAdTemplate) {
        CtPhotoInfo ctPhotoInfoAy = com.kwad.components.ct.response.a.a.ay(ctAdTemplate);
        KsContentPage.ContentItem contentItem = new KsContentPage.ContentItem();
        contentItem.position = i;
        contentItem.id = al.md5(String.valueOf(com.kwad.components.ct.response.a.a.bg(ctAdTemplate)));
        try {
            contentItem.videoDuration = com.kwad.components.ct.response.a.a.aB(ctAdTemplate);
        } catch (Throwable unused) {
        }
        if (com.kwad.components.ct.response.a.a.as(ctAdTemplate)) {
            contentItem.materialType = 1;
        } else if (com.kwad.components.ct.response.a.a.eH(ctAdTemplate)) {
            contentItem.materialType = 2;
        } else if (com.kwad.components.ct.response.a.a.au(ctAdTemplate)) {
            contentItem.materialType = 3;
        } else if (com.kwad.components.ct.response.a.a.aq(ctAdTemplate)) {
            contentItem.materialType = 4;
        } else {
            contentItem.materialType = 0;
        }
        g gVar = (g) d.g(g.class);
        if (gVar != null && c.o(ctPhotoInfoAy)) {
            gVar.a(contentItem, ctPhotoInfoAy);
        }
        return contentItem;
    }
}
