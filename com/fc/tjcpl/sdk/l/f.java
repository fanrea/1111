package com.fc.tjcpl.sdk.l;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Field;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f {
    public static f c = null;
    public static Field d = null;
    public static Field e = null;
    public static boolean f = false;
    public c a;
    public Context b = com.fc.tjcpl.sdk.b.a.b();

    public static class a extends Handler {
        public Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler handler = this.a;
            if (handler != null) {
                handler.handleMessage(message);
            }
        }
    }

    public static f a() {
        if (c == null) {
            c = new f();
        }
        return c;
    }

    public void a(String str, int i) {
        if (this.a == null) {
            this.a = new c(this.b);
        }
        this.a.setDuration(i);
        c cVar = this.a;
        int iA = com.fc.tjcpl.sdk.b.a.a(this.b, "layout", "tj_view_toast");
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(cVar.a).inflate(iA, (ViewGroup) null, false);
        cVar.setView(relativeLayout);
        if (relativeLayout != null && iA == com.fc.tjcpl.sdk.b.a.a(cVar.a, "layout", "tj_view_toast")) {
            ((TextView) relativeLayout.findViewById(com.fc.tjcpl.sdk.b.a.a(cVar.a, "id", "tj_toast_text"))).setText(Html.fromHtml(str));
        }
        c cVar2 = this.a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 25 || i2 == 24) {
            try {
                if (!f) {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    d = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = d.getType().getDeclaredField("mHandler");
                    e = declaredField2;
                    declaredField2.setAccessible(true);
                    f = true;
                }
                Object obj = d.get(cVar2);
                e.set(obj, new a((Handler) e.get(obj)));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.a.show();
    }
}
