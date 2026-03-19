package ca.da.ca.ja;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* compiled from: GaidGetter.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class j {
    public static volatile String a;

    public static String a(Context context, ca.da.ca.fa.g gVar) {
        AdvertisingIdClient.Info advertisingIdInfo;
        if (TextUtils.isEmpty(a)) {
            synchronized (j.class) {
                if (!TextUtils.isEmpty(a)) {
                    return a;
                }
                try {
                    advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
                } catch (Throwable th) {
                    if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                        th.printStackTrace();
                    }
                }
                String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                if (TextUtils.isEmpty(id)) {
                    id = gVar.e.getString("google_aid", null);
                } else if (!TextUtils.equals(gVar.e.getString("google_aid", null), id) && !TextUtils.isEmpty(id)) {
                    gVar.e.edit().putString("google_aid", id).apply();
                }
                a = id;
            }
        }
        return a;
    }
}
