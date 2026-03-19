package com.qq.e.comm.plugin;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class lp {
    static void b(Context context, String str) throws Throwable {
        a(context, a(context, "config"), str, true);
    }

    static void c(Context context, String str) throws Throwable {
        a(context, a(context, "test"), str, false);
    }

    private static File a(Context context, String str) {
        File dir = context.getDir("e_qq_com_mediation", 0);
        if (!dir.exists() && !dir.mkdirs()) {
            return null;
        }
        File file = new File(dir, str);
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    return null;
                }
            }
            return file;
        } catch (IOException unused) {
            return null;
        }
    }

    public static String a(Context context) throws Throwable {
        File fileA = a(context, "config");
        if (fileA == null) {
            return null;
        }
        try {
            String strA = a(fileA);
            if (strA == null) {
                return null;
            }
            return l.a(strA);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    private static String a(File file) throws Throwable {
        if (file != 0) {
            try {
                if (file.exists()) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream((File) file), "UTF-8"));
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb.append(line);
                            }
                            String string = sb.toString();
                            try {
                                bufferedReader.close();
                            } catch (Exception unused) {
                            }
                            return string;
                        } catch (IOException e) {
                            throw e;
                        }
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        file = 0;
                        if (file != 0) {
                            try {
                                file.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private static void a(Context context, File file, String str, boolean z) throws Throwable {
        if (file == null) {
            return;
        }
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
                if (z) {
                    try {
                        str = l.b(str);
                    } catch (Exception unused) {
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                }
                outputStreamWriter2.write(str);
                outputStreamWriter2.close();
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused4) {
        }
    }
}
