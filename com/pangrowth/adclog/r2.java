package com.pangrowth.adclog;

import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class r2 {
    public static Map<String, String> a = new HashMap();
    public static final String b = "cloudMessage" + UUID.randomUUID().toString();

    public static boolean a(p2 p2Var) {
        int i = 0;
        boolean z = false;
        while (i < p2Var.o.size()) {
            File file = new File(p2Var.o.get(i));
            if (file.exists()) {
                int i2 = i < p2Var.o.size() - 1 ? 1 : 2;
                if (p2Var.n) {
                    i2 = p2Var.d;
                }
                boolean zA = a("https://mon.snssdk.com/monitor/collect/c/cloudcontrol/file", file, i2, p2Var.h, p2Var.c, p2Var.e, p2Var.f, p2Var.g);
                if (zA && p2Var.k) {
                    file.delete();
                }
                z = i == 0 ? zA : z && zA;
            }
            i++;
        }
        return z;
    }

    public static boolean a(String str, int i, String str2, String str3, long j, HashMap map) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("connection", "keep-alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + b);
                Map<String, String> map2 = a;
                if (map2 != null && !map2.isEmpty()) {
                    for (Map.Entry<String, String> entry : a.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                            httpURLConnection.setRequestProperty(key, value);
                        }
                    }
                }
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            String str4 = b;
            stringBuffer.append(str4);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + i + "\r\n--" + str4 + "\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + str2 + "\r\n--" + str4 + "\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + str3 + "\r\n--" + str4 + "\r\n");
            StringBuilder sbAppend = new StringBuilder().append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");
            f1.c();
            stringBuffer.append(sbAppend.append("").append("\r\n").append("--").append(str4).append("\r\n").toString());
            StringBuilder sbAppend2 = new StringBuilder().append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");
            f1.c();
            stringBuffer.append(sbAppend2.append("").append("\r\n").append("--").append(str4).append("\r\n").toString());
            stringBuffer.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + j + "\r\n--" + str4 + "\r\n");
            if (i == 2 || i == 3 || (i == 0 && map != null && !map.isEmpty())) {
                dataOutputStream.write(stringBuffer.toString().getBytes());
                a(dataOutputStream, map);
                stringBuffer.setLength(0);
            }
            StringBuilder sbAppend3 = new StringBuilder().append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");
            f1.c();
            stringBuffer.append(sbAppend3.append("").append("\r\n").append("--").append(str4).append("\r\n").toString());
            dataOutputStream.write(stringBuffer.toString().getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
            if (responseCode == 200) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return true;
            }
            try {
                dataOutputStream.close();
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream2 = dataOutputStream;
            try {
                th.printStackTrace();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                return false;
            } finally {
            }
        }
    }

    public static boolean a(String str, File file, int i, String str2, String str3, String str4, long j, HashMap map) {
        HttpURLConnection httpURLConnection;
        DataOutputStream dataOutputStream;
        if (TextUtils.isEmpty(str) || file == null || !file.exists()) {
            throw new IllegalArgumentException("url and file not be null ");
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setReadTimeout(30000);
                httpURLConnection.setConnectTimeout(30000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("connection", "keep-alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + b);
                Map<String, String> map2 = a;
                if (map2 != null && !map2.isEmpty()) {
                    for (Map.Entry<String, String> entry : a.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                            httpURLConnection.setRequestProperty(key, value);
                        }
                    }
                }
                httpURLConnection.connect();
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            String str5 = b;
            stringBuffer.append(str5);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"status\"\r\n\r\n" + i + "\r\n--" + str5 + "\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"cid\"\r\n\r\n" + str3 + "\r\n--" + str5 + "\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"err_msg\"\r\n\r\n" + str4 + "\r\n--" + str5 + "\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"operate_time\"\r\n\r\n" + j + "\r\n--" + str5 + "\r\n");
            StringBuilder sbAppend = new StringBuilder().append("Content-Disposition: form-data; name=\"aid\"\r\n\r\n");
            f1.c();
            stringBuffer.append(sbAppend.append("").append("\r\n").append("--").append(str5).append("\r\n").toString());
            StringBuilder sbAppend2 = new StringBuilder().append("Content-Disposition: form-data; name=\"update_version_code\"\r\n\r\n");
            f1.c();
            stringBuffer.append(sbAppend2.append("").append("\r\n").append("--").append(str5).append("\r\n").toString());
            StringBuilder sbAppend3 = new StringBuilder().append("Content-Disposition: form-data; name=\"uid\"\r\n\r\n");
            f1.c();
            stringBuffer.append(sbAppend3.append("").append("\r\n").append("--").append(str5).append("\r\n").toString());
            if (i == 2 || i == 3 || (i == 0 && map != null && !map.isEmpty())) {
                dataOutputStream.write(stringBuffer.toString().getBytes());
                a(dataOutputStream, map);
                stringBuffer.setLength(0);
            }
            stringBuffer.append("Content-Disposition: form-data; name=\"file\"; filetype=\"" + str2 + "\"; filename=\"" + file.getName() + "\"\r\n");
            stringBuffer.append("Content-Type: text/plain\r\n");
            stringBuffer.append("\r\n");
            dataOutputStream.write(stringBuffer.toString().getBytes());
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int i2 = fileInputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                dataOutputStream.write(bArr, 0, i2);
            }
            fileInputStream.close();
            dataOutputStream.write("\r\n".getBytes());
            dataOutputStream.write(("--" + b + "--\r\n").getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            int responseCode = httpURLConnection.getResponseCode();
            httpURLConnection.disconnect();
            if (responseCode == 200) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return true;
            }
            try {
                dataOutputStream.close();
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            return false;
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream2 = dataOutputStream;
            try {
                th.printStackTrace();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    } catch (Throwable th6) {
                        th6.printStackTrace();
                    }
                }
                return false;
            } finally {
            }
        }
    }

    public static void a(DataOutputStream dataOutputStream, HashMap<String, String> map) throws IOException {
        if (f1.c().d != null && f1.c().d.size() != 0) {
            dataOutputStream.write(("Content-Disposition: form-data; name=\"fileCommon\"; filetype=\"command_commonparams\"; filename=\"common_params.txt\"\r\nContent-Type: text/plain\r\n\r\n").getBytes());
            dataOutputStream.write(i.a(f1.c().d).getBytes());
            dataOutputStream.write("\r\n".getBytes());
            dataOutputStream.write(new StringBuilder().append("--").append(b).append("\r\n").toString().getBytes());
            dataOutputStream.flush();
        }
        if (map == null || map.size() == 0) {
            return;
        }
        dataOutputStream.write(("Content-Disposition: form-data; name=\"fileSpecific\"; filetype=\"command_specificparams\"; filename=\"specific_params.txt\"\r\nContent-Type: text/plain\r\n\r\n").getBytes());
        dataOutputStream.write(i.a(map).getBytes());
        dataOutputStream.write("\r\n".getBytes());
        dataOutputStream.write(new StringBuilder().append("--").append(b).append("\r\n").toString().getBytes());
        dataOutputStream.flush();
    }
}
