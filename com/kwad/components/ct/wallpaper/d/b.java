package com.kwad.components.ct.wallpaper.d;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.kwad.components.core.u.a.c;
import com.kwad.components.ct.response.model.CtAdTemplate;
import com.kwad.components.ct.wallpaper.widget.a;
import com.kwad.components.ct.wallpaper.widget.e;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.y;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class b {
    private static final String aZT = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/wallpaper/kwai_wallpaper_plugin_1.4.apk".substring(65);
    private static final String aZU = "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/wallpaper/kwai_wallpaper_plugin_1.5.apk".substring(65);
    private static final String aZV = Environment.getExternalStorageDirectory().getAbsolutePath();

    public static boolean Lp() {
        return bc.app() || bc.apq() || bc.anS() || bc.anT();
    }

    public static void a(final Activity activity, final CtAdTemplate ctAdTemplate, final String str, final com.kwad.components.core.u.a.b bVar) {
        if (a(activity, str)) {
            bVar.a(new com.kwad.components.core.u.a.a(str, true));
            return;
        }
        com.kwad.components.ct.wallpaper.widget.b bVar2 = new com.kwad.components.ct.wallpaper.widget.b();
        bVar2.ZS = "开启存储权限，以正常保存作品并设置壁纸。";
        bVar2.bag = "取消";
        bVar2.baf = "确定";
        com.kwad.components.ct.e.b.JK().m(ctAdTemplate, 207);
        new com.kwad.components.ct.wallpaper.widget.a(activity, bVar2, new a.InterfaceC0544a() { // from class: com.kwad.components.ct.wallpaper.d.b.1
            @Override // com.kwad.components.ct.wallpaper.widget.a.InterfaceC0544a
            public final void c(Dialog dialog) {
                dialog.dismiss();
                bVar.a(new com.kwad.components.core.u.a.a(str, false));
            }

            @Override // com.kwad.components.ct.wallpaper.widget.a.InterfaceC0544a
            public final void b(Dialog dialog) {
                dialog.dismiss();
                com.kwad.components.ct.e.b.JK().m(ctAdTemplate, 208);
                b.a(activity, str, bVar);
            }
        }).show();
    }

    public static void a(Activity activity, String str, com.kwad.components.core.u.a.b bVar) {
        if (!a(activity, str)) {
            new c(activity).a(str, bVar);
        } else {
            bVar.a(new com.kwad.components.core.u.a.a(str, true));
        }
    }

    private static boolean a(Activity activity, String str) {
        return checkSelfPermission(activity, str) == 0;
    }

    private static String permissionToOp(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    private static int noteProxyOpNoThrow(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return -1;
    }

    private static int checkPermission(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String strPermissionToOp = permissionToOp(str);
        if (strPermissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return noteProxyOpNoThrow(context, strPermissionToOp, str2) != 0 ? -1 : 0;
    }

    private static int checkSelfPermission(Context context, String str) {
        return checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static void a(final Activity activity, final CtAdTemplate ctAdTemplate, final com.kwad.sdk.core.download.b bVar) {
        if (k(activity)) {
            com.kwad.components.ct.wallpaper.widget.b bVar2 = new com.kwad.components.ct.wallpaper.widget.b();
            bVar2.ZS = "插件安装提示";
            bVar2.bah = "设置动态壁纸需先安装插件，插件，插件可使用动态壁纸更稳定省点；插件安全，可放心安装。";
            bVar2.bag = "取消";
            bVar2.baf = "确定";
            com.kwad.components.ct.e.b.JK().m(ctAdTemplate, 200);
            new com.kwad.components.ct.wallpaper.widget.a(activity, bVar2, new a.InterfaceC0544a() { // from class: com.kwad.components.ct.wallpaper.d.b.2
                @Override // com.kwad.components.ct.wallpaper.widget.a.InterfaceC0544a
                public final void c(Dialog dialog) {
                    dialog.dismiss();
                    com.kwad.components.ct.e.b.JK().m(ctAdTemplate, 201);
                    ac.ae(activity, "该功能需要安装插件");
                    bVar.a(b.Lq());
                }

                @Override // com.kwad.components.ct.wallpaper.widget.a.InterfaceC0544a
                public final void b(Dialog dialog) {
                    dialog.dismiss();
                    com.kwad.components.ct.e.b.JK().m(ctAdTemplate, 202);
                    b.c(activity, ctAdTemplate, bVar);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static DownloadTask Lq() {
        return new DownloadTask(new DownloadTask.DownloadRequest(""));
    }

    public static boolean k(Activity activity) throws NumberFormatException {
        float f = Float.parseFloat(Lr().substring(Lr().lastIndexOf(Config.replace) + 1, Lr().lastIndexOf(".")));
        String strN = n(activity, "com.kwai.kwad.wallpaper");
        float f2 = strN != null ? Float.parseFloat(strN) : 0.0f;
        if (bc.anS() || bc.anT()) {
            return !isInstalled(activity, "com.kwai.kwad.wallpaper") || f > f2;
        }
        return false;
    }

    private static String n(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return y.getPackageInfo(context, str, 0).versionName;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean isInstalled(Context context, String str) {
        if ("".equals(str)) {
            return false;
        }
        return y.getPackageInfo(context, str, 0) != null;
    }

    private static String bi(CtAdTemplate ctAdTemplate) {
        return com.kwad.components.ct.response.a.c.j((PhotoInfo) com.kwad.components.ct.response.a.a.ay(ctAdTemplate)) + "_wallpaper.mp4";
    }

    public static void b(Activity activity, CtAdTemplate ctAdTemplate, final com.kwad.sdk.core.download.b bVar) {
        final String strD = com.kwad.components.ct.response.a.c.d((PhotoInfo) com.kwad.components.ct.response.a.a.ay(ctAdTemplate));
        if (TextUtils.isEmpty(strD)) {
            bVar.a(Lq());
            return;
        }
        File file = new File(aM(activity), bi(ctAdTemplate));
        if (file.exists()) {
            bVar.A(strD, file.getAbsolutePath());
            return;
        }
        final e eVar = new e(activity);
        com.kwad.sdk.c.SL().a(new DownloadTask.DownloadRequest(strD).setDestinationDir(file.getParent()).setDestinationFileName(file.getName()), new com.kwad.sdk.core.download.b() { // from class: com.kwad.components.ct.wallpaper.d.b.3
            @Override // com.kwad.sdk.core.download.b
            public final void b(DownloadTask downloadTask, int i, int i2) {
                if (i <= 0) {
                    return;
                }
                bVar.b(downloadTask, i, i2);
                eVar.setProgress(Math.abs(Math.min((i * 100) / i2, 100)));
                if (eVar.isShowing()) {
                    return;
                }
                eVar.show();
            }

            @Override // com.kwad.sdk.core.download.b
            public final void a(DownloadTask downloadTask, Throwable th) {
                bVar.a(downloadTask, th);
                eVar.dismiss();
            }

            @Override // com.kwad.sdk.core.download.b
            public final void b(DownloadTask downloadTask) {
                eVar.dismiss();
                bVar.b(downloadTask);
                bVar.A(strD, downloadTask.getTargetFilePath());
                com.kwad.sdk.c.SL().dY(downloadTask.getId());
            }

            @Override // com.kwad.sdk.core.download.b
            public final void a(DownloadTask downloadTask) {
                eVar.dismiss();
                bVar.a(downloadTask);
                com.kwad.sdk.c.SL().dY(downloadTask.getId());
            }

            @Override // com.kwad.sdk.core.download.b
            public final void c(DownloadTask downloadTask) {
                super.c(downloadTask);
                bVar.c(downloadTask);
            }
        });
    }

    public static void a(Activity activity, String str, String str2) {
        a.a(activity, str, str2, bc.anS() || bc.anT());
    }

    public static void c(final Activity activity, final CtAdTemplate ctAdTemplate, final com.kwad.sdk.core.download.b bVar) {
        final String strFu = com.kwad.sdk.core.network.idc.a.aaw().fu(Lr());
        DownloadTask.DownloadRequest destinationFileName = new DownloadTask.DownloadRequest(strFu).setDestinationDir(aN(activity)).setDestinationFileName(Ls());
        final e eVar = new e(activity);
        com.kwad.sdk.c.SL().a(destinationFileName, new com.kwad.sdk.core.download.b() { // from class: com.kwad.components.ct.wallpaper.d.b.4
            @Override // com.kwad.sdk.core.download.b
            public final void c(DownloadTask downloadTask) {
                super.c(downloadTask);
                bVar.c(downloadTask);
            }

            @Override // com.kwad.sdk.core.download.b
            public final void b(DownloadTask downloadTask, int i, int i2) {
                if (i <= 0) {
                    return;
                }
                bVar.b(downloadTask, i, i2);
                eVar.setProgress(Math.abs(Math.min((i * 100) / i2, 100)));
                if (eVar.isShowing()) {
                    return;
                }
                eVar.show();
            }

            @Override // com.kwad.sdk.core.download.b
            public final void a(DownloadTask downloadTask, Throwable th) {
                bVar.a(downloadTask, th);
                eVar.dismiss();
                if (th instanceof Exception) {
                    com.kwad.sdk.core.network.idc.a.aaw().h(strFu, (Exception) th);
                }
            }

            @Override // com.kwad.sdk.core.download.b
            public final void b(DownloadTask downloadTask) {
                eVar.dismiss();
                bVar.b(downloadTask);
                if (new File(b.aN(activity), b.Ls()).exists()) {
                    com.kwad.components.ct.e.b.JK().m(ctAdTemplate, 206);
                    b.l(activity);
                }
                com.kwad.sdk.c.SL().dY(downloadTask.getId());
            }

            @Override // com.kwad.sdk.core.download.b
            public final void a(DownloadTask downloadTask) {
                eVar.dismiss();
                bVar.a(downloadTask);
                com.kwad.sdk.c.SL().dY(downloadTask.getId());
            }
        });
    }

    public static void l(Activity activity) {
        as.ix(aN(activity) + File.separator + Ls());
    }

    private static File aM(Context context) {
        return new File(aN(context), ".gifshowWallPaper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String aN(Context context) {
        if (Build.VERSION.SDK_INT < 29) {
            return aZV;
        }
        return context.getExternalFilesDir(null).getAbsolutePath();
    }

    private static String Lr() {
        return Build.VERSION.SDK_INT > 29 ? "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/wallpaper/kwai_wallpaper_plugin_1.5.apk" : "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/wallpaper/kwai_wallpaper_plugin_1.4.apk";
    }

    public static String Ls() {
        if (Build.VERSION.SDK_INT > 29) {
            return aZU;
        }
        return aZT;
    }
}
