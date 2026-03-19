package lk.repeackage.honor.identifier;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class AdvertisingIdClient {

    public static final class Info {
        public String id;
        public boolean isLimit;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException {
        Info info;
        String string;
        String string2;
        a aVar = new a();
        aVar.b = context;
        try {
            Log.i("AdvertisingIdPlatform", "1.0.18.300 getCache start");
            string = Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state");
            string2 = Settings.Secure.getString(context.getContentResolver(), "oaid");
        } catch (Throwable th) {
            Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo cache error=" + th);
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            info = null;
        } else {
            boolean z = Boolean.parseBoolean(string);
            info = new Info();
            info.isLimit = z;
            info.id = string2;
            Log.i("AdvertisingIdPlatform", "getAdvertisingIdInfo success");
        }
        if (info != null) {
            return info;
        }
        try {
            if (!aVar.a(context)) {
                throw new IOException("Service not found or advertisingId not available");
            }
            try {
                Log.i("AdvertisingIdPlatform", "bindService start");
                Intent intent = new Intent();
                intent.setAction("com.hihonor.id.HnOaIdService");
                intent.setPackage("com.hihonor.id");
                context.bindService(intent, aVar, 1);
                aVar.e.await(1000L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                Log.e("AdvertisingIdPlatform", "getAdvertisingIdInfo error=" + e.getMessage());
            }
            aVar.a();
            return aVar.a;
        } catch (Throwable th2) {
            aVar.a();
            throw th2;
        }
    }

    public static boolean isAdvertisingIdAvailable(Context context) {
        return new a().a(context);
    }
}
