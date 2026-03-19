package com.ss.android.downloadlib.d.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.container.adrequest.g;
import com.kuaishou.weapon.p0.t;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.d.d.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d {
    private static String an = "";
    private static String c = "";
    private static volatile d h = null;
    private static String u = "";
    public b d;
    private Context mk;
    private boolean gb = true;
    private boolean tt = false;
    private volatile boolean tc = false;
    private final List<Pair<hc, c>> mq = new ArrayList();
    public final List<Object> hc = new ArrayList();
    private final ServiceConnection uo = new ServiceConnection() { // from class: com.ss.android.downloadlib.d.d.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (d.this.b) {
                d.this.d(false);
                d.this.d = b.d.d(iBinder);
                d.this.b();
                Iterator<Object> it = d.this.hc.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (d.this.b) {
                d.this.d(false);
                d.this.d = null;
                Iterator<Object> it = d.this.hc.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    };
    private String k = "";
    public final Object b = new Object();

    private d() {
    }

    public static d d() {
        if (h == null) {
            synchronized (d.class) {
                if (h == null) {
                    h = new d();
                }
            }
        }
        return h;
    }

    public boolean d(Context context, boolean z) {
        if (TextUtils.isEmpty(c)) {
            JSONObject jSONObjectTt = mq.tt();
            String strOptString = jSONObjectTt.optString("s");
            c = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString(g.q), strOptString);
            u = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString(t.i), strOptString);
            an = com.ss.android.socialbase.appdownloader.an.b.d(jSONObjectTt.optString("w"), strOptString);
        }
        this.tt = z;
        if (context == null) {
            return true;
        }
        this.mk = context.getApplicationContext();
        if (TextUtils.isEmpty(an)) {
            an = this.mk.getPackageName();
        }
        if (this.d != null || c()) {
            return true;
        }
        return this.mk.bindService(d(context), this.uo, 33);
    }

    public void hc() {
        if (this.d != null) {
            this.mk.unbindService(this.uo);
            this.d = null;
        }
        this.hc.clear();
        this.mq.clear();
    }

    public Intent d(Context context) {
        Intent intent = new Intent();
        intent.setAction(c);
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            String str = resolveInfo.serviceInfo.packageName;
            String str2 = resolveInfo.serviceInfo.name;
            if (u.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void d(hc hcVar, c cVar) {
        synchronized (this.b) {
            hcVar.u = an;
            if (TextUtils.isEmpty(hcVar.an)) {
                hcVar.an = this.k;
            }
            b bVar = this.d;
            if (bVar != null) {
                try {
                    bVar.d(hcVar, cVar);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.mq.d(e);
                }
            } else if (c() || d(this.mk, this.tt)) {
                this.mq.add(Pair.create(hcVar, cVar));
            }
        }
    }

    public void b() {
        for (Pair<hc, c> pair : this.mq) {
            try {
                this.d.d((hc) pair.first, (c) pair.second);
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
        }
        this.mq.clear();
    }

    public boolean c() {
        return this.tc;
    }

    public void d(boolean z) {
        this.tc = z;
    }
}
