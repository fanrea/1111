package com.kuaishou.security.kste.logic.base;

import android.content.Context;
import com.kuaishou.security.kste.export.IKSTECallback;
import com.kuaishou.security.kste.logic.base.AutoValue_InitCommonKSTEParams;
import com.kuaishou.security.kste.logic.base.KSTEContext;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class InitCommonKSTEParams {

    public abstract class Builder {
        public abstract Builder appKPN(String str);

        public abstract Builder appVer(String str);

        public abstract Builder appkey(String str);

        abstract InitCommonKSTEParams autoBuild();

        public InitCommonKSTEParams build() {
            return autoBuild();
        }

        public abstract Builder context(Context context);

        public abstract Builder did(String str);

        public abstract Builder initCallback(IKSTECallback iKSTECallback);

        public abstract Builder initMode(KSTEContext.Mode mode);

        public abstract Builder userId(String str);
    }

    public static Builder builder() {
        return new AutoValue_InitCommonKSTEParams.Builder();
    }

    public static InitCommonKSTEParams create(Context context, String str, IKSTECallback iKSTECallback, String str2, String str3, String str4, String str5, KSTEContext.Mode mode) {
        return builder().context(context).appkey(str).initCallback(iKSTECallback).did(str2).userId(str3).appVer(str4).appKPN(str5).initMode(mode).build();
    }

    public abstract String appKPN();

    public abstract String appVer();

    public abstract String appkey();

    public abstract Context context();

    public abstract String did();

    public abstract IKSTECallback initCallback();

    public abstract KSTEContext.Mode initMode();

    public abstract Builder toBuilder();

    public abstract String userId();
}
