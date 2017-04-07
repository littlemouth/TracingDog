package dfst.com.tracingdog.global;

/**
 * Created by yanfei on 2016-11-21.
 */
public class DataCenter {
    public interface URL {
        String SERVER = "http://192.168.42.69:8080/";
        String LOGIN = SERVER + "login";
    }

    public interface ResponseStatus {
        int SUCCESS = 0;
        int ERROR = -1;
    }
}
