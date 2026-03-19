package com.bytedance.sdk.djx.core.business.ad;

import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AdKey {
    private String mAdCategory;
    private String mAdSource;
    private String mAdType;
    private String mCategory;
    private String mCodeId;
    private Map<String, Object> mCommonParams;
    private int mHeight;
    private int mParamsCode;
    private int mWidth;
    private int mLoadCount = 1;
    private String mFeatureValues = "";

    public static AdKey obtain() {
        return new AdKey();
    }

    private AdKey() {
    }

    public String getCodeId() {
        return this.mCodeId;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getCategory() {
        return this.mCategory;
    }

    public String getFeatureValues() {
        return this.mFeatureValues;
    }

    public String getCategoryFeature() {
        return this.mCategory + this.mFeatureValues;
    }

    public int getLoadCount() {
        return this.mLoadCount;
    }

    public int getParamsCode() {
        return this.mParamsCode;
    }

    public String getAdType() {
        return this.mAdType;
    }

    public String getAdSource() {
        return this.mAdSource;
    }

    public String getAdCategory() {
        return this.mAdCategory;
    }

    public Map<String, Object> getCommonParams() {
        return this.mCommonParams;
    }

    public AdKey codeId(String str) {
        this.mCodeId = str;
        return this;
    }

    public AdKey width(int i) {
        this.mWidth = i;
        return this;
    }

    public AdKey height(int i) {
        this.mHeight = i;
        return this;
    }

    public AdKey category(String str) {
        this.mCategory = str;
        return this;
    }

    public AdKey featureValues(String str) {
        this.mFeatureValues = str;
        return this;
    }

    public AdKey loadCount(int i) {
        this.mLoadCount = i;
        return this;
    }

    public AdKey paramsCode(int i) {
        this.mParamsCode = i;
        return this;
    }

    public AdKey commonParams(Map<String, Object> map) {
        this.mCommonParams = map;
        return this;
    }

    public AdKey adType(String str) {
        this.mAdType = str;
        return this;
    }

    public AdKey adSource(String str) {
        this.mAdSource = str;
        return this;
    }

    public AdKey adCategory(String str) {
        this.mAdCategory = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdKey)) {
            return false;
        }
        AdKey adKey = (AdKey) obj;
        return this.mWidth == adKey.mWidth && this.mHeight == adKey.mHeight && this.mCodeId.equals(adKey.mCodeId);
    }

    public int hashCode() {
        int iHashCode = 1;
        Object[] objArr = {this.mCodeId, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight)};
        for (int i = 0; i < 3; i++) {
            Object obj = objArr[i];
            iHashCode = (iHashCode * 31) + (obj == null ? 0 : obj.hashCode());
        }
        String str = this.mCategory;
        return str != null ? iHashCode + str.hashCode() : iHashCode;
    }
}
