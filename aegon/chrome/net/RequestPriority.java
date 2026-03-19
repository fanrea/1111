package aegon.chrome.net;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public @interface RequestPriority {
    public static final int DEFAULT_PRIORITY = 2;
    public static final int HIGHEST = 5;
    public static final int IDLE = 1;
    public static final int LOW = 3;
    public static final int LOWEST = 2;
    public static final int MAXIMUM_PRIORITY = 5;
    public static final int MEDIUM = 4;
    public static final int MINIMUM_PRIORITY = 0;
    public static final int THROTTLED = 0;
}
