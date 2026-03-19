package cn.net.shoot.sharetracesdk.a;

import aegon.chrome.net.NetError;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import cn.net.shoot.sharetracesdk.AppData;
import cn.net.shoot.sharetracesdk.c.c;
import cn.net.shoot.sharetracesdk.e.f;
import cn.net.shoot.sharetracesdk.exception.SignatureNotFoundException;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.ws.WebSocketProtocol;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a {
    public static int a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static String a() {
        return Build.BRAND;
    }

    public static String a(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(line);
        }
    }

    public static void a(f fVar, int i, String str) {
        c cVar = new c();
        cVar.a = i;
        cVar.b = str;
        fVar.a(cVar);
    }

    public static int b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.widthPixels;
    }

    public static List<String> b() throws SocketException {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                        String hostAddress = inetAddressNextElement.getHostAddress();
                        if (!TextUtils.isEmpty(hostAddress)) {
                            arrayList.add(hostAddress);
                        }
                    }
                }
            }
        } catch (SocketException e) {
            Log.e("ShareTrace", e.toString());
        }
        return arrayList;
    }

    public static c c(String str) throws JSONException {
        c cVar = new c();
        JSONObject jSONObject = new JSONObject(str);
        cVar.a = jSONObject.getInt("status");
        cVar.b = jSONObject.getString("error");
        AppData appData = new AppData();
        if (!jSONObject.has("data") || jSONObject.isNull("data") || !(jSONObject.get("data") instanceof JSONObject)) {
            return cVar;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        if (jSONObject2.has("params_data") && !jSONObject2.isNull("params_data")) {
            appData.setParamsData(jSONObject2.getString("params_data"));
        }
        if (jSONObject2.has("channel") && !jSONObject2.isNull("channel")) {
            appData.setChannel(jSONObject2.getString("channel"));
        }
        if (jSONObject2.has(PointParamKey.TRACE_ID) && !jSONObject2.isNull(PointParamKey.TRACE_ID)) {
            cVar.c = jSONObject2.getString(PointParamKey.TRACE_ID);
        }
        cVar.d = appData;
        return cVar;
    }

    public static String c() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            return Build.SERIAL;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d() {
        return Build.MODEL;
    }

    public static String e() {
        return Build.VERSION.RELEASE;
    }

    public static int f() throws PackageManager.NameNotFoundException {
        Application application = cn.net.shoot.sharetracesdk.f.a.c().a;
        String packageName = application.getPackageName();
        PackageInfo packageInfo = null;
        if (!TextUtils.isEmpty(packageName)) {
            try {
                packageInfo = application.getPackageManager().getPackageInfo(packageName, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static AppData b(String str) {
        AppData appData = new AppData();
        if (TextUtils.isEmpty(str)) {
            return appData;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("params_data") && !jSONObject.isNull("params_data")) {
                appData.setParamsData(jSONObject.getString("params_data"));
            }
            if (jSONObject.has("channel") && !jSONObject.isNull("channel")) {
                appData.setChannel(jSONObject.getString("channel"));
            }
        } catch (Exception e) {
            Log.e("ShareTrace", "parse app data error. err=" + e.getMessage());
        }
        return appData;
    }

    public static b<ByteBuffer, Long> a(FileChannel fileChannel) throws SignatureNotFoundException, IOException {
        long size = fileChannel.size();
        if (size < 22) {
            throw new IOException("APK too small for ZIP End of Central Directory (EOCD) record");
        }
        long j = size - 22;
        long jMin = Math.min(j, WebSocketProtocol.PAYLOAD_SHORT_MAX);
        int i = 0;
        while (true) {
            long j2 = i;
            if (j2 > jMin) {
                throw new IOException("ZIP End of Central Directory (EOCD) record not found");
            }
            long j3 = j - j2;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            fileChannel.position(j3);
            fileChannel.read(byteBufferAllocate);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            if (byteBufferAllocate.getInt(0) == 101010256) {
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(2);
                fileChannel.position(j3 + 20);
                fileChannel.read(byteBufferAllocate2);
                byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
                short s = byteBufferAllocate2.getShort(0);
                if (s == i) {
                    ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate(4);
                    byteBufferAllocate3.order(ByteOrder.LITTLE_ENDIAN);
                    fileChannel.position((fileChannel.size() - s) - 6);
                    fileChannel.read(byteBufferAllocate3);
                    long j4 = byteBufferAllocate3.getInt(0);
                    if (j4 < 32) {
                        throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j4);
                    }
                    fileChannel.position(j4 - 24);
                    ByteBuffer byteBufferAllocate4 = ByteBuffer.allocate(24);
                    fileChannel.read(byteBufferAllocate4);
                    byteBufferAllocate4.order(ByteOrder.LITTLE_ENDIAN);
                    if (byteBufferAllocate4.getLong(8) != 2334950737559900225L || byteBufferAllocate4.getLong(16) != 3617552046287187010L) {
                        throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
                    }
                    long j5 = byteBufferAllocate4.getLong(0);
                    if (j5 < byteBufferAllocate4.capacity() || j5 > 2147483639) {
                        throw new SignatureNotFoundException("APK Signing Block size out of range: " + j5);
                    }
                    int i2 = (int) (8 + j5);
                    long j6 = j4 - i2;
                    if (j6 < 0) {
                        throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j6);
                    }
                    fileChannel.position(j6);
                    ByteBuffer byteBufferAllocate5 = ByteBuffer.allocate(i2);
                    fileChannel.read(byteBufferAllocate5);
                    byteBufferAllocate5.order(ByteOrder.LITTLE_ENDIAN);
                    long j7 = byteBufferAllocate5.getLong(0);
                    if (j7 == j5) {
                        return new b<>(byteBufferAllocate5, Long.valueOf(j6));
                    }
                    throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j7 + " vs " + j5);
                }
            }
            i++;
        }
    }

    public static Map<Integer, ByteBuffer> a(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        if (byteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
            int iCapacity = byteBuffer.capacity() - 24;
            if (iCapacity < 8) {
                throw new IllegalArgumentException("end < start: " + iCapacity + " < 8");
            }
            int iCapacity2 = byteBuffer.capacity();
            if (iCapacity > byteBuffer.capacity()) {
                throw new IllegalArgumentException("end > capacity: " + iCapacity + " > " + iCapacity2);
            }
            int iLimit = byteBuffer.limit();
            int iPosition = byteBuffer.position();
            int i = 0;
            try {
                byteBuffer.position(0);
                byteBuffer.limit(iCapacity);
                byteBuffer.position(8);
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBufferSlice.order(byteBuffer.order());
                byteBuffer.position(0);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                while (byteBufferSlice.hasRemaining()) {
                    i++;
                    if (byteBufferSlice.remaining() < 8) {
                        throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i);
                    }
                    long j = byteBufferSlice.getLong();
                    if (j < 4 || j > 2147483647L) {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + j);
                    }
                    int i2 = (int) j;
                    int iPosition2 = byteBufferSlice.position() + i2;
                    if (i2 > byteBufferSlice.remaining()) {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferSlice.remaining());
                    }
                    Integer numValueOf = Integer.valueOf(byteBufferSlice.getInt());
                    int i3 = i2 - 4;
                    if (i3 < 0) {
                        throw new IllegalArgumentException("size: " + i3);
                    }
                    int iLimit2 = byteBufferSlice.limit();
                    int iPosition3 = byteBufferSlice.position();
                    int i4 = i3 + iPosition3;
                    if (i4 < iPosition3 || i4 > iLimit2) {
                        throw new BufferUnderflowException();
                    }
                    byteBufferSlice.limit(i4);
                    try {
                        ByteBuffer byteBufferSlice2 = byteBufferSlice.slice();
                        byteBufferSlice2.order(byteBufferSlice.order());
                        byteBufferSlice.position(i4);
                        byteBufferSlice.limit(iLimit2);
                        linkedHashMap.put(numValueOf, byteBufferSlice2);
                        byteBufferSlice.position(iPosition2);
                    } catch (Throwable th) {
                        byteBufferSlice.limit(iLimit2);
                        throw th;
                    }
                }
                return linkedHashMap;
            } catch (Throwable th2) {
                byteBuffer.position(0);
                byteBuffer.limit(iLimit);
                byteBuffer.position(iPosition);
                throw th2;
            }
        }
        throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo()     // Catch: java.lang.Throwable -> Lb
            if (r5 != 0) goto L8
            goto Lb
        L8:
            java.lang.String r5 = r5.sourceDir     // Catch: java.lang.Throwable -> Lb
            goto Lc
        Lb:
            r5 = r0
        Lc:
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L13
            goto L1e
        L13:
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            java.lang.String r5 = a(r1)     // Catch: org.json.JSONException -> L44
            if (r5 != 0) goto L20
        L1e:
            r2 = r0
            goto L49
        L20:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L44
            r1.<init>(r5)     // Catch: org.json.JSONException -> L44
            java.util.Iterator r5 = r1.keys()     // Catch: org.json.JSONException -> L44
            java.util.HashMap r2 = new java.util.HashMap     // Catch: org.json.JSONException -> L44
            r2.<init>()     // Catch: org.json.JSONException -> L44
        L2e:
            boolean r3 = r5.hasNext()     // Catch: org.json.JSONException -> L44
            if (r3 == 0) goto L49
            java.lang.Object r3 = r5.next()     // Catch: org.json.JSONException -> L44
            java.lang.String r3 = r3.toString()     // Catch: org.json.JSONException -> L44
            java.lang.String r4 = r1.getString(r3)     // Catch: org.json.JSONException -> L44
            r2.put(r3, r4)     // Catch: org.json.JSONException -> L44
            goto L2e
        L44:
            r5 = move-exception
            r5.printStackTrace()
            goto L1e
        L49:
            if (r2 != 0) goto L4c
            return r0
        L4c:
            java.lang.Object r5 = r2.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.net.shoot.sharetracesdk.a.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(String str) {
        return cn.net.shoot.sharetracesdk.f.a.c().a.getSharedPreferences("pref_share_trace", 0).getString(str, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r4) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L33
            java.lang.String r2 = "r"
            r1.<init>(r4, r2)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L33
            java.nio.channels.FileChannel r4 = r1.getChannel()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L22
            cn.net.shoot.sharetracesdk.a.b r2 = a(r4)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L35
            A r2 = r2.a     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L35
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L35
            java.util.Map r2 = a(r2)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L35
            r4.close()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L42
            goto L3d
        L1d:
            r2 = move-exception
            goto L28
        L1f:
            r2 = move-exception
            r4 = r0
            goto L28
        L22:
            r4 = r0
            goto L35
        L24:
            r4 = move-exception
            r2 = r4
            r4 = r0
            r1 = r4
        L28:
            if (r4 == 0) goto L2d
            r4.close()     // Catch: java.io.IOException -> L2d cn.net.shoot.sharetracesdk.exception.SignatureNotFoundException -> L41
        L2d:
            if (r1 == 0) goto L32
            r1.close()     // Catch: java.io.IOException -> L32 cn.net.shoot.sharetracesdk.exception.SignatureNotFoundException -> L41
        L32:
            throw r2     // Catch: cn.net.shoot.sharetracesdk.exception.SignatureNotFoundException -> L41
        L33:
            r4 = r0
            r1 = r4
        L35:
            if (r4 == 0) goto L3a
            r4.close()     // Catch: java.io.IOException -> L3a cn.net.shoot.sharetracesdk.exception.SignatureNotFoundException -> L41
        L3a:
            if (r1 == 0) goto L41
            r2 = r0
        L3d:
            r1.close()     // Catch: java.lang.Throwable -> L42
            goto L42
        L41:
            r2 = r0
        L42:
            if (r2 != 0) goto L45
            goto L54
        L45:
            r4 = 1903654775(0x71777777, float:1.22539554E30)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r2.get(r4)
            java.nio.ByteBuffer r4 = (java.nio.ByteBuffer) r4
            if (r4 != 0) goto L56
        L54:
            r4 = r0
            goto L6c
        L56:
            byte[] r1 = r4.array()
            int r2 = r4.arrayOffset()
            int r3 = r4.position()
            int r3 = r3 + r2
            int r4 = r4.limit()
            int r2 = r2 + r4
            byte[] r4 = java.util.Arrays.copyOfRange(r1, r3, r2)
        L6c:
            if (r4 != 0) goto L6f
            goto L7c
        L6f:
            java.lang.String r1 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L78
            java.lang.String r2 = "UTF-8"
            r1.<init>(r4, r2)     // Catch: java.io.UnsupportedEncodingException -> L78
            r0 = r1
            goto L7c
        L78:
            r4 = move-exception
            r4.printStackTrace()
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.net.shoot.sharetracesdk.a.a.a(java.io.File):java.lang.String");
    }

    public static String a(Map<String, String> map) throws JSONException {
        if (map != null && map.size() != 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getValue())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
                return jSONObject.toString();
            } catch (Exception e) {
                Log.e("ShareTrace", "format params error. err=" + e.getMessage());
            }
        }
        return "{}";
    }

    public static void a(String str, Map<String, String> map, f fVar, String str2) {
        try {
            fVar.a(a(map, (HttpURLConnection) new URL(str).openConnection(), str2));
        } catch (Exception e) {
            Log.e("ShareTrace", "http post error. error msg=" + e.getMessage());
            a(fVar, NetError.ERR_CONNECTION_RESET, e.getMessage());
        }
    }

    public static void a(String str, String str2) {
        cn.net.shoot.sharetracesdk.f.a.c().a.getSharedPreferences("pref_share_trace", 0).edit().putString(str, str2).apply();
    }

    public static c a(Map<String, String> map, HttpURLConnection httpURLConnection, String str) throws IOException {
        c cVar = new c();
        map.put("rt", String.valueOf(System.currentTimeMillis()));
        map.put("net", str);
        InputStream inputStream = null;
        try {
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(cn.net.shoot.sharetracesdk.f.a.c().f);
                httpURLConnection.setReadTimeout(cn.net.shoot.sharetracesdk.f.a.c().e);
                httpURLConnection.setChunkedStreamingMode(0);
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
                httpURLConnection.connect();
                String str2 = "request url : " + httpURLConnection.getURL().toString();
                String strA = a(map);
                if (!TextUtils.isEmpty(strA)) {
                    PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
                    printWriter.print(strA);
                    printWriter.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                String str3 = "get code from response. code is " + responseCode;
                if (responseCode == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    String strA2 = a(inputStream);
                    String str4 = "Response Data is " + strA2;
                    cVar = c(strA2);
                } else {
                    cVar.a = responseCode;
                    cVar.b = "response data error.";
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                cVar.a = NetError.ERR_CONNECTION_RESET;
                cVar.b = e.getMessage();
                Log.e("ShareTrace", "http post error. error msg=" + e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                if (httpURLConnection != null) {
                }
            }
            httpURLConnection.disconnect();
            String str5 = "http post result:" + cVar.toString();
            return cVar;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, cn.net.shoot.sharetracesdk.e.f r10) throws java.lang.InterruptedException, java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 427
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.net.shoot.sharetracesdk.a.a.a(java.lang.String, java.util.Map, cn.net.shoot.sharetracesdk.e.f):void");
    }
}
