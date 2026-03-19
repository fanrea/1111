package lkxssdk.l0;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class d {
    public static d a;
    public Context b = lkxssdk.a.a.d().getApplicationContext();

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public String a(String str, String str2) {
        return this.b.getSharedPreferences("FCLibSetting", 0).getString(str, null);
    }

    public boolean b(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.b.getSharedPreferences("FCLibSetting", 0).edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }
}
