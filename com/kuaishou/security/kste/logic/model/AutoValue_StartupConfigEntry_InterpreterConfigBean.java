package com.kuaishou.security.kste.logic.model;

import com.alipay.sdk.m.u.i;
import com.kuaishou.security.kste.logic.model.StartupConfigEntry;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValue_StartupConfigEntry_InterpreterConfigBean extends StartupConfigEntry.InterpreterConfigBean {
    private final String interpreterCdn;
    private final String interpreterMd5;
    private final String interpreterVer;
    private final int needUpdate;

    final class Builder extends StartupConfigEntry.InterpreterConfigBean.Builder {
        private String interpreterCdn;
        private String interpreterMd5;
        private String interpreterVer;
        private Integer needUpdate;

        Builder() {
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean.Builder
        public final StartupConfigEntry.InterpreterConfigBean build() {
            String str = "";
            if (this.needUpdate == null) {
                str = " needUpdate";
            }
            if (this.interpreterVer == null) {
                str = str + " interpreterVer";
            }
            if (this.interpreterCdn == null) {
                str = str + " interpreterCdn";
            }
            if (this.interpreterMd5 == null) {
                str = str + " interpreterMd5";
            }
            if (str.isEmpty()) {
                return new AutoValue_StartupConfigEntry_InterpreterConfigBean(this.needUpdate.intValue(), this.interpreterVer, this.interpreterCdn, this.interpreterMd5);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean.Builder
        public final StartupConfigEntry.InterpreterConfigBean.Builder interpreterCdn(String str) {
            if (str == null) {
                throw new NullPointerException("Null interpreterCdn");
            }
            this.interpreterCdn = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean.Builder
        public final StartupConfigEntry.InterpreterConfigBean.Builder interpreterMd5(String str) {
            if (str == null) {
                throw new NullPointerException("Null interpreterMd5");
            }
            this.interpreterMd5 = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean.Builder
        public final StartupConfigEntry.InterpreterConfigBean.Builder interpreterVer(String str) {
            if (str == null) {
                throw new NullPointerException("Null interpreterVer");
            }
            this.interpreterVer = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean.Builder
        public final StartupConfigEntry.InterpreterConfigBean.Builder needUpdate(int i) {
            this.needUpdate = Integer.valueOf(i);
            return this;
        }
    }

    private AutoValue_StartupConfigEntry_InterpreterConfigBean(int i, String str, String str2, String str3) {
        this.needUpdate = i;
        this.interpreterVer = str;
        this.interpreterCdn = str2;
        this.interpreterMd5 = str3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StartupConfigEntry.InterpreterConfigBean) {
            StartupConfigEntry.InterpreterConfigBean interpreterConfigBean = (StartupConfigEntry.InterpreterConfigBean) obj;
            if (this.needUpdate == interpreterConfigBean.needUpdate() && this.interpreterVer.equals(interpreterConfigBean.interpreterVer()) && this.interpreterCdn.equals(interpreterConfigBean.interpreterCdn()) && this.interpreterMd5.equals(interpreterConfigBean.interpreterMd5())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.needUpdate ^ 1000003) * 1000003) ^ this.interpreterVer.hashCode()) * 1000003) ^ this.interpreterCdn.hashCode()) * 1000003) ^ this.interpreterMd5.hashCode();
    }

    @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean
    public final String interpreterCdn() {
        return this.interpreterCdn;
    }

    @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean
    public final String interpreterMd5() {
        return this.interpreterMd5;
    }

    @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean
    public final String interpreterVer() {
        return this.interpreterVer;
    }

    @Override // com.kuaishou.security.kste.logic.model.StartupConfigEntry.InterpreterConfigBean
    public final int needUpdate() {
        return this.needUpdate;
    }

    public final String toString() {
        return "InterpreterConfigBean{needUpdate=" + this.needUpdate + ", interpreterVer=" + this.interpreterVer + ", interpreterCdn=" + this.interpreterCdn + ", interpreterMd5=" + this.interpreterMd5 + i.d;
    }
}
