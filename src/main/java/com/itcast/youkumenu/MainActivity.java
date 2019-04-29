package com.itcast.youkumenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout level1;
    private RelativeLayout level2;
    private RelativeLayout level3;
    private ImageView icon_menu;
    private ImageView icon_home;

    /**
     * 是否显示最外层圆环
     * true:显示
     * false:隐藏
     */
    private boolean isShowLevel3 = true;

    /**
     * 是否显示中间圆环
     * true:显示
     * false:隐藏
     */
    private boolean isShowLevel2 = true;

    /**
     * 是否显示最里层圆环
     * true:显示
     * false:隐藏
     */
    private boolean isShowLevel1 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        level3 = (RelativeLayout) findViewById(R.id.level3);
        icon_menu = (ImageView) findViewById(R.id.icon_menu);
        level2 = (RelativeLayout) findViewById(R.id.level2);
        icon_home = (ImageView) findViewById(R.id.icon_home);
        level1 = (RelativeLayout) findViewById(R.id.level1);

        MyOnClickListener myOnClickListener = new MyOnClickListener();
        //设置点击事件
        icon_home.setOnClickListener(myOnClickListener);
        icon_menu.setOnClickListener(myOnClickListener);
    }

    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.icon_home://home键
                    //如果最外层菜单和中间菜单都是显示的，就都设置为隐藏
                    if(isShowLevel2){
                        //隐藏中间菜单
                        isShowLevel2 = false;
                        Tools.hideView(level2);

                        if(isShowLevel3){
                            //隐藏最外层菜单
                            isShowLevel3 = false;
                            Tools.hideView(level3,200);
                        }
                    }else{
                        //显示中间菜单
                        isShowLevel2 = true;
                        Tools.showView(level2);
                    }
                    //如果都是隐藏的，就仅显示中间菜单

                    break;
                case R.id.icon_menu://菜单键

                    if(isShowLevel3){
                        //隐藏
                        isShowLevel3 = false;
                        Tools.hideView(level3);
                    }else{
                        //显示
                        isShowLevel3 = true;
                        Tools.showView(level3);
                    }
                    break;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU){

            //如果三个圆环是显示的，就全部隐藏
            if (isShowLevel1){
                isShowLevel1 = false;
                Tools.hideView(level1);
                if(isShowLevel2){
                    //隐藏中间圆环
                    isShowLevel2 = false;
                    Tools.hideView(level2,200);

                    if (isShowLevel3){
                        //隐藏最外层圆环
                        isShowLevel3 = false;
                        Tools.hideView(level3,400);
                    }
                }
            }else{
                //如果最里层圆环和中间圆环是隐藏的，就显示
                //显示最里层圆环
                isShowLevel1 = true;
                Tools.showView(level1);

                //显示中间圆环
                isShowLevel2 = true;
                Tools.showView(level2,200);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
