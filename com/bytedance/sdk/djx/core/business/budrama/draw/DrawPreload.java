package com.bytedance.sdk.djx.core.business.budrama.draw;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.req.FeedApi;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.bytedance.sdk.djx.core.api.rsp.FeedRsp;
import com.bytedance.sdk.djx.core.business.reporter.DrawReporter;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.vod.IVideoService;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.InnerManager;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.NetworkUtils;
import com.bytedance.sdk.djx.utils.SP;
import com.bytedance.sdk.djx.utils.SPUtils;
import com.bytedance.sdk.djx.utils.service.ServiceManager;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DrawPreload {
    private static final String KEY_DATA = "data";
    private static final String KEY_ONLINE_PRELOAD = "online_preload";
    private static final String KEY_TIME = "time";
    private static final String TAG = "DrawPreload";
    private static volatile DrawPreload sInstance;
    private long mExpireTime;
    private Feed mFeed;
    private boolean mIsLoading = false;
    private final SPUtils mSPUtils;

    public static DrawPreload getInstance() {
        if (sInstance == null) {
            synchronized (DrawPreload.class) {
                if (sInstance == null) {
                    sInstance = new DrawPreload();
                }
            }
        }
        return sInstance;
    }

    private DrawPreload() {
        this.mExpireTime = 0L;
        SPUtils sPUtilsPreload = SP.preload();
        this.mSPUtils = sPUtilsPreload;
        try {
            long j = sPUtilsPreload.getLong(KEY_TIME);
            this.mFeed = readLocalData();
            if (j > 0 && System.currentTimeMillis() < j) {
                if (this.mFeed != null) {
                    this.mExpireTime = j;
                    ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).preload(this.mFeed, getPreloadSize());
                }
            } else {
                sendSkipLog(this.mFeed);
                sPUtilsPreload.clear();
                this.mExpireTime = 0L;
            }
        } catch (Throwable unused) {
            this.mSPUtils.clear();
            this.mExpireTime = 0L;
        }
    }

    private Feed readLocalData() {
        JSONObject jSONObjectBuild;
        String string = this.mSPUtils.getString("data");
        boolean z = this.mSPUtils.getBoolean(KEY_ONLINE_PRELOAD, false);
        if (TextUtils.isEmpty(string) || (jSONObjectBuild = JSON.build(new String(Base64.decode(string, 0)))) == null) {
            return null;
        }
        Feed feed = FeedApi.parseFeed(jSONObjectBuild);
        feed.setOnlinePreload(z);
        return feed;
    }

    public void saveData(Feed feed) {
        if (feed == null) {
            return;
        }
        this.mFeed = feed;
        try {
            this.mExpireTime = System.currentTimeMillis() + (SettingData.getInstance().getPreloadExpire() * 60 * 1000);
            this.mSPUtils.put("data", Base64.encodeToString(feed.getOriginal().toString().getBytes(), 0));
            this.mSPUtils.put(KEY_TIME, this.mExpireTime);
            this.mSPUtils.put(KEY_ONLINE_PRELOAD, true);
        } catch (Throwable unused) {
        }
        ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).preload(this.mFeed, getPreloadSize());
        this.mFeed.setOnlinePreload(true);
    }

    public void preload() {
        if (SettingData.getInstance().isClosePreload()) {
            LG.i(TAG, "preload was closed");
            return;
        }
        if (this.mFeed != null && this.mExpireTime > 0 && System.currentTimeMillis() < this.mExpireTime) {
            LG.i(TAG, "preload unnecessary");
        } else {
            if (this.mIsLoading) {
                return;
            }
            this.mIsLoading = true;
            ApiManager.getInstance().feed(new IApiCallback<FeedRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawPreload.1
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(FeedRsp feedRsp) {
                    DrawPreload.this.mIsLoading = false;
                    if (feedRsp == null || !feedRsp.isOk() || feedRsp.getData() == null || feedRsp.getData().isEmpty()) {
                        return;
                    }
                    try {
                        JSONObject jSONObjectOptJSONObject = feedRsp.getPreloadData().optJSONObject(0);
                        if (jSONObjectOptJSONObject != null) {
                            DrawPreload.this.mFeed = feedRsp.getData().get(0);
                            if (DrawPreload.this.mFeed != null) {
                                DrawPreload.this.mExpireTime = System.currentTimeMillis() + (SettingData.getInstance().getPreloadExpire() * 60 * 1000);
                                DrawPreload.this.mSPUtils.put("data", Base64.encodeToString(jSONObjectOptJSONObject.toString().getBytes(), 0));
                                DrawPreload.this.mSPUtils.put(DrawPreload.KEY_TIME, DrawPreload.this.mExpireTime);
                                DrawPreload.this.mSPUtils.put(DrawPreload.KEY_ONLINE_PRELOAD, false);
                                DrawPreload.this.mFeed.setOnlinePreload(false);
                                ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).preload(DrawPreload.this.mFeed, DrawPreload.this.getPreloadSize());
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, FeedRsp feedRsp) {
                    DrawPreload.this.mIsLoading = false;
                }
            }, FeedReqParams.build().category("hotsoon_video_detail_draw").preload(true), null);
        }
    }

    public Feed getFeed() {
        Feed feed;
        LG.i(TAG, "PreLoad: getFeed invoked, mFeed = " + this.mFeed + ", mExpireTime = " + this.mExpireTime);
        Feed feed2 = this.mFeed;
        Feed feed3 = null;
        if (feed2 != null) {
            if (feed2.isType4Drama()) {
                LG.i(TAG, "PreLoad: drama dont be preload");
                return null;
            }
            if (this.mExpireTime > 0 && System.currentTimeMillis() < this.mExpireTime) {
                feed = this.mFeed;
                LG.i(TAG, "PreLoad: hit");
            } else {
                sendSkipLog(this.mFeed);
                feed = null;
            }
            this.mFeed = null;
            this.mExpireTime = 0L;
            this.mSPUtils.clear();
            feed3 = feed;
        }
        if (feed3 != null) {
            feed3.setPreloadVideo(true);
        }
        return feed3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getPreloadSize() {
        int preloadSizeWifi;
        int networkType = NetworkUtils.getNetworkType(InnerManager.getContext());
        if (networkType == 1) {
            preloadSizeWifi = SettingData.getInstance().getPreloadSizeWifi();
        } else if (networkType == 3) {
            preloadSizeWifi = SettingData.getInstance().getPreloadSize2G();
        } else if (networkType == 4) {
            preloadSizeWifi = SettingData.getInstance().getPreloadSize3G();
        } else if (networkType == 5 || networkType == 6) {
            preloadSizeWifi = SettingData.getInstance().getPreloadSize4G();
        } else {
            preloadSizeWifi = SettingData.getInstance().getPreloadSizeOther();
        }
        return preloadSizeWifi;
    }

    private void sendSkipLog(Feed feed) {
        if (feed == null) {
            return;
        }
        LG.d(TAG, "send preload skip log: " + feed.getGroupId());
        BLogAgent.build("hotsoon_video_detail_draw", ILogConst.E_PRELOAD_SKIP, null).putString("category_server", feed.getCategoryName()).putLong("group_id", feed.getGroupId()).putInt("group_source", feed.getGroupSource()).putString(ILogConst.Keys.KEY_CATEGORY_NAME, DrawReporter.getCategoryName()).putString("position", "detail").putString(ILogConst.Keys.KEY_ENTER_FROM, DrawReporter.getEnterFrom()).send();
    }
}
