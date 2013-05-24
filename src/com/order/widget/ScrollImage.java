package com.order.widget;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.order.R;

public class ScrollImage extends RelativeLayout {

  private ImageScrollView imageScrollView = null;

  public ScrollImage(Context context, AttributeSet attrs) {
    super(context, attrs);

    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.scroll_image, ScrollImage.this);

    imageScrollView = (ImageScrollView) this.findViewById(R.id.myImageScrollView);
  }

  /**
   * 设置显示图片
   * @param list
   *          图片集合
   */
  public void setBitmapList(List<Bitmap> list) {
    int num = list.size();
    imageScrollView.removeAllViews();
    for (int i = 0; i < num; i++) {
      ImageView imageView = new ImageView(getContext());
      imageView.setImageBitmap(list.get(i));
      imageScrollView.addView(imageView);
    }
  }

  /**
   * 设置组件的高
   * 
   * @param height
   */
  public void setHeight(int height, int width) {
    android.view.ViewGroup.LayoutParams la = getLayoutParams();
    la.height = height;
    la.width = width;
    android.view.ViewGroup.LayoutParams lap = imageScrollView.getLayoutParams();
    lap.height = height;
    lap.width = width;
  }

  /**
   * 图片开始滚动
   * 
   * @param time
   *          滚动频率，单位：毫秒
   */
  public void start(int time) {
    imageScrollView.start(time);
  }

  /**
   * 图片停止滚动
   */
  public void stop() {
    imageScrollView.stop();
  }

  public int getPosition() {
    return imageScrollView.getCurrentScreenIndex();
  }

  /**
   * 设置监听方法
   * @param clickListener
   */
  public void setClickListener(OnClickListener clickListener) {
    imageScrollView.setClickListener(clickListener);
  }
}
