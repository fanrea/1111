package ca.da.ca.ab;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.apm.applog.AppLog;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.util.HashMap;

/* compiled from: UserProfileReporter.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e implements Runnable {
    public static final Handler f = new Handler(Looper.getMainLooper());
    public String a;
    public String b;
    public String c;
    public final a d;
    public Context e;

    public e(String str, String str2, String str3, a aVar, Context context) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = aVar;
        this.e = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!NetworkUtils.isNetworkAvailable(this.e)) {
                f.post(new c(this, 0));
                return;
            }
            HashMap map = new HashMap();
            map.put("Content-Type", "application/json");
            map.put("X-APIKEY", this.b);
            AppLog.getNetClient().post(this.a, this.c.getBytes(), map);
            f.post(new d(this));
        } catch (Throwable th) {
            th.printStackTrace();
            f.post(new c(this, 1));
        }
    }
}
