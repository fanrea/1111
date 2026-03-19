package com.luck.picture.lib.basic;

import android.app.Activity;
import android.text.TextUtils;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnQueryAllAlbumListener;
import com.luck.picture.lib.interfaces.OnQueryDataResultListener;
import com.luck.picture.lib.interfaces.OnQueryDataSourceListener;
import com.luck.picture.lib.interfaces.OnQueryFilterListener;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.luck.picture.lib.loader.LocalMediaLoader;
import com.luck.picture.lib.loader.LocalMediaPageLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureSelectionQueryModel {
    private final SelectorConfig selectionConfig;
    private final PictureSelector selector;

    public PictureSelectionQueryModel(PictureSelector pictureSelector, int i) {
        this.selector = pictureSelector;
        SelectorConfig selectorConfig = new SelectorConfig();
        this.selectionConfig = selectorConfig;
        SelectorProviders.getInstance().addSelectorConfigQueue(selectorConfig);
        selectorConfig.chooseMode = i;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z) {
        this.selectionConfig.isPageStrategy = z;
        return this;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z, int i) {
        this.selectionConfig.isPageStrategy = z;
        SelectorConfig selectorConfig = this.selectionConfig;
        if (i < 10) {
            i = 60;
        }
        selectorConfig.pageSize = i;
        return this;
    }

    public PictureSelectionQueryModel isPageStrategy(boolean z, int i, boolean z2) {
        this.selectionConfig.isPageStrategy = z;
        SelectorConfig selectorConfig = this.selectionConfig;
        if (i < 10) {
            i = 60;
        }
        selectorConfig.pageSize = i;
        this.selectionConfig.isFilterInvalidFile = z2;
        return this;
    }

    public PictureSelectionQueryModel setQueryFilterListener(OnQueryFilterListener onQueryFilterListener) {
        this.selectionConfig.onQueryFilterListener = onQueryFilterListener;
        return this;
    }

    public PictureSelectionQueryModel setQuerySortOrder(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.selectionConfig.sortOrder = str;
        }
        return this;
    }

    public PictureSelectionQueryModel isGif(boolean z) {
        this.selectionConfig.isGif = z;
        return this;
    }

    public PictureSelectionQueryModel isWebp(boolean z) {
        this.selectionConfig.isWebp = z;
        return this;
    }

    public PictureSelectionQueryModel isBmp(boolean z) {
        this.selectionConfig.isBmp = z;
        return this;
    }

    public PictureSelectionQueryModel setFilterMaxFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.filterMaxFileSize = j;
        } else {
            this.selectionConfig.filterMaxFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionQueryModel setFilterMinFileSize(long j) {
        if (j >= 1048576) {
            this.selectionConfig.filterMinFileSize = j;
        } else {
            this.selectionConfig.filterMinFileSize = j * 1024;
        }
        return this;
    }

    public PictureSelectionQueryModel setFilterVideoMaxSecond(int i) {
        this.selectionConfig.filterVideoMaxSecond = i * 1000;
        return this;
    }

    public PictureSelectionQueryModel setFilterVideoMinSecond(int i) {
        this.selectionConfig.filterVideoMinSecond = i * 1000;
        return this;
    }

    public IBridgeMediaLoader buildMediaLoader() {
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (this.selectionConfig.isPageStrategy) {
            return new LocalMediaPageLoader(activity, this.selectionConfig);
        }
        return new LocalMediaLoader(activity, this.selectionConfig);
    }

    public void obtainAlbumData(final OnQueryDataSourceListener<LocalMediaFolder> onQueryDataSourceListener) {
        IBridgeMediaLoader localMediaLoader;
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (onQueryDataSourceListener == null) {
            throw new NullPointerException("OnQueryDataSourceListener cannot be null");
        }
        if (this.selectionConfig.isPageStrategy) {
            localMediaLoader = new LocalMediaPageLoader(activity, this.selectionConfig);
        } else {
            localMediaLoader = new LocalMediaLoader(activity, this.selectionConfig);
        }
        localMediaLoader.loadAllAlbum(new OnQueryAllAlbumListener<LocalMediaFolder>() { // from class: com.luck.picture.lib.basic.PictureSelectionQueryModel.1
            @Override // com.luck.picture.lib.interfaces.OnQueryAllAlbumListener
            public void onComplete(List<LocalMediaFolder> list) {
                onQueryDataSourceListener.onComplete(list);
            }
        });
    }

    public void obtainMediaData(final OnQueryDataSourceListener<LocalMedia> onQueryDataSourceListener) {
        final IBridgeMediaLoader localMediaLoader;
        Activity activity = this.selector.getActivity();
        if (activity == null) {
            throw new NullPointerException("Activity cannot be null");
        }
        if (onQueryDataSourceListener == null) {
            throw new NullPointerException("OnQueryDataSourceListener cannot be null");
        }
        if (this.selectionConfig.isPageStrategy) {
            localMediaLoader = new LocalMediaPageLoader(activity, this.selectionConfig);
        } else {
            localMediaLoader = new LocalMediaLoader(activity, this.selectionConfig);
        }
        localMediaLoader.loadAllAlbum(new OnQueryAllAlbumListener<LocalMediaFolder>() { // from class: com.luck.picture.lib.basic.PictureSelectionQueryModel.2
            @Override // com.luck.picture.lib.interfaces.OnQueryAllAlbumListener
            public void onComplete(List<LocalMediaFolder> list) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                LocalMediaFolder localMediaFolder = list.get(0);
                if (PictureSelectionQueryModel.this.selectionConfig.isPageStrategy) {
                    localMediaLoader.loadPageMediaData(localMediaFolder.getBucketId(), 1, PictureSelectionQueryModel.this.selectionConfig.pageSize, new OnQueryDataResultListener<LocalMedia>() { // from class: com.luck.picture.lib.basic.PictureSelectionQueryModel.2.1
                        @Override // com.luck.picture.lib.interfaces.OnQueryDataResultListener
                        public void onComplete(ArrayList<LocalMedia> arrayList, boolean z) {
                            onQueryDataSourceListener.onComplete(arrayList);
                        }
                    });
                } else {
                    onQueryDataSourceListener.onComplete(localMediaFolder.getData());
                }
            }
        });
    }
}
