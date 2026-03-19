package lkxssdk.o;

import com.google.zxing.common.StringUtils;
import java.nio.charset.Charset;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class g {
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final boolean e;

    static {
        Charset charsetDefaultCharset = Charset.defaultCharset();
        a = charsetDefaultCharset;
        Charset charsetForName = Charset.forName(StringUtils.SHIFT_JIS);
        b = charsetForName;
        c = Charset.forName(StringUtils.GB2312);
        Charset charsetForName2 = Charset.forName("EUC_JP");
        d = charsetForName2;
        e = charsetForName.equals(charsetDefaultCharset) || charsetForName2.equals(charsetDefaultCharset);
    }
}
