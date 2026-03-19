package aegon.chrome.net;

import aegon.chrome.net.BidirectionalStream;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class ExperimentalBidirectionalStream extends BidirectionalStream {

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static abstract class Builder extends BidirectionalStream.Builder {
        @Override // aegon.chrome.net.BidirectionalStream.Builder
        public abstract Builder addHeader(String str, String str2);

        public Builder addRequestAnnotation(Object obj) {
            return this;
        }

        @Override // aegon.chrome.net.BidirectionalStream.Builder
        public abstract ExperimentalBidirectionalStream build();

        @Override // aegon.chrome.net.BidirectionalStream.Builder
        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean z);

        @Override // aegon.chrome.net.BidirectionalStream.Builder
        public abstract Builder setHttpMethod(String str);

        @Override // aegon.chrome.net.BidirectionalStream.Builder
        public abstract Builder setPriority(int i);

        public Builder setTrafficStatsTag(int i) {
            return this;
        }

        public Builder setTrafficStatsUid(int i) {
            return this;
        }
    }
}
