package lk.repeackage.honor.identifier;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import java.util.concurrent.CountDownLatch;
import lk.repeackage.a;
import lk.repeackage.b;
import lk.repeackage.honor.identifier.AdvertisingIdClient;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a implements ServiceConnection {
    public AdvertisingIdClient.Info a;
    public Context b;
    public final BinderC0840a c = new BinderC0840a();
    public final b d = new b();
    public final CountDownLatch e = new CountDownLatch(2);

    /* renamed from: lk.repeackage.honor.identifier.a$a, reason: collision with other inner class name */
    public class BinderC0840a extends a.AbstractBinderC0838a {
        public BinderC0840a() {
        }

        @Override // lk.repeackage.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // lk.repeackage.a
        public void a(int i, Bundle bundle) {
            AdvertisingIdClient.Info info;
            Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode = " + i + " retInfo = " + bundle);
            if (i == 0 && (info = a.this.a) != null) {
                info.id = bundle.getString("oa_id_flag");
                Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult success");
            }
            a.this.e.countDown();
        }
    }

    public class b extends a.AbstractBinderC0838a {
        public b() {
        }

        @Override // lk.repeackage.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // lk.repeackage.a
        public void a(int i, Bundle bundle) {
            Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult retCode=" + i + " retInfo= " + bundle);
            if (i == 0 && a.this.a != null) {
                boolean z = bundle.getBoolean("oa_id_limit_state");
                a.this.a.isLimit = z;
                Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult success  isLimit=" + z);
            }
            a.this.e.countDown();
        }
    }

    public final void a() {
        Log.i("AdvertisingIdPlatform", "disconnect");
        try {
            this.b.unbindService(this);
        } catch (Exception e) {
            Log.e("AdvertisingIdPlatform", "OAIDClientImpl#disconnect#Disconnect error::" + e.getMessage());
        }
    }

    public boolean a(Context context) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo("com.hihonor.id", 0);
            new Intent("com.hihonor.id.HnOaIdService").setPackage("com.hihonor.id");
            return !r5.queryIntentServices(r2, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        lk.repeackage.b c0839a;
        Log.i("AdvertisingIdPlatform", "onServiceConnected ");
        try {
            this.a = new AdvertisingIdClient.Info();
            int i = b.a.a;
            if (iBinder == null) {
                c0839a = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                c0839a = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof lk.repeackage.b)) ? new b.a.C0839a(iBinder) : (lk.repeackage.b) iInterfaceQueryLocalInterface;
            }
            c0839a.b(this.c);
            c0839a.a(this.d);
        } catch (Exception e) {
            Log.e("AdvertisingIdPlatform", "onServiceConnected error:" + e.getMessage());
            this.e.countDown();
            this.e.countDown();
            a();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.i("AdvertisingIdPlatform", "onServiceDisconnected ");
        this.e.countDown();
        this.e.countDown();
    }
}
