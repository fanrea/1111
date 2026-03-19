package com.ss.android.downloadlib.b;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.d.d.u.b;
import com.ss.android.downloadlib.h.mk;
import com.ss.android.socialbase.appdownloader.b.mq;
import com.ss.android.socialbase.appdownloader.b.uo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class h extends com.ss.android.socialbase.appdownloader.b.d {
    private static String d = "h";

    @Override // com.ss.android.socialbase.appdownloader.b.d, com.ss.android.socialbase.appdownloader.b.c
    public uo d(Context context) {
        return new uo(context) { // from class: com.ss.android.downloadlib.b.h.1
            private DialogInterface.OnCancelListener an;
            private b.d b;
            private DialogInterface.OnClickListener c;
            final /* synthetic */ Context d;
            private DialogInterface.OnClickListener u;

            {
                this.d = context;
                this.b = new b.d(context);
            }

            @Override // com.ss.android.socialbase.appdownloader.b.uo
            public uo d(int i) {
                this.b.d(this.d.getResources().getString(i));
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.uo
            public uo d(String str) {
                this.b.hc(str);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.uo
            public uo d(int i, DialogInterface.OnClickListener onClickListener) {
                this.b.b(this.d.getResources().getString(i));
                this.c = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.uo
            public uo hc(int i, DialogInterface.OnClickListener onClickListener) {
                this.b.c(this.d.getResources().getString(i));
                this.u = onClickListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.uo
            public uo d(DialogInterface.OnCancelListener onCancelListener) {
                this.an = onCancelListener;
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.uo
            public uo d(boolean z) {
                this.b.d(z);
                return this;
            }

            @Override // com.ss.android.socialbase.appdownloader.b.uo
            public mq d() {
                this.b.d(new b.hc() { // from class: com.ss.android.downloadlib.b.h.1.1
                    @Override // com.ss.android.d.d.u.b.hc
                    public void d(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.c != null) {
                            AnonymousClass1.this.c.onClick(dialogInterface, -1);
                        }
                    }

                    @Override // com.ss.android.d.d.u.b.hc
                    public void hc(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.u != null) {
                            AnonymousClass1.this.u.onClick(dialogInterface, -2);
                        }
                    }

                    @Override // com.ss.android.d.d.u.b.hc
                    public void b(DialogInterface dialogInterface) {
                        if (AnonymousClass1.this.an == null || dialogInterface == null) {
                            return;
                        }
                        AnonymousClass1.this.an.onCancel(dialogInterface);
                    }
                });
                mk.d(h.d, "getThemedAlertDlgBuilder", null);
                this.b.d(3);
                return new d(com.ss.android.downloadlib.addownload.mq.b().hc(this.b.d()));
            }
        };
    }

    private static class d implements mq {
        private Dialog d;

        public d(Dialog dialog) {
            if (dialog != null) {
                this.d = dialog;
                d();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.mq
        public void d() {
            Dialog dialog = this.d;
            if (dialog != null) {
                dialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.mq
        public boolean hc() {
            Dialog dialog = this.d;
            if (dialog != null) {
                return dialog.isShowing();
            }
            return false;
        }
    }
}
