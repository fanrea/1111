package com.android.gdt.qone.ao;

import android.text.TextUtils;
import com.android.gdt.qone.sdk.S.DataFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class a implements com.android.gdt.qone.x.a {
    public final /* synthetic */ DataFormatter a;
    public final /* synthetic */ DataFormatter b;
    public final /* synthetic */ c c;

    public a(c cVar, DataFormatter dataFormatter, DataFormatter dataFormatter2) {
        this.c = cVar;
        this.a = dataFormatter;
        this.b = dataFormatter2;
    }

    @Override // com.android.gdt.qone.x.a
    public final void a() throws Throwable {
        FileOutputStream fileOutputStream;
        this.a.a().putAll(this.b.a());
        c cVar = this.c;
        DataFormatter dataFormatter = this.a;
        cVar.getClass();
        String strA = c.a(dataFormatter, "qAucMjh7lsNepLGw");
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        String strB = com.android.gdt.qone.w.a.b();
        File file = new File(strB);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(strB, "spread_data");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                com.android.gdt.qone.af.c.a(e);
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(strA.getBytes());
                    fileOutputStream.flush();
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        com.android.gdt.qone.af.c.a(e2);
                    }
                    com.android.gdt.qone.af.c.b("c", "%s write success.", "spread_data");
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream2 = fileOutputStream;
                    com.android.gdt.qone.af.c.a(e);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e4) {
                            com.android.gdt.qone.af.c.a(e4);
                        }
                        com.android.gdt.qone.af.c.b("c", "%s write success.", "spread_data");
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileOutputStream2 = fileOutputStream;
                    com.android.gdt.qone.af.c.a(e);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e6) {
                            com.android.gdt.qone.af.c.a(e6);
                        }
                        com.android.gdt.qone.af.c.b("c", "%s write success.", "spread_data");
                    }
                } catch (Throwable th) {
                    th = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e7) {
                            com.android.gdt.qone.af.c.a(e7);
                        }
                        com.android.gdt.qone.af.c.b("c", "%s write success.", "spread_data");
                    }
                    throw th;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = fileOutputStream2;
        }
    }
}
