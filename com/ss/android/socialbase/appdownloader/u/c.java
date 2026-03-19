package com.ss.android.socialbase.appdownloader.u;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.view.KeyEvent;
import com.bytedance.sdk.component.utils.mq;
import com.ss.android.socialbase.appdownloader.b.e;
import com.ss.android.socialbase.appdownloader.tt;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class c {
    private static com.ss.android.socialbase.appdownloader.view.d b = null;
    private static AlertDialog c = null;
    private static final String d = "c";
    private static List<e> hc = new ArrayList();

    public static boolean d() {
        try {
            return hc();
        } catch (Throwable th) {
            mq.d(th);
            return true;
        }
    }

    private static boolean hc() throws ClassNotFoundException {
        Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        NotificationManager notificationManager = (NotificationManager) contextTr.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 24) {
            return notificationManager.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) contextTr.getSystemService("appops");
            ApplicationInfo applicationInfo = contextTr.getApplicationInfo();
            String packageName = contextTr.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                return ((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
        }
        return true;
    }

    public static synchronized void d(boolean z) {
        try {
            AlertDialog alertDialog = c;
            if (alertDialog != null) {
                alertDialog.cancel();
                c = null;
            }
            for (e eVar : hc) {
                if (eVar != null) {
                    if (z) {
                        eVar.d();
                    } else {
                        eVar.hc();
                    }
                }
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    public static synchronized void d(final Activity activity, final e eVar) {
        if (eVar == null) {
            return;
        }
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    int iD = tt.d(com.ss.android.socialbase.downloader.downloader.b.tr(), "tt_appdownloader_notification_request_title");
                    int iD2 = tt.d(com.ss.android.socialbase.downloader.downloader.b.tr(), "tt_appdownloader_notification_request_message");
                    int iD3 = tt.d(com.ss.android.socialbase.downloader.downloader.b.tr(), "tt_appdownloader_notification_request_btn_yes");
                    int iD4 = tt.d(com.ss.android.socialbase.downloader.downloader.b.tr(), "tt_appdownloader_notification_request_btn_no");
                    hc.add(eVar);
                    AlertDialog alertDialog = c;
                    if (alertDialog == null || !alertDialog.isShowing()) {
                        c = new AlertDialog.Builder(activity).setTitle(iD).setMessage(iD2).setPositiveButton(iD3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.u.c.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                c.hc(activity, eVar);
                                dialogInterface.cancel();
                                AlertDialog unused = c.c = null;
                            }
                        }).setNegativeButton(iD4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.u.c.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                c.d(false);
                            }
                        }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.ss.android.socialbase.appdownloader.u.c.1
                            @Override // android.content.DialogInterface.OnKeyListener
                            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                                if (i != 4) {
                                    return false;
                                }
                                if (keyEvent.getAction() == 1) {
                                    c.d(false);
                                }
                                return true;
                            }
                        }).setCancelable(false).show();
                    }
                    return;
                }
            } catch (Throwable th) {
                mq.d(th);
                d(false);
                return;
            }
        }
        eVar.hc();
    }

    public static void hc(Activity activity, e eVar) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    FragmentManager fragmentManager = activity.getFragmentManager();
                    String str = d;
                    com.ss.android.socialbase.appdownloader.view.d dVar = (com.ss.android.socialbase.appdownloader.view.d) fragmentManager.findFragmentByTag(str);
                    b = dVar;
                    if (dVar == null) {
                        b = new com.ss.android.socialbase.appdownloader.view.d();
                        fragmentManager.beginTransaction().add(b, str).commitAllowingStateLoss();
                        try {
                            fragmentManager.executePendingTransactions();
                        } catch (Throwable th) {
                            mq.d(th);
                        }
                    }
                    b.d();
                    return;
                }
            } catch (Throwable th2) {
                try {
                    mq.d(th2);
                    eVar.d();
                    return;
                } catch (Throwable th3) {
                    mq.d(th3);
                    return;
                }
            }
        }
        eVar.d();
    }

    public static void d(int i) {
        if (Build.VERSION.SDK_INT < 33 || com.ss.android.socialbase.downloader.uo.d.d(i).hc("enable_target_34") <= 0 || d()) {
            return;
        }
        Context contextTr = com.ss.android.socialbase.downloader.downloader.b.tr();
        try {
            Intent intent = new Intent(contextTr, (Class<?>) DownloadHandleNotificationActivity.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_REQUEST_PERMISSION");
            intent.addFlags(268435456);
            contextTr.startActivity(intent);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.an.d.u(d, "requestNotificationPermissionError2:".concat(String.valueOf(th)));
        }
    }
}
