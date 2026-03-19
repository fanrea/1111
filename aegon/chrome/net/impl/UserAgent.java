package aegon.chrome.net.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.alipay.sdk.m.u.i;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class UserAgent {
    private static final int VERSION_CODE_UNINITIALIZED = 0;
    private static final Object sLock = new Object();
    private static int sVersionCode;

    private UserAgent() {
    }

    public static String from(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append('/');
        sb.append(versionFromContext(context));
        sb.append(" (Linux; U; Android ");
        sb.append(Build.VERSION.RELEASE);
        sb.append("; ");
        sb.append(Locale.getDefault().toString());
        String str = Build.MODEL;
        if (str.length() > 0) {
            sb.append("; ");
            sb.append(str);
        }
        String str2 = Build.ID;
        if (str2.length() > 0) {
            sb.append("; Build/");
            sb.append(str2);
        }
        sb.append(i.b);
        appendCronetVersion(sb);
        sb.append(')');
        return sb.toString();
    }

    static String getQuicUserAgentIdFrom(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        appendCronetVersion(sb);
        return sb.toString();
    }

    private static int versionFromContext(Context context) {
        int i;
        synchronized (sLock) {
            if (sVersionCode == 0) {
                try {
                    sVersionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (PackageManager.NameNotFoundException unused) {
                    throw new IllegalStateException("Cannot determine package version");
                }
            }
            i = sVersionCode;
        }
        return i;
    }

    private static void appendCronetVersion(StringBuilder sb) {
        sb.append(" Cronet/");
        sb.append(ImplVersion.getCronetVersion());
    }
}
