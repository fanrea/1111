package lkxssdk.r0;

import com.lingku.xuanshang.xutils.cache.DiskCacheEntity;
import com.lingku.xuanshang.xutils.common.util.ParameterizedTypeUtil;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.http.annotation.HttpResponse;
import com.lingku.xuanshang.xutils.http.app.ResponseParser;
import com.lingku.xuanshang.xutils.http.loader.Loader;
import com.lingku.xuanshang.xutils.http.loader.LoaderFactory;
import com.lingku.xuanshang.xutils.http.request.UriRequest;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class g extends Loader<Object> {
    public final Type a;
    public final Class<?> b;
    public final ResponseParser c;
    public final Loader<?> d;

    public g(Type type) {
        Class<?> cls;
        Class<?> cls2;
        this.a = type;
        if (type instanceof ParameterizedType) {
            cls = (Class) ((ParameterizedType) type).getRawType();
        } else {
            if (type instanceof TypeVariable) {
                throw new IllegalArgumentException("not support callback type " + type.toString());
            }
            cls = (Class) type;
        }
        this.b = cls;
        if (List.class.equals(this.b)) {
            type = ParameterizedTypeUtil.getParameterizedType(type, List.class, 0);
            if (type instanceof ParameterizedType) {
                cls2 = (Class) ((ParameterizedType) type).getRawType();
            } else {
                if (type instanceof TypeVariable) {
                    throw new IllegalArgumentException("not support callback type " + type.toString());
                }
                cls2 = (Class) type;
            }
        } else {
            cls2 = this.b;
        }
        HttpResponse httpResponse = (HttpResponse) cls2.getAnnotation(HttpResponse.class);
        if (httpResponse == null) {
            throw new IllegalArgumentException("not found @HttpResponse from " + type);
        }
        try {
            Class<? extends ResponseParser> rVar = httpResponse.parser();
            this.c = rVar.newInstance();
            Loader<?> loader = LoaderFactory.getLoader(ParameterizedTypeUtil.getParameterizedType(rVar, ResponseParser.class, 0));
            this.d = loader;
            if (loader instanceof g) {
                throw new IllegalArgumentException("not support callback type " + type);
            }
        } catch (Throwable th) {
            throw new RuntimeException("create parser error", th);
        }
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Object load(UriRequest uriRequest) {
        uriRequest.setResponseParser(this.c);
        return this.c.parse(this.a, this.b, this.d.load(uriRequest));
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Object loadFromCache(DiskCacheEntity diskCacheEntity) {
        return this.c.parse(this.a, this.b, this.d.loadFromCache(diskCacheEntity));
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public Loader<Object> newInstance() {
        throw new IllegalAccessError("use constructor create ObjectLoader.");
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
        this.d.save2Cache(uriRequest);
    }

    @Override // com.lingku.xuanshang.xutils.http.loader.Loader
    public void setParams(RequestParams requestParams) {
        this.d.setParams(requestParams);
    }
}
