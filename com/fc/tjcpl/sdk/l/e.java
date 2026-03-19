package com.fc.tjcpl.sdk.l;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.fc.tjcpl.sdk.h.a;
import com.fc.tjcpl.sdk.h.h;
import com.fc.tjcpl.sdk.h.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e {

    public class a implements j {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        public a(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // com.fc.tjcpl.sdk.h.j
        public void a(int i, String str) {
        }

        @Override // com.fc.tjcpl.sdk.h.j
        public void a(Object obj) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            String str = d.a().a(com.fc.tjcpl.sdk.b.a.b(), com.fc.tjcpl.sdk.b.a.e(this.a), "") + "@" + this.b;
            d dVarA = d.a();
            Application applicationB = com.fc.tjcpl.sdk.b.a.b();
            String strE = com.fc.tjcpl.sdk.b.a.e(this.a);
            dVarA.getClass();
            SharedPreferences.Editor editorEdit = applicationB.getSharedPreferences("TJSetting", 0).edit();
            editorEdit.putString(strE, str);
            editorEdit.commit();
        }
    }

    public static void a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.getWindow().setStatusBarColor(i);
            boolean z = (i & 255) >= 187 && ((65280 & i) >> 8) >= 187 && ((i & 16711680) >> 16) >= 187;
            View decorView = activity.getWindow().getDecorView();
            if (z) {
                decorView.setSystemUiVisibility(8192);
            } else {
                decorView.setSystemUiVisibility(0);
            }
        }
    }

    public static void a(String str, String str2, String str3) throws Throwable {
        FileInputStream fileInputStream;
        int iAvailable;
        if (TextUtils.isEmpty(str2) || !com.fc.tjcpl.sdk.b.a.b(str2)) {
            return;
        }
        File file = new File(str3);
        if (!file.exists() || !file.isFile()) {
            return;
        }
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[1];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    iAvailable = fileInputStream.available();
                } catch (FileNotFoundException e) {
                    e = e;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e2) {
                            e = e2;
                            iAvailable = 0;
                            e.printStackTrace();
                            com.fc.tjcpl.sdk.i.c.a("apk file size is :" + iAvailable);
                            objArr[0] = Float.valueOf(iAvailable / 1048576.0f);
                            String str4 = String.format(locale, "%.1f", objArr);
                            file.delete();
                            f.a().a("已删除《" + str + "》APK安装包，节省 " + str4 + " M空间", 0);
                        }
                    }
                    iAvailable = 0;
                    com.fc.tjcpl.sdk.i.c.a("apk file size is :" + iAvailable);
                    objArr[0] = Float.valueOf(iAvailable / 1048576.0f);
                    String str42 = String.format(locale, "%.1f", objArr);
                    file.delete();
                    f.a().a("已删除《" + str + "》APK安装包，节省 " + str42 + " M空间", 0);
                } catch (IOException e3) {
                    e = e3;
                    fileInputStream2 = fileInputStream;
                    e.printStackTrace();
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    iAvailable = 0;
                    com.fc.tjcpl.sdk.i.c.a("apk file size is :" + iAvailable);
                    objArr[0] = Float.valueOf(iAvailable / 1048576.0f);
                    String str422 = String.format(locale, "%.1f", objArr);
                    file.delete();
                    f.a().a("已删除《" + str + "》APK安装包，节省 " + str422 + " M空间", 0);
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
            } catch (IOException e6) {
                e = e6;
            }
            try {
                fileInputStream.close();
            } catch (IOException e7) {
                e = e7;
                e.printStackTrace();
                com.fc.tjcpl.sdk.i.c.a("apk file size is :" + iAvailable);
                objArr[0] = Float.valueOf(iAvailable / 1048576.0f);
                String str4222 = String.format(locale, "%.1f", objArr);
                file.delete();
                f.a().a("已删除《" + str + "》APK安装包，节省 " + str4222 + " M空间", 0);
            }
            com.fc.tjcpl.sdk.i.c.a("apk file size is :" + iAvailable);
            objArr[0] = Float.valueOf(iAvailable / 1048576.0f);
            String str42222 = String.format(locale, "%.1f", objArr);
            file.delete();
            f.a().a("已删除《" + str + "》APK安装包，节省 " + str42222 + " M空间", 0);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static void a(String str, int i, String str2, int i2) {
        String strA = d.a().a(com.fc.tjcpl.sdk.b.a.b(), com.fc.tjcpl.sdk.b.a.e(str), "");
        if (TextUtils.isEmpty(strA) || !strA.contains(String.valueOf(i))) {
            a.C0361a c0361a = new a.C0361a();
            c0361a.a = str;
            c0361a.b = i;
            c0361a.c = str2;
            c0361a.d = i2;
            h.a().a(new com.fc.tjcpl.sdk.h.a(c0361a), new com.fc.tjcpl.sdk.h.d(), new a(str, i));
        }
    }
}
