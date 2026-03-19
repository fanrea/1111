package com.kuaishou.security.kste.logic.report;

import com.kuaishou.security.kste.logic.base.KSTEConst;
import com.kuaishou.security.kste.logic.base.XRay;
import com.kuaishou.security.kste.logic.event.KSTEException;
import com.kuaishou.security.kste.logic.report.KVSecurityPerfReport;
import com.kuaishou.security.kste.logic.util.KWLog;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KVGuardPerf {

    /* renamed from: com.kuaishou.security.kste.logic.report.KVGuardPerf$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$kuaishou$security$kste$logic$report$KVGuardPerf$RType;

        static {
            RType.values();
            int[] iArr = new int[5];
            $SwitchMap$com$kuaishou$security$kste$logic$report$KVGuardPerf$RType = iArr;
            try {
                RType rType = RType.CBACK_REPORT;
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$kuaishou$security$kste$logic$report$KVGuardPerf$RType;
                RType rType2 = RType.CBACK_ONERROR;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$kuaishou$security$kste$logic$report$KVGuardPerf$RType;
                RType rType3 = RType.CBACK_R_E;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$kuaishou$security$kste$logic$report$KVGuardPerf$RType;
                RType rType4 = RType.S_PERF;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$kuaishou$security$kste$logic$report$KVGuardPerf$RType;
                RType rType5 = RType.ALL;
                iArr5[0] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum RType {
        ALL,
        CBACK_REPORT,
        CBACK_ONERROR,
        CBACK_R_E,
        S_PERF
    }

    public static void error(RType rType, String str, int i) {
        if (XRay.get().getMInitParams() == null) {
            return;
        }
        String str2 = String.format(Locale.getDefault(), "apkmd5[%s] ed[%s] me[%d]", KVSecurityUtility.get(XRay.get().getMInitParams().context()).getHostApkMd5(), str, Integer.valueOf(i));
        int iOrdinal = rType.ordinal();
        if (iOrdinal == 0) {
            KVSecurityPerfReport.report(KVSecurityPerfReport.TAG.KSG_EXCEPTION, XRay.get().getMInitParams(), str, i);
            XRay.get().getMInitParams().initCallback().report(KSTEConst.REPORT_KEY, str2);
            XRay.get().getMInitParams().initCallback().onError(new KSTEException(str2, i));
        } else {
            if (iOrdinal == 1) {
                XRay.get().getMInitParams().initCallback().report(KSTEConst.REPORT_KEY, str2);
                return;
            }
            if (iOrdinal == 2) {
                XRay.get().getMInitParams().initCallback().onError(new KSTEException(str2, i));
                return;
            }
            if (iOrdinal == 3) {
                XRay.get().getMInitParams().initCallback().report(KSTEConst.REPORT_KEY, str2);
                XRay.get().getMInitParams().initCallback().onError(new KSTEException(str2, i));
            } else if (iOrdinal != 4) {
                KWLog.info("Can't recognize report type!");
            } else {
                KVSecurityPerfReport.report(KVSecurityPerfReport.TAG.KSG_EXCEPTION, XRay.get().getMInitParams(), str, i);
            }
        }
    }
}
