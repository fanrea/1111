package aegon.chrome.base.task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public @interface TaskPriority {
    public static final int BEST_EFFORT = 0;
    public static final int HIGHEST = 2;
    public static final int LOWEST = 0;
    public static final int USER_BLOCKING = 2;
    public static final int USER_VISIBLE = 1;
}
