package com.kuaishou.security.kste.logic.model;

import com.kuaishou.security.kste.logic.model.AutoValue_StartupConfigEntry;
import com.kuaishou.security.kste.logic.model.AutoValue_StartupConfigEntry_BitcodeConfigBean;
import com.kuaishou.security.kste.logic.model.AutoValue_StartupConfigEntry_InterpreterConfigBean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class StartupConfigEntry {

    public abstract class BitcodeConfigBean {

        public abstract class Builder {
            public abstract BitcodeConfigBean build();

            public abstract Builder needUpdate(int i);
        }

        public static Builder builder() {
            return new AutoValue_StartupConfigEntry_BitcodeConfigBean.Builder();
        }

        public abstract int needUpdate();
    }

    public abstract class Builder {
        public abstract Builder bitcodeConfig(BitcodeConfigBean bitcodeConfigBean);

        public abstract StartupConfigEntry build();

        public abstract Builder configPolicy(String str);

        public abstract Builder interpreterConfig(InterpreterConfigBean interpreterConfigBean);
    }

    public abstract class InterpreterConfigBean {

        public abstract class Builder {
            public abstract InterpreterConfigBean build();

            public abstract Builder interpreterCdn(String str);

            public abstract Builder interpreterMd5(String str);

            public abstract Builder interpreterVer(String str);

            public abstract Builder needUpdate(int i);
        }

        public static Builder builder() {
            return new AutoValue_StartupConfigEntry_InterpreterConfigBean.Builder();
        }

        public abstract String interpreterCdn();

        public abstract String interpreterMd5();

        public abstract String interpreterVer();

        public abstract int needUpdate();
    }

    public static Builder builder() {
        return new AutoValue_StartupConfigEntry.Builder();
    }

    public abstract BitcodeConfigBean bitcodeConfig();

    public abstract String configPolicy();

    public abstract InterpreterConfigBean interpreterConfig();
}
