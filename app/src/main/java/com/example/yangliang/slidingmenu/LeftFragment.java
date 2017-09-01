package com.example.yangliang.slidingmenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


/**
 * 创建日期：2017/8/31 on 下午9:44
 * 描述:左侧菜单
 * 作者: liangyang
 */
public class LeftFragment extends Fragment {


    private View view;
    private ListView mListView;
    //模拟数据源
    private List<String> mDatas = Arrays.asList("聊天", "发现", "通讯录", "朋友圈", "订阅号");
    private ArrayAdapter<String> adapter;


    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_left, container, false);
        mListView = (ListView) view.findViewById(R.id.id_listview_categories);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mDatas);
        mListView.setAdapter(adapter);
        return view;
    }

}
