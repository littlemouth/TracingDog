package dfst.com.tracingdog.entity;

import org.json.JSONObject;

import dfst.com.tracingdog.global.DataCenter;

/**
 * Created by yanfei on 2017-4-7.
 */
public class ResponseResult {
    public int status;
    public String message;
    public JSONObject data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
