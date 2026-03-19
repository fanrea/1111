package com.bytedance.sdk.djx.model;

import com.bytedance.sdk.djx.utils.JSON;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class VideoM {
    private String mDefinition;
    private float mDuration;
    private String mFallbackApi;
    private int mHeight;
    private String mKeySeed;
    private String mMediaType;
    private String mMsg;
    private JSONObject mOriginal;
    private int mStatus;
    private boolean mSupportSsl;
    private String mVideoId;
    private long mVideoSize;
    private int mWidth;

    public boolean isOk() {
        return this.mStatus == 10;
    }

    public JSONObject getOriginal() {
        return this.mOriginal;
    }

    public void setOriginal(JSONObject jSONObject) {
        this.mOriginal = jSONObject;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public String getMsg() {
        return this.mMsg;
    }

    public void setMsg(String str) {
        this.mMsg = str;
    }

    public boolean isSupportSsl() {
        return this.mSupportSsl;
    }

    public void setSupportSsl(boolean z) {
        this.mSupportSsl = z;
    }

    public String getVideoId() {
        return this.mVideoId;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }

    public String getMediaType() {
        return this.mMediaType;
    }

    public void setMediaType(String str) {
        this.mMediaType = str;
    }

    public String getFallbackApi() {
        return this.mFallbackApi;
    }

    public void setFallbackApi(String str) {
        this.mFallbackApi = str;
    }

    public String getKeySeed() {
        return this.mKeySeed;
    }

    public void setKeySeed(String str) {
        this.mKeySeed = str;
    }

    public int getWidth() {
        if (this.mOriginal == null || this.mWidth > 0) {
            return this.mWidth;
        }
        init();
        return this.mWidth;
    }

    public int getHeight() {
        if (this.mOriginal == null || this.mHeight > 0) {
            return this.mHeight;
        }
        init();
        return this.mHeight;
    }

    public long getVideoSize() {
        if (this.mOriginal == null || this.mVideoSize > 0) {
            return this.mVideoSize;
        }
        init();
        return this.mVideoSize;
    }

    public String getDefinition() {
        String str;
        if (this.mOriginal == null || ((str = this.mDefinition) != null && !str.isEmpty())) {
            return this.mDefinition;
        }
        init();
        return this.mDefinition;
    }

    private void init() {
        JSONObject jsonObject;
        JSONObject jSONObject = this.mOriginal;
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jsonObject2 = JSON.getJsonObject(jSONObject, "video_list");
            if (jsonObject2 == null || (jsonObject = JSON.getJsonObject(jsonObject2, "video_1")) == null) {
                return;
            }
            this.mVideoSize = JSON.getLong(jsonObject, "size", 0L);
            this.mWidth = JSON.getInt(jsonObject, "vwidth", 0);
            this.mHeight = JSON.getInt(jsonObject, "vheight", 0);
            this.mDefinition = JSON.getString(jsonObject, "definition", "");
        } catch (Throwable unused) {
        }
    }
}
