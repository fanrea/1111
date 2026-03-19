package com.alliance.ssp.adapter.tobid.custom;

import android.content.Context;
import android.util.Log;
import com.alliance.ssp.ad.api.SAAllianceAdInitParams;
import com.alliance.ssp.ad.api.SAAllianceAdSdk;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.windmill.sdk.WindMillError;
import com.windmill.sdk.custom.WMCustomAdapterProxy;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class YCustomerProxy extends WMCustomAdapterProxy {
    private static final String TAG = "YCustomerProxy";

    public int baseOnToBidCustomAdapterVersion() {
        return 2;
    }

    public void notifyPrivacyStatusChange() {
    }

    public void initializeADN(Context context, Map<String, Object> map) {
        try {
            String strOptString = new JSONObject((String) map.get(GlobalSetting.CUSTOM_INFO_KEY)).optString("appid");
            Log.i("Adapter", "初始化优推Sdk -- appId：" + strOptString + "--");
            SAAllianceAdSdk.init(strOptString, context, new SAAllianceAdInitParams.Builder().setDebug(true).build());
            callInitSuccess();
        } catch (Exception e) {
            callInitFail(WindMillError.ERROR_AD_ADAPTER_LOAD.getErrorCode(), e.getMessage());
            callInitFail(0, e.getMessage());
        }
    }

    public String getNetworkSdkVersion() {
        return SAAllianceAdSdk.getYouTuiADNSDKVersion();
    }
}
