package ca.da.da;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* compiled from: Cdid.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class d {
    public static b<String> a = new a();

    /* compiled from: Cdid.java */
    public static class a extends b<String> {
        @Override // ca.da.da.b
        public String a(Object[] objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String string2 = UUID.randomUUID().toString();
            ca.ca.ca.ca.a.a(sharedPreferences, "cdid", string2);
            return string2;
        }
    }
}
