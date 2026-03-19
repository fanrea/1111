package aegon.chrome.net;

import aegon.chrome.net.RequestFinishedInfo;
import aegon.chrome.net.UrlRequest;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ExperimentalUrlRequest extends UrlRequest {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static abstract class Builder extends UrlRequest.Builder {
        @Override // aegon.chrome.net.UrlRequest.Builder
        public abstract Builder addHeader(String str, String str2);

        public Builder addRequestAnnotation(Object obj) {
            return this;
        }

        @Override // aegon.chrome.net.UrlRequest.Builder
        public abstract Builder allowDirectExecutor();

        @Override // aegon.chrome.net.UrlRequest.Builder
        public abstract ExperimentalUrlRequest build();

        @Override // aegon.chrome.net.UrlRequest.Builder
        public abstract Builder disableCache();

        public Builder disableConnectionMigration() {
            return this;
        }

        @Override // aegon.chrome.net.UrlRequest.Builder
        public abstract Builder setHttpMethod(String str);

        @Override // aegon.chrome.net.UrlRequest.Builder
        public abstract Builder setPriority(int i);

        public Builder setRequestFinishedListener(RequestFinishedInfo.Listener listener) {
            return this;
        }

        public Builder setTrafficStatsTag(int i) {
            return this;
        }

        public Builder setTrafficStatsUid(int i) {
            return this;
        }

        @Override // aegon.chrome.net.UrlRequest.Builder
        public abstract Builder setUploadDataProvider(UploadDataProvider uploadDataProvider, Executor executor);
    }
}
