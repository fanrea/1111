package com.qq.e.comm.plugin;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class n20 {
    private static Toast c(String str) {
        Context contextA = r1.d().a();
        TextView textView = new TextView(contextA);
        textView.setText(str);
        textView.setPadding(yu.a(contextA, 20), yu.a(contextA, 12), yu.a(contextA, 20), yu.a(contextA, 12));
        textView.setTextColor(-1);
        textView.setTextSize(2, 16.0f);
        textView.setBackgroundDrawable(gx.a(60.0f, -16777216, 100));
        Toast toast = new Toast(contextA);
        toast.setGravity(17, 0, 0);
        toast.setView(textView);
        return toast;
    }

    public static void f(String str) {
        xo.d(new b(str));
    }

    public static void g(String str) {
        xo.d(new a(str));
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n20.e(this.a);
            } catch (Throwable unused) {
            }
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                n20.d(this.a);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        Toast toastC = c(str);
        toastC.setDuration(1);
        toastC.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str) {
        Toast toastC = c(str);
        toastC.setDuration(0);
        toastC.show();
    }
}
