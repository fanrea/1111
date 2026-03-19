package lkxssdk.o0;

import com.lingku.xuanshang.xutils.common.task.Priority;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a implements Runnable {
    public long a;
    public final Priority b;
    public final Runnable c;

    public a(Priority priority, Runnable runnable) {
        this.b = priority == null ? Priority.DEFAULT : priority;
        this.c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.run();
    }
}
