package com.kwad.sdk.mobileid;

import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.mobileid.a.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private static String TAG = "MobileIdManager";
    public static com.kwad.sdk.mobileid.a.a.a cfY;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
        d dVarAlM = alM();
        if (dVarAlM.isSuccess()) {
            dVarAlM = alJ();
            com.kwad.sdk.core.d.c.d(TAG, "init success :" + dVarAlM);
        } else {
            com.kwad.sdk.core.d.c.d(TAG, "init error: " + dVarAlM.alR());
        }
        c.a(context, dVarAlM);
    }

    private static d alJ() {
        d dVar;
        Context context = mContext;
        int iD = ao.d(context, be.el(context), bd.useNetworkStateDisable());
        try {
            if (!ao.isWifiConnected(mContext)) {
                dVar = new d(true, "uaidTokenCanRequest");
                new com.kwad.sdk.mobileid.a.a().cG(mContext);
                com.kwad.sdk.core.d.c.w(TAG, "requestMobileIdByMobileData");
            } else {
                boolean z = iD == 1;
                boolean z2 = !alK();
                if (z && z2) {
                    dVar = new d(true, "uaidTokenCanRequestByWifi");
                    h.schedule(new bh() { // from class: com.kwad.sdk.mobileid.a.1
                        @Override // com.kwad.sdk.utils.bh
                        public final void doTask() {
                            a.cF(a.mContext);
                            com.kwad.sdk.core.d.c.w(a.TAG, "requestMobileIdChangeToyMobileData");
                            h.schedule(new bh() { // from class: com.kwad.sdk.mobileid.a.1.1
                                @Override // com.kwad.sdk.utils.bh
                                public final void doTask() {
                                    a.alL();
                                    com.kwad.sdk.core.d.c.w(a.TAG, "schedule unbindNetwork");
                                }
                            }, 2L, TimeUnit.SECONDS);
                        }
                    }, e.YY(), TimeUnit.SECONDS);
                } else if (z) {
                    dVar = new d(false, "noRequestByBrand");
                } else if (z2) {
                    dVar = new d(false, "noRequestByNoCMCC");
                } else {
                    dVar = new d(false, "noRequestByBrandAndCMCC");
                }
            }
            return dVar;
        } catch (Exception e) {
            d dVar2 = new d(false, "noRequestByException");
            dVar2.hK(e.getMessage());
            ServiceProvider.reportSdkCaughtException(e);
            return dVar2;
        }
    }

    private static boolean alK() {
        String str = Build.MANUFACTURER;
        com.kwad.sdk.core.d.c.w(TAG, "isHuaweiOrHonorDevice manufacturer: " + str);
        return "HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cF(final Context context) {
        if (cfY == null) {
            cfY = new com.kwad.sdk.mobileid.a.a.a();
        }
        c.b(context, new d(true, "uaidTokenCanRequestByWifiPre"));
        cfY.a(context, new a.InterfaceC0627a() { // from class: com.kwad.sdk.mobileid.a.2
            @Override // com.kwad.sdk.mobileid.a.a.a.InterfaceC0627a
            public final void alQ() {
                new com.kwad.sdk.mobileid.a.a().b(context, true);
            }
        });
    }

    public static void alL() {
        synchronized (a.class) {
            if (cfY != null) {
                com.kwad.sdk.core.d.c.w(TAG, "unbindNetwork");
                cfY.alL();
            }
        }
    }

    private static d alM() {
        String str;
        boolean zAov = ag.aov();
        boolean z = zAov && !ag.aoI() && alN();
        if (!zAov) {
            str = "noRequestByUaidEnable";
        } else if (ag.aoI()) {
            str = "noRequestByUaidExist";
        } else {
            str = !alN() ? "noNetworkPermission" : "uaidTokenCanRequest";
        }
        return new d(z, str);
    }

    private static boolean alN() {
        String[] strArr = {g.b, g.d, "android.permission.CHANGE_NETWORK_STATE", g.a};
        for (int i = 0; i < 4; i++) {
            if (ActivityCompat.checkSelfPermission(ServiceProvider.getContext(), strArr[i]) != 0) {
                return false;
            }
        }
        return true;
    }
}
