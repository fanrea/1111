package com.qq.e.comm.plugin;

import com.bytedance.pangle.provider.ContentProviderManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class va {
    public static void a(Object obj, int i, Exception exc) {
        String str = obj instanceof String ? (String) obj : "";
        String message = exc != null ? exc.getMessage() : "";
        qc qcVar = new qc(1210043);
        qcVar.d(i);
        qcVar.a(new ja().a(ContentProviderManager.PROVIDER_URI, str).a("msg", message));
        b10.a(qcVar);
    }
}
