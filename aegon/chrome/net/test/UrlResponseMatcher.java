package aegon.chrome.net.test;

import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class UrlResponseMatcher implements ResponseMatcher {
    private final FakeUrlResponse mResponse;
    private final String mUrl;

    public UrlResponseMatcher(String str, FakeUrlResponse fakeUrlResponse) {
        if (str == null) {
            throw new NullPointerException("URL is required.");
        }
        if (fakeUrlResponse == null) {
            throw new NullPointerException("Response is required.");
        }
        this.mUrl = str;
        this.mResponse = fakeUrlResponse;
    }

    @Override // aegon.chrome.net.test.ResponseMatcher
    public FakeUrlResponse getMatchingResponse(String str, String str2, List<Map.Entry<String, String>> list) {
        if (this.mUrl.equals(str)) {
            return this.mResponse;
        }
        return null;
    }
}
