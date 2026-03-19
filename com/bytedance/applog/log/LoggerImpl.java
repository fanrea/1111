package com.bytedance.applog.log;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LoggerImpl extends AbstractAppLogLogger {
    private static final AbsSingleton<IAppLogLogger> GLOBAL_IMPL = new AbsSingleton<IAppLogLogger>() { // from class: com.bytedance.applog.log.LoggerImpl.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.applog.log.AbsSingleton
        public IAppLogLogger create(Object... objArr) {
            return new GlobalLoggerImpl();
        }
    };

    public static IAppLogLogger global() {
        return GLOBAL_IMPL.get(new Object[0]);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void verbose(String str, Object... objArr) {
        verbose((List<String>) null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void verbose(List<String> list, String str, Object... objArr) {
        verbose(0, list, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void verbose(int i, String str, Object... objArr) {
        verbose(i, null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void verbose(int i, List<String> list, String str, Object... objArr) {
        process(i, 0, list, null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void info(String str, Object... objArr) {
        info((List<String>) null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void info(List<String> list, String str, Object... objArr) {
        info(0, list, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void info(int i, String str, Object... objArr) {
        info(i, null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void info(int i, List<String> list, String str, Object... objArr) {
        process(i, 2, list, null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void debug(String str, Object... objArr) {
        debug((List<String>) null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void debug(List<String> list, String str, Object... objArr) {
        debug(0, list, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void debug(int i, String str, Object... objArr) {
        debug(i, null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void debug(int i, List<String> list, String str, Object... objArr) {
        process(i, 1, list, null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void warn(String str, Object... objArr) {
        warn((List<String>) null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void warn(List<String> list, String str, Object... objArr) {
        warn(0, list, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void warn(int i, String str, Object... objArr) {
        warn(i, null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void warn(int i, List<String> list, String str, Object... objArr) {
        process(i, 3, list, null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void error(String str, Throwable th, Object... objArr) {
        error((List<String>) null, str, th, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void error(List<String> list, String str, Throwable th, Object... objArr) {
        error(0, list, str, th, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void error(int i, String str, Throwable th, Object... objArr) {
        error(i, null, str, th, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void error(int i, List<String> list, String str, Throwable th, Object... objArr) {
        process(i, 4, list, th, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void error(String str, Object... objArr) {
        error(str, (Throwable) null, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void error(List<String> list, String str, Object... objArr) {
        error(list, str, (Throwable) null, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void error(int i, String str, Object... objArr) {
        error(i, (List<String>) null, str, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void error(int i, List<String> list, String str, Object... objArr) {
        error(i, list, str, null, objArr);
    }

    @Override // com.bytedance.applog.log.IAppLogLogger
    public void ast(String str, Throwable th, Object... objArr) {
        process(0, 5, null, th, str, objArr);
    }
}
