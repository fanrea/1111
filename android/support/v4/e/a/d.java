package android.support.v4.e.a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d {
    private final AccessibilityRecord cO;

    public static void a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    public static void b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public final int hashCode() {
        AccessibilityRecord accessibilityRecord = this.cO;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }

    @Deprecated
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        AccessibilityRecord accessibilityRecord = this.cO;
        if (accessibilityRecord == null) {
            if (dVar.cO != null) {
                return false;
            }
        } else if (!accessibilityRecord.equals(dVar.cO)) {
            return false;
        }
        return true;
    }
}
