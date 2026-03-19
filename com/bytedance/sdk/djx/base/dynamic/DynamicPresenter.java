package com.bytedance.sdk.djx.base.dynamic;

import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.djx.base.dynamic.api.DynamicApi;
import com.bytedance.sdk.djx.base.dynamic.api.DynamicRsp;
import com.bytedance.sdk.djx.internal.utils.DJXLogger;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.AdSdkUtils;
import com.bytedance.sdk.djx.utils.DJXThread;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.SP;
import com.bytedance.sdk.djx.utils.SPUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class DynamicPresenter {
    private static final String KEY_DATA = "data";
    private static final String NEW_PLAYER_SDK = "com.pandora.common.env.config.VodConfig";
    private static final String TAG = "DynamicPresenter";
    private static volatile DynamicPresenter sInstance;
    private final Map<String, DynamicModel> mMap = new HashMap();
    private final SPUtils mSPUtils = SP.dynamic();

    public static DynamicPresenter getInstance() {
        if (sInstance == null) {
            synchronized (DynamicPresenter.class) {
                if (sInstance == null) {
                    sInstance = new DynamicPresenter();
                }
            }
        }
        return sInstance;
    }

    private DynamicPresenter() {
        init();
    }

    private void init() {
        JSONObject jSONObjectBuild;
        try {
            String string = this.mSPUtils.getString("data");
            if (TextUtils.isEmpty(string) || (jSONObjectBuild = JSON.build(string)) == null) {
                return;
            }
            Iterator<String> itKeys = jSONObjectBuild.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    DynamicModel model = DynamicApi.parseModel(JSON.getJsonObject(jSONObjectBuild, next));
                    if (!TextUtils.isEmpty(next) && model != null) {
                        this.mMap.put(next, model);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveCache(DynamicRsp dynamicRsp) {
        if (dynamicRsp == null) {
            return;
        }
        try {
            String string = dynamicRsp.getData().toString();
            if (!TextUtils.isEmpty(string)) {
                this.mSPUtils.put("data", string);
            }
            this.mMap.clear();
            this.mMap.putAll(dynamicRsp.getMap());
        } catch (Throwable unused) {
        }
    }

    public DynamicModel getConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mMap.get(str);
    }

    public void update(String[] strArr, final IApiCallback<DynamicRsp> iApiCallback) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        DynamicApi.loadConfig(new IApiCallback<DynamicRsp>() { // from class: com.bytedance.sdk.djx.base.dynamic.DynamicPresenter.1
            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiSuccess(DynamicRsp dynamicRsp) {
                LG.d(DynamicPresenter.TAG, "dynamic api success: " + dynamicRsp.getData().toString());
                DynamicPresenter.this.saveCache(dynamicRsp);
                DynamicModel config = dynamicRsp.getConfig(DynamicManager.getInstance().getDynamicModel().mInitSiteId);
                if (config != null) {
                    DynamicManager.getInstance().setDynamicModel(config);
                    LG.d(DynamicPresenter.TAG, "newest: " + DynamicManager.getInstance().getDynamicModel().toString());
                }
                iApiCallback.onApiSuccess(dynamicRsp);
            }

            @Override // com.bytedance.sdk.djx.net.api.IApiCallback
            public void onApiFailure(DJXError dJXError, DynamicRsp dynamicRsp) {
                LG.d(DynamicPresenter.TAG, "dynamic api failure: " + dJXError);
                iApiCallback.onApiFailure(dJXError, dynamicRsp);
            }
        }, strArr);
    }

    public boolean isNewPlayer() {
        boolean zIsExist = AdSdkUtils.isExist(NEW_PLAYER_SDK);
        LG.i(TAG, "isNewPlayer? " + zIsExist);
        return zIsExist;
    }

    public void checkLicense(DynamicModel dynamicModel) {
        if (dynamicModel.mLicenseModel == null && isNewPlayer()) {
            DJXThread.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.djx.base.dynamic.DynamicPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DJXLogger.DEBUG) {
                        Toast.makeText(InnerManager.getContext(), "配置文件异常，请更新最新配置文件", 0).show();
                    }
                }
            });
        }
    }
}
