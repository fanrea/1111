package com.sigmob.sdk.downloader.core.dispatcher;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.sigmob.sdk.downloader.c;
import com.sigmob.sdk.downloader.d;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.g;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class a {
    private static final String a = "CallbackDispatcher";
    private final c b;
    private final Handler c;

    /* renamed from: com.sigmob.sdk.downloader.core.dispatcher.a$a, reason: collision with other inner class name */
    static class C0734a implements c {
        private final Handler a;

        C0734a(Handler uiHandler) {
            this.a = uiHandler;
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f task, final int blockIndex, final int responseCode, final Map<String, List<String>> requestHeaderFields) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "<----- finish connection task(" + task.c() + ") block(" + blockIndex + ") code[" + responseCode + "]" + requestHeaderFields);
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.a(task, blockIndex, responseCode, requestHeaderFields);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.a(task, blockIndex, responseCode, requestHeaderFields);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f task, final int blockIndex, final long contentLength) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "fetchStart: " + task.c());
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.10
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.a(task, blockIndex, contentLength);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.a(task, blockIndex, contentLength);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f task, final int responseCode, final Map<String, List<String>> headerFields) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "<----- finish trial task(" + task.c() + ") code[" + responseCode + "]" + headerFields);
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.a(task, responseCode, headerFields);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.a(task, responseCode, headerFields);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f task, final com.sigmob.sdk.downloader.core.breakpoint.c info) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "downloadFromBreakpoint: " + task.c());
            b(task, info);
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.a(task, info);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.a(task, info);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f task, final com.sigmob.sdk.downloader.core.breakpoint.c info, final com.sigmob.sdk.downloader.core.cause.b cause) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "downloadFromBeginning: " + task.c());
            b(task, info, cause);
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.a(task, info, cause);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.a(task, info, cause);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f task, final com.sigmob.sdk.downloader.core.cause.a cause, final Exception realCause) {
            if (cause == com.sigmob.sdk.downloader.core.cause.a.ERROR) {
                com.sigmob.sdk.downloader.core.c.b(a.a, "taskEnd: " + task.c() + " " + cause + " " + realCause);
            }
            b(task, cause, realCause);
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.a(task, cause, realCause);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.a(task, cause, realCause);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a(final f task, final Map<String, List<String>> headerFields) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "-----> start trial task(" + task.c() + ") " + headerFields);
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.a(task, headerFields);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.a(task, headerFields);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void a_(final f task) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "taskStart: " + task.c());
            b(task);
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.a_(task);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.a_(task);
            }
        }

        void b(f task) {
            d dVarI = g.j().i();
            if (dVarI != null) {
                dVarI.a(task);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(final f task, final int blockIndex, final long increaseBytes) {
            if (task.t() > 0) {
                f.c.a(task, SystemClock.uptimeMillis());
            }
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.11
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.b(task, blockIndex, increaseBytes);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.b(task, blockIndex, increaseBytes);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void b(final f task, final int blockIndex, final Map<String, List<String>> requestHeaderFields) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "-----> start connection task(" + task.c() + ") block(" + blockIndex + ") " + requestHeaderFields);
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.b(task, blockIndex, requestHeaderFields);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.b(task, blockIndex, requestHeaderFields);
            }
        }

        void b(f task, com.sigmob.sdk.downloader.core.breakpoint.c info) {
            d dVarI = g.j().i();
            if (dVarI != null) {
                dVarI.a(task, info);
            }
        }

        void b(f task, com.sigmob.sdk.downloader.core.breakpoint.c info, com.sigmob.sdk.downloader.core.cause.b cause) {
            d dVarI = g.j().i();
            if (dVarI != null) {
                dVarI.a(task, info, cause);
            }
        }

        void b(final f task, final com.sigmob.sdk.downloader.core.cause.a cause, final Exception realCause) {
            d dVarI = g.j().i();
            if (dVarI != null) {
                dVarI.a(task, cause, realCause);
            }
        }

        @Override // com.sigmob.sdk.downloader.c
        public void c(final f task, final int blockIndex, final long contentLength) {
            com.sigmob.sdk.downloader.core.c.b(a.a, "fetchEnd: " + task.c());
            if (task.s()) {
                this.a.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c cVarF = task.F();
                        if (cVarF != null) {
                            cVarF.c(task, blockIndex, contentLength);
                        }
                    }
                });
                return;
            }
            c cVarF = task.F();
            if (cVarF != null) {
                cVarF.c(task, blockIndex, contentLength);
            }
        }
    }

    public a() {
        Handler handler = new Handler(Looper.getMainLooper());
        this.c = handler;
        this.b = new C0734a(handler);
    }

    a(Handler handler, c transmit) {
        this.c = handler;
        this.b = transmit;
    }

    public c a() {
        return this.b;
    }

    public void a(final Collection<f> canceledCollection) {
        if (canceledCollection.size() <= 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(a, "endTasksWithCanceled canceled[" + canceledCollection.size() + "]");
        Iterator<f> it = canceledCollection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.s()) {
                c cVarF = next.F();
                if (cVarF != null) {
                    cVarF.a(next, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                }
                it.remove();
            }
        }
        this.c.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.3
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : canceledCollection) {
                    c cVarF2 = fVar.F();
                    if (cVarF2 != null) {
                        cVarF2.a(fVar, com.sigmob.sdk.downloader.core.cause.a.CANCELED, (Exception) null);
                    }
                }
            }
        });
    }

    public void a(final Collection<f> errorCollection, final Exception realCause) {
        if (errorCollection.size() <= 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(a, "endTasksWithError error[" + errorCollection.size() + "] realCause: " + realCause);
        Iterator<f> it = errorCollection.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (!next.s()) {
                c cVarF = next.F();
                if (cVarF != null) {
                    cVarF.a(next, com.sigmob.sdk.downloader.core.cause.a.ERROR, realCause);
                }
                it.remove();
            }
        }
        this.c.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.1
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : errorCollection) {
                    c cVarF2 = fVar.F();
                    if (cVarF2 != null) {
                        cVarF2.a(fVar, com.sigmob.sdk.downloader.core.cause.a.ERROR, realCause);
                    }
                }
            }
        });
    }

    public void a(final Collection<f> completedTaskCollection, final Collection<f> sameTaskConflictCollection, final Collection<f> fileBusyCollection) {
        if (completedTaskCollection.size() == 0 && sameTaskConflictCollection.size() == 0 && fileBusyCollection.size() == 0) {
            return;
        }
        com.sigmob.sdk.downloader.core.c.b(a, "endTasks completed[" + completedTaskCollection.size() + "] sameTask[" + sameTaskConflictCollection.size() + "] fileBusy[" + fileBusyCollection.size() + "]");
        if (completedTaskCollection.size() > 0) {
            Iterator<f> it = completedTaskCollection.iterator();
            while (it.hasNext()) {
                f next = it.next();
                if (!next.s()) {
                    c cVarF = next.F();
                    if (cVarF != null) {
                        cVarF.a(next, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
                    }
                    it.remove();
                }
            }
        }
        if (sameTaskConflictCollection.size() > 0) {
            Iterator<f> it2 = sameTaskConflictCollection.iterator();
            while (it2.hasNext()) {
                f next2 = it2.next();
                if (!next2.s()) {
                    c cVarF2 = next2.F();
                    if (cVarF2 != null) {
                        cVarF2.a(next2, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                    }
                    it2.remove();
                }
            }
        }
        if (fileBusyCollection.size() > 0) {
            Iterator<f> it3 = fileBusyCollection.iterator();
            while (it3.hasNext()) {
                f next3 = it3.next();
                if (!next3.s()) {
                    c cVarF3 = next3.F();
                    if (cVarF3 != null) {
                        cVarF3.a(next3, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                    }
                    it3.remove();
                }
            }
        }
        if (completedTaskCollection.size() == 0 && sameTaskConflictCollection.size() == 0 && fileBusyCollection.size() == 0) {
            return;
        }
        this.c.post(new Runnable() { // from class: com.sigmob.sdk.downloader.core.dispatcher.a.2
            @Override // java.lang.Runnable
            public void run() {
                for (f fVar : completedTaskCollection) {
                    c cVarF4 = fVar.F();
                    if (cVarF4 != null) {
                        cVarF4.a(fVar, com.sigmob.sdk.downloader.core.cause.a.COMPLETED, (Exception) null);
                    }
                }
                for (f fVar2 : sameTaskConflictCollection) {
                    c cVarF5 = fVar2.F();
                    if (cVarF5 != null) {
                        cVarF5.a(fVar2, com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY, (Exception) null);
                    }
                }
                for (f fVar3 : fileBusyCollection) {
                    c cVarF6 = fVar3.F();
                    if (cVarF6 != null) {
                        cVarF6.a(fVar3, com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY, (Exception) null);
                    }
                }
            }
        });
    }

    public boolean a(f task) {
        long jT = task.t();
        return jT <= 0 || SystemClock.uptimeMillis() - f.c.a(task) >= jT;
    }
}
