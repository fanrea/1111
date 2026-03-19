package com.baidu.mobads.container.components.command;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobads.container.util.bw;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class k {
    private static final String a = k.class.getSimpleName();
    private static final int b = 15;
    private static final int c = 1296000000;
    private static volatile k d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private bq f = bq.a();
    private long g = 0;

    private k() {
    }

    public static k a() {
        if (d == null) {
            synchronized (k.class) {
                if (d == null) {
                    d = new k();
                }
            }
        }
        return d;
    }

    public void a(Context context) {
        if (!this.e.getAndSet(true)) {
            this.g = System.currentTimeMillis();
            com.baidu.mobads.container.d.b.a().a(new l(this, context), 15L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        File[] fileArrC = c(context);
        if (fileArrC != null) {
            for (File file : fileArrC) {
                try {
                    if (a(file)) {
                        file.delete();
                    }
                } catch (Throwable th) {
                    this.f.b(a, "cleanExpiredFiles: " + th.getMessage());
                }
            }
        }
    }

    private File[] c(Context context) {
        try {
            return new File(bw.i(context)).listFiles(new a());
        } catch (Throwable th) {
            this.f.b(a, "getDownloadFiles: " + th.getMessage());
            return null;
        }
    }

    private boolean a(File file) {
        return file != null && file.exists() && file.isFile() && this.g - file.lastModified() > 1296000000;
    }

    static class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            if (!TextUtils.isEmpty(str)) {
                return str.endsWith(".apk");
            }
            return false;
        }
    }
}
