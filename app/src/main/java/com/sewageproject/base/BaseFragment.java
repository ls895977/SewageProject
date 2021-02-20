package com.sewageproject.base;
import com.trello.rxlifecycle2.components.support.RxFragment;
public  abstract class BaseFragment extends RxFragment {
    //当前类是否处理ui逻辑
    protected final int disableLayout = -10086;
    private boolean isInitView = false;
    private boolean isVisible = false;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见，获取该标志记录下来
        if (isVisibleToUser) {
            isVisible = true;
            isCanLoadData();
        } else {
            isVisible = false;
        }
    }
    private void isCanLoadData() {
        //所以条件是view初始化完成并且对用户可见
        if (isInitView && isVisible) {
            onLazyLoad();
            //防止重复加载数据
            isInitView = false;
            isVisible = false;
        }
    }
    /**
     * 加载要显示的数据
     */
    protected void onLazyLoad() {

    }
}
