package com.qq.e.comm.plugin;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class at {
    private Activity a;
    private String b;
    private rs c;
    private AlertDialog d;
    private boolean e = false;

    private void b() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.a, Build.VERSION.SDK_INT >= 21 ? R.style.Theme.Material.Light.Dialog.Alert : 0);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.b) ? "APP" : this.b;
        builder.setMessage(String.format("前往“%s”了解更多", objArr)).setCancelable(false).setPositiveButton("前往", new c()).setNegativeButton("取消", new b()).setOnCancelListener(new a());
        AlertDialog alertDialogCreate = builder.create();
        this.d = alertDialogCreate;
        alertDialogCreate.setOnDismissListener(new d());
        this.d.setOnShowListener(new e());
    }

    public void c() {
        xo.a((Runnable) new f());
    }

    public at(Activity activity, String str, rs rsVar) {
        this.a = activity;
        this.b = str;
        this.c = rsVar;
        b();
    }

    /* compiled from: A */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            at.this.e = true;
            at.this.c.a((JSONObject) null);
        }
    }

    /* compiled from: A */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            at.this.e = true;
            at.this.c.onCancel();
        }
    }

    /* compiled from: A */
    class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            at.this.e = true;
            at.this.c.onCancel();
        }
    }

    /* compiled from: A */
    class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            at.this.c.b(at.this.e);
        }
    }

    /* compiled from: A */
    class e implements DialogInterface.OnShowListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            at.this.c.a(true);
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                at.this.a();
                if (at.this.d == null || at.this.a.isFinishing()) {
                    return;
                }
                at.this.d.show();
            } catch (Exception unused) {
            }
        }
    }

    public void a() {
        AlertDialog alertDialog = this.d;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.d.dismiss();
    }
}
