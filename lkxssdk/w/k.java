package lkxssdk.w;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class k implements Runnable {
    public lkxssdk.z.b a;
    public e b;
    public lkxssdk.y.d c;

    public k(lkxssdk.z.b bVar, e eVar, lkxssdk.y.d dVar) {
        this.a = bVar;
        this.b = eVar;
        this.c = dVar;
    }

    @Override // java.lang.Runnable
    public void run() throws NoSuchAlgorithmException, IOException {
        String string;
        String str = lkxssdk.a.a.e(this.a.i.d).b;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
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
                        sb.append(lkxssdk.a0.c.a[(bArrDigest[i2] >>> 4) & 15]);
                        sb.append(lkxssdk.a0.c.a[bArrDigest[i2] & 15]);
                    }
                    string = sb.toString();
                }
            } catch (Exception unused) {
                System.out.println("md5 file error");
                string = "";
            }
            if (!TextUtils.isEmpty(string)) {
                String lowerCase = string.toLowerCase();
                lkxssdk.h0.c.b("tag", "file md5 lower:" + lowerCase + ",up:" + string);
                if (this.a.i.e.contains(string) || this.a.i.e.contains(lowerCase)) {
                    lkxssdk.z.b bVar = this.a;
                    bVar.h = 8;
                    this.b.j(bVar.i);
                } else {
                    lkxssdk.z.b bVar2 = this.a;
                    bVar2.h = 10;
                    this.b.a(bVar2.i);
                }
                lkxssdk.y.d dVar = this.c;
                if (dVar != null) {
                    ((g) dVar).i = string;
                    return;
                }
                return;
            }
        }
        lkxssdk.z.b bVar3 = this.a;
        bVar3.h = 8;
        this.b.j(bVar3.i);
        ((g) this.c).i = this.a.i.e.get(0);
    }
}
