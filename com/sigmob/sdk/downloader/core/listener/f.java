package com.sigmob.sdk.downloader.core.listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f implements com.sigmob.sdk.downloader.c {
    final com.sigmob.sdk.downloader.c[] a;

    public static class a {
        private List<com.sigmob.sdk.downloader.c> a = new ArrayList();

        public a a(com.sigmob.sdk.downloader.c listener) {
            if (listener != null && !this.a.contains(listener)) {
                this.a.add(listener);
            }
            return this;
        }

        public f a() {
            List<com.sigmob.sdk.downloader.c> list = this.a;
            return new f((com.sigmob.sdk.downloader.c[]) list.toArray(new com.sigmob.sdk.downloader.c[list.size()]));
        }

        public boolean b(com.sigmob.sdk.downloader.c listener) {
            return this.a.remove(listener);
        }
    }

    f(com.sigmob.sdk.downloader.c[] listenerList) {
        this.a = listenerList;
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f task, int blockIndex, int responseCode, Map<String, List<String>> responseHeaderFields) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(task, blockIndex, responseCode, responseHeaderFields);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f task, int blockIndex, long contentLength) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(task, blockIndex, contentLength);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f task, int responseCode, Map<String, List<String>> responseHeaderFields) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(task, responseCode, responseHeaderFields);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.breakpoint.c info) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(task, info);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.breakpoint.c info, com.sigmob.sdk.downloader.core.cause.b cause) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(task, info, cause);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f task, com.sigmob.sdk.downloader.core.cause.a cause, Exception realCause) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(task, cause, realCause);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a(com.sigmob.sdk.downloader.f task, Map<String, List<String>> requestHeaderFields) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a(task, requestHeaderFields);
        }
    }

    public boolean a(com.sigmob.sdk.downloader.c targetListener) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            if (cVar == targetListener) {
                return true;
            }
        }
        return false;
    }

    @Override // com.sigmob.sdk.downloader.c
    public void a_(com.sigmob.sdk.downloader.f task) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.a_(task);
        }
    }

    public int b(com.sigmob.sdk.downloader.c targetListener) {
        int i = 0;
        while (true) {
            com.sigmob.sdk.downloader.c[] cVarArr = this.a;
            if (i >= cVarArr.length) {
                return -1;
            }
            if (cVarArr[i] == targetListener) {
                return i;
            }
            i++;
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f task, int blockIndex, long increaseBytes) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.b(task, blockIndex, increaseBytes);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void b(com.sigmob.sdk.downloader.f task, int blockIndex, Map<String, List<String>> requestHeaderFields) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.b(task, blockIndex, requestHeaderFields);
        }
    }

    @Override // com.sigmob.sdk.downloader.c
    public void c(com.sigmob.sdk.downloader.f task, int blockIndex, long contentLength) {
        for (com.sigmob.sdk.downloader.c cVar : this.a) {
            cVar.c(task, blockIndex, contentLength);
        }
    }
}
