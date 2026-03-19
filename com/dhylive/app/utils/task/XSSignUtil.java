package com.dhylive.app.utils.task;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.t.a;
import com.baidu.mobads.container.adrequest.g;
import com.baidu.mobads.upgrade.remote.gray.c;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: XSSignUtil.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002¨\u0006\r"}, d2 = {"Lcom/dhylive/app/utils/task/XSSignUtil;", "", "()V", "buildUrl", "", "context", "Landroid/content/Context;", "mtUserId", "oaid", "mtId", "mtKey", "encryptMD5", "data", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class XSSignUtil {
    public static final XSSignUtil INSTANCE = new XSSignUtil();

    private XSSignUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int buildUrl$lambda$0(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public final String buildUrl(Context context, String mtUserId, String oaid, String mtId, String mtKey) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mtUserId, "mtUserId");
        Intrinsics.checkNotNullParameter(oaid, "oaid");
        Intrinsics.checkNotNullParameter(mtId, "mtId");
        Intrinsics.checkNotNullParameter(mtKey, "mtKey");
        final XSSignUtil$buildUrl$map$1 xSSignUtil$buildUrl$map$1 = new Function2<String, String, Integer>() { // from class: com.dhylive.app.utils.task.XSSignUtil$buildUrl$map$1
            public final Integer invoke(String str, String str2) {
                Intrinsics.checkNotNull(str2);
                return Integer.valueOf(str.compareTo(str2));
            }
        };
        TreeMap treeMap = new TreeMap(new Comparator() { // from class: com.dhylive.app.utils.task.XSSignUtil$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return XSSignUtil.buildUrl$lambda$0(xSSignUtil$buildUrl$map$1, obj, obj2);
            }
        });
        Uri.Builder builderBuildUpon = Uri.parse("https://api.xuanshangwa.com.cn/web/unionApi/act/token").buildUpon();
        builderBuildUpon.appendQueryParameter("mt_id", mtId);
        TreeMap treeMap2 = treeMap;
        treeMap2.put("mt_id", mtId);
        if (!TextUtils.isEmpty(mtUserId)) {
            builderBuildUpon.appendQueryParameter("mt_user_id", mtUserId);
            treeMap2.put("mt_user_id", mtUserId);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            builderBuildUpon.appendQueryParameter("oaid", oaid);
            treeMap2.put("oaid", oaid);
        } else {
            String imei = DeviceUtil.getIMEI(context);
            if (!TextUtils.isEmpty(imei)) {
                builderBuildUpon.appendQueryParameter(c.l, imei);
                Intrinsics.checkNotNull(imei);
                treeMap2.put(c.l, imei);
            }
            String imei2 = DeviceUtil.getIMEI(context, 0);
            if (!TextUtils.isEmpty(imei2)) {
                builderBuildUpon.appendQueryParameter("imei1", imei2);
                Intrinsics.checkNotNull(imei2);
                treeMap2.put("imei1", imei2);
            }
            String imei22 = DeviceUtil.getImei2(context);
            if (!TextUtils.isEmpty(imei22)) {
                builderBuildUpon.appendQueryParameter(g.A, imei22);
                Intrinsics.checkNotNull(imei22);
                treeMap2.put(g.A, imei22);
            }
        }
        String phoneModel = DeviceUtil.getPhoneModel();
        if (!TextUtils.isEmpty(phoneModel)) {
            builderBuildUpon.appendQueryParameter("mobile_model", phoneModel);
            Intrinsics.checkNotNull(phoneModel);
            treeMap2.put("mobile_model", phoneModel);
        }
        String systemVersion = DeviceUtil.getSystemVersion();
        if (!TextUtils.isEmpty(systemVersion)) {
            builderBuildUpon.appendQueryParameter("sys_ver", systemVersion);
            Intrinsics.checkNotNull(systemVersion);
            treeMap2.put("sys_ver", systemVersion);
        }
        String str = "";
        String str2 = (System.currentTimeMillis() / 1000) + "";
        builderBuildUpon.appendQueryParameter(a.k, str2);
        treeMap2.put(a.k, str2);
        StringBuilder sb = new StringBuilder();
        Iterator it = treeMap2.entrySet().iterator();
        while (it.hasNext()) {
            sb.append((String) ((Map.Entry) it.next()).getValue()).append("#");
        }
        sb.append(mtKey);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrEncode = Base64.encode(bytes, 2);
        try {
            Intrinsics.checkNotNull(bArrEncode);
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            str = new String(bArrEncode, charsetForName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        builderBuildUpon.appendQueryParameter("sign", encryptMD5(str));
        String string2 = builderBuildUpon.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String encryptMD5(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.lang.String r1 = "UTF-8"
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)     // Catch: java.security.NoSuchAlgorithmException -> L20 java.io.UnsupportedEncodingException -> L25
            java.lang.String r2 = "forName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.security.NoSuchAlgorithmException -> L20 java.io.UnsupportedEncodingException -> L25
            byte[] r6 = r6.getBytes(r1)     // Catch: java.security.NoSuchAlgorithmException -> L20 java.io.UnsupportedEncodingException -> L25
            java.lang.String r1 = "getBytes(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)     // Catch: java.security.NoSuchAlgorithmException -> L20 java.io.UnsupportedEncodingException -> L25
            java.lang.String r1 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1)     // Catch: java.security.NoSuchAlgorithmException -> L20 java.io.UnsupportedEncodingException -> L25
            byte[] r6 = r1.digest(r6)     // Catch: java.security.NoSuchAlgorithmException -> L20 java.io.UnsupportedEncodingException -> L25
            goto L2a
        L20:
            r6 = move-exception
            r6.printStackTrace()
            goto L29
        L25:
            r6 = move-exception
            r6.printStackTrace()
        L29:
            r6 = r0
        L2a:
            if (r6 == 0) goto L54
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            int r1 = r1 * 2
            r0.<init>(r1)
            r1 = 0
            int r2 = r6.length
        L36:
            if (r1 >= r2) goto L4f
            r3 = r6[r1]
            r3 = r3 & 255(0xff, float:3.57E-43)
            r4 = 16
            if (r3 >= r4) goto L45
            java.lang.String r4 = "0"
            r0.append(r4)
        L45:
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r0.append(r3)
            int r1 = r1 + 1
            goto L36
        L4f:
            java.lang.String r6 = r0.toString()
            return r6
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dhylive.app.utils.task.XSSignUtil.encryptMD5(java.lang.String):java.lang.String");
    }
}
