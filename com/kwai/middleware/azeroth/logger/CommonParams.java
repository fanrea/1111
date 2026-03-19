package com.kwai.middleware.azeroth.logger;

import com.kwai.middleware.azeroth.logger.AutoValueCommonParams;
import com.kwai.middleware.azeroth.utils.Utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class CommonParams {
    public abstract String container();

    public abstract boolean realtime();

    public abstract float sampleRatio();

    public abstract String sdkName();

    public abstract String subBiz();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValueCommonParams.Builder().container("NATIVE").realtime(false).sampleRatio(1.0f).subBiz("");
    }

    public static abstract class Builder {
        abstract CommonParams autoBuild();

        public abstract Builder container(String str);

        public abstract Builder realtime(boolean z);

        public abstract Builder sampleRatio(float f);

        public abstract Builder sdkName(String str);

        public abstract Builder subBiz(String str);

        public CommonParams build() {
            CommonParams commonParamsAutoBuild = autoBuild();
            Utils.checkNotNull(commonParamsAutoBuild.sdkName());
            return commonParamsAutoBuild;
        }
    }
}
