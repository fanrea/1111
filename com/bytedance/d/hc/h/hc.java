package com.bytedance.d.hc.h;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.bytedance.d.hc.gb;
import com.bytedance.d.hc.gb.tc;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static boolean d = false;
    private static b hc;

    public static boolean d() {
        return true;
    }

    public static boolean hc() {
        return true;
    }

    public static an d(long j, String str, byte[] bArr, d dVar, String str2, boolean z) throws IOException {
        if (str == null) {
            return new an(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str3 = null;
        if (d.GZIP == dVar && length > 128) {
            bArr = hc(bArr);
            str3 = "gzip";
        } else if (d.DEFLATER == dVar && length > 128) {
            bArr = d(bArr);
            str3 = "deflate";
        }
        String str4 = str3;
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new an(202);
        }
        if (z) {
            byte[] bArrA = TTEncryptUtils.a(bArr2, bArr2.length);
            if (bArrA != null) {
                if (TextUtils.isEmpty(new URL(str).getQuery())) {
                    if (!str.endsWith("?")) {
                        str = str + "?";
                    }
                } else if (!str.endsWith(a.n)) {
                    str = str + a.n;
                }
                str = str + "encrypt=true";
                str2 = "application/octet-stream;tt-data=a";
                bArr2 = bArrA;
            }
            return d(str, bArr2, str2, str4, "POST", true, true);
        }
        return d(str, bArr2, str2, str4, "POST", true, false);
    }

    private static byte[] d(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] hc(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            try {
                tc.hc(th);
                gZIPOutputStream.close();
                return null;
            } catch (Throwable th2) {
                gZIPOutputStream.close();
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0056 A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005b A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0061 A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068 A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0074 A[Catch: all -> 0x004d, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f6 A[Catch: all -> 0x004d, TRY_ENTER, TryCatch #8 {all -> 0x004d, blocks: (B:12:0x0029, B:14:0x002f, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x0056, B:26:0x0061, B:28:0x0068, B:29:0x006d, B:31:0x0074, B:33:0x0079, B:37:0x008b, B:42:0x0093, B:43:0x0096, B:44:0x0097, B:46:0x009f, B:65:0x00d7, B:70:0x00f6, B:71:0x00fd, B:24:0x005b), top: B:103:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.bytedance.d.hc.h.an d(java.lang.String r5, byte[] r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.d.hc.h.hc.d(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, boolean, boolean):com.bytedance.d.hc.h.an");
    }

    private static an b(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new an(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                return new an(0, jSONObject);
            }
            return new an(204, str);
        } catch (JSONException unused) {
            return new an(204, str);
        }
    }

    public static an d(String str, String str2) {
        return d(str, str2, d());
    }

    public static String d(Map map) {
        return gb.u().hc();
    }

    public static String hc(Map map) {
        return gb.u().b();
    }

    public static an d(u uVar) {
        if (uVar == null) {
            return new an(201);
        }
        try {
            return d(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, uVar.d(), uVar.b(), d.GZIP, MediaTypeUtils.APPLICATION_JSON, uVar.hc());
        } catch (Throwable th) {
            tc.hc(th);
            return new an(207, th);
        }
    }

    public static an d(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                return d(PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE, str, str2.getBytes(), d.GZIP, MediaTypeUtils.APPLICATION_JSON, z);
            }
            return new an(201);
        } catch (Throwable th) {
            tc.hc(th);
            return new an(207, th);
        }
    }

    private static byte[] d(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    com.bytedance.d.hc.gb.an.d(byteArrayOutputStream);
                }
            }
        }
    }

    public enum d {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int c;

        d(int i) {
            this.c = i;
        }
    }

    /* renamed from: com.bytedance.d.hc.h.hc$hc, reason: collision with other inner class name */
    public enum EnumC0189hc {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);

        final int h;

        EnumC0189hc(int i) {
            this.h = i;
        }
    }
}
