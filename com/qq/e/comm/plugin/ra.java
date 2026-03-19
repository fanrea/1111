package com.qq.e.comm.plugin;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.qq.e.comm.pi.ACTD;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ra implements ACTD, DialogInterface.OnClickListener {
    private static SparseArray<b> c = new SparseArray<>();
    private final Activity a;
    private b b;

    /* compiled from: A */
    public interface b {
        void a();

        void b();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    public ra(Activity activity) {
        this.a = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.a.getIntent().getStringExtra("tip_key");
        String stringExtra2 = this.a.getIntent().getStringExtra("positive_text_id_key");
        if (TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = "打开";
        }
        String stringExtra3 = this.a.getIntent().getStringExtra("negative_text_id_key");
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = "取消";
        }
        int intExtra = this.a.getIntent().getIntExtra("callback_id_key", -1);
        if (intExtra != -1 && !TextUtils.isEmpty(stringExtra)) {
            b bVar = c.get(intExtra);
            this.b = bVar;
            if (bVar == null) {
                this.a.finish();
                return;
            }
            int i = Build.VERSION.SDK_INT;
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a, i >= 21 ? R.style.Theme.Material.Light.Dialog.Alert : 0);
            builder.setMessage(stringExtra).setCancelable(false).setPositiveButton(stringExtra2, this).setNegativeButton(stringExtra3, this);
            if (i >= 17) {
                builder.setOnDismissListener(new a());
            }
            try {
                builder.create().show();
                return;
            } catch (Exception unused) {
                this.a.finish();
                return;
            }
        }
        this.a.finish();
    }

    /* compiled from: A */
    class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ra.this.a();
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        a();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        b bVar = this.b;
        if (bVar != null) {
            if (i == -1) {
                bVar.a();
            } else if (i == -2) {
                bVar.b();
            }
        }
        try {
            dialogInterface.dismiss();
        } catch (Throwable unused) {
        }
        a();
        this.a.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        b bVar = this.b;
        if (bVar != null) {
            c.remove(bVar.hashCode());
            this.b = null;
        }
    }

    public static void a(String str, b bVar) {
        a(str, null, null, bVar);
    }

    public static void a(String str, String str2, String str3, b bVar) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            Context contextA = r1.d().a();
            Intent intent = new Intent();
            intent.setClassName(contextA, "com.qq.e.ads.DialogActivity");
            intent.putExtra(ACTD.DELEGATE_NAME_KEY, wm.DIALOG_ACTIVITY);
            intent.putExtra("appid", r1.d().b().a());
            intent.putExtra("tip_key", str);
            intent.putExtra("positive_text_id_key", str2);
            intent.putExtra("negative_text_id_key", str3);
            int iHashCode = bVar.hashCode();
            intent.putExtra("callback_id_key", iHashCode);
            intent.setFlags(268435456);
            contextA.startActivity(intent);
            c.put(iHashCode, bVar);
            return;
        }
        qm$h$$ExternalSyntheticBackport0.m(bVar);
    }
}
