package okhttp3.internal.b;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class d {
    private static final ThreadLocal<DateFormat> Ba = new ThreadLocal<DateFormat>() { // from class: okhttp3.internal.b.d.1
        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ DateFormat initialValue() {
            return gD();
        }

        private static DateFormat gD() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(okhttp3.internal.c.zF);
            return simpleDateFormat;
        }
    };
    private static final String[] Bb;
    private static final DateFormat[] Bc;

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        Bb = strArr;
        Bc = new DateFormat[strArr.length];
    }

    public static Date parse(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = Ba.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        synchronized (Bb) {
            int length = Bb.length;
            for (int i = 0; i < length; i++) {
                DateFormat simpleDateFormat = Bc[i];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(Bb[i], Locale.US);
                    simpleDateFormat.setTimeZone(okhttp3.internal.c.zF);
                    Bc[i] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            return null;
        }
    }

    public static String format(Date date) {
        return Ba.get().format(date);
    }
}
