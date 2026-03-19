package com.kuaishou.security.kste.logic.util;

import android.os.Environment;
import android.os.Process;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KWLog {
    private static final String EMPTY = "";
    private static final String TAG = "storm";
    private static boolean flag = true;
    private static final String path = "ksvideo_play_tiktok_runtime.txt";
    private static PrintWriter ps;

    static {
        setFlag(true);
        setFlag(false);
    }

    private static int d(String str, String str2, Throwable th) {
        return Log.d(str, str2, th);
    }

    private static int d(String str, String str2, Throwable th, Object... objArr) {
        return Log.d(str, format(str2, objArr), th);
    }

    private static int d(String str, String str2, Object... objArr) {
        String str3 = format(str2, objArr);
        int i = 0;
        while (i <= str3.length() / 2000) {
            int i2 = i * 2000;
            i++;
            int length = i * 2000;
            if (length > str3.length()) {
                length = str3.length();
            }
            str3.substring(i2, length);
        }
        return 0;
    }

    public static void debug(String str) {
        if (flag) {
            d(TAG, "[*] Debug : " + str, new Object[0]);
        }
    }

    private static int e(String str, String str2, Throwable th) {
        return Log.e(str, str2, th);
    }

    private static int e(String str, String str2, Throwable th, Object... objArr) {
        return Log.e(str, format(str2, objArr), th);
    }

    private static int e(String str, String str2, Object... objArr) {
        return Log.e(str, format(str2, objArr));
    }

    public static void error(String str) {
        if (flag) {
            e(TAG, "[-] Error : " + str, new Object[0]);
        }
    }

    private static String format(String str, Object... objArr) {
        try {
            return String.format(str == null ? "" : str, objArr);
        } catch (RuntimeException e) {
            w(TAG, "format error. reason=%s, format=%s", e.getMessage(), str);
            return String.format("", str);
        }
    }

    public static void handleNuLException(Throwable th) {
        try {
            if (!flag || th == null) {
                return;
            }
            th.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int i(String str, String str2, Throwable th) {
        return Log.i(str, str2, th);
    }

    private static int i(String str, String str2, Throwable th, Object... objArr) {
        return Log.i(str, format(str2, objArr), th);
    }

    private static int i(String str, String str2, Object... objArr) {
        return Log.i(str, format(str2, objArr));
    }

    public static void info(String str) {
        if (flag) {
            i(TAG, "[*] Info : " + str, new Object[0]);
        }
    }

    public static void info(String str, Object... objArr) {
        if (flag) {
            i(TAG, str, objArr);
        }
    }

    public static void log(Class cls, Throwable th) {
        if (flag && cls != null) {
            logInternal(cls.getName() + " Exception ");
            if (th == null) {
                return;
            }
            logInternal(th);
        }
    }

    private static void logInternal(String str) {
        if (ps != null) {
            String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            try {
                ps.println(str2 + " Pid(): " + Process.myPid() + " T" + Thread.currentThread().getId() + " " + str);
                ps.flush();
            } catch (Exception unused) {
            }
        }
    }

    private static void logInternal(Throwable th) {
        PrintWriter printWriter = ps;
        if (printWriter != null) {
            th.printStackTrace(printWriter);
        }
    }

    public static void setFlag(boolean z) {
        flag = z;
    }

    public static void setPath() throws Throwable {
        FileOutputStream fileOutputStream;
        BufferedWriter bufferedWriter;
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory() + "/ksvideo_play_tiktok_runtime.txt", true);
                try {
                    outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    try {
                        bufferedWriter = new BufferedWriter(outputStreamWriter);
                    } catch (IOException unused) {
                        bufferedWriter = null;
                    } catch (Throwable th) {
                        bufferedWriter = null;
                        outputStreamWriter2 = outputStreamWriter;
                        th = th;
                    }
                } catch (IOException unused2) {
                    bufferedWriter = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = null;
                }
            } catch (IOException unused3) {
                fileOutputStream = null;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                bufferedWriter = null;
            }
            try {
                ps = new PrintWriter((Writer) bufferedWriter, true);
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    outputStreamWriter.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                bufferedWriter.close();
            } catch (IOException unused4) {
                outputStreamWriter2 = outputStreamWriter;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                if (outputStreamWriter2 != null) {
                    try {
                        outputStreamWriter2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (Throwable th4) {
                th = th4;
                outputStreamWriter2 = outputStreamWriter;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                if (outputStreamWriter2 != null) {
                    try {
                        outputStreamWriter2.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (bufferedWriter == null) {
                    throw th;
                }
                try {
                    bufferedWriter.close();
                    throw th;
                } catch (Exception e7) {
                    e7.printStackTrace();
                    throw th;
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    private static int v(String str, String str2, Throwable th) {
        return Log.v(str, str2, th);
    }

    private static int v(String str, String str2, Throwable th, Object... objArr) {
        return Log.v(str, format(str2, objArr), th);
    }

    private static int v(String str, String str2, Object... objArr) {
        return Log.v(str, format(str2, objArr));
    }

    public static void verbose(String str) {
        if (flag) {
            v(TAG, "[*] Verbose : " + str, new Object[0]);
        }
    }

    private static int w(String str, String str2, Throwable th) {
        return Log.w(str, str2, th);
    }

    private static int w(String str, String str2, Throwable th, Object... objArr) {
        return Log.w(str, format(str2, objArr), th);
    }

    private static int w(String str, String str2, Object... objArr) {
        return Log.w(str, format(str2, objArr));
    }

    public static void warning(String str) {
        if (flag) {
            w(TAG, "[-] Warn : " + str, new Object[0]);
        }
    }
}
