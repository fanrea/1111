package com.kuaishou.security.kste.logic.model;

import com.kuaishou.security.kste.logic.model.AutoValue_BCInvokeTask;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class BCInvokeTask {

    public abstract class Builder {
        public abstract Builder appkey(String str);

        public abstract BCInvokeTask build();

        public abstract Builder input(byte[] bArr);

        public abstract Builder kpn(String str);

        public abstract Builder maxOutLen(int i);

        public abstract Builder taskTag(String str);

        public abstract Builder timeout(long j);

        public abstract Builder vmBizId(String str);
    }

    public static Builder builder() {
        return new AutoValue_BCInvokeTask.Builder();
    }

    public static BCInvokeTask create(String str, String str2, String str3, byte[] bArr, int i, long j, String str4) {
        return builder().appkey(str).kpn(str2).vmBizId(str3).input(bArr).maxOutLen(i).build();
    }

    public abstract String appkey();

    public abstract byte[] input();

    public abstract String kpn();

    public abstract int maxOutLen();

    public abstract Builder toBuilder();

    public abstract String vmBizId();
}
