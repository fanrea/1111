package com.bytedance.pangle.plugin;

import android.content.ComponentCallbacks;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.util.cm;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.an.h;
import com.bytedance.pangle.c.hc;
import com.bytedance.pangle.d.d;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.res.PluginResources;
import com.bytedance.pangle.tc;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.tt;
import com.bytedance.pangle.util.uo;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.api.an;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c {
    private static final tc d = tc.d();

    c() {
    }

    boolean d(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, plugin == null, pkg = ".concat(String.valueOf(str)));
            return false;
        }
        if (!plugin.isInstalled()) {
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPlugin, UN_INSTALLED, ".concat(String.valueOf(str)));
            return false;
        }
        if (plugin.isLoading()) {
            return false;
        }
        if (plugin.isLoaded()) {
            return true;
        }
        synchronized (plugin) {
            if (plugin.isLoaded()) {
                return true;
            }
            plugin.setLifeCycle(4);
            tc tcVar = d;
            tcVar.d(2000, 0, plugin.mPkgName, plugin.getVersion(), null);
            com.bytedance.pangle.log.d dVarD = com.bytedance.pangle.log.d.d(ZeusLogger.TAG_LOAD, "PluginLoader", "loadPlugin:".concat(String.valueOf(str)));
            d(com.bytedance.pangle.c.hc.gb, hc.d.s, plugin.mPkgName, plugin.getVersion(), -1L, (String) null);
            ZeusPluginStateListener.postStateChange(str, 8, new Object[0]);
            StringBuilder sb = new StringBuilder();
            boolean zD = plugin.isIsDexPlugin() ? com.bytedance.pangle.b.hc.d(plugin, sb) : d(str, plugin, sb);
            if ((plugin instanceof d) && plugin.isIsDexPlugin()) {
                ((d) plugin).d();
            }
            dVarD.d("loadPluginInternal:".concat(String.valueOf(zD)));
            if (zD) {
                plugin.setLifeCycle(3);
                d(com.bytedance.pangle.c.hc.tt, hc.d.us, plugin.mPkgName, plugin.getVersion(), dVarD.d(), sb.toString());
                ZeusPluginStateListener.postStateChange(str, 9, new Object[0]);
                tcVar.d(ZeusPluginEventCallback.EVENT_FINISH_LOAD, 0, plugin.mPkgName, plugin.getVersion(), null);
            } else {
                plugin.setLifeCycle(2);
                sb.append("plugin:").append(plugin.mPkgName).append(" versionCode:").append(plugin.getVersion()).append("load failed;");
                d(com.bytedance.pangle.c.hc.tt, hc.d.z, plugin.mPkgName, plugin.getVersion(), -1L, sb.toString());
                ZeusPluginStateListener.postStateChange(str, 10, new Object[0]);
                tcVar.d(ZeusPluginEventCallback.EVENT_FINISH_LOAD, -1, plugin.mPkgName, plugin.getVersion(), null);
            }
            ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader loadFinished, ".concat(String.valueOf(plugin)));
            if (!plugin.isLoaded()) {
                return false;
            }
            ZeusLogger.d(ZeusLogger.TAG_LOAD, "PluginLoader postResult, LOADED " + plugin.mPkgName);
            return true;
        }
    }

    private boolean d(final String str, final Plugin plugin, final StringBuilder sb) {
        boolean zHc;
        final PackageInfo[] packageInfoArr;
        try {
            if (plugin == null) {
                sb.append("loadPluginInternal, plugin == null;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not exist !!!");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadPluginInternal, !plugin.isInstalled();");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] not installed !!!");
                return false;
            }
            final String strHc = com.bytedance.pangle.u.b.hc(plugin.mPkgName, plugin.getVersion());
            ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoaderfind Apk: sourceApk:" + strHc + " ; pkgName:" + plugin.mPkgName + " ; " + plugin.getVersion());
            if (!new File(strHc).exists()) {
                sb.append("loadPluginInternal, sourceApk not exist;");
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] file not exist !!!");
                return false;
            }
            zHc = hc(strHc, plugin, sb);
            try {
                final File file = new File(com.bytedance.pangle.u.b.c(plugin.mPkgName, plugin.getVersion()));
                final File fileD = d(plugin.mPkgName, plugin.getVersion(), strHc);
                boolean z = true;
                PackageInfo[] packageInfoArr2 = new PackageInfo[1];
                if (tt.rf()) {
                    packageInfoArr = packageInfoArr2;
                    z = true;
                    com.bytedance.pangle.d.d.d(true, new d.InterfaceC0251d() { // from class: com.bytedance.pangle.plugin.c.1
                        @Override // com.bytedance.pangle.d.d.InterfaceC0251d
                        public void d() throws Exception {
                            c.this.d(plugin, strHc, file, fileD, sb);
                        }
                    }, new d.InterfaceC0251d() { // from class: com.bytedance.pangle.plugin.c.2
                        @Override // com.bytedance.pangle.d.d.InterfaceC0251d
                        public void d() throws Throwable {
                            packageInfoArr[0] = c.this.d(str, plugin, sb, strHc, file);
                        }
                    });
                } else {
                    packageInfoArr = packageInfoArr2;
                    d(plugin, strHc, file, fileD, sb);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader before makeResources");
                    packageInfoArr[0] = d(str, plugin, sb, strHc, file);
                    ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader after makeResources");
                }
                d(plugin, sb, packageInfoArr[0]);
                return z;
            } catch (Throwable th) {
                th = th;
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "loadPluginInternal stack:" + Arrays.toString(th.getStackTrace()));
                GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_ERROR, "loadLog:" + sb.toString());
                sb.append("loadPluginInternal ").append(th.getMessage()).append(i.b);
                ZeusLogger.w(ZeusLogger.TAG_LOAD, "PluginLoader loadPluginInternal, plugin[" + str + "] ", th);
                if (zHc) {
                    uo.d().d(str, plugin.getVersion(), "load");
                    if (uo.d().hc(str, plugin.getVersion(), "load") > 3) {
                        Zeus.unInstallPlugin(str);
                    }
                }
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            zHc = false;
        }
    }

    private boolean hc(String str, Plugin plugin, StringBuilder sb) throws IOException {
        if (tt.b() || tt.gb() || tt.rf()) {
            sb.append("removeEntry skip 1;");
            return false;
        }
        if (!((uo.d().tt(plugin.mPkgName, plugin.getVersion()) & 1) != 0)) {
            sb.append("removeEntry skip 2;");
            return false;
        }
        boolean zHc = com.bytedance.pangle.u.c.hc(Zeus.getAppApplication());
        boolean zH = uo.d().h(plugin.mPkgName, plugin.getVersion());
        if (zHc && zH) {
            if (!uo.d().gb(plugin.mPkgName, plugin.getVersion())) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean zD = com.bytedance.pangle.util.hc.hc.d(str, true, false, plugin.mPkgName, plugin.getVersion(), 2);
                sb.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
                uo.d().c(plugin.mPkgName, plugin.getVersion(), true);
                return zD;
            }
            sb.append("removeEntry skip 3;");
            return false;
        }
        sb.append("removeEntry skip 4 ").append(zHc).append(" ").append(zH).append(i.b);
        return false;
    }

    private void d(Plugin plugin, StringBuilder sb, PackageInfo packageInfo) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ActivityInfo[] activityInfoArr = packageInfo.activities;
        if (activityInfoArr != null) {
            for (ActivityInfo activityInfo : activityInfoArr) {
                if (TextUtils.isEmpty(activityInfo.processName) || !activityInfo.processName.contains(":")) {
                    activityInfo.processName = LiveConfigKey.MAIN;
                } else {
                    activityInfo.processName = activityInfo.processName.split(":")[1];
                }
                plugin.pluginActivities.put(activityInfo.name, activityInfo);
            }
        }
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (TextUtils.isEmpty(serviceInfo.processName) || !serviceInfo.processName.contains(":")) {
                    serviceInfo.processName = LiveConfigKey.MAIN;
                } else {
                    serviceInfo.processName = serviceInfo.processName.split(":")[1];
                }
                plugin.pluginServices.put(serviceInfo.name, serviceInfo);
            }
        }
        ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
        if (activityInfoArr2 != null) {
            for (ActivityInfo activityInfo2 : activityInfoArr2) {
                if (TextUtils.isEmpty(activityInfo2.processName) || !activityInfo2.processName.contains(":")) {
                    activityInfo2.processName = LiveConfigKey.MAIN;
                } else {
                    activityInfo2.processName = activityInfo2.processName.split(":")[1];
                }
                plugin.pluginReceiver.put(activityInfo2.name, activityInfo2);
            }
        }
        ProviderInfo[] providerInfoArr = packageInfo.providers;
        if (providerInfoArr != null) {
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (TextUtils.isEmpty(providerInfo.processName) || !providerInfo.processName.contains(":")) {
                    providerInfo.processName = LiveConfigKey.MAIN;
                } else {
                    providerInfo.processName = providerInfo.processName.split(":")[1];
                }
                plugin.pluginProvider.put(providerInfo.name, providerInfo);
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (plugin.pluginProvider != null && plugin.pluginProvider.size() > 0) {
            ContentProviderManager.getInstance().installContentProviders(plugin.pluginProvider.values(), plugin);
        }
        sb.append("installProvider cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(packageInfo.applicationInfo.className)) {
            plugin.mApplication = (ZeusApplication) plugin.mClassLoader.loadClass(packageInfo.applicationInfo.className).newInstance();
            plugin.mApplication.attach(plugin, Zeus.getAppApplication());
        }
        sb.append("makeApplication cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(i.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo d(String str, final Plugin plugin, StringBuilder sb, String str2, File file) throws PackageManager.NameNotFoundException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(str2, 143);
        plugin.mHostApplication = (PluginApplicationWrapper) ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), plugin.mPkgName);
        plugin.mHostApplicationInfoHookSomeField = new ApplicationInfo(Zeus.getAppApplication().getApplicationInfo());
        plugin.mHostApplicationInfoHookSomeField.nativeLibraryDir = file.getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.dataDir = plugin.mHostApplication.getDataDir().getAbsolutePath();
        plugin.mHostApplicationInfoHookSomeField.sourceDir = str2;
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.sourceDir)) {
            packageArchiveInfo.applicationInfo.sourceDir = str2;
        }
        if (TextUtils.isEmpty(packageArchiveInfo.applicationInfo.publicSourceDir)) {
            packageArchiveInfo.applicationInfo.publicSourceDir = str2;
        }
        plugin.mResources = new PluginResources(Zeus.getAppApplication().getPackageManager().getResourcesForApplication(packageArchiveInfo.applicationInfo), str);
        Zeus.getAppApplication().registerComponentCallbacks(new ComponentCallbacks() { // from class: com.bytedance.pangle.plugin.c.3
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                plugin.mResources.updateConfiguration(configuration, Zeus.getAppApplication().getResources().getDisplayMetrics());
            }
        });
        sb.append("makeResources cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        return packageArchiveInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Plugin plugin, String str, File file, File file2, StringBuilder sb) throws Exception {
        long jCurrentTimeMillis = System.currentTimeMillis();
        d(plugin, str, file, file2);
        sb.append("classLoader cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(" ;");
        if (plugin.mOpenLoadClassOpt) {
            com.bytedance.pangle.u.u.d(new Runnable() { // from class: com.bytedance.pangle.plugin.c.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        plugin.mClassLoader.setAllPluginClasses((HashSet) MethodUtils.invokeStaticMethod(plugin.mClassLoader.loadClass("com.volcengine.PluginClassHolder"), "getPluginClasses", new Object[0]));
                    } catch (Throwable unused) {
                    }
                }
            });
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        try {
            String str2 = (String) FieldUtils.readStaticField(plugin.mClassLoader.loadClass("com.volcengine.StubConfig"), "actStubV1");
            if (str2 != null) {
                d(plugin, str2);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th) {
            sb.append("actStubV1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(i.b);
            throw th;
        }
        sb.append("actStubV1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis2).append(i.b);
    }

    private void d(Plugin plugin, String str, File file, File file2) throws Exception {
        if (d()) {
            plugin.mClassLoader = new PluginClassLoader("", file2, file.getAbsolutePath(), null);
            d(plugin.mClassLoader, str);
        } else {
            if (tt.b()) {
                String strD = h.d(plugin.mPkgName, plugin.getVersion());
                String[] strArrSplit = strD.split(":");
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z = !com.bytedance.pangle.an.hc.d(file2.getAbsolutePath(), strArrSplit);
                ZeusLogger.d(ZeusLogger.TAG_LOAD, "useDirect:" + (System.currentTimeMillis() - jCurrentTimeMillis) + " " + z);
                plugin.mClassLoader = new PluginClassLoader(z ? "" : strD, file2, file.getAbsolutePath(), null);
                return;
            }
            plugin.mClassLoader = new PluginClassLoader(str, file2, file.getAbsolutePath(), null);
        }
    }

    private File d(String str, int i, String str2) {
        File file = new File(com.bytedance.pangle.u.b.b(str, i));
        if (tt.h() && !com.bytedance.pangle.an.hc.d(file + File.separator + com.bytedance.pangle.an.hc.d(str2))) {
            file = null;
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void d(Plugin plugin, String str) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mapping");
        HashMap map = new HashMap();
        if (jSONObjectOptJSONObject2 != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObjectOptJSONObject2.getString(next));
            }
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("forceMappings");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                int iOptInt = jSONObject2.optInt("minApi", 0);
                int iOptInt2 = jSONObject2.optInt("maxApi", Integer.MAX_VALUE);
                int apiVersionCode = plugin.getApiVersionCode();
                if (apiVersionCode <= iOptInt2 && apiVersionCode >= iOptInt && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("mapping")) != null) {
                    Iterator<String> itKeys2 = jSONObjectOptJSONObject.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        map.put(next2, jSONObjectOptJSONObject.getString(next2));
                    }
                }
            }
        }
        for (String str2 : map.keySet()) {
            String str3 = (String) map.get(str2);
            ComponentManager.registerActivity(plugin.mPkgName, ((str3 == null || !str3.contains(".")) ? plugin.mPkgName + "." : "") + ((String) map.get(str2)), str2);
        }
    }

    public static void d(String str, int i, String str2, int i2, long j, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt("status_code", com.bytedance.pangle.log.hc.d(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.hc.d(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.hc.d(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.hc.hc(Long.valueOf(j))));
            jSONObject2.putOpt(cm.V, com.bytedance.pangle.log.hc.d(str3));
        } catch (JSONException e) {
            an.d(e);
        }
        com.bytedance.pangle.c.hc.d().d(str, jSONObject, jSONObject3, jSONObject2);
    }

    private static boolean d() {
        return tt.rf();
    }

    public static boolean d(Object obj, String str) {
        if (str != null) {
            try {
                for (String str2 : str.split(File.pathSeparator)) {
                    new File(str2).setReadOnly();
                }
            } catch (Throwable th) {
                an.d(th);
                ZeusLogger.errReport(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath fail >>>".concat(String.valueOf(str)), th);
                return false;
            }
        }
        MethodUtils.getAccessibleMethod(BaseDexClassLoader.class, "addDexPath", String.class).invoke(obj, str);
        ZeusLogger.i(ZeusLogger.TAG_LOAD, "PluginLoader createPluginClassLoader#addDexPath success >>>".concat(String.valueOf(str)));
        return true;
    }
}
