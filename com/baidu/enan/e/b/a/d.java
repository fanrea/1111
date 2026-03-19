package com.baidu.enan.e.b.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.bmf_mods.common.ErrorCode;
import com.kuaishou.socket.nano.SocketMessages;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d {
    private static boolean a() {
        try {
            if (!b().toUpperCase().equals("BLACKBERRY")) {
                if (!b().equals("RIM")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            return ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter() != null;
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return false;
        }
    }

    public static int b(Context context) {
        int intExtra;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
                if (batteryManager == null) {
                    return 0;
                }
                return batteryManager.getIntProperty(4);
            }
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = -1;
            if (intentRegisterReceiver != null) {
                int intExtra2 = intentRegisterReceiver.getIntExtra("level", -1);
                intExtra = intentRegisterReceiver.getIntExtra("scale", -1);
                i = intExtra2;
            } else {
                intExtra = -1;
            }
            return (int) ((i / intExtra) * 100.0f);
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return 0;
        }
    }

    public static String c(Context context) {
        try {
            int iA = a(f(context));
            if (iA <= 0) {
                return null;
            }
            return iA % 1024 == 0 ? String.format("%d %s", Integer.valueOf(iA / 1024), "GB") : (iA < 1024 || iA % 512 != 0) ? a(Long.valueOf(iA)) : String.format("%.1f %s", Float.valueOf(iA / 1024.0f), "GB");
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return null;
        }
    }

    public static Pair<Boolean, Integer> d(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            boolean z = intExtra == 2 || intExtra == 5;
            return new Pair<>(Boolean.valueOf(z), Integer.valueOf(z ? intentRegisterReceiver.getIntExtra("plugged", -1) : -1));
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return new Pair<>(Boolean.FALSE, -1);
        }
    }

    private static long f(Context context) {
        try {
            long jG = g(context);
            return jG <= 0 ? h(context) : jG;
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return 0L;
        }
    }

    private static long g(Context context) {
        if (context != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    if (activityManager == null) {
                        return 0L;
                    }
                    activityManager.getMemoryInfo(memoryInfo);
                    return memoryInfo.totalMem / 1048576;
                }
            } catch (Throwable th) {
                com.baidu.enan.f.b.a(th);
            }
        }
        return 0L;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0067 -> B:39:0x0077). Please report as a decompilation issue!!! */
    private static long h(Context context) {
        Throwable th;
        BufferedReader bufferedReader;
        String line;
        File file = new File(com.baidu.enan.f.b.a("L3Byb2MvbWVtaW5mbw=="));
        long j = 0;
        try {
        } catch (Throwable th2) {
            com.baidu.enan.f.b.a(th2);
        }
        if (file.exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            com.baidu.enan.f.b.a(th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return j;
                        } catch (Throwable th4) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th5) {
                                    com.baidu.enan.f.b.a(th5);
                                }
                            }
                            throw th4;
                        }
                    }
                } while (!line.startsWith("MemTotal:"));
                String upperCase = line.substring(9).trim().toUpperCase();
                int iIndexOf = upperCase.indexOf(" KB");
                if (iIndexOf > 0) {
                    long jA = a(upperCase.substring(0, iIndexOf));
                    if (jA > 0) {
                        j = jA / 1024;
                    }
                }
                bufferedReader.close();
            } catch (Throwable th6) {
                th = th6;
                bufferedReader = null;
            }
        }
        return j;
    }

    public static int e(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 24) {
                return -1;
            }
            return Settings.Global.getInt(context.getContentResolver(), "boot_count");
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return -1;
        }
    }

    private static int a(long j) {
        try {
            if (a()) {
                String upperCase = Build.BOARD.trim().toUpperCase();
                if (upperCase.startsWith("SQW100-")) {
                    return 3072;
                }
                if (!upperCase.startsWith("SQC100-") && !upperCase.startsWith("SQK100-") && !upperCase.startsWith("SQN100-") && !upperCase.startsWith("SQR100-") && !upperCase.startsWith("STA100-") && !upperCase.startsWith("STK100-") && !upperCase.startsWith("STL100-") && !upperCase.startsWith("STR100-")) {
                    if (upperCase.startsWith("STJ100-")) {
                        return 1536;
                    }
                }
                return 2048;
            }
            float f = j / 1024.0f;
            if (f > 10.0f) {
                return ErrorCode.INSUFFICIENT_MEMORY;
            }
            if (f > 8.0f) {
                return com.sigmob.sdk.archives.tar.d.b;
            }
            if (f > 7.0f) {
                return 8192;
            }
            if (f > 5.0f) {
                return 6144;
            }
            if (f > 4.0f) {
                return Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION;
            }
            if (f > 3.0f) {
                return 4096;
            }
            if (f > 2.0f) {
                return 3072;
            }
            if (f > 1.0f) {
                return 2048;
            }
            if (f > 0.75f) {
                return 1024;
            }
            return f > 0.5f ? SocketMessages.PayloadType.SC_LIVE_PK_KO_MODE : f > 0.25f ? 512 : 0;
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return 0;
        }
    }

    private static String a(Long l) {
        try {
            return l.longValue() >= 10240 ? String.format("%.2f %s", Float.valueOf(l.longValue() / 1024.0f), "GB") : String.format("%d %s", l, "MB");
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return "";
        }
    }

    private static long a(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException e) {
            com.baidu.enan.f.b.a(e);
            return Long.MIN_VALUE;
        }
    }

    private static String b() {
        try {
            return Build.VERSION.SDK_INT >= 4 ? Build.MANUFACTURER.trim() : "";
        } catch (Throwable th) {
            com.baidu.enan.f.b.a(th);
            return "";
        }
    }
}
