package com.dhylive.app.m_vm.main;

import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.dhylive.app.BaseUrls;
import com.dhylive.app.data.mine.AdOrderEcpm;
import com.dhylive.app.data.mine.AdOrderInfo;
import com.dhylive.app.data.mine.ConfigurationInfo;
import com.dhylive.app.data.mine.NovelInfo;
import com.dhylive.app.data.mine.VipLevelInfo;
import com.dhylive.app.data.mine.WithdrawData;
import com.dhylive.app.data.mine.WithdrawInfo;
import com.dhylive.app.data.mine.WithdrawSettingInfo;
import com.dhylive.app.data.mine.WxPayInfo;
import com.dhylive.app.data.user.UserData;
import com.dhylive.app.net.BaseResp;
import com.dhylive.app.net.HashMapNonNull;
import com.dhylive.app.net.ListData;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/* compiled from: MainService.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H§@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0003H§@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0003H§@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0003H§@¢\u0006\u0002\u0010\u0015J\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0003H§@¢\u0006\u0002\u0010\u0015J\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0003H§@¢\u0006\u0002\u0010\u0015J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0003H§@¢\u0006\u0002\u0010\u0015J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010$\u001a\u00020\fH§@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J$\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0001\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H§@¢\u0006\u0002\u0010+¨\u0006,"}, d2 = {"Lcom/dhylive/app/m_vm/main/MainService;", "", "applyWithdraw", "Lcom/dhylive/app/net/BaseResp;", "params", "Lcom/dhylive/app/net/HashMapNonNull;", "(Lcom/dhylive/app/net/HashMapNonNull;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindAlipay", "bindBankCard", "createAdOrder", "Lcom/dhylive/app/data/mine/AdOrderInfo;", "createAliPayOrder", "", "createWxPayOrder", "Lcom/dhylive/app/data/mine/WxPayInfo;", "getAdOrderEcpm", "Lcom/dhylive/app/data/mine/AdOrderEcpm;", "getConfiguration", "Lcom/dhylive/app/data/mine/ConfigurationInfo;", "getConvertMoney", "getJumpLog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNovelSetting", "Lcom/dhylive/app/data/mine/NovelInfo;", IFunc.IVK_GET_USER_INFO, "Lcom/dhylive/app/data/user/UserData;", "getVipLevelList", "Lcom/dhylive/app/data/mine/VipLevelInfo;", "getWaitWithDraw", "Lcom/dhylive/app/net/ListData;", "Lcom/dhylive/app/data/mine/WithdrawData;", "getWithdrawList", "Lcom/dhylive/app/data/mine/WithdrawInfo;", "getWithdrawSetting", "Lcom/dhylive/app/data/mine/WithdrawSettingInfo;", "successWithDraw", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAdOrder", "updateUserInfo", "part", "", "Lokhttp3/MultipartBody$Part;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface MainService {
    @FormUrlEncoded
    @POST(BaseUrls.APP_APPLY_WITHDRAW)
    Object applyWithdraw(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<? extends Object>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.APP_BIND_ALIPAY)
    Object bindAlipay(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<? extends Object>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.APP_BIND_BANK)
    Object bindBankCard(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<? extends Object>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.ORDER)
    Object createAdOrder(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<AdOrderInfo>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.CREATE_ORDER)
    Object createAliPayOrder(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<String>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.CREATE_ORDER)
    Object createWxPayOrder(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<WxPayInfo>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.GET_ORDER_INFO)
    Object getAdOrderEcpm(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<AdOrderEcpm>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.GET_MOVIE_AD)
    Object getConfiguration(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<ConfigurationInfo>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.GET_CONVERT_Money)
    Object getConvertMoney(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<? extends Object>> continuation);

    @POST(BaseUrls.GET_JUMP_LOG)
    Object getJumpLog(Continuation<? super BaseResp<? extends Object>> continuation);

    @GET(BaseUrls.GET_NOVEL)
    Object getNovelSetting(Continuation<? super BaseResp<NovelInfo>> continuation);

    @GET(BaseUrls.APP_MY_USER_INFO)
    Object getUserInfo(Continuation<? super BaseResp<UserData>> continuation);

    @GET(BaseUrls.GET_GET_LIST)
    Object getVipLevelList(Continuation<? super BaseResp<VipLevelInfo>> continuation);

    @GET(BaseUrls.GET_WAIT_WITHDRAW)
    Object getWaitWithDraw(Continuation<? super BaseResp<ListData<WithdrawData>>> continuation);

    @GET(BaseUrls.APP_WITHDRAW_LIST)
    Object getWithdrawList(Continuation<? super BaseResp<WithdrawInfo>> continuation);

    @POST(BaseUrls.APP_WITHDRAW_SETTING)
    Object getWithdrawSetting(Continuation<? super BaseResp<WithdrawSettingInfo>> continuation);

    @GET(BaseUrls.GET_SUCCESS_WITHDRAW)
    Object successWithDraw(@Query("id") String str, Continuation<? super BaseResp<String>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.SOURCE)
    Object updateAdOrder(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<String>> continuation);

    @POST(BaseUrls.APP_UPDATE_USER_INFO)
    @Multipart
    Object updateUserInfo(@Part List<MultipartBody.Part> list, Continuation<? super BaseResp<? extends Object>> continuation);
}
