package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.ss.android.socialbase.appdownloader.u.c;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.hc.u;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class d extends Fragment {
    public void d() {
        try {
            try {
                try {
                    startActivityForResult(an(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(hc(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(c(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(b(), 1000);
        }
    }

    public Intent hc() {
        Context contextU = u();
        if (contextU == null) {
            return null;
        }
        String packageName = contextU.getPackageName();
        if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (lowerCase.contains(u.b)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            }
            if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextU.getPackageName()));
    }

    private Context u() {
        Context contextTr = b.tr();
        return (contextTr != null || getActivity() == null || getActivity().isFinishing()) ? contextTr : getActivity().getApplicationContext();
    }

    public Intent b() {
        Context contextU = u();
        if (contextU == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + contextU.getPackageName()));
    }

    private Intent an() {
        Context contextU = u();
        if (contextU == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = contextU.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = contextU.getApplicationInfo().uid;
        intent.putExtra(Config.CUSTOM_USER_ID, i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    public static Intent c() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (c.d()) {
            c.d(true);
        } else {
            c.d(false);
        }
    }
}
