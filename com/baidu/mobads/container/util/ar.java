package com.baidu.mobads.container.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ar {
    private static final long a = 50000000;
    private static long b = a;
    private static final int c = 256;
    private a d;
    private b e = new b(this);

    public interface a {
        void a();
    }

    public static void a(int i) {
        b = i * 1000 * 1000;
    }

    public void a(String str) {
        com.baidu.mobads.container.d.b.a().a((com.baidu.mobads.container.d.a) new as(this, str), 2);
    }

    public void b(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
            }
        } catch (Exception e) {
        }
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class b extends Handler {
        WeakReference<ar> a;

        public b(ar arVar) {
            super(Looper.getMainLooper());
            this.a = new WeakReference<>(arVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ar arVar = this.a.get();
            if (arVar != null) {
                switch (message.what) {
                    case 256:
                        if (arVar.d != null) {
                            arVar.d.a();
                            break;
                        }
                        break;
                }
                super.handleMessage(message);
            }
        }
    }
}
