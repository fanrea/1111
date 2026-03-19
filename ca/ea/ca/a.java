package ca.ea.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: MsaIdInterface.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: MsaIdInterface.java */
    /* renamed from: ca.ea.ca.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0037a extends Binder implements a {

        /* compiled from: MsaIdInterface.java */
        /* renamed from: ca.ea.ca.a$a$a, reason: collision with other inner class name */
        public static class C0038a implements a {
            public IBinder a;

            public C0038a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0038a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
