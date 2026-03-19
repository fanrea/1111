package com.dhylive.app;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.dhylive.app.databinding.ActivityAdvertisingBindingImpl;
import com.dhylive.app.databinding.ActivityAuthCallbackBindingImpl;
import com.dhylive.app.databinding.ActivityContentListBindingImpl;
import com.dhylive.app.databinding.ActivityCrashBindingImpl;
import com.dhylive.app.databinding.ActivityDramaDetailBindingImpl;
import com.dhylive.app.databinding.ActivityDramaSearchBindingImpl;
import com.dhylive.app.databinding.ActivityLoginAccountBindingImpl;
import com.dhylive.app.databinding.ActivityMainBindingImpl;
import com.dhylive.app.databinding.ActivityMineDetailsBindingImpl;
import com.dhylive.app.databinding.ActivityNovelDetailBindingImpl;
import com.dhylive.app.databinding.ActivityOfficialGroupBindingImpl;
import com.dhylive.app.databinding.ActivityPhotoPreviewBindingImpl;
import com.dhylive.app.databinding.ActivityProtocolBindingImpl;
import com.dhylive.app.databinding.ActivityRegisterBindingImpl;
import com.dhylive.app.databinding.ActivityResetPasswordBindingImpl;
import com.dhylive.app.databinding.ActivitySettingBindingImpl;
import com.dhylive.app.databinding.ActivityShowAdBindingImpl;
import com.dhylive.app.databinding.ActivitySplashBindingImpl;
import com.dhylive.app.databinding.ActivityVipCenterBindingImpl;
import com.dhylive.app.databinding.ActivityWebBindingImpl;
import com.dhylive.app.databinding.ActivityWhithdrawSettingBindingImpl;
import com.dhylive.app.databinding.ActivityWithdrawBindingImpl;
import com.dhylive.app.databinding.DialogBindInviteBindingImpl;
import com.dhylive.app.databinding.DialogBindPhoneBindingImpl;
import com.dhylive.app.databinding.DialogInfoBindingImpl;
import com.dhylive.app.databinding.DialogLoadingBindingImpl;
import com.dhylive.app.databinding.DialogNoticeBindingImpl;
import com.dhylive.app.databinding.DialogPermissionsBindingImpl;
import com.dhylive.app.databinding.DialogPrivacyPolicyBindingImpl;
import com.dhylive.app.databinding.DialogRedPacketBindingImpl;
import com.dhylive.app.databinding.DialogSendCoinBindingImpl;
import com.dhylive.app.databinding.DialogSpeedBindingImpl;
import com.dhylive.app.databinding.DialogUpdateNicknameBindingImpl;
import com.dhylive.app.databinding.DialogUpdatePwdBindingImpl;
import com.dhylive.app.databinding.DialogUpdateVersionBindingImpl;
import com.dhylive.app.databinding.DialogWaitWithdrawBindingImpl;
import com.dhylive.app.databinding.FragmentContainerBindingImpl;
import com.dhylive.app.databinding.FragmentDramaDrawBindingImpl;
import com.dhylive.app.databinding.FragmentDramaListBindingImpl;
import com.dhylive.app.databinding.FragmentHomeBindingImpl;
import com.dhylive.app.databinding.FragmentMineBindingImpl;
import com.dhylive.app.databinding.FragmentMoguTaskBindingImpl;
import com.dhylive.app.databinding.FragmentNovelBindingImpl;
import com.dhylive.app.databinding.FragmentRefreshRecyclerBindingImpl;
import com.dhylive.app.databinding.FragmentShortVideoBindingImpl;
import com.dhylive.app.databinding.FragmentTaskBindingImpl;
import com.dhylive.app.databinding.FragmentWebBindingImpl;
import com.dhylive.app.databinding.ItemDramaBindingImpl;
import com.dhylive.app.databinding.ItemMoguTaskBindingImpl;
import com.dhylive.app.databinding.ItemMoneyBindingImpl;
import com.dhylive.app.databinding.ItemNovelBindingImpl;
import com.dhylive.app.databinding.ItemPhotoPreviewBindingImpl;
import com.dhylive.app.databinding.LayoutNovHeaderRecommendBindingImpl;
import com.dhylive.app.databinding.LayoutToolbarBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYADVERTISING = 1;
    private static final int LAYOUT_ACTIVITYAUTHCALLBACK = 2;
    private static final int LAYOUT_ACTIVITYCONTENTLIST = 3;
    private static final int LAYOUT_ACTIVITYCRASH = 4;
    private static final int LAYOUT_ACTIVITYDRAMADETAIL = 5;
    private static final int LAYOUT_ACTIVITYDRAMASEARCH = 6;
    private static final int LAYOUT_ACTIVITYLOGINACCOUNT = 7;
    private static final int LAYOUT_ACTIVITYMAIN = 8;
    private static final int LAYOUT_ACTIVITYMINEDETAILS = 9;
    private static final int LAYOUT_ACTIVITYNOVELDETAIL = 10;
    private static final int LAYOUT_ACTIVITYOFFICIALGROUP = 11;
    private static final int LAYOUT_ACTIVITYPHOTOPREVIEW = 12;
    private static final int LAYOUT_ACTIVITYPROTOCOL = 13;
    private static final int LAYOUT_ACTIVITYREGISTER = 14;
    private static final int LAYOUT_ACTIVITYRESETPASSWORD = 15;
    private static final int LAYOUT_ACTIVITYSETTING = 16;
    private static final int LAYOUT_ACTIVITYSHOWAD = 17;
    private static final int LAYOUT_ACTIVITYSPLASH = 18;
    private static final int LAYOUT_ACTIVITYVIPCENTER = 19;
    private static final int LAYOUT_ACTIVITYWEB = 20;
    private static final int LAYOUT_ACTIVITYWHITHDRAWSETTING = 21;
    private static final int LAYOUT_ACTIVITYWITHDRAW = 22;
    private static final int LAYOUT_DIALOGBINDINVITE = 23;
    private static final int LAYOUT_DIALOGBINDPHONE = 24;
    private static final int LAYOUT_DIALOGINFO = 25;
    private static final int LAYOUT_DIALOGLOADING = 26;
    private static final int LAYOUT_DIALOGNOTICE = 27;
    private static final int LAYOUT_DIALOGPERMISSIONS = 28;
    private static final int LAYOUT_DIALOGPRIVACYPOLICY = 29;
    private static final int LAYOUT_DIALOGREDPACKET = 30;
    private static final int LAYOUT_DIALOGSENDCOIN = 31;
    private static final int LAYOUT_DIALOGSPEED = 32;
    private static final int LAYOUT_DIALOGUPDATENICKNAME = 33;
    private static final int LAYOUT_DIALOGUPDATEPWD = 34;
    private static final int LAYOUT_DIALOGUPDATEVERSION = 35;
    private static final int LAYOUT_DIALOGWAITWITHDRAW = 36;
    private static final int LAYOUT_FRAGMENTCONTAINER = 37;
    private static final int LAYOUT_FRAGMENTDRAMADRAW = 38;
    private static final int LAYOUT_FRAGMENTDRAMALIST = 39;
    private static final int LAYOUT_FRAGMENTHOME = 40;
    private static final int LAYOUT_FRAGMENTMINE = 41;
    private static final int LAYOUT_FRAGMENTMOGUTASK = 42;
    private static final int LAYOUT_FRAGMENTNOVEL = 43;
    private static final int LAYOUT_FRAGMENTREFRESHRECYCLER = 44;
    private static final int LAYOUT_FRAGMENTSHORTVIDEO = 45;
    private static final int LAYOUT_FRAGMENTTASK = 46;
    private static final int LAYOUT_FRAGMENTWEB = 47;
    private static final int LAYOUT_ITEMDRAMA = 48;
    private static final int LAYOUT_ITEMMOGUTASK = 49;
    private static final int LAYOUT_ITEMMONEY = 50;
    private static final int LAYOUT_ITEMNOVEL = 51;
    private static final int LAYOUT_ITEMPHOTOPREVIEW = 52;
    private static final int LAYOUT_LAYOUTNOVHEADERRECOMMEND = 53;
    private static final int LAYOUT_LAYOUTTOOLBAR = 54;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(54);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_advertising, 1);
        sparseIntArray.put(R.layout.activity_auth_callback, 2);
        sparseIntArray.put(R.layout.activity_content_list, 3);
        sparseIntArray.put(R.layout.activity_crash, 4);
        sparseIntArray.put(R.layout.activity_drama_detail, 5);
        sparseIntArray.put(R.layout.activity_drama_search, 6);
        sparseIntArray.put(R.layout.activity_login_account, 7);
        sparseIntArray.put(R.layout.activity_main, 8);
        sparseIntArray.put(R.layout.activity_mine_details, 9);
        sparseIntArray.put(R.layout.activity_novel_detail, 10);
        sparseIntArray.put(R.layout.activity_official_group, 11);
        sparseIntArray.put(R.layout.activity_photo_preview, 12);
        sparseIntArray.put(R.layout.activity_protocol, 13);
        sparseIntArray.put(R.layout.activity_register, 14);
        sparseIntArray.put(R.layout.activity_reset_password, 15);
        sparseIntArray.put(R.layout.activity_setting, 16);
        sparseIntArray.put(R.layout.activity_show_ad, 17);
        sparseIntArray.put(R.layout.activity_splash, 18);
        sparseIntArray.put(R.layout.activity_vip_center, 19);
        sparseIntArray.put(R.layout.activity_web, 20);
        sparseIntArray.put(R.layout.activity_whithdraw_setting, 21);
        sparseIntArray.put(R.layout.activity_withdraw, 22);
        sparseIntArray.put(R.layout.dialog_bind_invite, 23);
        sparseIntArray.put(R.layout.dialog_bind_phone, 24);
        sparseIntArray.put(R.layout.dialog_info, 25);
        sparseIntArray.put(R.layout.dialog_loading, 26);
        sparseIntArray.put(R.layout.dialog_notice, 27);
        sparseIntArray.put(R.layout.dialog_permissions, 28);
        sparseIntArray.put(R.layout.dialog_privacy_policy, 29);
        sparseIntArray.put(R.layout.dialog_red_packet, 30);
        sparseIntArray.put(R.layout.dialog_send_coin, 31);
        sparseIntArray.put(R.layout.dialog_speed, 32);
        sparseIntArray.put(R.layout.dialog_update_nickname, 33);
        sparseIntArray.put(R.layout.dialog_update_pwd, 34);
        sparseIntArray.put(R.layout.dialog_update_version, 35);
        sparseIntArray.put(R.layout.dialog_wait_withdraw, 36);
        sparseIntArray.put(R.layout.fragment_container, 37);
        sparseIntArray.put(R.layout.fragment_drama_draw, 38);
        sparseIntArray.put(R.layout.fragment_drama_list, 39);
        sparseIntArray.put(R.layout.fragment_home, 40);
        sparseIntArray.put(R.layout.fragment_mine, 41);
        sparseIntArray.put(R.layout.fragment_mogu_task, 42);
        sparseIntArray.put(R.layout.fragment_novel, 43);
        sparseIntArray.put(R.layout.fragment_refresh_recycler, 44);
        sparseIntArray.put(R.layout.fragment_short_video, 45);
        sparseIntArray.put(R.layout.fragment_task, 46);
        sparseIntArray.put(R.layout.fragment_web, 47);
        sparseIntArray.put(R.layout.item_drama, 48);
        sparseIntArray.put(R.layout.item_mogu_task, 49);
        sparseIntArray.put(R.layout.item_money, 50);
        sparseIntArray.put(R.layout.item_novel, 51);
        sparseIntArray.put(R.layout.item_photo_preview, 52);
        sparseIntArray.put(R.layout.layout_nov_header_recommend, 53);
        sparseIntArray.put(R.layout.layout_toolbar, 54);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/activity_advertising_0".equals(obj)) {
                    return new ActivityAdvertisingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_advertising is invalid. Received: " + obj);
            case 2:
                if ("layout/activity_auth_callback_0".equals(obj)) {
                    return new ActivityAuthCallbackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_auth_callback is invalid. Received: " + obj);
            case 3:
                if ("layout/activity_content_list_0".equals(obj)) {
                    return new ActivityContentListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_content_list is invalid. Received: " + obj);
            case 4:
                if ("layout/activity_crash_0".equals(obj)) {
                    return new ActivityCrashBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_crash is invalid. Received: " + obj);
            case 5:
                if ("layout/activity_drama_detail_0".equals(obj)) {
                    return new ActivityDramaDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_drama_detail is invalid. Received: " + obj);
            case 6:
                if ("layout/activity_drama_search_0".equals(obj)) {
                    return new ActivityDramaSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_drama_search is invalid. Received: " + obj);
            case 7:
                if ("layout/activity_login_account_0".equals(obj)) {
                    return new ActivityLoginAccountBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_login_account is invalid. Received: " + obj);
            case 8:
                if ("layout/activity_main_0".equals(obj)) {
                    return new ActivityMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + obj);
            case 9:
                if ("layout/activity_mine_details_0".equals(obj)) {
                    return new ActivityMineDetailsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_mine_details is invalid. Received: " + obj);
            case 10:
                if ("layout/activity_novel_detail_0".equals(obj)) {
                    return new ActivityNovelDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_novel_detail is invalid. Received: " + obj);
            case 11:
                if ("layout/activity_official_group_0".equals(obj)) {
                    return new ActivityOfficialGroupBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_official_group is invalid. Received: " + obj);
            case 12:
                if ("layout/activity_photo_preview_0".equals(obj)) {
                    return new ActivityPhotoPreviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_photo_preview is invalid. Received: " + obj);
            case 13:
                if ("layout/activity_protocol_0".equals(obj)) {
                    return new ActivityProtocolBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_protocol is invalid. Received: " + obj);
            case 14:
                if ("layout/activity_register_0".equals(obj)) {
                    return new ActivityRegisterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_register is invalid. Received: " + obj);
            case 15:
                if ("layout/activity_reset_password_0".equals(obj)) {
                    return new ActivityResetPasswordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_reset_password is invalid. Received: " + obj);
            case 16:
                if ("layout/activity_setting_0".equals(obj)) {
                    return new ActivitySettingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_setting is invalid. Received: " + obj);
            case 17:
                if ("layout/activity_show_ad_0".equals(obj)) {
                    return new ActivityShowAdBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_show_ad is invalid. Received: " + obj);
            case 18:
                if ("layout/activity_splash_0".equals(obj)) {
                    return new ActivitySplashBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + obj);
            case 19:
                if ("layout/activity_vip_center_0".equals(obj)) {
                    return new ActivityVipCenterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_vip_center is invalid. Received: " + obj);
            case 20:
                if ("layout/activity_web_0".equals(obj)) {
                    return new ActivityWebBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_web is invalid. Received: " + obj);
            case 21:
                if ("layout/activity_whithdraw_setting_0".equals(obj)) {
                    return new ActivityWhithdrawSettingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_whithdraw_setting is invalid. Received: " + obj);
            case 22:
                if ("layout/activity_withdraw_0".equals(obj)) {
                    return new ActivityWithdrawBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_withdraw is invalid. Received: " + obj);
            case 23:
                if ("layout/dialog_bind_invite_0".equals(obj)) {
                    return new DialogBindInviteBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_bind_invite is invalid. Received: " + obj);
            case 24:
                if ("layout/dialog_bind_phone_0".equals(obj)) {
                    return new DialogBindPhoneBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_bind_phone is invalid. Received: " + obj);
            case 25:
                if ("layout/dialog_info_0".equals(obj)) {
                    return new DialogInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_info is invalid. Received: " + obj);
            case 26:
                if ("layout/dialog_loading_0".equals(obj)) {
                    return new DialogLoadingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_loading is invalid. Received: " + obj);
            case 27:
                if ("layout/dialog_notice_0".equals(obj)) {
                    return new DialogNoticeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_notice is invalid. Received: " + obj);
            case 28:
                if ("layout/dialog_permissions_0".equals(obj)) {
                    return new DialogPermissionsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_permissions is invalid. Received: " + obj);
            case 29:
                if ("layout/dialog_privacy_policy_0".equals(obj)) {
                    return new DialogPrivacyPolicyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_privacy_policy is invalid. Received: " + obj);
            case 30:
                if ("layout/dialog_red_packet_0".equals(obj)) {
                    return new DialogRedPacketBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_red_packet is invalid. Received: " + obj);
            case 31:
                if ("layout/dialog_send_coin_0".equals(obj)) {
                    return new DialogSendCoinBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_send_coin is invalid. Received: " + obj);
            case 32:
                if ("layout/dialog_speed_0".equals(obj)) {
                    return new DialogSpeedBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_speed is invalid. Received: " + obj);
            case 33:
                if ("layout/dialog_update_nickname_0".equals(obj)) {
                    return new DialogUpdateNicknameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_update_nickname is invalid. Received: " + obj);
            case 34:
                if ("layout/dialog_update_pwd_0".equals(obj)) {
                    return new DialogUpdatePwdBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_update_pwd is invalid. Received: " + obj);
            case 35:
                if ("layout/dialog_update_version_0".equals(obj)) {
                    return new DialogUpdateVersionBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_update_version is invalid. Received: " + obj);
            case 36:
                if ("layout/dialog_wait_withdraw_0".equals(obj)) {
                    return new DialogWaitWithdrawBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_wait_withdraw is invalid. Received: " + obj);
            case 37:
                if ("layout/fragment_container_0".equals(obj)) {
                    return new FragmentContainerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_container is invalid. Received: " + obj);
            case 38:
                if ("layout/fragment_drama_draw_0".equals(obj)) {
                    return new FragmentDramaDrawBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_drama_draw is invalid. Received: " + obj);
            case 39:
                if ("layout/fragment_drama_list_0".equals(obj)) {
                    return new FragmentDramaListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_drama_list is invalid. Received: " + obj);
            case 40:
                if ("layout/fragment_home_0".equals(obj)) {
                    return new FragmentHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + obj);
            case 41:
                if ("layout/fragment_mine_0".equals(obj)) {
                    return new FragmentMineBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_mine is invalid. Received: " + obj);
            case 42:
                if ("layout/fragment_mogu_task_0".equals(obj)) {
                    return new FragmentMoguTaskBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_mogu_task is invalid. Received: " + obj);
            case 43:
                if ("layout/fragment_novel_0".equals(obj)) {
                    return new FragmentNovelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_novel is invalid. Received: " + obj);
            case 44:
                if ("layout/fragment_refresh_recycler_0".equals(obj)) {
                    return new FragmentRefreshRecyclerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_refresh_recycler is invalid. Received: " + obj);
            case 45:
                if ("layout/fragment_short_video_0".equals(obj)) {
                    return new FragmentShortVideoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_short_video is invalid. Received: " + obj);
            case 46:
                if ("layout/fragment_task_0".equals(obj)) {
                    return new FragmentTaskBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_task is invalid. Received: " + obj);
            case 47:
                if ("layout/fragment_web_0".equals(obj)) {
                    return new FragmentWebBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_web is invalid. Received: " + obj);
            case 48:
                if ("layout/item_drama_0".equals(obj)) {
                    return new ItemDramaBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_drama is invalid. Received: " + obj);
            case 49:
                if ("layout/item_mogu_task_0".equals(obj)) {
                    return new ItemMoguTaskBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_mogu_task is invalid. Received: " + obj);
            case 50:
                if ("layout/item_money_0".equals(obj)) {
                    return new ItemMoneyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_money is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent dataBindingComponent, View view, int i, Object obj) {
        switch (i) {
            case 51:
                if ("layout/item_novel_0".equals(obj)) {
                    return new ItemNovelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_novel is invalid. Received: " + obj);
            case 52:
                if ("layout/item_photo_preview_0".equals(obj)) {
                    return new ItemPhotoPreviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_photo_preview is invalid. Received: " + obj);
            case 53:
                if ("layout/layout_nov_header_recommend_0".equals(obj)) {
                    return new LayoutNovHeaderRecommendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_nov_header_recommend is invalid. Received: " + obj);
            case 54:
                if ("layout/layout_toolbar_0".equals(obj)) {
                    return new LayoutToolbarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_toolbar is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i3 = (i2 - 1) / 50;
        if (i3 == 0) {
            return internalGetViewDataBinding0(dataBindingComponent, view, i2, tag);
        }
        if (i3 != 1) {
            return null;
        }
        return internalGetViewDataBinding1(dataBindingComponent, view, i2, tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(54);
            sKeys = map;
            map.put("layout/activity_advertising_0", Integer.valueOf(R.layout.activity_advertising));
            map.put("layout/activity_auth_callback_0", Integer.valueOf(R.layout.activity_auth_callback));
            map.put("layout/activity_content_list_0", Integer.valueOf(R.layout.activity_content_list));
            map.put("layout/activity_crash_0", Integer.valueOf(R.layout.activity_crash));
            map.put("layout/activity_drama_detail_0", Integer.valueOf(R.layout.activity_drama_detail));
            map.put("layout/activity_drama_search_0", Integer.valueOf(R.layout.activity_drama_search));
            map.put("layout/activity_login_account_0", Integer.valueOf(R.layout.activity_login_account));
            map.put("layout/activity_main_0", Integer.valueOf(R.layout.activity_main));
            map.put("layout/activity_mine_details_0", Integer.valueOf(R.layout.activity_mine_details));
            map.put("layout/activity_novel_detail_0", Integer.valueOf(R.layout.activity_novel_detail));
            map.put("layout/activity_official_group_0", Integer.valueOf(R.layout.activity_official_group));
            map.put("layout/activity_photo_preview_0", Integer.valueOf(R.layout.activity_photo_preview));
            map.put("layout/activity_protocol_0", Integer.valueOf(R.layout.activity_protocol));
            map.put("layout/activity_register_0", Integer.valueOf(R.layout.activity_register));
            map.put("layout/activity_reset_password_0", Integer.valueOf(R.layout.activity_reset_password));
            map.put("layout/activity_setting_0", Integer.valueOf(R.layout.activity_setting));
            map.put("layout/activity_show_ad_0", Integer.valueOf(R.layout.activity_show_ad));
            map.put("layout/activity_splash_0", Integer.valueOf(R.layout.activity_splash));
            map.put("layout/activity_vip_center_0", Integer.valueOf(R.layout.activity_vip_center));
            map.put("layout/activity_web_0", Integer.valueOf(R.layout.activity_web));
            map.put("layout/activity_whithdraw_setting_0", Integer.valueOf(R.layout.activity_whithdraw_setting));
            map.put("layout/activity_withdraw_0", Integer.valueOf(R.layout.activity_withdraw));
            map.put("layout/dialog_bind_invite_0", Integer.valueOf(R.layout.dialog_bind_invite));
            map.put("layout/dialog_bind_phone_0", Integer.valueOf(R.layout.dialog_bind_phone));
            map.put("layout/dialog_info_0", Integer.valueOf(R.layout.dialog_info));
            map.put("layout/dialog_loading_0", Integer.valueOf(R.layout.dialog_loading));
            map.put("layout/dialog_notice_0", Integer.valueOf(R.layout.dialog_notice));
            map.put("layout/dialog_permissions_0", Integer.valueOf(R.layout.dialog_permissions));
            map.put("layout/dialog_privacy_policy_0", Integer.valueOf(R.layout.dialog_privacy_policy));
            map.put("layout/dialog_red_packet_0", Integer.valueOf(R.layout.dialog_red_packet));
            map.put("layout/dialog_send_coin_0", Integer.valueOf(R.layout.dialog_send_coin));
            map.put("layout/dialog_speed_0", Integer.valueOf(R.layout.dialog_speed));
            map.put("layout/dialog_update_nickname_0", Integer.valueOf(R.layout.dialog_update_nickname));
            map.put("layout/dialog_update_pwd_0", Integer.valueOf(R.layout.dialog_update_pwd));
            map.put("layout/dialog_update_version_0", Integer.valueOf(R.layout.dialog_update_version));
            map.put("layout/dialog_wait_withdraw_0", Integer.valueOf(R.layout.dialog_wait_withdraw));
            map.put("layout/fragment_container_0", Integer.valueOf(R.layout.fragment_container));
            map.put("layout/fragment_drama_draw_0", Integer.valueOf(R.layout.fragment_drama_draw));
            map.put("layout/fragment_drama_list_0", Integer.valueOf(R.layout.fragment_drama_list));
            map.put("layout/fragment_home_0", Integer.valueOf(R.layout.fragment_home));
            map.put("layout/fragment_mine_0", Integer.valueOf(R.layout.fragment_mine));
            map.put("layout/fragment_mogu_task_0", Integer.valueOf(R.layout.fragment_mogu_task));
            map.put("layout/fragment_novel_0", Integer.valueOf(R.layout.fragment_novel));
            map.put("layout/fragment_refresh_recycler_0", Integer.valueOf(R.layout.fragment_refresh_recycler));
            map.put("layout/fragment_short_video_0", Integer.valueOf(R.layout.fragment_short_video));
            map.put("layout/fragment_task_0", Integer.valueOf(R.layout.fragment_task));
            map.put("layout/fragment_web_0", Integer.valueOf(R.layout.fragment_web));
            map.put("layout/item_drama_0", Integer.valueOf(R.layout.item_drama));
            map.put("layout/item_mogu_task_0", Integer.valueOf(R.layout.item_mogu_task));
            map.put("layout/item_money_0", Integer.valueOf(R.layout.item_money));
            map.put("layout/item_novel_0", Integer.valueOf(R.layout.item_novel));
            map.put("layout/item_photo_preview_0", Integer.valueOf(R.layout.item_photo_preview));
            map.put("layout/layout_nov_header_recommend_0", Integer.valueOf(R.layout.layout_nov_header_recommend));
            map.put("layout/layout_toolbar_0", Integer.valueOf(R.layout.layout_toolbar));
        }
    }
}
