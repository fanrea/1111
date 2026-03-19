package com.kuaishou.security.kste.logic.model;

import com.alipay.sdk.m.u.i;
import com.kuaishou.security.kste.logic.model.StartupConfigEntry;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValue_StartupConfigEntry extends StartupConfigEntry {
    private final StartupConfigEntry.BitcodeConfigBean bitcodeConfig;
    private final String configPolicy;
    private final StartupConfigEntry.InterpreterConfigBean interpreterConfig;

    final class Builder extends StartupConfigEntry.Builder {
        private StartupConfigEntry.BitcodeConfigBean bitcodeConfig;
        private String configPolicy;
        private StartupConfigEntry.InterpreterConfigBean interpreterConfig;

        Builder() {
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.Builder
        public final StartupConfigEntry.Builder bitcodeConfig(StartupConfigEntry.BitcodeConfigBean bitcodeConfigBean) {
            if (bitcodeConfigBean == null) {
                throw new NullPointerException("Null bitcodeConfig");
            }
            this.bitcodeConfig = bitcodeConfigBean;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.Builder
        public final StartupConfigEntry build() {
            String str = "";
            if (this.configPolicy == null) {
                str = " configPolicy";
            }
            if (this.bitcodeConfig == null) {
                str = str + " bitcodeConfig";
            }
            if (this.interpreterConfig == null) {
                str = str + " interpreterConfig";
            }
            if (str.isEmpty()) {
                return new AutoValue_StartupConfigEntry(this.configPolicy, this.bitcodeConfig, this.interpreterConfig);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.Builder
        public final StartupConfigEntry.Builder configPolicy(String str) {
            if (str == null) {
                throw new NullPointerException("Null configPolicy");
            }
            this.configPolicy = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.Builder
        public final StartupConfigEntry.Builder interpreterConfig(StartupConfigEntry.InterpreterConfigBean interpreterConfigBean) {
            if (interpreterConfigBean == null) {
                throw new NullPointerException("Null interpreterConfig");
            }
            this.interpreterConfig = interpreterConfigBean;
            return this;
        }
    }

    private AutoValue_StartupConfigEntry(String str, StartupConfigEntry.BitcodeConfigBean bitcodeConfigBean, StartupConfigEntry.InterpreterConfigBean interpreterConfigBean) {
        this.configPolicy = str;
        this.bitcodeConfig = bitcodeConfigBean;
        this.interpreterConfig = interpreterConfigBean;
    }

    @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry
    public final StartupConfigEntry.BitcodeConfigBean bitcodeConfig() {
        return this.bitcodeConfig;
    }

    @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry
    public final String configPolicy() {
        return this.configPolicy;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StartupConfigEntry) {
            StartupConfigEntry startupConfigEntry = (StartupConfigEntry) obj;
            if (this.configPolicy.equals(startupConfigEntry.configPolicy()) && this.bitcodeConfig.equals(startupConfigEntry.bitcodeConfig()) && this.interpreterConfig.equals(startupConfigEntry.interpreterConfig())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.configPolicy.hashCode() ^ 1000003) * 1000003) ^ this.bitcodeConfig.hashCode()) * 1000003) ^ this.interpreterConfig.hashCode();
    }

    @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry
    public final StartupConfigEntry.InterpreterConfigBean interpreterConfig() {
        return this.interpreterConfig;
    }

    public final String toString() {
        return "StartupConfigEntry{configPolicy=" + this.configPolicy + ", bitcodeConfig=" + this.bitcodeConfig + ", interpreterConfig=" + this.interpreterConfig + i.d;
    }
}
