package com.adouble.dagger2demo.module.simple;

import com.adouble.dagger2demo.R;
import com.adouble.dagger2demo.base.BaseFragment;
import com.adouble.dagger2demo.dagger.simple.SimpleComponent;
import com.fang.common.base.utils.over.ToastUtil;

import butterknife.Unbinder;

public class SimpleFragment extends BaseFragment implements SimpleContract.View {

    Unbinder unbinder;

//    @Inject
    SimpleContract.Presenter mPresenter;

    private SimpleComponent mComponent;

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void inject() {

    }

    @Override
    public void onResume() {
        super.onResume();

        mPresenter.loadData();
    }

    @Override
    public void showData(String net) {
        ToastUtil.showCLToast(getContext(), net);

    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.simple_frag;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

}
