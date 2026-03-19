package com.sigmob.sdk.videocache.file;

import com.czhj.sdk.logger.SigmobLog;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class e implements com.sigmob.sdk.videocache.file.a {
    private final ExecutorService a = Executors.newSingleThreadExecutor();

    private class a implements Callable<Void> {
        private final File b;

        public a(File file) {
            this.b = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            e.this.b(this.b);
            return null;
        }
    }

    private void a(List<File> files) {
        long jB = b(files);
        int size = files.size();
        for (File file : files) {
            if (!a(file, jB, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jB -= length;
                    SigmobLog.i("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    SigmobLog.e("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> files) {
        Iterator<File> it = files.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    @Override // com.sigmob.sdk.videocache.file.a
    public void a(File file) throws IOException {
        this.a.submit(new a(file));
    }

    protected abstract boolean a(File file, long totalSize, int totalCount);
}
