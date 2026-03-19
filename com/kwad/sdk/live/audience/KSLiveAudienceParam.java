package com.kwad.sdk.live.audience;

import com.kwad.sdk.live.audience.model.KSLivePlayConfig;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLiveAudienceParam {
    public final String liveServiceToken;
    public final String mAnchorId;
    public final String mAppId;
    public final String mBiz;
    public final String mExpTag;
    public final JSONObject mExtraInfoJson;
    public KSLivePlayConfig mLivePlayConfig;
    public final String mReason;
    public final int mSource;
    public long userId;

    public KSLiveAudienceParam(Builder builder) {
        this.mAnchorId = builder.mAnchorId;
        this.mSource = builder.mSource;
        this.mReason = builder.mReason;
        this.mExpTag = builder.mExpTag;
        this.mLivePlayConfig = builder.mLivePlayConfig;
        this.mAppId = builder.mAppId;
        this.mBiz = builder.mBiz;
        this.mExtraInfoJson = builder.mExtraInfoJson;
        this.liveServiceToken = builder.mLiveServiceToken;
        this.userId = builder.mUserId;
        Utils.checkNoNull(this.mAnchorId);
    }

    public static class Builder {
        private String mAnchorId;
        private String mAppId;
        private String mBiz;
        private String mExpTag;
        private JSONObject mExtraInfoJson;
        private KSLivePlayConfig mLivePlayConfig;
        private String mLiveServiceToken;
        private String mReason;
        private int mSource;
        private long mUserId;

        public Builder setAnchorId(String str) {
            this.mAnchorId = str;
            return this;
        }

        public Builder setSource(int i) {
            this.mSource = i;
            return this;
        }

        public Builder setReason(String str) {
            this.mReason = str;
            return this;
        }

        public Builder setExpTag(String str) {
            this.mExpTag = str;
            return this;
        }

        public Builder setLiveServiceToken(String str) {
            this.mLiveServiceToken = str;
            return this;
        }

        public Builder setUserId(long j) {
            this.mUserId = j;
            return this;
        }

        public Builder setLivePlayConfig(KSLivePlayConfig kSLivePlayConfig) {
            this.mLivePlayConfig = kSLivePlayConfig;
            return this;
        }

        public Builder setAppId(String str) {
            this.mAppId = str;
            return this;
        }

        public Builder setBiz(String str) {
            this.mBiz = str;
            return this;
        }

        public Builder setExtraInfoJson(JSONObject jSONObject) {
            this.mExtraInfoJson = jSONObject;
            return this;
        }

        public KSLiveAudienceParam build() {
            return new KSLiveAudienceParam(this);
        }
    }
}
