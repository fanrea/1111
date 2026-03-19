package com.duoyou.task.sdk.xutils.http.loader;

import com.duoyou.task.sdk.xutils.cache.DiskCacheEntity;
import com.duoyou.task.sdk.xutils.common.util.ParameterizedTypeUtil;
import com.duoyou.task.sdk.xutils.http.RequestParams;
import com.duoyou.task.sdk.xutils.http.annotation.HttpResponse;
import com.duoyou.task.sdk.xutils.http.app.ResponseParser;
import com.duoyou.task.sdk.xutils.http.request.UriRequest;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ObjectLoader extends Loader<Object> {
    private final Loader<?> innerLoader;
    private final Class<?> objectClass;
    private final Type objectType;
    private final ResponseParser parser;

    public ObjectLoader(Type type) {
        HttpResponse httpResponse;
        Class cls;
        this.objectType = type;
        if (type instanceof ParameterizedType) {
            this.objectClass = (Class) ((ParameterizedType) type).getRawType();
        } else {
            if (type instanceof TypeVariable) {
                throw new IllegalArgumentException("not support callback type " + type.toString());
            }
            this.objectClass = (Class) type;
        }
        if (List.class.equals(this.objectClass)) {
            type = ParameterizedTypeUtil.getParameterizedType(type, List.class, 0);
            if (type instanceof ParameterizedType) {
                cls = (Class) ((ParameterizedType) type).getRawType();
            } else {
                if (type instanceof TypeVariable) {
                    throw new IllegalArgumentException("not support callback type " + type.toString());
                }
                cls = (Class) type;
            }
            httpResponse = (HttpResponse) cls.getAnnotation(HttpResponse.class);
        } else {
            httpResponse = (HttpResponse) this.objectClass.getAnnotation(HttpResponse.class);
        }
        if (httpResponse != null) {
            try {
                Class<? extends ResponseParser> rVar = httpResponse.parser();
                this.parser = rVar.newInstance();
                Loader<?> loader = LoaderFactory.getLoader(ParameterizedTypeUtil.getParameterizedType(rVar, ResponseParser.class, 0));
                this.innerLoader = loader;
                if (loader instanceof ObjectLoader) {
                    throw new IllegalArgumentException("not support callback type " + type);
                }
                return;
            } catch (Throwable th) {
                throw new RuntimeException("create parser error", th);
            }
        }
        throw new IllegalArgumentException("not found @HttpResponse from " + type);
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Loader<Object> newInstance() {
        throw new IllegalAccessError("use constructor create ObjectLoader.");
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void setParams(RequestParams requestParams) {
        this.innerLoader.setParams(requestParams);
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Object load(UriRequest uriRequest) {
        uriRequest.setResponseParser(this.parser);
        return this.parser.parse(this.objectType, this.objectClass, this.innerLoader.load(uriRequest));
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public Object loadFromCache(DiskCacheEntity diskCacheEntity) {
        return this.parser.parse(this.objectType, this.objectClass, this.innerLoader.loadFromCache(diskCacheEntity));
    }

    @Override // com.duoyou.task.sdk.xutils.http.loader.Loader
    public void save2Cache(UriRequest uriRequest) {
        this.innerLoader.save2Cache(uriRequest);
    }
}
