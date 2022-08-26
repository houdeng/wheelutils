package com.houdeng.commonlydialog.customizeddialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.houdeng.commonlydialog.R;
import com.houdeng.commonlydialog.utils.AnimationUtil;

/**
 * 主要是交付到机器人服务那边调用
 * 机器人服务中使用需要使用系统窗口，#line59
 */
public class SOAStartDialog extends AlertDialog {

    private AnimationDrawable toastDrawable;
    public static int ACTION_MAX_LENGTH = 24;
    public static int DURATION = 50;//设置每一帧的加载时间
    private String action_check = "check";

    private ImageView roadCheck;
    private ImageView playlistCheck;
    private ImageView xiangfenCheck;
    private ImageView airConCheck;
    private ImageView close;

    private LinearLayout startDialogView;
    private FrameLayout thenDialogView;

    public SOAStartDialog(Context context) {
        this(context, 0);
    }

    public SOAStartDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_box_start);
        // 弹窗外部蒙层不可取消弹窗(false)
        setCanceledOnTouchOutside(false);

        initView();

        new TempTask().execute();
        //使用系统窗口
//        getWindow().setType((WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY));
    }

    @Override
    public void onStart() {
        super.onStart();

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.width = 2000;
        lp.height = 650;
        lp.dimAmount = 0;

        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().setAttributes(lp);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    public void initView(){
        //StartDialogView里面的内容
        roadCheck = findViewById(R.id.road_iv);
        playlistCheck = findViewById(R.id.playlist_iv);
        xiangfenCheck = findViewById(R.id.xiangfen_iv);
        airConCheck = findViewById(R.id.aircon_iv);

        //thenDialogView里面的内容
        close = findViewById(R.id.close_btn);

        startDialogView = findViewById(R.id.start_dialog_view);//开始显示，后隐藏
        thenDialogView = findViewById(R.id.then_dialog_view);//开始隐藏，后显示

        thenDialogView.setVisibility(View.INVISIBLE);//隐藏
        closeDialog();//初始化按键
    }

    public void setCheckDrawable(ImageView iv){
        toastDrawable = AnimationUtil.addAnimation(getContext(),iv,action_check,ACTION_MAX_LENGTH,DURATION,true);
    }

    /**
     * 关闭弹窗
     */
    private void closeDialog(){
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SOAStartDialog.this.dismiss();

                //动态注册广播接收器
//                IntentFilter intentFilter = new IntentFilter();
//                intentFilter.addAction("com.desay.svicp.broadcast.SOA_LOAD_FINISH");
//                MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
//                getContext().registerReceiver(myBroadcastReceiver, intentFilter);

                //发送广播
                Intent intent = new Intent("com.desay.svicp.broadcast.SOA_LOAD_FINISH");
                getContext().sendBroadcast(intent);
            }
        });
    }

    class TempTask extends AsyncTask<Void,Integer,Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            int i = 0;
            while (true){
                publishProgress(i);
                try {
                    //模拟加载完一个帧动画后多久后开始加载下一个帧动画
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i>4){
                    break;
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            if (values[0] == 0){
                setCheckDrawable(roadCheck);
            }else if (values[0] == 1){
                setCheckDrawable(playlistCheck);
            }else if (values[0] == 2){
                setCheckDrawable(xiangfenCheck);
            }else if (values[0] == 3){
                setCheckDrawable(airConCheck);
            }else {
                try {
                    //设置画面切换时间
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                startDialogView.setVisibility(View.GONE);
                thenDialogView.setVisibility(View.VISIBLE);
            }
        }

    }


}
