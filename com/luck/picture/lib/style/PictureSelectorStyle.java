package com.luck.picture.lib.style;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class PictureSelectorStyle {
    private AlbumWindowStyle albumWindowStyle;
    private BottomNavBarStyle bottomBarStyle;
    private SelectMainStyle selectMainStyle;
    private TitleBarStyle titleBarStyle;
    private PictureWindowAnimationStyle windowAnimationStyle;

    public TitleBarStyle getTitleBarStyle() {
        TitleBarStyle titleBarStyle = this.titleBarStyle;
        return titleBarStyle == null ? new TitleBarStyle() : titleBarStyle;
    }

    public void setTitleBarStyle(TitleBarStyle titleBarStyle) {
        this.titleBarStyle = titleBarStyle;
    }

    public SelectMainStyle getSelectMainStyle() {
        SelectMainStyle selectMainStyle = this.selectMainStyle;
        return selectMainStyle == null ? new SelectMainStyle() : selectMainStyle;
    }

    public void setSelectMainStyle(SelectMainStyle selectMainStyle) {
        this.selectMainStyle = selectMainStyle;
    }

    public BottomNavBarStyle getBottomBarStyle() {
        BottomNavBarStyle bottomNavBarStyle = this.bottomBarStyle;
        return bottomNavBarStyle == null ? new BottomNavBarStyle() : bottomNavBarStyle;
    }

    public void setBottomBarStyle(BottomNavBarStyle bottomNavBarStyle) {
        this.bottomBarStyle = bottomNavBarStyle;
    }

    public PictureWindowAnimationStyle getWindowAnimationStyle() {
        if (this.windowAnimationStyle == null) {
            this.windowAnimationStyle = PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();
        }
        return this.windowAnimationStyle;
    }

    public void setWindowAnimationStyle(PictureWindowAnimationStyle pictureWindowAnimationStyle) {
        this.windowAnimationStyle = pictureWindowAnimationStyle;
    }

    public AlbumWindowStyle getAlbumWindowStyle() {
        AlbumWindowStyle albumWindowStyle = this.albumWindowStyle;
        return albumWindowStyle == null ? new AlbumWindowStyle() : albumWindowStyle;
    }

    public void setAlbumWindowStyle(AlbumWindowStyle albumWindowStyle) {
        this.albumWindowStyle = albumWindowStyle;
    }
}
