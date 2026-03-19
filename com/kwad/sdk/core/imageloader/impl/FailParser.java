package com.kwad.sdk.core.imageloader.impl;

import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.glide.load.engine.GlideException;
import com.kwad.sdk.glide.request.a;
import java.io.IOException;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FailParser {
    public static <R> FailReason parseFail(a<R> aVar) {
        GlideException glideExceptionAix;
        if (aVar != null && (glideExceptionAix = aVar.aix()) != null) {
            List<Throwable> rootCauses = glideExceptionAix.getRootCauses();
            for (Throwable th : rootCauses) {
                if (th instanceof IOException) {
                    return new FailReason(FailReason.FailType.IO_ERROR, th);
                }
                if (th instanceof OutOfMemoryError) {
                    return new FailReason(FailReason.FailType.OUT_OF_MEMORY, th);
                }
            }
            if (!rootCauses.isEmpty()) {
                return new FailReason(FailReason.FailType.UNKNOWN, rootCauses.get(0));
            }
        }
        return new FailReason(FailReason.FailType.UNKNOWN, new RuntimeException("unknown failed"));
    }
}
