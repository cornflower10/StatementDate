package com.nightonke.date.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.nightonke.date.model.StatementDateRecord;
import com.nightonke.saver.R;
import com.nightonke.date.model.RecordManager;
import com.nightonke.date.util.StatementDateUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
public class RecordCheckDialogRecyclerViewAdapter extends RecyclerView.Adapter<RecordCheckDialogRecyclerViewAdapter.viewHolder> {

    private OnItemClickListener onItemClickListener;

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private List<StatementDateRecord> coCoinRecords;

    public RecordCheckDialogRecyclerViewAdapter(Context context, List<StatementDateRecord> list) {
        coCoinRecords = new ArrayList<>();
        coCoinRecords = list;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public RecordCheckDialogRecyclerViewAdapter(Context context, List<StatementDateRecord> list, OnItemClickListener onItemClickListener) {
        coCoinRecords = new ArrayList<>();
        coCoinRecords = list;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new viewHolder(mLayoutInflater.inflate(R.layout.record_check_item, parent, false));
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
        holder.imageView.setImageResource(
                StatementDateUtil.GetTagIcon(coCoinRecords.get(position).getTag()));
        holder.date.setText(coCoinRecords.get(position).getCalendarString());
        holder.date.setTypeface(StatementDateUtil.typefaceLatoLight);
        holder.money.setTypeface(StatementDateUtil.typefaceLatoLight);
        holder.money.setText(String.valueOf((int) coCoinRecords.get(position).getMoney()));
        holder.money.setTextColor(
                StatementDateUtil.GetTagColorResource(RecordManager.TAGS.get(coCoinRecords.get(position).getTag()).getId()));
        holder.index.setText((position + 1) + "");
        holder.index.setTypeface(StatementDateUtil.typefaceLatoLight);
        holder.remark.setText(coCoinRecords.get(position).getRemark());
        holder.remark.setTypeface(StatementDateUtil.typefaceLatoLight);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (coCoinRecords == null) {
            return 0;
        }
        return coCoinRecords.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @InjectView(R.id.image_view)
        ImageView imageView;
        @InjectView(R.id.date)
        TextView date;
        @InjectView(R.id.remark)
        TextView remark;
        @InjectView(R.id.money)
        TextView money;
        @InjectView(R.id.index)
        TextView index;
        @InjectView(R.id.material_ripple_layout)
        MaterialRippleLayout layout;

        viewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }

        @Override
        public void onClick(View v) {
//            onItemClickListener.onItemClick(v, getPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }
}