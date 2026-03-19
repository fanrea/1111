package com.bytedance.sdk.djx.core.api.req;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobads.container.util.cm;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.core.api.ApiUrl;
import com.bytedance.sdk.djx.core.api.log.NetLog;
import com.bytedance.sdk.djx.core.api.rsp.FeedRsp;
import com.bytedance.sdk.djx.core.business.ad.IDJXAd;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.util.AntiFraudManager;
import com.bytedance.sdk.djx.core.util.FeedSurveyManager;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.model.Image;
import com.bytedance.sdk.djx.model.Music;
import com.bytedance.sdk.djx.model.Video;
import com.bytedance.sdk.djx.model.VideoM;
import com.bytedance.sdk.djx.model.VideoUrl;
import com.bytedance.sdk.djx.net.NetClient;
import com.bytedance.sdk.djx.net.RequestLogUtil;
import com.bytedance.sdk.djx.net.api.ErrCode;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.net.cb.NetCallback;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.bytedance.sdk.djx.net.req.NetBuilder;
import com.bytedance.sdk.djx.net.req.NetResponse;
import com.bytedance.sdk.djx.setting.SettingsHelper;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetUtils;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.SP;
import com.bytedance.sdk.djx.utils.UIUtil;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.sigmob.sdk.base.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class FeedApi {
    public static final String CATEGORY_DRAW = "hotsoon_video_detail_draw";
    public static final String CATEGORY_GRID = "hotsoon_video";
    private static final int TYPE_FEED = 0;
    private static final Handler sHandler = new Handler(Looper.getMainLooper());
    private static int mLoadCount = 0;

    public static void loadFeed(final IApiCallback<FeedRsp> iApiCallback, final FeedReqParams feedReqParams, final Map<String, Object> map) {
        if (!NetworkUtils.isActive(InnerManager.getContext())) {
            NetLog.feedResultFail(feedReqParams, 0L, null, -4, ErrCode.msg(-4), null, map);
            sHandler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.djx.core.api.req.FeedApi.1
                @Override // java.lang.Runnable
                public void run() {
                    IApiCallback iApiCallback2 = iApiCallback;
                    if (iApiCallback2 != null) {
                        iApiCallback2.onApiFailure(DJXError.build(-4, ErrCode.msg(-4)), null);
                    }
                }
            }, 500L);
        } else {
            SettingsHelper.loadSettings();
            NetLog.feedStart(feedReqParams, map);
            String strFeed = ApiUrl.feed();
            NetClient.post().url(strFeed).addHeader("Content-Type", MediaTypeUtils.APPLICATION_FORM).params(buildParams(strFeed, feedReqParams, 0, map)).go(new NetCallback<String>() { // from class: com.bytedance.sdk.djx.core.api.req.FeedApi.2
                @Override // com.bytedance.sdk.djx.net.cb.NetCallback
                public void onNetError(NetBuilder netBuilder, int i, String str, Throwable th) {
                    NetLog.feedResultFail(feedReqParams, SystemClock.elapsedRealtime() - this.mStartTime, null, i, str, th, map);
                    if (iApiCallback != null) {
                        DJXError dJXErrorBuild = DJXError.build(i, str);
                        NetUtils.injectReqId(dJXErrorBuild, netBuilder.mResponseHeaders);
                        iApiCallback.onApiFailure(dJXErrorBuild, null);
                    }
                }

                @Override // com.bytedance.sdk.djx.net.cb.NetCallback
                public void onNetSuccess(NetBuilder netBuilder, NetResponse<String> netResponse) {
                    Throwable th;
                    String str;
                    FeedRsp feedRsp;
                    String requestId;
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    try {
                        feedRsp = FeedApi.parse(feedReqParams.mPreload || feedReqParams.mCached, JSON.build(netResponse.data));
                        feedRsp.setOriginal(netResponse.data);
                        requestId = feedRsp.getRequestId();
                    } catch (Throwable th2) {
                        th = th2;
                        str = null;
                    }
                    try {
                        RequestLogUtil.sendRequestBeanParseLog("FeedRsp", SystemClock.elapsedRealtime() - jElapsedRealtime2);
                        if (feedRsp.isOk()) {
                            if (feedRsp.getExtra().getAdMode() > -1) {
                                SettingData.getInstance().setMixAdLogic(feedRsp.getExtra().getAdMode());
                            }
                            if (feedRsp.getExtra().getAdModeNews() > -1) {
                                SettingData.getInstance().setNewsMixAdLogic(feedRsp.getExtra().getAdModeNews());
                            }
                            NetLog.feedResultSuccess(feedReqParams, jElapsedRealtime, requestId, feedRsp, map);
                            IApiCallback iApiCallback2 = iApiCallback;
                            if (iApiCallback2 != null) {
                                iApiCallback2.onApiSuccess(feedRsp);
                                return;
                            }
                            return;
                        }
                        int code = feedRsp.getCode();
                        String msg = feedRsp.getMsg();
                        if (TextUtils.isEmpty(msg)) {
                            msg = ErrCode.msg(code);
                        }
                        NetLog.feedResultFail(feedReqParams, jElapsedRealtime, requestId, code, msg, null, map);
                        if (iApiCallback != null) {
                            DJXError dJXError = feedRsp.toDJXError();
                            NetUtils.injectReqId(dJXError, netBuilder.mResponseHeaders);
                            iApiCallback.onApiFailure(dJXError, feedRsp);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = requestId;
                        LG.e("FeedApi", "callback error", th);
                        NetLog.feedResultFail(feedReqParams, jElapsedRealtime, str, -2, ErrCode.msg(-2), th, map);
                        IApiCallback iApiCallback3 = iApiCallback;
                        if (iApiCallback3 != null) {
                            iApiCallback3.onApiFailure(DJXError.build(-2, ErrCode.msg(-2)), null);
                        }
                    }
                }
            });
        }
    }

    private static Map<String, String> buildParams(String str, FeedReqParams feedReqParams, int i, Map<String, Object> map) {
        HashMap map2 = new HashMap(NetClient.getCommonParams());
        String featureValues = getFeatureValues(feedReqParams.mCategory, feedReqParams.mDrawType);
        map2.put("need_video_model", "1");
        map2.put("urge_stay", feedReqParams.mUrgeStay);
        map2.put("category", feedReqParams.mCategory);
        if (featureValues.contains("skit") && str != null && str.equals(ApiUrl.feed())) {
            map2.put("lock_free", String.valueOf(feedReqParams.mDramaFree));
            if ("skit_only".equals(featureValues) && feedReqParams.mTopDramaId > 0) {
                map2.put("top_shortplay_id", String.valueOf(feedReqParams.mTopDramaId));
            }
        }
        map2.put("allow_stick", "1");
        map2.put("is_fake", AntiFraudManager.getInstance().isBlock() ? "1" : "0");
        map2.put("sdk_new_user", DevInfo.sIsNewUser ? "1" : "0");
        map2.put("alive_seconds", String.valueOf(DevInfo.sAliveSeconds));
        if (!TextUtils.isEmpty(feedReqParams.mPushGroupId)) {
            map2.put("group_ids", feedReqParams.mPushGroupId);
        }
        if (feedReqParams.mPreload) {
            map2.put("is_preload", "1");
            map2.put("custom_count", "1");
        }
        if (!TextUtils.isEmpty(feedReqParams.mReqType)) {
            map2.put("request_type", feedReqParams.mReqType);
        }
        if (!TextUtils.isEmpty(feedReqParams.mAdToken)) {
            map2.put("union_ad_req", feedReqParams.mAdToken);
        }
        if (!TextUtils.isEmpty(feedReqParams.mAdTokenHalfScreenInterstitial)) {
            map2.put("half_interstitial_ad_req", feedReqParams.mAdTokenHalfScreenInterstitial);
        }
        if (!TextUtils.isEmpty(feedReqParams.mAdTokenFullScreenInterstitial)) {
            map2.put("full_interstitial_ad_req", feedReqParams.mAdTokenFullScreenInterstitial);
        }
        if (!TextUtils.isEmpty(feedReqParams.mAdTokenPostIt)) {
            map2.put("post_it_interstitial_ad_req", feedReqParams.mAdTokenPostIt);
        }
        if (!TextUtils.isEmpty(feedReqParams.mAdPreloadIds)) {
            map2.put("pre_gids", feedReqParams.mAdPreloadIds);
        }
        if (!TextUtils.isEmpty(feedReqParams.mSkipAdUnion)) {
            map2.put("skip_ad_union", feedReqParams.mSkipAdUnion);
        }
        map2.put("is_cache_update", feedReqParams.mCached ? "1" : "0");
        if (!TextUtils.isEmpty(featureValues)) {
            map2.put("featureValues", featureValues);
        }
        if (i == 0 && !feedReqParams.mPreload && feedReqParams.mAdRefresh != null) {
            map2.put("page", feedReqParams.mAdRefresh.mRefreshPage + "");
            map2.put("refresh_request_id", feedReqParams.mAdRefresh.mRefreshReqId);
            map2.put("displayed_data_count", feedReqParams.mAdRefresh.mRefreshDataCount + "");
            map2.put("last_ads_pos", feedReqParams.mAdRefresh.mRefreshAdPos);
        }
        if (feedReqParams.mWidth > 0.0f && feedReqParams.mHeight > 0.0f) {
            map2.put("screen_width", String.valueOf(UIUtil.dp2px(feedReqParams.mWidth)));
            map2.put("screen_height", String.valueOf(UIUtil.dp2px(feedReqParams.mHeight)));
        }
        if (map != null && "outside".equals(map.get(BLogAgent.PARAM_END_TYPE))) {
            map2.put("is_outter", String.valueOf(1));
        } else {
            map2.put("is_outter", String.valueOf(0));
        }
        if (feedReqParams.mRootGid > 0) {
            map2.put("root_gid", String.valueOf(feedReqParams.mRootGid));
            map2.put("impr_count_from_root_gid", String.valueOf(feedReqParams.mRootGidPage));
        }
        if (feedReqParams.mRefreshCounter > 0) {
            map2.put("session_refresh_id", String.valueOf(feedReqParams.mRefreshCounter));
        }
        if (DevInfo.sDisableABTest && ApiUrl.feed().equals(str)) {
            map2.put("disable_abtest", "1");
        }
        String qExtraString = FeedSurveyManager.getInstance().getQExtraString();
        if (!TextUtils.isEmpty(qExtraString)) {
            map2.put("q_extra", qExtraString);
        }
        String cliQExtraString = FeedSurveyManager.getInstance().getCliQExtraString();
        if (!TextUtils.isEmpty(cliQExtraString)) {
            map2.put("cli_q_extra", cliQExtraString);
        }
        int i2 = mLoadCount;
        if (i2 < 2) {
            mLoadCount = i2 + 1;
            if (DevInfo.sInterestType >= 1 && DevInfo.sInterestType <= 29 && DevInfo.sInterestType != 15 && DevInfo.sInterestType != 18) {
                map2.put("douyin_tag", String.valueOf(DevInfo.sInterestType + 2000));
            }
            boolean z = SP.defaults().getBoolean("firstRefresh", false);
            if (!z) {
                map2.put("first_refresh", "true");
            }
            if (mLoadCount >= 2 && !z) {
                SP.defaults().put("firstRefresh", true);
            }
        }
        return map2;
    }

    public static String getFeatureValues(String str, int i) {
        return ((i & 1) != 0 && "hotsoon_video_detail_draw".equals(str) && i == 1) ? "skit_only" : "";
    }

    public static Map<String, String> getRequestParams(FeedReqParams feedReqParams) {
        return buildParams(null, feedReqParams, 0, null);
    }

    public static FeedRsp parse(JSONObject jSONObject) {
        return parse(false, jSONObject);
    }

    public static FeedRsp parse(boolean z, JSONObject jSONObject) {
        FeedRsp feedRsp = new FeedRsp();
        feedRsp.parseComm(jSONObject);
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "data");
        feedRsp.setHasMore(JSON.getBoolean(jsonObject, "has_more", true));
        feedRsp.setWorksCount(JSON.getInt(jsonObject, "video_count"));
        feedRsp.setFavouriteCursor(JSON.getInt(jsonObject, "cursor"));
        feedRsp.setData(new ArrayList());
        JSONArray jsonArray = JSON.getJsonArray(jsonObject, "list");
        if (z) {
            feedRsp.setPreloadData(jsonArray);
        }
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                Feed feed = parseFeed(jsonArray.optJSONObject(i));
                feed.setReqId(feedRsp.getRequestId());
                feed.setAdShakeCoverShow(feedRsp.getExtra().getAdShakeCoverShow());
                if (feed.getDrama() != null) {
                    feed.getDrama().reqId = feedRsp.getRequestId();
                    feed.getDrama().recMap.put("request_id", feedRsp.getRequestId());
                }
                feedRsp.getData().add(feed);
            }
        }
        return feedRsp;
    }

    public static Feed parseFeed(JSONObject jSONObject) {
        Feed feed = new Feed();
        feed.setOriginal(jSONObject);
        try {
            feed.setGroupId(Long.valueOf(JSON.getString(jSONObject, "episode_id")).longValue());
            feed.setItemId(feed.getGroupId());
        } catch (Throwable unused) {
        }
        feed.setVideoId(JSON.getString(jSONObject, PointParamKey.VID));
        feed.setGroupSource(JSON.getInt(jSONObject, "group_source"));
        feed.setTag(JSON.getString(jSONObject, "tag"));
        feed.setTitle(JSON.getString(jSONObject, "title"));
        feed.setSource(JSON.getString(jSONObject, n.l));
        feed.setArticleUrl(JSON.getString(jSONObject, "article_url"));
        feed.setDelete(JSON.getBoolean(jSONObject, "is_delete", false));
        feed.setPublishTime(JSON.getLong(jSONObject, "publish_time"));
        feed.setBehotTime(JSON.getLong(jSONObject, "behot_time"));
        feed.setAbstract(JSON.getString(jSONObject, "abstract"));
        feed.setShareUrl(JSON.getString(jSONObject, "share_url"));
        feed.setShareCount(JSON.getInt(jSONObject, "share_count"));
        feed.setHasVideo(JSON.getBoolean(jSONObject, "has_video"));
        feed.setVideoWatchCount(JSON.getInt(jSONObject, "video_watch_count"));
        feed.setVideoDuration(JSON.getInt(jSONObject, "video_duration"));
        feed.setTip(JSON.getInt(jSONObject, "tip"));
        feed.setLabel(JSON.getString(jSONObject, "label"));
        feed.setDiggCount(JSON.getInt(jSONObject, "digg_count"));
        feed.setBuryCount(JSON.getInt(jSONObject, "bury_count"));
        feed.setCommentCount(JSON.getInt(jSONObject, "comment_count"));
        feed.setCommentUrl(JSON.getString(jSONObject, "comment_url"));
        feed.setCoverMode(JSON.getInt(jSONObject, "cover_mode"));
        feed.setCategory(JSON.getInt(jSONObject, "category", 0));
        feed.setCategoryName(JSON.getString(jSONObject, ILogConst.Keys.KEY_CATEGORY_NAME));
        feed.setFirstFramePoster(JSON.getString(jSONObject, "first_frame_poster"));
        feed.setCellType(JSON.getInt(jSONObject, "cell_type", -1));
        feed.setStick(JSON.getBoolean(jSONObject, "is_stick", false));
        feed.setExtra(JSON.getString(jSONObject, "extra"));
        feed.setVideoSearchSuggestWord(JSON.getString(jSONObject, "search_suggest_word"));
        feed.setVideoSearchUrl(JSON.getString(jSONObject, "search_url"));
        feed.setPlatformSource(JSON.getInt(jSONObject, "platform_source", 0));
        JSONArray jsonArray = JSON.getJsonArray(jSONObject, "cover_image_list");
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                feed.addCoverImage(parseImage(jsonArray.optJSONObject(i)));
            }
        }
        feed.setVideo(parseVideo(JSON.getJsonObject(jSONObject, "video_detail")));
        feed.setVideoModel(parseVideoModel(JSON.getJsonObject(jSONObject, "video_model")));
        feed.setMusic(parseMusic(JSON.getJsonObject(jSONObject, "music")));
        feed.setAdId(JSON.getString(jSONObject, IDJXAd.AD_CODE_ID, (String) null));
        feed.setCid(JSON.getString(jSONObject, g.s, (String) null));
        feed.setAdMeta(JSON.getString(jSONObject, "adm", (String) null));
        feed.setAdRankScore(Double.valueOf(JSON.getDouble(jSONObject, "rank_score", 0.0d)).floatValue());
        feed.setAdType(JSON.getInt(jSONObject, "ad_type", 0));
        feed.setDramaDetail(parseDramaDetail(jSONObject));
        return feed;
    }

    private static Music parseMusic(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Music music = new Music();
        music.setAlbumCover(JSON.getString(jSONObject, "album_cover"));
        music.setAuthorName(JSON.getString(jSONObject, "author"));
        music.setTitle(JSON.getString(jSONObject, "title"));
        music.setMusicId(Long.valueOf(JSON.getString(jSONObject, "music_id")).longValue());
        return music;
    }

    public static VideoM parseVideoModel(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        VideoM videoM = new VideoM();
        videoM.setOriginal(jSONObject);
        videoM.setStatus(JSON.getInt(jSONObject, "status"));
        videoM.setMsg(JSON.getString(jSONObject, cm.V));
        videoM.setSupportSsl(JSON.getBoolean(jSONObject, "enable_ssl"));
        videoM.setVideoId(JSON.getString(jSONObject, "video_id"));
        videoM.setDuration(Double.valueOf(JSON.getDouble(jSONObject, "video_duration", 0.0d)).floatValue());
        videoM.setMediaType(JSON.getString(jSONObject, "media_type"));
        videoM.setFallbackApi(JSON.getString(jSONObject, "fallback_api"));
        videoM.setKeySeed(JSON.getString(jSONObject, "key_seed"));
        return videoM;
    }

    private static Video parseVideo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Video video = new Video();
        video.setStatus(JSON.getInt(jSONObject, "status"));
        video.setVideoId(JSON.getString(jSONObject, "video_id"));
        video.setPosterUrl(JSON.getString(jSONObject, "poster_url"));
        video.setDuration(Double.valueOf(JSON.getDouble(jSONObject, "video_duration", 0.0d)).floatValue());
        JSONArray jsonArray = JSON.getJsonArray(jSONObject, "video_list");
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jsonArray.optJSONObject(i);
                VideoUrl videoUrl = new VideoUrl();
                videoUrl.setUrl(JSON.getString(jSONObjectOptJSONObject, "main_url"));
                videoUrl.setBackupUrl(JSON.getString(jSONObjectOptJSONObject, "backup_url_1"));
                videoUrl.setFileHash(JSON.getString(jSONObjectOptJSONObject, "file_hash"));
                videoUrl.setSize(JSON.getLong(jSONObjectOptJSONObject, "size"));
                videoUrl.setExpire(JSON.getLong(jSONObjectOptJSONObject, "url_expire"));
                videoUrl.setDefinition(JSON.getString(jSONObjectOptJSONObject, "definition"));
                videoUrl.setVideoType(JSON.getString(jSONObjectOptJSONObject, "vtype"));
                videoUrl.setBitrate(JSON.getInt(jSONObjectOptJSONObject, "bitrate"));
                videoUrl.setWidth(JSON.getInt(jSONObjectOptJSONObject, "vwidth"));
                videoUrl.setHeight(JSON.getInt(jSONObjectOptJSONObject, "vheight"));
                video.addVideoUrl(videoUrl);
            }
        }
        return video;
    }

    private static Image parseImage(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        Image image = new Image();
        image.setUrl(JSON.getString(jSONObject, "url"));
        image.setUri(JSON.getString(jSONObject, ContentProviderManager.PROVIDER_URI));
        image.setWidth(JSON.getInt(jSONObject, "width"));
        image.setHeight(JSON.getInt(jSONObject, "height"));
        JSONArray jsonArray = JSON.getJsonArray(jSONObject, "url_list");
        if (jsonArray != null) {
            int length = jsonArray.length();
            for (int i = 0; i < length; i++) {
                image.addBackupUrl(JSON.getString(jsonArray.optJSONObject(i), "url"));
            }
        }
        return image;
    }

    private static Drama parseDrama(JSONObject jSONObject) {
        if (jSONObject != null) {
            return DramaApi.parseDrama(jSONObject);
        }
        return new Drama();
    }

    private static DramaDetail parseDramaDetail(JSONObject jSONObject) {
        if (jSONObject != null) {
            return DramaApi.parseDramaDetail(jSONObject);
        }
        return new DramaDetail();
    }
}
