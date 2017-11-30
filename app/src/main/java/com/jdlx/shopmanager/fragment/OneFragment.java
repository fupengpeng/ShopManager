package com.jdlx.shopmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.jdlx.shopmanager.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @class_name: OneFragment
 * @Description: 描述
 * @Company: 山东九点连线信息技术有限公司
 * @ProjectName: com.jdlx.shopmanager.fragment
 * @author fupengpeng
 * @date 2017/11/29 0029 17:23
 */
public class OneFragment extends Fragment {
    @BindView(R.id.ibtn_fragment_one)
    ImageButton ibtnFragmentOne;
    Unbinder unbinder;
    private String TAG = "OneFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_one, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.ibtn_fragment_one)
    public void onViewClicked() {
        Log.e(TAG, "onViewClicked: " + "oneFragment");

    }
}
