package com.bytedance.sdk.djx.core.settings;

import com.alipay.sdk.m.u.b;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.Commerce;
import com.bytedance.sdk.djx.model.ContentCfg;
import com.bytedance.sdk.djx.model.FeaturesCfg;
import com.bytedance.sdk.djx.model.LogCfg;
import com.bytedance.sdk.djx.model.VideoCfg;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.VerifierSp;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.texturerender.effect.AbsEffect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class SettingsParser {
    public static VideoCfg parseVideo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        VideoCfg videoCfg = new VideoCfg();
        videoCfg.setHardEncode(JSON.getInt(jSONObject, "hard_encode", 0));
        return videoCfg;
    }

    public static Commerce parseCommerce(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce commerce = new Commerce();
        commerce.setAdSort(parseAdSort(JSON.getJsonObject(jSONObject, "ad_sort")));
        commerce.setAdExpire(JSON.getInt(jSONObject, "ad_expire_min", 60));
        commerce.setAdMode(JSON.getInt(jSONObject, "ad_mode", 0));
        commerce.setAdModeNews(JSON.getInt(jSONObject, "news_ad_mode", 0));
        commerce.setAdVideoPlayer(JSON.getInt(jSONObject, "ad_video_player", 1));
        commerce.setAdRenderMethod(JSON.getInt(jSONObject, "ad_render_method", 2));
        commerce.setAdCoverShow(JSON.getInt(jSONObject, "mask", 1));
        commerce.setAdCoverPlayMode(JSON.getInt(jSONObject, "play_mode", 0));
        commerce.setAdCoverShowTime(JSON.getInt(jSONObject, "mask_show_sec", 2));
        commerce.setInterstitialAwake(JSON.getInt(jSONObject, "interstitial_awake_per", -1));
        commerce.setInterstitialPostAwake(JSON.getInt(jSONObject, "interstitial_post_it_awake_per", -1));
        commerce.setAdHalfScreenInterstitialAwake(JSON.getInt(jSONObject, "draw_halfscreen_interstitial_awake_per", -1));
        commerce.setAdFullScreenInterstitialAwake(JSON.getInt(jSONObject, "draw_fullscreen_interstitial_awake_per", -1));
        commerce.setNewsInsertAwake(JSON.getInt(jSONObject, "news_interstitial_awake_sec", -1));
        commerce.setNewsInsertLoopEnable(JSON.getInt(jSONObject, "news_interstitial_loop", 1));
        commerce.setNewsInsertLoopSec(JSON.getInt(jSONObject, "news_interstitial_sep_sec", 60));
        commerce.setVideoBannerAdLocation(JSON.getInt(jSONObject, "video_banner_location", 0));
        commerce.setVideoBannerAdAwake(JSON.getInt(jSONObject, "video_banner_awake_per", -1));
        commerce.setVideoBannerAdLoopDuration(JSON.getInt(jSONObject, "video_banner_sep_per", 60));
        commerce.setVideoBannerAdCarousel(JSON.getInt(jSONObject, "video_banner_carousel_per", 30));
        commerce.setDrawAdExpress(JSON.getInt(jSONObject, "draw_ad_express", 1));
        commerce.setDrawAdCardExpress(JSON.getInt(jSONObject, "draw_ad_card_express", 1));
        commerce.setDramaDrawCustomOpen(JSON.getBoolean(jSONObject, "ad_drama_draw_custom_open", true));
        commerce.setBannerCustomBoxOpen(JSON.getBoolean(jSONObject, "ad_box_banner_custom_open", true));
        commerce.setBannerCustomDetailOpen(JSON.getBoolean(jSONObject, "ad_detail_banner_custom_open", true));
        commerce.setAdCardStyle(JSON.getInt(jSONObject, "ad_card_style", 0));
        commerce.setAdLearnMoreShow(JSON.getInt(jSONObject, "ad_learn_more_show", 0));
        commerce.setAdLearnMoreHighlight(JSON.getInt(jSONObject, "ad_learn_more_highlight", 7000));
        commerce.setAdMiniCardShow(JSON.getInt(jSONObject, "ad_mini_card_show", 5000));
        commerce.setAdMiniCardHighlight(JSON.getInt(jSONObject, "ad_mini_card_highlight", 7000));
        commerce.setAdLargeCardShow(JSON.getInt(jSONObject, "ad_large_card_show", AVMDLDataLoader.KeyIsFileKeyRule));
        commerce.setAdDurationLimit(JSON.getInt(jSONObject, "ad_duration_limit", AbsEffect.OPTION_EFFECT_FLOAT_SRCROPSIZEU));
        commerce.setAdShakeCoverShow(JSON.getBoolean(jSONObject, "ad_shake_cover_show", false));
        commerce.setAdShakeCoverAppear(JSON.getLong(jSONObject, "ad_shake_cover_appear", b.a));
        commerce.setAdShakeCoverDisappear(JSON.getLong(jSONObject, "ad_shake_cover_disappear", 8000L));
        commerce.setAdShakeAccelerationThreshold(JSON.getInt(jSONObject, "ad_shake_acceleration_threshold", 16));
        commerce.setAdFullScreenClick(JSON.getBoolean(jSONObject, "ad_full_screen_click", false));
        return commerce;
    }

    private static Commerce.AdSort parseAdSort(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce.AdSort adSort = new Commerce.AdSort();
        JSONObject jsonObject = JSON.getJsonObject(jSONObject, "feed_image_mode");
        JSONObject jsonObject2 = JSON.getJsonObject(jSONObject, "suduku");
        JSONObject jsonObject3 = JSON.getJsonObject(jSONObject, "video_double_feed");
        JSONObject jsonObject4 = JSON.getJsonObject(jSONObject, "news");
        JSONObject jsonObject5 = JSON.getJsonObject(jSONObject, "small_video_card");
        JSONObject jsonObject6 = JSON.getJsonObject(jSONObject, "video_detail_related");
        JSONObject jsonObject7 = JSON.getJsonObject(jSONObject, "article_detail_related");
        adSort.setFeedImageMode(parseFeedImageMode(jsonObject));
        adSort.setSuduku(parseSuduku(jsonObject2));
        adSort.setVideoDoubleFeed(parseVideoDoubleFeed(jsonObject3));
        adSort.setNews(parseNews(jsonObject4));
        adSort.setVideoCard(parseVideoCard(jsonObject5));
        adSort.setVideoDetailRelated(parseVideoDetailRelated(jsonObject6));
        adSort.setArticleDetailRelated(parseArticleDetailRelated(jsonObject7));
        return adSort;
    }

    private static Commerce.FeedImageMode parseFeedImageMode(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce.FeedImageMode feedImageMode = new Commerce.FeedImageMode();
        feedImageMode.setFirstAdPos(JSON.getInt(jSONObject, "first_ad_pos", 4));
        feedImageMode.setFollowSep(JSON.getInt(jSONObject, "follow_sep", 5));
        feedImageMode.setFollowAdPos(JSON.getInt(jSONObject, "follow_ad_pos", 5));
        return feedImageMode;
    }

    private static Commerce.Suduku parseSuduku(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce.Suduku suduku = new Commerce.Suduku();
        suduku.setFirstAdPos(JSON.getInt(jSONObject, "first_ad_pos", 4));
        suduku.setFollowSep(JSON.getInt(jSONObject, "follow_sep", 5));
        suduku.setFollowAdPos(JSON.getInt(jSONObject, "follow_ad_pos", 5));
        return suduku;
    }

    private static Commerce.VideoDoubleFeed parseVideoDoubleFeed(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce.VideoDoubleFeed videoDoubleFeed = new Commerce.VideoDoubleFeed();
        videoDoubleFeed.setFirstAdPos(JSON.getInt(jSONObject, "first_ad_pos", 4));
        videoDoubleFeed.setFollowSep(JSON.getInt(jSONObject, "follow_sep", 5));
        videoDoubleFeed.setFollowAdPos(JSON.getInt(jSONObject, "follow_ad_pos", 5));
        return videoDoubleFeed;
    }

    private static Commerce.News parseNews(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce.News news = new Commerce.News();
        news.setFirstAdPos(JSON.getInt(jSONObject, "first_ad_pos", 3));
        news.setFollowSep(JSON.getInt(jSONObject, "follow_sep", 3));
        news.setFollowAdPos(JSON.getInt(jSONObject, "follow_ad_pos", 3));
        return news;
    }

    private static Commerce.VideoCard parseVideoCard(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce.VideoCard videoCard = new Commerce.VideoCard();
        videoCard.setFirstAdPos(JSON.getInt(jSONObject, "first_ad_pos", 4));
        videoCard.setFollowSep(JSON.getInt(jSONObject, "follow_sep", 5));
        videoCard.setFollowAdPos(JSON.getInt(jSONObject, "follow_ad_pos", 5));
        return videoCard;
    }

    private static Commerce.VideoDetailRelated parseVideoDetailRelated(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce.VideoDetailRelated videoDetailRelated = new Commerce.VideoDetailRelated();
        videoDetailRelated.setFirstAdPos(JSON.getInt(jSONObject, "first_ad_pos", 1));
        videoDetailRelated.setFollowSep(JSON.getInt(jSONObject, "follow_sep", 3));
        videoDetailRelated.setFollowAdPos(JSON.getInt(jSONObject, "follow_ad_pos", 3));
        return videoDetailRelated;
    }

    private static Commerce.ArticleDetailRelated parseArticleDetailRelated(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Commerce.ArticleDetailRelated articleDetailRelated = new Commerce.ArticleDetailRelated();
        articleDetailRelated.setFirstAdPos(JSON.getInt(jSONObject, "first_ad_pos", 3));
        articleDetailRelated.setFollowSep(JSON.getInt(jSONObject, "follow_sep", 3));
        articleDetailRelated.setFollowAdPos(JSON.getInt(jSONObject, "follow_ad_pos", 3));
        return articleDetailRelated;
    }

    public static FeaturesCfg parseFeatures(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FeaturesCfg featuresCfg = new FeaturesCfg();
        featuresCfg.setEnableDramaCache(JSON.getInt(jSONObject, "enable_drama_cache_v2", 1));
        featuresCfg.setDidDegrade(JSON.getInt(jSONObject, "sdk_did_degrade", 0));
        featuresCfg.setSeekThumbShow(JSON.getInt(jSONObject, ILogConst.CLICK_THUMB_SHOW, 0));
        featuresCfg.setDramaCacheExpireTime(JSON.getInt(jSONObject, "drama_cache_expire_time_seconds", 518400));
        featuresCfg.setDramaCacheMaxSize(JSON.getInt(jSONObject, "drama_cache_max_size", 100));
        featuresCfg.setEnableLike(JSON.getInt(jSONObject, "enable_like", 1));
        featuresCfg.setEnableComment(JSON.getInt(jSONObject, "enable_comment", 1));
        featuresCfg.setEnableShare(JSON.getInt(jSONObject, "enable_share", 1));
        featuresCfg.setFeedEnableShare(JSON.getInt(jSONObject, "feed_enable_share", 1));
        featuresCfg.setFeedEnableDigg(JSON.getInt(jSONObject, "feed_enable_digg", 1));
        featuresCfg.setFeedEnableFavor(JSON.getInt(jSONObject, "feed_enable_favor", 1));
        featuresCfg.setFeedEnableComment(JSON.getInt(jSONObject, "feed_enable_comment", 1));
        featuresCfg.setEnableSyncHistory(JSON.getInt(jSONObject, "enable_sync_history", 1));
        featuresCfg.setEnableContinuousPlay(JSON.getInt(jSONObject, "enable_continuous_play", 0));
        featuresCfg.setInnerEnterClose(JSON.getInt(jSONObject, "inner_enter_close", 1));
        featuresCfg.setEnableWhiteScreen(JSON.getInt(jSONObject, "enable_white_screen", 0));
        featuresCfg.setEnableWhiteScreenDetail(JSON.getInt(jSONObject, "enable_white_screen_detail", 0));
        featuresCfg.setEnableHomePage(JSON.getInt(jSONObject, "custom_homepage", 1));
        featuresCfg.setEnableMusicTurnTable(JSON.getInt(jSONObject, "custom_music_turntable", 1));
        featuresCfg.setVideoCard14EnterMode(JSON.getInt(jSONObject, "enter_mode", 1));
        featuresCfg.setEnableRedPacket(JSON.getInt(jSONObject, "enable_red_packet", 0));
        featuresCfg.setEnableSearchSuggest(JSON.getInt(jSONObject, "enable_search_suggest", 1));
        featuresCfg.setEnableLiveEntrance(JSON.getInt(jSONObject, "enable_live_entrance", 1));
        featuresCfg.setSwitchCacheTimeout(JSON.getLong(jSONObject, "switch_cache_timeout", b.a));
        featuresCfg.setCacheExpireRandomHours(JSON.getInt(jSONObject, "cache_expire_random_hours", 24));
        featuresCfg.setEnableStickProtectShowAd(JSON.getInt(jSONObject, "enable_stick_protect_show_ad", 1));
        featuresCfg.setEnableShowLikeGuide(JSON.getInt(jSONObject, "enable_new_user_guide", 1) == 1);
        featuresCfg.setEnableShowFollowGuide(JSON.getInt(jSONObject, "enable_follow_guide", 1) == 1);
        featuresCfg.setEnableWriteComment(JSON.getInt(jSONObject, "enable_write_comment", 1) == 1);
        featuresCfg.setMixContinue(JSON.getInt(jSONObject, "mix_continue", 0));
        featuresCfg.setSkitContinue(JSON.getInt(jSONObject, "skit_continue", 1));
        featuresCfg.setEnableStickCustom(JSON.getInt(jSONObject, "enable_stick_custom", 0));
        featuresCfg.setPluginMode(JSON.getInt(jSONObject, "plugin_mode", 0));
        featuresCfg.setInDramaBlackList(JSON.getInt(jSONObject, "shortplay_blacklist", 0));
        VerifierSp.saveSetting(JSON.getInt(jSONObject, "verifier_disabled", 0) == 1);
        ArrayList arrayList = new ArrayList();
        JSONArray jsonArray = JSON.getJsonArray(jSONObject, "share_panel_config");
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); i++) {
                arrayList.add(jsonArray.optString(i));
            }
        }
        featuresCfg.setSharePanelConfig(arrayList);
        ArrayList arrayList2 = new ArrayList();
        JSONArray jsonArray2 = JSON.getJsonArray(jSONObject, "feed_share_panel_config");
        if (jsonArray2 != null) {
            for (int i2 = 0; i2 < jsonArray2.length(); i2++) {
                arrayList2.add(jsonArray2.optString(i2));
            }
        }
        featuresCfg.setFeedSharePanelConfig(arrayList2);
        JSONArray jsonArray3 = JSON.getJsonArray(jSONObject, "video_plugin_block_list");
        if (jsonArray3 == null) {
            jsonArray3 = JSON.buildArr();
        }
        featuresCfg.setVideoPluginBLockList(jsonArray3.toString());
        JSONArray jsonArray4 = JSON.getJsonArray(jSONObject, "plugin_adsdk_blocklist");
        featuresCfg.setAdSdkBlockList(jsonArray4 != null ? jsonArray4.toString() : "");
        featuresCfg.setShortPlayFirstFrame(JSON.getString(jSONObject, "shortplay_player_first_frame", "first_frame"));
        featuresCfg.setHotListRetryTime(JSON.getInt(jSONObject, "get_hot_drama_max_retry_sec"));
        featuresCfg.setConsecutiveUnlockingEnable(JSON.getBoolean(jSONObject, "enable_consecutive_unlocking", true));
        return featuresCfg;
    }

    public static ContentCfg parseContent(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ContentCfg contentCfg = new ContentCfg();
        contentCfg.setSmallVideoCardSubNum(JSON.getInt(jSONObject, "small_video_card_sub_num", 16));
        contentCfg.setArticleDetailRelatedNum(JSON.getInt(jSONObject, "article_detail_related_num", 5));
        contentCfg.setVideoDetailRelatedNum(JSON.getInt(jSONObject, "video_detail_related_num", 8));
        contentCfg.setVideoDetailRelatedTotal(JSON.getInt(jSONObject, "video_detail_related_total", 20));
        contentCfg.setPreloadSizeWifi(JSON.getInt(jSONObject, "preload_size_wifi", -1));
        contentCfg.setPreloadSize4G(JSON.getInt(jSONObject, "preload_size_4g", 800));
        contentCfg.setPreloadSize3G(JSON.getInt(jSONObject, "preload_size_3g", 800));
        contentCfg.setPreloadSize2G(JSON.getInt(jSONObject, "preload_size_2g", 800));
        contentCfg.setPreloadSizeOther(JSON.getInt(jSONObject, "preload_size_other", 800));
        contentCfg.setPreloadExpire(JSON.getInt(jSONObject, "preload_expire", 1440));
        contentCfg.setMinFlingDistance(JSON.getInt(jSONObject, "min_fling_distance", 25));
        contentCfg.setMinFlingVelocity(JSON.getInt(jSONObject, "min_fling_velocity", 400));
        contentCfg.setMinScrollDistance(JSON.getDouble(jSONObject, "min_scroll_distance", 0.4d));
        contentCfg.setClosePreload(JSON.getInt(jSONObject, "close_preload", 0));
        contentCfg.setCloseCacheUp(JSON.getInt(jSONObject, "close_cache_up", 1));
        contentCfg.setCustomCateCfg(parseCustomCate(JSON.getJsonObject(jSONObject, "custom_cate")));
        return contentCfg;
    }

    private static ContentCfg.CustomCateCfg parseCustomCate(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ContentCfg.CustomCateCfg customCateCfg = new ContentCfg.CustomCateCfg();
        HashMap map = new HashMap();
        Iterator keys = JSON.getKeys(jSONObject);
        while (keys != null && keys.hasNext()) {
            String str = (String) keys.next();
            map.put(str, JSON.getJsonObject(jSONObject, str));
        }
        customCateCfg.setSceneMap(map);
        return customCateCfg;
    }

    public static LogCfg parseLogCfg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LogCfg logCfg = new LogCfg();
        logCfg.setExposure(parseExposure(JSON.getJsonObject(jSONObject, "exposure")));
        return logCfg;
    }

    private static LogCfg.Exposure parseExposure(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        LogCfg.Exposure exposure = new LogCfg.Exposure();
        exposure.setFeedImageMode(JSON.getInt(jSONObject, "feed_image_mode", 70));
        exposure.setSuduku(JSON.getInt(jSONObject, "suduku", 70));
        exposure.setNews(JSON.getInt(jSONObject, "news", 50));
        return exposure;
    }
}
