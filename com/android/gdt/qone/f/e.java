package com.android.gdt.qone.f;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.android.gdt.oaid2.VendorManager;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class e implements com.android.gdt.qone.b.a, IInterface {
    public VendorManager a;
    public g d;
    public String b = "";
    public String c = "";
    public boolean e = false;
    public boolean f = false;
    public final d g = new d(this);

    @Override // com.android.gdt.qone.b.a
    public final void a() {
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    @Override // com.android.gdt.qone.b.a
    public final void b() {
        com.android.gdt.qone.c.e.c.a(this.g);
    }

    @Override // com.android.gdt.qone.b.a
    public final boolean c() {
        return false;
    }

    @Override // com.android.gdt.qone.b.a
    public final void d() {
        g gVar;
        if (!this.e || (gVar = this.d) == null) {
            return;
        }
        try {
            if (!gVar.a || gVar.b == null) {
                return;
            }
            com.android.gdt.qone.af.b.c("HSDID start to unbind did service");
            gVar.a = false;
            gVar.b.unbindService(gVar.e);
        } catch (Exception e) {
            com.android.gdt.qone.af.b.a("HSDID error:" + e.getMessage());
        }
    }

    @Override // com.android.gdt.qone.b.a
    public final void a(Context context, VendorManager vendorManager) {
        this.a = vendorManager;
        this.d = new g(context);
    }

    public final void a(c cVar) {
        String string;
        String string2;
        try {
            a aVar = (a) cVar;
            aVar.getClass();
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                aVar.a.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string2 = parcelObtain2.readString();
                parcelObtain2.recycle();
            } catch (Throwable unused) {
                parcelObtain2.recycle();
                string2 = "";
            }
            parcelObtain.recycle();
            this.b = string2;
            if (string2 == null) {
                this.b = "";
            }
        } catch (Exception unused2) {
        }
        try {
            a aVar2 = (a) cVar;
            aVar2.getClass();
            Parcel parcelObtain3 = Parcel.obtain();
            Parcel parcelObtain4 = Parcel.obtain();
            try {
                parcelObtain3.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                aVar2.a.transact(5, parcelObtain3, parcelObtain4, 0);
                parcelObtain4.readException();
                string = parcelObtain4.readString();
                parcelObtain4.recycle();
            } catch (Throwable unused3) {
                parcelObtain4.recycle();
                string = "";
            }
            parcelObtain3.recycle();
            this.c = string;
            if (string == null) {
                this.c = "";
            }
        } catch (Exception unused4) {
        }
        try {
            this.f = ((a) cVar).a();
        } catch (Exception unused5) {
        }
        this.e = true;
        VendorManager vendorManager = this.a;
        if (vendorManager != null) {
            vendorManager.callbackOaid(this.f, this.c, this.b, false);
        }
    }
}
