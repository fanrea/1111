package com.kuaishou.tk.api.exception;

import android.text.TextUtils;
import com.tk.core.i.a;
import com.tkruntime.v8.V8ScriptCompilationException;
import com.tkruntime.v8.V8ScriptException;
import com.tkruntime.v8.V8ScriptExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKExceptionUtil {
    public static void checkStack(JSONObject jSONObject, Throwable th) throws JSONException {
        if (th == null) {
            return;
        }
        try {
            if ((th instanceof V8ScriptExecutionException) || (th instanceof V8ScriptCompilationException)) {
                jSONObject.put("jsStack", getJSStackTrack((V8ScriptException) th));
            }
            jSONObject.put("nativeStack", getStackTraceList(th));
        } catch (Exception e) {
            a.a("TKTraceReporter", "checkStack exception", e);
        }
    }

    public static String getJSStackTrack(V8ScriptException v8ScriptException) {
        if (v8ScriptException == null) {
            return "";
        }
        String jSStackTrace = v8ScriptException.getJSStackTrace();
        return TextUtils.isEmpty(jSStackTrace) ? "" : jSStackTrace.trim().replaceAll("\t", "").replaceAll("\n", "#");
    }

    public static String getJSStackTrack(TKJSException tKJSException) {
        if (tKJSException == null) {
            return "";
        }
        String jsStackTrace = tKJSException.getJsStackTrace();
        return TextUtils.isEmpty(jsStackTrace) ? "" : jsStackTrace.trim().replaceAll("\t", "").replaceAll("\n", "#");
    }

    public static String getStackTraceList(Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (th == null) {
            return sb.toString();
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return sb.toString();
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append("#at ");
            sb.append(stackTraceElement.toString());
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            sb.append("#Caused by: ");
            sb.append(cause.toString());
            addCauseStack(cause, stackTrace, cause.getStackTrace(), sb);
        }
        return sb.toString();
    }

    private static void addCauseStack(Throwable th, StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2, StringBuilder sb) {
        if (th == null || stackTraceElementArr == null || stackTraceElementArr2 == null || sb == null) {
            return;
        }
        int length = stackTraceElementArr2.length - 1;
        for (int length2 = stackTraceElementArr.length - 1; length >= 0 && length2 >= 0 && stackTraceElementArr2[length].equals(stackTraceElementArr[length2]); length2--) {
            length--;
        }
        int length3 = (stackTraceElementArr2.length - 1) - length;
        for (int i = 0; i < length; i++) {
            sb.append("#at ");
            sb.append(stackTraceElementArr2[i]);
        }
        if (length3 != 0) {
            sb.append("#... ");
            sb.append(length3);
            sb.append(" more");
        }
    }
}
