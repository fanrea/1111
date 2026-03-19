package com.kwai.kanas.upload;

import com.kwai.kanas.Kanas;
import com.kwai.kanas.interfaces.KanasConfig;
import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.configs.InitCommonParams;
import com.kwai.middleware.azeroth.network.BaseApiParams;
import com.kwai.middleware.azeroth.utils.TextUtils;
import com.pandora.common.Constants;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class c extends BaseApiParams {
    @Override // com.kwai.middleware.azeroth.network.BaseApiParams, com.kwai.middleware.azeroth.network.AzerothApiParams
    public Map<String, String> getUrlParams() {
        Map<String, String> urlParams = super.getUrlParams();
        KanasConfig config = Kanas.get().getConfig();
        InitCommonParams commonParams = Azeroth.get().getCommonParams();
        urlParams.put("ud", TextUtils.emptyIfNull(commonParams.getUserId()));
        urlParams.put("productName", commonParams.getProductName());
        urlParams.put(Constants.APPLog.DEVICE_ID, TextUtils.emptyIfNull(config.deviceId()));
        urlParams.put("platform", "ANDROID_PHONE");
        return urlParams;
    }
}
