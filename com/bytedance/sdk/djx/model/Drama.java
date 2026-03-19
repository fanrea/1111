package com.bytedance.sdk.djx.model;

import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.utils.JSON;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Drama extends DJXDrama {
    public long channelId;
    public int providerId;
    public int rankId;
    public String reqId;
    public boolean visibility;

    public static Drama copy(Drama drama) {
        Drama drama2 = new Drama();
        drama2.id = drama.id;
        drama2.title = drama.title;
        drama2.coverImage = drama.coverImage;
        drama2.coverImages2 = drama.coverImages2;
        drama2.status = drama.status;
        drama2.total = drama.total;
        drama2.index = drama.index;
        drama2.freeSet = drama.freeSet;
        drama2.lockSet = drama.lockSet;
        drama2.unlockIndex = drama.unlockIndex;
        drama2.scriptAuthor = drama.scriptAuthor;
        drama2.scriptName = drama.scriptName;
        drama2.reqId = drama.reqId;
        drama2.actionTime = drama.actionTime;
        drama2.createTime = drama.createTime;
        drama2.visibility = drama.visibility;
        drama2.groupId = drama.groupId;
        drama2.providerId = drama.providerId;
        drama2.channelId = drama.channelId;
        drama2.rankId = drama.rankId;
        drama2.recMap = drama.recMap;
        drama2.episodeStatusList = drama.episodeStatusList;
        drama2.icpNumber = drama.icpNumber;
        drama2.isPotential = drama.isPotential;
        drama2.levelLabel = drama.levelLabel;
        drama2.type = drama.type;
        drama2.typeId = drama.typeId;
        drama2.desc = drama.desc;
        drama2.isFavor = drama.isFavor;
        drama2.favoriteTime = drama.favoriteTime;
        drama2.favoriteCount = drama.favoriteCount;
        return drama2;
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObjectBuild = JSON.build();
        try {
            jSONObjectBuild.put("shortplay_id", this.id);
            jSONObjectBuild.put("status", this.status);
            jSONObjectBuild.put(Config.EXCEPTION_MEMORY_TOTAL, this.total);
            jSONObjectBuild.put("title", this.title);
            jSONObjectBuild.put("cover_image", this.coverImage);
            jSONObjectBuild.put("cover_image_v2s", this.coverImages2);
            jSONObjectBuild.put("lock_free", this.freeSet);
            jSONObjectBuild.put("lock_ad", this.lockSet);
            jSONObjectBuild.put("index", this.index);
            jSONObjectBuild.put("lock_index", this.unlockIndex);
            jSONObjectBuild.put(ILogConst.Keys.KEY_CATEGORY_NAME, this.type);
            jSONObjectBuild.put("category_id", this.typeId);
            jSONObjectBuild.put(RemoteRewardActivity.JSON_BANNER_DESC_ID, this.desc);
            jSONObjectBuild.put("source_novel_author", this.scriptAuthor);
            jSONObjectBuild.put("source_novel_name", this.scriptName);
            jSONObjectBuild.put("action_time", this.actionTime);
            jSONObjectBuild.put("create_time", this.createTime);
            jSONObjectBuild.put("visibility", this.visibility);
            jSONObjectBuild.put("episode_id", this.groupId);
            jSONObjectBuild.put("provider_id", this.providerId);
            jSONObjectBuild.put("channel_id", this.channelId);
            jSONObjectBuild.put("rank_id", this.rankId);
            jSONObjectBuild.put("request_id", this.reqId);
            jSONObjectBuild.put("episode_status_list", this.episodeStatusList);
            jSONObjectBuild.put(NativeUnifiedADAppInfoImpl.Keys.ICP_NUMBER, this.icpNumber);
            jSONObjectBuild.put("is_potential", this.isPotential);
            jSONObjectBuild.put("level_label", this.levelLabel);
            jSONObjectBuild.put("favorite_state", this.isFavor);
            jSONObjectBuild.put("favorite_time", this.favoriteTime);
            jSONObjectBuild.put("favorite_count", this.favoriteCount);
            return jSONObjectBuild;
        } catch (JSONException unused) {
            return null;
        }
    }

    public Map<String, Object> toMap() {
        HashMap map = new HashMap();
        map.put("drama_id", Long.valueOf(this.id));
        map.put("title", this.title);
        map.put("index", Integer.valueOf(this.index));
        map.put("status", Integer.valueOf(this.status));
        map.put(Config.EXCEPTION_MEMORY_TOTAL, Integer.valueOf(this.total));
        map.put("cover_image", this.coverImage);
        map.put("type", this.type);
        map.put(RemoteRewardActivity.JSON_BANNER_DESC_ID, this.desc);
        map.put("script_author", this.scriptAuthor);
        map.put("script_name", this.scriptName);
        map.put("create_time", Long.valueOf(this.createTime));
        map.put("action_time", Long.valueOf(this.actionTime));
        map.put("visibility", Boolean.valueOf(this.visibility));
        map.put("group_id", Long.valueOf(this.groupId));
        map.put("provider_id", Integer.valueOf(this.providerId));
        map.put("channel_id", Long.valueOf(this.channelId));
        map.put("rank_id", Integer.valueOf(this.rankId));
        map.put("unlock_index", Integer.valueOf(this.unlockIndex));
        map.put("episode_status_list", this.episodeStatusList);
        map.put(NativeUnifiedADAppInfoImpl.Keys.ICP_NUMBER, this.icpNumber);
        return map;
    }

    @Override // com.bytedance.sdk.djx.model.DJXDrama
    public String toString() {
        return "Drama{freeSet=" + this.freeSet + ", lockSet=" + this.lockSet + ", reqId='" + this.reqId + "', groupId=" + this.groupId + ", providerId=" + this.providerId + ", channelId=" + this.channelId + ", rankId=" + this.rankId + ", visibility=" + this.visibility + ", id=" + this.id + ", title='" + this.title + "', coverImage='" + this.coverImage + "', coverImages2='" + this.coverImages2 + "', status=" + this.status + ", total=" + this.total + ", index=" + this.index + ", type='" + this.type + "', typeId=" + this.typeId + ", desc='" + this.desc + "', scriptName='" + this.scriptName + "', scriptAuthor='" + this.scriptAuthor + "', createTime=" + this.createTime + "', actionTime=" + this.actionTime + "', unlockIndex=" + this.unlockIndex + "', episodeStatuses=" + this.episodeStatusList + "', icpNumber=" + this.icpNumber + '}';
    }

    public boolean equal(Drama drama) {
        return drama != null && this.id == drama.id;
    }
}
