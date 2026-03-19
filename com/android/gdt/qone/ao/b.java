package com.android.gdt.qone.ao;

import com.android.gdt.qone.sdk.S.DataFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class b implements com.android.gdt.qone.x.a {
    public final /* synthetic */ DataFormatter[] a;
    public final /* synthetic */ c b;

    public b(c cVar, DataFormatter[] dataFormatterArr) {
        this.b = cVar;
        this.a = dataFormatterArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.gdt.qone.x.a
    public final void a() throws Throwable {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[0];
        String str = null;
        FileInputStream fileInputStream2 = null;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(new File(com.android.gdt.qone.w.a.b(), "spread_data").getAbsolutePath());
                    try {
                        bArr = new byte[fileInputStream.available()];
                        fileInputStream.read(bArr);
                        fileInputStream.close();
                    } catch (FileNotFoundException e) {
                        e = e;
                        fileInputStream2 = fileInputStream;
                        com.android.gdt.qone.af.c.a(e);
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        String str2 = new String(bArr);
                        DataFormatter[] dataFormatterArr = this.a;
                        this.b.getClass();
                        str = "qAucMjh7lsNepLGw";
                        dataFormatterArr[0] = c.a(str2, "qAucMjh7lsNepLGw");
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream3 = fileInputStream;
                        com.android.gdt.qone.af.c.a(e);
                        if (fileInputStream3 != null) {
                            fileInputStream3.close();
                        }
                        String str22 = new String(bArr);
                        DataFormatter[] dataFormatterArr2 = this.a;
                        this.b.getClass();
                        str = "qAucMjh7lsNepLGw";
                        dataFormatterArr2[0] = c.a(str22, "qAucMjh7lsNepLGw");
                    } catch (Throwable th) {
                        th = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                com.android.gdt.qone.af.c.a(e3);
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (IOException e6) {
                com.android.gdt.qone.af.c.a(e6);
            }
            String str222 = new String(bArr);
            DataFormatter[] dataFormatterArr22 = this.a;
            this.b.getClass();
            str = "qAucMjh7lsNepLGw";
            dataFormatterArr22[0] = c.a(str222, "qAucMjh7lsNepLGw");
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = str;
        }
    }
}
