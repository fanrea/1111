package com.kwad.components.ct.home.download;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.Serializable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HomeApkBannerData extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -3305476346070314287L;
    public String appPackageName;
    public String mAdTemplateUniqueId;
    public String mDownloadFilePath;
    public long mTimeStamp;

    public static HomeApkBannerData convertAdTemplateToHomeApkBannerData(AdTemplate adTemplate) {
        if (adTemplate == null || !com.kwad.components.ct.response.a.a.eH(adTemplate)) {
            return null;
        }
        HomeApkBannerData homeApkBannerData = new HomeApkBannerData();
        homeApkBannerData.mTimeStamp = System.currentTimeMillis();
        homeApkBannerData.mAdTemplateUniqueId = adTemplate.mUniqueId;
        homeApkBannerData.mDownloadFilePath = com.kwad.components.ct.response.a.a.eP(adTemplate).downloadFilePath;
        homeApkBannerData.appPackageName = com.kwad.sdk.core.response.b.a.aB(com.kwad.components.ct.response.a.a.eP(adTemplate));
        return homeApkBannerData;
    }
}
