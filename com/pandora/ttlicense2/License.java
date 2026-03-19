package com.pandora.ttlicense2;

import android.util.Base64;
import com.alipay.sdk.m.p.e;
import com.pandora.ttlicense2.utils.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class License {
    private String bundleId;
    private String channel;
    private String fileVersion;
    private String id;
    Module[] modules;
    private String packageName;
    private int type;
    private int version;

    public License() {
    }

    public License(String content) {
        if (content == null) {
            return;
        }
        byte[] bArrDecode = Base64.decode(content, 0);
        if (bArrDecode == null) {
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(new String(bArrDecode));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject == null) {
            return;
        }
        this.id = jSONObject.optString("Id");
        this.version = jSONObject.optInt(e.g);
        this.channel = jSONObject.optString("Channel");
        this.type = jSONObject.optInt("Type");
        this.packageName = jSONObject.optString("PackageName");
        this.fileVersion = jSONObject.optString("FileVersion");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("Modules");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        this.modules = new Module[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            this.modules[i] = new Module((JSONObject) jSONArrayOptJSONArray.opt(i));
        }
    }

    public String getId() {
        return this.id;
    }

    public int getVersion() {
        return this.version;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getType() {
        return this.type;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getBundleId() {
        return this.bundleId;
    }

    public long getFileVersion() {
        return IOUtils.parseLong(this.fileVersion);
    }

    public Module[] getModules() {
        return this.modules;
    }

    public static class Module {
        private String edition;
        private long expireBuffer;
        private long expireTime;
        private Module[] features;
        private String name;
        private long startTime;

        public Module() {
        }

        public Module(JSONObject module) {
            if (module == null) {
                return;
            }
            this.name = module.optString("Name");
            this.startTime = module.optLong("StartTime");
            this.expireTime = module.optLong("ExpireTime");
            this.expireBuffer = module.optLong("ExpireBuffer");
            this.edition = module.optString("Edition");
            JSONArray jSONArrayOptJSONArray = module.optJSONArray("Features");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                return;
            }
            this.features = new Module[jSONArrayOptJSONArray.length()];
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                this.features[i] = new Module((JSONObject) jSONArrayOptJSONArray.opt(i));
            }
        }

        public String getName() {
            return this.name;
        }

        public String getEdition() {
            return this.edition;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public long getExpireTime() {
            return this.expireTime;
        }

        public long getExpireBuffer() {
            return this.expireBuffer;
        }

        public Module[] getFeatures() {
            return this.features;
        }
    }
}
