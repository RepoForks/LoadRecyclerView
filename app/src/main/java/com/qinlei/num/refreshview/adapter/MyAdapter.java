package com.qinlei.num.refreshview.adapter;

import android.widget.ImageView;

import com.qinlei.num.loadrecyclerlib.BaseLoadMoreAdapter;
import com.qinlei.num.loadrecyclerlib.ViewHolder;
import com.qinlei.num.refreshview.R;
import com.qinlei.num.refreshview.model.Stories;

import java.util.List;

/**
 * Created by ql on 2017/2/28.
 */

public class MyAdapter extends BaseLoadMoreAdapter<Stories> {
    private final int IMAGE_0 = 100;
    private final int IMAGE_1 = 101;

    public MyAdapter(List<Stories> datas) {
        super(datas);
    }

    @Override
    public int getLayoutId(int viewType) {
        if (viewType == IMAGE_0) {
            return R.layout.item_image_0;
        } else {
            return R.layout.item_image_1;
        }
    }

    @Override
    public void convert(ViewHolder holder, Stories data, int position) {
        if (getNormalItemViewType(position) == IMAGE_1) {
            holder.setText(R.id.item_text_and_image_tv, data.getTitle());
            holder.getView(R.id.item_text_and_image_image, ImageView.class).setImageResource(R.mipmap.ic_launcher);
        } else {
            holder.setText(R.id.item_text_tv, data.getTitle());
        }
    }

    /**
     * 注意复写的是getNormalItemViewType 而不是getItemViewType
     *
     * @param position
     * @return
     */
    @Override
    public int getNormalItemViewType(int position) {
        if (getmDatas().get(position).getImages() == null || getmDatas().get(position).getImages().size() == 0) {
            return IMAGE_0;
        } else {
            return IMAGE_1;
        }
    }
}
