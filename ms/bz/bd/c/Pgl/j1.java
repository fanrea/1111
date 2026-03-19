package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class j1 {
    public static String d(Context context) {
        String str;
        String string;
        String str2 = "null_";
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        } catch (Throwable th) {
            try {
                str = "null_" + th.getMessage();
            } catch (Throwable unused) {
            }
        }
        if (!TextUtils.isEmpty(string)) {
            if (string.contains("/")) {
                str = string.split("/")[0];
                str2 = str;
            } else {
                str2 = string;
            }
        }
        StringBuilder sb = new StringBuilder(str2);
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]").append(packageName);
                }
            }
        } catch (Throwable unused2) {
        }
        return sb.toString();
    }

    public static String hc(Context context) {
        String str;
        String string;
        String str2 = "null_";
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        } catch (Throwable th) {
            try {
                str = "null_" + th.getMessage();
            } catch (Throwable unused) {
            }
        }
        if (!TextUtils.isEmpty(string)) {
            if (string.contains("/")) {
                str = string.split("/")[0];
                str2 = str;
            } else {
                str2 = string;
            }
        }
        StringBuilder sb = new StringBuilder(str2);
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                String str3 = context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir;
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]").append(str3);
                }
            }
        } catch (Throwable unused2) {
        }
        return sb.toString();
    }
}
