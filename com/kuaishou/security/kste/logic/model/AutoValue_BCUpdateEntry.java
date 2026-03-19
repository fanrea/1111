package com.kuaishou.security.kste.logic.model;

import com.alipay.sdk.m.u.i;
import com.kuaishou.security.kste.logic.model.BCUpdateEntry;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValue_BCUpdateEntry extends BCUpdateEntry {
    private final String bcCdn;
    private final String bcMd5;
    private final int bcVer;
    private final String vmBizId;

    final class Builder extends BCUpdateEntry.Builder {
        private String bcCdn;
        private String bcMd5;
        private Integer bcVer;
        private String vmBizId;

        Builder() {
        }

        @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry.Builder
        public final BCUpdateEntry.Builder bcCdn(String str) {
            if (str == null) {
                throw new NullPointerException("Null bcCdn");
            }
            this.bcCdn = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry.Builder
        public final BCUpdateEntry.Builder bcMd5(String str) {
            if (str == null) {
                throw new NullPointerException("Null bcMd5");
            }
            this.bcMd5 = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry.Builder
        public final BCUpdateEntry.Builder bcVer(int i) {
            this.bcVer = Integer.valueOf(i);
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry.Builder
        public final BCUpdateEntry build() {
            String str = "";
            if (this.bcVer == null) {
                str = " bcVer";
            }
            if (this.bcCdn == null) {
                str = str + " bcCdn";
            }
            if (this.bcMd5 == null) {
                str = str + " bcMd5";
            }
            if (this.vmBizId == null) {
                str = str + " vmBizId";
            }
            if (str.isEmpty()) {
                return new AutoValue_BCUpdateEntry(this.bcVer.intValue(), this.bcCdn, this.bcMd5, this.vmBizId);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry.Builder
        public final BCUpdateEntry.Builder vmBizId(String str) {
            if (str == null) {
                throw new NullPointerException("Null vmBizId");
            }
            this.vmBizId = str;
            return this;
        }
    }

    private AutoValue_BCUpdateEntry(int i, String str, String str2, String str3) {
        this.bcVer = i;
        this.bcCdn = str;
        this.bcMd5 = str2;
        this.vmBizId = str3;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry
    public final String bcCdn() {
        return this.bcCdn;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry
    public final String bcMd5() {
        return this.bcMd5;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry
    public final int bcVer() {
        return this.bcVer;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCUpdateEntry) {
            BCUpdateEntry bCUpdateEntry = (BCUpdateEntry) obj;
            if (this.bcVer == bCUpdateEntry.bcVer() && this.bcCdn.equals(bCUpdateEntry.bcCdn()) && this.bcMd5.equals(bCUpdateEntry.bcMd5()) && this.vmBizId.equals(bCUpdateEntry.vmBizId())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.bcVer ^ 1000003) * 1000003) ^ this.bcCdn.hashCode()) * 1000003) ^ this.bcMd5.hashCode()) * 1000003) ^ this.vmBizId.hashCode();
    }

    public final String toString() {
        return "BCUpdateEntry{bcVer=" + this.bcVer + ", bcCdn=" + this.bcCdn + ", bcMd5=" + this.bcMd5 + ", vmBizId=" + this.vmBizId + i.d;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCUpdateEntry
    public final String vmBizId() {
        return this.vmBizId;
    }
}
