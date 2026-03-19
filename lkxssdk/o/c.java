package lkxssdk.o;

import com.fendasz.moku.planet.utils.thirdparty.codec.CharEncoding;
import com.google.zxing.common.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public enum c {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, CharEncoding.ISO_8859_1),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, CharEncoding.UTF_16BE, "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, CharEncoding.US_ASCII),
    Big5(new int[]{28}, new String[0]),
    GB18030(29, StringUtils.GB2312, "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");

    public static final Map<Integer, c> w = new HashMap();
    public static final Map<String, c> x = new HashMap();
    public final String[] A;
    public final int[] z;

    static {
        c[] cVarArrValues = values();
        for (int i = 0; i < 22; i++) {
            c cVar = cVarArrValues[i];
            for (int i2 : cVar.z) {
                w.put(Integer.valueOf(i2), cVar);
            }
            x.put(cVar.name(), cVar);
            for (String str : cVar.A) {
                x.put(str, cVar);
            }
        }
    }

    c(int i, String... strArr) {
        this.z = new int[]{i};
        this.A = strArr;
    }

    c(int[] iArr, String... strArr) {
        this.z = iArr;
        this.A = strArr;
    }
}
