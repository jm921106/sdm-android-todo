package com.todo.sdm.sdm_android_todo.activitys;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.todo.sdm.sdm_android_todo.R;
import com.todo.sdm.sdm_android_todo.adapters.TodoAdapter;
import com.todo.sdm.sdm_android_todo.data.DataTodo;
import com.todo.sdm.sdm_android_todo.databinding.ActivityListBinding;

public class ListActivity extends AppCompatActivity {

    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        binding.setA(this);

        setRecyclerView();
    }

    // [#] 액션을 액션 바에 추가하기
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // [#] 액션 버튼이 동작하게 만들기
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.action_plus:
                Toast.makeText(this,"I'm Action Plus !",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_minus:
                Toast.makeText(this,"I'm Action Minus !",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // [#] Recycler View 연동하기 (databinding 이용처리)
    private void setRecyclerView() {
        binding.rcContent.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        TodoAdapter adapter = new TodoAdapter(this);
        binding.rcContent.setAdapter(adapter);

        adapter.updateItems(DataTodo.getDataTodo());
    }

}
