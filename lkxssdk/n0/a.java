package lkxssdk.n0;

import android.text.TextUtils;
import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.cache.LruDiskCache;
import com.lingku.xuanshang.xutils.common.util.FileUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.db.sqlite.WhereBuilder;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a implements Runnable {
    public final /* synthetic */ LruDiskCache a;

    public a(LruDiskCache lruDiskCache) {
        this.a = lruDiskCache;
    }

    @Override // java.lang.Runnable
    public void run() {
        List<DiskCacheEntity> listFindAll;
        if (!this.a.b) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        LruDiskCache lruDiskCache = this.a;
        if (jCurrentTimeMillis - lruDiskCache.g < 1000) {
            return;
        }
        lruDiskCache.g = jCurrentTimeMillis;
        if (lruDiskCache.b) {
            try {
                WhereBuilder whereBuilderB = WhereBuilder.b("expires", "<", Long.valueOf(System.currentTimeMillis()));
                List listFindAll2 = lruDiskCache.c.selector(DiskCacheEntity.class).where(whereBuilderB).findAll();
                lruDiskCache.c.delete(DiskCacheEntity.class, whereBuilderB);
                if (listFindAll2 != null && listFindAll2.size() > 0) {
                    Iterator it = listFindAll2.iterator();
                    while (it.hasNext()) {
                        String path = ((DiskCacheEntity) it.next()).getPath();
                        if (!TextUtils.isEmpty(path)) {
                            lruDiskCache.a(path);
                        }
                    }
                }
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
        try {
            int iCount = (int) this.a.c.selector(DiskCacheEntity.class).count();
            if (iCount > 5010 && (listFindAll = this.a.c.selector(DiskCacheEntity.class).orderBy("lastAccess").orderBy("hits").limit(iCount - 5000).offset(0).findAll()) != null && listFindAll.size() > 0) {
                for (DiskCacheEntity diskCacheEntity : listFindAll) {
                    try {
                        this.a.c.delete(diskCacheEntity);
                        String path2 = diskCacheEntity.getPath();
                        if (!TextUtils.isEmpty(path2)) {
                            this.a.a(path2);
                            this.a.a(path2 + ".tmp");
                        }
                    } catch (Throwable th2) {
                        LogUtil.e(th2.getMessage(), th2);
                    }
                }
            }
        } catch (Throwable th3) {
            LogUtil.e(th3.getMessage(), th3);
        }
        while (true) {
            try {
                long fileOrDirSize = FileUtil.getFileOrDirSize(this.a.d);
                LruDiskCache lruDiskCache2 = this.a;
                if (fileOrDirSize <= lruDiskCache2.e) {
                    return;
                }
                List<DiskCacheEntity> listFindAll3 = lruDiskCache2.c.selector(DiskCacheEntity.class).orderBy("lastAccess").orderBy("hits").limit(10).offset(0).findAll();
                if (listFindAll3 != null && listFindAll3.size() > 0) {
                    for (DiskCacheEntity diskCacheEntity2 : listFindAll3) {
                        try {
                            this.a.c.delete(diskCacheEntity2);
                            String path3 = diskCacheEntity2.getPath();
                            if (!TextUtils.isEmpty(path3)) {
                                this.a.a(path3);
                                this.a.a(path3 + ".tmp");
                            }
                        } catch (Throwable th4) {
                            LogUtil.e(th4.getMessage(), th4);
                        }
                    }
                }
            } catch (Throwable th5) {
                LogUtil.e(th5.getMessage(), th5);
                return;
            }
        }
    }
}
