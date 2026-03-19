package com.alliance.ssp.ad.o0;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.Thread;
import java.nio.charset.Charset;

/* compiled from: SACrashHandler.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class o implements Thread.UncaughtExceptionHandler {
    public static final o c = new o();
    public static final Charset d = Charset.forName("UTF-8");
    public Thread.UncaughtExceptionHandler a;
    public Context b = null;

    public void a(Context context) {
        this.b = context;
        this.a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        Context context2 = this.b;
        if (context2 != null) {
            SharedPreferences sharedPreferences = context2.getSharedPreferences("saveddata", 0);
            String string = sharedPreferences.getString("adnsdkcrash", "");
            if (string.length() > 0) {
                new com.alliance.ssp.ad.d0.f().a(0, 0, "002", string, (Exception) null);
                int i = l.a;
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString("adnsdkcrash", "");
                editorEdit.commit();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        String strA;
        try {
            strA = a(th);
        } catch (IOException unused) {
            strA = null;
        }
        Context context = this.b;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("saveddata", 0);
            if (strA == null) {
                strA = "";
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("adnsdkcrash", strA);
            editorEdit.commit();
        }
        this.a.uncaughtException(thread, th);
    }

    public static String a(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Charset charset = d;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, charset);
        PrintWriter printWriter = new PrintWriter((Writer) outputStreamWriter, true);
        th.printStackTrace(printWriter);
        String str = new String(byteArrayOutputStream.toByteArray(), charset);
        printWriter.close();
        outputStreamWriter.close();
        byteArrayOutputStream.close();
        return str;
    }
}
