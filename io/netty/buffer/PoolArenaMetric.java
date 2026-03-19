package io.netty.buffer;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface PoolArenaMetric {
    List<PoolChunkListMetric> chunkLists();

    long numActiveAllocations();

    long numActiveHugeAllocations();

    long numActiveNormalAllocations();

    long numActiveSmallAllocations();

    long numActiveTinyAllocations();

    long numAllocations();

    int numChunkLists();

    long numDeallocations();

    long numHugeAllocations();

    long numHugeDeallocations();

    long numNormalAllocations();

    long numNormalDeallocations();

    long numSmallAllocations();

    long numSmallDeallocations();

    int numSmallSubpages();

    long numTinyAllocations();

    long numTinyDeallocations();

    int numTinySubpages();

    List<PoolSubpageMetric> smallSubpages();

    List<PoolSubpageMetric> tinySubpages();
}
