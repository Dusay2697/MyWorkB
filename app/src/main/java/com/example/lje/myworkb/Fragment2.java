package com.example.lje.myworkb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment2 extends Fragment {
    private Toast toast;
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_fragment2,container,false);//인플레이터:XML에서 만든 화면을 단말기에서 볼수있게 해주는 메소드


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
}
