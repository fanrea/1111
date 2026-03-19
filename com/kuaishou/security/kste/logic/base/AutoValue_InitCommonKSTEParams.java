package com.kuaishou.security.kste.logic.base;

import android.content.Context;
import com.alipay.sdk.m.u.i;
import com.kuaishou.security.kste.export.IKSTECallback;
import com.kuaishou.security.kste.logic.base.InitCommonKSTEParams;
import com.kuaishou.security.kste.logic.base.KSTEContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class AutoValue_InitCommonKSTEParams extends InitCommonKSTEParams {
    private final String appKPN;
    private final String appVer;
    private final String appkey;
    private final Context context;
    private final String did;
    private final IKSTECallback initCallback;
    private final KSTEContext.Mode initMode;
    private final String userId;

    final class Builder extends InitCommonKSTEParams.Builder {
        private String appKPN;
        private String appVer;
        private String appkey;
        private Context context;
        private String did;
        private IKSTECallback initCallback;
        private KSTEContext.Mode initMode;
        private String userId;

        Builder() {
        }

        private Builder(InitCommonKSTEParams initCommonKSTEParams) {
            this.context = initCommonKSTEParams.context();
            this.appkey = initCommonKSTEParams.appkey();
            this.initCallback = initCommonKSTEParams.initCallback();
            this.did = initCommonKSTEParams.did();
            this.userId = initCommonKSTEParams.userId();
            this.appVer = initCommonKSTEParams.appVer();
            this.appKPN = initCommonKSTEParams.appKPN();
            this.initMode = initCommonKSTEParams.initMode();
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        public final InitCommonKSTEParams.Builder appKPN(String str) {
            if (str == null) {
                throw new NullPointerException("Null appKPN");
            }
            this.appKPN = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        public final InitCommonKSTEParams.Builder appVer(String str) {
            if (str == null) {
                throw new NullPointerException("Null appVer");
            }
            this.appVer = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        public final InitCommonKSTEParams.Builder appkey(String str) {
            if (str == null) {
                throw new NullPointerException("Null appkey");
            }
            this.appkey = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        final InitCommonKSTEParams autoBuild() {
            String str = "";
            if (this.context == null) {
                str = " context";
            }
            if (this.appkey == null) {
                str = str + " appkey";
            }
            if (this.initCallback == null) {
                str = str + " initCallback";
            }
            if (this.did == null) {
                str = str + " did";
            }
            if (this.userId == null) {
                str = str + " userId";
            }
            if (this.appVer == null) {
                str = str + " appVer";
            }
            if (this.appKPN == null) {
                str = str + " appKPN";
            }
            if (this.initMode == null) {
                str = str + " initMode";
            }
            if (str.isEmpty()) {
                return new AutoValue_InitCommonKSTEParams(this.context, this.appkey, this.initCallback, this.did, this.userId, this.appVer, this.appKPN, this.initMode);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        public final InitCommonKSTEParams.Builder context(Context context) {
            if (context == null) {
                throw new NullPointerException("Null context");
            }
            this.context = context;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        public final InitCommonKSTEParams.Builder did(String str) {
            if (str == null) {
                throw new NullPointerException("Null did");
            }
            this.did = str;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        public final InitCommonKSTEParams.Builder initCallback(IKSTECallback iKSTECallback) {
            if (iKSTECallback == null) {
                throw new NullPointerException("Null initCallback");
            }
            this.initCallback = iKSTECallback;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        public final InitCommonKSTEParams.Builder initMode(KSTEContext.Mode mode) {
            if (mode == null) {
                throw new NullPointerException("Null initMode");
            }
            this.initMode = mode;
            return this;
        }

        @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams.Builder
        public final InitCommonKSTEParams.Builder userId(String str) {
            if (str == null) {
                throw new NullPointerException("Null userId");
            }
            this.userId = str;
            return this;
        }
    }

    private AutoValue_InitCommonKSTEParams(Context context, String str, IKSTECallback iKSTECallback, String str2, String str3, String str4, String str5, KSTEContext.Mode mode) {
        this.context = context;
        this.appkey = str;
        this.initCallback = iKSTECallback;
        this.did = str2;
        this.userId = str3;
        this.appVer = str4;
        this.appKPN = str5;
        this.initMode = mode;
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final String appKPN() {
        return this.appKPN;
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final String appVer() {
        return this.appVer;
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final String appkey() {
        return this.appkey;
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final Context context() {
        return this.context;
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final String did() {
        return this.did;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InitCommonKSTEParams) {
            InitCommonKSTEParams initCommonKSTEParams = (InitCommonKSTEParams) obj;
            if (this.context.equals(initCommonKSTEParams.context()) && this.appkey.equals(initCommonKSTEParams.appkey()) && this.initCallback.equals(initCommonKSTEParams.initCallback()) && this.did.equals(initCommonKSTEParams.did()) && this.userId.equals(initCommonKSTEParams.userId()) && this.appVer.equals(initCommonKSTEParams.appVer()) && this.appKPN.equals(initCommonKSTEParams.appKPN()) && this.initMode.equals(initCommonKSTEParams.initMode())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((((((((this.context.hashCode() ^ 1000003) * 1000003) ^ this.appkey.hashCode()) * 1000003) ^ this.initCallback.hashCode()) * 1000003) ^ this.did.hashCode()) * 1000003) ^ this.userId.hashCode()) * 1000003) ^ this.appVer.hashCode()) * 1000003) ^ this.appKPN.hashCode()) * 1000003) ^ this.initMode.hashCode();
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final IKSTECallback initCallback() {
        return this.initCallback;
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final KSTEContext.Mode initMode() {
        return this.initMode;
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final InitCommonKSTEParams.Builder toBuilder() {
        return new Builder(this);
    }

    public final String toString() {
        return "InitCommonKSTEParams{context=" + this.context + ", appkey=" + this.appkey + ", initCallback=" + this.initCallback + ", did=" + this.did + ", userId=" + this.userId + ", appVer=" + this.appVer + ", appKPN=" + this.appKPN + ", initMode=" + this.initMode + i.d;
    }

    @Override // com.kuaishou.security.kste.logic.base.InitCommonKSTEParams
    public final String userId() {
        return this.userId;
    }
}
