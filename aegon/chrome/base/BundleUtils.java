package aegon.chrome.base;

import dalvik.system.BaseDexClassLoader;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class BundleUtils {
    private static final boolean sIsBundle;

    static {
        boolean z;
        try {
            Class.forName("aegon.chrome.base.BundleCanary");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        sIsBundle = z;
    }

    public static boolean isBundle() {
        return sIsBundle;
    }

    private static String getNativeLibraryPath(String str) {
        StrictModeContext strictModeContextAllowDiskReads = StrictModeContext.allowDiskReads();
        try {
            String strFindLibrary = ((BaseDexClassLoader) ContextUtils.getApplicationContext().getClassLoader()).findLibrary(str);
            if (strictModeContextAllowDiskReads != null) {
                strictModeContextAllowDiskReads.close();
            }
            return strFindLibrary;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (strictModeContextAllowDiskReads != null) {
                    try {
                        strictModeContextAllowDiskReads.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
