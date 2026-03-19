package com.fc.tjcpl.sdk.l;

import android.content.Context;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    public static d a;

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public String a(Context context, String str, String str2) {
        return context.getSharedPreferences("TJSetting", 0).getString(str, str2);
    }
}
