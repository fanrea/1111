package com.bytedance.sdk.djx.model;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LogCfg {
    private Exposure mExposure;

    public Exposure getExposure() {
        return this.mExposure;
    }

    public void setExposure(Exposure exposure) {
        this.mExposure = exposure;
    }

    public static class Exposure {
        private int mFeedImageMode;
        private int mNews;
        private int mSuduku;

        public int getFeedImageMode() {
            return this.mFeedImageMode;
        }

        public void setFeedImageMode(int i) {
            this.mFeedImageMode = i;
        }

        public int getSuduku() {
            return this.mSuduku;
        }

        public void setSuduku(int i) {
            this.mSuduku = i;
        }

        public int getNews() {
            return this.mNews;
        }

        public void setNews(int i) {
            this.mNews = i;
        }
    }
}
