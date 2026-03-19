package ca.da.da.ca;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.alipay.sdk.m.q0.a;

/* compiled from: IDeviceidInterface.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface b extends IInterface {

    /* compiled from: IDeviceidInterface.java */
    public static abstract class a extends Binder implements b {

        /* compiled from: IDeviceidInterface.java */
        /* renamed from: ca.da.da.ca.b$a$a, reason: collision with other inner class name */
        public static class C0034a implements b {
            public IBinder a;

            public C0034a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(a.AbstractBinderC0056a.a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof b)) ? new C0034a(iBinder) : (b) iInterfaceQueryLocalInterface;
        }
    }
}
