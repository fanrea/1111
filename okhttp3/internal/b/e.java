package okhttp3.internal.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class e {
    private static final Pattern PARAMETER = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    public static long c(Response response) {
        return a(response.headers());
    }

    public static long a(Headers headers) {
        return x(headers.get("Content-Length"));
    }

    private static long x(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static boolean a(Response response, Headers headers, Request request) {
        for (String str : e(response)) {
            if (!okhttp3.internal.c.b(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(Response response) {
        return b(response.headers());
    }

    private static boolean b(Headers headers) {
        return c(headers).contains("*");
    }

    private static Set<String> e(Response response) {
        return c(response.headers());
    }

    private static Set<String> c(Headers headers) {
        Set<String> setEmptySet = Collections.emptySet();
        int size = headers.size();
        Set<String> treeSet = setEmptySet;
        for (int i = 0; i < size; i++) {
            if ("Vary".equalsIgnoreCase(headers.name(i))) {
                String strValue = headers.value(i);
                if (treeSet.isEmpty()) {
                    treeSet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strValue.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
    }

    public static Headers f(Response response) {
        return b(response.networkResponse().request().headers(), response.headers());
    }

    private static Headers b(Headers headers, Headers headers2) {
        Set<String> setC = c(headers2);
        if (setC.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String strName = headers.name(i);
            if (setC.contains(strName)) {
                builder.add(strName, headers.value(i));
            }
        }
        return builder.build();
    }

    public static List<Challenge> a(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : headers.values(str)) {
            int iIndexOf = str2.indexOf(32);
            if (iIndexOf != -1) {
                Matcher matcher = PARAMETER.matcher(str2);
                int iEnd = iIndexOf;
                while (true) {
                    if (!matcher.find(iEnd)) {
                        break;
                    }
                    if (str2.regionMatches(true, matcher.start(1), "realm", 0, 5)) {
                        String strSubstring = str2.substring(0, iIndexOf);
                        String strGroup = matcher.group(3);
                        if (strGroup != null) {
                            arrayList.add(new Challenge(strSubstring, strGroup));
                            break;
                        }
                    }
                    iEnd = matcher.end();
                }
            }
        }
        return arrayList;
    }

    public static void a(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    public static boolean g(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && c(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static int a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int c(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    public static int d(String str, int i) throws NumberFormatException {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
