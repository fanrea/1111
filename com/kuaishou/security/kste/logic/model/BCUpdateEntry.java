package com.kuaishou.security.kste.logic.model;

import com.kuaishou.security.kste.logic.model.AutoValue_BCUpdateEntry;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class BCUpdateEntry {

    public abstract class Builder {
        public abstract Builder bcCdn(String str);

        public abstract Builder bcMd5(String str);

        public abstract Builder bcVer(int i);

        public abstract BCUpdateEntry build();

        public abstract Builder vmBizId(String str);
    }

    public static Builder builder() {
        return new AutoValue_BCUpdateEntry.Builder();
    }

    public static BCUpdateEntry create(int i, String str, String str2, String str3) {
        return builder().bcVer(i).bcCdn(str).bcMd5(str2).vmBizId(str3).build();
    }

    public abstract String bcCdn();

    public abstract String bcMd5();

    public abstract int bcVer();

    public abstract String vmBizId();
}
