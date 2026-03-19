package com.bytedance.sdk.djx.model;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaDetail extends DramaFeed {
    private static final String CELL_TYPE = "cell_type";
    private static final String CHANNEL_ID = "channel_id";
    private static final String DRAW_AD = "draw_ad";
    private static final String EPISODE_ID = "episode_id";
    private static final String FRONT_EPISODE_ID = "front_episode_id";
    private static final String INDEX = "index";
    private static final String LIKE_COUNT = "like_count";
    private static final String LIKE_STATE = "like_state";
    private static final String LIKE_TIME = "like_time";
    private static final String NEXT_RECOMMEND_SHORTPLAY_ID = "next_recommend_shortplay_id";
    private static final String POSTER_IMAGE_V2S = "poster_image_v2s";
    private static final String PROVIDER_ID = "provider_id";
    private static final String RANK_ID = "rank_id";
    private static final String SHORTPLAY_ID = "shortplay_id";
    private static final String STATUS = "status";
    private static final String TITLE = "title";
    private static final String TOTAL = "total";
    private static final String VIDEO_MODEL = "video_model";
    private long mChannelId;
    private Drama mDrama;
    private List<DJXImage> mFirstCovers;
    private long mFrontGroupId;
    private long mGroupId;
    private int mIndex;
    private long mNextGroupId;
    private long mNextRecommendSkitId;
    private int mProviderId;
    private int mRankId;
    private String mReqId;
    private long mSkitId;
    private String mSkitName;
    private int mSkitTotal;
    private int mStatus;
    private VideoM mVideoModel;
    private boolean mIsLiked = false;
    private long mLikeTime = 0;
    private int mLikeCount = 0;

    public Drama getDrama() {
        return this.mDrama;
    }

    public void setDrama(Drama drama) {
        this.mDrama = drama;
    }

    public long getNextRecommendSkitId() {
        return this.mNextRecommendSkitId;
    }

    public void setNextRecommendSkitId(long j) {
        this.mNextRecommendSkitId = j;
    }

    public String getReqId() {
        return this.mReqId;
    }

    public void setReqId(String str) {
        this.mReqId = str;
    }

    public long getSkitId() {
        return this.mSkitId;
    }

    public void setSkitId(long j) {
        this.mSkitId = j;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(long j) {
        this.mGroupId = j;
    }

    public long getNextGroupId() {
        return this.mNextGroupId;
    }

    public void setNextGroupId(long j) {
        this.mNextGroupId = j;
    }

    public long getFrontGroupId() {
        return this.mFrontGroupId;
    }

    public void setFrontGroupId(long j) {
        this.mFrontGroupId = j;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setIndex(int i) {
        this.mIndex = i;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public int getSkitTotal() {
        return this.mSkitTotal;
    }

    public void setSkitTotal(int i) {
        this.mSkitTotal = i;
    }

    public String getSkitName() {
        return this.mSkitName;
    }

    public void setSkitName(String str) {
        this.mSkitName = str;
    }

    public VideoM getVideoModel() {
        return this.mVideoModel;
    }

    public void setVideoModel(VideoM videoM) {
        this.mVideoModel = videoM;
    }

    public int getVideoDuration() {
        VideoM videoM = this.mVideoModel;
        if (videoM != null) {
            return Float.valueOf(videoM.getDuration()).intValue();
        }
        return 0;
    }

    public String getVideoId() {
        VideoM videoM = this.mVideoModel;
        if (videoM != null) {
            return videoM.getVideoId();
        }
        return null;
    }

    public long getVideoSize() {
        VideoM videoM = this.mVideoModel;
        if (videoM == null) {
            return 0L;
        }
        return videoM.getVideoSize();
    }

    public int getProviderId() {
        return this.mProviderId;
    }

    public void setProviderId(int i) {
        this.mProviderId = i;
    }

    public long getChannelId() {
        return this.mChannelId;
    }

    public void setChannelId(long j) {
        this.mChannelId = j;
    }

    public int getRankId() {
        return this.mRankId;
    }

    public void setRankId(int i) {
        this.mRankId = i;
    }

    public boolean isLiked() {
        return this.mIsLiked;
    }

    public void setIsLiked(boolean z) {
        this.mIsLiked = z;
    }

    public long getLikeTime() {
        return this.mLikeTime;
    }

    public void setLikeTime(long j) {
        this.mLikeTime = j;
    }

    public int getLikeCount() {
        return this.mLikeCount;
    }

    public void setLikeCount(int i) {
        this.mLikeCount = i;
    }

    public List<DJXImage> getFirstCovers() {
        return this.mFirstCovers;
    }

    public void setFirstCovers(List<DJXImage> list) {
        this.mFirstCovers = list;
    }

    public void addFirstCover(DJXImage dJXImage) {
        if (dJXImage == null) {
            return;
        }
        if (this.mFirstCovers == null) {
            this.mFirstCovers = new ArrayList();
        }
        this.mFirstCovers.add(dJXImage);
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("group_id", Long.valueOf(this.mGroupId));
        map.put("drama_id", Long.valueOf(this.mSkitId));
        map.put("title", this.mSkitName);
        map.put("index", Integer.valueOf(this.mIndex));
        map.put("status", Integer.valueOf(this.mStatus));
        map.put("total", Integer.valueOf(this.mSkitTotal));
        map.put("video_duration", Integer.valueOf(getVideoDuration()));
        map.put("video_size", Long.valueOf(getVideoSize()));
        if (getVideoModel() != null) {
            map.put("video_width", Integer.valueOf(getVideoModel().getWidth()));
            map.put("video_height", Integer.valueOf(getVideoModel().getHeight()));
        }
        map.put(PROVIDER_ID, Integer.valueOf(this.mProviderId));
        map.put(CHANNEL_ID, Long.valueOf(this.mChannelId));
        map.put(RANK_ID, Integer.valueOf(this.mRankId));
        return map;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SHORTPLAY_ID, this.mSkitId);
            jSONObject.put(EPISODE_ID, this.mGroupId);
            jSONObject.put(NEXT_RECOMMEND_SHORTPLAY_ID, this.mNextGroupId);
            jSONObject.put(FRONT_EPISODE_ID, this.mFrontGroupId);
            jSONObject.put("index", this.mIndex);
            jSONObject.put("status", this.mStatus);
            jSONObject.put("total", this.mSkitTotal);
            jSONObject.put("title", this.mSkitName);
            jSONObject.put(NEXT_RECOMMEND_SHORTPLAY_ID, this.mNextRecommendSkitId);
            jSONObject.put(VIDEO_MODEL, this.mVideoModel.getOriginal());
            jSONObject.put(PROVIDER_ID, this.mProviderId);
            jSONObject.put(RANK_ID, this.mRankId);
            jSONObject.put(CHANNEL_ID, Long.toString(this.mChannelId));
            JSONObject jsonObject = this.mDrama.toJsonObject();
            Iterator<String> itKeys = jsonObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!TextUtils.isEmpty(next) && jSONObject.opt(next) == null) {
                    jSONObject.put(next, jsonObject.opt(next));
                }
            }
            jSONObject.put(DRAW_AD, getIsDrawAd());
            jSONObject.put(CELL_TYPE, getCellType());
            jSONObject.put(LIKE_STATE, this.mIsLiked);
            jSONObject.put(LIKE_TIME, this.mLikeTime);
            jSONObject.put(LIKE_COUNT, this.mLikeCount);
            JSONArray jSONArray = new JSONArray();
            if (this.mFirstCovers != null) {
                for (int i = 0; i < this.mFirstCovers.size(); i++) {
                    jSONArray.put(parseDJXImageToJSONObject(this.mFirstCovers.get(i)));
                }
            }
            jSONObject.put(POSTER_IMAGE_V2S, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject parseDJXImageToJSONObject(DJXImage dJXImage) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("main_url", dJXImage.url);
            jSONObject.put("backup_url", dJXImage.backupUrl);
            jSONObject.put("definition", dJXImage.definition);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
