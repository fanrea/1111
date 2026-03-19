package com.qq.e.comm.plugin.apkmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.comm.plugin.g10;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.xo;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class j extends BroadcastReceiver {
    private static final String b;
    private static final String c;
    private static int d = 4;
    private final g10 a;

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ Intent b;

        a(Context context, Intent intent) {
            this.a = context;
            this.b = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.sendBroadcast(this.b);
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    static {
        String packageName = r1.d().a().getPackageName();
        b = packageName + ".gdtdownload";
        c = packageName + ".gdtservicecreate";
    }

    static void b(Context context) {
        Intent intent = new Intent(c);
        intent.setPackage(context.getPackageName());
        a(context, intent);
    }

    j a(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(b);
        intentFilter.addAction(c);
        if (Build.VERSION.SDK_INT >= 34) {
            context.registerReceiver(this, intentFilter, d);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        return this;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (TextUtils.equals(intent.getAction(), c)) {
            l.e().a();
            return;
        }
        try {
            this.a.a(intent.getStringExtra("package"), intent.getIntExtra("status", 0), intent.getIntExtra("progress", 0), intent.getLongExtra("totalSize", 0L));
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, Intent intent) {
        xo.d(new a(context, intent));
    }

    public static void a(String str, int i, int i2, long j) {
        Intent intent = new Intent(b);
        Context contextA = r1.d().a();
        intent.putExtra("package", str);
        intent.putExtra("status", i);
        intent.putExtra("progress", i2);
        intent.putExtra("totalSize", j);
        intent.setPackage(contextA.getPackageName());
        intent.toString();
        a(contextA, intent);
    }

    j(g10 g10Var) {
        this.a = g10Var;
    }
}
