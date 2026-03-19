package com.bytedance.sdk.djx;

import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EMSdkConfig {
    private Map<String, Object> internalSettings = new HashMap();
    private int mAliveSeconds;
    private boolean mAutoStartMiniapp;
    private boolean mDisableABTest;
    private int mImageCacheSize;
    private int mInterestType;
    private boolean mIsDebug;
    private boolean mIsNewUser;
    private IDJXPrivacyController mPrivacyController;
    private IDJXRouter mRouter;
    private IDJXToastController mToastController;

    public Map<String, Object> getInternalSettings() {
        return this.internalSettings;
    }

    public void setInternalSettings(Map<String, Object> map) {
        this.internalSettings = map;
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public void setDebug(boolean z) {
        this.mIsDebug = z;
    }

    public IDJXPrivacyController getPrivacyController() {
        return this.mPrivacyController;
    }

    public void setPrivacyController(IDJXPrivacyController iDJXPrivacyController) {
        this.mPrivacyController = iDJXPrivacyController;
    }

    public int getImageCacheSize() {
        return this.mImageCacheSize;
    }

    public IDJXToastController getToastController() {
        return this.mToastController;
    }

    public void setToastController(IDJXToastController iDJXToastController) {
        this.mToastController = iDJXToastController;
    }

    public boolean isDisableABTest() {
        return this.mDisableABTest;
    }

    public boolean isNewUser() {
        return this.mIsNewUser;
    }

    public int getAliveSeconds() {
        return this.mAliveSeconds;
    }

    public int getInterestType() {
        return this.mInterestType;
    }

    public IDJXRouter getRouter() {
        return this.mRouter;
    }

    public void setRouter(IDJXRouter iDJXRouter) {
        this.mRouter = iDJXRouter;
    }

    public boolean isAutoStartMiniapp() {
        return this.mAutoStartMiniapp;
    }

    protected EMSdkConfig(Builder builder) {
        this.mIsNewUser = false;
        this.mAliveSeconds = 0;
        this.mAutoStartMiniapp = true;
        this.mIsDebug = builder.isDebug;
        this.mPrivacyController = builder.privacyController;
        this.mImageCacheSize = builder.imageCacheSize;
        this.mToastController = builder.toastController;
        this.mDisableABTest = builder.mDisableABTest;
        this.mIsNewUser = builder.mIsNewUser;
        this.mAliveSeconds = builder.mAliveSeconds;
        this.mInterestType = builder.mInterestType;
        this.mRouter = builder.mRouter;
        this.mAutoStartMiniapp = builder.autoStartMiniapp;
    }

    public static class Builder<T> {
        private int imageCacheSize;
        private boolean isDebug;
        private int mAliveSeconds;
        private int mInterestType;
        private boolean mIsNewUser;
        private IDJXRouter mRouter;
        private IDJXPrivacyController privacyController;
        private IDJXToastController toastController;
        private boolean mDisableABTest = false;
        private boolean autoStartMiniapp = true;

        /* JADX WARN: Multi-variable type inference failed */
        @Deprecated
        public T preloadDraw(boolean z) {
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T router(IDJXRouter iDJXRouter) {
            this.mRouter = iDJXRouter;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T privacyController(IDJXPrivacyController iDJXPrivacyController) {
            this.privacyController = iDJXPrivacyController;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T debug(boolean z) {
            this.isDebug = z;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T toastController(IDJXToastController iDJXToastController) {
            this.toastController = iDJXToastController;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T imageCacheSize(int i) {
            this.imageCacheSize = i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T disableABTest(boolean z) {
            this.mDisableABTest = z;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T interestType(int i) {
            this.mInterestType = i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T newUser(boolean z) {
            this.mIsNewUser = z;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T aliveSeconds(int i) {
            this.mAliveSeconds = i;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public T autoStartMiniapp(boolean z) {
            this.autoStartMiniapp = z;
            return this;
        }
    }

    public String toString() {
        return "EMSdkSdkConfig{mIsDebug=" + this.mIsDebug + ", mPrivacyController=" + this.mPrivacyController + ", mImageCacheSize=" + this.mImageCacheSize + ", mToastController=" + this.mToastController + ", mDisableABTest=" + this.mDisableABTest + ", mIsNewUser=" + this.mIsNewUser + ", mAliveSeconds=" + this.mAliveSeconds + ", mInterestType=" + this.mInterestType + ", mAutoStartMiniapp=" + this.mAutoStartMiniapp + '}';
    }
}
