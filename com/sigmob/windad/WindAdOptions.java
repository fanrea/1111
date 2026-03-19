package com.sigmob.windad;

import com.sigmob.sdk.base.utils.m;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindAdOptions {
    private String a;
    private String b;
    private HashMap<String, String> c;
    private WindCustomController d;

    public WindAdOptions(String appId, String appKey) {
        if (m.b(appId)) {
            this.a = appId.trim();
        }
        this.b = appKey;
    }

    public String getAppId() {
        return this.a;
    }

    public String getAppKey() {
        return this.b;
    }

    public WindCustomController getCustomController() {
        return this.d;
    }

    public HashMap<String, String> getExtData() {
        return this.c;
    }

    public WindAdOptions setCustomController(WindCustomController customController) {
        this.d = customController;
        return this;
    }

    public WindAdOptions setExtData(HashMap<String, String> extData) {
        this.c = extData;
        return this;
    }
}
