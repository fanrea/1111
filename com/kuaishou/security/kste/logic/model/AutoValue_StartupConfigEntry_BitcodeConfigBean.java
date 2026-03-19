package com.kuaishou.security.kste.logic.model;

import com.alipay.sdk.m.u.i;
import com.kuaishou.security.kste.logic.model.StartupConfigEntry;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValue_StartupConfigEntry_BitcodeConfigBean extends StartupConfigEntry.BitcodeConfigBean {
    private final int needUpdate;

    final class Builder extends StartupConfigEntry.BitcodeConfigBean.Builder {
        private Integer needUpdate;

        Builder() {
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.BitcodeConfigBean.Builder
        public final StartupConfigEntry.BitcodeConfigBean build() {
            String str = "";
            if (this.needUpdate == null) {
                str = " needUpdate";
            }
            if (str.isEmpty()) {
                return new AutoValue_StartupConfigEntry_BitcodeConfigBean(this.needUpdate.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.BitcodeConfigBean.Builder
        public final StartupConfigEntry.BitcodeConfigBean.Builder needUpdate(int i) {
            this.needUpdate = Integer.valueOf(i);
            return this;
        }
    }

    private AutoValue_StartupConfigEntry_BitcodeConfigBean(int i) {
        this.needUpdate = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof StartupConfigEntry.BitcodeConfigBean) && this.needUpdate == ((StartupConfigEntry.BitcodeConfigBean) obj).needUpdate();
    }

    public final int hashCode() {
        return this.needUpdate ^ 1000003;
    }

    @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.BitcodeConfigBean
    public final int needUpdate() {
        return this.needUpdate;
    }

    public final String toString() {
        return "BitcodeConfigBean{needUpdate=" + this.needUpdate + i.d;
    }
}
