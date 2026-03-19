package com.android.gdt.qone.n;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.alipay.sdk.m.p0.c;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b implements com.android.gdt.qone.b.a {
    public a a;
    public VendorManager b;

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = new a(context);
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
    public final void a() throws ClassNotFoundException {
        String str;
        String string;
        VendorManager vendorManager = this.b;
        if (vendorManager != null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, c.c, "unknown");
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            boolean zEquals = "1".equals(str);
            a aVar = this.a;
            aVar.getClass();
            Cursor cursorQuery = aVar.a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
            if (cursorQuery == null) {
                com.android.gdt.qone.af.b.a("return cursor is null,return");
                string = null;
            } else {
                string = cursorQuery.moveToNext() ? cursorQuery.getString(cursorQuery.getColumnIndex(com.alipay.sdk.m.p0.b.d)) : null;
                cursorQuery.close();
            }
            vendorManager.callbackOaid(zEquals, null, string, false);
        }
    }
}
