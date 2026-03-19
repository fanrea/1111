package ca.da.ca.ja;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: PrivateAgreement.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class m {
    public static boolean a;
    public static ca.da.ca.ja.a<SharedPreferences> b = new a();

    /* compiled from: PrivateAgreement.java */
    public static class a extends ca.da.ca.ja.a<SharedPreferences> {
        @Override // ca.da.ca.ja.a
        public SharedPreferences a(Object[] objArr) {
            return ((Context) objArr[0]).getSharedPreferences("ug_install_settings_pref", 0);
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
