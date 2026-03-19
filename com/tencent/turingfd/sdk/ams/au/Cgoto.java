package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.goto, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cgoto {
    public static int a(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver == null || !TextUtils.equals(intentRegisterReceiver.getAction(), "android.intent.action.BATTERY_CHANGED")) {
                return -1;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("level", 0);
            int intExtra2 = intentRegisterReceiver.getIntExtra("scale", 100);
            if (intExtra2 == 0) {
                return -1;
            }
            int i = (intExtra * 100) / intExtra2;
            int i2 = i >= 0 ? i : 0;
            if (i2 > 100) {
                return 100;
            }
            return i2;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
