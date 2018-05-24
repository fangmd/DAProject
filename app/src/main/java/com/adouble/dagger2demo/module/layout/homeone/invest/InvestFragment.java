package com.adouble.dagger2demo.module.layout.homeone.invest;


import android.os.Bundle;
import android.widget.TextView;

import com.adouble.dagger2demo.R;
import com.nerc.baselibrary.base.LazyBaseFragment;

import butterknife.BindView;

/**
 * Author: Created by fangmingdong on -上午10:20
 * Description:
 */
public class InvestFragment extends LazyBaseFragment<InvestPresenter> implements InvestContract.View {

    @BindView(R.id.tv_invest)
    TextView mTvInvest;


    public InvestFragment() {
        // Required empty public constructor
    }

    public static InvestFragment newInstance() {
        Bundle args = new Bundle();

        InvestFragment fragment = new InvestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.invest_fragment;
    }

    @Override
    protected InvestPresenter getPresenter() {
        return new InvestPresenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void lazyLoad() {
        ((InvestContract.Presenter) mPresenter).getData();
    }

    @Override
    public void showData(int data) {
        int source = Integer.parseInt(mTvInvest.getText().toString());
        mTvInvest.setText(String.valueOf(data + source));
    }
}
