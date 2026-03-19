package aegon.chrome.base;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class CommandLineInitUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String COMMAND_LINE_FILE_PATH = "/data/local";
    private static final String COMMAND_LINE_FILE_PATH_DEBUG_APP = "/data/local/tmp";

    private CommandLineInitUtil() {
    }

    public static void initCommandLine(String str) {
        initCommandLine(str, null);
    }

    public static void initCommandLine(String str, Supplier<Boolean> supplier) {
        File file = new File(COMMAND_LINE_FILE_PATH_DEBUG_APP, str);
        if (!file.exists() || !shouldUseDebugCommandLine(supplier)) {
            file = new File(COMMAND_LINE_FILE_PATH, str);
        }
        CommandLine.initFromFile(file.getPath());
    }

    private static boolean shouldUseDebugCommandLine(Supplier<Boolean> supplier) {
        String debugAppJBMR1;
        if (supplier != null && supplier.get().booleanValue()) {
            return true;
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        if (Build.VERSION.SDK_INT < 17) {
            debugAppJBMR1 = getDebugAppPreJBMR1(applicationContext);
        } else {
            debugAppJBMR1 = getDebugAppJBMR1(applicationContext);
        }
        return applicationContext.getPackageName().equals(debugAppJBMR1) || BuildInfo.isDebugAndroid();
    }

    private static String getDebugAppJBMR1(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
            return Settings.Global.getString(context.getContentResolver(), "debug_app");
        }
        return null;
    }

    private static String getDebugAppPreJBMR1(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
            return Settings.System.getString(context.getContentResolver(), "debug_app");
        }
        return null;
    }
}
