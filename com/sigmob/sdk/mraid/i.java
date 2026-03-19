package com.sigmob.sdk.mraid;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class i {
    public static final String a = "vnd.android.cursor.item/event";
    private static final int b = 31;
    private static final String[] c = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    public interface a {
        void onFailure(c exception);
    }

    private static class b implements MediaScannerConnection.MediaScannerConnectionClient {
        private final String a;
        private final String b;
        private MediaScannerConnection c;

        private b(String filename, String mimeType) {
            this.a = filename;
            this.b = mimeType;
        }

        private void a(MediaScannerConnection connection) {
            this.c = connection;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.a, this.b);
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String path, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    private String a(int number) throws IllegalArgumentException {
        switch (number) {
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            default:
                throw new IllegalArgumentException("invalid day of week " + number);
        }
    }

    private Date a(String dateTime) {
        Date date = null;
        for (String str : c) {
            try {
                date = new SimpleDateFormat(str, Locale.US).parse(dateTime);
            } catch (ParseException unused) {
            }
            if (date != null) {
                break;
            }
        }
        return date;
    }

    private Map<String, Object> a(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (!map.containsKey("description") || !map.containsKey("start")) {
            throw new IllegalArgumentException("Missing start and description fields");
        }
        map2.put("title", map.get("description"));
        if (!map.containsKey("start") || map.get("start") == null) {
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        Date dateA = a(map.get("start"));
        if (dateA == null) {
            throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
        }
        map2.put("beginTime", Long.valueOf(dateA.getTime()));
        if (map.containsKey(PointCategory.END) && map.get(PointCategory.END) != null) {
            Date dateA2 = a(map.get(PointCategory.END));
            if (dateA2 == null) {
                throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            map2.put("endTime", Long.valueOf(dateA2.getTime()));
        }
        if (map.containsKey("location")) {
            map2.put("eventLocation", map.get("location"));
        }
        if (map.containsKey("summary")) {
            map2.put("description", map.get("summary"));
        }
        if (map.containsKey("transparency")) {
            map2.put("availability", Integer.valueOf(map.get("transparency").equals("transparent") ? 1 : 0));
        }
        map2.put("rrule", b(map));
        return map2;
    }

    private String b(int number) throws IllegalArgumentException {
        if (number == 0 || number < -31 || number > 31) {
            throw new IllegalArgumentException("invalid day of month " + number);
        }
        return "" + number;
    }

    private String b(String expression) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] strArrSplit = expression.split(",");
        for (String str : strArrSplit) {
            int i = Integer.parseInt(str);
            if (i == 7) {
                i = 0;
            }
            if (!zArr[i]) {
                sb.append(a(i) + ",");
                zArr[i] = true;
            }
        }
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String b(Map<String, String> params) throws IllegalArgumentException {
        String strC;
        StringBuilder sb;
        String str;
        StringBuilder sbAppend;
        StringBuilder sb2 = new StringBuilder();
        if (params.containsKey("frequency")) {
            String str2 = params.get("frequency");
            int i = params.containsKey(MetricsSQLiteCacheKt.METRICS_INTERVAL) ? Integer.parseInt(params.get(MetricsSQLiteCacheKt.METRICS_INTERVAL)) : -1;
            if ("daily".equals(str2)) {
                sb2.append("FREQ=DAILY;");
                if (i != -1) {
                    sbAppend = new StringBuilder().append("INTERVAL=").append(i);
                    sb2.append(sbAppend.append(com.alipay.sdk.m.u.i.b).toString());
                }
            } else {
                if ("weekly".equals(str2)) {
                    sb2.append("FREQ=WEEKLY;");
                    if (i != -1) {
                        sb2.append("INTERVAL=" + i + com.alipay.sdk.m.u.i.b);
                    }
                    if (params.containsKey("daysInWeek")) {
                        strC = b(params.get("daysInWeek"));
                        if (strC == null) {
                            throw new IllegalArgumentException("invalid ");
                        }
                        sb = new StringBuilder();
                        str = "BYDAY=";
                        sbAppend = sb.append(str).append(strC);
                    }
                } else {
                    if (!"monthly".equals(str2)) {
                        throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                    }
                    sb2.append("FREQ=MONTHLY;");
                    if (i != -1) {
                        sb2.append("INTERVAL=" + i + com.alipay.sdk.m.u.i.b);
                    }
                    if (params.containsKey("daysInMonth")) {
                        strC = c(params.get("daysInMonth"));
                        if (strC == null) {
                            throw new IllegalArgumentException();
                        }
                        sb = new StringBuilder();
                        str = "BYMONTHDAY=";
                        sbAppend = sb.append(str).append(strC);
                    }
                }
                sb2.append(sbAppend.append(com.alipay.sdk.m.u.i.b).toString());
            }
        }
        return sb2.toString();
    }

    private String c(String expression) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] strArrSplit = expression.split(",");
        for (String str : strArrSplit) {
            int i = Integer.parseInt(str);
            int i2 = i + 31;
            if (!zArr[i2]) {
                sb.append(b(i) + ",");
                zArr[i2] = true;
            }
        }
        if (strArrSplit.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static boolean c(Context context) {
        return false;
    }

    public static boolean d(Context context) {
        return false;
    }

    public void a(Context context, String imageUrl, a failureListener) throws c {
        if (c(context)) {
            return;
        }
        SigmobLog.e("Error downloading file - the device does not have an SD card mounted, or the SigmobAndroid permission is not granted.");
        throw new c("Error downloading file  - the device does not have an SD card mounted, or the SigmobAndroid permission is not granted.");
    }

    public void a(final Context context, final Map<String, String> params) throws c {
        if (!d(context)) {
            SigmobLog.e("unsupported action createCalendarEvent for devices pre-ICS");
            throw new c("Action is unsupported on this device (need SigmobAndroid version Ice Cream Sandwich or above)");
        }
        try {
            Map<String, Object> mapA = a(params);
            Intent type = new Intent("android.intent.action.INSERT").setType(a);
            for (String str : mapA.keySet()) {
                Object obj = mapA.get(str);
                if (obj instanceof Long) {
                    type.putExtra(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    type.putExtra(str, ((Integer) obj).intValue());
                } else {
                    type.putExtra(str, (String) obj);
                }
            }
            type.setFlags(268435456);
            context.startActivity(type);
        } catch (ActivityNotFoundException unused) {
            SigmobLog.e("no calendar app installed");
            throw new c("Action is unsupported on this device - no calendar app installed");
        } catch (IllegalArgumentException e) {
            SigmobLog.e("create calendar: invalid parameters " + e.getMessage());
            throw new c(e);
        } catch (Exception e2) {
            SigmobLog.e("could not create calendar event");
            throw new c(e2);
        }
    }

    public boolean a(Activity activity, View view) {
        return false;
    }

    public boolean a(Context context) {
        return false;
    }

    public boolean b(Context context) {
        return false;
    }
}
