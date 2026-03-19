package com.apm.insight.g;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import android.os.Build;
import com.apm.insight.g;
import java.util.Date;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class a {
    public static String a(long j) {
        if (j == 0) {
            return "not obtained";
        }
        try {
            Long lValueOf = Long.valueOf(j / 1024);
            if (lValueOf.longValue() < 1) {
                return "< 1MB";
            }
            if (lValueOf.longValue() <= 30) {
                return "[1~30MB]";
            }
            if (lValueOf.longValue() > 30 && lValueOf.longValue() <= 60) {
                return "(30~100MB]";
            }
            if (lValueOf.longValue() > 60 && lValueOf.longValue() <= 100) {
                return "(60~100MB]";
            }
            if (lValueOf.longValue() > 100 && lValueOf.longValue() <= 200) {
                return "(100~150MB]";
            }
            if (lValueOf.longValue() > 200 && lValueOf.longValue() <= 300) {
                return "(200~300MB]";
            }
            if (lValueOf.longValue() > 300 && lValueOf.longValue() <= 400) {
                return "(300~400MB]";
            }
            if (lValueOf.longValue() > 400 && lValueOf.longValue() <= 500) {
                return "(400~500MB]";
            }
            if (lValueOf.longValue() > 500 && lValueOf.longValue() <= 600) {
                return "(500~600MB]";
            }
            if (lValueOf.longValue() > 600 && lValueOf.longValue() <= 700) {
                return "(600~700MB]";
            }
            if (lValueOf.longValue() > 700 && lValueOf.longValue() <= 800) {
                return "(700~800MB]";
            }
            if (lValueOf.longValue() > 800 && lValueOf.longValue() <= 900) {
                return "(800~900MB]";
            }
            if (lValueOf.longValue() > 900 && lValueOf.longValue() <= 1000) {
                return "(900~1000MB]";
            }
            if (lValueOf.longValue() > 1000 && lValueOf.longValue() <= 1500) {
                return "(1GB~1.5GB]";
            }
            if (lValueOf.longValue() > 1500 && lValueOf.longValue() <= 2000) {
                return "(1.5GB~2GB]";
            }
            if (lValueOf.longValue() > 2000 && lValueOf.longValue() <= com.alipay.sdk.m.u.b.a) {
                return "(2GB~3GB]";
            }
            if (lValueOf.longValue() > com.alipay.sdk.m.u.b.a && lValueOf.longValue() <= 4000) {
                return "(3GB~4GB]";
            }
            if (lValueOf.longValue() > 4000 && lValueOf.longValue() <= 6000) {
                return "(4GB~6GB]";
            }
            if (lValueOf.longValue() > 6000) {
                if (lValueOf.longValue() <= 8000) {
                    return "(6GB~8GB]";
                }
            }
            return ">8G";
        } catch (Throwable unused) {
            return "invalid";
        }
    }

    public static String a(ApplicationExitInfo applicationExitInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("ApplicationExitInfo");
        sb.append("\n\tProcess : ").append(applicationExitInfo.getProcessName()).append("(").append(applicationExitInfo.getPid()).append(")");
        sb.append("\n\tTime : ").append(com.apm.insight.o.b.a().format(new Date(applicationExitInfo.getTimestamp())));
        sb.append("\n\tReason : ").append(applicationExitInfo.getReason()).append(" (").append(b(applicationExitInfo.getReason())).append(")");
        sb.append("\n\tRSS = ").append(applicationExitInfo.getRss());
        sb.append("\n\tPSS = ").append(applicationExitInfo.getPss());
        sb.append("\n\tDescription : ").append(applicationExitInfo.getDescription());
        sb.append("\n\tStatus = ").append(applicationExitInfo.getStatus());
        sb.append("\n\tImportance = ").append(applicationExitInfo.getImportance());
        return sb.toString();
    }

    public static List<ApplicationExitInfo> a(int i) {
        Context contextF;
        ActivityManager activityManager;
        List<ApplicationExitInfo> historicalProcessExitReasons;
        if (!a() || (contextF = g.f()) == null || (activityManager = (ActivityManager) contextF.getSystemService("activity")) == null || (historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(contextF.getPackageName(), 0, i)) == null || historicalProcessExitReasons.size() <= 0) {
            return null;
        }
        return historicalProcessExitReasons;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static String b(int i) {
        switch (i) {
            case 1:
                return "EXIT_SELF";
            case 2:
                return "SIGNALED";
            case 3:
                return "LOW_MEMORY";
            case 4:
                return "APP CRASH(EXCEPTION)";
            case 5:
                return "APP CRASH(NATIVE)";
            case 6:
                return "ANR";
            case 7:
                return "INITIALIZATION FAILURE";
            case 8:
                return "PERMISSION CHANGE";
            case 9:
                return "EXCESSIVE RESOURCE USAGE";
            case 10:
                return "USER REQUESTED";
            case 11:
                return "USER STOPPED";
            case 12:
                return "DEPENDENCY DIED";
            case 13:
                return "OTHER KILLS BY SYSTEM";
            case 14:
                return "FREEZER";
            default:
                return "UNKNOWN";
        }
    }

    public static String c(int i) {
        switch (i) {
            case 1:
                return "WAIT FOR DEBUGGER";
            case 2:
                return "TOO MANY CACHED PROCS";
            case 3:
                return "TOO MANY EMPTY PROCS";
            case 4:
                return "TRIM EMPTY";
            case 5:
                return "LARGE CACHED";
            case 6:
                return "MEMORY PRESSURE";
            case 7:
                return "EXCESSIVE CPU USAGE";
            case 8:
                return "SYSTEM UPDATE_DONE";
            case 9:
                return "KILL ALL FG";
            case 10:
                return "KILL ALL BG EXCEPT";
            case 11:
                return "KILL UID";
            case 12:
                return "KILL PID";
            case 13:
                return "INVALID START";
            case 14:
                return "INVALID STATE";
            case 15:
                return "IMPERCEPTIBLE";
            case 16:
                return "REMOVE LRU";
            case 17:
                return "ISOLATED NOT NEEDED";
            case 18:
                return "CACHED IDLE FORCED APP STANDBY";
            case 19:
                return "FREEZER BINDER IOCTL";
            case 20:
                return "FREEZER BINDER TRANSACTION";
            case 21:
                return "FORCE STOP";
            case 22:
                return "REMOVE TASK";
            case 23:
                return "STOP APP";
            case 24:
                return "KILL BACKGROUND";
            case 25:
                return "PACKAGE UPDATE";
            default:
                return "UNKNOWN";
        }
    }

    public static boolean d(int i) {
        return i == 10 || i == 11;
    }
}
