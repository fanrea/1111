package com.kwad.sdk.collector;

import android.os.Environment;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.collector.model.jni.AnalyseTaskNative;
import com.kwad.sdk.collector.model.jni.AppRunningInfoNative;
import com.kwad.sdk.collector.model.jni.RulesTargetNative;
import com.kwad.sdk.collector.model.jni.UploadEntryNative;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static com.kwad.sdk.collector.a Wm() {
        return new a();
    }

    public static class a implements com.kwad.sdk.collector.a {
        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            com.kwad.sdk.collector.model.c.a(strategy, arrayList2);
            File file = new File(Environment.getExternalStorageDirectory(), "/Android/data/");
            int size = arrayList2.size();
            long[] jArr = new long[size];
            for (int i = 0; i < size; i++) {
                com.kwad.sdk.collector.model.a aVar = (com.kwad.sdk.collector.model.a) arrayList2.get(i);
                if (!(aVar instanceof AnalyseTaskNative)) {
                    return arrayList;
                }
                jArr[i] = ((AnalyseTaskNative) aVar).getNativePtr();
            }
            if (d.Wo()) {
                try {
                    long[] jArrAnalysis = AppStatusNative.analysis(jArr, file.getAbsolutePath() + "/");
                    com.kwad.sdk.core.d.c.d("AppStatusAnalyserNative", "analysisByFile: runningInfoPtrs: " + jArrAnalysis);
                    for (long j : jArrAnalysis) {
                        arrayList.add(new AppRunningInfoNative(j));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
            com.kwad.sdk.core.d.c.d("AppStatusAnalyserNative", "analysisByFile: info size: " + arrayList.size());
            return arrayList;
        }

        @Override // com.kwad.sdk.collector.a
        public final List<com.kwad.sdk.collector.model.e> a(List<com.kwad.sdk.collector.model.d> list, long j, String str) {
            int size = list.size();
            long[] jArr = new long[list.size()];
            for (int i = 0; i < size; i++) {
                com.kwad.sdk.collector.model.d dVar = list.get(i);
                if (dVar instanceof RulesTargetNative) {
                    jArr[i] = ((RulesTargetNative) dVar).getNativePtr();
                }
            }
            ArrayList arrayList = new ArrayList();
            if (d.Wo()) {
                try {
                    for (long j2 : AppStatusNative.nativeGetUploadEntry(jArr, j, str)) {
                        arrayList.add(new UploadEntryNative(j2));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
            return arrayList;
        }
    }
}
