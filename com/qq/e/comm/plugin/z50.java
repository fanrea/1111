package com.qq.e.comm.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class z50 extends BroadcastReceiver {
    private static volatile z50 c;
    private final ConcurrentHashMap<String, a> a;
    private AtomicBoolean b = new AtomicBoolean(false);

    /* compiled from: A */
    public interface a {
        void a(int i);

        void b(int i);
    }

    private z50() {
        if (r1.d().f().a("rxmbr", 1) == 1) {
            this.a = new ConcurrentHashMap<>();
        } else {
            this.a = null;
        }
    }

    public void a(String str, a aVar) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        b();
        this.a.put(str, aVar);
    }

    private void b() {
        if (this.b.compareAndSet(false, true)) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(com.baidu.mobads.container.util.bd.a);
                intentFilter.addAction(com.baidu.mobads.container.util.bd.b);
                r1.d().a().registerReceiver(this, intentFilter);
            } catch (Throwable unused) {
                this.b.compareAndSet(true, false);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        a aVar;
        if (this.a == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("packageName");
        if (TextUtils.isEmpty(string) || (aVar = this.a.get(string)) == null) {
            return;
        }
        String action = intent.getAction();
        if (com.baidu.mobads.container.util.bd.a.equals(action)) {
            aVar.b(extras.getInt("styleCheckResult"));
        } else if (com.baidu.mobads.container.util.bd.b.equals(action)) {
            aVar.a(extras.getInt("statusCode"));
        }
    }

    public void a(String str) {
        if (this.a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.a.remove(str);
    }

    public static z50 a() {
        if (c != null) {
            return c;
        }
        synchronized (z50.class) {
            if (c == null) {
                c = new z50();
            }
        }
        return c;
    }
}
