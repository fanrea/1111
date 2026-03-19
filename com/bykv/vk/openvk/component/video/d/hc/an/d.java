package com.bykv.vk.openvk.component.video.d.hc.an;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.an.b;
import com.bykv.vk.openvk.component.video.d.hc.an;
import com.bykv.vk.openvk.component.video.d.hc.c;
import com.bykv.vk.openvk.component.video.d.hc.u;
import com.bytedance.sdk.component.utils.mq;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static final boolean d = b.hc();
    private C0161d b;
    private HashMap<String, Boolean> hc;

    private d() {
        this.hc = new HashMap<>();
        hc();
    }

    public static d d() {
        return hc.d;
    }

    private static class hc {
        private static final d d = new d();
    }

    public boolean hc() {
        if (this.b != null) {
            return true;
        }
        com.bykv.vk.openvk.component.video.d.hc.d.b bVarB = b();
        if (bVarB == null) {
            return false;
        }
        u.d(true);
        u.hc(true);
        u.d(1);
        an.d().c();
        try {
            C0161d c0161d = new C0161d();
            this.b = c0161d;
            c0161d.setName("csj_video_cache_preloader");
            this.b.start();
            u.d(bVarB, com.bykv.vk.openvk.component.video.api.b.getContext());
            c.b();
            c.b().d(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean d(com.bykv.vk.openvk.component.video.api.b.c cVar) {
        if (!hc()) {
            return false;
        }
        this.b.d(cVar);
        return true;
    }

    public String hc(com.bykv.vk.openvk.component.video.api.b.c cVar) {
        if (cVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(cVar.w());
        return an.d().d(false, z, z ? cVar.w() : cVar.cb(), cVar.cb());
    }

    private static com.bykv.vk.openvk.component.video.d.hc.d.b b() {
        File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hc.hc(com.bykv.vk.openvk.component.video.api.b.getContext()), "proxy_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        com.bykv.vk.openvk.component.video.d.hc.d.b bVar = null;
        try {
            com.bykv.vk.openvk.component.video.d.hc.d.b bVar2 = new com.bykv.vk.openvk.component.video.d.hc.d.b(file);
            try {
                bVar2.d(104857600L);
                return bVar2;
            } catch (IOException e) {
                e = e;
                bVar = bVar2;
                mq.d(e);
                return bVar;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* renamed from: com.bykv.vk.openvk.component.video.d.hc.an.d$d, reason: collision with other inner class name */
    class C0161d extends com.bytedance.sdk.component.tc.c.b {
        private boolean b;
        private final Queue<C0162d> c;
        private Queue<C0162d> hc;
        private Queue<C0162d> u;

        public C0161d() {
            super("VideoCachePreloader$PreLoadThread");
            this.c = new ArrayBlockingQueue(10);
            this.hc = new LinkedBlockingQueue();
            this.b = true;
            this.u = new LinkedBlockingQueue();
        }

        private C0162d d(int i, com.bykv.vk.openvk.component.video.api.b.c cVar) {
            this.c.size();
            C0162d c0162dPoll = this.c.poll();
            if (c0162dPoll == null) {
                c0162dPoll = new C0162d();
            }
            c0162dPoll.d = i;
            c0162dPoll.an = cVar;
            return c0162dPoll;
        }

        private void d(C0162d c0162d) {
            c0162d.b = null;
            c0162d.hc = null;
            c0162d.d = -1;
            c0162d.an = null;
            this.c.offer(c0162d);
        }

        private synchronized void hc(C0162d c0162d) {
            this.u.add(c0162d);
            notify();
        }

        private void b(C0162d c0162d) {
            if (c0162d == null) {
                return;
            }
            this.hc.offer(c0162d);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.b) {
                synchronized (this) {
                    if (!this.u.isEmpty()) {
                        d();
                    }
                    while (!this.hc.isEmpty()) {
                        C0162d c0162dPoll = this.hc.poll();
                        if (c0162dPoll != null) {
                            int i = c0162dPoll.d;
                            if (i != 0) {
                                if (i == 1) {
                                    c.b().d(c0162dPoll.hc);
                                } else if (i == 2) {
                                    c.b().c();
                                } else if (i == 3) {
                                    c.b().c();
                                    if (u.hc() != null) {
                                        u.hc().d();
                                    }
                                    if (u.d() != null) {
                                        u.d().d();
                                    }
                                } else if (i == 4) {
                                    c.b().c();
                                    this.b = false;
                                }
                            } else if (c0162dPoll.b != null && c0162dPoll.b.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : c0162dPoll.b) {
                                    if (com.bykv.vk.openvk.component.video.d.b.d.d(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                c.b().d(false, !TextUtils.isEmpty(c0162dPoll.u), c0162dPoll.c, c0162dPoll.hc, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            d(c0162dPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        mq.d(e);
                    }
                }
            }
        }

        private void d() {
            while (true) {
                C0162d c0162dPoll = this.u.poll();
                if (c0162dPoll == null) {
                    return;
                }
                c0162dPoll.hc = c0162dPoll.an.cb();
                c0162dPoll.b = new String[]{c0162dPoll.an.cb()};
                int iHc = c0162dPoll.an.hc();
                if (iHc <= 0) {
                    iHc = c0162dPoll.an.an();
                }
                c0162dPoll.c = iHc;
                c0162dPoll.u = c0162dPoll.an.w();
                if (!TextUtils.isEmpty(c0162dPoll.an.w())) {
                    c0162dPoll.hc = c0162dPoll.an.w();
                }
                c0162dPoll.an = null;
                b(c0162dPoll);
            }
        }

        public void d(com.bykv.vk.openvk.component.video.api.b.c cVar) {
            hc(d(0, cVar));
        }

        /* renamed from: com.bykv.vk.openvk.component.video.d.hc.an.d$d$d, reason: collision with other inner class name */
        private class C0162d {
            public com.bykv.vk.openvk.component.video.api.b.c an;
            public String[] b;
            public int c;
            public int d;
            public String hc;
            public String u;

            public C0162d() {
            }
        }
    }
}
