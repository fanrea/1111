package com.style.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.style.widget.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ab extends BroadcastReceiver {
    public static final String a = "feed_back";
    private a.b b;
    private Context c;

    public void a(Context context, a.b bVar) {
        this.c = context;
        this.b = bVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("reason");
            if (a.equals(action) && this.b != null) {
                if (TextUtils.equals("onShow", stringExtra)) {
                    if (this.b instanceof a.c) {
                        ((a.c) this.b).a();
                        return;
                    }
                    return;
                }
                if (!TextUtils.equals("onDismiss", stringExtra)) {
                    this.b.a(stringExtra);
                }
                if (this.b instanceof a.c) {
                    ((a.c) this.b).b();
                }
                if (this.c != null) {
                    new com.component.c.b(this.c).a(this);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
