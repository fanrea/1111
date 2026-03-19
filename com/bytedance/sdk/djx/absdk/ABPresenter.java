package com.bytedance.sdk.djx.absdk;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class ABPresenter {
    private ISettingABConfig mABConfig;
    private JSONObject mSetting;
    private final List<IABDataChangeListener> listeners = new CopyOnWriteArrayList();
    private final ABModel mABModel = new ABModel();
    private final Map<String, JSONObject> mConfig = new ConcurrentHashMap();

    ABPresenter() {
    }

    public void init(ISettingABConfig iSettingABConfig) {
        try {
            this.mABConfig = iSettingABConfig;
            String data = this.mABModel.getData(iSettingABConfig.getUID());
            if (TextUtils.isEmpty(data)) {
                return;
            }
            this.mConfig.put(iSettingABConfig.getUID(), new JSONObject(data));
        } catch (Exception unused) {
        }
    }

    public void refresh(int i, String str) {
        if (i == 1) {
            refreshByABConfig(str);
        } else if (i == 2) {
            refreshBySettings(str);
        }
    }

    private void refreshBySettings(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mSetting = new JSONObject(str).optJSONObject(ICEffectKeys.KEY_IS_IC_EFFECT_AB_CONFIG);
        } catch (Exception unused) {
        }
    }

    private void refreshByABConfig(String str) {
        JSONObject jSONObjectOptJSONObject;
        try {
            ISettingABConfig iSettingABConfig = this.mABConfig;
            if (iSettingABConfig != null) {
                String uid = iSettingABConfig.getUID();
                if (TextUtils.isEmpty(uid)) {
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObjectOptJSONObject2 = new JSONObject(str).optJSONObject("pangle_sp_api");
                        if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("sdk_client")) != null) {
                            this.mConfig.put(uid, jSONObjectOptJSONObject);
                            String string = jSONObjectOptJSONObject.toString();
                            this.mABModel.refresh(uid, string);
                            notifyDataChange(uid, string);
                            return;
                        }
                    } catch (JSONException unused) {
                    }
                }
                this.mConfig.remove(uid);
                this.mABModel.clear(uid);
                notifyDataChange(uid, null);
            }
        } catch (Exception unused2) {
        }
    }

    public <T> T getConfig(String str, T t) {
        String str2;
        JSONObject selectJson;
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] strArrSplit = str.split("\\.");
                if (strArrSplit.length > 0 && (selectJson = getSelectJson((str2 = strArrSplit[strArrSplit.length - 1]), (String[]) Arrays.copyOfRange(strArrSplit, 0, strArrSplit.length - 1))) != null) {
                    return (T) selectJson.opt(str2);
                }
            }
        } catch (Exception unused) {
        }
        return t;
    }

    public JSONObject getAllABConfig() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            ISettingABConfig iSettingABConfig = this.mABConfig;
            if (iSettingABConfig != null && !TextUtils.isEmpty(iSettingABConfig.getUID())) {
                jSONObject.putOpt("user_id", this.mABConfig.getUID());
                JSONObject jSONObject2 = this.mConfig.get(this.mABConfig.getUID());
                if (jSONObject2 != null) {
                    jSONObject.putOpt(ICEffectKeys.KEY_IS_IC_EFFECT_AB_CONFIG, jSONObject2);
                }
            }
            JSONObject jSONObject3 = this.mSetting;
            if (jSONObject3 != null) {
                jSONObject.putOpt(a.v, jSONObject3);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject getSelectJson(String str, String[] strArr) {
        JSONObject jSONObjectFindJson;
        JSONObject jSONObjectFindJson2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = this.mConfig.get(this.mABConfig.getUID());
            if (jSONObject != null && jSONObject.length() > 0 && (jSONObjectFindJson2 = findJson(jSONObject, strArr)) != null) {
                if (jSONObjectFindJson2.has(str)) {
                    return jSONObjectFindJson2;
                }
            }
        } catch (Exception unused) {
        }
        JSONObject jSONObject2 = this.mSetting;
        if (jSONObject2 == null || jSONObject2.length() <= 0 || (jSONObjectFindJson = findJson(this.mSetting, strArr)) == null || !jSONObjectFindJson.has(str)) {
            return null;
        }
        return jSONObjectFindJson;
    }

    private JSONObject findJson(JSONObject jSONObject, String[] strArr) {
        if (jSONObject == null || strArr == null) {
            return null;
        }
        for (String str : strArr) {
            jSONObject = jSONObject.optJSONObject(str);
            if (jSONObject == null) {
                return null;
            }
        }
        return jSONObject;
    }

    public void registerListener(IABDataChangeListener iABDataChangeListener) {
        if (iABDataChangeListener == null || this.listeners.contains(iABDataChangeListener)) {
            return;
        }
        this.listeners.add(iABDataChangeListener);
    }

    public void removeListener(IABDataChangeListener iABDataChangeListener) {
        if (iABDataChangeListener != null) {
            this.listeners.remove(iABDataChangeListener);
        }
    }

    public void notifyDataChange(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        for (IABDataChangeListener iABDataChangeListener : this.listeners) {
            if (iABDataChangeListener != null) {
                iABDataChangeListener.onDataChange(str, str2);
            }
        }
    }
}
