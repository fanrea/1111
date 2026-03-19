package com.tachikoma.lottie.network;

import android.content.Context;
import android.support.v4.d.i;
import com.tachikoma.lottie.c;
import com.tachikoma.lottie.e;
import com.tachikoma.lottie.f;
import com.tachikoma.lottie.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b {
    private final Context Nd;
    private final a Ne;
    private final String url;

    public static l<e> f(Context context, String str) {
        return new b(context, str).lQ();
    }

    private b(Context context, String str) {
        this.Nd = context.getApplicationContext();
        this.url = str;
        this.Ne = new a(this.Nd, str);
    }

    private l<e> lQ() {
        e eVarLR = lR();
        if (eVarLR != null) {
            return new l<>(eVarLR);
        }
        c.Q("Animation for " + this.url + " not found in cache. Fetching from network.");
        return lS();
    }

    private e lR() {
        l<e> lVarA;
        i<FileExtension, InputStream> iVarLP = this.Ne.lP();
        if (iVarLP == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) iVarLP.first;
        InputStream inputStream = (InputStream) iVarLP.second;
        if (fileExtension == FileExtension.ZIP) {
            lVarA = f.b(new ZipInputStream(inputStream), this.url);
        } else {
            lVarA = f.a(inputStream, this.url);
        }
        if (lVarA.getValue() != null) {
            return lVarA.getValue();
        }
        return null;
    }

    private l<e> lS() {
        try {
            return lT();
        } catch (IOException e) {
            return new l<>((Throwable) e);
        }
    }

    private l lT() throws IOException {
        FileExtension fileExtension;
        l<e> lVarB;
        c.Q("Fetching " + this.url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.url).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        if (httpURLConnection.getErrorStream() != null || httpURLConnection.getResponseCode() != 200) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    return new l((Throwable) new IllegalArgumentException("Unable to fetch " + this.url + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + ((Object) sb)));
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
                c.Q("Handling zip response.");
                fileExtension = FileExtension.ZIP;
                lVarB = f.b(new ZipInputStream(new FileInputStream(this.Ne.a(httpURLConnection.getInputStream(), fileExtension))), this.url);
            } else {
                c.Q("Received json response.");
                fileExtension = FileExtension.JSON;
                lVarB = f.a(new FileInputStream(new File(this.Ne.a(httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.url);
            }
            if (lVarB.getValue() != null) {
                this.Ne.a(fileExtension);
            }
            StringBuilder sb2 = new StringBuilder("Completed fetch from network. Success: ");
            sb2.append(lVarB.getValue() != null);
            c.Q(sb2.toString());
            return lVarB;
        }
    }
}
