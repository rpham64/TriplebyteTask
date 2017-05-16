package com.rpham64.android.triplebyteproject.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rpham64.android.triplebyteproject.R;
import com.rpham64.android.triplebyteproject.model.Transaction;
import com.rpham64.android.triplebyteproject.ui.adapter.TransactionsAdapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Rudolf on 5/8/2017.
 */

public class TransactionsFragment extends Fragment{

    @InjectView(R.id.recycler_view_transactions) RecyclerView viewTransactions;

    private TransactionsAdapter mAdapter;

    private List<Transaction> mTransactions;

    public static TransactionsFragment newInstance() {

        Bundle args = new Bundle();

        TransactionsFragment fragment = new TransactionsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTransactions = new ArrayList<>();

        Date date1 = new Date(1970, 0, 26);
        String title1 = "Dinner at Momo's";
        String category1 = "Restaurants/Dining";
        String price1 = "$15.35";

        Date date2 = new Date(1970, 0, 27);
        String title2 = "Date night with Julie";
        String category2 = "Entertainment";
        String price2 = "$17.25";

        Transaction transaction1 = new Transaction(date1, title1, category1, price1);
        Transaction transaction2 = new Transaction(date2, title2, category2, price2);

        mTransactions.add(transaction1);
        mTransactions.add(transaction2);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_transactions, container, false);
        ButterKnife.inject(this, view);

        viewTransactions.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        mAdapter = new TransactionsAdapter(getContext(), mTransactions);
        viewTransactions.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public void addTransaction(Transaction transaction) {
        mTransactions.add(transaction);
        mAdapter.notifyItemInserted(mAdapter.getItemCount());
    }
}
