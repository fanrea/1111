package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.luck.picture.lib.permissions.PermissionConfig;
import com.ss.android.d.d.b.h;
import com.ss.android.d.d.hc.v;
import com.ss.android.d.d.hc.w;
import com.ss.android.d.d.hc.yi;
import com.ss.android.downloadlib.addownload.gb;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.c.vv;
import com.ss.android.socialbase.downloader.h.b;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class u implements h, k.d {
    private static final String d = "u";
    private final Map<Integer, Object> an;
    private gb b;
    private c c;
    private com.ss.android.d.d.b.hc cb;
    private com.ss.android.d.d.b.b e;
    private com.ss.android.socialbase.downloader.h.b gb;
    private com.ss.android.d.d.u.u h;
    private final com.ss.android.downloadlib.h.k hc;
    private final boolean jh;
    private long k;
    private boolean mk;
    private long mq;
    private boolean rf;
    private SoftReference<w> sy;
    private final vv tc;
    private b tt;
    private WeakReference<Context> u;
    private String uo;
    private com.ss.android.d.d.b.d w;
    private SoftReference<yi> yo;

    interface d {
        void d();
    }

    interface hc {
        void d(long j);
    }

    public u() {
        com.ss.android.downloadlib.h.k kVar = new com.ss.android.downloadlib.h.k(Looper.getMainLooper(), this);
        this.hc = kVar;
        this.an = new ConcurrentHashMap();
        this.tc = new gb.d(kVar);
        this.k = -1L;
        this.e = null;
        this.cb = null;
        this.w = null;
        this.b = new gb(this);
        this.c = new c(kVar);
        this.jh = com.ss.android.socialbase.downloader.uo.d.b().d("ttdownloader_callback_twice");
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public u hc(Context context) {
        if (context != null) {
            this.u = new WeakReference<>(context);
        }
        mq.hc(context);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public u hc(int i, com.ss.android.d.d.b.c cVar) {
        if (cVar != null) {
            if (mq.tt().optInt("back_use_softref_listener") == 1) {
                this.an.put(Integer.valueOf(i), cVar);
            } else if (mq.tt().optInt("use_weakref_listener") == 1) {
                this.an.put(Integer.valueOf(i), new WeakReference(cVar));
            } else {
                this.an.put(Integer.valueOf(i), new SoftReference(cVar));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public u hc(com.ss.android.d.d.b.b bVar) throws JSONException {
        if (bVar != null) {
            if (bVar.np()) {
                if (bVar.c() <= 0 || TextUtils.isEmpty(bVar.yi())) {
                    com.ss.android.downloadlib.u.b.d().d("setDownloadModel ad error");
                }
            } else if (bVar.c() == 0 && (bVar instanceof com.ss.android.hc.d.d.b)) {
                com.ss.android.downloadlib.u.b.d().d(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.uo.d.b().d("fix_model_id")) {
                    ((com.ss.android.hc.d.d.b) bVar).b(bVar.d().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
            this.k = bVar.c();
            this.e = bVar;
            if (tt.d(bVar)) {
                ((com.ss.android.hc.d.d.b) bVar).hc(3L);
                com.ss.android.hc.d.hc.hc hcVarC = com.ss.android.downloadlib.addownload.hc.an.d().c(this.k);
                if (hcVarC != null && hcVarC.mq() != 3) {
                    hcVarC.u(3L);
                    com.ss.android.downloadlib.addownload.hc.tt.d().d(hcVarC);
                }
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public u hc(com.ss.android.d.d.b.d dVar) {
        JSONObject jSONObjectS;
        this.w = dVar;
        if (com.ss.android.downloadlib.h.u.hc(this.e).hc("force_auto_open") == 1) {
            uo().hc(1);
        }
        if (com.ss.android.socialbase.downloader.uo.d.b().d("fix_show_dialog") && (jSONObjectS = this.e.s()) != null && jSONObjectS.optInt("subprocess") > 0) {
            uo().hc(false);
        }
        com.ss.android.downloadlib.addownload.hc.an.d().d(this.k, uo());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public u hc(com.ss.android.d.d.b.hc hcVar) {
        this.cb = hcVar;
        this.rf = mq().mk() == 0;
        com.ss.android.downloadlib.addownload.hc.an.d().d(this.k, mq());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h d(yi yiVar) {
        if (yiVar == null) {
            this.yo = null;
        } else {
            this.yo = new SoftReference<>(yiVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void d() {
        this.mk = true;
        com.ss.android.downloadlib.addownload.hc.an.d().d(this.k, mq());
        com.ss.android.downloadlib.addownload.hc.an.d().d(this.k, uo());
        this.b.d(this.k);
        cb();
        if (mq.tt().optInt("enable_empty_listener", 1) == 1 && this.an.get(Integer.MIN_VALUE) == null) {
            hc(Integer.MIN_VALUE, new com.ss.android.d.d.hc.d());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public boolean d(int i) {
        if (i == 0) {
            this.an.clear();
        } else {
            this.an.remove(Integer.valueOf(i));
        }
        if (this.an.isEmpty()) {
            this.mk = false;
            this.mq = System.currentTimeMillis();
            if (this.gb != null) {
                com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).mk(this.gb.h());
            }
            b bVar = this.tt;
            if (bVar != null && bVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.tt.cancel(true);
            }
            this.b.d(this.gb);
            String str = d;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            com.ss.android.socialbase.downloader.h.b bVar2 = this.gb;
            com.ss.android.downloadlib.h.mk.d(str, sb.append(bVar2 == null ? "" : bVar2.tc()).toString(), null);
            this.hc.removeCallbacksAndMessages(null);
            this.h = null;
            this.gb = null;
            return true;
        }
        if (this.an.size() == 1 && this.an.containsKey(Integer.MIN_VALUE)) {
            this.b.hc(this.gb);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void d(boolean z) {
        if (this.gb != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.b.u uVarB = com.ss.android.socialbase.appdownloader.c.mk().b();
                if (uVarB != null) {
                    uVarB.d(this.gb);
                }
                com.ss.android.socialbase.downloader.downloader.h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).d(this.gb.h(), true);
                return;
            }
            Intent intent = new Intent(mq.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.gb.h());
            mq.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public boolean hc() {
        return this.mk;
    }

    public boolean b() {
        com.ss.android.socialbase.downloader.h.b bVar = this.gb;
        return (bVar == null || bVar.w() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public long c() {
        return this.mq;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h d(long j) throws JSONException {
        if (j != 0) {
            com.ss.android.d.d.b.b bVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(j);
            if (bVarD != null) {
                this.e = bVarD;
                this.k = j;
                this.b.d(j);
            }
        } else {
            com.ss.android.downloadlib.u.b.d().d(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void hc(final int i) throws JSONException {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.b.d(this.k);
        if (!com.ss.android.downloadlib.addownload.hc.an.d().u(this.k).yi()) {
            com.ss.android.downloadlib.u.b.d().d("handleDownload ModelBox !isStrictValid");
        }
        if (this.b.d(i, this.e)) {
            com.ss.android.downloadlib.addownload.compliance.an.d().d(this.b.d, new com.ss.android.downloadlib.addownload.compliance.gb() { // from class: com.ss.android.downloadlib.addownload.u.1
                @Override // com.ss.android.downloadlib.addownload.compliance.gb
                public void d(String str) throws JSONException {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!com.ss.android.downloadlib.h.gb.d(u.this.getContext(), u.this.b.d, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.ss.android.downloadlib.addownload.compliance.an.d().d(1, u.this.b.d, jSONObject);
                            int i2 = i;
                            if (i2 == 1) {
                                com.ss.android.socialbase.downloader.an.d.d(u.d, "miui new rollback fail: handleDownload id:" + u.this.k + ",tryPerformButtonClick:", null);
                                u.this.b(true);
                                return;
                            } else {
                                if (i2 != 2) {
                                    return;
                                }
                                com.ss.android.socialbase.downloader.an.d.d(u.d, "miui new rollback fail: handleDownload id:" + u.this.k + ",tryPerformButtonClick:", null);
                                u.this.hc(true);
                                return;
                            }
                        }
                        jSONObject.putOpt("download_miui_jump_market_success", 1);
                        com.ss.android.downloadlib.addownload.compliance.an.d().d(0, u.this.b.d, jSONObject);
                    } catch (Exception e) {
                        com.ss.android.downloadlib.u.b.d().d(e, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.gb
                public void d() {
                    int i2 = i;
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.an.d.d(u.d, "miui new get miui deeplink fail: handleDownload id:" + u.this.k + ",tryPerformButtonClick:", null);
                        u.this.b(true);
                    } else {
                        if (i2 != 2) {
                            return;
                        }
                        com.ss.android.socialbase.downloader.an.d.d(u.d, "miui new get miui deeplink fail: handleDownload id:" + u.this.k + ",tryPerformButtonClick:", null);
                        u.this.hc(true);
                    }
                }
            });
            return;
        }
        if (this.b.d(getContext(), i, this.rf)) {
            return;
        }
        boolean zB = b(i);
        if (i == 1) {
            if (zB) {
                return;
            }
            com.ss.android.downloadlib.h.mk.d(d, "handleDownload id:" + this.k + ",pIC:", null);
            b(true);
            return;
        }
        if (i == 2 && !zB) {
            com.ss.android.downloadlib.h.mk.d(d, "handleDownload id:" + this.k + ",pBC:", null);
            hc(true);
        }
    }

    public boolean u() {
        return mq.tt().optInt("quick_app_enable_switch", 0) == 0 && this.e.z() != null && !TextUtils.isEmpty(this.e.z().d()) && com.ss.android.downloadlib.addownload.b.d(this.gb) && com.ss.android.downloadlib.h.uo.d(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.e.z().d())));
    }

    private boolean b(int i) {
        if (!u()) {
            return false;
        }
        int i2 = -1;
        String strD = this.e.z().d();
        if (i == 1) {
            i2 = 5;
        } else if (i == 2) {
            i2 = 4;
        }
        com.ss.android.d.d.b.b bVar = this.e;
        if (bVar instanceof com.ss.android.hc.d.d.b) {
            ((com.ss.android.hc.d.d.b) bVar).b(3);
        }
        boolean zB = com.ss.android.downloadlib.h.tt.b(mq.getContext(), strD);
        if (zB) {
            com.ss.android.downloadlib.c.d.d().d(this.k, i);
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.obj = Long.valueOf(this.e.c());
            com.ss.android.downloadlib.addownload.b.d().d(this, i2, this.e);
        } else {
            com.ss.android.downloadlib.c.d.d().d(this.k, false, 0);
        }
        return zB;
    }

    public void hc(boolean z) {
        u(z);
    }

    private void mk() {
        SoftReference<yi> softReference = this.yo;
        if (softReference != null && softReference.get() != null) {
            this.yo.get().onItemClick(this.e, mq(), uo());
            this.yo = null;
        } else {
            mq.hc();
            getContext();
            uo();
        }
    }

    public void b(boolean z) {
        if (z) {
            com.ss.android.downloadlib.c.d.d().d(this.k, 1);
        }
        k();
    }

    private void u(boolean z) {
        if (com.ss.android.downloadlib.h.u.hc(this.e).hc("notification_opt_2") == 1 && this.gb != null) {
            com.ss.android.socialbase.downloader.notification.hc.d().an(this.gb.h());
        }
        an(z);
    }

    public void an() {
        this.hc.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.u.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<com.ss.android.d.d.b.c> it = gb.d((Map<Integer, Object>) u.this.an).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(u.this.w());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.h.k.d
    public void d(Message message) {
        if (message != null && this.mk && message.what == 3) {
            this.gb = (com.ss.android.socialbase.downloader.h.b) message.obj;
            this.b.d(message, w(), this.an);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.u;
        if (weakReference != null && weakReference.get() != null) {
            return this.u.get();
        }
        return mq.getContext();
    }

    private com.ss.android.d.d.b.hc mq() {
        com.ss.android.d.d.b.hc hcVar = this.cb;
        return hcVar == null ? new h.d().d() : hcVar;
    }

    private com.ss.android.d.d.b.d uo() {
        if (this.w == null) {
            this.w = new com.ss.android.d.d.b.an();
        }
        return this.w;
    }

    private void k() {
        String str = d;
        com.ss.android.downloadlib.h.mk.d(str, "pICD", null);
        if (this.b.c(this.gb)) {
            com.ss.android.downloadlib.h.mk.d(str, "pICD BC", null);
            an(false);
        } else {
            com.ss.android.downloadlib.h.mk.d(str, "pICD IC", null);
            mk();
        }
    }

    private void an(final boolean z) {
        com.ss.android.d.d.b.b bVar;
        String str = d;
        com.ss.android.downloadlib.h.mk.d(str, "pBCD", null);
        if (e()) {
            com.ss.android.downloadlib.addownload.hc.u uVarU = com.ss.android.downloadlib.addownload.hc.an.d().u(this.k);
            if (this.rf) {
                if (tt()) {
                    if (c(false) && uVarU.c != null && uVarU.c.uo()) {
                        d(z, true);
                        return;
                    }
                    return;
                }
                d(z, true);
                return;
            }
            if (this.e.np() && uVarU.c != null && uVarU.c.mq() && uVarU.hc != null && com.ss.android.downloadlib.addownload.compliance.hc.d().d(uVarU.hc) && com.ss.android.downloadlib.addownload.compliance.hc.d().d(uVarU)) {
                return;
            }
            d(z, true);
            return;
        }
        com.ss.android.downloadlib.h.mk.d(str, "pBCD continue download, status:" + this.gb.w(), null);
        com.ss.android.socialbase.downloader.h.b bVar2 = this.gb;
        if (bVar2 != null && (bVar = this.e) != null) {
            bVar2.c(bVar.uo());
        }
        final int iW = this.gb.w();
        final int iH = this.gb.h();
        final com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(this.gb);
        if (iW == -2 || iW == -1) {
            this.b.d(this.gb, z);
            if (hcVarD != null) {
                hcVarD.gb(System.currentTimeMillis());
                hcVarD.tt(this.gb.js());
            }
            this.gb.u(false);
            this.c.d(new com.ss.android.downloadlib.addownload.hc.u(this.k, this.e, mq(), uo()));
            this.c.d(iH, this.gb.js(), this.gb.mb(), new d() { // from class: com.ss.android.downloadlib.addownload.u.3
                @Override // com.ss.android.downloadlib.addownload.u.d
                public void d() {
                    if (u.this.c.d()) {
                        return;
                    }
                    u uVar = u.this;
                    uVar.d(iH, iW, uVar.gb);
                }
            });
            if (iW == -2 && com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVarD).d("show_pause_continue_toast", 0) == 1) {
                com.ss.android.downloadlib.gb.d().hc().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.u.4
                    @Override // java.lang.Runnable
                    public void run() {
                        mq.b().d(13, mq.getContext(), u.this.e, "已恢复下载", null, 0);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (e.d(iW)) {
            if (this.e.y()) {
                this.c.d(true);
                com.ss.android.downloadlib.b.gb.d().hc(com.ss.android.downloadlib.addownload.hc.an.d().c(this.k));
                if (com.ss.android.downloadlib.h.u.d((com.ss.android.hc.d.hc.d) hcVarD).d("cancel_pause_optimise_switch", 0) == 1) {
                    com.ss.android.downloadlib.addownload.c.c.d().d(hcVarD, iW, new com.ss.android.downloadlib.addownload.c.gb() { // from class: com.ss.android.downloadlib.addownload.u.6
                        @Override // com.ss.android.downloadlib.addownload.c.gb
                        public void d(com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
                            if (u.this.gb == null && com.ss.android.socialbase.downloader.uo.d.b().d("fix_handle_pause")) {
                                u.this.gb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(iH);
                            }
                            u.this.b.d(u.this.gb, z);
                            if (u.this.gb == null || !com.ss.android.socialbase.downloader.e.an.hc(mq.getContext()) || !u.this.gb.xp()) {
                                mk.d().d(u.this.e, u.this.gb);
                                hcVar.mk(System.currentTimeMillis());
                                u uVar = u.this;
                                uVar.d(iH, iW, uVar.gb);
                                return;
                            }
                            u.this.gb.ia();
                            com.ss.android.downloadlib.c.d.d().d("cancel_pause_reserve_wifi_cancel_on_wifi", hcVarD);
                        }
                    }, new com.ss.android.downloadlib.addownload.d.b() { // from class: com.ss.android.downloadlib.addownload.u.5
                        @Override // com.ss.android.downloadlib.addownload.d.b
                        public void delete() {
                            u.this.d(true);
                        }
                    });
                    return;
                } else {
                    com.ss.android.downloadlib.addownload.c.mk.d().d(hcVarD, iW, new com.ss.android.downloadlib.addownload.c.gb() { // from class: com.ss.android.downloadlib.addownload.u.7
                        @Override // com.ss.android.downloadlib.addownload.c.gb
                        public void d(com.ss.android.hc.d.hc.hc hcVar) throws JSONException {
                            if (u.this.gb == null && com.ss.android.socialbase.downloader.uo.d.b().d("fix_handle_pause")) {
                                u.this.gb = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(iH);
                            }
                            u.this.b.d(u.this.gb, z);
                            if (u.this.gb == null || !com.ss.android.socialbase.downloader.e.an.hc(mq.getContext()) || !u.this.gb.xp()) {
                                mk.d().d(u.this.e, u.this.gb);
                                hcVar.mk(System.currentTimeMillis());
                                u uVar = u.this;
                                uVar.d(iH, iW, uVar.gb);
                                return;
                            }
                            u.this.gb.ia();
                            com.ss.android.downloadlib.c.d.d().hc("pause_reserve_wifi_cancel_on_wifi", hcVarD);
                        }
                    });
                    return;
                }
            }
            return;
        }
        this.b.d(this.gb, z);
        d(iH, iW, this.gb);
    }

    public void d(boolean z, final boolean z2) {
        if (z) {
            com.ss.android.downloadlib.c.d.d().d(this.k, 2);
        }
        if (!com.ss.android.downloadlib.h.uo.d()) {
            if (!com.ss.android.downloadlib.h.tc.hc("android.permission.WRITE_EXTERNAL_STORAGE") && !uo().k()) {
                this.e.d(this.b.hc());
            }
        } else if (!com.ss.android.downloadlib.h.tc.hc("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.h.tc.hc(PermissionConfig.READ_MEDIA_AUDIO) && !com.ss.android.downloadlib.h.tc.hc("android.permission.READ_MEDIA_VIDEO") && !uo().k()) {
            this.e.d(this.b.hc());
        }
        if (com.ss.android.downloadlib.h.u.b(this.e) == 0) {
            com.ss.android.downloadlib.h.mk.d(d, "pBCD not start", null);
            this.b.d(new v() { // from class: com.ss.android.downloadlib.addownload.u.8
                @Override // com.ss.android.d.d.hc.v
                public void d() {
                    com.ss.android.downloadlib.h.mk.d(u.d, "pBCD start download", null);
                    u.this.h(z2);
                }

                @Override // com.ss.android.d.d.hc.v
                public void d(String str) {
                    com.ss.android.downloadlib.h.mk.d(u.d, "pBCD onDenied", null);
                }
            });
        } else {
            h(z2);
        }
    }

    private boolean e() {
        if (com.ss.android.socialbase.downloader.uo.d.b().d("fix_click_start")) {
            com.ss.android.socialbase.downloader.h.b bVar = this.gb;
            if (bVar == null) {
                return true;
            }
            if ((bVar.w() == -3 && this.gb.js() <= 0) || this.gb.w() == 0 || this.gb.w() == -4) {
                return true;
            }
            return com.ss.android.socialbase.downloader.e.an.d(this.gb.w(), this.gb.mk(), this.gb.gb());
        }
        com.ss.android.socialbase.downloader.h.b bVar2 = this.gb;
        if (bVar2 == null) {
            return true;
        }
        return !(bVar2.w() == -3 || com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).c(this.gb.h())) || this.gb.w() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, int i2, com.ss.android.socialbase.downloader.h.b bVar) {
        if (com.ss.android.socialbase.downloader.uo.d.b().d("fix_click_start")) {
            if (i2 != -3 && !com.ss.android.socialbase.downloader.downloader.c.d().u(i)) {
                d(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.c.mk().d(mq.getContext(), i, i2);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.c.mk().d(mq.getContext(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final boolean z) {
        this.c.d(new com.ss.android.downloadlib.addownload.hc.u(this.k, this.e, mq(), uo()));
        this.c.d(0, 0L, 0L, new d() { // from class: com.ss.android.downloadlib.addownload.u.9
            @Override // com.ss.android.downloadlib.addownload.u.d
            public void d() throws JSONException {
                if (u.this.c.d()) {
                    return;
                }
                u.this.gb(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb(boolean z) throws JSONException {
        Iterator<com.ss.android.d.d.b.c> it = gb.d(this.an).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.e, uo());
        }
        int iD = this.b.d(mq.getContext(), this.tc);
        String str = d;
        com.ss.android.downloadlib.h.mk.d(str, "beginDown id:" + iD, null);
        if (iD != 0) {
            if (this.gb != null && !com.ss.android.socialbase.downloader.uo.d.b().d("fix_click_start")) {
                this.b.d(this.gb, false);
            } else if (z) {
                this.b.d();
            }
        } else {
            com.ss.android.socialbase.downloader.h.b bVarD = new b.d(this.e.d()).d();
            bVarD.c(-1);
            d(bVarD);
            com.ss.android.downloadlib.c.d.d().d(this.k, new com.ss.android.socialbase.downloader.u.d(2, "start download failed, id=0"));
            com.ss.android.downloadlib.u.b.d().hc("beginDown");
        }
        if (this.b.d(b())) {
            com.ss.android.downloadlib.h.mk.d(str, "beginDown IC id:" + iD, null);
            mk();
        }
    }

    public void h() {
        if (this.an.size() == 0) {
            return;
        }
        Iterator<com.ss.android.d.d.b.c> it = gb.d(this.an).iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        com.ss.android.socialbase.downloader.h.b bVar = this.gb;
        if (bVar != null) {
            bVar.c(-4);
        }
    }

    private class b extends com.bytedance.sdk.component.tc.c.hc<String, Void, com.ss.android.socialbase.downloader.h.b> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.ss.android.socialbase.downloader.h.b doInBackground(String... strArr) {
            com.ss.android.socialbase.downloader.h.b bVarHc = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length > 0 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            String str2 = strArr[0];
            if (u.this.e != null && !TextUtils.isEmpty(u.this.e.e())) {
                if (TextUtils.isEmpty(str)) {
                    bVarHc = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).hc(str2, u.this.e.e());
                } else {
                    bVarHc = com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).gb(com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).d(str, u.this.e.e()));
                }
            }
            if (bVarHc != null) {
                return bVarHc;
            }
            if (!TextUtils.isEmpty(str)) {
                return com.ss.android.socialbase.appdownloader.c.mk().d(mq.getContext(), str);
            }
            return com.ss.android.socialbase.appdownloader.c.mk().d(mq.getContext(), str2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(com.ss.android.socialbase.downloader.h.b bVar) {
            super.onPostExecute(bVar);
            if (isCancelled() || u.this.e == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.hc.b bVarD = com.ss.android.downloadlib.h.uo.d(u.this.e.he(), u.this.e.de(), u.this.e.v());
                com.ss.android.downloadlib.addownload.hc.gb.d().d(u.this.e.de(), bVarD.hc(), com.ss.android.downloadlib.addownload.hc.an.d().d(bVar));
                boolean zD = bVarD.d();
                if (bVar != null && bVar.h() != 0 && (zD || !com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).d(bVar))) {
                    com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).mk(bVar.h());
                    if (u.this.gb == null || u.this.gb.w() != -4) {
                        u.this.gb = bVar;
                        if (u.this.jh) {
                            com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).d(u.this.gb.h(), u.this.tc, false);
                        } else {
                            com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).d(u.this.gb.h(), u.this.tc);
                        }
                    } else {
                        u.this.gb = null;
                    }
                    u.this.b.d(u.this.gb, u.this.w(), gb.d((Map<Integer, Object>) u.this.an), zD);
                } else {
                    if (bVar != null && com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).d(bVar)) {
                        com.ss.android.socialbase.downloader.notification.hc.d().an(bVar.h());
                        u.this.gb = null;
                    }
                    if (u.this.gb != null) {
                        com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).mk(u.this.gb.h());
                        if (u.this.jh) {
                            com.ss.android.socialbase.downloader.downloader.h.hc(u.this.getContext()).d(u.this.gb.h(), u.this.tc, false);
                        } else {
                            com.ss.android.socialbase.downloader.downloader.h.hc(u.this.getContext()).d(u.this.gb.h(), u.this.tc);
                        }
                    }
                    if (!zD) {
                        Iterator<com.ss.android.d.d.b.c> it = gb.d((Map<Integer, Object>) u.this.an).iterator();
                        while (it.hasNext()) {
                            it.next().d();
                        }
                        u.this.gb = null;
                    } else {
                        u.this.gb = new b.d(u.this.e.d()).d();
                        u.this.gb.c(-3);
                        u.this.b.d(u.this.gb, u.this.w(), gb.d((Map<Integer, Object>) u.this.an), zD);
                    }
                }
                u.this.b.b(u.this.gb);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
    }

    private void d(com.ss.android.socialbase.downloader.h.b bVar) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = bVar;
        this.hc.sendMessage(messageObtain);
    }

    private void cb() {
        b bVar = this.tt;
        if (bVar != null && bVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.tt.cancel(true);
        }
        this.tt = new b();
        if (!TextUtils.isEmpty(this.uo)) {
            com.ss.android.downloadlib.h.hc.d(this.tt, this.e.d(), this.e.he(), this.uo);
        } else {
            com.ss.android.downloadlib.h.hc.d(this.tt, this.e.d(), this.e.he());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.d.d.u.u w() {
        if (this.h == null) {
            this.h = new com.ss.android.d.d.u.u();
        }
        return this.h;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public void gb() {
        com.ss.android.downloadlib.addownload.hc.an.d().an(this.k);
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.uo = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.h
    public h d(w wVar) {
        if (wVar == null) {
            this.sy = null;
        } else {
            this.sy = new SoftReference<>(wVar);
        }
        return this;
    }

    public boolean tt() {
        SoftReference<w> softReference = this.sy;
        if (softReference == null) {
            return false;
        }
        return tt.d(this.e, softReference.get());
    }

    public boolean c(boolean z) throws JSONException {
        SoftReference<w> softReference = this.sy;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.sy.get().d(true);
                } else {
                    this.sy.get().d();
                }
                this.sy = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.u.b.d().hc("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.u.b.d().hc("mDownloadButtonClickListener has recycled");
        return false;
    }
}
