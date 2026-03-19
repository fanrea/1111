package com.tk.core.component.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobstat.forbes.Config;
import com.tk.core.component.text.e;
import com.tk.core.o.ac;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f {
    private static final String[] afd = {"alte-din.ttf", "AvenirNext-BoldItalic.ttf"};
    private static final FontLRUCache<String, a> afe = new FontLRUCache<>(20);

    /* synthetic */ f(byte b2) {
        this();
    }

    private f() {
    }

    static final class b {
        private static final f afo = new f(0);
    }

    public static f rh() {
        return b.afo;
    }

    public final void preload() {
        for (String str : afd) {
            if (com.tachikoma.core.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
                com.tk.core.i.a.z("FONT", str + "'s font preload from asset.");
            }
            afe.put(str, o(str, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a a(String str, int i, AssetManager assetManager, String str2, String str3, int i2) {
        a aVar = new a((byte) 0);
        Typeface typefaceA = a(str, str2, str3, i2);
        if (typefaceA == null && (typefaceA = a(str, assetManager)) == null) {
            typefaceA = co(str);
        }
        if (typefaceA == null) {
            aVar.aw(true);
            typefaceA = Typeface.create(str, i);
        }
        aVar.a(i, typefaceA);
        return aVar;
    }

    public final void a(final String str, final int i, final AssetManager assetManager, final String str2, final String str3, final int i2, final int i3, final e.a aVar) {
        final String strA = a(str, str3, i2);
        a aVar2 = afe.get(strA);
        if (com.tachikoma.core.a.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            if (aVar2 == null) {
                com.tk.core.i.a.z("FONT", str + "'s font not cached, loading... . bundleID = " + str3 + ", versionCode = " + i2);
            } else {
                com.tk.core.i.a.z("FONT", str + "'s font use cache. bundleID = " + str3 + ", versionCode = " + i2);
            }
        }
        if (aVar2 == null) {
            com.tk.core.o.p.execute(new Runnable() { // from class: com.tk.core.component.text.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    final a aVarA = f.this.a(str, i, assetManager, str2, str3, i2);
                    f.afe.put(strA, aVarA);
                    ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.text.f.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (aVar != null) {
                                aVar.a(aVarA.dW(i), false, i3);
                            }
                        }
                    });
                }
            });
        } else {
            aVar.a(aVar2.dW(i), true, i3);
        }
    }

    public final Typeface b(String str, int i, AssetManager assetManager, String str2, String str3, int i2) {
        String strA = a(str, str3, i2);
        a aVarA = afe.get(strA);
        if (aVarA == null) {
            aVarA = a(str, i, assetManager, str2, str3, i2);
            afe.put(strA, aVarA);
        }
        return aVarA.dW(i);
    }

    public final Typeface a(String str, int i, String str2, int i2) {
        a aVar = afe.get(a(str, str2, i2));
        if (aVar != null) {
            return aVar.dW(0);
        }
        return null;
    }

    public final Typeface b(String str, int i, String str2, int i2) {
        a aVar = new a((byte) 0);
        Typeface typefaceCo = co(str);
        if (typefaceCo == null) {
            aVar.aw(true);
            typefaceCo = Typeface.create(str, 0);
        }
        if (typefaceCo != null) {
            aVar.a(0, typefaceCo);
            afe.put(a(str, str2, i2), aVar);
        }
        return typefaceCo;
    }

    private static Typeface a(String str, AssetManager assetManager) {
        try {
            if (str.endsWith(".ttf") || str.endsWith(".otf")) {
                try {
                    return Typeface.createFromAsset(assetManager, "fonts/".concat(str));
                } catch (RuntimeException unused) {
                    return Typeface.createFromAsset(assetManager, str);
                }
            }
            String strConcat = str.concat(".ttf");
            try {
                try {
                    try {
                        return Typeface.createFromAsset(assetManager, "fonts/".concat(strConcat));
                    } catch (RuntimeException unused2) {
                        return Typeface.createFromAsset(assetManager, strConcat);
                    }
                } catch (RuntimeException unused3) {
                    return Typeface.createFromAsset(assetManager, strConcat);
                }
            } catch (RuntimeException unused4) {
                strConcat = str.concat(".otf");
                return Typeface.createFromAsset(assetManager, "fonts/".concat(strConcat));
            }
        } catch (RuntimeException unused5) {
            return null;
        }
        return null;
    }

    private static Typeface a(String str, String str2, String str3, int i) {
        String strConcat;
        File file;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.endsWith(".ttf") || str.endsWith(".otf")) {
            strConcat = str2.concat(str);
            file = new File(strConcat);
        } else {
            strConcat = str2.concat(str).concat(".ttf");
            file = new File(strConcat);
            if (!file.exists()) {
                strConcat = str2.concat(str).concat(".otf");
                file = new File(strConcat);
            }
        }
        if (file.exists()) {
            try {
                Typeface typefaceCreateFromFile = Typeface.createFromFile(strConcat);
                if (typefaceCreateFromFile != null) {
                    return typefaceCreateFromFile;
                }
            } catch (Throwable th) {
                com.tk.core.i.a.a("FONT", "font = " + strConcat + " bundleId = " + str3 + " versionCode = " + i, th);
            }
        }
        return null;
    }

    private static Typeface co(String str) {
        if (str.endsWith(".ttf") || str.endsWith(".otf")) {
            File fileH = d.h(com.tk.core.o.s.getContext(), str);
            if (fileH.exists()) {
                return Typeface.createFromFile(fileH.getAbsoluteFile());
            }
            return null;
        }
        File fileH2 = d.h(com.tk.core.o.s.getContext(), str.concat(".ttf"));
        if (fileH2.exists()) {
            return Typeface.createFromFile(fileH2.getAbsoluteFile());
        }
        File fileH3 = d.h(com.tk.core.o.s.getContext(), str.concat(".otf"));
        if (fileH3.exists()) {
            return Typeface.createFromFile(fileH3.getAbsoluteFile());
        }
        return null;
    }

    private a o(String str, int i) {
        a aVar = new a((byte) 0);
        Typeface typefaceA = a(str, com.tk.core.o.s.getContext().getAssets());
        if (typefaceA == null) {
            aVar.aw(true);
            typefaceA = Typeface.create(str, -1);
        }
        aVar.a(-1, typefaceA);
        return aVar;
    }

    private static String a(String str, String str2, int i) {
        for (String str3 : afd) {
            if (!str.contains(".ttf")) {
                str = str.concat(".ttf");
            }
            if (str3.equals(str)) {
                return str3;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
            sb.append(Config.replace);
            sb.append(i);
            sb.append(Config.replace);
        }
        sb.append(str);
        return sb.toString();
    }

    static class a {
        private boolean afm;
        private SparseArray<Typeface> afn;

        /* synthetic */ a(byte b) {
            this();
        }

        private a() {
            this.afn = new SparseArray<>(4);
        }

        public final Typeface dW(int i) {
            return !this.afm ? this.afn.get(0) : this.afn.get(i);
        }

        public final void aw(boolean z) {
            this.afm = true;
        }

        public final void a(int i, Typeface typeface) {
            if (!this.afm) {
                this.afn.put(0, typeface);
            } else {
                this.afn.put(i, typeface);
            }
        }
    }
}
