package com.kwai.video.ksliveplayer;

import com.kwai.middleware.azeroth.Azeroth;
import com.kwai.middleware.azeroth.logger.CommonParams;
import com.kwai.middleware.azeroth.logger.CustomProtoEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KSLivePlayerLogUploader {
    private static final String SDK_NAME = "KSLivePlayer";

    private KSLivePlayerLogUploader() {
    }

    public static void logEvent(String str, String str2) throws JSONException {
        logEvent(str, str2, false);
    }

    public static void logEvent(String str, String str2, boolean z) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("element_action", str);
            jSONObject.put("content_package", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Azeroth.get().getLogger().addCustomProtoEvent(CustomProtoEvent.builder().type("vp_stat_event").payload(jSONObject).commonParams(CommonParams.builder().realtime(z).sdkName("KSLivePlayer").build()).build());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int convertPageType(java.lang.String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = -1999289321(0xffffffff88d54417, float:-1.2835479E-33)
            r2 = 3
            r3 = 0
            r4 = 2
            r5 = 1
            if (r0 == r1) goto L3a
            r1 = -1057247979(0xffffffffc0fbad15, float:-7.864878)
            if (r0 == r1) goto L30
            r1 = 2285(0x8ed, float:3.202E-42)
            if (r0 == r1) goto L26
            r1 = 2366543(0x241c4f, float:3.316233E-39)
            if (r0 == r1) goto L1c
            goto L44
        L1c:
            java.lang.String r0 = "MINA"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L44
            r6 = 2
            goto L45
        L26:
            java.lang.String r0 = "H5"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L44
            r6 = 1
            goto L45
        L30:
            java.lang.String r0 = "UNKNOWN_PAGE_TYPE"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L44
            r6 = 3
            goto L45
        L3a:
            java.lang.String r0 = "NATIVE"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L44
            r6 = 0
            goto L45
        L44:
            r6 = -1
        L45:
            if (r6 == 0) goto L4e
            if (r6 == r5) goto L4d
            if (r6 == r4) goto L4c
            return r3
        L4c:
            return r2
        L4d:
            return r4
        L4e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwai.video.ksliveplayer.KSLivePlayerLogUploader.convertPageType(java.lang.String):int");
    }
}
