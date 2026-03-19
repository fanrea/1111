package com.ss.android.socialbase.appdownloader;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.sdk.component.utils.mq;
import com.sigmob.sdk.base.n;
import com.ss.android.socialbase.appdownloader.b.cb;
import com.ss.android.socialbase.appdownloader.b.k;
import com.ss.android.socialbase.appdownloader.b.mk;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import com.ss.android.socialbase.downloader.c.e;
import com.ss.android.socialbase.downloader.c.mt;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.c.z;
import com.ss.android.socialbase.downloader.downloader.rf;
import com.ss.android.socialbase.downloader.impls.yo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static boolean an = false;
    private static final String d = "c";
    private static boolean gb = false;
    private static boolean h = false;
    private static volatile c hc;
    private String b;
    private String c;
    private com.ss.android.socialbase.appdownloader.b.gb cb;
    private cb de;
    private com.ss.android.socialbase.appdownloader.b.tt e;
    private z jh;
    private com.ss.android.socialbase.appdownloader.b.u k;
    private mk rf;
    private mt sy;
    private int tc;
    private Future tt;
    private com.ss.android.socialbase.appdownloader.b.c uo;
    private com.ss.android.socialbase.appdownloader.b.b v;
    private k w;
    private com.ss.android.socialbase.appdownloader.b.h yo;
    private DownloadReceiver u = new DownloadReceiver();
    private boolean mk = false;
    private boolean mq = false;

    public com.ss.android.socialbase.appdownloader.b.b d() {
        return this.v;
    }

    public void d(com.ss.android.socialbase.appdownloader.b.b bVar) {
        this.v = bVar;
    }

    public com.ss.android.socialbase.appdownloader.b.c hc() {
        return this.uo;
    }

    public com.ss.android.socialbase.appdownloader.b.u b() {
        return this.k;
    }

    public com.ss.android.socialbase.appdownloader.b.tt c() {
        return this.e;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c = str;
    }

    public String u() {
        return this.c;
    }

    public com.ss.android.socialbase.appdownloader.b.h an() {
        return this.yo;
    }

    public void d(com.ss.android.socialbase.appdownloader.b.h hVar) {
        this.yo = hVar;
    }

    public boolean h() {
        return com.ss.android.socialbase.downloader.uo.d.hc().optInt("package_flag_config", 1) == 1;
    }

    public mk gb() {
        return this.rf;
    }

    public void d(mk mkVar) {
        this.rf = mkVar;
    }

    public File tt() {
        return com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).b();
    }

    public String tc() {
        return this.b;
    }

    private c() {
    }

    public static c mk() {
        if (hc == null) {
            synchronized (c.class) {
                if (hc == null) {
                    hc = new c();
                }
            }
        }
        return hc;
    }

    @Deprecated
    public void d(Context context, String str, com.ss.android.socialbase.appdownloader.b.c cVar, com.ss.android.socialbase.appdownloader.b.u uVar, com.ss.android.socialbase.appdownloader.b.tt ttVar) {
        if (cVar != null) {
            this.uo = cVar;
        }
        if (uVar != null) {
            this.k = uVar;
        }
        if (ttVar != null) {
            this.e = ttVar;
        }
        b(context);
    }

    private void b(Context context) {
        if (context == null || an) {
            return;
        }
        com.ss.android.socialbase.downloader.hc.u.d("application/vnd.android.package-archive");
        com.ss.android.socialbase.downloader.downloader.b.d(context);
        com.ss.android.socialbase.downloader.downloader.b.d(new com.ss.android.socialbase.appdownloader.c.hc());
        if (this.mq) {
            com.ss.android.socialbase.downloader.downloader.b.d(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.jh();
                }
            }, 5L, TimeUnit.SECONDS);
        } else {
            jh();
        }
        sy();
        an = true;
    }

    public void hc(String str) {
        com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).u(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jh() {
        synchronized (this.u) {
            if (h) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter2.addDataScheme(n.z);
                com.ss.android.socialbase.downloader.downloader.b.tr().registerReceiver(this.u, intentFilter);
                com.ss.android.socialbase.downloader.downloader.b.tr().registerReceiver(this.u, intentFilter2);
                h = true;
            } catch (Exception e) {
                mq.d(e);
            }
            com.ss.android.socialbase.downloader.an.d.hc(d, "registerDownloadReceiver mIsRegistered:" + h);
        }
    }

    public void mq() {
        if (com.ss.android.socialbase.downloader.uo.d.b().d("enable_app_install_receiver", 1) <= 0) {
            com.ss.android.socialbase.downloader.an.d.hc(d, "disable app install receiver");
            return;
        }
        synchronized (this.u) {
            try {
                if (gb) {
                    return;
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                    intentFilter.addDataScheme("package");
                    com.ss.android.socialbase.downloader.downloader.b.tr().registerReceiver(this.u, intentFilter);
                    gb = true;
                    cb cbVar = this.de;
                    if (cbVar != null) {
                        cbVar.d();
                    }
                } catch (Throwable th) {
                    mq.d(th);
                }
                com.ss.android.socialbase.downloader.an.d.hc(d, "tryRegisterTempAppInstallDownloadReceiver mIsAppInstallRegistered:" + h);
            } finally {
                hc(0);
            }
        }
    }

    private void hc(int i) {
        this.tc = com.ss.android.socialbase.downloader.uo.d.b().d("app_install_keep_receiver_time_s", 60);
        com.ss.android.socialbase.downloader.an.d.hc(d, "tryUnRegisterTempAppInstallDownloadReceiver mAppInstallReceiverKeepTime:" + this.tc);
        if (this.tc <= 0) {
            return;
        }
        if (i > 0) {
            this.tc = i;
        }
        Future future = this.tt;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable th) {
                mq.d(th);
            }
        }
        this.tt = com.ss.android.socialbase.downloader.downloader.b.d(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.an.d.hc(c.d, "registerDownloadReceiver tryUnRegisterTempAppInstallDownloadReceiver run inner");
                c.this.uo();
                c.this.jh();
            }
        }, this.tc, TimeUnit.SECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0022 A[Catch: all -> 0x001c, TryCatch #1 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x0014, B:10:0x0018, B:16:0x0022, B:17:0x0027, B:15:0x001f), top: B:22:0x0003, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void uo() {
        /*
            r3 = this;
            com.ss.android.socialbase.appdownloader.DownloadReceiver r0 = r3.u
            monitor-enter(r0)
            boolean r1 = com.ss.android.socialbase.appdownloader.c.h     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            android.content.Context r1 = com.ss.android.socialbase.downloader.downloader.b.tr()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            com.ss.android.socialbase.appdownloader.DownloadReceiver r2 = r3.u     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            boolean r1 = com.ss.android.socialbase.appdownloader.c.gb     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            com.ss.android.socialbase.appdownloader.b.cb r1 = r3.de     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            if (r1 == 0) goto L22
            r1.hc()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1e
            goto L22
        L1c:
            r1 = move-exception
            goto L30
        L1e:
            r1 = move-exception
            com.bytedance.sdk.component.utils.mq.d(r1)     // Catch: java.lang.Throwable -> L1c
        L22:
            r1 = 0
            com.ss.android.socialbase.appdownloader.c.h = r1     // Catch: java.lang.Throwable -> L1c
            com.ss.android.socialbase.appdownloader.c.gb = r1     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r0 = com.ss.android.socialbase.appdownloader.c.d
            java.lang.String r1 = "registerDownloadReceiver unRegisterDownloadReceiver"
            com.ss.android.socialbase.downloader.an.d.hc(r0, r1)
            return
        L30:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1c
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.uo():void");
    }

    private void sy() {
        if (Build.VERSION.SDK_INT >= 21) {
            yo.d(new yo.hc() { // from class: com.ss.android.socialbase.appdownloader.c.3
                @Override // com.ss.android.socialbase.downloader.impls.yo.hc
                public void d(com.ss.android.socialbase.downloader.h.b bVar, long j, boolean z, int i) {
                    RetryJobSchedulerService.d(bVar, j, z, i);
                }
            });
        }
    }

    public static boolean d(Context context, int i) {
        return b.d(context, i, true) == 1;
    }

    public void d(Context context, int i, int i2) {
        try {
            switch (i2) {
                case -4:
                case -1:
                    com.ss.android.socialbase.downloader.downloader.h.hc(context).u(i);
                    break;
                case -3:
                    b.d(context, i, true);
                    break;
                case -2:
                    com.ss.android.socialbase.downloader.downloader.h.hc(context).b(i);
                    break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 7:
                case 8:
                    com.ss.android.socialbase.downloader.downloader.h.hc(context).d(i);
                    break;
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    public int d(an anVar) {
        int i;
        String str;
        int i2;
        JSONObject jSONObject;
        com.ss.android.socialbase.downloader.h.b bVarGb;
        if (anVar == null || anVar.getContext() == null) {
            return 0;
        }
        try {
            List<com.ss.android.socialbase.downloader.h.u> listD = d(anVar.c());
            String strD = anVar.d();
            if (TextUtils.isEmpty(strD)) {
                return 0;
            }
            final int iRf = anVar.rf();
            final boolean z = iRf == 0;
            String strBc = anVar.bc();
            final String strHc = anVar.hc();
            if (TextUtils.isEmpty(strBc)) {
                strBc = b.d(strD, strHc, anVar.mq(), z);
            }
            if (strBc.length() > 255) {
                strBc = strBc.substring(strBc.length() - 255);
            }
            if (TextUtils.isEmpty(strHc)) {
                strHc = strBc;
            }
            String strMq = anVar.mq();
            if (strBc.endsWith(".apk") && !b.b(anVar.mq())) {
                strMq = "application/vnd.android.package-archive";
            }
            String strB = anVar.b();
            if (TextUtils.isEmpty(anVar.b())) {
                strB = b.hc();
            }
            String str2 = strB;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(strBc)) {
                String strRu = anVar.ru();
                if (TextUtils.isEmpty(strRu)) {
                    strRu = strD;
                }
                int iD = com.ss.android.socialbase.downloader.downloader.b.d(strRu, str2);
                if (com.ss.android.socialbase.downloader.uo.d.d(anVar.i()).d("resume_task_override_settings") && (bVarGb = com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).gb(iD)) != null) {
                    try {
                        anVar.d(new JSONObject(bVarGb.ru()));
                    } catch (Throwable unused) {
                    }
                }
                com.ss.android.socialbase.downloader.uo.d.d(iD, anVar.i());
                boolean zHv = anVar.hv();
                boolean z2 = (com.ss.android.socialbase.downloader.uo.d.d(iD).d("modify_force", 1) == 1 && !zHv && com.ss.android.socialbase.downloader.e.an.c(str2, strBc) && com.ss.android.socialbase.downloader.downloader.h.hc(anVar.getContext()).gb(iD) == null) ? true : zHv;
                vv vvVarTc = anVar.tc();
                if (vvVarTc != null || (!anVar.u() && !anVar.an())) {
                    i = iD;
                    str = str2;
                } else if (anVar.k() != null) {
                    vvVarTc = new com.ss.android.socialbase.appdownloader.u.hc(anVar.k());
                    i = iD;
                    str = str2;
                } else {
                    i = iD;
                    str = str2;
                    vvVarTc = new com.ss.android.socialbase.appdownloader.u.hc(anVar.getContext(), iD, strHc, str, strBc, anVar.mk());
                }
                e eVarTr = anVar.tr();
                if (eVarTr == null) {
                    eVarTr = new e() { // from class: com.ss.android.socialbase.appdownloader.c.4
                        @Override // com.ss.android.socialbase.downloader.c.e
                        public void d(com.ss.android.socialbase.downloader.h.b bVar, com.ss.android.socialbase.downloader.u.d dVar, int i3) {
                            if (c.this.e != null) {
                                c.this.e.d(bVar, dVar, i3);
                            }
                        }
                    };
                }
                List<com.ss.android.socialbase.downloader.c.k> listVv = com.ss.android.socialbase.downloader.downloader.b.vv();
                if (!listVv.isEmpty()) {
                    Iterator<com.ss.android.socialbase.downloader.c.k> it = listVv.iterator();
                    while (it.hasNext()) {
                        anVar.d(it.next());
                    }
                }
                String strMk = anVar.mk();
                try {
                    if (!TextUtils.isEmpty(strMk)) {
                        jSONObject = new JSONObject(strMk);
                    } else {
                        jSONObject = new JSONObject();
                    }
                    jSONObject.put("auto_install_with_notification", anVar.h());
                    jSONObject.put("auto_install_without_notification", anVar.an());
                    strMk = jSONObject.toString();
                } catch (Throwable unused2) {
                }
                boolean z3 = anVar.u() || anVar.an();
                if (!z3 || com.ss.android.socialbase.downloader.uo.d.d(i).hc("enable_notification_ui") <= 0) {
                    i2 = i;
                } else {
                    i2 = i;
                    com.ss.android.socialbase.appdownloader.u.b.d().d(i2, anVar.nw());
                }
                final com.ss.android.socialbase.downloader.h.c cVarW = com.ss.android.socialbase.downloader.downloader.h.d(anVar.getContext()).b(strD).hc(anVar.dz()).d(strBc).hc(strHc).c(str).hc(anVar.gb()).d(listD).d(eVarTr).d(anVar.v()).hc(anVar.np()).c(z3).u(strMk).an(strMq).c(anVar.s()).b(anVar.us()).d(anVar.tt()).hc(vvVarTc).d(d(anVar.nv())).b(z2).an(anVar.w()).h(anVar.yo()).d(anVar.e()).d(anVar.cb()).u(anVar.uo()).h(anVar.jh()).gb(anVar.sy()).d(anVar.de()).gb(anVar.yi()).tt(anVar.he()).tt(anVar.vv()).tc(anVar.zw()).mq(anVar.z()).uo(anVar.fs()).d(anVar.r()).d(anVar.dc()).d(anVar.j()).k(anVar.ba()).d(anVar.y()).d(anVar.nr()).mk(anVar.mt()).d(anVar.wl()).d(anVar.i()).tc(anVar.nw()).e(anVar.xp()).mq(anVar.to()).d(anVar.ra()).u(anVar.l()).hc(anVar.fu()).cb(anVar.rw()).mk(anVar.ru()).w(anVar.ia());
                if (cVarW != null && !anVar.q().isEmpty()) {
                    cVarW.b(anVar.q());
                }
                if (cVarW != null) {
                    if (z3 && anVar.yn() && anVar.getActivity() != null && !anVar.getActivity().isFinishing() && !com.ss.android.socialbase.appdownloader.u.c.d()) {
                        com.ss.android.socialbase.appdownloader.u.c.d(anVar.getActivity(), new com.ss.android.socialbase.appdownloader.b.e() { // from class: com.ss.android.socialbase.appdownloader.c.5
                            @Override // com.ss.android.socialbase.appdownloader.b.e
                            public void d() {
                                com.ss.android.socialbase.downloader.an.d.hc(c.d, "notification permission granted, start download :" + strHc);
                                c.this.d(cVarW, iRf, z);
                            }

                            @Override // com.ss.android.socialbase.appdownloader.b.e
                            public void hc() {
                                com.ss.android.socialbase.downloader.an.d.hc(c.d, "notification permission denied, start download :" + strHc);
                                c.this.d(cVarW, iRf, z);
                            }
                        });
                    } else {
                        com.ss.android.socialbase.downloader.an.d.hc(d, "notification permission need not request, start download :".concat(String.valueOf(strHc)));
                        com.ss.android.socialbase.appdownloader.u.c.d(i2);
                        d(cVarW, iRf, z);
                        cVarW.d();
                    }
                }
                return i2;
            }
            return 0;
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.gb.d.d(anVar.dc(), (com.ss.android.socialbase.downloader.h.b) null, new com.ss.android.socialbase.downloader.u.d(1003, com.ss.android.socialbase.downloader.e.an.hc(th, "addDownloadTask")), 0);
            com.ss.android.socialbase.downloader.an.d.u(d, String.format("add download task error:%s", th));
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.ss.android.socialbase.downloader.h.c cVar, int i, boolean z) {
        if (cVar == null) {
            return;
        }
        cVar.cb();
        com.ss.android.socialbase.downloader.h.b bVarD = cVar.d();
        if (bVarD != null) {
            bVarD.k(i);
        }
        if (bVarD == null || !z) {
            return;
        }
        bVarD.e(z);
    }

    private List<com.ss.android.socialbase.downloader.h.u> d(List<com.ss.android.socialbase.downloader.h.u> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.h.u uVar : list) {
                if (uVar != null && !TextUtils.isEmpty(uVar.d()) && !TextUtils.isEmpty(uVar.hc())) {
                    if (uVar.d().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new com.ss.android.socialbase.downloader.h.u(uVar.d(), uVar.hc()));
                }
            }
        }
        if (!z) {
            arrayList.add(new com.ss.android.socialbase.downloader.h.u("User-Agent", com.ss.android.socialbase.appdownloader.hc.d.d));
        }
        return arrayList;
    }

    public String d(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(".apk") || b.b(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    private s d(final com.ss.android.socialbase.appdownloader.b.an anVar) {
        if (anVar == null) {
            return null;
        }
        return new s() { // from class: com.ss.android.socialbase.appdownloader.c.6
            @Override // com.ss.android.socialbase.downloader.c.s
            public void d(int i, com.ss.android.socialbase.downloader.h.b bVar, String str, String str2) {
                if (i != 1 && i != 3) {
                    if (i == 9) {
                        com.ss.android.socialbase.downloader.downloader.b.tr();
                        return;
                    } else if (i != 5 && i != 6 && i != 7) {
                        return;
                    }
                }
                bVar.w();
            }

            @Override // com.ss.android.socialbase.downloader.c.s
            public boolean d(boolean z) {
                return anVar.d(z);
            }

            @Override // com.ss.android.socialbase.downloader.c.s
            public String d() {
                return anVar.d();
            }
        };
    }

    public com.ss.android.socialbase.downloader.h.b d(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                com.ss.android.socialbase.downloader.h.b bVarD = d(context, str, tt());
                if (bVarD == null) {
                    bVarD = d(context, str, com.bytedance.sdk.openadsdk.api.plugin.hc.d(context, Environment.DIRECTORY_DOWNLOADS));
                }
                if (bVarD == null) {
                    bVarD = d(context, str, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
                }
                if (bVarD == null) {
                    bVarD = d(context, str, com.bytedance.sdk.openadsdk.api.plugin.hc.d(context));
                }
                return (bVarD == null && com.ss.android.socialbase.downloader.uo.d.b().d("get_download_info_by_list")) ? hc(context, str) : bVarD;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.an.d.hc(d, String.format("getAppDownloadInfo error:%s", th.getMessage()));
            }
        }
        return null;
    }

    private com.ss.android.socialbase.downloader.h.b d(Context context, String str, File file) {
        if (context == null || TextUtils.isEmpty(str) || file == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.downloader.h.hc(context).hc(str, file.getAbsolutePath());
    }

    private com.ss.android.socialbase.downloader.h.b hc(Context context, String str) {
        List<com.ss.android.socialbase.downloader.h.b> listD = com.ss.android.socialbase.downloader.downloader.h.hc(context).d(str);
        if (listD == null) {
            return null;
        }
        for (com.ss.android.socialbase.downloader.h.b bVar : listD) {
            if (bVar != null && bVar.nu()) {
                return bVar;
            }
        }
        return null;
    }

    public List<com.ss.android.socialbase.downloader.h.b> d(Context context) {
        return com.ss.android.socialbase.downloader.downloader.h.hc(context).b("application/vnd.android.package-archive");
    }

    public List<com.ss.android.socialbase.downloader.h.b> hc(Context context) {
        return com.ss.android.socialbase.downloader.downloader.h.hc(context).c("application/vnd.android.package-archive");
    }

    public k k() {
        return this.w;
    }

    public com.ss.android.socialbase.appdownloader.b.gb e() {
        return this.cb;
    }

    public void d(com.ss.android.socialbase.appdownloader.b.gb gbVar) {
        this.cb = gbVar;
    }

    public rf cb() {
        return com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).hc();
    }

    public void d(rf rfVar) {
        com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).d(rfVar);
    }

    public void d(z zVar) {
        this.jh = zVar;
    }

    public z w() {
        return this.jh;
    }

    public void d(mt mtVar) {
        this.sy = mtVar;
    }

    public mt yo() {
        return this.sy;
    }

    public void d(int i) {
        if (com.ss.android.socialbase.downloader.uo.d.b().d("enable_app_install_receiver", 1) <= 0) {
            return;
        }
        mq();
        hc(i);
    }

    public void d(cb cbVar) {
        this.de = cbVar;
    }

    public static Pair<Intent, Boolean> hc(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 31 && com.ss.android.socialbase.downloader.uo.d.d(i).hc("enable_target_34") > 0) {
            return new Pair<>(new Intent(context, (Class<?>) DownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) DownloadHandlerService.class), Boolean.FALSE);
    }

    public static PendingIntent d(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }
}
