package com.pangrowth.adclog;

import android.content.Intent;
import com.bytedance.sdk.djx.core.log.ILogConst;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class p implements Object<Intent> {
    public String a(Intent intent) throws NoSuchMethodException, SecurityException {
        if (intent == null) {
            return ILogConst.CACHE_PLAY_REASON_NULL;
        }
        StringBuilder sb = new StringBuilder(128);
        sb.append("Intent { ");
        i.a(intent, sb);
        sb.append(" }");
        return sb.toString();
    }
}
