package com.bytedance.sdk.djx.core.business.budrama.draw;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.djx.core.api.ApiManager;
import com.bytedance.sdk.djx.core.api.req.FeedApi;
import com.bytedance.sdk.djx.core.api.req.FeedReqParams;
import com.bytedance.sdk.djx.core.api.rsp.FeedRsp;
import com.bytedance.sdk.djx.core.settings.SettingData;
import com.bytedance.sdk.djx.core.vod.IPreloadCallback;
import com.bytedance.sdk.djx.core.vod.IVideoService;
import com.bytedance.sdk.djx.model.DJXError;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.net.api.IApiCallback;
import com.bytedance.sdk.djx.utils.JSON;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.SP;
import com.bytedance.sdk.djx.utils.SPUtils;
import com.bytedance.sdk.djx.utils.service.ServiceManager;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DrawPreload2 {
    private static final long DAY_MILLIS = 86400000;
    public static final int HOUR_MILLIS = 3600000;
    private static final String KEY_DATA = "data";
    private static final String KEY_EXPIRE_TIME = "expire_time";
    private static final String TAG = "DrawPreload2";
    private static volatile DrawPreload2 sInstance;
    private boolean mInit = false;
    private boolean mIsLoading = false;
    private long mExpireTime = -1;
    private final List<Feed> mFeedList = new CopyOnWriteArrayList();
    private final SPUtils mSPUtils = SP.preload2();

    public static DrawPreload2 getInstance() {
        if (sInstance == null) {
            synchronized (DrawPreload2.class) {
                if (sInstance == null) {
                    sInstance = new DrawPreload2();
                }
            }
        }
        return sInstance;
    }

    private DrawPreload2() {
        TTExecutor.get().executeDefaultTask(new TTRunnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawPreload2.1
            public void run() {
                DrawPreload2.this.init();
                if (DrawPreload2.this.checkCacheExpired()) {
                    DrawPreload2.this.refreshLocalCache();
                }
                DrawPreload2.this.mInit = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        try {
            this.mExpireTime = this.mSPUtils.getLong(KEY_EXPIRE_TIME);
            String string = this.mSPUtils.getString("data", (String) null);
            if (string != null && !string.isEmpty()) {
                JSONArray jSONArrayBuildArr = JSON.buildArr(new String(Base64.decode(string, 0)));
                ArrayList arrayList = new ArrayList();
                int length = jSONArrayBuildArr == null ? 0 : jSONArrayBuildArr.length();
                for (int i = 0; i < length; i++) {
                    try {
                        arrayList.add(FeedApi.parseFeed(jSONArrayBuildArr.optJSONObject(i)));
                    } catch (Throwable unused) {
                    }
                }
                loadVideoFile(true, arrayList);
                return;
            }
            reset();
        } catch (Throwable unused2) {
            reset();
        }
    }

    public void refresh() {
        if (!this.mInit || this.mIsLoading) {
            return;
        }
        if (checkCacheExpired()) {
            refreshLocalCache();
            LG.d(TAG, "need to refresh cache");
        } else {
            LG.d(TAG, "no need to refresh cache");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshLocalCache() {
        if (SettingData.getInstance().isCloseCacheUp()) {
            LG.d(TAG, "video cache has been closed");
        } else if (this.mIsLoading) {
            LG.d(TAG, "refresh loading, then return");
        } else {
            this.mIsLoading = true;
            ApiManager.getInstance().feed(new IApiCallback<FeedRsp>() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawPreload2.2
                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiSuccess(FeedRsp feedRsp) {
                    if (feedRsp.getData() == null || feedRsp.getData().isEmpty()) {
                        DrawPreload2.this.mIsLoading = false;
                        return;
                    }
                    JSONArray preloadData = feedRsp.getPreloadData();
                    if (preloadData == null || preloadData.length() <= 0) {
                        DrawPreload2.this.mIsLoading = false;
                        return;
                    }
                    String string = preloadData.toString();
                    if (TextUtils.isEmpty(string)) {
                        DrawPreload2.this.mIsLoading = false;
                        return;
                    }
                    DrawPreload2.this.mExpireTime = System.currentTimeMillis() + 86400000 + ((long) (Math.random() * Math.max(SettingData.getInstance().getCacheExpireRandomHours(), 0) * 3600000.0d));
                    DrawPreload2.this.mSPUtils.put("data", Base64.encodeToString(string.getBytes(), 0));
                    DrawPreload2.this.mSPUtils.put(DrawPreload2.KEY_EXPIRE_TIME, DrawPreload2.this.mExpireTime);
                    LG.d(DrawPreload2.TAG, "refresh cache && clear old cache");
                    DrawPreload2.this.mIsLoading = false;
                    final List<Feed> data = feedRsp.getData();
                    TTExecutor.get().executeDefaultTask(new TTRunnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawPreload2.2.1
                        public void run() {
                            DrawPreload2.this.loadVideoFile(false, data);
                        }
                    });
                }

                @Override // com.bytedance.sdk.djx.net.api.IApiCallback
                public void onApiFailure(DJXError dJXError, FeedRsp feedRsp) {
                    DrawPreload2.this.mIsLoading = false;
                }
            }, FeedReqParams.build().cached(true).category("hotsoon_video_detail_draw"), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadVideoFile(boolean z, List<Feed> list) {
        this.mFeedList.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        if (z) {
            for (Feed feed : list) {
                feed.setCachedVideo(true);
                if (!feed.isType4Drama() && ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).getCacheSize(feed) > 0) {
                    this.mFeedList.add(feed);
                }
            }
        }
        for (Feed feed2 : list) {
            feed2.setCachedVideo(true);
            if (!feed2.isType4Drama()) {
                ((IVideoService) ServiceManager.getInstance().getService(IVideoService.class)).preload(feed2, 2147483647L, new IPreloadCallback<Feed>() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawPreload2.3
                    @Override // com.bytedance.sdk.djx.core.vod.IPreloadCallback
                    public void onFailure(Feed feed3) {
                    }

                    @Override // com.bytedance.sdk.djx.core.vod.IPreloadCallback
                    public void onSuccess(Feed feed3, String str, String str2, String str3) {
                        if (DrawPreload2.this.isContain(feed3)) {
                            return;
                        }
                        DrawPreload2.this.mFeedList.add(feed3);
                        LG.d(DrawPreload2.TAG, "preload cache success , group id = " + feed3.getGroupId());
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isContain(Feed feed) {
        if (feed == null) {
            return false;
        }
        for (Feed feed2 : this.mFeedList) {
            if (feed2 != null && feed2.getGroupId() == feed.getGroupId()) {
                return true;
            }
        }
        return false;
    }

    public List<Feed> getFeedList() {
        ArrayList arrayList = new ArrayList(this.mFeedList);
        Collections.shuffle(arrayList);
        return arrayList;
    }

    public void remove(final Feed feed) {
        if (feed == null) {
            return;
        }
        boolean z = false;
        if (!this.mFeedList.isEmpty()) {
            Iterator<Feed> it = this.mFeedList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Feed next = it.next();
                if (next != null && next.getGroupId() == feed.getGroupId()) {
                    this.mFeedList.remove(i);
                    z = true;
                    break;
                }
                i++;
            }
        }
        if (z) {
            TTExecutor.get().executeDefaultTask(new TTRunnable() { // from class: com.bytedance.sdk.djx.core.business.budrama.draw.DrawPreload2.4
                public void run() {
                    try {
                        JSONArray jSONArrayBuildArr = JSON.buildArr(new String(Base64.decode(DrawPreload2.this.mSPUtils.getString("data", (String) null), 0)));
                        int length = jSONArrayBuildArr == null ? 0 : jSONArrayBuildArr.length();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                i2 = -1;
                                break;
                            } else if (FeedApi.parseFeed(jSONArrayBuildArr.optJSONObject(i2)).getGroupId() == feed.getGroupId()) {
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i2 > -1) {
                            JSONArray jSONArrayRemove = JSON.remove(jSONArrayBuildArr, i2);
                            String string = jSONArrayRemove.toString();
                            if (jSONArrayRemove.length() != 0 && !TextUtils.isEmpty(string)) {
                                DrawPreload2.this.mSPUtils.put("data", Base64.encodeToString(string.getBytes(), 0));
                                return;
                            }
                            DrawPreload2.this.reset();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkCacheExpired() {
        return System.currentTimeMillis() >= this.mExpireTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reset() {
        this.mSPUtils.clear();
        this.mExpireTime = 0L;
    }
}
