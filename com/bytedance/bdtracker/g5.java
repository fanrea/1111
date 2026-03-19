package com.bytedance.bdtracker;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class g5 {
    public static f5<String> a = new a();

    public static class a extends f5<String> {
        @Override // com.bytedance.bdtracker.f5
        public String a(Object[] objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String string2 = UUID.randomUUID().toString();
            com.bytedance.bdtracker.a.a(sharedPreferences, "cdid", string2);
            return string2;
        }
    }
}
