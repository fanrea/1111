package com.kwai.middleware.azeroth.utils;

import android.content.Context;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.content.a;
import android.util.Log;
import com.component.c.c;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class DeviceIDUtil {
    private static final Pattern ANDROID_ID_PATTERN = Pattern.compile("^[0-9a-fA-F]{16}$");
    public static final List<String> BLACK_ANDROID_ID_LIST = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d", "b06ebfc4520b5008", "2a782c9015e19bc1", "aa02fbb253737fc8", "ac69d74ef1ba99e4", "dbd4d56770897c47", "abafaa417ee08ca2", "795c456a96f21c5b", "a5f5faddde9e9f02", "fe0b1c9868b9cd97", "d9d75592d9146cbe", "26d084fed86946ae", "7034ad254eda67ad", "674d3e9fa3f2fa4e", "3a45681de9ef1b90", "f4ffa5fbd84db322", "75bcc47f4ff738df", "743461a0e4d0ff76", "6bd6c744119b9094", "39aef181a6030b79", "529da8c466197e06", "8e17f7422b35fbea", "ee8425b2963f98ae", "780e2c5023c135b5", "5861b6ef90e23b25");
    private static final String DEVICE_ID_FILE_NAME = ".did.cfg";
    public static final String DEVICE_ID_PREFIX = "ANDROID_";
    private static final String KEY_ANDROID_ID = "android_id";
    private static boolean sCanGetAndroidId;
    private static String sDeviceId;
    private static ExecutorService sIOExecutor;

    public static void setCanGetAndroidId(boolean z) {
        sCanGetAndroidId = z;
    }

    private DeviceIDUtil() {
    }

    public static synchronized String getDeviceId(Context context) {
        if (android.text.TextUtils.isEmpty(sDeviceId)) {
            sDeviceId = readDeviceId(context);
        }
        return sDeviceId;
    }

    private static String readDeviceId(Context context) {
        if (!sCanGetAndroidId) {
            Log.i("OpenAzeroth", "DeviceIDUtil: sCanGetAndroidId is false, return");
            return "ANDROID_unknown";
        }
        if (a.b(context, "android.permission.READ_PHONE_STATE") != 0) {
            Log.e("OpenAzeroth", "DeviceIDUtil: no permission for get did");
            return "ANDROID_unknown";
        }
        String androidId = SystemUtils.getAndroidId(context);
        if (isLegalAndroidId(androidId) && !isBlackAndroidId(androidId)) {
            return DEVICE_ID_PREFIX + androidId;
        }
        String savedAndroidId = readSavedAndroidId(context);
        if (isLegalAndroidId(savedAndroidId)) {
            return DEVICE_ID_PREFIX + savedAndroidId;
        }
        String strGenerateAndroidId = generateAndroidId();
        if (!android.text.TextUtils.isEmpty(strGenerateAndroidId)) {
            saveAndroidIdToPref(context, strGenerateAndroidId);
            saveAndroidIdToFile(getDeviceIDFile1(context), strGenerateAndroidId);
            saveAndroidIdToFile(getDeviceIDFile2(context), strGenerateAndroidId);
        }
        return DEVICE_ID_PREFIX + strGenerateAndroidId;
    }

    private static String readSavedAndroidId(Context context) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(KEY_ANDROID_ID, null);
        String file = readFile(getDeviceIDFile1(context));
        String file2 = readFile(getDeviceIDFile2(context));
        if (!android.text.TextUtils.isEmpty(string) && string.equals(file) && string.equals(file2)) {
            return string;
        }
        if (!android.text.TextUtils.isEmpty(string) && string.equals(file)) {
            saveAndroidIdToFile(getDeviceIDFile2(context), string);
            return string;
        }
        if (!android.text.TextUtils.isEmpty(string) && string.equals(file2)) {
            saveAndroidIdToFile(getDeviceIDFile1(context), string);
            return string;
        }
        if (!android.text.TextUtils.isEmpty(file) && file.equals(file2)) {
            saveAndroidIdToPref(context, file);
            return file;
        }
        if (!android.text.TextUtils.isEmpty(string)) {
            saveAndroidIdToFile(getDeviceIDFile1(context), string);
            saveAndroidIdToFile(getDeviceIDFile2(context), string);
            return string;
        }
        if (!android.text.TextUtils.isEmpty(file)) {
            saveAndroidIdToPref(context, file);
            saveAndroidIdToFile(getDeviceIDFile2(context), file);
            return file;
        }
        if (android.text.TextUtils.isEmpty(file2)) {
            return null;
        }
        saveAndroidIdToPref(context, file2);
        saveAndroidIdToFile(getDeviceIDFile2(context), file2);
        return file2;
    }

    private static String generateAndroidId() {
        try {
            return TextUtils.leftPad(Long.toHexString(Utils.random()), 16, '0');
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static boolean isLegalAndroidId(String str) {
        return !android.text.TextUtils.isEmpty(str) && ANDROID_ID_PATTERN.matcher(str).find();
    }

    private static boolean isBlackAndroidId(String str) {
        return BLACK_ANDROID_ID_LIST.contains(str.toLowerCase(Locale.US));
    }

    private static void saveAndroidIdToPref(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(KEY_ANDROID_ID, str).apply();
    }

    private static void saveAndroidIdToFile(final File file, final String str) {
        execute(new Runnable() { // from class: com.kwai.middleware.azeroth.utils.DeviceIDUtil.1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                DeviceIDUtil.writeFile(file, str);
            }
        });
    }

    private static File getDeviceIDFile1(Context context) {
        return new File(context.getExternalFilesDir(""), DEVICE_ID_FILE_NAME);
    }

    private static File getDeviceIDFile2(Context context) {
        if (c.a.equals(Environment.getExternalStorageState())) {
            return null;
        }
        try {
            File file = new File(Environment.getExternalStorageDirectory(), "." + context.getPackageName());
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, DEVICE_ID_FILE_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeFile(File file, String str) throws Throwable {
        if (file == null) {
            return;
        }
        try {
            FileUtils.write(file, str, Charsets.UTF_8, false);
        } catch (Exception unused) {
        }
    }

    private static String readFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            return FileUtils.readFirstLine(file, Charsets.UTF_8);
        } catch (Exception unused) {
            return null;
        }
    }

    private static void execute(Runnable runnable) {
        if (sIOExecutor == null) {
            sIOExecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        }
        sIOExecutor.execute(runnable);
    }

    public static void addBlackAndroidIDList(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (String str : list) {
            if (!android.text.TextUtils.isEmpty(str)) {
                BLACK_ANDROID_ID_LIST.add(str.toLowerCase(Locale.US));
            }
        }
    }
}
