package com.android.gdt.qone.j;

import android.content.Context;
import android.util.Log;
import com.android.gdt.oaid2.VendorManager;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e implements com.android.gdt.qone.b.a {
    public Context a;
    public VendorManager b;

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = context;
        this.b = vendorManager;
    }

    @Override // com.android.gdt.qone.b.a
    public final void b() {
    }

    @Override // com.android.gdt.qone.b.a
    public final boolean c() {
        return true;
    }

    @Override // com.android.gdt.qone.b.a
    public final void d() {
    }

    @Override // com.android.gdt.qone.b.a
    public final void a() throws Throwable {
        VendorManager vendorManager = this.b;
        if (vendorManager != null) {
            Context context = null;
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null);
                method.setAccessible(true);
                context = (Context) method.invoke(null, null);
            } catch (Exception e) {
                Log.e(com.alipay.sdk.m.i0.b.a, "ActivityThread:currentApplication --> " + e.toString());
            }
            boolean zA = context == null ? false : c.a().a(context, false);
            Context context2 = this.a;
            c cVarA = c.a();
            String strA = cVarA.a(context2.getApplicationContext(), cVarA.c);
            Context context3 = this.a;
            c cVarA2 = c.a();
            vendorManager.callbackOaid(zA, strA, cVarA2.a(context3.getApplicationContext(), cVarA2.b), false);
        }
    }
}
