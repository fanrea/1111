package com.bytedance.applog.log;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IAppLogLogger {
    void ast(String str, Throwable th, Object... objArr);

    void debug(int i, String str, Object... objArr);

    void debug(int i, List<String> list, String str, Object... objArr);

    void debug(String str, Object... objArr);

    void debug(List<String> list, String str, Object... objArr);

    void error(int i, String str, Throwable th, Object... objArr);

    void error(int i, String str, Object... objArr);

    void error(int i, List<String> list, String str, Throwable th, Object... objArr);

    void error(int i, List<String> list, String str, Object... objArr);

    void error(String str, Throwable th, Object... objArr);

    void error(String str, Object... objArr);

    void error(List<String> list, String str, Throwable th, Object... objArr);

    void error(List<String> list, String str, Object... objArr);

    void info(int i, String str, Object... objArr);

    void info(int i, List<String> list, String str, Object... objArr);

    void info(String str, Object... objArr);

    void info(List<String> list, String str, Object... objArr);

    void setAppId(String str);

    void verbose(int i, String str, Object... objArr);

    void verbose(int i, List<String> list, String str, Object... objArr);

    void verbose(String str, Object... objArr);

    void verbose(List<String> list, String str, Object... objArr);

    void warn(int i, String str, Object... objArr);

    void warn(int i, List<String> list, String str, Object... objArr);

    void warn(String str, Object... objArr);

    void warn(List<String> list, String str, Object... objArr);
}
