package com.alliance.ssp.ad.m0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.alliance.ssp.ad.o0.l;

/* compiled from: SDKBroadcastManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public BroadcastReceiver a;
    public boolean b;
    public Context c;

    /* compiled from: SDKBroadcastManager.java */
    /* renamed from: com.alliance.ssp.ad.m0.a$a, reason: collision with other inner class name */
    public class C0093a extends BroadcastReceiver {
        public final /* synthetic */ c a;

        public C0093a(a aVar, c cVar) {
            this.a = cVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                c cVar = this.a;
                if (cVar != null) {
                    cVar.a(intent);
                }
            } catch (Exception unused) {
            }
        }
    }

    public a(c<Intent> cVar, Context context) {
        this.c = context;
        this.a = new C0093a(this, cVar);
    }

    public void a() {
        Context context;
        try {
            if (this.a == null || !this.b || (context = this.c) == null) {
                return;
            }
            context.getApplicationContext().unregisterReceiver(this.a);
            this.b = false;
        } catch (Exception unused) {
            int i = l.a;
        }
    }

    public void b(String... strArr) {
        Context context;
        try {
            if (this.a != null && strArr.length != 0) {
                IntentFilter intentFilter = new IntentFilter();
                for (String str : strArr) {
                    if (a(str)) {
                        intentFilter.addAction(str);
                    }
                }
                if (intentFilter.countActions() <= 0 || (context = this.c) == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    try {
                        this.c.getApplicationContext().registerReceiver(this.a, intentFilter, Context.class.getField("RECEIVER_EXPORTED").getInt(null));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    context.getApplicationContext().registerReceiver(this.a, intentFilter);
                }
                this.b = true;
            }
        } catch (Exception unused) {
            int i = l.a;
        }
    }

    public static void a(final Context context, final String str) {
        if (a(str)) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.alliance.ssp.ad.m0.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(str, context);
                }
            });
        }
    }

    public static /* synthetic */ void a(String str, Context context) {
        try {
            context.getApplicationContext().sendBroadcast(new Intent(str));
        } catch (Exception unused) {
            int i = l.a;
        }
    }

    public static boolean a(String... strArr) {
        try {
            for (String str : strArr) {
                if (str == null || str.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            int i = l.a;
            return false;
        }
    }
}
