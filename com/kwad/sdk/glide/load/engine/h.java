package com.kwad.sdk.glide.load.engine;

import com.kwad.sdk.glide.load.DataSource;
import com.kwad.sdk.glide.load.EncodeStrategy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class h {
    public static final h bTp = new h() { // from class: com.kwad.sdk.glide.load.engine.h.1
        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agC() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agD() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean b(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final h bTq = new h() { // from class: com.kwad.sdk.glide.load.engine.h.2
        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agC() {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agD() {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean b(DataSource dataSource) {
            return false;
        }
    };
    public static final h bTr = new h() { // from class: com.kwad.sdk.glide.load.engine.h.3
        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agC() {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agD() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean b(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final h bTs = new h() { // from class: com.kwad.sdk.glide.load.engine.h.4
        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agC() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agD() {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean b(DataSource dataSource) {
            return false;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final h bTt = new h() { // from class: com.kwad.sdk.glide.load.engine.h.5
        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agC() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean agD() {
            return true;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean b(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.kwad.sdk.glide.load.engine.h
        public final boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    };

    public abstract boolean a(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);

    public abstract boolean agC();

    public abstract boolean agD();

    public abstract boolean b(DataSource dataSource);
}
