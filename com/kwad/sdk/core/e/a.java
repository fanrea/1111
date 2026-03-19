package com.kwad.sdk.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.DeviceUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.e.a.b;
import com.kwad.sdk.core.e.a.d;
import com.kwad.sdk.core.e.a.e;
import com.kwad.sdk.core.e.a.f;
import com.kwad.sdk.core.e.a.g;
import com.kwad.sdk.core.e.a.j;
import com.kwad.sdk.core.e.a.k;
import com.kwad.sdk.core.e.a.l;
import com.kwad.sdk.core.e.a.m;
import com.kwad.sdk.core.e.a.n;
import com.kwad.sdk.oaid.NewOAIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.s;
import io.netty.util.internal.StringUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    static /* synthetic */ void aaX() {
    }

    public static String getAppOAID(Context context) {
        if (bd.useOaidDisable() && !TextUtils.isEmpty(bd.getDevOaid())) {
            return bd.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (bd.useOaidDisable() || !s.anZ()) {
            String strAaV = aaV();
            sOAID = strAaV;
            return strAaV;
        }
        initAsync(context);
        return sOAID;
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        h.execute(new bh() { // from class: com.kwad.sdk.core.e.a.1
            @Override // com.kwad.sdk.utils.bh
            public final void doTask() {
                String unused = a.sOAID = a.aaV();
                if (TextUtils.isEmpty(a.sOAID)) {
                    a.getOAIDNormal(context);
                    if (NewOAIDSDKHelper.isSupport()) {
                        NewOAIDSDKHelper.a(context, new NewOAIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                            @Override // com.kwad.sdk.oaid.NewOAIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.fI(str);
                                a.aaX();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void OnOAIDValid(String str) {
                                String unused2 = a.sOAID = str;
                                a.fI(str);
                                a.aaX();
                            }
                        });
                    }
                    a.sInitIng.set(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String aaV() {
        if (sHasReadSp.getAndSet(true)) {
            return sOAID;
        }
        String strH = ag.h("ksadsdk_pref", "kasd_oaid_key", "");
        sOAID = strH;
        return strH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fI(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ag.g("ksadsdk_pref", "kasd_oaid_key", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void getOAIDNormal(Context context) {
        if (!TextUtils.isEmpty(sOAID) || context == null || sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (upperCase.equals(DeviceUtils.ROM_LENOVO)) {
                        c = 7;
                        break;
                    }
                    break;
                case -1712043046:
                    if (upperCase.equals("SAMSUNG")) {
                        c = 11;
                        break;
                    }
                    break;
                case -1706170181:
                    if (upperCase.equals("XIAOMI")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1134767290:
                    if (upperCase.equals("BLACKSHARK")) {
                        c = 3;
                        break;
                    }
                    break;
                case -602397472:
                    if (upperCase.equals("ONEPLUS")) {
                        c = 5;
                        break;
                    }
                    break;
                case 89163:
                    if (upperCase.equals("ZTE")) {
                        c = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 2018896:
                    if (upperCase.equals("ASUS")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 2432928:
                    if (upperCase.equals(DeviceUtils.ROM_OPPO)) {
                        c = 4;
                        break;
                    }
                    break;
                case 2555124:
                    if (upperCase.equals("SSUI")) {
                        c = 15;
                        break;
                    }
                    break;
                case 2634924:
                    if (upperCase.equals(DeviceUtils.ROM_VIVO)) {
                        c = 6;
                        break;
                    }
                    break;
                case 68924490:
                    if (upperCase.equals("HONOR")) {
                        c = 1;
                        break;
                    }
                    break;
                case 73239724:
                    if (upperCase.equals("MEIZU")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 74632627:
                    if (upperCase.equals("NUBIA")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 630905871:
                    if (upperCase.equals("MOTOLORA")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 976565563:
                    if (upperCase.equals("FERRMEOS")) {
                        c = 14;
                        break;
                    }
                    break;
                case 2141820391:
                    if (upperCase.equals("HUAWEI")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    sOAID = new d(applicationContext).getOAID();
                    break;
                case 1:
                    sOAID = new b(applicationContext).getOAID();
                    break;
                case 2:
                case 3:
                    sOAID = new m(applicationContext).getOAID();
                    break;
                case 4:
                case 5:
                    sOAID = new j(applicationContext).getOAID();
                    break;
                case 6:
                    sOAID = new l(applicationContext).getOAID();
                    break;
                case 7:
                case '\b':
                    sOAID = new e(applicationContext).getOAID();
                    break;
                case '\t':
                    sOAID = new f(applicationContext).getOAID();
                    break;
                case '\n':
                    sOAID = new g(applicationContext).getOAID();
                    break;
                case 11:
                    sOAID = new k(applicationContext).getOAID();
                    break;
                case '\f':
                    sOAID = new com.kwad.sdk.core.e.a.a(applicationContext).getOAID();
                    break;
                case '\r':
                case 14:
                case 15:
                    sOAID = new n(applicationContext).getOAID();
                    break;
            }
            c.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + sOAID);
            if (TextUtils.isEmpty(sOAID)) {
                sGetOaidFail = true;
            }
            fI(sOAID);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }
}
