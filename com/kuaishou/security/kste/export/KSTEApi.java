package com.kuaishou.security.kste.export;

import com.kuaishou.security.kste.export.KSTEResult;
import com.kuaishou.security.kste.logic.base.InitCommonKSTEParams;
import com.kuaishou.security.kste.logic.base.KSTEContext;
import com.kuaishou.security.kste.logic.base.XRay;
import com.kuaishou.security.kste.logic.model.BCInvokeTask;
import com.kuaishou.security.kste.logic.model.ForwardBiz;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSTEApi {
    public static synchronized int initialize(InitCommonKSTEParams.Builder builder) {
        return XRay.get().performInit(builder.initMode(KSTEContext.Mode.ASYNC));
    }

    public static KSTEResult invoke(String str, String str2, String str3, byte[] bArr, int i) {
        if (bArr.length == 0) {
            return new KSTEResult(KSTEResult.Code.INVOKE_PARAM_INVALID, new byte[0]);
        }
        return XRay.get().invokeDirectly(BCInvokeTask.builder().appkey(str).kpn(str2).vmBizId(str3).input(bArr).maxOutLen(i).timeout(-1L).taskTag("").build());
    }

    public static void registerBizId(String str, String str2, String str3) {
        XRay.get().getFwBizIds().add(new ForwardBiz(str3, str, str2));
    }
}
