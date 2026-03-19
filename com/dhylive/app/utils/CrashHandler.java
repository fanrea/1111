package com.dhylive.app.utils;

import android.app.Application;
import android.os.Process;
import com.bytedance.applog.game.GameReportHelper;
import com.dhylive.app.v.common.activity.CrashActivity;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CrashHandler.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/dhylive/app/utils/CrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "mApplication", "Landroid/app/Application;", "(Landroid/app/Application;)V", "mOldHandler", "uncaughtException", "", "thread", "Ljava/lang/Thread;", "throwable", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Application mApplication;
    private final Thread.UncaughtExceptionHandler mOldHandler;

    public /* synthetic */ CrashHandler(Application application, DefaultConstructorMarker defaultConstructorMarker) {
        this(application);
    }

    private CrashHandler(Application application) {
        Class<?> cls;
        this.mApplication = application;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.mOldHandler = defaultUncaughtExceptionHandler;
        if (!(!Intrinsics.areEqual(getClass().getName(), (defaultUncaughtExceptionHandler == null || (cls = defaultUncaughtExceptionHandler.getClass()) == null) ? null : cls.getName()))) {
            throw new IllegalStateException("请不要重复注册 Crash 监听".toString());
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable throwable) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        CrashActivity.Companion.start(this.mApplication, throwable);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.mOldHandler;
        if (uncaughtExceptionHandler != null) {
            String name = uncaughtExceptionHandler.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (!StringsKt.startsWith$default(name, "com.android.internal.os", false, 2, (Object) null)) {
                this.mOldHandler.uncaughtException(thread, throwable);
            }
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* compiled from: CrashHandler.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/dhylive/app/utils/CrashHandler$Companion;", "", "()V", GameReportHelper.REGISTER, "", "application", "Landroid/app/Application;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void register(Application application) {
            Intrinsics.checkNotNullParameter(application, "application");
            Thread.setDefaultUncaughtExceptionHandler(new CrashHandler(application, null));
        }
    }
}
