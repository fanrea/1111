package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class StillCaptureFlashStopRepeatingQuirk implements Quirk {
    static boolean load() {
        return "SAMSUNG".equals(Build.MANUFACTURER.toUpperCase(Locale.US)) && Build.MODEL.toUpperCase(Locale.US).startsWith("SM-A716");
    }
}
