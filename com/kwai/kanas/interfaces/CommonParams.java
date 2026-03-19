package com.kwai.kanas.interfaces;

import com.kwai.kanas.interfaces.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class CommonParams {
    public abstract String container();

    public abstract boolean realtime();

    public abstract float sampleRatio();

    public abstract String sdkName();

    public abstract String subBiz();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new a.C0650a().realtime(false).container("NATIVE").sdkName("").subBiz("").sampleRatio(1.0f);
    }

    public static abstract class Builder {
        abstract CommonParams a();

        public abstract Builder container(String str);

        public abstract Builder realtime(boolean z);

        public abstract Builder sampleRatio(float f);

        public abstract Builder sdkName(String str);

        public abstract Builder subBiz(String str);

        public CommonParams build() {
            return a();
        }
    }
}
