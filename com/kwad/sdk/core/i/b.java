package com.kwad.sdk.core.i;

import android.app.ActivityManager;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.LocaleList;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bs;
import com.kwad.sdk.utils.m;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b implements c {
    private static Locale bIm;
    private String bDs;
    private boolean bIk = true;
    private Map<String, String> bIl = new LinkedHashMap();

    private static long bg(long j) {
        if (j > 524288000) {
            return 524288000L;
        }
        return j;
    }

    @Override // com.kwad.sdk.core.i.c
    public final void cA(boolean z) {
        this.bIk = z;
    }

    @Override // com.kwad.sdk.core.i.c
    public final String acz() {
        return this.bIk ? "kwai-android aegon/4.6.3.1" : "kwai-android aegon/4.6.3";
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bY(Context context) {
        return cb(context);
    }

    @Override // com.kwad.sdk.core.i.c
    public final String bZ(Context context) {
        try {
            if (this.bIl.isEmpty()) {
                ca(context);
            }
            StringBuilder sbAcA = acA();
            if (this.bIk) {
                sbAcA.insert(0, " KRN/3.6.6");
            }
            return sbAcA.toString();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.w("KwaiUAGetter", "getWebViewUASuffix: " + th.getMessage());
            return "";
        }
    }

    private void ca(Context context) {
        this.bIl.put("Yoda", "3.2.11-rc1");
        this.bIl.put("Kwai", "11.8.10");
        this.bIl.put("OS_PRO_BIT", String.valueOf(AbiUtil.isArm64(context) ? 1 : 0));
        this.bIl.put("MAX_PHY_MEM", String.valueOf(bs.eK(context) >> 20));
        this.bIl.put("KDT", "PHONE");
        this.bIl.put("AZPREFIX", "az4");
        this.bIl.put("ICFO", "0");
        this.bIl.put("StatusHT", String.valueOf(com.kwad.sdk.c.a.a.bt(context)));
        this.bIl.put("TitleHT", "44");
        this.bIl.put("NetType", cc(context));
        this.bIl.put("ISLP", String.valueOf(cd(context)));
        this.bIl.put("ISDM", String.valueOf(ce(context)));
        int iEJ = bs.eJ(context);
        this.bIl.put("ISLB", String.valueOf((iEJ <= 0 || iEJ >= 15) ? 0 : 1));
        this.bIl.put("locale", acB());
        this.bIl.put("SHP", String.valueOf(m.getScreenHeight(context)));
        this.bIl.put("SWP", String.valueOf(m.getScreenWidth(context)));
        this.bIl.put("SD", String.valueOf(m.di(context)));
        this.bIl.put("CD", "0");
        this.bIl.put("ISLM", String.valueOf(cf(context)));
    }

    private StringBuilder acA() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.bIl.entrySet()) {
            sb.append(" ").append(entry.getKey()).append("/").append(entry.getValue());
        }
        return sb;
    }

    private String cb(Context context) {
        if (!TextUtils.isEmpty(this.bDs)) {
            return this.bDs;
        }
        if (context == null) {
            return "";
        }
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        if (!TextUtils.isEmpty(this.bDs)) {
            return this.bDs;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.bDs = WebSettings.getDefaultUserAgent(context);
        } else {
            this.bDs = System.getProperty("http.agent");
        }
        return this.bDs;
    }

    private static String cc(Context context) {
        NetworkInfo networkInfoDW;
        if (context == null || (networkInfoDW = ao.dW(context)) == null) {
            return "DISABLE";
        }
        int type = networkInfoDW.getType();
        if (type != 0) {
            return type != 1 ? "unknown" : "WIFI";
        }
        String subtypeName = networkInfoDW.getSubtypeName();
        return TextUtils.isEmpty(subtypeName) ? networkInfoDW.getTypeName() : subtypeName;
    }

    private static int cd(Context context) {
        return !AbiUtil.isArm64(context) || ((bs.eK(context) >> 20) > 4096L ? 1 : ((bs.eK(context) >> 20) == 4096L ? 0 : -1)) <= 0 ? 1 : 0;
    }

    private static int ce(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 48) == 32 ? 1 : 0;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return 0;
        }
    }

    private static int cf(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return !memoryInfo.lowMemory && (memoryInfo.availMem > (bg(memoryInfo.threshold) + bh(Debug.getPss())) ? 1 : (memoryInfo.availMem == (bg(memoryInfo.threshold) + bh(Debug.getPss())) ? 0 : -1)) > 0 ? 0 : 1;
    }

    private static String acB() {
        if (Build.VERSION.SDK_INT >= 24) {
            bIm = LocaleList.getDefault().get(0);
        } else {
            bIm = Locale.getDefault();
        }
        if (bIm == null) {
            bIm = Locale.CHINESE;
        }
        return bIm.getLanguage();
    }

    private static long bh(long j) {
        long j2;
        long j3 = j / 512000;
        if (j3 == 0) {
            return 524288000L;
        }
        if (j3 == 1) {
            j2 = j / 2;
        } else {
            j2 = j / 3;
        }
        return j2 * 1024;
    }
}
