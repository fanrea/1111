package com.bytedance.sdk.djx.core.business.budrama;

import android.os.SystemClock;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.bytedance.sdk.djx.core.business.SpeedScopeType;
import com.bytedance.sdk.djx.core.business.reporter.DrawReporter;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.vod.DJXPlayerView;
import com.bytedance.sdk.djx.core.vod.util.SRABConfig;
import com.bytedance.sdk.djx.model.DJXDramaUnlockAdMode;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.component.a.a.b;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DramaLog {
    private static final int SPEED_PLAY_1X = 1;
    private String mCategory;
    private Map<String, Object> mCommonParams;
    private int mFreeSet;
    private String mFromCategory;
    private String mFromGid;
    private boolean mHasSendPlay = false;
    private long mSpeedPlayDuration = 0;

    public void setParams(String str, String str2, String str3, Map<String, Object> map) {
        this.mCategory = str;
        this.mFromCategory = str2;
        this.mFromGid = str3;
        this.mCommonParams = map;
    }

    public void setDramaParams(int i) {
        this.mFreeSet = i;
    }

    public void reset() {
        this.mHasSendPlay = false;
    }

    public boolean sendPlayEvent(DramaDetail dramaDetail, boolean z, String str) {
        if (dramaDetail == null || this.mHasSendPlay) {
            return false;
        }
        this.mHasSendPlay = true;
        BLogAgent.build(this.mCategory, z ? ILogConst.E_VIDEO_PLAY : ILogConst.E_VIDEO_PLAY_DRAW, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putString("from_gid", this.mFromGid).putString("class", dramaDetail.getDrama().type).putInt(ILogConst.Keys.KEY_EPISODE, dramaDetail.getIndex()).putString("play_source", str).send();
        return true;
    }

    public void sendPauseEvent(DramaDetail dramaDetail) {
        if (dramaDetail == null) {
            return;
        }
        BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_PAUSE, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putString("from_gid", this.mFromGid).putInt(ILogConst.Keys.KEY_EPISODE, dramaDetail.getIndex()).send();
    }

    public void sendContinueEvent(DramaDetail dramaDetail) {
        if (dramaDetail == null) {
            return;
        }
        BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_CONTINUE, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putString("from_gid", this.mFromGid).putInt(ILogConst.Keys.KEY_EPISODE, dramaDetail.getIndex()).send();
    }

    public boolean sendOverEvent(DramaDetail dramaDetail, boolean z, long j, int i, String str, DJXPlayerView dJXPlayerView) {
        if (dramaDetail == null || !this.mHasSendPlay) {
            return false;
        }
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, z ? ILogConst.E_VIDEO_OVER : ILogConst.E_VIDEO_OVER_DRAW, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putLong("duration", j).putLong(ILogConst.Keys.KEY_PERCENT, i).putString("from_gid", this.mFromGid).putString("class", dramaDetail.getDrama().type).putInt(ILogConst.Keys.KEY_EPISODE, dramaDetail.getIndex()).putString("play_source", str);
        if (dJXPlayerView != null) {
            bLogAgentPutString.putInt("sr_multiple", SRABConfig.abSRMultiple()).putInt("sr_status", dJXPlayerView.isSRMode() ? 1 : 0).putString("sr_err_code", SRABConfig.enableSR() ? dJXPlayerView.getSRErrorMsg() : "-3");
        }
        bLogAgentPutString.send();
        return true;
    }

    public void sendRecVideoDuration(DramaDetail dramaDetail, long j, int i, Map<String, Object> map) {
        if (dramaDetail != null && this.mHasSendPlay) {
            BLogAgent bLogAgentPutLong = BLogAgent.build(this.mCategory, "rec_video_duration", this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString("request_id", dramaDetail.getReqId()).putLong("shortplay_id", dramaDetail.getSkitId()).putLong("duration", j).putLong(ILogConst.Keys.KEY_PERCENT, i).putString("from_gid", this.mFromGid).putString("class", dramaDetail.getDrama().type).putLong("episode_id", dramaDetail.getGroupId()).putInt("provider_id", dramaDetail.getProviderId()).putInt("rank_id", dramaDetail.getRankId()).putLong("channel_id", dramaDetail.getChannelId());
            if (map != null) {
                Object obj = map.get("request_id");
                if (obj instanceof String) {
                    bLogAgentPutLong.putString("source_request_id", (String) obj);
                }
                Object obj2 = map.get("channel_id");
                if (obj2 instanceof Long) {
                    bLogAgentPutLong.putLong("source_channel_id", ((Long) obj2).longValue());
                }
                Object obj3 = map.get("episode_id");
                if (obj3 instanceof Long) {
                    bLogAgentPutLong.putLong("source_episode_id", ((Long) obj3).longValue());
                } else if (obj3 instanceof String) {
                    try {
                        bLogAgentPutLong.putLong("source_episode_id", Long.parseLong((String) obj3));
                    } catch (Exception unused) {
                    }
                }
                Object obj4 = map.get("shortplay_id");
                if (obj4 instanceof Long) {
                    bLogAgentPutLong.putLong("source_shortplay_id", ((Long) obj4).longValue());
                }
            }
            bLogAgentPutLong.send();
        }
    }

    public void sendUnlockEvent(DramaDetail dramaDetail, int i, int i2, DJXDramaUnlockAdMode dJXDramaUnlockAdMode) {
        if (dramaDetail == null) {
            return;
        }
        BLogAgent.build(this.mCategory, ILogConst.E_DRAMA_UNLOCK, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putInt("M_episode", i).putInt("unlock_index", i2).putString(ILogConst.Keys.INTERFACE_TYPE, DJXDramaUnlockAdMode.MODE_COMMON.equals(dJXDramaUnlockAdMode) ? "sdk" : "api").putString("from_gid", this.mFromGid).send();
    }

    public void sendCompleteEvent(DramaDetail dramaDetail, int i) {
        if (dramaDetail == null) {
            return;
        }
        BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_COMPLETE, this.mCommonParams).putString("page_scene", ILogConst.Params.SCENE_PLAY_PAGE).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putString("from_gid", this.mFromGid).putString("class", dramaDetail.getDrama().type).putInt(Config.EXCEPTION_MEMORY_TOTAL, dramaDetail.getSkitTotal()).putInt("unlock_index", i).putInt(ILogConst.Keys.KEY_EPISODE, dramaDetail.getIndex()).send();
    }

    public void sendThumbShow(DramaDetail dramaDetail, long j, long j2, long j3) {
        if (dramaDetail == null) {
            return;
        }
        BLogAgent bLogAgentPutLong = BLogAgent.build(this.mCategory, ILogConst.CLICK_THUMB_SHOW, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString(ILogConst.Keys.KEY_CATEGORY_NAME, DrawReporter.getCategoryName()).putString("position", "detail").putLong(MetricsSQLiteCacheKt.METRICS_START_TIME, j).putLong(MetricsSQLiteCacheKt.METRICS_END_TIME, j2).putLong("duration", j3);
        float f = j * 1.0f;
        if (j3 == 0) {
            j3 = 1;
        }
        bLogAgentPutLong.putLong("progress", Math.min(Float.valueOf((f / j3) * 100.0f).intValue(), 100)).putInt("index", dramaDetail.getIndex()).putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getDrama() != null ? dramaDetail.getDrama().id : 0L).send();
    }

    public void sendSeekBarStopTracking(DramaDetail dramaDetail, long j, long j2) {
        if (dramaDetail == null) {
            return;
        }
        BLogAgent.build(this.mCategory, ILogConst.CLICK_PROGRESS_BAR, this.mCommonParams).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString(ILogConst.Keys.KEY_CATEGORY_NAME, DrawReporter.getCategoryName()).putString("position", "detail").putLong(MetricsSQLiteCacheKt.METRICS_START_TIME, j).putLong(MetricsSQLiteCacheKt.METRICS_END_TIME, j2).putInt("index", dramaDetail.getIndex()).send();
    }

    public void sendCustomAdShow(DramaDetail dramaDetail, String str, boolean z) {
        BLogAgent.build(this.mCategory, ILogConst.E_EXTERNAL_AD_SHOW, null).putString(ILogConst.Keys.INTERFACE_TYPE, "api").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putString("from_gid", this.mFromGid).putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putString("cpm", str).putString("unlock_type", z ? "continuous" : "common").send();
    }

    public void sendCustomAdShowFinish(DramaDetail dramaDetail, long j, DJXDramaUnlockAdMode dJXDramaUnlockAdMode, boolean z) {
        if (j > 0) {
            BLogAgent.build(this.mCategory, ILogConst.E_EXTERNAL_AD_COMPLETE, null).putString(ILogConst.Keys.INTERFACE_TYPE, "api").putLong("action_duration", SystemClock.elapsedRealtime() - j).putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putString("from_gid", this.mFromGid).putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putString("unlock_type", z ? "continuous" : "common").send();
        }
    }

    public void sendCustomAdCheck(DramaDetail dramaDetail, String str, int i, boolean z) {
        BLogAgent.build(this.mCategory, ILogConst.E_EXTERNAL_AD_CHECK, null).putString(ILogConst.Keys.INTERFACE_TYPE, "api").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putString("from_gid", this.mFromGid).putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putString("class_name", str).putInt("visibility_rate", i).putString("unlock_type", z ? "continuous" : "common").send();
    }

    public void sendDrawReq(long j) {
        BLogAgent.build(this.mCategory, ILogConst.E_DRAW_REQ, null).putLong("send_id", j).send();
    }

    public void sendSpeedPlay(float f, DramaDetail dramaDetail, long j, boolean z, SpeedScopeType speedScopeType) {
        BLogAgent bLogAgentPutString = BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_SPEED_PLAY, this.mCommonParams).putString(b.e.a, String.valueOf(f)).putLong("group_id", dramaDetail.getGroupId()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, this.mCategory).putString(ILogConst.Keys.KEY_ENTER_FROM, getEnterFrom(this.mFromCategory)).putString("position", "detail").putString(g.o, dramaDetail.getReqId()).putString(ILogConst.Keys.KEY_MODE, "playlet").putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId()).putInt("N_episode", this.mFreeSet).putString("from_gid", this.mFromGid).putInt(ILogConst.Keys.KEY_EPISODE, dramaDetail.getIndex()).putInt("video_duration", dramaDetail.getVideoDuration()).putLong("video_playbackTime", j).putInt("start", z ? 1 : 0).putString("scope", speedScopeType.toString().toLowerCase());
        if (!z && this.mSpeedPlayDuration != 0) {
            bLogAgentPutString.putLong("speed_play_duration", System.currentTimeMillis() - this.mSpeedPlayDuration);
            this.mSpeedPlayDuration = 0L;
        }
        if (z) {
            this.mSpeedPlayDuration = System.currentTimeMillis();
        }
        bLogAgentPutString.send();
    }

    public void sendGlobalSpeed(float f) {
        BLogAgent.build(this.mCategory, ILogConst.E_VIDEO_SPEED_PLAY, this.mCommonParams).putString(b.e.a, String.valueOf(f)).putString("scope", "global").send();
    }

    private String getEnterFrom(String str) {
        str.hashCode();
        switch (str) {
            case "my_history":
                return ILogConst.FROM_DRAMA_MY_HISTORY;
            case "mixed_feed":
                return ILogConst.FROM_DRAW_DRAMA_MIXED_CATEGORY;
            case "skit_banner":
                return ILogConst.FROM_EXTERNAL_DRAMA_CARD;
            case "skit_home_history":
                return ILogConst.FROM_DRAMA_HISTORY;
            case "skit_mixed_feed":
                return ILogConst.FROM_DRAMA_CATEGORY;
            default:
                return ILogConst.FROM_CATEGORY;
        }
    }
}
