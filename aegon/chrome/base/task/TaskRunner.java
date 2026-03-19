package aegon.chrome.base.task;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface TaskRunner {
    void destroy();

    void disableLifetimeCheck();

    void initNativeTaskRunner();

    void postDelayedTask(Runnable runnable, long j);

    void postTask(Runnable runnable);
}
