package com.kwad.sdk.liteapi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.DeviceUtils;
import com.kwad.sdk.api.a.b;
import com.kwad.sdk.liteapi.LiteOADIDSDKHelper25;
import com.kwad.sdk.liteapi.oaid.OADIDSDKHelper;
import com.kwad.sdk.liteapi.oaid.helpers.ASUSDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.HONORDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.HWDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.LenovoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.MeizuDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.NubiaDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.OppoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.SamsungDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.VivoDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.XiaomiDeviceIDHelper;
import com.kwad.sdk.liteapi.oaid.helpers.ZTEDeviceIDHelper;
import io.netty.util.internal.StringUtil;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LiteOAIDHelper {
    private static final String KEY_OAID = "kasd_oaid_key";
    private static final String TAG = "OAIDHelper";
    private static boolean sGetOaidFail = false;
    private static String sOAID = "";
    private static final AtomicBoolean sInitIng = new AtomicBoolean();
    private static final AtomicBoolean sHasReadSp = new AtomicBoolean();

    public static String getAppOAID(Context context) {
        if (LiteSDKDeviceController.useOaidDisable() && !TextUtils.isEmpty(LiteSDKDeviceController.getDevOaid())) {
            return LiteSDKDeviceController.getDevOaid();
        }
        if (!TextUtils.isEmpty(sOAID)) {
            return sOAID;
        }
        if (LiteSDKDeviceController.useOaidDisable()) {
            return sOAID;
        }
        initAsync(context);
        return sOAID;
    }

    public static String obtainCurrent() {
        return sOAID;
    }

    private static void initAsync(final Context context) {
        if (context == null || sInitIng.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new b() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                if (TextUtils.isEmpty(LiteOAIDHelper.sOAID)) {
                    LiteOAIDHelper.getOAIDNormal(context);
                    if (OADIDSDKHelper.isSupport()) {
                        OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1.1
                            @Override // com.kwad.sdk.liteapi.oaid.OADIDSDKHelper.a
                            public final void OnOAIDValid(String str) {
                                String unused = LiteOAIDHelper.sOAID = str;
                            }
                        });
                    } else if (LiteOADIDSDKHelper25.isSupport()) {
                        LiteOADIDSDKHelper25.getOAId(context, new LiteOADIDSDKHelper25.OAIDListener() { // from class: com.kwad.sdk.liteapi.LiteOAIDHelper.1.2
                        });
                    }
                    LiteOAIDHelper.sInitIng.set(false);
                }
            }
        });
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
                    sOAID = new HWDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 1:
                    sOAID = new HONORDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 2:
                case 3:
                    sOAID = new XiaomiDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 4:
                case 5:
                    sOAID = new OppoDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 6:
                    sOAID = new VivoDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 7:
                case '\b':
                    sOAID = new LenovoDeviceIDHelper(applicationContext).getOAID();
                    break;
                case '\t':
                    sOAID = new MeizuDeviceIDHelper(applicationContext).getOAID();
                    break;
                case '\n':
                    sOAID = new NubiaDeviceIDHelper(applicationContext).getOAID();
                    break;
                case 11:
                    sOAID = new SamsungDeviceIDHelper(applicationContext).getOAID();
                    break;
                case '\f':
                    sOAID = new ASUSDeviceIDHelper(applicationContext).getOAID();
                    break;
                case '\r':
                case 14:
                case 15:
                    sOAID = new ZTEDeviceIDHelper(applicationContext).getOAID();
                    break;
            }
            LiteApiLogger.i(TAG, "manufacturer:" + upperCase + "--OAID:" + sOAID);
            if (TextUtils.isEmpty(sOAID)) {
                sGetOaidFail = true;
            }
        } catch (Throwable th) {
            LiteApiLogger.printStackTraceOnly(th);
        }
    }
}
