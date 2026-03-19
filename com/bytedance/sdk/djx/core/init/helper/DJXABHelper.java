package com.bytedance.sdk.djx.core.init.helper;

import com.bytedance.sdk.djx.absdk.EMABManager;
import com.bytedance.sdk.djx.absdk.ISettingABConfig;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.model.ev.BETokenUpdate;
import com.bytedance.sdk.djx.net.token.TokenHelper;
import com.bytedance.sdk.djx.setting.OnSettingsUpdateListener;
import com.bytedance.sdk.djx.setting.SettingsHelper;
import com.bytedance.sdk.djx.utils.bus.BusEvent;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.bytedance.sdk.djx.utils.bus.IBusListener;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXABHelper {
    public static void init() {
        DJXBus.getInstance().addListener(new IBusListener() { // from class: com.bytedance.sdk.djx.core.init.helper.DJXABHelper.1
            public void onBusEvent(BusEvent busEvent) {
                if (busEvent instanceof BETokenUpdate) {
                    SettingsHelper.loadSettings(true);
                }
            }
        });
        SettingsHelper.registerListener(new OnSettingsUpdateListener() { // from class: com.bytedance.sdk.djx.core.init.helper.DJXABHelper.2
            public void onSettingsUpdate(boolean z, JSONObject jSONObject) {
                try {
                    EMABManager.getInstance().refresh(2, jSONObject.toString());
                } catch (Exception unused) {
                }
            }
        });
        EMABManager.getInstance().init(new ISettingABConfig() { // from class: com.bytedance.sdk.djx.core.init.helper.DJXABHelper.3
            @Override // com.bytedance.sdk.djx.absdk.ISettingABConfig
            public String getSpName() {
                return "djxsdk_setting_cfg";
            }

            @Override // com.bytedance.sdk.djx.absdk.ISettingABConfig
            public String getAppId() {
                return DevInfo.sAppId;
            }

            @Override // com.bytedance.sdk.djx.absdk.ISettingABConfig
            public String getUID() {
                return TokenHelper.getInstance().getUserId();
            }
        });
    }
}
