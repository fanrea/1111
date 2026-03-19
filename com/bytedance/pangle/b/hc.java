package com.bytedance.pangle.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.hc;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.c;
import com.bytedance.pangle.tc;
import com.bytedance.pangle.u.b;
import com.bytedance.pangle.util.gb;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.tt;
import com.bytedance.pangle.util.uo;
import com.bytedance.sdk.openadsdk.api.an;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    public static int d(String str) {
        String strD;
        File[] fileArrMk;
        int i = -1;
        if (TextUtils.isEmpty(str) || (strD = b.d(str)) == null) {
            return -1;
        }
        File[] fileArrListFiles = new File(strD).listFiles(new FileFilter() { // from class: com.bytedance.pangle.b.hc.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file : fileArrListFiles) {
                int i2 = Integer.parseInt(file.getName().split("-")[1]);
                if (i2 > i && uo.d().c(str, i2) && (fileArrMk = b.mk(str, i2)) != null && fileArrMk.length > 0) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static void d(final String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strD = b.d(str);
        if (TextUtils.isEmpty(strD)) {
            return;
        }
        final String strConcat = "version-".concat(String.valueOf(i));
        new File(strD).listFiles(new FileFilter() { // from class: com.bytedance.pangle.b.hc.2
            @Override // java.io.FileFilter
            public boolean accept(File file) throws NumberFormatException {
                if (file != null && !strConcat.equals(file.getName())) {
                    h.d(file.getAbsolutePath());
                    if (file.getName().matches("^version-(\\d+)$")) {
                        uo.d().hc(str, Integer.parseInt(file.getName().split("-")[1]), false);
                    }
                }
                return false;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092 A[DONT_GENERATE, PHI: r5
  0x0092: PHI (r5v2 java.io.BufferedReader) = (r5v1 java.io.BufferedReader), (r5v4 java.io.BufferedReader) binds: [B:37:0x0090, B:22:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.pangle.b.d d(java.io.File r7, java.util.List<java.io.File> r8) throws org.json.JSONException, java.io.IOException {
        /*
            java.lang.String r0 = "Zeus/install_pangle"
            r1 = 0
            if (r7 == 0) goto La7
            if (r8 == 0) goto La7
            int r2 = r8.size()
            if (r2 <= 0) goto La7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75
            r2.<init>()     // Catch: java.lang.Throwable -> L75
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L75
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L75
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L72
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L6f
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L6f
        L21:
            java.lang.String r6 = r5.readLine()     // Catch: java.lang.Throwable -> L6d
            if (r6 == 0) goto L2b
            r2.append(r6)     // Catch: java.lang.Throwable -> L6d
            goto L21
        L2b:
            com.bytedance.pangle.tc r6 = com.bytedance.pangle.tc.d()     // Catch: java.lang.Throwable -> L6d
            com.bytedance.pangle.ZeusPluginDecodeCallback r6 = r6.c()     // Catch: java.lang.Throwable -> L6d
            if (r6 == 0) goto L61
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = r6.decode(r2)     // Catch: java.lang.Throwable -> L6d
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L6d
            if (r6 != 0) goto L5b
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6d
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L6d
            java.lang.String r2 = "DexPluginUtils parse dex config json success"
            com.bytedance.pangle.log.ZeusLogger.i(r0, r2)     // Catch: java.lang.Throwable -> L6d
            com.bytedance.pangle.b.d r7 = com.bytedance.pangle.b.d.d(r6, r7, r8)     // Catch: java.lang.Throwable -> L6d
            r3.close()
            r4.close()
            r5.close()
            return r7
        L5b:
            java.lang.String r7 = "DexPluginUtils parse dex config fail decode content is empty"
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L6d
            goto L66
        L61:
            java.lang.String r7 = "DexPluginUtils parse dex config fail decode callback is null"
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L6d
        L66:
            r3.close()
            r4.close()
            goto L92
        L6d:
            r7 = move-exception
            goto L79
        L6f:
            r7 = move-exception
            r5 = r1
            goto L79
        L72:
            r7 = move-exception
            r4 = r1
            goto L78
        L75:
            r7 = move-exception
            r3 = r1
            r4 = r3
        L78:
            r5 = r4
        L79:
            java.lang.String r8 = "DexPluginUtils parse dex config fail throw error "
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L96
            java.lang.String r7 = r8.concat(r7)     // Catch: java.lang.Throwable -> L96
            com.bytedance.pangle.log.ZeusLogger.w(r0, r7)     // Catch: java.lang.Throwable -> L96
            if (r3 == 0) goto L8b
            r3.close()
        L8b:
            if (r4 == 0) goto L90
            r4.close()
        L90:
            if (r5 == 0) goto La7
        L92:
            r5.close()
            goto La7
        L96:
            r7 = move-exception
            if (r3 == 0) goto L9c
            r3.close()
        L9c:
            if (r4 == 0) goto La1
            r4.close()
        La1:
            if (r5 == 0) goto La6
            r5.close()
        La6:
            throw r7
        La7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.b.hc.d(java.io.File, java.util.List):com.bytedance.pangle.b.d");
    }

    public static boolean d(d dVar, long j) throws JSONException {
        List<File> listC;
        File fileU = null;
        if (dVar != null) {
            listC = dVar.c();
            fileU = dVar.u();
        } else {
            listC = null;
        }
        if (fileU != null && listC != null && listC.size() > 0) {
            int iB = dVar.b();
            String strHc = dVar.hc();
            ZeusPluginStateListener.postStateChange(strHc, 11, new Object[0]);
            com.bytedance.pangle.plugin.b.d(com.bytedance.pangle.c.hc.c, hc.d.yo, strHc, iB, -1L, null);
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex start packageName = " + strHc + " version is " + iB);
            String strMk = uo.d().mk(strHc);
            if (!TextUtils.isEmpty(strMk) && d(strMk) >= iB) {
                com.bytedance.pangle.plugin.b.d(com.bytedance.pangle.c.hc.u, hc.d.jh, strHc, iB, -1L, "dex installed version more than download version can no install new dex zip");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("dex installed version more than download version can no install new dex zip"));
                return false;
            }
            String strH = TextUtils.isEmpty(dVar.h()) ? strHc : dVar.h();
            if (!b.tc(strH, iB)) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex no dir need install packageName=" + strHc + " version=" + iB);
                    for (File file : listC) {
                        if (file.getName().endsWith(".dex")) {
                            String strD = b.d(strH, iB, file.getName());
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex = " + file.getName());
                            gb.d(file.getAbsolutePath(), strD);
                        }
                    }
                    if (fileU.getName().endsWith(".json")) {
                        String strMq = b.mq(strH, iB);
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex config = " + fileU.getName());
                        gb.d(fileU.getAbsolutePath(), strMq);
                    }
                    if (b.tc(strH, iB)) {
                        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex success packageName = " + strHc + " version = " + iB);
                        ZeusPluginStateListener.postStateChange(strHc, 12, new Object[0]);
                        com.bytedance.pangle.plugin.b.d(com.bytedance.pangle.c.hc.u, hc.d.rf, strHc, iB, SystemClock.elapsedRealtime() - j, "install success");
                        uo.d().hc(strH, iB, true);
                        if (!TextUtils.isEmpty(dVar.h())) {
                            uo.d().b(strHc, strH);
                            uo.d().c(strHc, strMk);
                        }
                        return true;
                    }
                    com.bytedance.pangle.plugin.b.d(com.bytedance.pangle.c.hc.u, hc.d.jh, strHc, iB, -1L, "install dir not exists");
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils ".concat("install dir not exists"));
                } catch (Exception e) {
                    com.bytedance.pangle.plugin.b.d(com.bytedance.pangle.c.hc.u, hc.d.jh, strHc, iB, -1L, "throw exception: ".concat(String.valueOf(e)));
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail throw exception");
                    an.d(e);
                }
            } else {
                com.bytedance.pangle.plugin.b.d(com.bytedance.pangle.c.hc.u, hc.d.rf, strHc, iB, SystemClock.elapsedRealtime() - j, "install success 已经安装完成");
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex already install packageName = " + strHc + " version = " + iB);
                return true;
            }
        } else {
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginUtils install dex fail config is null");
        }
        return false;
    }

    private static String hc(String str) {
        return (str == null || !str.endsWith(":")) ? str : str.substring(0, str.length() - 1);
    }

    public static boolean d(Plugin plugin, StringBuilder sb) {
        try {
            if (plugin == null) {
                sb.append("loadDexPlugin fail, plugin == null;");
                return false;
            }
            if (!plugin.isInstalled()) {
                sb.append("loadDexPlugin fail, plugin is not installed");
                return false;
            }
            if (!(plugin instanceof com.bytedance.pangle.plugin.d)) {
                sb.append("loadDexPlugin fail, plugin must be dexPlugin");
                return false;
            }
            String strMk = uo.d().mk(plugin.mPkgName);
            if (TextUtils.isEmpty(strMk)) {
                strMk = plugin.mPkgName;
            }
            int iD = d(strMk);
            if (iD == -1) {
                sb.append("loadDexPlugin fail, get Plugin version is -1");
                return false;
            }
            File[] fileArrMk = b.mk(strMk, iD);
            if (fileArrMk != null && fileArrMk.length != 0) {
                String strMq = b.mq(strMk, iD);
                if (TextUtils.isEmpty(strMq)) {
                    sb.append("loadDexPlugin fail, configFileString is empty");
                    return false;
                }
                File file = new File(strMq);
                if (file.exists() && file.isFile()) {
                    d dVarD = d(file, (List<File>) Arrays.asList(fileArrMk));
                    ((com.bytedance.pangle.plugin.d) plugin).d(dVarD);
                    if (dVarD == null) {
                        sb.append("loadDexPlugin fail, config is null");
                        return false;
                    }
                    if (!dVarD.d()) {
                        sb.append("loadDexPlugin fail, check dex fail");
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    for (File file2 : fileArrMk) {
                        if (file2.isFile()) {
                            sb2.append(file2.getAbsolutePath());
                            sb2.append(":");
                        }
                    }
                    String strHc = hc(sb2.toString());
                    if (TextUtils.isEmpty(strHc)) {
                        sb.append("loadDexPlugin fail, dexPath is empty");
                        return false;
                    }
                    Map<String, JSONObject> mapU = tc.d().u();
                    if (mapU != null && mapU.size() != 0) {
                        JSONObject jSONObject = mapU.get(plugin.mPkgName);
                        if (jSONObject != null && jSONObject.has("hostPackageName")) {
                            String strOptString = jSONObject.optString("hostPackageName");
                            if (TextUtils.isEmpty(strOptString)) {
                                sb.append("loadDexPlugin fail, hostPackageName is empty");
                                return false;
                            }
                            Plugin plugin2 = Zeus.getPlugin(strOptString);
                            if (plugin2 != null) {
                                if (tt.mk()) {
                                    sb.append("loadDexPlugin addDexPath success dexPath=".concat(String.valueOf(strHc)));
                                    return c.d(plugin2.mClassLoader, strHc);
                                }
                                if (plugin2.mClassLoader != null) {
                                    ArrayList arrayList = new ArrayList(1);
                                    arrayList.add(new PluginClassLoader(strHc, null, null, null));
                                    sb.append("loadDexPlugin setOtherPluginClassLoader success dexPath=").append(strHc);
                                    plugin2.mClassLoader.setOtherPluginClassLoader(arrayList);
                                    return true;
                                }
                                sb.append("loadDexPlugin fail classLoader is null");
                                return false;
                            }
                            sb.append("loadDexPlugin fail, hostPlugin is null hostPackageName=").append(strOptString);
                            return false;
                        }
                        sb.append("loadDexPlugin fail, dex config can not get hostPackageName");
                        return false;
                    }
                    sb.append("loadDexPlugin fail, getPackageDexManager is empty");
                    return false;
                }
                sb.append("loadDexPlugin fail, config file is not exists or is not file");
                return false;
            }
            sb.append("loadDexPlugin fail, get dex files is null or length is 0");
            return false;
        } catch (Throwable th) {
            sb.append("loadDexPlugin fail, throw error ").append(th);
            return false;
        }
    }
}
