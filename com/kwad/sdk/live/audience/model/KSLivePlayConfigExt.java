package com.kwad.sdk.live.audience.model;

import android.text.TextUtils;
import com.kwad.sdk.live.audience.Utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLivePlayConfigExt {
    public static void copyValueFromResponse(KSLivePlayConfig kSLivePlayConfig, KSLivePlayConfig kSLivePlayConfig2) {
        if (!TextUtils.isEmpty(kSLivePlayConfig2.mLiveStreamId)) {
            kSLivePlayConfig.mLiveStreamId = kSLivePlayConfig2.mLiveStreamId;
        }
        if (!TextUtils.isEmpty(kSLivePlayConfig2.mAttach)) {
            kSLivePlayConfig.mAttach = kSLivePlayConfig2.mAttach;
        }
        if (!TextUtils.isEmpty(kSLivePlayConfig2.mLocale)) {
            kSLivePlayConfig.mLocale = kSLivePlayConfig2.mLocale;
        }
        if (!Utils.isEmpty(kSLivePlayConfig2.mSocketHostPorts)) {
            kSLivePlayConfig.mSocketHostPorts.clear();
            kSLivePlayConfig.mSocketHostPorts.addAll(kSLivePlayConfig2.getSocketHostPorts());
        }
        if (kSLivePlayConfig2.mRace != null && kSLivePlayConfig2.mRace != KSLivePlayConfig.DEFAULT_RACE) {
            kSLivePlayConfig.mRace.mStartTime = kSLivePlayConfig2.mRace.mStartTime;
            kSLivePlayConfig.mRace.mCost = kSLivePlayConfig2.mRace.mCost;
            kSLivePlayConfig.mRace.mSuccess = kSLivePlayConfig2.mRace.mSuccess;
            kSLivePlayConfig.mRace.mTag = kSLivePlayConfig2.mRace.mTag;
            if (!Utils.isEmpty(kSLivePlayConfig2.mRace.mRounds)) {
                kSLivePlayConfig.mRace.mRounds.clear();
                kSLivePlayConfig.mRace.mRounds.addAll(kSLivePlayConfig2.mRace.mRounds);
            }
        }
        if (Utils.isEmpty(kSLivePlayConfig2.mPlayUrls)) {
            TextUtils.isEmpty(kSLivePlayConfig2.mLiveManifestJson);
        }
        if (!TextUtils.isEmpty(kSLivePlayConfig2.mLiveManifestJson)) {
            kSLivePlayConfig.mPlayUrls = null;
            kSLivePlayConfig.mLiveManifestJson = kSLivePlayConfig2.mLiveManifestJson;
        } else {
            if (Utils.isEmpty(kSLivePlayConfig2.mPlayUrls)) {
                return;
            }
            kSLivePlayConfig.mPlayUrls.clear();
            kSLivePlayConfig.mPlayUrls.addAll(kSLivePlayConfig2.mPlayUrls);
            kSLivePlayConfig.mLiveManifestJson = null;
        }
    }
}
