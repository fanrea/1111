package com.sigmob.sdk.downloader.core;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.util.Log;
import com.baidu.mobstat.forbes.Config;
import com.sigmob.sdk.base.n;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.downloader.core.breakpoint.h;
import com.sigmob.sdk.downloader.core.breakpoint.j;
import com.sigmob.sdk.downloader.core.connection.a;
import com.sigmob.sdk.downloader.core.connection.b;
import com.sigmob.sdk.downloader.core.connection.c;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    public static final String a = "HEAD";
    public static final String b = "Range";
    public static final String c = "If-Match";
    public static final String d = "User-Agent";
    public static final String e = "Content-Length";
    public static final String f = "Content-Range";
    public static final String g = "Etag";
    public static final String h = "Transfer-Encoding";
    public static final String i = "Accept-Ranges";
    public static final String j = "Content-Disposition";
    public static final String k = "chunked";
    public static final int l = -1;
    public static final int m = 416;
    private static b n = new a();

    public static class a implements b {
        @Override // com.sigmob.sdk.downloader.core.c.b
        public void a(String tag, String msg) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.b
        public void a(String tag, String msg, Exception e) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.b
        public void b(String tag, String msg) {
        }

        @Override // com.sigmob.sdk.downloader.core.c.b
        public void c(String tag, String msg) {
        }
    }

    public interface b {
        void a(String tag, String msg);

        void a(String tag, String msg, Exception e);

        void b(String tag, String msg);

        void c(String tag, String msg);
    }

    public static long a(StatFs statFs) {
        return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static j a(Context context) {
        try {
            return (j) Class.forName("com.sigmob.sdk.downloader.core.breakpoint.i").getDeclaredConstructor(Context.class).newInstance(context);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            return new h();
        }
    }

    public static j a(j originStore) {
        try {
            originStore = (j) originStore.getClass().getMethod("createRemitSelf", new Class[0]).invoke(originStore, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        b("Util", "Get final download store is " + originStore);
        return originStore;
    }

    public static File a(final File file) {
        File parentFile = file.getParentFile();
        return parentFile == null ? new File("/") : parentFile;
    }

    public static String a(long bytes, boolean si) {
        int i2 = si ? 1000 : 1024;
        if (bytes < i2) {
            return bytes + " B";
        }
        double d2 = bytes;
        double d3 = i2;
        int iLog = (int) (Math.log(d2) / Math.log(d3));
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d2 / Math.pow(d3, iLog)), (si ? "kMGTPE" : "KMGTPE").charAt(iLog - 1) + (si ? "" : "i"));
    }

    public static String a(String string) {
        byte[] bArrDigest;
        try {
            bArrDigest = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            bArrDigest = null;
        }
        if (bArrDigest == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
        for (byte b2 : bArrDigest) {
            int i2 = b2 & 255;
            if (i2 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i2));
        }
        return sb.toString();
    }

    public static ThreadFactory a(final String name, final boolean daemon) {
        return new ThreadFactory() { // from class: com.sigmob.sdk.downloader.core.c.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, name);
                thread.setDaemon(daemon);
                return thread;
            }
        };
    }

    public static void a() {
        n = null;
    }

    public static void a(com.sigmob.sdk.downloader.core.breakpoint.a info) {
        boolean z = true;
        if (info.a() >= 0 && info.a() <= info.d()) {
            z = false;
        }
        if (z) {
            a("resetBlockIfDirty", "block is dirty so have to reset: " + info);
            info.f();
        }
    }

    public static void a(b l2) {
        n = l2;
    }

    public static void a(final com.sigmob.sdk.downloader.core.connection.a connection) {
    }

    public static void a(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, long instanceLength, boolean isAcceptRange) {
        int iA = g.j().g().a(isAcceptRange) ? g.j().g().a(task, instanceLength) : 1;
        info.f();
        long j2 = iA;
        long j3 = instanceLength / j2;
        int i2 = 0;
        long j4 = 0;
        long j5 = 0;
        while (i2 < iA) {
            j4 += j5;
            j5 = i2 == 0 ? (instanceLength % j2) + j3 : j3;
            info.a(new com.sigmob.sdk.downloader.core.breakpoint.a(j4, j5));
            i2++;
        }
    }

    public static void a(String tag, String msg) {
        b bVar = n;
        if (bVar != null) {
            bVar.a(tag, msg);
        } else {
            Log.w(tag, msg);
        }
    }

    public static void a(String tag, String msg, Exception e2) {
        b bVar = n;
        if (bVar != null) {
            bVar.a(tag, msg, e2);
        } else {
            Log.e(tag, msg, e2);
        }
    }

    public static void a(Map<String, List<String>> headerField) throws IOException {
        if (headerField.containsKey("If-Match") || headerField.containsKey("Range")) {
            throw new IOException("If-Match and Range only can be handle by internal!");
        }
    }

    public static void a(Map<String, List<String>> userHeaderField, com.sigmob.sdk.downloader.core.connection.a connection) throws IOException {
        a(userHeaderField);
        b(userHeaderField, connection);
    }

    public static boolean a(long fetchedLength, long contentLength) {
        return fetchedLength == contentLength;
    }

    public static boolean a(ConnectivityManager manager) {
        if (manager == null) {
            a("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static boolean a(Uri uri) {
        return uri.getScheme().equals("content");
    }

    public static boolean a(CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static long b(String contentLength) {
        if (contentLength == null) {
            return -1L;
        }
        try {
            return Long.parseLong(contentLength);
        } catch (NumberFormatException unused) {
            b("Util", "parseContentLength failed parse for '" + contentLength + "'");
            return -1L;
        }
    }

    public static b b() {
        return n;
    }

    public static void b(String tag, String msg) {
        b bVar = n;
        if (bVar != null) {
            bVar.b(tag, msg);
        } else {
            Log.d(tag, msg);
        }
    }

    public static void b(Map<String, List<String>> headerFields, com.sigmob.sdk.downloader.core.connection.a connection) {
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                connection.a(key, it.next());
            }
        }
    }

    public static boolean b(ConnectivityManager manager) {
        if (manager == null) {
            a("Util", "failed to get connectivity manager!");
            return true;
        }
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean b(Uri uri) {
        return uri.getScheme().equals(n.z);
    }

    public static long c(Uri contentUri) {
        contentUri.getAuthority();
        Cursor cursorQuery = g.j().h().getContentResolver().query(contentUri, null, null, null, null);
        if (cursorQuery == null) {
            return 0L;
        }
        try {
            cursorQuery.moveToFirst();
            int columnIndex = cursorQuery.getColumnIndex("_size");
            if (columnIndex >= 0) {
                return cursorQuery.getLong(columnIndex);
            }
            return 0L;
        } finally {
            cursorQuery.close();
        }
    }

    public static a.b c() {
        String name = b.a.class.getName();
        try {
            if (o.a().ac()) {
                return (a.b) Class.forName(name).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return new c.b();
    }

    public static void c(String tag, String msg) {
        b bVar = n;
        if (bVar != null) {
            bVar.c(tag, msg);
        } else {
            Log.i(tag, msg);
        }
    }

    public static boolean c(String permission) {
        return g.j().h().checkCallingOrSelfPermission(permission) == 0;
    }

    public static long d(String contentRange) throws NumberFormatException {
        if (contentRange != null && contentRange.length() != 0) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(contentRange);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                a("Util", "parse content-length from content-range failed " + e2);
            }
        }
        return -1L;
    }

    private static String e(String filename) {
        if (filename == null || filename.isEmpty()) {
            return null;
        }
        return filename.replaceAll("\\.\\./", Config.replace);
    }
}
