package com.kwad.components.ct.response.model.cached;

import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CacheTemplate extends CtAdTemplate {
    public CacheTemplate(CtAdTemplate ctAdTemplate, SceneImpl sceneImpl) {
        this.posId = ctAdTemplate.posId;
        this.type = ctAdTemplate.type;
        this.contentType = ctAdTemplate.contentType;
        this.realShowType = ctAdTemplate.realShowType;
        this.adInfoList = ctAdTemplate.adInfoList;
        this.photoInfo = ctAdTemplate.photoInfo;
        this.needHide = ctAdTemplate.needHide;
        this.llsid = ctAdTemplate.llsid;
        setShowPosition(ctAdTemplate.getShowPosition());
        this.extra = ctAdTemplate.extra;
        this.impAdExtra = ctAdTemplate.impAdExtra;
        this.mUniqueId = String.valueOf(UUID.randomUUID());
        this.mPvReported = ctAdTemplate.mPvReported;
        this.mContentPvReported = ctAdTemplate.mContentPvReported;
        this.mAdScene = sceneImpl;
        this.mPcursor = ctAdTemplate.mPcursor;
        this.mOriginJString = ctAdTemplate.mOriginJString;
        if (this.mOriginJString == null) {
            this.mOriginJString = ctAdTemplate.toJson().toString();
        }
        this.mRequestCount = ctAdTemplate.mRequestCount;
        this.mOutClickTimeParam = ctAdTemplate.mOutClickTimeParam;
    }
}
