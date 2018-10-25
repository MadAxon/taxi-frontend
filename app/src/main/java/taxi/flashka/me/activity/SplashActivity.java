package taxi.flashka.me.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import taxi.flashka.me.repository.preference.SharedPrefs;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (SharedPrefs.getInstance().getToken(this) == null)
            startActivity(new Intent(this, LoginActivity.class));
        else startActivity(new Intent(this, DealActivity.class));
    }
}
