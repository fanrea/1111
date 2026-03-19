package com.bytedance.msdk.core.hc;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.gb.zw;
import com.pandora.common.utils.Times;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.Period;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static final zw d = zw.d("tt_user_live_day_time", com.bytedance.msdk.core.hc.getContext());
    private static final SimpleDateFormat hc = new SimpleDateFormat(Times.YYYY_MM_DD);
    private static final Calendar b = Calendar.getInstance();

    public static void d() {
        com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "recordUserLiveDay start => enableDynamicPolicy:" + com.bytedance.msdk.core.hc.hc().r());
        if (com.bytedance.msdk.core.hc.hc().r()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strH = h();
            com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "当前日期(key)：".concat(String.valueOf(strH)));
            zw zwVar = d;
            if (zwVar.u(strH)) {
                com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "key=" + strH + "，同一天，不再重新记录");
                return;
            }
            if (TextUtils.isEmpty(zwVar.hc("start_index"))) {
                zwVar.d("start_index", strH);
                com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "START_INDEX=".concat(String.valueOf(strH)));
            }
            zwVar.d(strH, true);
            zwVar.d("user_live_times", zwVar.hc("user_live_times", 0) + 1);
            String strHc = zwVar.hc("start_index");
            if (!TextUtils.equals(strHc, strH)) {
                try {
                    SimpleDateFormat simpleDateFormat = hc;
                    Date date = simpleDateFormat.parse(strHc);
                    Date date2 = simpleDateFormat.parse(strH);
                    if (date2 == null) {
                        date2 = new Date();
                    }
                    if (date != null) {
                        int iD = d(date.getTime(), date2.getTime());
                        int iL = com.bytedance.msdk.core.hc.hc().l();
                        if (iL - iD < 0) {
                            int i = iD - iL;
                            String strD = d(date, i);
                            if (!TextUtils.isEmpty(strD)) {
                                zwVar.d("start_index", strD);
                                d(strHc, date, i);
                            }
                            com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "old-startIndex:" + strHc + ",diff=" + i + ",new-startIndex:" + strD);
                        }
                    }
                } catch (ParseException e) {
                    com.bytedance.msdk.d.u.b.c("AdLoadDynamicParamHandler", "计算生成日期出错：" + e.getMessage());
                }
            } else {
                com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "startDay:" + strHc + ",key=" + strH + "，同一天，不处理");
            }
            com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "recordUserLiveDay方法，执行耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        }
    }

    private static void d(String str, Date date, int i) {
        if (i == 1) {
            zw zwVar = d;
            if (zwVar.u(str)) {
                zwVar.d("user_live_times", Math.max(zwVar.b("user_live_times") - 1, 0));
            }
            zwVar.an(str);
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            i2++;
            String strD = d(date, i2);
            zw zwVar2 = d;
            if (zwVar2.u(strD)) {
                zwVar2.d("user_live_times", Math.max(zwVar2.b("user_live_times") - 1, 0));
            }
            zwVar2.an(strD);
        }
    }

    public static int hc() {
        if (com.bytedance.msdk.core.hc.hc().r()) {
            return d.hc("user_live_times", 0);
        }
        return -1;
    }

    public static void d(String str) {
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return;
        }
        d(str, "_dislike_count_");
    }

    public static int hc(String str) {
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return -1;
        }
        return tt(d.hc(hc(str, "_dislike_count_")));
    }

    public static void b(String str) {
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return;
        }
        d(str, "_show_count_");
    }

    public static int c(String str) {
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return -1;
        }
        return tt(d.hc(hc(str, "_show_count_")));
    }

    public static void u(String str) {
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return;
        }
        d(str, "_click_count_");
    }

    public static int an(String str) {
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return -1;
        }
        return tt(d.hc(hc(str, "_click_count_")));
    }

    public static void b() {
        com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "recordSameDaySdkStartTimes start => enableDynamicPolicy:" + com.bytedance.msdk.core.hc.hc().r());
        if (com.bytedance.msdk.core.hc.hc().r()) {
            d((String) null, "tt_sdk_start_count_");
        }
    }

    public static int c() {
        if (com.bytedance.msdk.core.hc.hc().r()) {
            return tt(d.hc("tt_sdk_start_count_"));
        }
        return -1;
    }

    public static void h(String str) {
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return;
        }
        String strHc = hc(str, "_show_current_time_");
        String strHc2 = hc(str, "_show_last_time_");
        zw zwVar = d;
        String strHc3 = zwVar.hc("_show_gap_time_day");
        String strH = h();
        com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "recordSameDayTwoAdIntervalTime curKey:" + strHc + ",lastKey :" + strHc2 + ",today:" + strH + ",recordDate:" + strHc3);
        if (!TextUtils.equals(strHc3, strH)) {
            zwVar.d(strHc2, 0L);
            zwVar.d(strHc, System.currentTimeMillis());
            zwVar.d("_show_gap_time_day", strH);
        } else {
            zwVar.d(strHc2, zwVar.c(strHc));
            zwVar.d(strHc, System.currentTimeMillis());
        }
    }

    public static long gb(String str) {
        if (!com.bytedance.msdk.core.hc.hc().r() || str == null) {
            return -1L;
        }
        String strHc = hc(str, "_show_current_time_");
        String strHc2 = hc(str, "_show_last_time_");
        zw zwVar = d;
        if (!TextUtils.equals(zwVar.hc("_show_gap_time_day"), h())) {
            return 0L;
        }
        if (zwVar.c(strHc2) == 0) {
            return 0L;
        }
        return Math.round((zwVar.c(strHc) - r5) / 1000);
    }

    public static int u() {
        if (com.bytedance.msdk.core.hc.hc().r()) {
            return d(com.bytedance.msdk.core.d.mk().b(), System.currentTimeMillis());
        }
        return -1;
    }

    public static long an() {
        if (!com.bytedance.msdk.core.hc.hc().r()) {
            return -1L;
        }
        float fU = com.bytedance.msdk.core.d.mk().u() / 60000.0f;
        if (fU <= 0.0f || fU >= 1.0f) {
            return Math.round(fU);
        }
        return 1L;
    }

    private static void d(String str, String str2) {
        String strHc = hc(str, str2);
        String strH = h();
        zw zwVar = d;
        String strHc2 = zwVar.hc(strHc);
        com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "saveToSpByAction key:" + strHc + ",old value:" + strHc2);
        int i = 1;
        if (!TextUtils.isEmpty(strHc2)) {
            String[] strArrSplit = strHc2.split(Config.replace);
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[0];
                if (!TextUtils.isEmpty(str3) && TextUtils.equals(strH, str3)) {
                    i = 1 + Integer.parseInt(strArrSplit[1]);
                    strH = str3;
                }
                strHc2 = d(strH, i);
            }
            com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "saveToSpByAction key:" + strHc + "，new value：" + strHc2);
            zwVar.d(strHc, strHc2);
            return;
        }
        zwVar.d(strHc, d(strH, 1));
        com.bytedance.msdk.d.u.b.hc("AdLoadDynamicParamHandler", "saveToSpByAction 首次记录 key:" + strHc + "，new value：" + d(strH, 1));
    }

    private static String d(String str, int i) {
        return str + Config.replace + i;
    }

    private static int tt(String str) {
        String str2;
        if (str == null) {
            return 0;
        }
        String[] strArrSplit = str.split(Config.replace);
        if (strArrSplit.length != 2 || (str2 = strArrSplit[1]) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    private static int d(long j, long j2) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Period.between(Instant.ofEpochMilli(j).atZone(ZoneOffset.systemDefault()).toLocalDate(), Instant.ofEpochMilli(j2).atZone(ZoneOffset.systemDefault()).toLocalDate()).getDays();
        }
        return (int) ((j2 - j) / 86400000);
    }

    private static String hc(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str + str2;
    }

    private static String h() {
        return hc.format(new Date());
    }

    private static String d(Date date, int i) {
        if (date == null) {
            return null;
        }
        Calendar calendar = b;
        calendar.setTime(date);
        calendar.add(5, i);
        return hc.format(calendar.getTime());
    }

    public static void d(List<com.bytedance.msdk.hc.b> list, com.bytedance.msdk.core.tc.hc hcVar) {
        if (!com.bytedance.msdk.core.hc.hc().r() || list == null || hcVar == null) {
            return;
        }
        for (com.bytedance.msdk.hc.b bVar : list) {
            if (bVar != null) {
                bVar.j().put("prime_rit", hcVar.fs());
            }
        }
    }
}
