package ca.fa.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: IOpenID.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface a extends IInterface {

    /* compiled from: IOpenID.java */
    /* renamed from: ca.fa.ca.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0039a extends Binder implements a {

        /* compiled from: IOpenID.java */
        /* renamed from: ca.fa.ca.a$a$a, reason: collision with other inner class name */
        public static class C0040a implements a {
            public IBinder a;

            public C0040a(IBinder iBinder) {
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
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof a)) ? new C0040a(iBinder) : (a) iInterfaceQueryLocalInterface;
        }
    }
}
