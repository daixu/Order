package com.order.activity;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import com.order.R;

public class MainActivity extends TabActivity {

  private static final String TAB_INFORMATION = "information";
  private static final String TAB_CARTE = "carte";
  private static final String TAB_LIVE = "live";
  private static final String TAB_REGISTRATION = "registration";
  private static final String TAB_ORDERING = "ordering";

  private Intent mInformation, mCarte, mLive,mRegistration, mOrdering;

  private TabHost mTabHost;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    mInformation = new Intent(this, InformationActivity.class);
    mCarte = new Intent(this, InformationActivity.class);
    mLive = new Intent(this, InformationActivity.class);
    mRegistration = new Intent(this, InformationActivity.class);
    mOrdering = new Intent(this, InformationActivity.class);

    mTabHost = getTabHost();
    setupCollectionTab();
    setupClassifyTab();
    setupChartsTab();
    setupCenteredTab();
    setupSearchTab();
  }

  /**
   * 签到
   */
  private void setupCenteredTab() {
    mTabHost.addTab(mTabHost.newTabSpec(TAB_REGISTRATION)
        .setIndicator(prepareTabView(this, R.drawable.icon_registration))
        .setContent(mRegistration));
  }

  /**
   * 菜单
   */
  private void setupClassifyTab() {
    mTabHost.addTab(mTabHost.newTabSpec(TAB_CARTE)
        .setIndicator(prepareTabView(this, R.drawable.icon_carte))
        .setContent(mCarte));
  }

  /**
   * 资讯
   */
  private void setupCollectionTab() {
    mTabHost.addTab(mTabHost.newTabSpec(TAB_INFORMATION)
        .setIndicator(prepareTabView(this, R.drawable.icon_information))
        .setContent(mInformation));
  }

  /**
   * 活动
   */
  private void setupChartsTab() {
    mTabHost.addTab(mTabHost.newTabSpec(TAB_LIVE)
        .setIndicator(prepareTabView(this, R.drawable.icon_live))
        .setContent(mLive));
  }

  /**
   * 订餐
   */
  private void setupSearchTab() {
    mTabHost.addTab(mTabHost.newTabSpec(TAB_ORDERING)
        .setIndicator(prepareTabView(this, R.drawable.icon_ordering))
        .setContent(mOrdering));
  }

  private View prepareTabView(Context context, int imageId) {
    View localView = LayoutInflater.from(context).inflate(
        R.layout.tab_main_nav, null);
    ((ImageView) localView.findViewById(R.id.ivIcon))
        .setImageResource(imageId);
    return localView;
  }
}
