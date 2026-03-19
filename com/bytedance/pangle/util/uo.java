package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class uo {
    private static volatile uo d;
    private SharedPreferences hc = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    public static uo d() {
        if (d == null) {
            synchronized (uo.class) {
                if (d == null) {
                    d = new uo();
                }
            }
        }
        return d;
    }

    private uo() {
    }

    public void d(String str) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putString("ROM_LAST_".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
        editorEdit.apply();
    }

    public boolean hc(String str) {
        return !TextUtils.isEmpty(this.hc.getString("HOST_ABI_".concat(String.valueOf(str)), ""));
    }

    public boolean b(String str) {
        boolean z = !TextUtils.equals(this.hc.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + this.hc.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
        return z;
    }

    public void c(String str) {
        String string = this.hc.getString("HOST_ABI_".concat(String.valueOf(str)), "");
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putString("HOST_ABI_".concat(String.valueOf(str)), Zeus.getHostAbi());
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
    }

    public int u(String str) {
        int i = this.hc.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
        return i;
    }

    public void d(String str, int i) {
        int iU = u(str);
        if (iU != i) {
            SharedPreferences.Editor editorEdit = this.hc.edit();
            editorEdit.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), i);
            editorEdit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + iU + " --> " + i);
    }

    public String an(String str) {
        String string = this.hc.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public void d(String str, String str2) {
        String strAn = an(str);
        if (!TextUtils.equals(strAn, str2)) {
            SharedPreferences.Editor editorEdit = this.hc.edit();
            editorEdit.putString("HOST_IDENTITY_".concat(String.valueOf(str)), str2);
            editorEdit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str + ") " + strAn + " --> " + str2);
    }

    public void d(String str, int i, int i2, int i3) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putInt("API_MIN_" + str + Config.replace + i, i2);
        editorEdit.putInt("API_MAX_" + str + Config.replace + i, i3);
        editorEdit.apply();
    }

    public int hc(String str, int i) {
        return this.hc.getInt("API_MIN_" + str + Config.replace + i, 0);
    }

    public int b(String str, int i) {
        int i2 = this.hc.getInt("API_MAX_" + str + Config.replace + i, Integer.MAX_VALUE);
        if (i2 == 0) {
            return Integer.MAX_VALUE;
        }
        return i2;
    }

    public void d(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        String str2 = "DISABLE_DOWNLOAD_" + str + Config.replace + i;
        if (z) {
            editorEdit.putInt(str2, 0);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " disable=" + z);
    }

    public void h(String str) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
    }

    public void gb(String str) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.remove("UNINSTALL__".concat(String.valueOf(str)));
        editorEdit.apply();
    }

    public boolean tt(String str) {
        return this.hc.getBoolean("UNINSTALL__".concat(String.valueOf(str)), false);
    }

    public String tc(String str) {
        return this.hc.getString("IDENTITY_".concat(String.valueOf(str)), "");
    }

    public void hc(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putString("IDENTITY_".concat(String.valueOf(str)), str2);
        editorEdit.apply();
    }

    public void hc(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        String str2 = "INSTALLED_" + str + "-" + i;
        if (z) {
            editorEdit.putBoolean(str2, true);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
    }

    public boolean c(String str, int i) {
        return this.hc.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i)), false);
    }

    public void u(String str, int i) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), i);
        editorEdit.apply();
    }

    public boolean an(String str, int i) {
        return this.hc.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", str), -1) == i;
    }

    public void b(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putBoolean("dex_opt_state_" + str + Config.replace + i, z);
        editorEdit.apply();
    }

    public boolean h(String str, int i) {
        return this.hc.getBoolean("dex_opt_state_" + str + Config.replace + i, false);
    }

    public boolean gb(String str, int i) {
        return this.hc.getBoolean("dex_remove_state_" + str + Config.replace + i, false);
    }

    public void c(String str, int i, boolean z) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putBoolean("dex_remove_state_" + str + Config.replace + i, z);
        editorEdit.apply();
    }

    public void d(String str, int i, int i2) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putInt("remove_entry_flag_" + str + Config.replace + i, i2);
        editorEdit.apply();
    }

    public int tt(String str, int i) {
        return this.hc.getInt("remove_entry_flag_" + str + Config.replace + i, 0);
    }

    public void d(String str, int i, String str2) {
        int iHc = hc(str, i, str2);
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putInt(str2 + "_failed_count_when_rm_entry_" + str + Config.replace + i, iHc + 1);
        editorEdit.apply();
    }

    public int hc(String str, int i, String str2) {
        return this.hc.getInt(str2 + "_failed_count_when_rm_entry_" + str + Config.replace + i, 0);
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strD = an.d(str);
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putString("ALIAS_".concat(String.valueOf(strD)), str2);
        editorEdit.apply();
    }

    public String mk(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.hc.getString("ALIAS_".concat(String.valueOf(an.d(str))), "");
    }

    public void mq(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strD = an.d(str);
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.remove("ALIAS_".concat(String.valueOf(strD)));
        editorEdit.apply();
    }

    public void c(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.hc.edit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strD = an.d(str);
        String string = this.hc.getString("ALIAS_LAST_TIME_".concat(String.valueOf(strD)), "");
        if (TextUtils.isEmpty(string)) {
            editorEdit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(strD)), str2);
        } else {
            editorEdit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(strD)), string + Config.replace + str2);
        }
        editorEdit.apply();
    }

    public List<String> uo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.hc.getString("ALIAS_LAST_TIME_".concat(String.valueOf(an.d(str))), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Arrays.asList(string.split(Config.replace));
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strD = an.d(str);
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.remove("ALIAS_LAST_TIME_".concat(String.valueOf(strD)));
        editorEdit.apply();
    }
}
