package lkxssdk.l0;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.gson.Gson;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.db.annotation.Column;
import com.lingku.xuanshang.xutils.db.converter.ColumnConverterFactory;
import com.lingku.xuanshang.xutils.db.table.ColumnEntity;
import com.lingku.xuanshang.xutils.db.table.DbModel;
import com.lingku.xuanshang.xutils.db.table.TableEntity;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a {
    public static DbModel a(Cursor cursor) {
        DbModel dbModel = new DbModel();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            dbModel.add(cursor.getColumnName(i), cursor.getString(i));
        }
        return dbModel;
    }

    public static <T> T a(TableEntity<T> tableEntity, Cursor cursor) {
        T tCreateEntity = tableEntity.createEntity();
        LinkedHashMap<String, ColumnEntity> columnMap = tableEntity.getColumnMap();
        int columnCount = cursor.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            ColumnEntity columnEntity = columnMap.get(cursor.getColumnName(i));
            if (columnEntity != null) {
                columnEntity.setValueFromCursor(tCreateEntity, cursor, i);
            }
        }
        return tCreateEntity;
    }

    public static <T> T a(JSONObject jSONObject, Class<T> cls) {
        try {
            return (T) new Gson().fromJson(jSONObject.toString(), (Class) cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a() {
        return lkxssdk.a.a.d() != null ? Settings.Secure.getString(lkxssdk.a.a.d().getContentResolver(), "android_id") : "";
    }

    public static String a(int i) {
        try {
            if (!a(lkxssdk.a.a.d(), "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) lkxssdk.a.a.d().getSystemService("phone");
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 26) {
                if ((i2 >= 23 ? telephonyManager.getPhoneCount() : ((Integer) telephonyManager.getClass().getMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue()) <= i) {
                    return "";
                }
                try {
                    TelephonyManager telephonyManager2 = (TelephonyManager) lkxssdk.a.a.d().getSystemService("phone");
                    return (String) telephonyManager2.getClass().getMethod("getImei", Integer.TYPE).invoke(telephonyManager2, Integer.valueOf(i));
                } catch (Exception unused) {
                    return "";
                }
            }
            int phoneCount = telephonyManager.getPhoneCount();
            lkxssdk.h0.c.b("phoneCount:" + phoneCount);
            if (phoneCount <= i) {
                return "";
            }
            telephonyManager.getMeid();
            return telephonyManager.getImei(i);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(Context context, int i, int i2) {
        if (context == null) {
            return "";
        }
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        return String.format(Locale.getDefault(), "%.2f", Double.valueOf(Math.sqrt(Math.pow(i / r0.xdpi, 2.0d) + Math.pow(i2 / r0.ydpi, 2.0d))));
    }

    public static LinkedHashMap<String, ColumnEntity> a(Class<?> cls) {
        LinkedHashMap<String, ColumnEntity> linkedHashMap = new LinkedHashMap<>();
        a(cls, linkedHashMap);
        return linkedHashMap;
    }

    public static void a(Class<?> cls, HashMap<String, ColumnEntity> map) {
        Column column;
        if (Object.class.equals(cls)) {
            return;
        }
        try {
            for (Field field : cls.getDeclaredFields()) {
                int modifiers = field.getModifiers();
                if (!Modifier.isStatic(modifiers) && !Modifier.isTransient(modifiers) && (column = (Column) field.getAnnotation(Column.class)) != null && ColumnConverterFactory.isSupportColumnConverter(field.getType())) {
                    ColumnEntity columnEntity = new ColumnEntity(cls, field, column);
                    if (!map.containsKey(columnEntity.getName())) {
                        map.put(columnEntity.getName(), columnEntity);
                    }
                }
            }
            a(cls.getSuperclass(), map);
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
    }

    public static boolean a(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int[] a(Context context) {
        int[] iArr = {0, 0};
        if (context == null) {
            return iArr;
        }
        int i = Build.VERSION.SDK_INT;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        int iIntValue = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        if (i >= 14 && i < 17) {
            try {
                iIntValue = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (Exception unused) {
                iIntValue = displayMetrics.heightPixels;
            }
        } else if (i >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
            iIntValue = displayMetrics.heightPixels;
            i2 = displayMetrics.widthPixels;
        }
        iArr[0] = i2;
        iArr[1] = iIntValue;
        return iArr;
    }

    public static String b() {
        return a(lkxssdk.a.a.d(), "android.permission.READ_PHONE_STATE") ? ((TelephonyManager) lkxssdk.a.a.d().getSystemService("phone")).getDeviceId() : "";
    }

    public static String c() {
        return a(lkxssdk.a.a.d(), "android.permission.READ_PHONE_STATE") ? ((TelephonyManager) lkxssdk.a.a.d().getSystemService("phone")).getSubscriberId() : "";
    }

    public static String d() {
        return (Build.VERSION.SDK_INT < 26 || !a(lkxssdk.a.a.d(), "android.permission.READ_PHONE_STATE")) ? Build.SERIAL : Build.getSerial();
    }

    public static String e() {
        lkxssdk.a.a.d().getApplicationContext();
        return lkxssdk.a0.c.a(new b().a.toString());
    }

    public static boolean f() {
        return (Resources.getSystem().getConfiguration().screenLayout & 15) >= 3;
    }
}
