package com.fc.tjcpl.sdk.n;

import android.webkit.WebChromeClient;
import com.fc.tjcpl.sdk.view.CustomViewContent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class q extends WebChromeClient {
    public final /* synthetic */ CustomViewContent a;

    public q(CustomViewContent customViewContent) {
        this.a = customViewContent;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:27:0x00f6
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView r5, android.webkit.ValueCallback<android.net.Uri[]> r6, android.webkit.WebChromeClient.FileChooserParams r7) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fc.tjcpl.sdk.n.q.onShowFileChooser(android.webkit.WebView, android.webkit.ValueCallback, android.webkit.WebChromeClient$FileChooserParams):boolean");
    }
}
