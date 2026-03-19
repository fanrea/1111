package com.qq.e.comm.plugin;

import com.qq.e.mediation.interfaces.INoticeUrlProvider;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class kx {
    private static INoticeUrlProvider a(tr trVar) {
        if (trVar == null) {
            return null;
        }
        try {
            String strE = trVar.e();
            return (INoticeUrlProvider) Class.forName(strE.split(strE.split("(\\w+\\.){2}")[r1.length - 1])[0] + INoticeUrlProvider.IMPL_CLASS_NAME).asSubclass(INoticeUrlProvider.class).newInstance();
        } catch (Exception e) {
            e.toString();
            return null;
        }
    }

    public static void a(qy qyVar, tr trVar, boolean z, boolean z2, String str) {
        INoticeUrlProvider iNoticeUrlProviderA;
        if (qyVar == null || (iNoticeUrlProviderA = a(trVar)) == null) {
            return;
        }
        if (z) {
            zt.a(iNoticeUrlProviderA.getAssembledWinNoticeUrl(qyVar.h(), str, z2));
        } else {
            zt.a(iNoticeUrlProviderA.getAssembledLossNoticeUrl(qyVar.e(), str, z2));
        }
        if (z2) {
            return;
        }
        List<String> listD = qyVar.d();
        for (int i = 0; i < listD.size(); i++) {
            zt.a(iNoticeUrlProviderA.getOtherAssembledLossNoticeUrl(listD.get(i), str));
        }
    }
}
