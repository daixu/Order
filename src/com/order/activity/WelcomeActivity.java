package com.order.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.order.R;

public class WelcomeActivity extends Activity {
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.welcome);

    new Handler().postDelayed(new Runnable() {
      public void run() {
        RedirectMainActivity();
      }
    }, 3000);
  }

  /**
   * 跳转
   */
  private void RedirectMainActivity() {
    Intent intent = new Intent();
    intent.setClass(this, MainActivity.class);
    startActivity(intent);
    this.finish();
  }
}