package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.socialbase.appdownloader.b.c;
import com.ss.android.socialbase.appdownloader.b.mq;
import com.ss.android.socialbase.appdownloader.b.u;
import com.ss.android.socialbase.appdownloader.b.uo;
import com.ss.android.socialbase.appdownloader.tt;
import com.ss.android.socialbase.downloader.c.s;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.e.an;
import com.ss.android.socialbase.downloader.h.b;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class DownloadTaskDeleteActivity extends Activity {
    private mq d;
    private Intent hc;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
    }

    private void d() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        this.hc = getIntent();
        hc();
        mq mqVar = this.d;
        if (mqVar != null && !mqVar.hc()) {
            this.d.d();
        } else if (this.d == null) {
            finish();
        }
    }

    private void hc() throws Resources.NotFoundException {
        Intent intent;
        if (this.d != null || (intent = this.hc) == null) {
            return;
        }
        try {
            final boolean z = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final b bVarGb = h.hc(getApplicationContext()).gb(intExtra);
            if (bVarGb == null) {
                return;
            }
            String strTt = bVarGb.tt();
            if (TextUtils.isEmpty(strTt)) {
                com.bytedance.sdk.component.utils.mq.hc("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String string = String.format(getString(tt.d(this, "tt_appdownloader_notification_download_delete")), strTt);
            c cVarHc = com.ss.android.socialbase.appdownloader.c.mk().hc();
            uo uoVarD = cVarHc != null ? cVarHc.d(this) : null;
            if (uoVarD == null) {
                uoVarD = new com.ss.android.socialbase.appdownloader.c.d(this);
            }
            if (uoVarD != null) {
                int iD = tt.d(this, "tt_appdownloader_tip");
                int iD2 = tt.d(this, "tt_appdownloader_label_ok");
                int iD3 = tt.d(this, "tt_appdownloader_label_cancel");
                if (com.ss.android.socialbase.downloader.uo.d.d(bVarGb.h()).d("cancel_with_net_opt", 0) == 1 && an.gb() && bVarGb.js() != bVarGb.mb()) {
                    z = true;
                }
                if (z) {
                    iD2 = tt.d(this, "tt_appdownloader_label_reserve_wifi");
                    iD3 = tt.d(this, "tt_appdownloader_label_cancel_directly");
                    string = getResources().getString(tt.d(this, "tt_appdownloader_resume_in_wifi"));
                }
                uoVarD.d(iD).d(string).d(iD2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!z) {
                            DownloadTaskDeleteActivity.this.d(bVarGb, intExtra);
                        } else {
                            bVarGb.c(true);
                            h.hc(DownloadTaskDeleteActivity.this).d(bVarGb.h());
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.hc(DownloadTaskDeleteActivity.this).b(bVarGb.h());
                                }
                            }, 100L);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).hc(iD3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (z) {
                            DownloadTaskDeleteActivity.this.d(bVarGb, intExtra);
                        }
                        DownloadTaskDeleteActivity.this.finish();
                    }
                }).d(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        DownloadTaskDeleteActivity.this.finish();
                    }
                });
                this.d = uoVarD.d();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(b bVar, int i) {
        u uVarB = com.ss.android.socialbase.appdownloader.c.mk().b();
        if (uVarB != null) {
            uVarB.d(bVar);
        }
        s sVarTt = h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).tt(i);
        if (sVarTt != null) {
            sVarTt.d(10, bVar, "", "");
        }
        if (com.ss.android.socialbase.downloader.downloader.b.tr() != null) {
            h.hc(com.ss.android.socialbase.downloader.downloader.b.tr()).hc(i);
        }
    }
}
