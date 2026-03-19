package com.kwad.components.core.request.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import com.kwad.sdk.l.a.d;
import com.kwad.sdk.l.a.e;
import com.kwad.sdk.l.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.ce;
import com.kwad.sdk.utils.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b implements com.kwad.sdk.core.b {
    private String NI;
    private int RV;
    private int YW;
    private String YX;
    private Long YY;
    private Long YZ;
    private Long Za;
    private Long Zb;
    private String Zc;
    private String Zd;
    private long Zf;
    private String Zg;
    private long Zh;
    private String Zj;
    private String Zk;
    private boolean Zl;
    private List<a> Zm;
    private f Zn;
    private d Zo;
    private com.kwad.sdk.l.a.b Zp;
    private List<e> Zq;
    private List<ce.a> Ze = new CopyOnWriteArrayList();
    private int Zi = -1;
    private float screenBrightness = -1.0f;
    private int RY = -1;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    private static Context getContext() {
        return ServiceProvider.anu();
    }

    public static b sL() {
        b bVar = new b();
        bVar.YW = bs.apX();
        bVar.YX = AbiUtil.cN(getContext());
        bVar.RV = bs.eJ(getContext());
        bVar.YY = Long.valueOf(bs.eK(getContext()));
        bVar.YZ = Long.valueOf(bs.eG(getContext()));
        bVar.Za = Long.valueOf(bs.apU());
        bVar.Zb = Long.valueOf(bs.apV());
        bVar.Zc = be.el(getContext());
        bVar.Zd = be.em(getContext());
        bVar.Ze.addAll(be.r(getContext(), 15));
        bVar.Zf = bs.aqc();
        bVar.Zh = bs.aqd();
        bVar.Zk = bs.aqe();
        bVar.Zj = bs.aqf();
        bVar.NI = bs.aqg();
        bVar.Zg = bs.aqh();
        Context context = getContext();
        if (context != null) {
            bVar.Zi = bs.eR(context);
            bVar.Zm = new CopyOnWriteArrayList(a.aB(context));
            bVar.aA(context);
        }
        bVar.Zo = r.anV();
        bVar.Zp = be.ang();
        bVar.Zq = bk.apD().apE();
        bVar.Zn = be.anh();
        return bVar;
    }

    private void aA(Context context) {
        if (com.kwad.sdk.core.config.e.aH(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
            if (intentRegisterReceiver != null) {
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                this.Zl = intExtra == 2 || intExtra == 5;
                int intExtra2 = intentRegisterReceiver.getIntExtra("plugged", -1);
                if (intExtra2 == 2) {
                    this.RY = 1;
                    return;
                }
                if (intExtra2 == 1) {
                    this.RY = 2;
                } else if (intExtra2 == 4) {
                    this.RY = 3;
                } else if (intExtra2 == 0) {
                    this.RY = 0;
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "cpuCount", this.YW);
        aa.putValue(jSONObject, "cpuAbi", this.YX);
        aa.putValue(jSONObject, "batteryPercent", this.RV);
        aa.putValue(jSONObject, "totalMemorySize", this.YY.longValue());
        aa.putValue(jSONObject, "availableMemorySize", this.YZ.longValue());
        aa.putValue(jSONObject, "totalDiskSize", this.Za.longValue());
        aa.putValue(jSONObject, "availableDiskSize", this.Zb.longValue());
        aa.putValue(jSONObject, "imsi", this.Zc);
        aa.putValue(jSONObject, "iccid", this.Zd);
        aa.putValue(jSONObject, "wifiList", this.Ze);
        aa.putValue(jSONObject, "bootTime", this.Zf);
        aa.putValue(jSONObject, "romName", this.NI);
        aa.putValue(jSONObject, "romVersion", this.Zg);
        aa.putValue(jSONObject, "romBuildTimestamp", this.Zh);
        aa.putValue(jSONObject, "ringerMode", this.Zi);
        aa.putValue(jSONObject, "audioStreamInfo", this.Zm);
        aa.putValue(jSONObject, "baseBandVersion", this.Zj);
        aa.putValue(jSONObject, "fingerPrint", this.Zk);
        aa.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        aa.putValue(jSONObject, "isCharging", this.Zl);
        aa.putValue(jSONObject, "chargeType", this.RY);
        f fVar = this.Zn;
        if (fVar != null) {
            aa.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.Zo;
        if (dVar != null) {
            aa.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.l.a.b bVar = this.Zp;
        if (bVar != null) {
            aa.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.Zq;
        if (list != null) {
            aa.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }

    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int Zr = -1;
        public int Zs = -1;
        public int Zt = -1;
        public int streamType;

        private static int bb(int i) {
            if (i != 0) {
                if (i == 1) {
                    return 1;
                }
                if (i == 2) {
                    return 2;
                }
                if (i == 3) {
                    return 3;
                }
                if (i == 4) {
                    return 4;
                }
                if (i == 5) {
                    return 5;
                }
            }
            return 0;
        }

        private a(int i) {
            this.streamType = i;
        }

        public static List<a> aB(Context context) {
            AudioManager audioManager;
            ArrayList arrayList = new ArrayList();
            if (context == null || com.kwad.sdk.core.config.e.aH(256L)) {
                return arrayList;
            }
            try {
                audioManager = (AudioManager) context.getSystemService("audio");
            } catch (Exception unused) {
            }
            if (audioManager == null) {
                return arrayList;
            }
            for (int i = 0; i <= 5; i++) {
                a aVar = new a(i);
                int iBb = bb(i);
                aVar.Zt = audioManager.getStreamVolume(iBb);
                aVar.Zr = audioManager.getStreamMaxVolume(iBb);
                if (Build.VERSION.SDK_INT >= 28) {
                    aVar.Zs = audioManager.getStreamMinVolume(iBb);
                }
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }
}
