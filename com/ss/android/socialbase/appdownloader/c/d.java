package com.ss.android.socialbase.appdownloader.c;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.ss.android.socialbase.appdownloader.b.mq;
import com.ss.android.socialbase.appdownloader.b.uo;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends com.ss.android.socialbase.appdownloader.b.hc {
    private AlertDialog.Builder d;

    public d(Context context) {
        this.d = new AlertDialog.Builder(context);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.uo
    public uo d(int i) {
        AlertDialog.Builder builder = this.d;
        if (builder != null) {
            builder.setTitle(i);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.uo
    public uo d(String str) {
        AlertDialog.Builder builder = this.d;
        if (builder != null) {
            builder.setMessage(str);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.uo
    public uo d(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.d;
        if (builder != null) {
            builder.setPositiveButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.uo
    public uo hc(int i, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = this.d;
        if (builder != null) {
            builder.setNegativeButton(i, onClickListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.uo
    public uo d(DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = this.d;
        if (builder != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        return this;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.uo
    public mq d() {
        return new C0765d(this.d);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.c.d$d, reason: collision with other inner class name */
    private static class C0765d implements mq {
        private AlertDialog d;

        public C0765d(AlertDialog.Builder builder) {
            if (builder != null) {
                this.d = builder.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.mq
        public void d() {
            AlertDialog alertDialog = this.d;
            if (alertDialog != null) {
                alertDialog.show();
            }
        }

        @Override // com.ss.android.socialbase.appdownloader.b.mq
        public boolean hc() {
            AlertDialog alertDialog = this.d;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }
    }
}
