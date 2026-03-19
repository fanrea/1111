package com.luck.picture.lib.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.adapter.PictureAlbumAdapter;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.decoration.WrapContentLinearLayoutManager;
import com.luck.picture.lib.entity.LocalMediaFolder;
import com.luck.picture.lib.interfaces.OnAlbumItemClickListener;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.SdkVersionUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AlbumListPopWindow extends PopupWindow {
    private static final int ALBUM_MAX_COUNT = 8;
    private boolean isDismiss = false;
    private PictureAlbumAdapter mAdapter;
    private final Context mContext;
    private RecyclerView mRecyclerView;
    private SelectorConfig selectorConfig;
    private View windMask;
    private int windowMaxHeight;
    private OnPopupWindowStatusListener windowStatusListener;

    public interface OnPopupWindowStatusListener {
        void onDismissPopupWindow();

        void onShowPopupWindow();
    }

    public AlbumListPopWindow(Context context, SelectorConfig selectorConfig) {
        this.mContext = context;
        this.selectorConfig = selectorConfig;
        setContentView(LayoutInflater.from(context).inflate(R.layout.ps_window_folder, (ViewGroup) null));
        setWidth(-1);
        setHeight(-2);
        setAnimationStyle(R.style.PictureThemeWindowStyle);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        initViews();
    }

    private void initViews() {
        this.windowMaxHeight = (int) (DensityUtil.getScreenHeight(this.mContext) * 0.6d);
        this.mRecyclerView = (RecyclerView) getContentView().findViewById(R.id.folder_list);
        this.windMask = getContentView().findViewById(R.id.rootViewBg);
        this.mRecyclerView.setLayoutManager(new WrapContentLinearLayoutManager(this.mContext));
        PictureAlbumAdapter pictureAlbumAdapter = new PictureAlbumAdapter(this.selectorConfig);
        this.mAdapter = pictureAlbumAdapter;
        this.mRecyclerView.setAdapter(pictureAlbumAdapter);
        this.windMask.setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.dialog.AlbumListPopWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlbumListPopWindow.this.dismiss();
            }
        });
        getContentView().findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() { // from class: com.luck.picture.lib.dialog.AlbumListPopWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SdkVersionUtils.isMinM()) {
                    AlbumListPopWindow.this.dismiss();
                }
            }
        });
    }

    public void bindAlbumData(List<LocalMediaFolder> list) {
        this.mAdapter.bindAlbumData(list);
        this.mAdapter.notifyDataSetChanged();
        this.mRecyclerView.getLayoutParams().height = list.size() > 8 ? this.windowMaxHeight : -2;
    }

    public List<LocalMediaFolder> getAlbumList() {
        return this.mAdapter.getAlbumList();
    }

    public LocalMediaFolder getFolder(int i) {
        if (this.mAdapter.getAlbumList().size() <= 0 || i >= this.mAdapter.getAlbumList().size()) {
            return null;
        }
        return this.mAdapter.getAlbumList().get(i);
    }

    public int getFirstAlbumImageCount() {
        if (getFolderCount() > 0) {
            return getFolder(0).getFolderTotalNum();
        }
        return 0;
    }

    public int getFolderCount() {
        return this.mAdapter.getAlbumList().size();
    }

    public void setOnIBridgeAlbumWidget(OnAlbumItemClickListener onAlbumItemClickListener) {
        this.mAdapter.setOnIBridgeAlbumWidget(onAlbumItemClickListener);
    }

    public static AlbumListPopWindow buildPopWindow(Context context, SelectorConfig selectorConfig) {
        return new AlbumListPopWindow(context, selectorConfig);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view) {
        if (getAlbumList() == null || getAlbumList().size() == 0) {
            return;
        }
        if (SdkVersionUtils.isN()) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            showAtLocation(view, 0, 0, iArr[1] + view.getHeight());
        } else {
            super.showAsDropDown(view);
        }
        this.isDismiss = false;
        OnPopupWindowStatusListener onPopupWindowStatusListener = this.windowStatusListener;
        if (onPopupWindowStatusListener != null) {
            onPopupWindowStatusListener.onShowPopupWindow();
        }
        this.windMask.animate().alpha(1.0f).setDuration(250L).setStartDelay(250L).start();
        changeSelectedAlbumStyle();
    }

    public void changeSelectedAlbumStyle() {
        List<LocalMediaFolder> albumList = this.mAdapter.getAlbumList();
        for (int i = 0; i < albumList.size(); i++) {
            LocalMediaFolder localMediaFolder = albumList.get(i);
            localMediaFolder.setSelectTag(false);
            this.mAdapter.notifyItemChanged(i);
            for (int i2 = 0; i2 < this.selectorConfig.getSelectCount(); i2++) {
                if (TextUtils.equals(localMediaFolder.getFolderName(), this.selectorConfig.getSelectedResult().get(i2).getParentFolderName()) || localMediaFolder.getBucketId() == -1) {
                    localMediaFolder.setSelectTag(true);
                    this.mAdapter.notifyItemChanged(i);
                    break;
                }
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        if (this.isDismiss) {
            return;
        }
        this.windMask.setAlpha(0.0f);
        OnPopupWindowStatusListener onPopupWindowStatusListener = this.windowStatusListener;
        if (onPopupWindowStatusListener != null) {
            onPopupWindowStatusListener.onDismissPopupWindow();
        }
        this.isDismiss = true;
        this.windMask.post(new Runnable() { // from class: com.luck.picture.lib.dialog.AlbumListPopWindow.3
            @Override // java.lang.Runnable
            public void run() {
                AlbumListPopWindow.super.dismiss();
                AlbumListPopWindow.this.isDismiss = false;
            }
        });
    }

    public void setOnPopupWindowStatusListener(OnPopupWindowStatusListener onPopupWindowStatusListener) {
        this.windowStatusListener = onPopupWindowStatusListener;
    }
}
