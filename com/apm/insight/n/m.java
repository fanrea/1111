package com.apm.insight.n;

import com.bytedance.apm.common.utility.NetworkUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class m extends b {
    private final HttpURLConnection f;

    public m(String str, String str2, Map<String, String> map, boolean z) throws ProtocolException {
        super(str, str2, map, z);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f = httpURLConnection;
        NetworkUtils.setupSSLFactory(httpURLConnection);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.a);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (!z) {
            this.d = new g(this.f.getOutputStream());
        } else {
            this.f.setRequestProperty("Content-Encoding", "gzip");
            this.e = new r(this.f.getOutputStream());
        }
    }

    @Override // com.apm.insight.n.b, com.apm.insight.n.j
    public String a() throws IOException {
        super.a();
        ArrayList arrayList = new ArrayList();
        int responseCode = this.f.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Server returned non-OK status: " + responseCode);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f.getInputStream()));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            arrayList.add(line);
        }
        bufferedReader.close();
        this.f.disconnect();
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return sb.toString();
    }
}
