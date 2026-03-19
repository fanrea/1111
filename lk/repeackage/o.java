package lk.repeackage;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.lk.oaid.ErrorCode;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class o implements d {
    public final Context a;
    public String b;
    public String c;

    public static final class a {
        public final String a;

        public a(String str, boolean z) {
            this.a = str;
        }
    }

    public o(Context context) {
        this.a = context;
    }

    @Override // lk.repeackage.d
    public void a(c cVar) {
        a aVar;
        if (cVar == null) {
            return;
        }
        Context context = this.a;
        if (context == null) {
            cVar.onOAIDGetError(ErrorCode.STATE_CALL_PARAM, new e("context is null !!!"));
            return;
        }
        Uri uri = z.a;
        if (!z.a(context, uri)) {
            cVar.a("get by aidl");
            f.a("requestAdvertisingIdInfo via aidl");
            if (!a()) {
                cVar.a(" not support ! reason:" + this.c);
                cVar.onOAIDGetError(ErrorCode.STATE_DEVICE_NOSUPPORT, new e("Huawei OAID not available"));
                return;
            } else {
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage(this.b);
                t.a(this.a, intent, cVar, new n(this));
                return;
            }
        }
        cVar.a("get by provider");
        f.a("requestAdvertisingIdInfo via provider");
        Context context2 = this.a;
        if (context2 == null || !z.a(context2, uri)) {
            aVar = new a("00000000-0000-0000-0000-000000000000", true);
        } else {
            try {
                Cursor cursorQuery = context2.getContentResolver().query(uri, null, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    aVar = new a("00000000-0000-0000-0000-000000000000", true);
                } else {
                    int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("oaid");
                    int columnIndexOrThrow2 = cursorQuery.getColumnIndexOrThrow("limit_track");
                    String string = cursorQuery.getString(columnIndexOrThrow);
                    aVar = new a(string, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(string) ? true : Boolean.valueOf(cursorQuery.getString(columnIndexOrThrow2)).booleanValue());
                }
                a0.a(cursorQuery);
            } catch (Throwable th) {
                try {
                    Log.w("InfoProviderUtil", "query oaid via provider ex: " + th.getClass().getSimpleName());
                    a0.a(null);
                    aVar = new a("00000000-0000-0000-0000-000000000000", true);
                } catch (Throwable th2) {
                    a0.a(null);
                    throw th2;
                }
            }
        }
        f.a("getoaid:" + aVar.a);
        cVar.onOAIDGetComplete(aVar.a);
    }

    @Override // lk.repeackage.d
    public boolean a() throws PackageManager.NameNotFoundException {
        StringBuilder sbAppend;
        String str;
        Context context = this.a;
        if (context == null) {
            this.c = "context is null";
            return false;
        }
        this.b = g.c(context);
        try {
            PackageManager packageManager = this.a.getPackageManager();
            packageManager.getPackageInfo(this.b, 128);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(this.b);
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && !listQueryIntentServices.isEmpty()) {
                return true;
            }
            this.c = "packageName:" + this.b + " queryIntentServices null";
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            sbAppend = new StringBuilder().append("packageName:").append(this.b);
            str = " not found exception";
            this.c = sbAppend.append(str).toString();
            return false;
        } catch (Exception unused2) {
            sbAppend = new StringBuilder().append("packageName:").append(this.b);
            str = " occur exception";
            this.c = sbAppend.append(str).toString();
            return false;
        }
    }
}
