package com.bytedance.pangle.plugin;

import android.content.pm.PackageInfo;
import com.alipay.sdk.m.u.i;
import com.baidu.mobads.container.util.cm;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.an.an;
import com.bytedance.pangle.c.hc;
import com.bytedance.pangle.d.d;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.tc;
import com.bytedance.pangle.util.gb;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.tt;
import com.bytedance.pangle.util.uo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private static final tc d = tc.d();

    static boolean d(final File file, final String str, final int i) throws JSONException {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("useOpt;");
        final boolean[] zArr = {false};
        try {
            tc tcVar = d;
            tcVar.d(1000, 0, str, i, null);
            com.bytedance.pangle.log.d dVarD = com.bytedance.pangle.log.d.d(ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(String.valueOf(str)));
            d(com.bytedance.pangle.c.hc.c, hc.d.yo, str, i, -1L, null);
            hc(str, i);
            h.d(com.bytedance.pangle.u.b.d(str, i));
            com.bytedance.pangle.d.d.d(false, new d.InterfaceC0251d() { // from class: com.bytedance.pangle.plugin.b.1
                @Override // com.bytedance.pangle.d.d.InterfaceC0251d
                public void d() throws Throwable {
                    b.an(file, str, i, stringBuffer);
                }
            }, new d.InterfaceC0251d() { // from class: com.bytedance.pangle.plugin.b.2
                @Override // com.bytedance.pangle.d.d.InterfaceC0251d
                public void d() throws Throwable {
                    final Map mapH = b.h(file, str, i, stringBuffer);
                    b.gb(file, str, i, stringBuffer);
                    b.hc(b.tt(file, str, i, stringBuffer), str, i, stringBuffer);
                    if (tt.gb() || tt.b()) {
                        final boolean[] zArr2 = {false};
                        com.bytedance.pangle.d.d.d(false, new d.InterfaceC0251d() { // from class: com.bytedance.pangle.plugin.b.2.1
                            @Override // com.bytedance.pangle.d.d.InterfaceC0251d
                            public void d() throws Throwable {
                                b.hc(str, i, (Map<String, List<ZipEntry>>) mapH, stringBuffer);
                            }
                        }, new d.InterfaceC0251d() { // from class: com.bytedance.pangle.plugin.b.2.2
                            @Override // com.bytedance.pangle.d.d.InterfaceC0251d
                            public void d() throws Throwable {
                                zArr2[0] = b.tc(file, str, i, stringBuffer);
                            }
                        });
                        zArr[0] = b.hc(str, i, zArr2[0], stringBuffer);
                    } else {
                        b.hc(str, i, (Map<String, List<ZipEntry>>) mapH, stringBuffer);
                        zArr[0] = b.hc(str, i, false, stringBuffer);
                        b.b(str, i);
                    }
                }
            });
            h.d(file);
            d(com.bytedance.pangle.c.hc.u, hc.d.rf, str, i, dVarD.d(), stringBuffer.toString());
            dVarD.d("success");
            tcVar.d(1100, 0, str, i, null);
            return true;
        } catch (Throwable th) {
            if (th instanceof d) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                d(com.bytedance.pangle.c.hc.u, hc.d.jh, str, i, -1L, stringBuffer.toString());
                d.d(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                uo.d().d(str, i, Config.INPUT_INSTALLED_PKG);
            }
            return false;
        }
    }

    private static void hc(String str, int i) {
        int iHc = uo.d().hc(str, i, Config.INPUT_INSTALLED_PKG);
        int iHc2 = uo.d().hc(str, i, "load");
        int removeApkEntryFlag = GlobalParam.getInstance().getRemoveApkEntryFlag(str);
        if (iHc > 3 || iHc2 > 3) {
            removeApkEntryFlag = 0;
        }
        uo.d().d(str, i, removeApkEntryFlag);
        uo.d().c(str, i, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hc(String str, int i, boolean z, StringBuffer stringBuffer) {
        int iTt = uo.d().tt(str, i);
        boolean z2 = (iTt & 1) != 0;
        boolean z3 = (iTt & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        String strHc = com.bytedance.pangle.u.b.hc(str, i);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zD = com.bytedance.pangle.util.hc.hc.d(strHc, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        return zD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(String str, String str2, int i, StringBuffer stringBuffer) throws JSONException, d {
        long jCurrentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        int iD = new com.bytedance.pangle.res.d.b().d(new File(str), false, sb);
        stringBuffer.append(iD == 100 ? "modifyRes" : "noModifyRes").append(" cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        if (iD == 100 || iD == 200) {
            return;
        }
        String string = sb.toString();
        d(com.bytedance.pangle.c.hc.u, hc.d.zw, str2, i, -1L, string);
        d.d(1100, -2, str2, i, null);
        throw new d("modifyRes failed. result = " + iD + ", errorLog = " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void an(File file, String str, int i, StringBuffer stringBuffer) throws d {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.gb.u.d(file.getAbsolutePath(), str)) {
                } else {
                    throw new RuntimeException("安装包签名校验失败[1]");
                }
            } catch (Exception e) {
                d(com.bytedance.pangle.c.hc.u, hc.d.sy, str, i, -1L, null);
                d.d(1100, -3, str, i, e);
                throw new d(e.getMessage(), e);
            }
        } finally {
            stringBuffer.append("checkSignature cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, List<ZipEntry>> h(File file, String str, int i, StringBuffer stringBuffer) throws d {
        String str2 = "插件包包含so不符合宿主ABI类型";
        if (!GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.util.u<Boolean, Map<String, List<ZipEntry>>> uVarD = com.bytedance.pangle.u.hc.d(file);
                boolean zBooleanValue = uVarD.d.booleanValue();
                Map<String, List<ZipEntry>> map = uVarD.hc;
                if (zBooleanValue) {
                    return map;
                }
                throw new d(str2);
            } catch (Exception e) {
                d(com.bytedance.pangle.c.hc.u, hc.d.vv, str, i, -1L, null);
                d.d(1100, -5, str, i, e);
                throw new d(str2, e);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gb(File file, String str, int i, StringBuffer stringBuffer) throws d {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                PackageInfo packageInfo = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 4096);
                PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                List listAsList = Arrays.asList(packageInfo.requestedPermissions);
                if (packageArchiveInfo.requestedPermissions != null && packageArchiveInfo.requestedPermissions.length > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!listAsList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        if (GlobalParam.getInstance().checkPermission()) {
                            throw new d("The following permissions are declared in the plugin but not in the host: ".concat(String.valueOf(arrayList)));
                        }
                    }
                }
            } catch (Exception e) {
                d(com.bytedance.pangle.c.hc.u, hc.d.de, str, i, -1L, null);
                d.d(1100, -4, str, i, e);
                throw new d("安装包权限校验失败", e);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String tt(File file, String str, int i, StringBuffer stringBuffer) throws d {
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strHc = com.bytedance.pangle.u.b.hc(str, i);
        try {
            try {
                gb.d(file.getAbsolutePath(), strHc);
                return strHc;
            } catch (Exception e) {
                d(com.bytedance.pangle.c.hc.u, hc.d.v, str, i, -1L, null);
                d.d(1100, -6, str, i, e);
                throw new d("安装包拷贝失败", e);
            }
        } finally {
            stringBuffer.append("copyApk cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hc(String str, int i, Map<String, List<ZipEntry>> map, StringBuffer stringBuffer) throws d {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.u.hc.d(new File(com.bytedance.pangle.u.b.hc(str, i)), new File(com.bytedance.pangle.u.b.c(str, i)), str, map);
            } catch (Exception e) {
                d(com.bytedance.pangle.c.hc.u, hc.d.np, str, i, -1L, com.bytedance.pangle.log.hc.d((Object) e));
                d.d(1100, -7, str, i, e);
                throw new d("安装包动态库拷贝失败", e);
            }
        } finally {
            stringBuffer.append("copySo cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tc(File file, String str, int i, StringBuffer stringBuffer) throws d {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (tt.b()) {
                    com.bytedance.pangle.an.h.d(file, str, i);
                    com.bytedance.pangle.an.hc.d(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                    an.d();
                } else if (tt.gb()) {
                    String strB = com.bytedance.pangle.u.b.b(str, i);
                    String strHc = com.bytedance.pangle.u.b.hc(str, i);
                    String str2 = strB + File.separator + com.bytedance.pangle.an.hc.d(strHc);
                    if (com.bytedance.pangle.an.hc.d(strHc, strB + File.separator + com.bytedance.pangle.an.hc.d(strHc)) && com.bytedance.pangle.an.hc.d(str2)) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                d(com.bytedance.pangle.c.hc.u, hc.d.he, str, i, -1L, null);
                throw new d("dexOpt1失败", e);
            }
        } finally {
            stringBuffer.append("dexOpt1 cost:").append(System.currentTimeMillis() - jCurrentTimeMillis).append(i.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, int i) throws JSONException, d {
        try {
            if (tt.h() || tt.tt()) {
                uo.d().b(str, i, false);
                com.bytedance.pangle.an.hc.d(Zeus.getAppApplication()).edit().putInt(str, i).apply();
                an.d();
            }
        } catch (Exception e) {
            d(com.bytedance.pangle.c.hc.u, hc.d.he, str, i, -1L, null);
            throw new d("dexOpt2失败", e);
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
            com.bytedance.sdk.openadsdk.api.an.d(e);
        }
        com.bytedance.pangle.c.hc.d().d(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static class d extends IOException {
        private d(String str) {
            super(str);
        }

        private d(String str, Throwable th) {
            super(str, th);
        }
    }
}
