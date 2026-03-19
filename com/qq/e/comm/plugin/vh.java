package com.qq.e.comm.plugin;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class vh {
    private static final Pattern f = Pattern.compile("[R,r]ange:[ ]?bytes=(\\d*)-");
    private static final Pattern g = Pattern.compile("GET /(.*)%26sdk_ad_type%3D");
    private static final Pattern h = Pattern.compile("%26sdk_ad_type%3D(\\d+)%26video_view_hashcode%3D");
    private static final Pattern i = Pattern.compile("%26video_view_hashcode%3D(\\d+)");
    public final String a;
    final long b;
    final boolean c;
    public final int d;
    public final String e;

    public static vh a(InputStream inputStream) throws IOException, vu {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, d6.a));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                return new vh(sb.toString());
            }
            sb.append(line);
            sb.append('\n');
        }
    }

    private long b(String str) {
        Matcher matcher = f.matcher(str);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }
        return -1L;
    }

    private String c(String str) {
        Matcher matcher = g.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: url not found!");
    }

    private String d(String str) {
        Matcher matcher = i.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: Video hashcode not found!");
    }

    public String toString() {
        return "GetRequest{rangeOffset=" + this.b + ", partial=" + this.c + ", uri=" + this.a + ", videoViewHashcode=" + this.e + ", adType='" + this.d + "'}";
    }

    private int a(String str) {
        Matcher matcher = h.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        throw new IllegalArgumentException("Invalid request `" + str + "`: ad type not found!");
    }

    private vh(String str) throws vu {
        lu.a(str);
        long jB = b(str);
        this.b = Math.max(0L, jB);
        this.c = jB >= 0;
        this.a = c(str);
        this.d = a(str);
        this.e = d(str);
    }
}
