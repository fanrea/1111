package com.bytedance.msdk.gb;

import android.content.Context;
import android.content.Intent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {

    public interface d {
    }

    public static void d(Context context, Intent intent, d dVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
        } catch (Throwable unused) {
        }
    }
}
