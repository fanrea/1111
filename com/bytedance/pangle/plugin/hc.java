package com.bytedance.pangle.plugin;

import android.os.SystemClock;
import com.baidu.mobads.container.util.cm;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.hc;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.h;
import com.bytedance.sdk.openadsdk.api.an;
import java.io.File;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class hc implements Runnable {
    private File d;
    private final String hc;

    hc(String str, File file) {
        this.d = file;
        this.hc = str;
    }

    @Override // java.lang.Runnable
    public void run() throws JSONException {
        d();
    }

    private void hc() {
        File fileD;
        int i = 3;
        while (i > 0) {
            i--;
            try {
                File file = new File(this.d.getAbsolutePath() + "_unzip");
                if (file.exists()) {
                    file.delete();
                    file.mkdirs();
                }
                h.hc(this.d.getAbsolutePath(), file.getAbsolutePath());
                File[] fileArrListFiles = file.listFiles();
                File file2 = this.d;
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    file2 = fileArrListFiles[0];
                }
                fileD = d(file2);
            } catch (Exception e) {
                ZeusLogger.errReport(ZeusLogger.TAG_INIT, "Plugin install : unZip file failed !!!", e);
                an.d(e);
            }
            if (fileD != null && fileD.exists() && fileD.isFile()) {
                this.d = fileD;
                ZeusLogger.d("Plugin install : unZip count : " + (3 - i));
                return;
            }
        }
    }

    private File d(File file) {
        if (file.exists() || file.getParent() == null) {
            return file;
        }
        File[] fileArrListFiles = new File(file.getParent()).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length == 0) {
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.exists() && file2.getName().endsWith(".apk")) {
                return file2;
            }
        }
        return file;
    }

    private static void d(String str, int i, String str2, int i2, long j, String str3) throws JSONException {
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

    private com.bytedance.pangle.h.d.u b() {
        com.bytedance.pangle.b.d dVarD;
        if (this.d == null) {
            return null;
        }
        try {
            File file = new File(this.d.getAbsolutePath() + "_unzip");
            if (file.exists()) {
                h.d(file);
                file.mkdirs();
            }
            h.hc(this.d.getAbsolutePath(), file.getAbsolutePath());
            File[] fileArrListFiles = file.listFiles();
            LinkedList linkedList = new LinkedList();
            File file2 = null;
            for (File file3 : fileArrListFiles) {
                if (file3.getName().equals("config.json")) {
                    file2 = file3;
                } else if (file3.getName().endsWith(".dex")) {
                    linkedList.add(file3);
                }
            }
            h.d(this.d);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable Dex deleting downloadFile apkFile=" + this.d);
            this.d = file;
            if (linkedList.size() > 0 && file2 != null && file2.isFile() && (dVarD = com.bytedance.pangle.b.hc.d(file2, linkedList)) != null) {
                return new com.bytedance.pangle.h.d.u(dVarD);
            }
        } catch (Exception e) {
            an.d(e);
        }
        return null;
    }

    boolean d() throws JSONException {
        com.bytedance.pangle.h.d.u uVarD;
        File file = this.d;
        if (file != null && file.getName().endsWith(".dex.zip")) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ZeusLogger.d("Plugin install : start unDexZip file ~~~~");
            uVarD = b();
            if (uVarD != null) {
                d(com.bytedance.pangle.c.hc.h, hc.d.rf, this.hc, 0, SystemClock.elapsedRealtime() - jElapsedRealtime, "");
                ZeusLogger.d("Plugin install : finish install from unDexZip success ~~~~");
            } else {
                ZeusLogger.d("Plugin install : finish install from unDexZip fail ~~~~");
            }
        } else {
            if (h.hc(this.d)) {
                ZeusLogger.d("Plugin install : start unZip file ~~~~");
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                hc();
                d(com.bytedance.pangle.c.hc.h, hc.d.fs, this.hc, 0, SystemClock.elapsedRealtime() - jElapsedRealtime2, "");
                ZeusLogger.d("Plugin install : start install from unZip ~~~~");
            } else {
                ZeusLogger.d("Plugin install : start install without unZip ~~~~");
            }
            uVarD = com.bytedance.pangle.h.d.c.d(this.d);
        }
        if (uVarD == null) {
            ZeusPluginStateListener.postStateChange(this.hc, 7, " read local file package info failed !!! pluginPkg = " + this.hc + " mApkFile.exists = " + this.d.exists());
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable read local file package info failed !!! pluginPkg = " + this.hc);
            return false;
        }
        Plugin plugin = PluginManager.getInstance().getPlugin(uVarD.d);
        if (plugin == null) {
            ZeusPluginStateListener.postStateChange(this.hc, 7, " plugin == null !!! pluginPkg = " + this.hc);
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstallRunnable cannot query valid plugin !!! packageName = " + uVarD.d);
            return false;
        }
        boolean zInstall = plugin.install(this.d, uVarD);
        if (zInstall) {
            ZeusPluginStateListener.postStateChange(uVarD.d, 6, new Object[0]);
        } else {
            ZeusPluginStateListener.postStateChange(uVarD.d, 7, "Internal error.");
        }
        return zInstall;
    }
}
