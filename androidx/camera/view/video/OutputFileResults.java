package androidx.camera.view.video;

import android.net.Uri;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class OutputFileResults {
    public abstract Uri getSavedUri();

    OutputFileResults() {
    }

    public static OutputFileResults create(Uri uri) {
        return new AutoValue_OutputFileResults(uri);
    }
}
