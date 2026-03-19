package com.bytedance.sdk.djx.model;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Video {
    private float mDuration;
    private JSONObject mOriginal;
    private String mPosterUrl;
    private int mStatus;
    private String mVideoId;
    private List<VideoUrl> mVideoUrls;

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

    public String getVideoId() {
        return this.mVideoId;
    }

    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    public String getPosterUrl() {
        return this.mPosterUrl;
    }

    public void setPosterUrl(String str) {
        this.mPosterUrl = str;
    }

    public float getDuration() {
        return this.mDuration;
    }

    public void setDuration(float f) {
        this.mDuration = f;
    }

    public List<VideoUrl> getVideoUrls() {
        return this.mVideoUrls;
    }

    public void setVideoUrls(List<VideoUrl> list) {
        this.mVideoUrls = list;
    }

    public void addVideoUrl(VideoUrl videoUrl) {
        if (videoUrl != null) {
            if (this.mVideoUrls == null) {
                this.mVideoUrls = new ArrayList();
            }
            this.mVideoUrls.add(videoUrl);
        }
    }
}
