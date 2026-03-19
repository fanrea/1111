package com.pandora.ttlicense2;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class LicenseLogger {
    private static final String EVENT_NAME = "license_info";
    private static final String FILE_VERSION = "FileVersion";
    private static final String LICENSE_LOG = "LicenseLog.txt";
    private static final String TAG = "LicenseLogUploader";
    private static LicenseLogger sInstance;
    private final Context mContext;
    private final EventListenerList mEventListenerList = new EventListenerList();

    public interface EventListener {
        void onLicenseAddSuccess(String licenseId);
    }

    public void addEventListener(EventListener eventListener) {
        this.mEventListenerList.add(eventListener);
    }

    private static class EventListenerList implements EventListener {
        private final CopyOnWriteArrayList<EventListener> mListeners;

        private EventListenerList() {
            this.mListeners = new CopyOnWriteArrayList<>();
        }

        public void add(EventListener listener) {
            synchronized (this) {
                this.mListeners.add(listener);
            }
        }

        @Override // com.pandora.ttlicense2.LicenseLogger.EventListener
        public void onLicenseAddSuccess(String licenseId) {
            synchronized (this) {
                Iterator<EventListener> it = this.mListeners.iterator();
                while (it.hasNext()) {
                    it.next().onLicenseAddSuccess(licenseId);
                }
            }
        }
    }

    public EventListener eventListener() {
        return this.mEventListenerList;
    }

    public static synchronized LicenseLogger getInstance() {
        LicenseLogger licenseLogger;
        licenseLogger = sInstance;
        if (licenseLogger == null) {
            throw new NullPointerException("Call init first!");
        }
        return licenseLogger;
    }

    public static LicenseLogger init(Context context) {
        if (sInstance == null) {
            sInstance = new LicenseLogger(context);
        }
        return sInstance;
    }

    private LicenseLogger(Context context) {
        this.mContext = context;
    }

    private Set<String> getUploadedLicenseLog() {
        return this.mContext.getSharedPreferences("LicenseInfo", 0).getStringSet(FILE_VERSION, new HashSet());
    }

    private void recordUploadedLicense(long fileVersion) {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("LicenseInfo", 0);
        Set<String> stringSet = sharedPreferences.getStringSet(FILE_VERSION, new HashSet());
        if (stringSet.contains(String.valueOf(fileVersion))) {
            return;
        }
        stringSet.add(String.valueOf(fileVersion));
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putStringSet(FILE_VERSION, stringSet);
        editorEdit.apply();
    }

    private boolean isLicenseUploaded(long fileVersion) {
        return getUploadedLicenseLog().contains(String.valueOf(fileVersion));
    }

    public void upLoadLicenseLog(License license) throws JSONException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (license == null || license.getModules().length <= 0) {
            return;
        }
        long fileVersion = license.getFileVersion();
        if (isLicenseUploaded(fileVersion)) {
            return;
        }
        long expireTime = license.getModules()[0].getExpireTime();
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Id", license.getId());
            jSONObject.put("BundleId", license.getBundleId());
            jSONObject.put("PackageName", license.getPackageName());
            jSONObject.put(FILE_VERSION, fileVersion);
            jSONObject.put("Edition", license.getModules()[0].getEdition());
            jSONObject.put("StartTime", license.getModules()[0].getStartTime());
            jSONObject.put("ExpireTime", expireTime);
            jSONObject.put("ExpireBuffer", license.getModules()[0].getExpireBuffer());
            jSONObject.put("CollectTime", jCurrentTimeMillis);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        onUpload(EVENT_NAME, jSONObject);
    }

    public void onUpload(String eventName, JSONObject jsonObject) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (jsonObject == null) {
            return;
        }
        try {
            Method method = Class.forName("com.pandora.common.applog.AppLogWrapper").getMethod("upload", String.class, JSONObject.class);
            method.setAccessible(true);
            method.invoke(null, eventName, jsonObject);
            recordUploadedLicense(jsonObject.getLong(FILE_VERSION));
            Log.i(TAG, jsonObject.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }
}
