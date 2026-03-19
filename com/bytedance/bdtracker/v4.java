package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class v4 {
    public static boolean a;
    public static i4<SharedPreferences> b = new a();

    public static class a extends i4<SharedPreferences> {
        @Override // com.bytedance.bdtracker.i4
        public SharedPreferences a(Object[] objArr) {
            return f4.a((Context) objArr[0], "ug_install_settings_pref", 0);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (a) {
            return true;
        }
        return b.b(context).getBoolean("_install_started_v2", false);
    }
}
