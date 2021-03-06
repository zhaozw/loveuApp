package com.example.loveuApp.view;

/**
 * Created by caolu on 2016/7/27.
 */
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.loveuApp.R;
import com.example.loveuApp.homepage.run.RunActivity;
import com.example.loveuApp.updata.*;
import com.example.loveuApp.updata.UpFoodActivity;
import com.example.loveuApp.updata.UpHelpActivity;
import com.example.loveuApp.updata.UpPaiActivity;
import com.example.loveuApp.updata.UpdataFragment;


public class TestFragment extends Fragment {
    private Button button;
//
//    TestFragment(Button button){
//        this.button = button;
//    }

    private int[] mDrawables = new int[]{
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher};

    private String[] mTitles = new String[]{
            "AB","AC","AD","AE","AF","AG"};


    private MenuView mMenuView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_layout, container, false);
        return view;
    }



    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMenuView = (MenuView) getActivity().findViewById(R.id.menu_view);

        mMenuView.setMenuResource(mDrawables,mTitles,getActivity());
        mMenuView.setOnMenuClickListener(new MenuView.onMenuClickListener() {
            @Override
            public void onMenuClick(int position) {
                Toast.makeText(getActivity(),""+(position+1),Toast.LENGTH_SHORT).show();
                if(position==0){
                    startActivity(new Intent(getActivity(), UpFoodActivity.class));
                }
                if(position==1){
                    startActivity(new Intent(getActivity(), UpPaiActivity.class));
                }
                if(position==2){
                    startActivity(new Intent(getActivity(), UpHelpActivity.class));
                }
                if (position == 4){
                    startActivity(new Intent(getActivity(),UpRunActivity.class));
                }
                if (position == 5){
                    startActivity(new Intent(getActivity(),UpXueActivity.class));

                }
            }
        });

        button = (Button) getActivity().findViewById(R.id.button_start);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMenuView.toggleMenu();
            }
        });

    }
}
