package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.d.d.hc.w;
import com.ss.android.d.d.u.b;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.h.mk;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.downloadlib.u.hc;
import com.ss.android.hc.d.d.d;
import com.ss.android.hc.d.d.hc;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class hc implements com.ss.android.hc.d.hc {
    private static String d = "hc";
    private static volatile hc hc;
    private tc b = tc.d(mq.getContext());

    private hc() {
    }

    public static hc d() {
        if (hc == null) {
            synchronized (hc.class) {
                if (hc == null) {
                    hc = new hc();
                }
            }
        }
        return hc;
    }

    @Override // com.ss.android.hc.d.hc
    public Dialog d(Context context, String str, boolean z, com.ss.android.d.d.b.b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar, com.ss.android.d.d.b.c cVar, int i) {
        return d(context, str, z, bVar, hcVar, dVar, cVar, i, false);
    }

    @Override // com.ss.android.hc.d.hc
    public Dialog d(Context context, String str, boolean z, com.ss.android.d.d.b.b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar, com.ss.android.d.d.b.c cVar, int i, w wVar) {
        return d(context, str, z, bVar, hcVar, dVar, cVar, i, false, wVar);
    }

    public Dialog d(Context context, String str, boolean z, com.ss.android.d.d.b.b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar, com.ss.android.d.d.b.c cVar, int i, boolean z2) {
        return d(context, str, z, bVar, hcVar, dVar, cVar, i, z2, null);
    }

    public Dialog d(final Context context, final String str, final boolean z, final com.ss.android.d.d.b.b bVar, final com.ss.android.d.d.b.hc hcVar, final com.ss.android.d.d.b.d dVar, final com.ss.android.d.d.b.c cVar, final int i, final boolean z2, final w wVar) {
        return (Dialog) com.ss.android.downloadlib.u.hc.d(new hc.d<Dialog>() { // from class: com.ss.android.downloadlib.hc.1
            @Override // com.ss.android.downloadlib.u.hc.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Dialog hc() {
                return hc.this.hc(context, str, z, bVar, hcVar, dVar, cVar, i, z2, wVar);
            }
        });
    }

    public Dialog hc(Context context, String str, boolean z, final com.ss.android.d.d.b.b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar, com.ss.android.d.d.b.c cVar, int i, boolean z2, w wVar) {
        if (d(bVar.c())) {
            if (z2) {
                d(bVar.c(), hcVar, dVar);
            } else {
                hc(bVar.c());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(bVar.d())) {
            return null;
        }
        this.b.d(context, i, cVar, bVar);
        final com.ss.android.d.d.b.hc hcVar2 = (com.ss.android.d.d.b.hc) uo.d(hcVar, b());
        final com.ss.android.d.d.b.d dVar2 = (com.ss.android.d.d.b.d) uo.d(dVar, hc());
        hcVar2.d(1);
        if ((dVar2.mq() && com.ss.android.downloadlib.addownload.compliance.hc.d().d(bVar)) ? true : (mq.tt().optInt("disable_lp_dialog", 0) == 1) | z) {
            this.b.d(bVar.d(), bVar.c(), 2, hcVar2, dVar2, wVar);
            return null;
        }
        mk.d(d, "tryStartDownload show dialog appName:" + bVar.d(), null);
        Dialog dialogHc = mq.b().hc(new b.d(context).d(bVar.gb()).hc("确认要下载此应用吗？").b("确认").c("取消").d(new b.hc() { // from class: com.ss.android.downloadlib.hc.2
            @Override // com.ss.android.d.d.u.b.hc
            public void d(DialogInterface dialogInterface) {
                hc.this.b.d(bVar.d(), bVar.c(), 2, hcVar2, dVar2);
                com.ss.android.downloadlib.c.d.d().d("landing_download_dialog_confirm", bVar, hcVar2, dVar2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.d.d.u.b.hc
            public void hc(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.c.d.d().d("landing_download_dialog_cancel", bVar, hcVar2, dVar2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.d.d.u.b.hc
            public void b(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.c.d.d().d("landing_download_dialog_cancel", bVar, hcVar2, dVar2);
            }
        }).d(0).d());
        com.ss.android.downloadlib.c.d.d().d("landing_download_dialog_show", bVar, hcVar2, dVar2);
        return dialogHc;
    }

    @Override // com.ss.android.hc.d.hc
    public boolean d(Context context, long j, String str, com.ss.android.d.d.b.c cVar, int i) {
        com.ss.android.hc.d.hc.hc hcVarC = com.ss.android.downloadlib.addownload.hc.an.d().c(j);
        if (hcVarC != null) {
            this.b.d(context, i, cVar, hcVarC.t());
            return true;
        }
        com.ss.android.d.d.b.b bVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(j);
        if (bVarD == null) {
            return false;
        }
        this.b.d(context, i, cVar, bVarD);
        return true;
    }

    @Override // com.ss.android.hc.d.hc
    public boolean d(long j, int i) {
        com.ss.android.d.d.b.b bVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(j);
        if (bVarD == null) {
            return false;
        }
        this.b.d(bVarD.d(), i);
        return true;
    }

    public void d(long j, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar) {
        com.ss.android.d.d.b.b bVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(j);
        com.ss.android.hc.d.hc.hc hcVarC = com.ss.android.downloadlib.addownload.hc.an.d().c(j);
        if (bVarD == null && hcVarC != null) {
            bVarD = hcVarC.t();
        }
        if (bVarD == null) {
            return;
        }
        if (hcVar == null || dVar == null || (hcVar instanceof com.ss.android.d.d.b.h) || (dVar instanceof com.ss.android.d.d.b.an)) {
            hc(j);
        } else {
            hcVar.d(1);
            this.b.d(bVarD.d(), j, 2, hcVar, dVar);
        }
    }

    public void hc(long j) {
        com.ss.android.d.d.b.b bVarD = com.ss.android.downloadlib.addownload.hc.an.d().d(j);
        com.ss.android.hc.d.hc.hc hcVarC = com.ss.android.downloadlib.addownload.hc.an.d().c(j);
        if (bVarD == null && hcVarC != null) {
            bVarD = hcVarC.t();
        }
        if (bVarD == null) {
            return;
        }
        com.ss.android.d.d.b.hc hcVarHc = com.ss.android.downloadlib.addownload.hc.an.d().hc(j);
        com.ss.android.d.d.b.d dVarB = com.ss.android.downloadlib.addownload.hc.an.d().b(j);
        if (hcVarHc instanceof com.ss.android.d.d.b.h) {
            hcVarHc = null;
        }
        if (dVarB instanceof com.ss.android.d.d.b.an) {
            dVarB = null;
        }
        if (hcVarC == null) {
            if (hcVarHc == null) {
                hcVarHc = b();
            }
            if (dVarB == null) {
                dVarB = hc();
            }
        } else {
            if (hcVarHc == null) {
                hcVarHc = new hc.d().d(hcVarC.tc()).tc(hcVarC.tt()).b(hcVarC.uo()).d(false).c("click_start_detail").u("click_pause_detail").an("click_continue_detail").h("click_install_detail").tt("storage_deny_detail").d();
            }
            if (dVarB == null) {
                dVarB = hcVarC.gv();
            }
        }
        com.ss.android.d.d.b.hc hcVar = hcVarHc;
        hcVar.d(1);
        this.b.d(bVarD.d(), j, 2, hcVar, dVarB);
    }

    @Override // com.ss.android.hc.d.hc
    public boolean d(long j) {
        return (com.ss.android.downloadlib.addownload.hc.an.d().d(j) == null && com.ss.android.downloadlib.addownload.hc.an.d().c(j) == null) ? false : true;
    }

    @Override // com.ss.android.hc.d.hc
    public boolean d(Context context, Uri uri, com.ss.android.d.d.b.b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar) {
        return d(context, uri, bVar, hcVar, dVar, null);
    }

    @Override // com.ss.android.hc.d.hc
    public boolean d(final Context context, final Uri uri, final com.ss.android.d.d.b.b bVar, final com.ss.android.d.d.b.hc hcVar, final com.ss.android.d.d.b.d dVar, final w wVar) {
        return ((Boolean) com.ss.android.downloadlib.u.hc.d(new hc.d<Boolean>() { // from class: com.ss.android.downloadlib.hc.3
            @Override // com.ss.android.downloadlib.u.hc.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public Boolean hc() {
                return Boolean.valueOf(hc.this.hc(context, uri, bVar, hcVar, dVar, wVar));
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hc(Context context, Uri uri, com.ss.android.d.d.b.b bVar, com.ss.android.d.d.b.hc hcVar, com.ss.android.d.d.b.d dVar, w wVar) throws JSONException {
        com.ss.android.d.d.b.d dVarHc = dVar;
        if (!com.ss.android.d.d.an.d.d(uri) || mq.tt().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? mq.getContext() : context;
        String strHc = com.ss.android.d.d.an.d.hc(uri);
        if (bVar == null) {
            return com.ss.android.downloadlib.h.tt.d(context2, strHc).getType() == 5;
        }
        if (!TextUtils.isEmpty(strHc) && (bVar instanceof com.ss.android.hc.d.d.b)) {
            ((com.ss.android.hc.d.d.b) bVar).gb(strHc);
        }
        if (dVarHc != null) {
            dVarHc.d(2);
        } else if ((bVar instanceof com.ss.android.hc.d.d.b) && TextUtils.isEmpty(bVar.d())) {
            ((com.ss.android.hc.d.d.b) bVar).tc(uri.toString());
            dVarHc = d(true);
        } else if (bVar.d().startsWith("market")) {
            dVarHc = d(true);
        } else {
            dVarHc = hc();
        }
        com.ss.android.downloadlib.addownload.hc.u uVar = new com.ss.android.downloadlib.addownload.hc.u(bVar.c(), bVar, (com.ss.android.d.d.b.hc) uo.d(hcVar, b()), dVarHc);
        com.ss.android.downloadlib.addownload.hc.an.d().d(uVar.hc);
        com.ss.android.downloadlib.addownload.hc.an.d().d(uVar.d, uVar.b);
        com.ss.android.downloadlib.addownload.hc.an.d().d(uVar.d, uVar.c);
        if (uo.d(bVar) && com.ss.android.socialbase.downloader.uo.d.b().hc("app_link_opt") == 1 && com.ss.android.downloadlib.hc.d.d(uVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        uo.d(jSONObject, "market_url", uri.toString());
        uo.d(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.c.d.d().hc("market_click_open", jSONObject, uVar);
        com.ss.android.downloadlib.addownload.hc.h hVarD = com.ss.android.downloadlib.h.tt.d(context2, uVar, strHc);
        String strD = uo.d(hVarD.hc(), PointCategory.OPEN_MARKET);
        if (hVarD.getType() == 5) {
            com.ss.android.downloadlib.hc.d.d(strD, jSONObject, uVar, true);
            return true;
        }
        if (hVarD.getType() != 6) {
            return true;
        }
        uo.d(jSONObject, "error_code", Integer.valueOf(hVarD.d()));
        com.ss.android.downloadlib.c.d.d().hc("market_open_failed", jSONObject, uVar);
        if (com.ss.android.downloadlib.addownload.tt.d(bVar, wVar)) {
            wVar.d();
        }
        return false;
    }

    public static com.ss.android.d.d.b.d hc() {
        return d(false);
    }

    public static com.ss.android.d.d.b.d d(boolean z) {
        d.C0761d c0761dC = new d.C0761d().d(0).d(true).b(false).c(false);
        if (z) {
            c0761dC.hc(2);
        } else {
            c0761dC.hc(0);
        }
        return c0761dC.d();
    }

    public static com.ss.android.d.d.b.hc b() {
        return new hc.d().d("landing_h5_download_ad_button").hc("landing_h5_download_ad_button").c("click_start_detail").u("click_pause_detail").an("click_continue_detail").h("click_install_detail").gb("click_open_detail").tt("storage_deny_detail").d(1).d(false).hc(true).b(false).d();
    }
}
