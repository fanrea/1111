package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    private static int getMatchScore(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    private Font findBaseFont(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int matchScore = getMatchScore(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int matchScore2 = getMatchScore(fontStyle, font2.getStyle());
            if (matchScore2 < matchScore) {
                font = font2;
                matchScore = matchScore2;
            }
        }
        return font;
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    protected Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c A[Catch: IOException -> 0x0061, Exception -> 0x0081, PHI: r4
  0x001c: PHI (r4v5 android.graphics.fonts.FontFamily$Builder) = (r4v3 android.graphics.fonts.FontFamily$Builder), (r4v1 android.graphics.fonts.FontFamily$Builder) binds: [B:19:0x0052, B:8:0x001a] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #1 {IOException -> 0x0061, blocks: (B:6:0x000d, B:9:0x001c, B:27:0x0060, B:26:0x005d), top: B:37:0x000d }] */
    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r10, android.os.CancellationSignal r11, androidx.core.provider.FontsContractCompat.FontInfo[] r12, int r13) throws java.io.IOException {
        /*
            r9 = this;
            android.content.ContentResolver r10 = r10.getContentResolver()
            r0 = 0
            int r1 = r12.length     // Catch: java.lang.Exception -> L81
            r2 = 0
            r4 = r0
            r3 = r2
        L9:
            if (r3 >= r1) goto L64
            r5 = r12[r3]     // Catch: java.lang.Exception -> L81
            android.net.Uri r6 = r5.getUri()     // Catch: java.io.IOException -> L61 java.lang.Exception -> L81
            java.lang.String r7 = "r"
            android.os.ParcelFileDescriptor r6 = r10.openFileDescriptor(r6, r7, r11)     // Catch: java.io.IOException -> L61 java.lang.Exception -> L81
            if (r6 != 0) goto L20
            if (r6 == 0) goto L61
        L1c:
            r6.close()     // Catch: java.io.IOException -> L61 java.lang.Exception -> L81
            goto L61
        L20:
            android.graphics.fonts.Font$Builder r7 = new android.graphics.fonts.Font$Builder     // Catch: java.lang.Throwable -> L55
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L55
            int r8 = r5.getWeight()     // Catch: java.lang.Throwable -> L55
            android.graphics.fonts.Font$Builder r7 = r7.setWeight(r8)     // Catch: java.lang.Throwable -> L55
            boolean r8 = r5.isItalic()     // Catch: java.lang.Throwable -> L55
            if (r8 == 0) goto L35
            r8 = 1
            goto L36
        L35:
            r8 = r2
        L36:
            android.graphics.fonts.Font$Builder r7 = r7.setSlant(r8)     // Catch: java.lang.Throwable -> L55
            int r5 = r5.getTtcIndex()     // Catch: java.lang.Throwable -> L55
            android.graphics.fonts.Font$Builder r5 = r7.setTtcIndex(r5)     // Catch: java.lang.Throwable -> L55
            android.graphics.fonts.Font r5 = r5.build()     // Catch: java.lang.Throwable -> L55
            if (r4 != 0) goto L4f
            android.graphics.fonts.FontFamily$Builder r7 = new android.graphics.fonts.FontFamily$Builder     // Catch: java.lang.Throwable -> L55
            r7.<init>(r5)     // Catch: java.lang.Throwable -> L55
            r4 = r7
            goto L52
        L4f:
            r4.addFont(r5)     // Catch: java.lang.Throwable -> L55
        L52:
            if (r6 == 0) goto L61
            goto L1c
        L55:
            r5 = move-exception
            if (r6 == 0) goto L60
            r6.close()     // Catch: java.lang.Throwable -> L5c
            goto L60
        L5c:
            r6 = move-exception
            r5.addSuppressed(r6)     // Catch: java.io.IOException -> L61 java.lang.Exception -> L81
        L60:
            throw r5     // Catch: java.io.IOException -> L61 java.lang.Exception -> L81
        L61:
            int r3 = r3 + 1
            goto L9
        L64:
            if (r4 != 0) goto L67
            return r0
        L67:
            android.graphics.fonts.FontFamily r10 = r4.build()     // Catch: java.lang.Exception -> L81
            android.graphics.Typeface$CustomFallbackBuilder r11 = new android.graphics.Typeface$CustomFallbackBuilder     // Catch: java.lang.Exception -> L81
            r11.<init>(r10)     // Catch: java.lang.Exception -> L81
            android.graphics.fonts.Font r10 = r9.findBaseFont(r10, r13)     // Catch: java.lang.Exception -> L81
            android.graphics.fonts.FontStyle r10 = r10.getStyle()     // Catch: java.lang.Exception -> L81
            android.graphics.Typeface$CustomFallbackBuilder r10 = r11.setStyle(r10)     // Catch: java.lang.Exception -> L81
            android.graphics.Typeface r10 = r10.build()     // Catch: java.lang.Exception -> L81
            return r10
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi29Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) throws IOException {
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
                try {
                    Font fontBuild = new Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight()).setSlant(fontFileResourceEntry.isItalic() ? 1 : 0).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(findBaseFont(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatBaseImpl
    Typeface createWeightStyle(Context context, Typeface typeface, int i, boolean z) {
        return Typeface.create(typeface, i, z);
    }
}
