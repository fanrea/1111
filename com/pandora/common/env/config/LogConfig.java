package com.pandora.common.env.config;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LogConfig {
    private String deviceID;
    private boolean enable;
    private boolean enableConsole;
    private boolean enableLogFile;
    private int logExpireTimeS;
    private int logLevel;
    private String logPath;
    private int maxLogSizeM;
    private int singleLogSizeM;

    public interface LogLevel {
        public static final int Debug = 2;
        public static final int Error = 5;
        public static final int Info = 3;
        public static final int None = 6;
        public static final int Verbose = 1;
        public static final int Warning = 4;
    }

    private LogConfig(Builder build) {
        this.deviceID = "";
        this.maxLogSizeM = 100;
        this.singleLogSizeM = 2;
        this.logExpireTimeS = 604800;
        this.enableConsole = true;
        this.enableLogFile = true;
        this.logLevel = 2;
        this.enable = false;
        this.deviceID = build.deviceID;
        this.logPath = build.logPath;
        this.maxLogSizeM = build.maxLogSizeM;
        this.singleLogSizeM = build.singleLogSizeM;
        this.logExpireTimeS = build.logExpireTimeS;
        this.enableConsole = build.enableConsole;
        this.enableLogFile = build.enableLogFile;
        this.logLevel = build.logLevel;
        this.enable = build.enable;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getLogPath() {
        return this.logPath;
    }

    public int getMaxLogSizeM() {
        return this.maxLogSizeM;
    }

    public int getSingleLogSizeM() {
        return this.singleLogSizeM;
    }

    public int getLogExpireTimeS() {
        return this.logExpireTimeS;
    }

    public boolean isEnableConsole() {
        return this.enableConsole;
    }

    public int getLogLevel() {
        return this.logLevel;
    }

    public boolean isEnableLogFile() {
        return this.enableLogFile;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public static class Builder {
        private final Context context;
        private String logPath;
        private String deviceID = "";
        private int maxLogSizeM = 100;
        private int singleLogSizeM = 2;
        public int logExpireTimeS = 604800;
        private boolean enableConsole = true;
        private boolean enableLogFile = true;
        private int logLevel = 2;
        private final String DEFAULT_LOG_DIR = "Log";
        private boolean enable = false;

        public Builder(Context context) {
            this.context = context;
            this.logPath = context.getFilesDir().getAbsolutePath() + File.separator + "Log";
        }

        public LogConfig build() {
            if (TextUtils.isEmpty(this.logPath)) {
                this.logPath = new File(this.context.getCacheDir(), "Log").getAbsolutePath();
            }
            return new LogConfig(this);
        }

        public Builder setDeviceID(final String deviceID) {
            this.deviceID = deviceID;
            return this;
        }

        public Builder setLogPath(final String logPath) {
            this.logPath = logPath;
            return this;
        }

        public Builder setMaxLogSizeM(final int maxLogSizeM) {
            this.maxLogSizeM = maxLogSizeM;
            return this;
        }

        public Builder setSingleLogSizeM(final int singleLogSizeM) {
            this.singleLogSizeM = singleLogSizeM;
            return this;
        }

        public Builder setLogExpireTimeS(final int logExpireTimeS) {
            this.logExpireTimeS = logExpireTimeS;
            return this;
        }

        public Builder setEnableConsole(final boolean enableConsole) {
            this.enableConsole = enableConsole;
            return this;
        }

        public Builder setEnableLogFile(final boolean enableLogFile) {
            this.enableLogFile = enableLogFile;
            return this;
        }

        public Builder setLogLevel(final int logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public Builder setEnable(final boolean enable) {
            this.enable = enable;
            return this;
        }
    }
}
