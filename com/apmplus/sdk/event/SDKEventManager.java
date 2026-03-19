package com.apmplus.sdk.event;

import android.text.TextUtils;
import com.bytedance.framwork.core.apm.SDKMonitor;
import com.bytedance.framwork.core.apm.SDKMonitorUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class SDKEventManager {
    private static final SDKEventManager a = new SDKEventManager();

    public static SDKEventManager getInstance() {
        return a;
    }

    private SDKEventManager() {
    }

    public static void init(SDKEventInitConfig sDKEventInitConfig) throws JSONException {
        if (sDKEventInitConfig == null && TextUtils.isEmpty(sDKEventInitConfig.getAid())) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", sDKEventInitConfig.getAid());
            jSONObject.put("host_aid", sDKEventInitConfig.getHostAid());
            jSONObject.put("channel", sDKEventInitConfig.getChannel());
            jSONObject.put("app_version", sDKEventInitConfig.getAppVersion());
            jSONObject.put("version_code", sDKEventInitConfig.getUpdateVersionCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SDKMonitorUtils.setConfigUrl(sDKEventInitConfig.getAid(), sDKEventInitConfig.getEventRequestUrls());
        SDKMonitorUtils.setDefaultReportUrl(sDKEventInitConfig.getAid(), sDKEventInitConfig.getEventUploadUrls());
        SDKMonitorUtils.initMonitor(sDKEventInitConfig.getContext().getApplicationContext(), sDKEventInitConfig.getAid(), sDKEventInitConfig.getToken(), jSONObject, sDKEventInitConfig.isDebug(), false, new SDKMonitor.IGetExtendParams() { // from class: com.apmplus.sdk.event.SDKEventManager.1
            @Override // com.bytedance.framwork.core.apm.SDKMonitor.IGetExtendParams
            public Map<String, String> getCommonParams() {
                return null;
            }

            @Override // com.bytedance.framwork.core.apm.SDKMonitor.IGetExtendParams
            public String getSessionId() {
                return null;
            }
        }, sDKEventInitConfig.getDynamicParams());
    }

    public static SDKMonitor getSDKMonitor(String str) {
        return SDKMonitorUtils.getInstance(str);
    }
}
