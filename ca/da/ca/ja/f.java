package ca.da.ca.ja;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.apm.applog.AppLog;
import com.bytedance.applog.util.HardwareUtils;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.UUID;

/* compiled from: DeviceParamsProvider.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class f implements k {
    public static String f;
    public static String g;
    public static volatile String h;
    public final Context a;
    public ca.da.ca.ia.c b;
    public final ca.da.ca.ia.a c;
    public final String d;
    public final ca.da.ca.fa.g e;

    public f(Context context, ca.da.ca.fa.g gVar, ca.da.ca.ia.a aVar) {
        this.e = gVar;
        this.d = gVar.b.getLocalTest() ? "_local" : "";
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        e eVar = new e();
        this.c = aVar;
        ca.da.ca.ia.l lVar = new ca.da.ca.ia.l(applicationContext, gVar.b.getSpName());
        this.b = lVar;
        lVar.a = aVar;
        if (!gVar.b.getAnonymous()) {
            new Thread(new d(eVar)).start();
        }
        a(gVar.b.getAccount());
    }

    public String a(boolean z) {
        String string;
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        if (AppLog.isAndroidIdEnabled()) {
            Context context = this.a;
            try {
                SharedPreferences sharedPreferencesA = ca.da.ca.ia.l.a(context);
                string = sharedPreferencesA.getString(HardwareUtils.GLOBAL_CACHE_GET_ANDROID_ID, null);
                if (TextUtils.isEmpty(string)) {
                    string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string)) {
                        sharedPreferencesA.edit().putString(HardwareUtils.GLOBAL_CACHE_GET_ANDROID_ID, string).commit();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                string = null;
            }
        } else {
            string = "";
        }
        try {
            if (!t.b(string) || "9774d56d682e549c".equals(string)) {
                SharedPreferences sharedPreferences = this.a.getSharedPreferences("snssdk_openudid", 0);
                String string2 = sharedPreferences.getString("openudid", null);
                if (t.b(string2)) {
                    this.c.d(string2, null);
                } else {
                    string2 = new BigInteger(80, new SecureRandom()).toString(16);
                    if (string2.charAt(0) == '-') {
                        string2 = string2.substring(1);
                    }
                    int length = 13 - string2.length();
                    if (length > 0) {
                        StringBuilder sb = new StringBuilder();
                        while (length > 0) {
                            sb.append('F');
                            length--;
                        }
                        sb.append(string2);
                        string2 = sb.toString();
                    }
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("openudid", string2);
                    editorEdit.commit();
                }
                string = string2;
            } else {
                string = this.b.d(null, string);
            }
        } catch (Exception e2) {
            r.a("", e2);
        }
        if (!TextUtils.isEmpty(string)) {
            string = ca.ca.ca.ca.a.a(string).append(this.d).toString();
        }
        if (!TextUtils.isEmpty(string)) {
            f = string;
        }
        return string;
    }

    public String b() {
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        h = this.b.c("", "");
        return h;
    }

    public String a() {
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        try {
            SharedPreferences sharedPreferences = this.a.getSharedPreferences("snssdk_openudid", 0);
            String string = sharedPreferences.getString("clientudid", null);
            if (!t.b(string)) {
                string = UUID.randomUUID().toString();
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("clientudid", string);
                editorEdit.commit();
            } else {
                this.c.b(string, null);
            }
            if (!TextUtils.isEmpty(string)) {
                string = string + this.d;
            }
            g = string;
            return string;
        } catch (Exception e) {
            r.a("", e);
            return "";
        }
    }

    public void a(String str) {
        if (!t.a(str) || t.a(str, h)) {
            return;
        }
        h = this.b.c(str, h);
    }

    public void a(Account account) {
        ca.da.ca.ia.a aVar = this.c;
        if (aVar != null) {
            aVar.a(account);
        }
    }

    public void a(Context context, String str) {
        r.a("DeviceParamsProvider#clearDidAndIid clearKey=" + str + " sDeviceId=" + h + " mCacheHandler.loadDeviceId()=" + this.b.c("", ""));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        h = null;
        String str2 = "clear_key_prefix" + str;
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.e.b.getSpName(), 0);
        if (!sharedPreferences.getBoolean(str2, false)) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putBoolean(str2, true);
            if (sharedPreferences.contains(com.baidu.mobads.upgrade.remote.gray.c.l)) {
                editorEdit.remove(com.baidu.mobads.upgrade.remote.gray.c.l);
            }
            if (sharedPreferences.contains("install_id")) {
                editorEdit.remove("install_id");
            }
            editorEdit.apply();
            this.b.a(com.baidu.mobads.upgrade.remote.gray.c.l);
            if (r.b) {
                r.a("clearKey : " + str + " :clear installId and deviceId finish");
                return;
            }
            return;
        }
        if (r.b) {
            r.a("clearKey : " + str + " : is already cleared");
        }
    }
}
