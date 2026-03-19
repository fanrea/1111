package com.kwad.components.core.request.model;

import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ImpInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = 6229807370051396781L;
    public int action;
    public int adNum;
    public SceneImpl adScene;
    public int adStyle;
    public String backUrl;
    public String comment;
    public long cpmBidFloor;
    public long entryScene;
    public String extraData;
    public int height;
    public long posId;
    public String promoteId;
    public int screenOrientation;
    public String sdkExtraData;
    public URLPackage urlPackage;
    public long userCommRateBuying;
    public long userCommRateSharing;
    public int width;
    public long pageScene = 0;
    public long subPageScene = 0;

    public ImpInfo(SceneImpl sceneImpl) {
        this.adScene = sceneImpl;
        this.posId = sceneImpl.posId;
        this.entryScene = sceneImpl.entryScene;
        this.adNum = sceneImpl.adNum;
        this.action = sceneImpl.action;
        this.width = sceneImpl.width;
        this.height = sceneImpl.height;
        if (sceneImpl.mKsAdLabel != null && sceneImpl.mKsAdLabel.cpmBidFloor != 0) {
            this.cpmBidFloor = sceneImpl.mKsAdLabel.cpmBidFloor;
        }
        this.adStyle = sceneImpl.adStyle;
        if (sceneImpl.urlPackage != null) {
            this.urlPackage = sceneImpl.urlPackage;
        }
        this.promoteId = sceneImpl.promoteId;
        this.comment = sceneImpl.comment;
        this.backUrl = sceneImpl.backUrl;
        this.userCommRateBuying = sceneImpl.userCommRateBuying;
        this.userCommRateSharing = sceneImpl.userCommRateSharing;
        this.screenOrientation = sceneImpl.screenOrientation;
        String rewardCallbackExtraByKey = getRewardCallbackExtraByKey("extraData");
        if (rewardCallbackExtraByKey != null) {
            this.extraData = rewardCallbackExtraByKey;
        }
    }

    public String getRewardCallbackExtraByKey(String str) {
        SceneImpl sceneImpl;
        Map<String, String> rewardCallbackExtraData;
        if (str == null || (sceneImpl = this.adScene) == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
            return null;
        }
        return rewardCallbackExtraData.get(str);
    }

    public AdLabelImpl getAdLabelFromAdScene() {
        SceneImpl sceneImpl = this.adScene;
        if (sceneImpl == null) {
            return null;
        }
        return sceneImpl.mKsAdLabel;
    }
}
