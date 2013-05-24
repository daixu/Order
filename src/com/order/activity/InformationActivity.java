package com.order.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.order.R;
import com.order.widget.ScrollImage;

public class InformationActivity extends Activity {

  private ScrollImage scrollImage;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.information_activity);
    initView();
  }

  private void initView() {
    scrollImage = (ScrollImage) findViewById(R.id.simage);
    List<Bitmap> list = new ArrayList<Bitmap>();

    list.add(BitmapFactory.decodeResource(getResources(), R.drawable.train));
    list.add(BitmapFactory.decodeResource(getResources(), R.drawable.train));
    list.add(BitmapFactory.decodeResource(getResources(), R.drawable.train));

    int width = getWindowManager().getDefaultDisplay().getWidth();
    scrollImage.setHeight((int) (1.0 * width * list.get(0).getHeight() / list.get(0).getWidth()), list.get(0)
        .getWidth());

    scrollImage.setBitmapList(list);
    scrollImage.start(8 * 1000);
  }

}
