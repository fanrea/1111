package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ax;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class d {
    private static final Pattern bJa = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern bJb = Pattern.compile("GET /(.*) HTTP");
    public final String bJc;
    public final long bJd;
    public final boolean bJe;

    private d(String str) {
        ax.iA(str);
        long jFY = fY(str);
        this.bJd = Math.max(0L, jFY);
        this.bJe = jFY >= 0;
        this.bJc = fZ(str);
    }

    public static d c(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (!TextUtils.isEmpty(line)) {
                sb.append(line).append('\n');
            } else {
                return new d(sb.toString());
            }
        }
    }

    private static long fY(String str) {
        Matcher matcher = bJa.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private static String fZ(String str) {
        Matcher matcher = bJb.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    public final String toString() {
        return "GetRequest{rangeOffset=" + this.bJd + ", partial=" + this.bJe + ", uri='" + this.bJc + "'}";
    }
}
