package dfst.com.tracingdog.callback;

import org.apache.http.conn.ConnectTimeoutException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/**
 * Created by yanfei on 2017-4-7.
 */
public abstract class SimpleHttpCallback<T> implements HttpCallback<T> {
    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof ConnectException) {

        } else if (e instanceof TimeoutException) {

        } else if (e instanceof SocketTimeoutException) {

        }
    }
}
