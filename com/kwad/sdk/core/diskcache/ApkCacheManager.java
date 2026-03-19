package com.kwad.sdk.core.diskcache;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.bf;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class ApkCacheManager {
    private File bAK;
    private final ExecutorService bAL;
    private final Callable<Void> bAM;
    private Future bih;

    /* synthetic */ ApkCacheManager(byte b) {
        this();
    }

    private ApkCacheManager() {
        this.bAL = GlobalThreadPools.acm();
        this.bAM = new Callable<Void>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: Zy, reason: merged with bridge method [inline-methods] */
            public Void call() {
                synchronized (ApkCacheManager.class) {
                    if (ApkCacheManager.this.bAK != null && ApkCacheManager.this.bAK.exists() && !ApkCacheManager.this.Zw()) {
                        ApkCacheManager apkCacheManager = ApkCacheManager.this;
                        for (File file : apkCacheManager.n(apkCacheManager.bAK)) {
                            if (file.getName().endsWith(".apk")) {
                                ApkCacheManager.this.h(file);
                                if (ApkCacheManager.this.Zw()) {
                                    return null;
                                }
                            }
                        }
                        return null;
                    }
                    return null;
                }
            }
        };
        if (((f) ServiceProvider.get(f.class)).getContext() == null) {
            return;
        }
        try {
            this.bAK = bf.ex(((f) ServiceProvider.get(f.class)).getContext());
        } catch (Throwable unused) {
        }
    }

    enum Holder {
        INSTANCE;

        private ApkCacheManager mInstance = new ApkCacheManager(0);

        Holder() {
        }

        final ApkCacheManager getInstance() {
            return this.mInstance;
        }
    }

    public static ApkCacheManager getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Zw() {
        File file = this.bAK;
        if (file == null || !file.exists()) {
            return false;
        }
        File[] fileArrListFiles = this.bAK.listFiles();
        if (fileArrListFiles.length > 5) {
            return fileArrListFiles.length <= 10 && l(this.bAK) <= 400;
        }
        return true;
    }

    public final void Zx() {
        File file = this.bAK;
        if (file == null || !file.exists()) {
            return;
        }
        Future future = this.bih;
        if (future == null || future.isDone()) {
            this.bih = this.bAL.submit(this.bAM);
        }
    }

    private int l(File file) {
        return (int) ((m(file) / 1000.0f) / 1000.0f);
    }

    private long m(File file) {
        long length;
        File[] fileArrListFiles = file.listFiles();
        long j = 0;
        if (fileArrListFiles != null) {
            int length2 = fileArrListFiles.length;
            for (int i = 0; i < length2; i++) {
                if (fileArrListFiles[i].isDirectory()) {
                    length = m(fileArrListFiles[i]);
                } else {
                    length = fileArrListFiles[i].length();
                }
                j += length;
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    h(file2);
                }
                file.delete();
                return;
            }
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<File> n(File file) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return arrayList;
        }
        arrayList.addAll(Arrays.asList(fileArrListFiles));
        ai(arrayList);
        return arrayList;
    }

    private void ai(List<File> list) {
        Collections.sort(list, new Comparator<File>() { // from class: com.kwad.sdk.core.diskcache.ApkCacheManager.2
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file, File file2) {
                return c(file, file2);
            }

            private static int c(File file, File file2) {
                if (file.lastModified() >= file2.lastModified()) {
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
                return -1;
            }
        });
    }
}
