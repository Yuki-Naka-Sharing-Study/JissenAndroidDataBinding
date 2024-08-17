package com.example.jissenandroiddatabinding

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jissenandroiddatabinding.databinding.ActivityMainBinding
import com.example.jissenandroiddatabinding.databinding.ListExampleBinding
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = ExampleAdapter(this)
        adapter.items = listOf(
            ListItem("ゴミ出し", Date()),
            ListItem("技術書を書く", Date()),
            ListItem("脱稿する", Date())
        )
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

    class ExampleAdapter(context: Context) : RecyclerView.Adapter<Holder>() {
        var items: List<ListItem> = emptyList()
        private val inflater = LayoutInflater.from(context)

        override fun getItemCount(): Int = items.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val binding: ListExampleBinding = DataBindingUtil.inflate(inflater, R.layout.list_example, parent, false)
            return Holder(binding)
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.binding.item = items[position]
            holder.binding.executePendingBindings()
        }
    }

    class Holder(val binding: ListExampleBinding): RecyclerView.ViewHolder(binding.root)
}