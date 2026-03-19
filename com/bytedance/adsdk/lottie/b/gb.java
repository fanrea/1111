package com.bytedance.adsdk.lottie.b;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.lottie.mq;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class gb {
    private final h d;
    private final an hc;

    public gb(h hVar, an anVar) {
        this.d = hVar;
        this.hc = anVar;
    }

    public mq<com.bytedance.adsdk.lottie.an> d(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.an anVarHc = hc(context, str, str2);
        if (anVarHc != null) {
            return new mq<>(anVarHc);
        }
        com.bytedance.adsdk.lottie.u.u.d("Animation for " + str + " not found in cache. Fetching from network.");
        return b(context, str, str2);
    }

    private com.bytedance.adsdk.lottie.an hc(Context context, String str, String str2) {
        h hVar;
        Pair<b, InputStream> pairD;
        mq<com.bytedance.adsdk.lottie.an> mqVarHc;
        if (str2 == null || (hVar = this.d) == null || (pairD = hVar.d(str)) == null) {
            return null;
        }
        b bVar = (b) pairD.first;
        InputStream inputStream = (InputStream) pairD.second;
        if (bVar == b.ZIP) {
            mqVarHc = com.bytedance.adsdk.lottie.h.d(context, new ZipInputStream(inputStream), str2);
        } else {
            mqVarHc = com.bytedance.adsdk.lottie.h.hc(inputStream, str2);
        }
        if (mqVarHc.d() != null) {
            return mqVarHc.d();
        }
        return null;
    }

    private mq<com.bytedance.adsdk.lottie.an> b(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.u.u.d("Fetching " + str);
        c cVar = null;
        try {
            try {
                c cVarD = this.hc.d(str);
                if (!cVarD.d()) {
                    mq<com.bytedance.adsdk.lottie.an> mqVar = new mq<>(new IllegalArgumentException(cVarD.c()));
                    if (cVarD != null) {
                        try {
                            cVarD.close();
                        } catch (IOException e) {
                            com.bytedance.adsdk.lottie.u.u.d("LottieFetchResult close failed ", e);
                        }
                    }
                    return mqVar;
                }
                mq<com.bytedance.adsdk.lottie.an> mqVarD = d(context, str, cVarD.hc(), cVarD.b(), str2);
                com.bytedance.adsdk.lottie.u.u.d("Completed fetch from network. Success: " + (mqVarD.d() != null));
                if (cVarD != null) {
                    try {
                        cVarD.close();
                    } catch (IOException e2) {
                        com.bytedance.adsdk.lottie.u.u.d("LottieFetchResult close failed ", e2);
                    }
                }
                return mqVarD;
            } catch (Exception e3) {
                mq<com.bytedance.adsdk.lottie.an> mqVar2 = new mq<>(e3);
                if (0 != 0) {
                    try {
                        cVar.close();
                    } catch (IOException e4) {
                        com.bytedance.adsdk.lottie.u.u.d("LottieFetchResult close failed ", e4);
                    }
                }
                return mqVar2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cVar.close();
                } catch (IOException e5) {
                    com.bytedance.adsdk.lottie.u.u.d("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    private mq<com.bytedance.adsdk.lottie.an> d(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        mq<com.bytedance.adsdk.lottie.an> mqVarD;
        b bVar;
        h hVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            com.bytedance.adsdk.lottie.u.u.d("Handling zip response.");
            b bVar2 = b.ZIP;
            mqVarD = d(context, str, inputStream, str3);
            bVar = bVar2;
        } else {
            com.bytedance.adsdk.lottie.u.u.d("Received json response.");
            bVar = b.JSON;
            mqVarD = d(str, inputStream, str3);
        }
        if (str3 != null && mqVarD.d() != null && (hVar = this.d) != null) {
            hVar.d(str, bVar);
        }
        return mqVarD;
    }

    private mq<com.bytedance.adsdk.lottie.an> d(Context context, String str, InputStream inputStream, String str2) throws IOException {
        h hVar;
        if (str2 == null || (hVar = this.d) == null) {
            return com.bytedance.adsdk.lottie.h.d(context, new ZipInputStream(inputStream), (String) null);
        }
        return com.bytedance.adsdk.lottie.h.d(context, new ZipInputStream(new FileInputStream(hVar.d(str, inputStream, b.ZIP))), str);
    }

    private mq<com.bytedance.adsdk.lottie.an> d(String str, InputStream inputStream, String str2) throws IOException {
        h hVar;
        if (str2 == null || (hVar = this.d) == null) {
            return com.bytedance.adsdk.lottie.h.hc(inputStream, (String) null);
        }
        return com.bytedance.adsdk.lottie.h.hc(new FileInputStream(hVar.d(str, inputStream, b.JSON).getAbsolutePath()), str);
    }
}
