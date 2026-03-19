package com.duoyou.task.sdk.xutils;

import android.content.Context;
import com.duoyou.task.sdk.xutils.DbManager;
import com.duoyou.task.sdk.xutils.common.TaskController;
import com.duoyou.task.sdk.xutils.common.task.TaskControllerImpl;
import com.duoyou.task.sdk.xutils.db.DbManagerImpl;
import com.duoyou.task.sdk.xutils.http.HttpManagerImpl;
import com.duoyou.task.sdk.xutils.image.ImageManagerImpl;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class x {
    private x() {
    }

    public static boolean isDebug() {
        return Ext.debug;
    }

    public static Context app() {
        return Ext.app;
    }

    public static TaskController task() {
        return Ext.taskController;
    }

    public static HttpManager http() {
        if (Ext.httpManager == null) {
            HttpManagerImpl.registerInstance();
        }
        return Ext.httpManager;
    }

    public static ImageManager image() {
        if (Ext.imageManager == null) {
            ImageManagerImpl.registerInstance();
        }
        return Ext.imageManager;
    }

    public static DbManager getDb(DbManager.DaoConfig daoConfig) {
        return DbManagerImpl.getInstance(daoConfig);
    }

    public static class Ext {
        private static Context app;
        private static boolean debug;
        private static HttpManager httpManager;
        private static ImageManager imageManager;
        private static TaskController taskController;

        private Ext() {
        }

        public static void init(Context context) {
            TaskControllerImpl.registerInstance();
            if (app == null) {
                app = context;
            }
        }

        public static void setDebug(boolean z) {
            debug = z;
        }

        public static void setTaskController(TaskController taskController2) {
            if (taskController == null) {
                taskController = taskController2;
            }
        }

        public static void setHttpManager(HttpManager httpManager2) {
            httpManager = httpManager2;
        }

        public static void setImageManager(ImageManager imageManager2) {
            imageManager = imageManager2;
        }

        public static void setDefaultHostnameVerifier(HostnameVerifier hostnameVerifier) {
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        }
    }
}
