package dfst.com.tracingdog.callback;

/**
 * Created by yanfei on 2017-4-7.
 */
public interface HttpCallback<T> {
    void onSuccess(T t);
    void onError(Throwable e);
}
