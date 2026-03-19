package com.baidu.mobstat.forbes;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobstat.forbes.an;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class z {
    private static volatile boolean a;
    private static volatile boolean b;
    private static volatile boolean c;

    private static boolean a(int i) {
        switch (i) {
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
            default:
                return false;
        }
    }

    private static void a(int i, boolean z) {
        switch (i) {
            case 0:
                a = z;
                break;
            case 1:
                b = z;
                break;
            case 2:
                c = z;
                break;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4 A[Catch: all -> 0x0143, Exception -> 0x014a, TryCatch #2 {all -> 0x0143, blocks: (B:29:0x0076, B:31:0x0080, B:35:0x0092, B:38:0x00a6, B:39:0x00ca, B:41:0x00d4, B:44:0x00fc, B:46:0x0100, B:47:0x010c, B:50:0x0122, B:51:0x012e, B:56:0x0136), top: B:81:0x0076, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fc A[Catch: all -> 0x0143, Exception -> 0x014a, TryCatch #2 {all -> 0x0143, blocks: (B:29:0x0076, B:31:0x0080, B:35:0x0092, B:38:0x00a6, B:39:0x00ca, B:41:0x00d4, B:44:0x00fc, B:46:0x0100, B:47:0x010c, B:50:0x0122, B:51:0x012e, B:56:0x0136), top: B:81:0x0076, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013f A[Catch: all -> 0x0151, PHI: r2 r4
  0x013f: PHI (r2v2 boolean) = (r2v4 boolean), (r2v6 boolean) binds: [B:69:0x014c, B:61:0x013d] A[DONT_GENERATE, DONT_INLINE]
  0x013f: PHI (r4v4 java.net.HttpURLConnection) = (r4v5 java.net.HttpURLConnection), (r4v6 java.net.HttpURLConnection) binds: [B:69:0x014c, B:61:0x013d] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0003, B:13:0x0012, B:17:0x001e, B:20:0x002a, B:21:0x0044, B:23:0x004e, B:24:0x0068, B:62:0x013f, B:65:0x0146, B:66:0x0149, B:29:0x0076, B:31:0x0080, B:35:0x0092, B:38:0x00a6, B:39:0x00ca, B:41:0x00d4, B:44:0x00fc, B:46:0x0100, B:47:0x010c, B:50:0x0122, B:51:0x012e, B:56:0x0136), top: B:80:0x0003, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized boolean a(android.content.Context r10, java.lang.String r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.z.a(android.content.Context, java.lang.String, int, boolean):boolean");
    }

    private static String a(Context context, String str, int i) {
        switch (i) {
            case 0:
                return a();
            case 1:
                return a(context);
            case 2:
                return a(context, str);
            default:
                return "";
        }
    }

    private static String a() {
        return "https://dxp.baidu.com/vizParser";
    }

    private static String a(Context context) throws UnsupportedEncodingException {
        String strA = aj.a(context, c.b);
        ArrayList<Pair> arrayList = new ArrayList();
        if (!TextUtils.isEmpty(strA)) {
            String strA2 = an.a.a(strA.getBytes());
            if (!TextUtils.isEmpty(strA2)) {
                arrayList.add(new Pair("sign", strA2));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair pair : arrayList) {
            try {
                String strEncode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                String strEncode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(strEncode + "=" + strEncode2);
                } else {
                    sb.append(com.alipay.sdk.m.s.a.n + strEncode + "=" + strEncode2);
                }
            } catch (Exception e) {
            }
        }
        String string = sb.toString();
        return !TextUtils.isEmpty(string) ? "https://dxp.baidu.com/autoTracker?" + string : "https://dxp.baidu.com/autoTracker";
    }

    private static String a(Context context, String str) throws UnsupportedEncodingException {
        ArrayList<Pair> arrayList = new ArrayList();
        arrayList.add(new Pair("sdkVersion", StatService.getSdkVersion()));
        arrayList.add(new Pair("appKey", "" + str));
        arrayList.add(new Pair("packageName", context.getPackageName()));
        arrayList.add(new Pair("appVersion", ar.f(context)));
        arrayList.add(new Pair("cuid", ""));
        arrayList.add(new Pair(com.baidu.mobads.container.adrequest.g.z, ""));
        arrayList.add(new Pair("platform", "Android"));
        arrayList.add(new Pair("model", CooperService.instance().getPhoneModel()));
        arrayList.add(new Pair("s", Build.VERSION.SDK_INT + ""));
        arrayList.add(new Pair(Config.OS, CooperService.instance().getOSSysVersion()));
        StringBuilder sb = new StringBuilder();
        for (Pair pair : arrayList) {
            try {
                String strEncode = URLEncoder.encode(((String) pair.first).toString(), "UTF-8");
                String strEncode2 = URLEncoder.encode(((String) pair.second).toString(), "UTF-8");
                if (TextUtils.isEmpty(sb.toString())) {
                    sb.append(strEncode + "=" + strEncode2);
                } else {
                    sb.append(com.alipay.sdk.m.s.a.n + strEncode + "=" + strEncode2);
                }
            } catch (Exception e) {
            }
        }
        return "https://dxp.baidu.com/circleConfig?" + sb.toString();
    }

    private static String b(int i) {
        switch (i) {
            case 0:
                return c.a;
            case 1:
                return c.b;
            case 2:
                return c.c;
            default:
                return "";
        }
    }
}
