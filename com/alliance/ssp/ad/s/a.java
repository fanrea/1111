package com.alliance.ssp.ad.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import com.alliance.ssp.ad.s.b;
import java.io.File;

/* compiled from: DiskCache.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class a implements c {
    public b a;

    public a(Context context) {
        a(context);
    }

    public final void a(Context context) {
        int i;
        try {
            File fileA = a(context, "com.alliance.ssp.ad.image");
            if (fileA != null) {
                if (!fileA.exists()) {
                    fileA.mkdirs();
                }
                try {
                    i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                } catch (Exception e) {
                    e.printStackTrace();
                    i = 1;
                }
                this.a = b.a(fileA, i, 1, 104857600L);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final File a(Context context, String str) {
        String path;
        if ((com.component.c.c.a.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && context.getExternalCacheDir() != null) {
            path = context.getExternalCacheDir().getPath();
        } else {
            path = context.getCacheDir().getPath();
        }
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return new File(com.alliance.ssp.ad.a.b.a(path).append(File.separator).append(str).toString());
    }

    @Override // com.alliance.ssp.ad.s.c
    public Bitmap a(String str) {
        try {
            String strA = com.alliance.ssp.ad.o.c.a(str);
            b bVar = this.a;
            b.d dVarB = bVar != null ? bVar.b(strA) : null;
            if (dVarB != null) {
                return BitmapFactory.decodeStream(dVarB.a(0));
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0044 -> B:41:0x0056). Please report as a decompilation issue!!! */
    @Override // com.alliance.ssp.ad.s.c
    public void a(String str, Bitmap bitmap) {
        try {
            if (!TextUtils.isEmpty(str) && this.a != null) {
                String strA = com.alliance.ssp.ad.o.c.a(str);
                b bVar = this.a;
                b.C0097b c0097bA = null;
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    try {
                        c0097bA = bVar.a(strA);
                        if (c0097bA != null) {
                            if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, c0097bA.a(0))) {
                                c0097bA.b();
                            }
                        }
                        bVar.b();
                    } catch (Exception e2) {
                        if (c0097bA != null) {
                            try {
                                c0097bA.a();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        e2.printStackTrace();
                        bVar.b();
                    }
                } finally {
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
