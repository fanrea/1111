package com.sigmob.windad;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class WindAdRequest {
    protected int a = 1;
    private int b;
    private final String c;
    private String d;
    private String e;
    private Map<String, Object> f;
    private Map<String, Object> g;
    private boolean h;

    protected WindAdRequest(String placementId, String userId, Map<String, Object> options, int adFormat) {
        this.c = placementId;
        this.d = userId;
        this.f = options;
        this.b = adFormat;
    }

    public static boolean isPlacementEmpty(WindAdRequest adRequest) {
        return adRequest == null || TextUtils.isEmpty(adRequest.getPlacementId());
    }

    public int getAdCount() {
        return this.a;
    }

    public int getAdType() {
        return this.b;
    }

    public String getAdxId() {
        Map<String, Object> map = this.g;
        if (map == null) {
            return null;
        }
        Object obj = map.get(WindAds.ADX_ID);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public String getLoadId() {
        Map<String, Object> map = this.g;
        if (map == null) {
            return null;
        }
        Object obj = map.get("loadId");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public Map<String, Object> getOptions() {
        return this.f;
    }

    public String getPlacementId() {
        return this.c;
    }

    public String getUserId() {
        return this.d;
    }

    public boolean hasOptions() {
        return this.f != null;
    }

    public boolean isHalfInterstitial() {
        return this.h;
    }

    public void setAdCount(int adCount) {
        this.a = adCount;
    }

    public void setExtOptions(Map<String, Object> extOptions) {
        this.g = extOptions;
    }

    public void setHalfInterstitial(boolean halfInterstitial) {
        this.h = halfInterstitial;
    }

    public void setOptions(Map<String, Object> options) {
        this.f = options;
    }

    public void setUserId(String userId) {
        this.d = userId;
    }
}
