package com.example.lje.myworkb;

import android.app.TabActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.Toast;


import java.util.ArrayList;
//
public class MainActivity extends TabActivity {//tabhost을 사용할때는 TabActivity
    Fragment1 a;
    private Toast toast;
    Scene scene1;
    Scene scene2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup rootContainer;


        //Scene클래스
        rootContainer =
                (ViewGroup) findViewById(R.id.rootContainer);//전환을 처리할때는 장면들을 포함하는 루트 컨테이너 확인 필수

        scene1 = Scene.getSceneForLayout(rootContainer,R.layout.activity_main2,this);//getSceneForLayput()메소드는 메인2액티비티파일에 포함된 레이아웃으로부터 장면을 생성한다.

        scene2 = Scene.getSceneForLayout(rootContainer,R.layout.activity_main,this);

        scene1.enter();


        //Tabhost
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1").setIndicator("기능1");//탭 메뉴에 해당하는 탭스펙 생성
        tab1.setContent(R.id.tab1);//탭스펙을 탭과 연결
        tabHost.addTab(tab1);//생성한 탭스펙을 탭호스트에 지정

        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2").setIndicator("기능2");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        //TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3").setIndicator("기능2");
        // tab3.setContent(R.id.tab3);
        //tabHost.addTab(tab3);

        tabHost.setCurrentTab(0);//처음에 실행하는 화면이 첫번째 탭이 표시되게 하는 함수

        //Spinner
        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> spinnerlist = new ArrayList<String>();//스피너 내용 작성

        spinnerlist.add("자몽");
        spinnerlist.add("홍시");
        spinnerlist.add("배");
        spinnerlist.add("석류");
        spinnerlist.add("기타");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,spinnerlist);
        spinner.setAdapter(adapter);//스트링리스트를 어댑터에 연결하고 스피너에 연결을 하면 완성
    }
    //Toast
    public void onButton2Clicked(View v){

        toast = Toast.makeText(this, "요일을 선택하였습니다.", Toast.LENGTH_LONG);}

    //Toast
    public void onButton3Clicked(View v){

        toast = Toast.makeText(this, "과일을 선택하였습니다.", Toast.LENGTH_LONG);}

    //Scene클래스
    public void goToScene2 (View view){//이 메소드는 두 장면 간의 전환을 수행한다.

        TransitionManager.go(scene2);
    }

    public void goToScene1 (View view){

        TransitionManager.go(scene1);
    }

}
