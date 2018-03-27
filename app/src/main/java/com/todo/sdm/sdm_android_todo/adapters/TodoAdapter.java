package com.todo.sdm.sdm_android_todo.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.todo.sdm.sdm_android_todo.R;
import com.todo.sdm.sdm_android_todo.databinding.HomeListTodoBinding;
import com.todo.sdm.sdm_android_todo.models.Todo;

public class TodoAdapter extends BaseAdapter<Todo, TodoAdapter.TodoViewHolder> {


    public TodoAdapter(Context context) {
        super(context);
    }

    @Override
    public void onBindView(TodoViewHolder holder, int position) {

        Todo todo = getItem(position);
        holder.binding.setTodo(todo);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_todo, parent, false);
        return new TodoViewHolder(view);
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {

        HomeListTodoBinding binding;

        public TodoViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }


}
