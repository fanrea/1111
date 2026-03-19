package com.kwad.sdk.core.videocache.a;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class e implements com.kwad.sdk.core.videocache.a.a {
    private final ExecutorService bJN = GlobalThreadPools.acc();

    protected abstract boolean bk(long j);

    @Override // com.kwad.sdk.core.videocache.a.a
    public final void s(File file) {
        this.bJN.submit(new a(file));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(File file) throws Throwable {
        d.w(file);
        ao(d.v(file.getParentFile()));
    }

    private void ao(List<File> list) {
        long jAp = ap(list);
        list.size();
        for (File file : list) {
            if (!bk(jAp)) {
                long length = file.length();
                if (file.delete()) {
                    jAp -= length;
                } else {
                    com.kwad.sdk.core.d.c.e("LruDiskUsage", "Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private static long ap(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    class a implements Callable<Void> {
        private final File file;

        public a(File file) {
            this.file = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // java.util.concurrent.Callable
        /* renamed from: Zy, reason: merged with bridge method [inline-methods] */
        public Void call() throws Throwable {
            e.this.z(this.file);
            return null;
        }
    }
}
