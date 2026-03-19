package com.bykv.vk.openvk.component.video.d.hc.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.openvk.component.video.d.hc.c;
import com.bykv.vk.openvk.component.video.d.hc.u;
import com.bytedance.sdk.component.tc.h;
import com.bytedance.sdk.component.tc.tt;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends com.bykv.vk.openvk.component.video.d.hc.d.d {
    private final Set<d> an;
    private final ReentrantReadWriteLock b;
    private final ReentrantReadWriteLock.ReadLock c;
    public final File d;
    private volatile float gb;
    private volatile long h;
    private final LinkedHashMap<String, File> hc = new LinkedHashMap<>(0, 0.75f, true);
    private final Handler mk;
    private final Runnable tc;
    private final hc tt;
    private final ReentrantReadWriteLock.WriteLock u;

    public interface d {
        void d(String str);

        void d(Set<String> set);
    }

    public void d(d dVar) {
        if (dVar != null) {
            this.an.add(dVar);
        }
    }

    public b(File file) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.b = reentrantReadWriteLock;
        this.c = reentrantReadWriteLock.readLock();
        this.u = reentrantReadWriteLock.writeLock();
        this.an = Collections.newSetFromMap(new ConcurrentHashMap());
        this.h = 104857600L;
        this.gb = 0.5f;
        this.tt = new hc();
        this.tc = new Runnable() { // from class: com.bykv.vk.openvk.component.video.d.hc.d.b.1
            @Override // java.lang.Runnable
            public void run() {
                h.hc(new tt("cleanupCmd", 1) { // from class: com.bykv.vk.openvk.component.video.d.hc.d.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hc(b.this.h);
                    }
                });
            }
        };
        this.mk = new Handler(Looper.getMainLooper());
        if (file == null || !file.exists() || !file.isDirectory() || !file.canRead() || !file.canWrite()) {
            throw new IOException("dir error!  ".concat(String.valueOf(file == null ? " dir null" : "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite())));
        }
        this.d = file;
        h.hc(new tt("DiskLruCache", 5) { // from class: com.bykv.vk.openvk.component.video.d.hc.d.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.hc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc() {
        this.u.lock();
        try {
            File[] fileArrListFiles = this.d.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bykv.vk.openvk.component.video.d.hc.d.b.3
                    @Override // java.util.Comparator
                    /* renamed from: d, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file2 = (File) it.next();
                    this.hc.put(d(file2), file2);
                }
            }
            this.u.unlock();
            b();
        } catch (Throwable th) {
            this.u.unlock();
            throw th;
        }
    }

    public void d(long j) {
        this.h = j;
        b();
    }

    private void b() {
        this.mk.removeCallbacks(this.tc);
        this.mk.postDelayed(this.tc, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    public void d() {
        c.b().c();
        Context context = u.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.d.hc.hc.b.d(context).d(0);
        }
        this.mk.removeCallbacks(this.tc);
        h.hc(new tt("clear", 1) { // from class: com.bykv.vk.openvk.component.video.d.hc.d.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.hc(0L);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.d.d
    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.tt.d(str);
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.d.d
    public void hc(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.tt.hc(str);
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.d.d
    public File b(String str) {
        this.c.lock();
        File file = this.hc.get(str);
        this.c.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.d, str);
        this.u.lock();
        this.hc.put(str, file2);
        this.u.unlock();
        Iterator<d> it = this.an.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
        b();
        return file2;
    }

    @Override // com.bykv.vk.openvk.component.video.d.hc.d.d
    public File c(String str) {
        if (!this.c.tryLock()) {
            return null;
        }
        File file = this.hc.get(str);
        this.c.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5 A[LOOP:3: B:41:0x00df->B:43:0x00e5, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void hc(long r13) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.d.hc.d.b.hc(long):void");
    }

    private String d(File file) {
        return file.getName();
    }

    private static final class hc {
        private final Map<String, Integer> d;

        private hc() {
            this.d = new HashMap();
        }

        synchronized void d(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.d.get(str);
                if (num == null) {
                    this.d.put(str, 1);
                    return;
                }
                this.d.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }

        synchronized void hc(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.d.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.d.remove(str);
                    return;
                }
                this.d.put(str, Integer.valueOf(num.intValue() - 1));
            }
        }

        synchronized boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.d.containsKey(str);
        }
    }
}
