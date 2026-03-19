package com.kwad.sdk.crash.handler;

import android.content.Context;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class c extends b {
    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 1;
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private c() {
    }

    public static c aeu() {
        return a.bNF;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.aef().isDebug()) {
            initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    public final void a(Throwable th, ExceptionMessage exceptionMessage, Context context) throws Throwable {
        a(th, exceptionMessage, context, ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TQ());
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0120 A[Catch: all -> 0x01aa, TRY_LEAVE, TryCatch #9 {all -> 0x01aa, blocks: (B:37:0x0112, B:39:0x0120), top: B:176:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0133 A[Catch: all -> 0x01a1, TryCatch #3 {all -> 0x01a1, blocks: (B:40:0x0129, B:42:0x0133, B:44:0x0146, B:46:0x014d, B:48:0x0157, B:49:0x0165, B:51:0x016d, B:52:0x0170, B:61:0x0197, B:54:0x0176, B:56:0x017b, B:58:0x0183, B:60:0x0190), top: B:164:0x0129 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0201 A[Catch: all -> 0x026f, TryCatch #13 {all -> 0x026f, blocks: (B:93:0x01f7, B:95:0x0201, B:97:0x0214, B:99:0x021b, B:101:0x0225, B:102:0x0233, B:104:0x023b, B:105:0x023e, B:114:0x0265, B:107:0x0244, B:109:0x0249, B:111:0x0251, B:113:0x025e), top: B:184:0x01f7 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.Throwable r21, com.kwad.sdk.crash.model.message.ExceptionMessage r22, android.content.Context r23, boolean r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 759
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.handler.c.a(java.lang.Throwable, com.kwad.sdk.crash.model.message.ExceptionMessage, android.content.Context, boolean):void");
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(File[] fileArr, CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }

    static class a {
        private static final c bNF = new c(0);
    }
}
