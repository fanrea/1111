package com.fendasz.moku.planet.utils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DensityUtils {
    public static String getPrintSize(long j) {
        if (j < 1024) {
            return j + "B";
        }
        long j2 = j / 1024;
        if (j2 < 1024) {
            return j2 + "KB";
        }
        long j3 = j2 / 1024;
        if (j3 < 1024) {
            long j4 = j3 * 100;
            return (j4 / 100) + "." + (j4 % 100) + "MB";
        }
        long j5 = (j3 * 100) / 1024;
        return (j5 / 100) + "." + (j5 % 100) + "GB";
    }

    public static String formatTime(Long l) {
        Integer num = 1000;
        Integer numValueOf = Integer.valueOf(Integer.valueOf(Integer.valueOf(num.intValue() * 60).intValue() * 60).intValue() * 24);
        Long lValueOf = Long.valueOf(l.longValue() / numValueOf.intValue());
        Long lValueOf2 = Long.valueOf((l.longValue() - (lValueOf.longValue() * numValueOf.intValue())) / r2.intValue());
        Long lValueOf3 = Long.valueOf(((l.longValue() - (lValueOf.longValue() * numValueOf.intValue())) - (lValueOf2.longValue() * r2.intValue())) / r1.intValue());
        Long lValueOf4 = Long.valueOf((((l.longValue() - (lValueOf.longValue() * numValueOf.intValue())) - (lValueOf2.longValue() * r2.intValue())) - (lValueOf3.longValue() * r1.intValue())) / num.intValue());
        Long.valueOf((((l.longValue() - (lValueOf.longValue() * numValueOf.intValue())) - (lValueOf2.longValue() * r2.intValue())) - (lValueOf3.longValue() * r1.intValue())) - (lValueOf4.longValue() * num.intValue()));
        StringBuffer stringBuffer = new StringBuffer();
        if (lValueOf.longValue() > 0) {
            stringBuffer.append(lValueOf + "天");
        }
        if (lValueOf2.longValue() > 0) {
            stringBuffer.append(lValueOf2 + "时");
        }
        if (lValueOf3.longValue() > 0) {
            stringBuffer.append(lValueOf3 + "分");
        }
        if (lValueOf4.longValue() > 0) {
            stringBuffer.append(lValueOf4 + "秒");
        }
        return stringBuffer.toString();
    }
}
