package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class StorageUtils {
    private static final String DIAN_HOT_TASK_LIST = "moku_dian_sp_hot_task_list_key";
    private static final String DIAN_SEARCH_TASK_LIST = "moku_dian_sp_search_task_list_key";
    private static final String DIAN_SP_SEARCH_HISTORY_KEY = "moku_dian_sp_search_history_key";
    private static final String TAG = "MOKU_StorageUtils=>";

    public static boolean saveBitmap(Context context, Bitmap bitmap, String str) throws IOException {
        String str2 = (((File) Objects.requireNonNull(Environment.getExternalStorageDirectory())).getPath() + File.separator + Environment.DIRECTORY_PICTURES) + File.separator + str;
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse(UriUtils.FILE_PREFIX + str2)));
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static List<String> queryDianSearchHistory(Context context) {
        String string = SharedPreferencesUtils.getInstance(context).getString(DIAN_SP_SEARCH_HISTORY_KEY, null);
        if (string != null && !StringUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList(jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
                return arrayList;
            } catch (Exception unused) {
                LogUtils.logE(TAG, "queryDianSearchHistory error");
            }
        }
        return null;
    }

    public static void addDianSearchHistory(Context context, String str) {
        List listQueryDianSearchHistory = queryDianSearchHistory(context);
        if (listQueryDianSearchHistory == null) {
            listQueryDianSearchHistory = new ArrayList();
        }
        listQueryDianSearchHistory.add(str);
        SharedPreferencesUtils.getInstance(context).putString(DIAN_SP_SEARCH_HISTORY_KEY, JSON.toJSONString(listQueryDianSearchHistory));
    }

    public static void cleanSearchHistory(Context context) {
        SharedPreferencesUtils.getInstance(context).remove(DIAN_SP_SEARCH_HISTORY_KEY);
    }

    public static String getSearchTaskList(Context context) {
        return SharedPreferencesUtils.getInstance(context).getString(DIAN_SEARCH_TASK_LIST, null);
    }

    public static void putSearchTaskList(Context context, String str) {
        if (str == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtils.getInstance(context).putString(DIAN_SEARCH_TASK_LIST, str);
    }

    public static void cleanSearchTaskList(Context context) {
        SharedPreferencesUtils.getInstance(context).remove(DIAN_SEARCH_TASK_LIST);
    }

    public static void putHotTaskList(Context context, String str) {
        if (str == null || StringUtils.isEmpty(str)) {
            return;
        }
        SharedPreferencesUtils.getInstance(context).putString(DIAN_HOT_TASK_LIST, str);
    }

    public static void clearHotTaskList(Context context) {
        SharedPreferencesUtils.getInstance(context).remove(DIAN_HOT_TASK_LIST);
    }

    public static String getHotTaskList(Context context) {
        return SharedPreferencesUtils.getInstance(context).getString(DIAN_HOT_TASK_LIST, null);
    }
}
