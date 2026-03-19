package ca.da.da.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: IDidAidlInterface.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface c extends IInterface {

    /* compiled from: IDidAidlInterface.java */
    public static abstract class a extends Binder implements c {

        /* compiled from: IDidAidlInterface.java */
        /* renamed from: ca.da.da.ca.c$a$a, reason: collision with other inner class name */
        public static class C0035a implements c {
            public IBinder a;

            public C0035a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof c)) ? new C0035a(iBinder) : (c) iInterfaceQueryLocalInterface;
        }
    }
}
