package com.pandora.common.globalsettings;

import android.text.TextUtils;
import android.util.Log;
import com.pandora.common.utils.TTVideoLog;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FetchSettingsManager {
    private static final String TAG = "FetchSettingsManager";
    private boolean enableSettingsUpdate;

    private FetchSettingsManager() {
        this.enableSettingsUpdate = true;
    }

    private static class FetchGlobalSdkParamsManagerHolder {
        private static final FetchSettingsManager INSTANCE = new FetchSettingsManager();

        private FetchGlobalSdkParamsManagerHolder() {
        }
    }

    public static FetchSettingsManager getInstance() {
        return FetchGlobalSdkParamsManagerHolder.INSTANCE;
    }

    public void setEnableSettingsUpdate(boolean enable) {
        this.enableSettingsUpdate = enable;
    }

    public boolean isEnableSettingsUpdate() {
        return this.enableSettingsUpdate;
    }

    public void fetchSdkParams() {
        if (!this.enableSettingsUpdate) {
            Log.i(TAG, "Ignore fetch sdk parames");
        } else {
            final String str = GlobalSdkParamsUtil.settingURLString();
            new Thread(new Runnable() { // from class: com.pandora.common.globalsettings.FetchSettingsManager.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    String str2 = GlobalSdkParamsUtil.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            if (!jSONObject.has("Result")) {
                                String string = jSONObject.getJSONObject("ResponseMetadata").getJSONObject("Error").toString();
                                Log.e(GlobalSdkParamsUtil.TAG, "result is not exist");
                                TTVideoLog.d(GlobalSdkParamsUtil.TAG, "url=" + str + " error msg=" + string);
                                FetchSettingsManager.this.delayFetchSetting();
                                return;
                            }
                            JSONObject jSONObject2 = (JSONObject) jSONObject.get("Result");
                            if (jSONObject2 == null) {
                                Log.e(GlobalSdkParamsUtil.TAG, "resultObject is null");
                                FetchSettingsManager.this.delayFetchSetting();
                                return;
                            } else {
                                if (GlobalSdkParams.getInstance().setSettings(jSONObject2)) {
                                    return;
                                }
                                FetchSettingsManager.this.delayFetchSetting();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            FetchSettingsManager.this.delayFetchSetting();
                            return;
                        }
                    }
                    Log.e(GlobalSdkParamsUtil.TAG, "response is null or empty");
                    FetchSettingsManager.this.delayFetchSetting();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delayFetchSetting() {
        new Timer().schedule(new TimerTask() { // from class: com.pandora.common.globalsettings.FetchSettingsManager.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                FetchSettingsManager.this.fetchSdkParams();
            }
        }, 5000L);
    }
}
