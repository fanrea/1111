package com.qq.e.comm.plugin;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.luck.picture.lib.config.SelectMimeType;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class a30 {
    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return str;
        }
        return str + (str.contains("?") ? com.alipay.sdk.m.s.a.n : "?") + str2 + "=" + str3;
    }

    public static boolean b(String str, String str2, String str3) {
        URL url;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        if (url == null) {
            return false;
        }
        String query = url.getQuery();
        if (TextUtils.isEmpty(query)) {
            return false;
        }
        return Pattern.compile("(^|&)" + str2 + "=" + str3 + "(&|$)").matcher(query).find();
    }

    public static boolean e(String str) {
        return c(Uri.parse(str));
    }

    public static boolean d(String str) {
        return (TextUtils.isEmpty(str) || e(str)) ? false : true;
    }

    public static Pair<Boolean, String> d(String str, String str2, String str3) {
        String str4 = "(\\?|&|#)" + str2 + "=([^&#]*)";
        String str5 = str2 + "=" + str3;
        Matcher matcher = Pattern.compile(str4).matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = false;
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(1) + str5);
            z = true;
        }
        matcher.appendTail(stringBuffer);
        return new Pair<>(Boolean.valueOf(z), stringBuffer.toString());
    }

    public static boolean f(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("weixin://dl");
    }

    public static String c(String str) {
        int iIndexOf;
        return (!TextUtils.isEmpty(str) && (iIndexOf = str.indexOf(63)) > 0) ? str.substring(0, iIndexOf) : str;
    }

    /* compiled from: A */
    public enum a {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE(SelectMimeType.SYSTEM_IMAGE);

        private String a;

        a(String str) {
            this.a = str;
        }

        public String b() {
            return this.a;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.qq.e.comm.plugin.a30.a b(java.lang.String r1) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto La
            java.lang.String r1 = r1.toLowerCase()
        La:
            int r0 = r1.hashCode()
            switch(r0) {
                case 3401: goto L63;
                case 97669: goto L59;
                case 98819: goto L4f;
                case 102340: goto L45;
                case 105441: goto L3b;
                case 111145: goto L31;
                case 3213227: goto L26;
                case 3268712: goto L1c;
                case 3645340: goto L12;
                default: goto L11;
            }
        L11:
            goto L6d
        L12:
            java.lang.String r0 = "webp"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 5
            goto L6e
        L1c:
            java.lang.String r0 = "jpeg"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 3
            goto L6e
        L26:
            java.lang.String r0 = "html"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 8
            goto L6e
        L31:
            java.lang.String r0 = "png"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 4
            goto L6e
        L3b:
            java.lang.String r0 = "jpg"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 2
            goto L6e
        L45:
            java.lang.String r0 = "gif"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 7
            goto L6e
        L4f:
            java.lang.String r0 = "css"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 0
            goto L6e
        L59:
            java.lang.String r0 = "bmp"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 6
            goto L6e
        L63:
            java.lang.String r0 = "js"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L6d
            r1 = 1
            goto L6e
        L6d:
            r1 = -1
        L6e:
            switch(r1) {
                case 0: goto L7a;
                case 1: goto L77;
                case 2: goto L74;
                case 3: goto L74;
                case 4: goto L74;
                case 5: goto L74;
                case 6: goto L74;
                case 7: goto L74;
                default: goto L71;
            }
        L71:
            com.qq.e.comm.plugin.a30$a r1 = com.qq.e.comm.plugin.a30.a.HTML
            goto L7c
        L74:
            com.qq.e.comm.plugin.a30$a r1 = com.qq.e.comm.plugin.a30.a.IMAGE
            goto L7c
        L77:
            com.qq.e.comm.plugin.a30$a r1 = com.qq.e.comm.plugin.a30.a.JS
            goto L7c
        L7a:
            com.qq.e.comm.plugin.a30$a r1 = com.qq.e.comm.plugin.a30.a.CSS
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.a30.b(java.lang.String):com.qq.e.comm.plugin.a30$a");
    }

    public static String a(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.getMessage();
            return "";
        }
    }

    public static boolean c(Uri uri) {
        return (uri == null || uri.getScheme() == null || (!uri.getScheme().equalsIgnoreCase(com.alipay.sdk.m.l.a.r) && !uri.getScheme().equalsIgnoreCase("https"))) ? false : true;
    }

    public static String c(String str, String str2, String str3) {
        Pair<Boolean, String> pairD = d(str, str2, str3);
        if (((Boolean) pairD.first).booleanValue()) {
            return (String) pairD.second;
        }
        return a(str, str2, str3);
    }

    public static boolean b(Uri uri) {
        return uri != null && uri.isHierarchical() && "gdtmsg".equals(uri.getScheme()) && "e.qq.com".equals(uri.getAuthority());
    }

    public static String a(Uri uri) {
        if (uri == null) {
            return "";
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return "";
        }
        int iLastIndexOf = path.lastIndexOf("/0");
        if (iLastIndexOf > 0) {
            path = path.substring(0, iLastIndexOf);
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(path);
        return !TextUtils.isEmpty(fileExtensionFromUrl) ? fileExtensionFromUrl.toLowerCase() : "";
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        int iIndexOf = str.indexOf("?");
        if (iIndexOf > 0) {
            str = str.substring(0, iIndexOf - 1);
        }
        int iIndexOf2 = str2.indexOf("?");
        if (iIndexOf2 > 0) {
            str2 = str2.substring(0, iIndexOf2 - 1);
        }
        return TextUtils.equals(str, str2);
    }

    public static boolean a(String str, Collection<String> collection) {
        try {
            if (TextUtils.isEmpty(str) || collection == null || collection.size() <= 0) {
                return false;
            }
            return collection.contains(Uri.parse(str).getHost());
        } catch (Throwable th) {
            th.getMessage();
            return false;
        }
    }
}
