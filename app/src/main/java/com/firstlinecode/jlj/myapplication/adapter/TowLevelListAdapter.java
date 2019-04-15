package com.firstlinecode.jlj.myapplication.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.firstlinecode.jlj.myapplication.R;
import com.firstlinecode.jlj.myapplication.adapter.multipleitem.TwoListMultipleItem;

import java.util.List;

public class TowLevelListAdapter extends BaseMultiItemQuickAdapter<TwoListMultipleItem, BaseViewHolder> {

    public TowLevelListAdapter(List<TwoListMultipleItem> data) {
        super(data);
        addItemType(TwoListMultipleItem.TEXT, R.layout.recycler_child_itme);
        addItemType(TwoListMultipleItem.IMG, R.layout.recycler_child_open_itme);
    }

    @Override
    protected void convert(BaseViewHolder helper, TwoListMultipleItem item) {
        switch (helper.getItemViewType()) {
            case TwoListMultipleItem.TEXT:
                helper.setText(R.id.tv_re_child, item.getName());
                break;
            case TwoListMultipleItem.IMG:
//                layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                    @Override
//                    public int getSpanSize(int position) {
//                        return position;
//                    }
//                });
//                helper.setText(R.id.tv1,item.getName());
//                helper.setText(R.id.tv2,item.getId());
//                helper.setText(R.id.tv3,item.getAge());
//                helper.setText(R.id.tv4,item.getPhon());
//                helper.setText(R.id.tv5,item.getSex());
                break;
        }
    }
}
