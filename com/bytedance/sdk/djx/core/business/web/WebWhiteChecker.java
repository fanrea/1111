package com.bytedance.sdk.djx.core.business.web;

import android.graphics.Bitmap;
import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.core.util.CheckWhiteUtils;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.utils.LG;
import com.bytedance.sdk.djx.utils.thread.TTExecutor;
import com.bytedance.sdk.djx.utils.thread.TTRunnable;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class WebWhiteChecker {
    private static final int SCENE_DRAW_COMMENT = 1;
    private static final int SCENE_NEWS_DETAIL = 2;
    private static final String TAG = "WebWhiteChecker";
    private static volatile WebWhiteChecker sInstance;

    public static WebWhiteChecker getInstance() {
        if (sInstance == null) {
            synchronized (WebWhiteChecker.class) {
                if (sInstance == null) {
                    sInstance = new WebWhiteChecker();
                }
            }
        }
        return sInstance;
    }

    private WebWhiteChecker() {
    }

    public void addTask(Task task) {
        if (task == null || task.mBitmap == null) {
            return;
        }
        LG.d(TAG, "web white check: " + task.mScene + ", " + task.mLoadTime);
        TTExecutor.get().executeDefaultTask(new TaskRunner(task));
    }

    private static class TaskRunner extends TTRunnable {
        Task mTask;

        public TaskRunner(Task task) {
            this.mTask = task;
        }

        public void run() {
            Task task = this.mTask;
            if (task == null || task.mBitmap == null || !CheckWhiteUtils.checkWebViewIsTransparent(this.mTask.mBitmap, this.mTask.mColor)) {
                return;
            }
            try {
                sendWhiteLog(this.mTask.mThirdScene);
            } catch (Throwable th) {
                LG.e(WebWhiteChecker.TAG, "white screen upload log error: ", th);
            }
        }

        private void sendWhiteLog(String str) {
            Task task = this.mTask;
            if (task == null || task.mFeed == null) {
                return;
            }
            String str2 = null;
            if (this.mTask.mScene == 1) {
                str2 = ILogConst.E_COMMENT_WHITE_SCREEN;
            } else if (this.mTask.mScene == 2) {
                str2 = ILogConst.E_NEWS_DETAIL_WHITE_SCREEN;
            }
            BLogAgent bLogAgentPutLong = BLogAgent.build(this.mTask.mCategory, str2, this.mTask.mCommonParams).putLong("group_id", this.mTask.mFeed.getGroupId()).putInt("group_source", this.mTask.mFeed.getGroupSource()).putLong("cost_time", this.mTask.mLoadTime);
            if (this.mTask.mScene == 1) {
                bLogAgentPutLong.putInt("comment_count", this.mTask.mFeed.getCommentCount());
            }
            bLogAgentPutLong.send();
        }
    }

    public static Task buildDrawCommentTask(String str, Map<String, Object> map) {
        return new Task().setScene(1).setThirdScene(str).setCommonParams(map);
    }

    public static Task buildNewsDetailTask(String str, Map<String, Object> map) {
        return new Task().setScene(2).setThirdScene(str).setCommonParams(map);
    }

    public static class Task {
        Bitmap mBitmap;
        String mCategory;
        int mColor;
        Map<String, Object> mCommonParams;
        Feed mFeed;
        long mLoadTime;
        int mScene;
        String mThirdScene;

        void clean() {
            this.mBitmap = null;
        }

        public Task setScene(int i) {
            this.mScene = i;
            return this;
        }

        public Task setThirdScene(String str) {
            this.mThirdScene = str;
            return this;
        }

        public Task setColor(int i) {
            this.mColor = i;
            return this;
        }

        public Task setBitmap(Bitmap bitmap) {
            this.mBitmap = bitmap;
            return this;
        }

        public Task setLoadTime(long j) {
            this.mLoadTime = j;
            return this;
        }

        public Task setFeed(Feed feed) {
            this.mFeed = feed;
            return this;
        }

        public Task setCategory(String str) {
            this.mCategory = str;
            return this;
        }

        public Task setCommonParams(Map<String, Object> map) {
            this.mCommonParams = map;
            return this;
        }
    }
}
