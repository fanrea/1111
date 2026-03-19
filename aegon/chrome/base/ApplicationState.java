package aegon.chrome.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public @interface ApplicationState {
    public static final int HAS_DESTROYED_ACTIVITIES = 4;
    public static final int HAS_PAUSED_ACTIVITIES = 2;
    public static final int HAS_RUNNING_ACTIVITIES = 1;
    public static final int HAS_STOPPED_ACTIVITIES = 3;
    public static final int UNKNOWN = 0;
}
