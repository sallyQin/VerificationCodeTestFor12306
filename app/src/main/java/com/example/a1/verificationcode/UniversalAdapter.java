package com.example.a1.verificationcode;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




public abstract class UniversalAdapter extends RecyclerView.Adapter<UniversalHolder> implements View.OnClickListener{
    private int mItemRes;
    int mSelected = -1;

    public UniversalAdapter(@LayoutRes int itemRes) {
        mItemRes = itemRes;
    }

    @Override
    public UniversalHolder onCreateViewHolder(ViewGroup parent, int viewType) {// *通用
        View view = LayoutInflater.from(parent.getContext()).inflate(mItemRes,parent,false);
        UniversalHolder universalHolder = new UniversalHolder(view);
        view.setTag(universalHolder);
        view.setOnClickListener(this);
        return universalHolder;
    }



    @Override
    public void onClick(View v) { // *通用
        Object tag = v.getTag();
        if (tag instanceof RecyclerView.ViewHolder) {   // check tag-changed case
            setSelected(((RecyclerView.ViewHolder) tag).getAdapterPosition());
        }
    }

    public void setSelected(int position) { // *通用
        if (position != mSelected) {  //一旦position发生改变，改变界面
            int old = mSelected;
            mSelected = position;
            if (old >= 0) {
                notifyItemChanged(old);
            }
            if (position >= 0) {
                notifyItemChanged(position);
            }
            onItemChanged(position);
        }
    }

    public void onItemChanged(int position) { //具体需要点击itemView做什么操作
    }

}
