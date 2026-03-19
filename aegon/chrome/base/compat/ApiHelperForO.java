package aegon.chrome.base.compat;

import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.view.Display;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class ApiHelperForO {
    private ApiHelperForO() {
    }

    public static boolean isWideColorGamut(Display display) {
        return display.isWideColorGamut();
    }

    public static boolean isScreenWideColorGamut(Configuration configuration) {
        return configuration.isScreenWideColorGamut();
    }

    public static boolean isInstantApp(PackageManager packageManager) {
        return packageManager.isInstantApp();
    }

    public static void setDefaultFocusHighlightEnabled(View view, boolean z) {
        view.setDefaultFocusHighlightEnabled(z);
    }
}
