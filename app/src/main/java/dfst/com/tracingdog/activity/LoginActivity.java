package dfst.com.tracingdog.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.dfst.core.annotation.AView;
import com.dfst.core.annotation.After;
import com.dfst.core.annotation.Layout;
import com.dfst.core.annotation.Listener;
import com.dfst.core.annotation.Resource;

import dfst.com.tracingdog.R;

/**
 * Created by yanfei on 2017-03-29.
 */
@Layout(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements View.OnFocusChangeListener, TextWatcher {
    private static final String TAG = "LoginActivity";
    @AView
    private EditText loginAccountEditText, loginPasswordEditText;
    @AView
    private View loginAccountLineView, loginPasswordLineView;
    @AView
    private ImageView loginAccountClearImageView, loginShowPasswordImageView;

    @Resource(R.color.gray_e5e5e5)
    private int defaultLineColor;
    @Resource(R.color.common_bg_green)
    private int focusLineColor;
    @Resource(R.string.loginPasswordCharSequence)
    private String loginPasswordCharSequence;

    @After
    protected void init() {
        super.init();
        loginAccountEditText.setOnFocusChangeListener(this);
        loginAccountEditText.addTextChangedListener(this);
        loginPasswordEditText.setOnFocusChangeListener(this);
    }

    @Listener(R.id.loginButton)
    private void login(View view) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Listener(R.id.loginAccountClearImageView)
    private void clearAccount(View view) {
        loginAccountEditText.setText("");
    }

    @Listener(R.id.loginShowPasswordImageView)
    private void showPassowrd(View view) {
        if (loginPasswordEditText.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
            loginShowPasswordImageView.setImageResource(R.mipmap.eye_open);
            loginPasswordEditText.setInputType(
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        } else {
            loginShowPasswordImageView.setImageResource(R.mipmap.eye_close);
            loginPasswordEditText.setInputType(
                    InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (v.getId() == R.id.loginAccountEditText) {
            if (hasFocus) {
                loginAccountLineView.setBackgroundColor(focusLineColor);
            } else {
                loginAccountLineView.setBackgroundColor(defaultLineColor);
            }
        } else if (v.getId() == R.id.loginPasswordEditText) {
            if (hasFocus) {
                loginPasswordLineView.setBackgroundColor(focusLineColor);
            } else {
                loginPasswordLineView.setBackgroundColor(defaultLineColor);
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //Log.i(TAG, s.toString());
        if (s.toString().equals("")) {
            loginAccountClearImageView.setVisibility(View.GONE);
        } else {
            loginAccountClearImageView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
