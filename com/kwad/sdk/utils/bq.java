package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.pandora.common.utils.Times;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class bq {
    private static final SimpleDateFormat cnn = new SimpleDateFormat("MM/dd", Locale.US);
    private static final SimpleDateFormat cno = new SimpleDateFormat("yyyy/MM/dd", Locale.US);
    private static final SimpleDateFormat cnp = new SimpleDateFormat("MM月dd日", Locale.US);
    private static final SimpleDateFormat cnq = new SimpleDateFormat("yyyy年MM月dd日", Locale.US);
    private static final SimpleDateFormat cnr = new SimpleDateFormat("HH:mm", Locale.US);
    private static final SimpleDateFormat cns = new SimpleDateFormat("MM-dd", Locale.US);
    private static final SimpleDateFormat cnt = new SimpleDateFormat(Times.YYYY_MM_DD, Locale.US);

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || ILogConst.CACHE_PLAY_REASON_NULL.equalsIgnoreCase(str);
    }

    public static boolean iI(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static String iJ(String str) {
        return !TextUtils.isEmpty(str) ? str.trim() : "";
    }

    public static String iK(String str) {
        return !TextUtils.isEmpty(str) ? str.trim().replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1") : "";
    }

    public static String b(long j, String str) {
        return j <= 0 ? str : bB(j);
    }

    public static String bB(long j) {
        if (j <= 9999) {
            return String.valueOf(j);
        }
        return j < 10000000 ? ah.format("%.1fw", Double.valueOf(new BigDecimal(String.valueOf(j / 10000.0d)).setScale(1, 1).doubleValue())) : "999.9w";
    }

    public static String bC(long j) {
        if (j <= 9999) {
            return String.valueOf(j);
        }
        return j < 10000000 ? ah.format("%.1f万", Double.valueOf(new BigDecimal(String.valueOf(j / 10000.0d)).setScale(1, 1).doubleValue())) : "999.9万";
    }

    public static String bD(long j) {
        if (j <= 9999) {
            return String.valueOf(j);
        }
        return j < 100000000 ? ah.format("%.1fw", Double.valueOf(new BigDecimal(String.valueOf(j / 10000.0d)).setScale(1, 1).doubleValue())) : ah.format("%.1f亿", Double.valueOf(new BigDecimal(String.valueOf(j / 1.0E8d)).setScale(1, 1).doubleValue()));
    }

    private static String u(long j, long j2) {
        if (j < 0) {
            return "";
        }
        long jAbs = Math.abs(j2 - j);
        if (jAbs < 60000) {
            return "刚刚";
        }
        if (jAbs < 3600000) {
            return ah.format("%d分钟前", Integer.valueOf((int) (jAbs / 60000)));
        }
        if (jAbs < 86400000) {
            return ah.format("%d小时前", Integer.valueOf((int) (jAbs / 3600000)));
        }
        if (jAbs < 604800000) {
            return ah.format("%d天前", Integer.valueOf((int) (jAbs / 86400000)));
        }
        if (v(j2, j)) {
            return bE(j);
        }
        return bF(j);
    }

    private static boolean v(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        calendar.setTimeInMillis(j2);
        return i == calendar.get(1);
    }

    private static String bE(long j) {
        String str;
        SimpleDateFormat simpleDateFormat = cnn;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date(j));
        }
        return str;
    }

    private static String bF(long j) {
        String str;
        SimpleDateFormat simpleDateFormat = cno;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date(j));
        }
        return str;
    }

    private static String bG(long j) {
        String str;
        SimpleDateFormat simpleDateFormat = cnr;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date(j));
        }
        return str;
    }

    private static String bH(long j) {
        String str;
        SimpleDateFormat simpleDateFormat = cns;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date(j));
        }
        return str;
    }

    private static String bI(long j) {
        String str;
        SimpleDateFormat simpleDateFormat = cnt;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date(j));
        }
        return str;
    }

    public static String bJ(long j) {
        if (j < 0) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAbs = Math.abs(jCurrentTimeMillis - j);
        return (jAbs < 604800000 || jAbs >= 691200000) ? u(j, jCurrentTimeMillis) : "一周前";
    }

    public static String bK(long j) {
        if (j <= 0) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jAbs = Math.abs(jCurrentTimeMillis - j);
        long rawOffset = (jCurrentTimeMillis - ((Calendar.getInstance().getTimeZone().getRawOffset() + jCurrentTimeMillis) % 86400000)) - 86400000;
        if (jAbs < 60000) {
            return "刚刚";
        }
        if (jAbs < 3600000) {
            return ah.format("%d分钟前", Integer.valueOf((int) (jAbs / 60000)));
        }
        if (jAbs < 86400000) {
            return ah.format("%d小时前", Integer.valueOf((int) (jAbs / 3600000)));
        }
        if (j >= rawOffset) {
            return ah.format("昨天%s", bG(j));
        }
        if (v(jCurrentTimeMillis, j)) {
            return bH(j);
        }
        return bI(j);
    }

    public static String bL(long j) {
        if (j <= 0) {
            return "";
        }
        if (v(System.currentTimeMillis(), j)) {
            return bH(j);
        }
        return bI(j);
    }

    public static String aF(String str, String str2) {
        return TextUtils.isEmpty(str) ? "" : TextUtils.isEmpty(str2) ? str : str.replace(str2, "");
    }

    public static String bM(long j) {
        BigDecimal bigDecimal = new BigDecimal(j);
        if (j <= 0) {
            return "";
        }
        if (j < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return j + " 播放";
        }
        if (j < 100000000) {
            return bigDecimal.divide(new BigDecimal(10000)).setScale(1, 4).doubleValue() + "w 播放";
        }
        return bigDecimal.divide(new BigDecimal(100000000)).setScale(1, 4).doubleValue() + "亿 播放";
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }
}
