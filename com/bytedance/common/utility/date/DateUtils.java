package com.bytedance.common.utility.date;

import android.content.Context;
import com.bytedance.common.utility.R;
import com.pandora.common.utils.Times;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DateUtils implements DateDef {
    private static final SimpleDateFormat YEAR_FORMAT = new SimpleDateFormat(Times.YYYY_MM_DD);
    private static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("MM-dd HH:mm");

    private DateUtils() {
    }

    public static String getDateString(Context context, long j) {
        if (!isCurrentYear(j)) {
            return YEAR_FORMAT.format(Long.valueOf(j));
        }
        if (!android.text.format.DateUtils.isToday(j)) {
            return DAY_FORMAT.format(Long.valueOf(j));
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        return jCurrentTimeMillis >= 3600000 ? context.getString(R.string.hours_ago, Long.valueOf(jCurrentTimeMillis / 3600000)) : jCurrentTimeMillis >= 60000 ? context.getString(R.string.minutes_ago, Long.valueOf(jCurrentTimeMillis / 60000)) : context.getString(R.string.just_now);
    }

    public static boolean isCurrentYear(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i = calendar.get(1);
        calendar.setTimeInMillis(System.currentTimeMillis());
        return i == calendar.get(1);
    }
}
