package com.xhsj.customview.eventconflict.customview;

public interface ICustomView<S extends BaseCustomViewModel> {
    void setData(S data);
}
