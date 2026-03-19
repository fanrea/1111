package com.pandora.common.env.config;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class VodConfig {
    public static final String VOD_CACHE_DIR_DEFAULT = "video_cache";
    public static final int VOD_MAX_CACHE_SIZE_DEFAULT = 314572800;
    private final String cacheDirPath;
    private final int loaderType;
    private final int maxCacheSize;

    private VodConfig(Builder builder) {
        this.cacheDirPath = builder.cacheDirPath;
        this.maxCacheSize = builder.maxCacheSize;
        this.loaderType = builder.loaderType;
    }

    public String getCacheDirPath() {
        return this.cacheDirPath;
    }

    public int getMaxCacheSize() {
        return this.maxCacheSize;
    }

    public int getLoaderType() {
        return this.loaderType;
    }

    public String toString() {
        return "VodConfig{cacheDirPath='" + this.cacheDirPath + "', maxCacheSize=" + this.maxCacheSize + ", loaderType=" + this.loaderType + '}';
    }

    public static class Builder {
        private String cacheDirPath;
        private final Context context;
        private int maxCacheSize = 314572800;
        private int loaderType = 0;

        public Builder(Context context) {
            this.context = context;
            this.cacheDirPath = new File(context.getCacheDir(), VodConfig.VOD_CACHE_DIR_DEFAULT).getAbsolutePath();
        }

        public VodConfig build() {
            if (TextUtils.isEmpty(this.cacheDirPath)) {
                this.cacheDirPath = new File(this.context.getCacheDir(), VodConfig.VOD_CACHE_DIR_DEFAULT).getAbsolutePath();
            }
            return new VodConfig(this);
        }

        public Builder setCacheDirPath(final String cacheDirPath) {
            this.cacheDirPath = cacheDirPath;
            return this;
        }

        public Builder setMaxCacheSize(final int vodMaxCacheSize) {
            this.maxCacheSize = vodMaxCacheSize;
            return this;
        }

        public Builder setLoaderType(final int loaderType) {
            this.loaderType = loaderType;
            return this;
        }
    }
}
