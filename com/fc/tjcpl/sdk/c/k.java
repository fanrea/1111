package com.fc.tjcpl.sdk.c;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class k implements Runnable {
    public com.fc.tjcpl.sdk.f.b a;
    public e b;
    public com.fc.tjcpl.sdk.e.d c;

    public k(com.fc.tjcpl.sdk.f.b bVar, e eVar, com.fc.tjcpl.sdk.e.d dVar) {
        this.a = bVar;
        this.b = eVar;
        this.c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() throws NoSuchAlgorithmException, PackageManager.NameNotFoundException, IOException {
        String string;
        String str = this.a.i.d;
        com.fc.tjcpl.sdk.g.a aVar = new com.fc.tjcpl.sdk.g.a();
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = com.fc.tjcpl.sdk.b.a.b().getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null) {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    com.fc.tjcpl.sdk.g.a aVar2 = new com.fc.tjcpl.sdk.g.a();
                    applicationInfo.loadIcon(packageManager);
                    applicationInfo.loadLabel(packageManager).toString();
                    aVar2.a = applicationInfo.sourceDir;
                    aVar = aVar2;
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        String str2 = aVar.a;
        if (!TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            byte[] bArr = new byte[8192];
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i <= 0) {
                        break;
                    } else {
                        messageDigest.update(bArr, 0, i);
                    }
                }
                fileInputStream.close();
                byte[] bArrDigest = messageDigest.digest();
                if (bArrDigest == null) {
                    string = null;
                } else {
                    StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
                    for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                        sb.append(com.fc.tjcpl.sdk.g.b.a[(bArrDigest[i2] >>> 4) & 15]);
                        sb.append(com.fc.tjcpl.sdk.g.b.a[bArrDigest[i2] & 15]);
                    }
                    string = sb.toString();
                }
            } catch (Exception unused) {
                System.out.println("md5 file error");
                string = "";
            }
            if (!TextUtils.isEmpty(string)) {
                String lowerCase = string.toLowerCase();
                com.fc.tjcpl.sdk.i.c.b("tag", "file md5 lower:" + lowerCase + ",up:" + string);
                if (this.a.i.e.contains(string) || this.a.i.e.contains(lowerCase)) {
                    com.fc.tjcpl.sdk.f.b bVar = this.a;
                    bVar.h = 8;
                    this.b.h(bVar.i);
                } else {
                    com.fc.tjcpl.sdk.f.b bVar2 = this.a;
                    bVar2.h = 10;
                    this.b.f(bVar2.i);
                }
                com.fc.tjcpl.sdk.e.d dVar = this.c;
                if (dVar != null) {
                    ((g) dVar).i = string;
                    return;
                }
                return;
            }
        }
        com.fc.tjcpl.sdk.f.b bVar3 = this.a;
        bVar3.h = 8;
        this.b.h(bVar3.i);
        ((g) this.c).i = this.a.i.e.get(0);
    }
}
