package com.tk.component.imageview.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKCDNUrl implements Serializable {
    private static final String CDN = "cdn";
    private static final String IP = "ip";
    private static final String URL = "url";
    private static final String URL_PATTERN = "urlPattern";
    private static final String URL_TYPE = "urlType";
    private static final long serialVersionUID = 8253139331705520143L;
    public String mCdn;
    public Set<Integer> mFeature;
    public Map<String, String> mHeaders;
    private String mIp;
    public boolean mIsFreeTrafficCdn;
    public String mPushCdn;
    public String mUrl;
    private String mUrlPattern;
    public String mUrlType;

    public TKCDNUrl() {
    }

    public TKCDNUrl(String str, String str2, String str3, String str4, boolean z, Set<Integer> set, String str5, String str6, Map<String, String> map) {
        this.mCdn = str;
        this.mUrl = str2;
        this.mUrlType = str5;
        this.mIsFreeTrafficCdn = z;
        this.mFeature = set;
        this.mPushCdn = str6;
        this.mHeaders = map;
        this.mIp = str3;
        this.mUrlPattern = str4;
    }

    public TKCDNUrl(TKCDNUrl tKCDNUrl) {
        if (tKCDNUrl != null) {
            this.mCdn = tKCDNUrl.mCdn;
            this.mUrl = tKCDNUrl.mUrl;
            this.mUrlType = tKCDNUrl.mUrlType;
            this.mIsFreeTrafficCdn = tKCDNUrl.mIsFreeTrafficCdn;
            Set<Integer> set = tKCDNUrl.mFeature;
            if (set != null) {
                this.mFeature = new HashSet(set);
            }
            this.mPushCdn = tKCDNUrl.mPushCdn;
            Map<String, String> map = tKCDNUrl.mHeaders;
            if (map != null) {
                this.mHeaders = new HashMap(map);
            }
            this.mIp = tKCDNUrl.mIp;
            this.mUrlPattern = tKCDNUrl.mUrlPattern;
        }
    }

    public TKCDNUrl(String str, String str2) {
        this.mCdn = str;
        this.mUrl = str2;
    }

    public TKCDNUrl(String str, String str2, boolean z) {
        this.mCdn = str;
        this.mUrl = str2;
        this.mIsFreeTrafficCdn = z;
    }

    public TKCDNUrl(String str, String str2, String str3, String str4) {
        this.mCdn = str;
        this.mUrl = str2;
        this.mIp = str3;
        this.mUrlPattern = str4;
    }

    public TKCDNUrl(String str, String str2, String str3, String str4, String str5) {
        this.mCdn = str;
        this.mUrl = str2;
        this.mIp = str3;
        this.mUrlPattern = str4;
        this.mUrlType = str5;
    }

    public TKCDNUrl(String str, String str2, String str3, String str4, boolean z) {
        this.mCdn = str;
        this.mUrl = str2;
        this.mIp = str3;
        this.mUrlPattern = str4;
        this.mIsFreeTrafficCdn = z;
    }

    public Set<Integer> getFeature() {
        return this.mFeature;
    }

    public void setFeature(Set<Integer> set) {
        this.mFeature = set;
    }

    public String getCdn() {
        return this.mCdn;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getUrlType() {
        return this.mUrlType;
    }

    public boolean isFreeTrafficCdn() {
        return this.mIsFreeTrafficCdn;
    }

    public String getIp() {
        return this.mIp;
    }

    public String getUrlPattern() {
        return this.mUrlPattern;
    }

    public String getPushCdn() {
        return this.mPushCdn;
    }

    public Set<Integer> getFeatures() {
        return this.mFeature;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public String getPath() {
        try {
            return new URL(this.mUrl).getPath();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return this.mUrl;
        }
    }

    public String getSpecialSizeUrl(int i) {
        if (i > 0 && !TextUtils.isEmpty(this.mUrlPattern)) {
            return this.mUrlPattern.replaceAll("\\{[h,w]\\}", String.valueOf(i));
        }
        return getUrl();
    }

    public static List<TKCDNUrl> fromJsonString(String str) {
        try {
            return Arrays.asList(fromJsonArray(new JSONArray(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public static TKCDNUrl[] fromJsonArray(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        int length = jSONArray.length();
        TKCDNUrl[] tKCDNUrlArr = new TKCDNUrl[length];
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            tKCDNUrlArr[i] = new TKCDNUrl(jSONObject.optString("cdn"), jSONObject.optString("url"), jSONObject.optString(IP), jSONObject.optString(URL_PATTERN), jSONObject.optString(URL_TYPE));
        }
        return tKCDNUrlArr;
    }

    public static JSONArray toJsonArray(TKCDNUrl[] tKCDNUrlArr) {
        if (tKCDNUrlArr == null || tKCDNUrlArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (TKCDNUrl tKCDNUrl : tKCDNUrlArr) {
            jSONArray.put(new JSONObject().put("cdn", tKCDNUrl.mCdn).put("url", tKCDNUrl.mUrl).put(IP, tKCDNUrl.mIp).put(URL_PATTERN, tKCDNUrl.mUrlPattern).put(URL_TYPE, tKCDNUrl.mUrlType));
        }
        return jSONArray;
    }
}
