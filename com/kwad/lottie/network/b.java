package com.kwad.lottie.network;

import android.content.Context;
import androidx.core.util.Pair;
import com.kwad.lottie.c;
import com.kwad.lottie.d;
import com.kwad.lottie.e;
import com.kwad.lottie.j;
import com.kwad.lottie.k;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static a bpn;
    private final Context bpl;
    private final com.kwad.lottie.network.a bpm;
    private final String url;

    public interface a {
        void b(HttpURLConnection httpURLConnection);
    }

    public static void a(a aVar) {
        bpn = aVar;
    }

    public static k<d> x(Context context, String str) {
        return new b(context, str).St();
    }

    private b(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.bpl = applicationContext;
        this.url = str;
        this.bpm = new com.kwad.lottie.network.a(applicationContext, str);
    }

    private k<d> St() {
        return new k<>(new Callable<j<d>>() { // from class: com.kwad.lottie.network.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: Ql, reason: merged with bridge method [inline-methods] */
            public j<d> call() {
                return b.this.Su();
            }
        });
    }

    public final j<d> Su() {
        d dVarSv = Sv();
        if (dVarSv != null) {
            return new j<>(dVarSv);
        }
        c.de("Animation for " + this.url + " not found in cache. Fetching from network.");
        return Sw();
    }

    private d Sv() {
        j<d> jVarA;
        Pair<FileExtension, InputStream> pairSs = this.bpm.Ss();
        if (pairSs == null) {
            return null;
        }
        FileExtension fileExtension = pairSs.first;
        InputStream inputStream = pairSs.second;
        if (fileExtension == FileExtension.Zip) {
            jVarA = e.a(new ZipInputStream(inputStream), this.url);
        } else {
            jVarA = e.a(inputStream, this.url);
        }
        if (jVarA.getValue() != null) {
            return jVarA.getValue();
        }
        return null;
    }

    private j<d> Sw() {
        try {
            return Sx();
        } catch (IOException e) {
            return new j<>((Throwable) e);
        }
    }

    private j Sx() throws IOException {
        FileExtension fileExtension;
        j<d> jVarA;
        c.de("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        a aVar = bpn;
        if (aVar != null) {
            aVar.b(httpURLConnection);
        }
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() != null || httpURLConnection.getResponseCode() != 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
                } else {
                    return new j((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb)));
                }
            }
        } else {
            String contentType = httpURLConnection.getContentType();
            char c = 65535;
            int iHashCode = contentType.hashCode();
            if (iHashCode != -1248325150) {
                if (iHashCode == -43840953 && contentType.equals("application/json")) {
                    c = 1;
                }
            } else if (contentType.equals("application/zip")) {
                c = 0;
            }
            if (c == 0) {
                c.de("Handling zip response.");
                fileExtension = FileExtension.Zip;
                jVarA = e.a(new ZipInputStream(new FileInputStream(this.bpm.a(httpURLConnection.getInputStream(), fileExtension))), this.url);
            } else {
                c.de("Received json response.");
                fileExtension = FileExtension.Json;
                jVarA = e.a(new FileInputStream(new File(this.bpm.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
            }
            if (jVarA.getValue() != null) {
                this.bpm.a(fileExtension);
            }
            c.de("Completed fetch from network. Success: " + (jVarA.getValue() != null));
            return jVarA;
        }
    }
}
