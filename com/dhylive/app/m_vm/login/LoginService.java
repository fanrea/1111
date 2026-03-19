package com.dhylive.app.m_vm.login;

import com.bytedance.applog.game.GameReportHelper;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.dhylive.app.BaseUrls;
import com.dhylive.app.data.login.LoginData;
import com.dhylive.app.data.user.UserData;
import com.dhylive.app.net.BaseResp;
import com.dhylive.app.net.HashMapNonNull;
import com.dhylive.app.utils.LiveEventConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* compiled from: LoginService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H§@¢\u0006\u0002\u0010\u000bJ\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/dhylive/app/m_vm/login/LoginService;", "", "bindAgent", "Lcom/dhylive/app/net/BaseResp;", "params", "Lcom/dhylive/app/net/HashMapNonNull;", "(Lcom/dhylive/app/net/HashMapNonNull;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindWechat", "Lcom/dhylive/app/data/login/LoginData;", IFunc.IVK_GET_USER_INFO, "Lcom/dhylive/app/data/user/UserData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", GameReportHelper.REGISTER, "resetPwd", "sendVerificationCode", "phone", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", LiveEventConst.WX_LOGIN, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface LoginService {
    @FormUrlEncoded
    @POST(BaseUrls.APP_BIND_AGENT)
    Object bindAgent(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<? extends Object>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.APP_BING_WE_CHECK)
    Object bindWechat(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<LoginData>> continuation);

    @GET(BaseUrls.APP_MY_USER_INFO)
    Object getUserInfo(Continuation<? super BaseResp<UserData>> continuation);

    @FormUrlEncoded
    @POST("game/wechat/login")
    Object login(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<LoginData>> continuation);

    @FormUrlEncoded
    @POST("game/wechat/login")
    Object register(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<? extends Object>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.APP_FIND_PSW)
    Object resetPwd(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<? extends Object>> continuation);

    @GET(BaseUrls.APP_SEND_SMS)
    Object sendVerificationCode(@Query("mobile") String str, Continuation<? super BaseResp<? extends Object>> continuation);

    @FormUrlEncoded
    @POST(BaseUrls.APP_GET_TOKEN)
    Object wxLogin(@FieldMap HashMapNonNull hashMapNonNull, Continuation<? super BaseResp<LoginData>> continuation);
}
