package com.bytedance.sdk.djx.core.util;

import com.bytedance.sdk.djx.core.settings.SettingData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: DidDegradeUtil.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u0004H\u0007R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/djx/core/util/DidDegradeUtil;", "", "()V", "errCode11", "", "getErrCode11$annotations", "getErrCode11", "()Z", "setErrCode11", "(Z)V", "isDegrade", "base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DidDegradeUtil {
    public static final DidDegradeUtil INSTANCE = new DidDegradeUtil();
    private static boolean errCode11;

    @JvmStatic
    public static /* synthetic */ void getErrCode11$annotations() {
    }

    private DidDegradeUtil() {
    }

    public static final boolean getErrCode11() {
        return errCode11;
    }

    public static final void setErrCode11(boolean z) {
        errCode11 = z;
    }

    @JvmStatic
    public static final boolean isDegrade() {
        return SettingData.getInstance().getDidDegrade() == 1 || errCode11;
    }
}
