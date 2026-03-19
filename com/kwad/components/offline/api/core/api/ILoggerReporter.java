package com.kwad.components.offline.api.core.api;

import com.kwad.sdk.commercial.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface ILoggerReporter {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(c cVar);
}
