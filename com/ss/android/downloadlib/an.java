package com.ss.android.downloadlib;

import android.text.TextUtils;
import com.ss.android.d.d.hc.jh;
import com.ss.android.d.d.hc.k;
import com.ss.android.d.d.hc.mk;
import com.ss.android.d.d.hc.np;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.c.ba;
import com.ss.android.socialbase.downloader.d.d;
import org.json.JSONException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class an implements com.ss.android.d.d.d {
    an() {
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(com.ss.android.d.d.hc.tc tcVar) {
        mq.d(tcVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(com.ss.android.d.d.hc.h hVar) {
        mq.d(hVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(k kVar) {
        mq.d(kVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(com.ss.android.d.d.hc.tt ttVar) {
        mq.d(ttVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(com.ss.android.d.d.hc.mq mqVar) {
        mq.d(mqVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(com.ss.android.d.d.u.d dVar) {
        mq.d(dVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(String str) {
        mq.d(str);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(com.ss.android.socialbase.appdownloader.b.b bVar) {
        mq.d(bVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(final com.ss.android.d.d.hc.hc hcVar) {
        mq.d(hcVar);
        com.ss.android.socialbase.downloader.d.d.d().d(new d.b() { // from class: com.ss.android.downloadlib.an.1
        });
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(com.ss.android.socialbase.downloader.downloader.gb gbVar) {
        if (gbVar.np() == null) {
            gbVar.d(new ba() { // from class: com.ss.android.downloadlib.an.2
                @Override // com.ss.android.socialbase.downloader.c.ba
                public boolean hc(com.ss.android.socialbase.downloader.h.b bVar) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.c.ba
                public boolean d(com.ss.android.socialbase.downloader.h.b bVar) throws JSONException {
                    com.ss.android.socialbase.downloader.uo.d dVarD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h());
                    if (dVarD.hc("notification_opt_2") == 1) {
                        if (bVar.w() == -2) {
                            DownloadHandlerService.d(mq.getContext(), bVar, com.ss.android.socialbase.appdownloader.c.mk().b(), com.ss.android.socialbase.downloader.downloader.h.hc(mq.getContext()).tt(bVar.h()));
                        }
                        return true;
                    }
                    boolean zC = c(bVar);
                    if (dVarD.d("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return zC;
                }

                private boolean c(com.ss.android.socialbase.downloader.h.b bVar) {
                    String strD;
                    np npVarRf = mq.rf();
                    if (npVarRf == null) {
                        return false;
                    }
                    com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
                    if (hcVarD != null && hcVarD.b()) {
                        strD = com.ss.android.socialbase.downloader.uo.d.d(bVar.h()).d("ad_notification_jump_url", (String) null);
                    } else {
                        strD = com.ss.android.downloadlib.addownload.tt.d(bVar);
                    }
                    if (TextUtils.isEmpty(strD)) {
                        return false;
                    }
                    return npVarRf.d(mq.getContext(), strD);
                }

                @Override // com.ss.android.socialbase.downloader.c.ba
                public boolean b(com.ss.android.socialbase.downloader.h.b bVar) throws JSONException {
                    if (bVar == null) {
                        return false;
                    }
                    com.ss.android.hc.d.hc.hc hcVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(bVar);
                    if (hcVarD != null) {
                        com.ss.android.downloadlib.hc.d.d(hcVarD);
                    } else {
                        com.ss.android.downloadlib.h.tt.hc(mq.getContext(), bVar.us());
                    }
                    com.ss.android.socialbase.downloader.notification.hc.d().an(bVar.h());
                    return true;
                }
            });
        }
        gbVar.d(new com.ss.android.downloadlib.b.b());
        com.ss.android.socialbase.downloader.downloader.h.d(gbVar, true);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(com.ss.android.socialbase.appdownloader.b.h hVar) {
        com.ss.android.socialbase.appdownloader.c.mk().d(hVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(jh jhVar) {
        mq.d(jhVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public com.ss.android.d.d.d d(mk mkVar) {
        mq.d(mkVar);
        return this;
    }

    @Override // com.ss.android.d.d.d
    public void d() throws JSONException {
        if (!mq.np()) {
            com.ss.android.downloadlib.u.b.d().d("ttdownloader init error");
        }
        mq.d(com.ss.android.downloadlib.u.b.d());
        try {
            com.ss.android.socialbase.appdownloader.c.mk().hc(mq.v());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
        com.ss.android.socialbase.appdownloader.c.mk().d(d.d());
        u.d().hc(new Runnable() { // from class: com.ss.android.downloadlib.an.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.an.u.d("");
                if (com.ss.android.socialbase.appdownloader.an.u.e()) {
                    com.ss.android.socialbase.downloader.downloader.b.d(true);
                }
                if (com.ss.android.socialbase.downloader.uo.d.b().d("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.an.an.d(mq.getContext());
                }
            }
        });
    }
}
