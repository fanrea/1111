package ca.da.da;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: OpenDeviceIdentifierService.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public interface s extends IInterface {

    /* compiled from: OpenDeviceIdentifierService.java */
    public static abstract class a extends Binder implements s {

        /* compiled from: OpenDeviceIdentifierService.java */
        /* renamed from: ca.da.da.s$a$a, reason: collision with other inner class name */
        public static class C0036a implements s {
            public IBinder a;

            public C0036a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static s a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(com.alipay.sdk.m.c.b.a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof s)) ? new C0036a(iBinder) : (s) iInterfaceQueryLocalInterface;
        }
    }
}
