package aegon.chrome.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public @interface TraceRecordMode {
    public static final int ECHO_TO_CONSOLE = 3;
    public static final int RECORD_AS_MUCH_AS_POSSIBLE = 2;
    public static final int RECORD_CONTINUOUSLY = 1;
    public static final int RECORD_UNTIL_FULL = 0;
}
