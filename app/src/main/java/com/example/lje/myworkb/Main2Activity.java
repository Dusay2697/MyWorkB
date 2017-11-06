package com.example.lje.myworkb;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends FragmentActivity {
    int flag = 1;
    private Toast toast;
    ViewGroup rootContainer;
    Scene scene1;
    Scene scene2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Scene클래스
        rootContainer =
                (ViewGroup) findViewById(R.id.rootContainer);//전환을 처리할때는 장면들을 포함하는 루트 컨테이너 확인 필수

        scene1 = Scene.getSceneForLayout(rootContainer,R.layout.activity_main2,this);//getSceneForLayput()메소드는 메인2액티비티파일에 포함된 레이아웃으로부터 장면을 생성한다.

        scene2 = Scene.getSceneForLayout(rootContainer,R.layout.activity_main,this);

        scene1.enter();




        //프래그먼트
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


        Fragment1 fragment1 = new Fragment1();

        fragmentTransaction.add(R.id.container, fragment1);
        fragmentTransaction.commit();//commit:실행



    }
    //Toast
    public void onButton1Clicked(View v){

        toast = Toast.makeText(this, "간단한 앱을 완성하였습니다", Toast.LENGTH_LONG).show();}

    public void onFragment(View v) {
        Fragment fragment;

        switch (flag) {
            default:
            case 0: {
                fragment = new Fragment1();//FRIST화면
                flag = 1;
                break;

            }
            case 1: {
                fragment = new Fragment2();//TWO화면
                flag = 0;
                break;

            }
        }
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();//프래그먼트트랜젝션은 프래크먼트매니저에서 시작한다.
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();//commit:실행
    }



   //Toast
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonShow: {
                toast.show();
                break;

            }
            case R.id.buttonCancel: {
                toast.cancel();
                break;
            }
        }
    }

    //Scene클래스
    public void goToScene2 (View view){//이 메소드는 두 장면 간의 전환을 수행한다.

        TransitionManager.go(scene2);
    }

    public void goToScene1 (View view){

        TransitionManager.go(scene1);
    }






}


