package com.pangrowth.adclog;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class b0 {
    public final String a;
    public HttpURLConnection b;
    public DataOutputStream c;
    public GZIPOutputStream d;

    public b0(String str, String str2, boolean z) throws ProtocolException {
        String str3 = "AAA" + System.currentTimeMillis() + "AAA";
        this.a = str3;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.b = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.b.setDoOutput(true);
        this.b.setDoInput(true);
        this.b.setRequestMethod("POST");
        this.b.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + str3);
        if (!z) {
            this.c = new DataOutputStream(this.b.getOutputStream());
        } else {
            this.b.setRequestProperty("Content-Encoding", "gzip");
            this.d = new GZIPOutputStream(this.b.getOutputStream());
        }
    }

    public String a() throws IOException {
        ArrayList arrayList = new ArrayList();
        this.c.write(("\r\n--" + this.a + "--\r\n").getBytes());
        this.c.flush();
        this.c.close();
        int responseCode = this.b.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            arrayList.add(line);
        }
        bufferedReader.close();
        this.b.disconnect();
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return sb.toString();
    }

    public void a(String str, File file, Map<String, String> map) throws IOException {
        String name = file.getName();
        StringBuilder sb = new StringBuilder(100);
        sb.append("--").append(this.a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"; filename=\"").append(name).append("\"");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("; ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
        }
        sb.append("\r\n").append("Content-Transfer-Encoding: binary").append("\r\n").append("\r\n");
        this.c.write(sb.toString().getBytes());
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[8192];
        while (true) {
            int i = fileInputStream.read(bArr);
            if (i == -1) {
                fileInputStream.close();
                this.c.write("\r\n".getBytes());
                this.c.flush();
                return;
            }
            this.c.write(bArr, 0, i);
        }
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder(100);
        sb.append("--").append(this.a).append("\r\n").append("Content-Disposition: form-data; name=\"").append(str).append("\"").append("\r\n").append("Content-Type: text/plain; charset=").append("UTF-8").append("\r\n").append("\r\n").append(str2).append("\r\n");
        try {
            this.c.write(sb.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
