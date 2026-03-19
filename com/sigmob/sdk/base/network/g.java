package com.sigmob.sdk.base.network;

import android.text.TextUtils;
import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.track.BaseMacroCommon;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.volley.NetworkResponse;
import com.czhj.volley.VolleyError;
import com.sigmob.sdk.Sigmob;
import com.sigmob.sdk.base.common.ac;
import com.sigmob.sdk.base.common.ag;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g {
    public static void a(AdTracker tracker, BaseAdUnit adUnit, boolean isMulti) {
        a(tracker, adUnit, isMulti, true, true, null);
    }

    public static void a(AdTracker tracker, final BaseAdUnit adUnit, boolean isMulti, boolean inQueue, final boolean statistic, final TrackManager.Listener listener) {
        if (tracker != null && tracker.getMessageType() == AdTracker.MessageType.TRACKING_URL) {
            if (!tracker.isTracked() || isMulti) {
                String url = tracker.getUrl();
                SigMacroCommon macroCommon = Sigmob.getInstance().getMacroCommon();
                final String strMacroProcess = adUnit == null ? macroCommon.macroProcess(url) : adUnit.getMacroCommon().macroProcess(url, macroCommon.getMacroMap());
                tracker.setUrl(strMacroProcess);
                TrackManager.sendTracking(tracker, (BaseMacroCommon) null, isMulti, inQueue, new TrackManager.Listener() { // from class: com.sigmob.sdk.base.network.g.1
                    public void onErrorResponse(AdTracker tracker2, VolleyError error) {
                        if (statistic) {
                            ac.a(tracker2, strMacroProcess, adUnit, error);
                        }
                        TrackManager.Listener listener2 = listener;
                        if (listener2 != null) {
                            listener2.onErrorResponse(tracker2, error);
                        }
                    }

                    public void onSuccess(AdTracker tracker2, NetworkResponse response) {
                        if (statistic) {
                            ac.a(tracker2, strMacroProcess, adUnit, response, (ac.a) null);
                        }
                        TrackManager.Listener listener2 = listener;
                        if (listener2 != null) {
                            listener2.onSuccess(tracker2, response);
                        }
                    }
                });
            }
        }
    }

    public static void a(BaseAdUnit adUnit, String event) {
        a(adUnit, event, false);
    }

    public static void a(BaseAdUnit adUnit, String event, boolean isMulti) {
        List<ag> adTracker;
        if (event == null || adUnit == null || TextUtils.isEmpty(event) || (adTracker = adUnit.getAdTracker(event)) == null || adTracker.isEmpty()) {
            return;
        }
        for (ag agVar : adTracker) {
            adUnit.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, "1");
            a(agVar, adUnit, isMulti);
        }
    }

    public static int b(BaseAdUnit adUnit, String eventName, boolean jsSend) {
        if (adUnit == null || TextUtils.isEmpty(eventName) || TextUtils.isEmpty(eventName)) {
            return -1;
        }
        List<ag> adTracker = adUnit.getAdTracker(eventName);
        if (adTracker == null || adTracker.isEmpty()) {
            return -2;
        }
        for (ag agVar : adTracker) {
            if (jsSend) {
                agVar.setSource("js");
            }
            adUnit.getMacroCommon().addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, "1");
            a((AdTracker) agVar, adUnit, false);
        }
        return 0;
    }
}
