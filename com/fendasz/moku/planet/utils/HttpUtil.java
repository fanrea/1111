package com.fendasz.moku.planet.utils;

import com.alipay.sdk.m.s.a;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class HttpUtil {
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int TIME_OUT = 10000;

    /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String sendGet(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9) throws java.lang.Throwable {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r2.<init>(r8)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r8 = 1
            if (r9 == 0) goto L4c
            java.lang.String r3 = "?"
            r2.append(r3)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.util.Set r3 = r9.keySet()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
        L1b:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            if (r4 == 0) goto L40
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.StringBuilder r5 = r2.append(r4)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.String r6 = "="
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.Object r4 = r9.get(r4)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r5.append(r4)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.String r4 = "&"
            r2.append(r4)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            goto L1b
        L40:
            int r9 = r2.length()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            int r9 = r9 - r8
            int r3 = r2.length()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r2.delete(r9, r3)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
        L4c:
            java.net.URL r9 = new java.net.URL     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r9.<init>(r2)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.net.URLConnection r9 = r9.openConnection()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.String r2 = "GET"
            r9.setRequestMethod(r2)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r2 = 0
            r9.setDoOutput(r2)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r9.setDoInput(r8)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r8 = 10000(0x2710, float:1.4013E-41)
            r9.setConnectTimeout(r8)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r9.setReadTimeout(r8)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.String r8 = "Content-Type"
            java.lang.String r2 = "application/x-www-form-urlencoded"
            r9.setRequestProperty(r8, r2)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r9.connect()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r9.getResponseCode()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.io.InputStream r9 = r9.getInputStream()     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            java.lang.String r3 = "UTF-8"
            r2.<init>(r9, r3)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
            r8.<init>(r2)     // Catch: java.lang.Throwable -> Lac java.lang.Exception -> Lae
        L8c:
            java.lang.String r9 = r8.readLine()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La7
            if (r9 == 0) goto L96
            r0.append(r9)     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La7
            goto L8c
        L96:
            java.lang.String r9 = r0.toString()     // Catch: java.lang.Throwable -> La3 java.lang.Exception -> La7
            r8.close()     // Catch: java.lang.Exception -> L9e
            goto La2
        L9e:
            r8 = move-exception
            r8.printStackTrace()
        La2:
            return r9
        La3:
            r9 = move-exception
            r1 = r8
            r8 = r9
            goto Ld8
        La7:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto Lb0
        Lac:
            r8 = move-exception
            goto Ld8
        Lae:
            r8 = move-exception
            r9 = r1
        Lb0:
            java.io.PrintStream r0 = java.lang.System.out     // Catch: java.lang.Throwable -> Ld6
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld6
            r2.<init>()     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r3 = "发送GET请求出现异常！"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Throwable -> Ld6
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch: java.lang.Throwable -> Ld6
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Ld6
            r0.println(r2)     // Catch: java.lang.Throwable -> Ld6
            r8.printStackTrace()     // Catch: java.lang.Throwable -> Ld6
            if (r9 == 0) goto Ld5
            r9.close()     // Catch: java.lang.Exception -> Ld1
            goto Ld5
        Ld1:
            r8 = move-exception
            r8.printStackTrace()
        Ld5:
            return r1
        Ld6:
            r8 = move-exception
            r1 = r9
        Ld8:
            if (r1 == 0) goto Le2
            r1.close()     // Catch: java.lang.Exception -> Lde
            goto Le2
        Lde:
            r9 = move-exception
            r9.printStackTrace()
        Le2:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.HttpUtil.sendGet(java.lang.String, java.util.Map):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String sendGet(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.util.Map<java.lang.String, java.lang.Object> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fendasz.moku.planet.utils.HttpUtil.sendGet(java.lang.String, java.util.Map, java.util.Map):java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static String doGet(String str) throws Throwable {
        InputStream inputStream;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection;
        try {
            if (str != 0) {
                try {
                    str = (HttpURLConnection) new URL(str).openConnection();
                } catch (MalformedURLException e) {
                    e = e;
                    str = 0;
                    inputStream2 = null;
                } catch (IOException e2) {
                    e = e2;
                    str = 0;
                    inputStream2 = null;
                } catch (Throwable th) {
                    inputStream = null;
                    th = th;
                    str = 0;
                }
                try {
                    str.setConnectTimeout(10000);
                    str.setReadTimeout(10000);
                    str.setRequestMethod("GET");
                    str.setRequestProperty("Accept-Encoding", "gzip");
                    str.connect();
                    if (str.getResponseCode() == 200) {
                        inputStream2 = str.getInputStream();
                        try {
                            String line = new BufferedReader(new InputStreamReader(inputStream2)).readLine();
                            StreamUtil.close((HttpURLConnection) str);
                            StreamUtil.close(inputStream2);
                            return line;
                        } catch (MalformedURLException e3) {
                            e = e3;
                            e.printStackTrace();
                            httpURLConnection = str;
                            StreamUtil.close(httpURLConnection);
                            StreamUtil.close(inputStream2);
                            return null;
                        } catch (IOException e4) {
                            e = e4;
                            e.printStackTrace();
                            httpURLConnection = str;
                            StreamUtil.close(httpURLConnection);
                            StreamUtil.close(inputStream2);
                            return null;
                        }
                    }
                    StreamUtil.close((HttpURLConnection) str);
                    StreamUtil.close((InputStream) null);
                } catch (MalformedURLException e5) {
                    e = e5;
                    inputStream2 = null;
                } catch (IOException e6) {
                    e = e6;
                    inputStream2 = null;
                } catch (Throwable th2) {
                    inputStream = null;
                    th = th2;
                    StreamUtil.close((HttpURLConnection) str);
                    StreamUtil.close(inputStream);
                    throw th;
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String sendPostData(String str, Map<String, String> map, String str2) throws Throwable {
        byte[] bytes = getRequestData(map, str2).toString().getBytes();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", MediaTypeUtils.APPLICATION_FORM);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                httpURLConnection.getOutputStream().write(bytes);
                if (httpURLConnection.getResponseCode() != 200) {
                    return null;
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        String str3 = "err: " + e.getMessage().toString();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return str3;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                String string = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return string;
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String sendPostData(String str, Map<String, String> map, Map<String, Object> map2, String str2) throws Throwable {
        byte[] bytes = getRequestData(map, str2).toString().getBytes();
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(3000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", MediaTypeUtils.APPLICATION_FORM);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
                if (map2 != null && !map2.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map2.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), String.valueOf(entry.getValue()));
                    }
                }
                httpURLConnection.getOutputStream().write(bytes);
                if (httpURLConnection.getResponseCode() != 200) {
                    return null;
                }
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                    } catch (IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        String str3 = "err: " + e.getMessage().toString();
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        return str3;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                String string = sb.toString();
                try {
                    bufferedReader2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return string;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e5) {
            e = e5;
        }
    }

    public static StringBuffer getRequestData(Map<String, String> map, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), str)).append(a.n);
                }
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer;
    }

    public static String dealResponseResult(InputStream inputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        byteArrayOutputStream.close();
                        return null;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return null;
                    }
                }
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
        return new String(byteArrayOutputStream.toByteArray(), str);
    }

    public static class StreamUtil {
        public static void close(HttpURLConnection httpURLConnection) {
            httpURLConnection.disconnect();
        }

        public static void close(InputStream inputStream) throws IOException {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String doJsonPost(String str, String str2) throws Throwable {
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpURLConnection.setRequestProperty("accept", "application/json");
                    if (!StringUtils.isEmpty(str2)) {
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                    if (200 == httpURLConnection.getResponseCode()) {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                        try {
                            line = bufferedReader2.readLine();
                            bufferedReader = bufferedReader2;
                        } catch (Exception e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return line;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return line;
    }

    public static String doJsonPost(String str, String str2, Map<String, Object> map) throws Throwable {
        String line = "";
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                    httpURLConnection.setRequestProperty("accept", "application/json");
                    if (map != null && !map.isEmpty()) {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            httpURLConnection.setRequestProperty(entry.getKey(), String.valueOf(entry.getValue()));
                        }
                    }
                    if (!StringUtils.isEmpty(str2)) {
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str2.getBytes().length));
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        outputStream.write(str2.getBytes());
                        outputStream.flush();
                        outputStream.close();
                    }
                    if (200 == httpURLConnection.getResponseCode()) {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                        try {
                            line = bufferedReader2.readLine();
                            bufferedReader = bufferedReader2;
                        } catch (Exception e) {
                            e = e;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return line;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e3) {
                e = e3;
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return line;
    }
}
