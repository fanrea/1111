package ca.da.ca.ia;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* compiled from: SharedPreferenceCacheHelper.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class l extends c {
    public final SharedPreferences c;
    public final SharedPreferences d;

    public l(Context context, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        this.c = context.getSharedPreferences("snssdk_openudid", 0);
        this.d = context.getSharedPreferences(str, 0);
    }

    @Override // ca.da.ca.ia.c
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = c(str).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    @Override // ca.da.ca.ia.c
    public String b(String str) {
        return c(str).getString(str, null);
    }

    public final SharedPreferences c(String str) {
        return com.baidu.mobads.upgrade.remote.gray.c.l.equals(str) ? this.d : this.c;
    }

    @Override // ca.da.ca.ia.c
    public void a(String str) {
        SharedPreferences sharedPreferencesC = c(str);
        if (sharedPreferencesC != null && sharedPreferencesC.contains(str)) {
            c(str).edit().remove(str).apply();
        }
        super.a(str);
    }

    public static synchronized SharedPreferences a(Context context) {
        return context.getSharedPreferences("_apm_global_cache", 0);
    }
}
