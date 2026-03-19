package com.kwai.middleware.azeroth.logger;

import com.alipay.sdk.m.u.i;
import com.kuaishou.socket.nano.SocketMessages;
import com.kwai.middleware.azeroth.logger.CommonParams;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValueCommonParams extends CommonParams {
    private final String container;
    private final boolean realtime;
    private final float sampleRatio;
    private final String sdkName;
    private final String subBiz;

    private AutoValueCommonParams(String str, String str2, boolean z, float f, String str3) {
        this.sdkName = str;
        this.subBiz = str2;
        this.realtime = z;
        this.sampleRatio = f;
        this.container = str3;
    }

    @Override // com.kwai.middleware.azeroth.logger.CommonParams
    public final String sdkName() {
        return this.sdkName;
    }

    @Override // com.kwai.middleware.azeroth.logger.CommonParams
    public final String subBiz() {
        return this.subBiz;
    }

    @Override // com.kwai.middleware.azeroth.logger.CommonParams
    public final boolean realtime() {
        return this.realtime;
    }

    @Override // com.kwai.middleware.azeroth.logger.CommonParams
    public final float sampleRatio() {
        return this.sampleRatio;
    }

    @Override // com.kwai.middleware.azeroth.logger.CommonParams
    public final String container() {
        return this.container;
    }

    public final String toString() {
        return "CommonParams{sdkName=" + this.sdkName + ", subBiz=" + this.subBiz + ", realtime=" + this.realtime + ", sampleRatio=" + this.sampleRatio + ", container=" + this.container + i.d;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof CommonParams) {
            CommonParams commonParams = (CommonParams) obj;
            if (this.sdkName.equals(commonParams.sdkName()) && ((str = this.subBiz) != null ? str.equals(commonParams.subBiz()) : commonParams.subBiz() == null) && this.realtime == commonParams.realtime() && Float.floatToIntBits(this.sampleRatio) == Float.floatToIntBits(commonParams.sampleRatio()) && this.container.equals(commonParams.container())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.sdkName.hashCode() ^ 1000003) * 1000003;
        String str = this.subBiz;
        return ((((((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ (this.realtime ? SocketMessages.PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION : SocketMessages.PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO)) * 1000003) ^ Float.floatToIntBits(this.sampleRatio)) * 1000003) ^ this.container.hashCode();
    }

    @Override // com.kwai.middleware.azeroth.logger.CommonParams
    public final CommonParams.Builder toBuilder() {
        return new Builder(this);
    }

    static final class Builder extends CommonParams.Builder {
        private String container;
        private Boolean realtime;
        private Float sampleRatio;
        private String sdkName;
        private String subBiz;

        Builder() {
        }

        private Builder(CommonParams commonParams) {
            this.sdkName = commonParams.sdkName();
            this.subBiz = commonParams.subBiz();
            this.realtime = Boolean.valueOf(commonParams.realtime());
            this.sampleRatio = Float.valueOf(commonParams.sampleRatio());
            this.container = commonParams.container();
        }

        @Override // com.kwai.middleware.azeroth.logger.CommonParams.Builder
        public final CommonParams.Builder sdkName(String str) {
            if (str == null) {
                throw new NullPointerException("Null sdkName");
            }
            this.sdkName = str;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CommonParams.Builder
        public final CommonParams.Builder subBiz(String str) {
            this.subBiz = str;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CommonParams.Builder
        public final CommonParams.Builder realtime(boolean z) {
            this.realtime = Boolean.valueOf(z);
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CommonParams.Builder
        public final CommonParams.Builder sampleRatio(float f) {
            this.sampleRatio = Float.valueOf(f);
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CommonParams.Builder
        public final CommonParams.Builder container(String str) {
            if (str == null) {
                throw new NullPointerException("Null container");
            }
            this.container = str;
            return this;
        }

        @Override // com.kwai.middleware.azeroth.logger.CommonParams.Builder
        final CommonParams autoBuild() {
            String str = "";
            if (this.sdkName == null) {
                str = " sdkName";
            }
            if (this.realtime == null) {
                str = str + " realtime";
            }
            if (this.sampleRatio == null) {
                str = str + " sampleRatio";
            }
            if (this.container == null) {
                str = str + " container";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValueCommonParams(this.sdkName, this.subBiz, this.realtime.booleanValue(), this.sampleRatio.floatValue(), this.container);
        }
    }
}
