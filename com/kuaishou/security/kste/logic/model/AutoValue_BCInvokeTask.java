package com.kuaishou.security.kste.logic.model;

import com.kuaishou.security.kste.logic.model.BCInvokeTask;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValue_BCInvokeTask extends BCInvokeTask {
    private final String appkey;
    private final byte[] input;
    private final String kpn;
    private final int maxOutLen;
    private final String vmBizId;

    final class Builder extends BCInvokeTask.Builder {
        private String appkey;
        private byte[] input;
        private String kpn;
        private Integer maxOutLen;
        private String taskTag;
        private Long timeout;
        private String vmBizId;

        Builder() {
        }

        private Builder(BCInvokeTask bCInvokeTask) {
            this.appkey = bCInvokeTask.appkey();
            this.kpn = bCInvokeTask.kpn();
            this.vmBizId = bCInvokeTask.vmBizId();
            this.input = bCInvokeTask.input();
            this.maxOutLen = Integer.valueOf(bCInvokeTask.maxOutLen());
        }

        @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask.Builder
        public final BCInvokeTask.Builder appkey(String str) {
            if (str == null) {
                throw new NullPointerException("Null appkey");
            }
            this.appkey = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask.Builder
        public final BCInvokeTask build() {
            String str = "";
            if (this.appkey == null) {
                str = " appkey";
            }
            if (this.kpn == null) {
                str = str + " kpn";
            }
            if (this.vmBizId == null) {
                str = str + " vmBizId";
            }
            if (this.input == null) {
                str = str + " input";
            }
            if (this.maxOutLen == null) {
                str = str + " maxOutLen";
            }
            if (this.timeout == null) {
                str = str + " timeout";
            }
            if (this.taskTag == null) {
                str = str + " taskTag";
            }
            if (str.isEmpty()) {
                return new AutoValue_BCInvokeTask(this.appkey, this.kpn, this.vmBizId, this.input, this.maxOutLen.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask.Builder
        public final BCInvokeTask.Builder input(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null input");
            }
            this.input = bArr;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask.Builder
        public final BCInvokeTask.Builder kpn(String str) {
            if (str == null) {
                throw new NullPointerException("Null kpn");
            }
            this.kpn = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask.Builder
        public final BCInvokeTask.Builder maxOutLen(int i) {
            this.maxOutLen = Integer.valueOf(i);
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask.Builder
        public final BCInvokeTask.Builder taskTag(String str) {
            if (str == null) {
                throw new NullPointerException("Null taskTag");
            }
            this.taskTag = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask.Builder
        public final BCInvokeTask.Builder timeout(long j) {
            this.timeout = Long.valueOf(j);
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask.Builder
        public final BCInvokeTask.Builder vmBizId(String str) {
            if (str == null) {
                throw new NullPointerException("Null vmBizId");
            }
            this.vmBizId = str;
            return this;
        }
    }

    private AutoValue_BCInvokeTask(String str, String str2, String str3, byte[] bArr, int i) {
        this.appkey = str;
        this.kpn = str2;
        this.vmBizId = str3;
        this.input = bArr;
        this.maxOutLen = i;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask
    public final String appkey() {
        return this.appkey;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCInvokeTask) {
            BCInvokeTask bCInvokeTask = (BCInvokeTask) obj;
            if (this.appkey.equals(bCInvokeTask.appkey()) && this.kpn.equals(bCInvokeTask.kpn()) && this.vmBizId.equals(bCInvokeTask.vmBizId())) {
                if (Arrays.equals(this.input, bCInvokeTask instanceof AutoValue_BCInvokeTask ? ((AutoValue_BCInvokeTask) bCInvokeTask).input : bCInvokeTask.input()) && this.maxOutLen == bCInvokeTask.maxOutLen()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((this.appkey.hashCode() ^ 1000003) * 1000003) ^ this.kpn.hashCode()) * 1000003) ^ this.vmBizId.hashCode()) * 1000003) ^ Arrays.hashCode(this.input)) * 1000003) ^ this.maxOutLen) * 1000003;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask
    public final byte[] input() {
        return this.input;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask
    public final String kpn() {
        return this.kpn;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask
    public final int maxOutLen() {
        return this.maxOutLen;
    }

    @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask
    public final BCInvokeTask.Builder toBuilder() {
        return new Builder(this);
    }

    public final String toString() {
        return "BCInvokeTask{appkey=" + this.appkey + ", kpn=" + this.kpn + ", vmBizId=" + this.vmBizId + ", input=" + Arrays.toString(this.input) + ", maxOutLen=" + this.maxOutLen + ", }";
    }

    @Override // com.kuaishou.security.kste.logic.model.BCInvokeTask
    public final String vmBizId() {
        return this.vmBizId;
    }
}
