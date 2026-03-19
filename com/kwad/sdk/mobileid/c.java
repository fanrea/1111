package com.kwad.sdk.mobileid;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bh;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c {
    private static String traceId;

    public static void a(Context context, d dVar) {
        traceId = UUID.randomUUID().toString();
        x(a(context, 1, dVar));
    }

    public static void b(Context context, d dVar) {
        x(a(context, 2, dVar));
    }

    public static void a(Context context, CMTokenResponse cMTokenResponse) {
        UaidInfo uaidInfoA = a(context, 3, new d(true, "uaidTokenCanRequest"));
        uaidInfoA.token = cMTokenResponse.getResultToken();
        uaidInfoA.errorCode = cMTokenResponse.getResultCode();
        uaidInfoA.errorMsg = cMTokenResponse.getResultMsg();
        uaidInfoA.result = !TextUtils.isEmpty(uaidInfoA.token) ? 1 : 0;
        x(uaidInfoA);
    }

    public static void b(Context context, int i, String str) {
        UaidInfo uaidInfoA = a(context, 3, new d(false, "uaidTokenCanRequest"));
        uaidInfoA.token = null;
        uaidInfoA.errorCode = new StringBuilder().append(i).toString();
        uaidInfoA.errorMsg = str;
        uaidInfoA.result = 0;
        x(uaidInfoA);
    }

    public static void c(Context context, d dVar) {
        x(a(context, 4, dVar));
    }

    public static void a(Context context, UaidTokenResponse uaidTokenResponse) {
        UaidInfo uaidInfoA = a(context, 5, new d(true, "uaidTokenCanRequest"));
        uaidInfoA.uaid = uaidTokenResponse.uaid;
        uaidInfoA.errorCode = new StringBuilder().append(uaidTokenResponse.result).toString();
        uaidInfoA.errorMsg = uaidTokenResponse.errorMsg;
        uaidInfoA.result = !TextUtils.isEmpty(uaidInfoA.token) ? 1 : 0;
        x(uaidInfoA);
    }

    public static void c(Context context, int i, String str) {
        UaidInfo uaidInfoA = a(context, 5, new d(false, "uaidTokenCanRequest"));
        uaidInfoA.uaid = null;
        uaidInfoA.errorCode = new StringBuilder().append(i).toString();
        uaidInfoA.errorMsg = str;
        uaidInfoA.result = 0;
        x(uaidInfoA);
    }

    private static UaidInfo a(Context context, int i, d dVar) {
        boolean zUseNetworkStateDisable = bd.useNetworkStateDisable();
        boolean zUsePhoneStateDisable = bd.usePhoneStateDisable();
        String strEl = be.el(context);
        return UaidInfo.newBuilder().gQ(i).hM(traceId).hL(dVar.alR()).hN(dVar.alS()).gR(ao.d(context, strEl, zUseNetworkStateDisable)).gS(ao.dX(context)).dl((strEl == null || TextUtils.isEmpty(strEl.trim())) ? false : true).dj(!zUseNetworkStateDisable).dk(!zUsePhoneStateDisable).alT();
    }

    private static void x(final com.kwad.sdk.commercial.c.a aVar) {
        GlobalThreadPools.acm().execute(new bh() { // from class: com.kwad.sdk.mobileid.c.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                if (aVar != null) {
                    com.kwad.sdk.core.d.c.d("UAIDMonitor", "asyncReport json: " + aVar.toJson().toString());
                }
                com.kwad.sdk.commercial.b.v(aVar);
            }
        });
    }
}
