package com.kwai.middleware.azeroth.model;

import com.kwai.middleware.azeroth.interfaces.JsonAdapter;
import com.kwai.middleware.azeroth.utils.JsonUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class AzerothSdkConfigs implements JsonAdapter<AzerothSdkConfigs>, Serializable {
    private static final String KEY_CONFIG = "config";
    private static final long serialVersionUID = -5039261443980689344L;
    private Config mConfig;

    public Config getConfig() {
        return this.mConfig;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public AzerothSdkConfigs fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            AzerothSdkConfigs azerothSdkConfigs = new AzerothSdkConfigs();
            azerothSdkConfigs.mConfig = (Config) JsonUtils.fromJson(jSONObject, KEY_CONFIG, Config.class);
            return azerothSdkConfigs;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(KEY_CONFIG, JsonUtils.toJson(this.mConfig));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public static class Config implements JsonAdapter<Config>, Serializable {
        private static final String KEY_HOSTS = "hosts";
        private static final long serialVersionUID = -4951326854855563164L;
        private List<String> mHostList;

        public List<String> getHostList() {
            return this.mHostList;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public Config fromJson(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Config config = new Config();
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(KEY_HOSTS);
                if (jSONArrayOptJSONArray != null) {
                    config.mHostList = new ArrayList(jSONArrayOptJSONArray.length());
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        try {
                            config.mHostList.add(jSONArrayOptJSONArray.getString(i));
                        } catch (JSONException unused) {
                        }
                    }
                }
                return config;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.kwai.middleware.azeroth.interfaces.JsonAdapter
        public JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            List<String> list = this.mHostList;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = this.mHostList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                try {
                    jSONObject.put(AzerothSdkConfigs.KEY_CONFIG, jSONArray);
                } catch (JSONException unused) {
                }
            }
            return jSONObject;
        }
    }
}
