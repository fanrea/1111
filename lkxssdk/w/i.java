package lkxssdk.w;

import com.baidu.mobads.container.components.e.c;
import com.baidu.mobstat.forbes.Config;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class i implements Runnable {
    public a a;
    public lkxssdk.z.c b;
    public int c;
    public boolean d;
    public b e;
    public boolean f;

    public interface a {
    }

    public i(boolean z, b bVar, lkxssdk.z.c cVar, int i, a aVar) {
        this.f = z;
        this.b = cVar;
        this.a = aVar;
        this.c = i;
        this.e = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x024e A[Catch: all -> 0x029a, TRY_ENTER, TryCatch #15 {all -> 0x029a, blocks: (B:27:0x0129, B:28:0x0168, B:30:0x016d, B:32:0x0174, B:34:0x017a, B:35:0x018b, B:36:0x0192, B:37:0x0193, B:50:0x01de, B:52:0x01e8, B:54:0x01f2, B:55:0x01f4, B:59:0x0202, B:56:0x01f7, B:57:0x01fe, B:58:0x01ff, B:87:0x022d, B:102:0x024e, B:104:0x0252, B:105:0x0253, B:106:0x0259, B:110:0x025d, B:125:0x027e, B:127:0x028a, B:128:0x0291, B:129:0x0292, B:130:0x0299), top: B:165:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x027e A[Catch: all -> 0x029a, TRY_ENTER, TryCatch #15 {all -> 0x029a, blocks: (B:27:0x0129, B:28:0x0168, B:30:0x016d, B:32:0x0174, B:34:0x017a, B:35:0x018b, B:36:0x0192, B:37:0x0193, B:50:0x01de, B:52:0x01e8, B:54:0x01f2, B:55:0x01f4, B:59:0x0202, B:56:0x01f7, B:57:0x01fe, B:58:0x01ff, B:87:0x022d, B:102:0x024e, B:104:0x0252, B:105:0x0253, B:106:0x0259, B:110:0x025d, B:125:0x027e, B:127:0x028a, B:128:0x0291, B:129:0x0292, B:130:0x0299), top: B:165:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x029d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 693
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.w.i.a():void");
    }

    public final void b() throws Throwable {
        if (this.d) {
            return;
        }
        if (!this.f && !this.e.b.get()) {
            if (lkxssdk.a.a.h()) {
                this.e.a();
            }
            if (this.e.a.get()) {
                synchronized (this.e.c) {
                    if (this.e.a.get()) {
                        try {
                            this.e.c.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
        if (this.d) {
            return;
        }
        try {
            lkxssdk.z.c cVar = this.b;
            long j = cVar.f;
            if (j <= 0 || (j - cVar.e) + 1 != cVar.g) {
                a();
            } else {
                ((g) this.a).j();
            }
        } catch (lkxssdk.y.a e) {
            e.printStackTrace();
            lkxssdk.h0.c.b(c.a.a, "taskKey:" + this.b.a + ",DownloadException :type" + e.a + Config.replace + e.b);
            if (e.a != 3) {
                g gVar = (g) this.a;
                synchronized (gVar.m) {
                    int i = gVar.o;
                    boolean z = true;
                    if (i < gVar.d.d.e) {
                        gVar.o = i + 1;
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (this.d) {
                            return;
                        }
                        try {
                            Thread.sleep(this.c);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        if (this.d) {
                            return;
                        }
                        if (e.a == 5) {
                            File file = new File(this.b.h);
                            if (file.exists()) {
                                file.delete();
                            } else {
                                File parentFile = file.getParentFile();
                                if (!parentFile.exists()) {
                                    parentFile.mkdirs();
                                }
                            }
                            this.b.g = 0L;
                        }
                        b();
                        return;
                    }
                }
            }
            ((g) this.a).b(e);
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (this.d) {
            return;
        }
        lkxssdk.h0.c.c(c.a.a, "taskKey:" + this.b.a + ",run()");
        b();
    }
}
