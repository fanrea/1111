package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bi {
    private static Context bpl;
    private static Map<String, l> cmW = new HashMap();

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            com.kwad.sdk.core.d.c.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        if (apB()) {
            if (cmW.containsKey("baseStationEnable")) {
                boolean zUd = hVar.Ud();
                l lVarID = iD("baseStationEnable");
                if (lVarID != null) {
                    lVarID.dx(zUd);
                }
            }
            if (cmW.containsKey("simCardInfoEnable")) {
                boolean zUb = hVar.Ub();
                l lVarID2 = iD("simCardInfoEnable");
                if (lVarID2 != null) {
                    lVarID2.dx(zUb);
                    return;
                }
                return;
            }
            return;
        }
        bpl = context.getApplicationContext();
        cmW.put("baseStationEnable", new a(hVar.Ud()));
        cmW.put("simCardInfoEnable", new b(hVar.Ub()));
    }

    private static <T> l<T> iD(String str) {
        try {
            return cmW.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static com.kwad.sdk.l.a.b ang() {
        if (apB()) {
            return (com.kwad.sdk.l.a.b) iE("baseStationEnable");
        }
        return null;
    }

    public static com.kwad.sdk.l.a.f anh() {
        if (apB()) {
            return (com.kwad.sdk.l.a.f) iE("simCardInfoEnable");
        }
        return null;
    }

    private static <T> T iE(String str) {
        l lVarID = iD(str);
        if (lVarID != null) {
            return (T) lVarID.da(bpl);
        }
        return null;
    }

    private static boolean apB() {
        return bpl != null;
    }

    static class a extends l<com.kwad.sdk.l.a.b> {
        private static com.kwad.sdk.l.a.b cmX;

        public a(boolean z) {
            super(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.l
        /* renamed from: eC, reason: merged with bridge method [inline-methods] */
        public com.kwad.sdk.l.a.b db(Context context) {
            int lac;
            int cid;
            if (bd.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).aH(64L)) {
                return cmX;
            }
            com.kwad.sdk.l.a.b bVar = cmX;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || bd.readLocationDisable()) {
                return null;
            }
            int iA = -1;
            if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1) {
                return null;
            }
            if (bs.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                CellLocation cellLocation = telephonyManager.getCellLocation();
                if (cellLocation instanceof CdmaCellLocation) {
                    CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                    cid = cdmaCellLocation.getBaseStationId();
                    lac = cdmaCellLocation.getNetworkId();
                } else if (cellLocation instanceof GsmCellLocation) {
                    GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                    cid = gsmCellLocation.getCid();
                    lac = gsmCellLocation.getLac();
                } else {
                    lac = -1;
                    cid = -1;
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CellInfo next = it.next();
                        if (next != null && next.isRegistered()) {
                            cellInfo = next;
                            break;
                        }
                    }
                    if (cellInfo != null) {
                        iA = a(cellInfo);
                    }
                }
                cmX = new com.kwad.sdk.l.a.b(cid, lac, iA);
            }
            return cmX;
        }

        private static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) z.callMethod(cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }
    }

    static class b extends l<com.kwad.sdk.l.a.f> {
        @Override // com.kwad.sdk.utils.l
        protected final /* synthetic */ com.kwad.sdk.l.a.f db(Context context) {
            return eD(context);
        }

        public b(boolean z) {
            super(z);
        }

        private static com.kwad.sdk.l.a.f eD(Context context) {
            com.kwad.sdk.l.a.f fVar = new com.kwad.sdk.l.a.f();
            fVar.cjG = be.ep(context);
            fVar.cjF = be.en(context);
            return fVar;
        }
    }
}
