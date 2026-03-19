package com.bytedance.sdk.djx.core.business.budrama.draw;

import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.sdk.djx.core.business.SpeedScopeType;
import com.bytedance.sdk.djx.core.business.reporter.DrawReporter;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.vod.DJXPlayerView;
import com.bytedance.sdk.djx.core.vod.util.SRABConfig;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.Feed;
import com.component.a.a.b;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DrawLog {
    private static final float SPEED_1X = 1.0f;
    private static final String TAG = "DrawLog";
    private String mCategory;
    private Map<String, Object> mCommonParams;
    private String mFeatureValues;
    private boolean mHasSendPlay = false;
    private Long mSpeedPlayDuration = 0L;

    public void setParams(String str, Map<String, Object> map, String str2) {
        this.mCategory = str;
        this.mCommonParams = map;
        this.mFeatureValues = str2;
    }

    public void reset() {
        this.mHasSendPlay = false;
    }

    boolean sendPlayEvent(Feed feed, int i, String str, long j, Drama drama) {
        if (feed == null || this.mHasSendPlay) {
            return false;
        }
        this.mHasSendPlay = true;
        String categoryName = DrawReporter.getCategoryName();
        String enterFrom = DrawReporter.getEnterFrom();
        if (categoryName.equals("hotsoon_video_detail_draw")) {
            if (this.mFeatureValues.equals("skit_only")) {
                categoryName = "skit_mixed_feed";
            } else if (this.mFeatureValues.equals("skit")) {
                categoryName = "mixed_feed";
            }
        }
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_PLAY_DRAW, this.mCommonParams).putString("category_server", feed.getCategoryName()).putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, categoryName).putString(ILogConst.Keys.KEY_ENTER_FROM, enterFrom).putString("position", "detail").putString("video_play_type", str);
        if (!feed.isSplit() && j > 0) {
            bLogAgentPutString.putString("root_id", String.valueOf(j));
            bLogAgentPutString.putString("impr_count_from_root_gid", String.valueOf(feed.getRootGidPage()));
        }
        if (drama != null) {
            bLogAgentPutString.putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, drama.id).putInt("index", drama.index);
        }
        bLogAgentPutString.send();
        return true;
    }

    boolean sendPauseEvent(Feed feed) {
        if (feed == null) {
            return false;
        }
        String categoryName = DrawReporter.getCategoryName();
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_PAUSE, this.mCommonParams).putString("category_server", feed.getCategoryName()).putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, categoryName).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString("position", "detail");
        if (feed.getDrama() != null) {
            bLogAgentPutString.putInt("index", feed.getDrama().index);
        }
        bLogAgentPutString.send();
        return true;
    }

    boolean sendSpeedPlayEvent(float f, Feed feed, long j, boolean z, SpeedScopeType speedScopeType) {
        String categoryName = DrawReporter.getCategoryName();
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_SPEED_PLAY, this.mCommonParams).putString("category_server", feed.getCategoryName()).putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, categoryName).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString("position", "detail").putInt("video_duration", feed.getVideoDuration()).putLong("video_playbackTime", j).putInt("start", z ? 1 : 0).putString("scope", speedScopeType.toString().toLowerCase()).putString(b.e.a, String.valueOf(f));
        if (!z && this.mSpeedPlayDuration.longValue() != 0) {
            bLogAgentPutString.putLong("speed_play_duration", System.currentTimeMillis() - this.mSpeedPlayDuration.longValue());
            this.mSpeedPlayDuration = 0L;
        }
        if (z) {
            this.mSpeedPlayDuration = Long.valueOf(System.currentTimeMillis());
        }
        if (feed.getDrama() != null) {
            bLogAgentPutString.putInt("index", feed.getDrama().index);
        }
        bLogAgentPutString.send();
        return true;
    }

    boolean sendContinueEvent(Feed feed) {
        if (feed == null) {
            return false;
        }
        String categoryName = DrawReporter.getCategoryName();
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_CONTINUE, this.mCommonParams).putString("category_server", feed.getCategoryName()).putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, categoryName).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString("position", "detail");
        if (feed.getDrama() != null) {
            bLogAgentPutString.putInt("index", feed.getDrama().index);
        }
        bLogAgentPutString.send();
        return true;
    }

    boolean sendCompleteEvent(Feed feed, Drama drama) {
        if (feed == null) {
            return false;
        }
        BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_COMPLETE, this.mCommonParams).putString("page_scene", ILogConst.Params.SCENE_DRAW_PAGE).putLong("group_id", feed.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString("position", "detail").putString(g.o, feed.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, drama.id).putString("class", drama.type).putInt(Config.EXCEPTION_MEMORY_TOTAL, drama.total).putInt(ILogConst.Keys.KEY_EPISODE, drama.index).send();
        return true;
    }

    boolean sendOverEvent(Feed feed, int i, long j, int i2, String str, String str2, long j2, Drama drama, DJXPlayerView dJXPlayerView) {
        if (feed == null || !this.mHasSendPlay) {
            return false;
        }
        String categoryName = DrawReporter.getCategoryName();
        String enterFrom = DrawReporter.getEnterFrom();
        if (categoryName.equals("hotsoon_video_detail_draw")) {
            if (this.mFeatureValues.equals("skit_only")) {
                categoryName = "skit_mixed_feed";
            } else if (this.mFeatureValues.equals("skit")) {
                categoryName = "mixed_feed";
            }
        }
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_OVER_DRAW, this.mCommonParams).putString("category_server", feed.getCategoryName()).putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, categoryName).putString(ILogConst.Keys.KEY_ENTER_FROM, enterFrom).putString("position", "detail").putLong("duration", j).putLong(ILogConst.Keys.KEY_PERCENT, i2).putString("video_play_type", str).putString("cache_play_reason", str2);
        if (!feed.isSplit() && j2 > 0) {
            bLogAgentPutString.putString("root_id", String.valueOf(j2));
            bLogAgentPutString.putString("impr_count_from_root_gid", String.valueOf(feed.getRootGidPage()));
        }
        if (dJXPlayerView != null) {
            bLogAgentPutString.putInt("sr_multiple", SRABConfig.abSRMultiple()).putInt("sr_status", dJXPlayerView.isSRMode() ? 1 : 0).putString("sr_err_code", SRABConfig.enableSR() ? dJXPlayerView.getSRErrorMsg() : "-3");
        }
        if (drama != null) {
            bLogAgentPutString.putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, drama.id).putInt("index", drama.index);
        }
        bLogAgentPutString.send();
        return true;
    }

    public boolean sendRecVideoDuration(Drama drama, long j, int i) {
        if (drama == null || !this.mHasSendPlay) {
            return false;
        }
        BLogAgent.build(this.mCategory, "rec_video_duration", this.mCommonParams).putLong("group_id", drama.groupId).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString("request_id", drama.reqId).putLong("shortplay_id", drama.id).putLong("duration", j).putLong(ILogConst.Keys.KEY_PERCENT, i).putString("class", drama.type).putLong("episode_id", drama.groupId).putInt("provider_id", drama.providerId).putInt("rank_id", drama.rankId).putLong("channel_id", drama.channelId).send();
        return true;
    }

    void sendTab2End(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String categoryName = DrawReporter.getCategoryName();
        BLogAgent.build(this.mCategory, ILogConst.E_DRAW_TAB_TO_END, this.mCommonParams).putString(ILogConst.Keys.KEY_CATEGORY_NAME, categoryName).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString("enter_type", str).putString("position", "detail").send();
    }

    void sendEnterYes(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String categoryName = DrawReporter.getCategoryName();
        BLogAgent.build(this.mCategory, "enter_category", this.mCommonParams).putString(ILogConst.Keys.KEY_CATEGORY_NAME, categoryName).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString("enter_type", str).putString("position", "detail").send();
    }

    void sendEnterNo(long j) {
        String categoryName = DrawReporter.getCategoryName();
        BLogAgent.build(this.mCategory, "stay_category", this.mCommonParams).putString(ILogConst.Keys.KEY_CATEGORY_NAME, categoryName).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putLong("stay_time", j).putString("position", "detail").send();
    }

    void sendDelCacheVideo(String str, int i, int i2) {
        if (i2 <= 0) {
            return;
        }
        BLogAgent.build(this.mCategory, ILogConst.E_PRESTRAIN_DELETE, this.mCommonParams).putString("refresh_id", str).putInt("pre_cnt", i).putInt("pre_delete_cnt", i2).send();
    }

    void clickShare(Feed feed) {
        if (feed == null) {
            return;
        }
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, ILogConst.CLICK_SHARE_BUTTON, this.mCommonParams).putString("category_server", feed.getCategoryName()).putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, DrawReporter.getCategoryName()).putString("position", "detail");
        if (feed.getDrama() != null) {
            bLogAgentPutString.putInt("index", feed.getDrama().index);
        }
        bLogAgentPutString.send();
    }

    void clickMenu(String str, Feed feed) {
        if (feed == null) {
            return;
        }
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, str, this.mCommonParams).putString("category_server", feed.getCategoryName()).putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, DrawReporter.getCategoryName()).putString("position", "detail");
        if (feed.getDrama() != null) {
            bLogAgentPutString.putInt("index", feed.getDrama().index);
        }
        bLogAgentPutString.send();
    }

    public void sendThumbShow(Feed feed, long j, long j2, long j3) {
        if (feed == null) {
            return;
        }
        BLogAgent bLogAgentPutLong = BLogAgent.build(this.mCategory, ILogConst.CLICK_THUMB_SHOW, this.mCommonParams).putLong("group_id", feed.getGroupId()).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, DrawReporter.getCategoryName()).putString("position", "detail").putLong(MetricsSQLiteCacheKt.METRICS_START_TIME, j).putLong(MetricsSQLiteCacheKt.METRICS_END_TIME, j2).putLong("duration", j3);
        float f = j * 1.0f;
        if (j3 == 0) {
            j3 = 1;
        }
        bLogAgentPutLong.putLong("progress", Math.min(Float.valueOf((f / j3) * 100.0f).intValue(), 100)).putInt("index", feed.getDramaDetail() != null ? feed.getDramaDetail().getIndex() : 0).putLong(ILogConst.Keys.KEY_SKIT_ID, feed.getDrama() != null ? feed.getDrama().id : 0L).send();
    }

    void sendSeekBarStopTracking(Feed feed, long j, long j2) {
        if (feed == null) {
            return;
        }
        BLogAgent bLogAgentPutLong = BLogAgent.build(this.mCategory, ILogConst.CLICK_PROGRESS_BAR, this.mCommonParams).putLong("group_id", feed.getGroupId()).putLong("item_id", feed.getItemId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, DrawReporter.getCategoryName()).putString("position", "detail").putLong(MetricsSQLiteCacheKt.METRICS_START_TIME, j).putLong(MetricsSQLiteCacheKt.METRICS_END_TIME, j2);
        if (feed.getDrama() != null) {
            bLogAgentPutLong.putInt("index", feed.getDrama().index);
        }
        bLogAgentPutLong.send();
    }

    void pullRefresh() {
        BLogAgent.build(this.mCategory, ILogConst.E_PULL_REFRESH, this.mCommonParams).putString(ILogConst.Keys.KEY_CATEGORY_NAME, DrawReporter.getCategoryName()).putString("position", "detail").send();
    }

    void recShow(String str, Drama drama, float f) {
        BLogAgent.build(str, "rec_show", null).putString(ILogConst.Keys.KEY_CATEGORY_NAME, str).putString("request_id", drama.reqId).putLong("shortplay_id", drama.id).putLong("episode_id", drama.groupId).putInt("index", drama.index).putInt("pct", Math.min(Float.valueOf(f).intValue() * 100, 100)).putInt("provider_id", drama.providerId).putInt("rank_id", drama.rankId).putLong("channel_id", drama.channelId).send();
    }
}
