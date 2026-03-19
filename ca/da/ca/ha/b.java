package ca.da.ca.ha;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.Logger;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NewUserModeUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class b {
    public static Account a;

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r4) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r1 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r1)
            r1 = 0
            boolean r2 = com.apm.applog.AppLog.getEncryptAndCompress()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = "UTF-8"
            if (r2 == 0) goto L21
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L2e
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L1e
            r2.write(r4)     // Catch: java.lang.Throwable -> L1e
            r1 = r2
            goto L28
        L1e:
            r4 = move-exception
            r1 = r2
            goto L2f
        L21:
            byte[] r4 = r4.getBytes(r3)     // Catch: java.lang.Throwable -> L2e
            r0.write(r4)     // Catch: java.lang.Throwable -> L2e
        L28:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L2e:
            r4 = move-exception
        L2f:
            ca.da.ca.ja.r.a(r4)     // Catch: java.lang.Throwable -> L4c
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r4 = move-exception
            ca.da.ca.ja.r.a(r4)
        L3c:
            byte[] r4 = r0.toByteArray()
            boolean r0 = com.apm.applog.AppLog.getEncryptAndCompress()
            if (r0 == 0) goto L4b
            int r0 = r4.length
            byte[] r4 = com.bytedance.applog.encryptor.EncryptorUtil.encrypt(r4, r0)
        L4b:
            return r4
        L4c:
            r4 = move-exception
            if (r1 == 0) goto L57
            r1.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r0 = move-exception
            ca.da.ca.ja.r.a(r0)
        L57:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.ha.b.a(java.lang.String):byte[]");
    }

    public static Account a(Context context) {
        String packageName;
        String string;
        Account account = a;
        if (account != null) {
            return account;
        }
        AccountManager accountManager = AccountManager.get(context);
        try {
            packageName = context.getPackageName();
        } catch (Throwable th) {
            th = th;
            packageName = null;
        }
        try {
            string = context.getString(context.getApplicationInfo().labelRes);
        } catch (Throwable th2) {
            th = th2;
            Logger.d("NewUserModeUtil", "getAccount:" + th);
            string = null;
            if (TextUtils.isEmpty(string)) {
            }
            return null;
        }
        if (!TextUtils.isEmpty(string) || TextUtils.isEmpty(packageName)) {
            return null;
        }
        Account[] accountsByType = accountManager.getAccountsByType(packageName);
        int length = accountsByType.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Account account2 = accountsByType[i];
            if (account2 != null && string.equals(account2.name)) {
                a = account2;
                break;
            }
            i++;
        }
        return a;
    }

    public static boolean a(JSONObject jSONObject, Class<?>[] clsArr, Class<?>[] clsArr2) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            Object obj = jSONObject.get(itKeys.next());
            if (obj == null) {
                return false;
            }
            if (obj instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) obj;
                for (int i = 0; i < jSONArray.length(); i++) {
                    Object obj2 = jSONArray.get(i);
                    if (clsArr2 != null && !a(clsArr2, obj2.getClass())) {
                        return false;
                    }
                }
            } else if (clsArr != null && !a(clsArr, obj.getClass())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean a(T[] tArr, T t) {
        for (T t2 : tArr) {
            if (t2 == t) {
                return true;
            }
        }
        return false;
    }
}
