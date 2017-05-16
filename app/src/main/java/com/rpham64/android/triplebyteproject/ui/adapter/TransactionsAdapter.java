package com.rpham64.android.triplebyteproject.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rpham64.android.triplebyteproject.R;
import com.rpham64.android.triplebyteproject.model.Transaction;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Rudolf on 5/8/2017.
 */

public class TransactionsAdapter extends RecyclerView.Adapter<TransactionsAdapter.TransactionsViewHolder> {

    private Context mContext;
    private List<Transaction> mTransactions;

    public TransactionsAdapter(Context context, List<Transaction> transactions) {
        mContext = context;
        mTransactions = transactions;
    }

    @Override
    public TransactionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_transaction_item, parent, false);
        return new TransactionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransactionsViewHolder holder, int position) {
        Transaction transaction = mTransactions.get(position);
        holder.txtTitle.setText(transaction.title);
        holder.txtCategory.setText(transaction.category);
        holder.txtPrice.setText(String.valueOf(transaction.price));
    }

    @Override
    public int getItemCount() {
        if (mTransactions != null) return mTransactions.size();
        return 0;
    }

    class TransactionsViewHolder extends RecyclerView.ViewHolder {

        @InjectView(R.id.transaction_title) TextView txtTitle;
        @InjectView(R.id.transaction_category) TextView txtCategory;
        @InjectView(R.id.transaction_price) TextView txtPrice;

        private Transaction mTransaction;

        public TransactionsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.inject(this, itemView);
        }
    }
}
