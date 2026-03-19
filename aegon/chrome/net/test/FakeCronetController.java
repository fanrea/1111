package aegon.chrome.net.test;

import aegon.chrome.net.CronetEngine;
import aegon.chrome.net.ExperimentalCronetEngine;
import aegon.chrome.net.test.FakeCronetEngine;
import aegon.chrome.net.test.FakeUrlResponse;
import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public final class FakeCronetController {
    private static final List<CronetEngine> sInstances = Collections.synchronizedList(new ArrayList());
    private final List<ResponseMatcher> mResponseMatchers = Collections.synchronizedList(new ArrayList());

    public final CronetEngine.Builder newFakeCronetEngineBuilder(Context context) {
        FakeCronetEngine.Builder builder = new FakeCronetEngine.Builder(context);
        builder.setController(this);
        return new ExperimentalCronetEngine.Builder(builder);
    }

    public final void addResponseForUrl(FakeUrlResponse fakeUrlResponse, String str) {
        addResponseMatcher(new UrlResponseMatcher(str, fakeUrlResponse));
    }

    public final void addResponseMatcher(ResponseMatcher responseMatcher) {
        this.mResponseMatchers.add(responseMatcher);
    }

    public final void removeResponseMatcher(ResponseMatcher responseMatcher) {
        this.mResponseMatchers.remove(responseMatcher);
    }

    public final void clearResponseMatchers() {
        this.mResponseMatchers.clear();
    }

    public final void addRedirectResponse(String str, String str2) {
        addResponseForUrl(new FakeUrlResponse.Builder().setHttpStatusCode(302).addHeader("location", str).build(), str2);
    }

    public final void addHttpErrorResponse(int i, String str) {
        addResponseForUrl(getFailedResponse(i), str);
    }

    public final void addSuccessResponse(String str, String str2) {
        addResponseForUrl(new FakeUrlResponse.Builder().setResponseBody(str2).build(), str);
    }

    public static FakeCronetController getControllerForFakeEngine(CronetEngine cronetEngine) {
        if (cronetEngine instanceof FakeCronetEngine) {
            return ((FakeCronetEngine) cronetEngine).getController();
        }
        throw new IllegalArgumentException("Provided CronetEngine is not a fake CronetEngine");
    }

    public static List<CronetEngine> getFakeCronetEngines() {
        ArrayList arrayList;
        List<CronetEngine> list = sInstances;
        synchronized (list) {
            arrayList = new ArrayList(list);
        }
        return arrayList;
    }

    static void removeFakeCronetEngine(CronetEngine cronetEngine) {
        sInstances.remove(cronetEngine);
    }

    static void addFakeCronetEngine(FakeCronetEngine fakeCronetEngine) {
        sInstances.add(fakeCronetEngine);
    }

    final FakeUrlResponse getResponse(String str, String str2, List<Map.Entry<String, String>> list) {
        synchronized (this.mResponseMatchers) {
            Iterator<ResponseMatcher> it = this.mResponseMatchers.iterator();
            while (it.hasNext()) {
                FakeUrlResponse matchingResponse = it.next().getMatchingResponse(str, str2, list);
                if (matchingResponse != null) {
                    return matchingResponse;
                }
            }
            return getFailedResponse(404);
        }
    }

    private static FakeUrlResponse getFailedResponse(int i) {
        if (i < 400) {
            throw new IllegalArgumentException("Expected HTTP error code (code >= 400), but was: " + i);
        }
        return new FakeUrlResponse.Builder().setHttpStatusCode(i).build();
    }
}
