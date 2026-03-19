package com.lingku.xuanshang.xutils;

import android.app.Application;
import android.content.Context;
import com.lingku.xuanshang.xutils.DbManager;
import com.lingku.xuanshang.xutils.common.TaskController;
import com.lingku.xuanshang.xutils.common.task.TaskControllerImpl;
import com.lingku.xuanshang.xutils.db.DbManagerImpl;
import com.lingku.xuanshang.xutils.http.HttpManagerImpl;
import com.lingku.xuanshang.xutils.image.ImageManagerImpl;
import com.lingku.xuanshang.xutils.view.ViewInjectorImpl;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class x {

    public static class Ext {
        public static boolean a;
        public static Application b;
        public static TaskController c;
        public static HttpManager d;
        public static ImageManager e;
        public static ViewInjector f;

        public static void init(Application application) {
            TaskControllerImpl.registerInstance();
            if (b == null) {
                b = application;
            }
        }

        public static void setDebug(boolean z) {
            a = z;
        }

        public static void setDefaultHostnameVerifier(HostnameVerifier hostnameVerifier) {
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        }

        public static void setHttpManager(HttpManager httpManager) {
            d = httpManager;
        }

        public static void setImageManager(ImageManager imageManager) {
            e = imageManager;
        }

        public static void setTaskController(TaskController taskController) {
            if (c == null) {
                c = taskController;
            }
        }

        public static void setViewInjector(ViewInjector viewInjector) {
            f = viewInjector;
        }
    }

    public static class a extends Application {
        public a(Context context) {
            attachBaseContext(context);
        }
    }

    public static Application app() {
        if (Ext.b == null) {
            Ext.b = new a((Context) Class.forName("com.android.layoutlib.bridge.impl.RenderAction").getDeclaredMethod("getCurrentContext", new Class[0]).invoke(null, new Object[0]));
        }
        return Ext.b;
    }

    public static DbManager getDb(DbManager.DaoConfig daoConfig) {
        return DbManagerImpl.getInstance(daoConfig);
    }

    public static HttpManager http() {
        if (Ext.d == null) {
            HttpManagerImpl.registerInstance();
        }
        return Ext.d;
    }

    public static ImageManager image() {
        if (Ext.e == null) {
            ImageManagerImpl.registerInstance();
        }
        return Ext.e;
    }

    public static boolean isDebug() {
        return Ext.a;
    }

    public static TaskController task() {
        return Ext.c;
    }

    public static ViewInjector view() {
        if (Ext.f == null) {
            ViewInjectorImpl.registerInstance();
        }
        return Ext.f;
    }
}
