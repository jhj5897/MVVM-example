package com.example.mvvmtest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtest.databinding.RecyclerItemBinding

class UserListAdapter internal constructor(context: Context) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {
    private lateinit var recyclerItemBinding: RecyclerItemBinding

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<UserEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        recyclerItemBinding = DataBindingUtil.inflate(inflater, R.layout.recycler_item, parent, false)
        return UserViewHolder(recyclerItemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = users[position]
        holder.bindViewHolder(current)
    }

    override fun getItemCount(): Int = users.size

    internal fun setUsers(users:List<UserEntity>) {
        this.users = users
        notifyDataSetChanged()

    }

    inner class UserViewHolder(private val viewBinding:RecyclerItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bindViewHolder(item:UserEntity) {
            viewBinding.userInfo = item
        }
    }
}