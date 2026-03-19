package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.network.SigmobRequestUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.o;
import com.sigmob.windad.WindAdError;
import java.net.URL;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class e {

    public interface a {
        void a(int error, String message, String requestId, LoadAdRequest loadAdRequest);

        void a(List<BaseAdUnit> adUnit, LoadAdRequest loadAdRequest);
    }

    public static void a(LoadAdRequest loadAdRequest, a listener) {
        if (Networking.getSigRequestQueue() == null) {
            a(listener, WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), "request queue is null", null, loadAdRequest);
            return;
        }
        try {
            String strR = loadAdRequest.getAdType() == 5 ? o.a().R() : o.a().t();
            try {
                if (!TextUtils.isEmpty(loadAdRequest.getBidToken())) {
                    strR = o.a().u();
                }
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
            if (TextUtils.isEmpty(strR)) {
                a(listener, WindAdError.ERROR_SIGMOB_BAD_REQUEST.getErrorCode(), WindAdError.ERROR_SIGMOB_BAD_REQUEST.getMessage(), null, loadAdRequest);
            } else if (SigmobRequestUtil.isConnection(new URL(strR).getHost())) {
                Networking.getSigRequestQueue().add(new com.sigmob.sdk.base.network.a(strR, loadAdRequest, listener));
            } else {
                a(listener, WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), "network is disconnection", null, loadAdRequest);
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            a(listener, WindAdError.ERROR_SIGMOB_NETWORK.getErrorCode(), th2.getMessage(), null, loadAdRequest);
        }
    }

    public static void a(a listener, int errCode, String errorMsg, String requestId, LoadAdRequest loadAdRequest) {
        if (listener == null) {
            return;
        }
        listener.a(errCode, errorMsg, requestId, loadAdRequest);
        com.sigmob.sdk.manager.d.a().a(loadAdRequest);
    }

    public static void a(a listener, List<BaseAdUnit> adUnit, LoadAdRequest loadAdRequest) {
        if (listener == null) {
            return;
        }
        listener.a(adUnit, loadAdRequest);
        com.sigmob.sdk.manager.d.a().a(loadAdRequest);
    }
}
