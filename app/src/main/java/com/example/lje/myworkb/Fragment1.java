package com.example.lje.myworkb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;



public class Fragment1 extends Fragment {
    private Toast toast;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_fragment1,container,false);//인플레이터:XML에서 만든 화면을 단말기에서 볼수있게 해주는 메소드


    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        toast = Toast.makeText(this, "간단한 앱을 완성하였습니다", Toast.LENGTH_LONG).show();
    }

}
