package com.nightonke.date.adapter;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nightonke.saver.R;
import com.nightonke.date.util.StatementDateUtil;

import java.util.ArrayList;


public class DialogSelectListDataAdapter extends BaseAdapter {

    private ArrayList<double[]> data;

    public DialogSelectListDataAdapter(ArrayList<double[]> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        if (data != null) return data.size();
        else return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_select_list_data, null);

        TextView month = (TextView)convertView.findViewById(R.id.month);
        TextView year = (TextView)convertView.findViewById(R.id.year);
        TextView expense = (TextView)convertView.findViewById(R.id.expense);
        TextView sum = (TextView)convertView.findViewById(R.id.sum);

        month.setTypeface(StatementDateUtil.getInstance().typefaceLatoLight);
        year.setTypeface(StatementDateUtil.getInstance().typefaceLatoLight);
        expense.setTypeface(StatementDateUtil.getInstance().typefaceLatoLight);
        sum.setTypeface(StatementDateUtil.getInstance().typefaceLatoLight);

        double monthNum = data.get(position)[1];
        if (monthNum == -1) {
            year.setText((int)data.get(position)[0] + "");
            year.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
            month.setText("--");
        } else {
            month.setText(StatementDateUtil.getInstance().GetMonthShort((int)data.get(position)[1]));
            year.setText((int)data.get(position)[0] + "");
        }
        expense.setText(StatementDateUtil.GetInMoney((int)data.get(position)[3]));
        sum.setText((int)data.get(position)[2] + "'s");

        return convertView;
    }
}
