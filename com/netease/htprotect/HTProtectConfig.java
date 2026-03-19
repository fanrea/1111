package com.netease.htprotect;

import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class HTProtectConfig {
    private String channel;
    private String gameKey;
    private String host;
    private int serverType;
    private String ext_data_str = "";
    private HashMap ext_data = new HashMap();

    public String getExtraData() {
        if (this.ext_data_str.length() != 0) {
            return this.ext_data_str;
        }
        try {
            this.ext_data_str = new JSONObject(this.ext_data).toString();
        } catch (Exception unused) {
            this.ext_data_str = "";
        }
        return this.ext_data_str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setExtraData(String str, String str2) {
        this.ext_data.put(str, str2);
    }

    public void setExtraDataStr(String str) {
        this.ext_data_str = str;
    }

    public void setGameKey(String str) {
        this.gameKey = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setServerType(int i) {
        this.serverType = i;
    }
}
