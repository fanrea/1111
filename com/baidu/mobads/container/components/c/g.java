package com.baidu.mobads.container.components.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mobads.container.components.c.a;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.util.bd;
import com.baidu.mobads.container.util.bl;
import com.baidu.mobads.container.util.bq;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class g {
    public static final String a = "XAdInstallController";
    private static g b;
    private b d;
    private a e;
    private final ConcurrentHashMap<String, com.baidu.mobads.container.components.c.a> c = new ConcurrentHashMap<>();
    private final bq f = bq.a();

    public static g a() {
        if (b == null) {
            synchronized (g.class) {
                if (b == null) {
                    b = new g();
                }
            }
        }
        return b;
    }

    private g() {
    }

    public void a(Context context, j jVar) {
        if (context != null && jVar != null) {
            String str = jVar.Z;
            if (!TextUtils.isEmpty(str)) {
                com.baidu.mobads.container.components.c.a aVar = this.c.get(str);
                if (aVar != null) {
                    aVar.a(jVar);
                } else {
                    aVar = new com.baidu.mobads.container.components.c.a(jVar);
                    this.c.put(str, aVar);
                }
                a(context, aVar);
            }
        }
    }

    public void a(String str, a.InterfaceC0121a interfaceC0121a) {
        com.baidu.mobads.container.components.c.a aVar;
        if (!TextUtils.isEmpty(str) && this.c.containsKey(str) && (aVar = this.c.get(str)) != null) {
            aVar.a(interfaceC0121a);
        }
    }

    private void a(Context context, com.baidu.mobads.container.components.c.a aVar) {
        if (context != null && aVar != null) {
            Context applicationContext = context.getApplicationContext();
            if (aVar.a() < 0) {
                try {
                    if (bl.a(bl.f) && com.baidu.mobads.container.h.a.a().B()) {
                        if (this.e == null) {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                            intentFilter.addDataScheme("package");
                            this.e = new a();
                            new com.component.c.b(applicationContext).a(this.e, intentFilter);
                        }
                    } else {
                        if (this.d == null) {
                            this.d = new b(context, this.c);
                        }
                        this.d.c();
                    }
                    aVar.a(0);
                } catch (Exception e) {
                    this.f.c(a, "Install controller start failed.");
                }
            }
        }
    }

    public void a(Context context, String str) {
        if (context != null) {
            try {
                this.c.remove(str);
            } catch (Exception e) {
                this.f.a(a, "Install controller stop failed.");
            }
        }
    }

    public void a(Context context, Intent intent) {
        com.baidu.mobads.container.components.c.a aVar;
        try {
            String action = intent.getAction();
            String string = "";
            if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                String dataString = intent.getDataString();
                if (dataString != null && dataString.length() > 0) {
                    string = dataString.replace("package:", "");
                }
            } else {
                if (bd.a.equals(action) || bd.b.equals(action)) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        string = extras.getString("packageName");
                    }
                }
                if (TextUtils.isEmpty(string) && (aVar = this.c.get(string)) != null) {
                    aVar.a(context, action, string, intent);
                    return;
                }
            }
            if (TextUtils.isEmpty(string)) {
            }
        } catch (Throwable th) {
            this.f.a(a, th);
        }
    }

    public boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.c.containsKey(str);
        } catch (Throwable th) {
            return false;
        }
    }

    private static class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            g.a().a(context, intent);
        }
    }

    private static class b extends com.baidu.mobads.container.d.a<Void> {
        private final Context a;
        private final ConcurrentHashMap<String, com.baidu.mobads.container.components.c.a> b;
        private final AtomicBoolean c = new AtomicBoolean(false);

        public b(Context context, ConcurrentHashMap<String, com.baidu.mobads.container.components.c.a> concurrentHashMap) {
            this.a = context.getApplicationContext();
            this.b = concurrentHashMap;
        }

        public void c() {
            if (this.c.compareAndSet(false, true)) {
                com.baidu.mobads.container.d.b.a().a(this, 0L, 1L, TimeUnit.SECONDS);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.mobads.container.d.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void a() {
            if (this.b.size() > 0) {
                try {
                    for (String str : this.b.keySet()) {
                        com.baidu.mobads.container.components.c.a aVar = this.b.get(str);
                        if (aVar != null && !aVar.b()) {
                            if (com.baidu.mobads.container.util.j.b(this.a, str)) {
                                Intent intent = new Intent();
                                intent.setAction("android.intent.action.PACKAGE_ADDED");
                                intent.setData(Uri.parse("package:" + str));
                                intent.putExtra("fromTask", true);
                                g.a().a(this.a, intent);
                            }
                        } else {
                            g.a().a(this.a, str);
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    bq.a().a(th);
                    return null;
                }
            }
            a_();
            this.c.set(false);
            return null;
        }
    }
}
