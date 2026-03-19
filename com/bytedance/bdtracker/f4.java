package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import java.util.Collections;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class f4 extends u3 {
    public static f4 f;
    public final SharedPreferences c;
    public SharedPreferences d;
    public boolean e;

    public interface a {
        String a();
    }

    public f4(Context context, String str, String str2) {
        this.e = false;
        this.c = a(context, str, 0);
        this.d = a(context, str2, 0);
    }

    public f4(Context context, String str, boolean z) {
        this.e = false;
        this.c = a(context, str, 0);
        this.e = z;
    }

    public static SharedPreferences a(Context context, String str, int i) {
        Context contextCreateDeviceProtectedStorageContext;
        Throwable th;
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                contextCreateDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            } catch (Throwable th2) {
                contextCreateDeviceProtectedStorageContext = context;
                th = th2;
            }
            try {
                if (!contextCreateDeviceProtectedStorageContext.moveSharedPreferencesFrom(context, str)) {
                    LoggerImpl.global().warn(Collections.singletonList("SharedPreferenceCacheHelper"), "Failed to migrate shared preferences.", new Object[0]);
                }
            } catch (Throwable th3) {
                th = th3;
                LoggerImpl.global().error(Collections.singletonList("SharedPreferenceCacheHelper"), "Create protected storage context failed", th, new Object[0]);
                context = contextCreateDeviceProtectedStorageContext;
                return context.getSharedPreferences(str, i);
            }
            context = contextCreateDeviceProtectedStorageContext;
        }
        return context.getSharedPreferences(str, i);
    }

    public static synchronized f4 a(Context context) {
        if (f == null) {
            f = new f4(context, "_global_cache", true);
        }
        return f;
    }

    public synchronized String a(String str, a aVar) {
        if (d(str).contains(str)) {
            return e(str);
        }
        String strA = aVar != null ? aVar.a() : null;
        h(str, strA);
        return strA;
    }

    @Override // com.bytedance.bdtracker.u3
    public void a(String str) {
        SharedPreferences sharedPreferencesD = d(str);
        if (sharedPreferencesD != null && sharedPreferencesD.contains(str)) {
            d(str).edit().remove(str).apply();
        }
        super.a(str);
    }

    @Override // com.bytedance.bdtracker.u3
    public void a(String str, String str2) {
        h(str, str2);
    }

    @Override // com.bytedance.bdtracker.u3
    public void a(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return;
        }
        h(str, TextUtils.join("\n", strArr));
    }

    @Override // com.bytedance.bdtracker.u3
    public String b(String str) {
        return d(str).getString(str, null);
    }

    @Override // com.bytedance.bdtracker.u3
    public String[] c(String str) {
        String string = d(str).getString(str, null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split("\n");
    }

    public SharedPreferences d(String str) {
        SharedPreferences sharedPreferences;
        return (!com.baidu.mobads.upgrade.remote.gray.c.l.equals(str) || (sharedPreferences = this.d) == null) ? this.c : sharedPreferences;
    }

    public String e(String str) {
        return d(str).getString(str, null);
    }

    public void h(String str, String str2) {
        if (this.e || !TextUtils.isEmpty(str2)) {
            SharedPreferences.Editor editorEdit = d(str).edit();
            if (this.e && str2 == null) {
                str2 = "";
            }
            editorEdit.putString(str, str2);
            editorEdit.apply();
        }
    }
}
