package com.kotlinexample.businesscontentapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlinexample.businesscontentapp.databinding.RecyclerViewItemBinding
import com.kotlinexample.businesscontentapp.rest.BusinessContent
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class BusinessListAdapter(private val listener: BusinessContentItemListener) :
    RecyclerView.Adapter<BusinessListViewHolder>() {

    interface BusinessContentItemListener {
        fun onClickedBusiness(characterId: Long)
    }

    private val items = ArrayList<BusinessContent>()

    fun setItems(items: ArrayList<BusinessContent>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessListViewHolder {
        val binding: RecyclerViewItemBinding =
            RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BusinessListViewHolder(binding, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BusinessListViewHolder, position: Int) =
        holder.bind(items[position])

}

class BusinessListViewHolder(
    private val itemBinding: RecyclerViewItemBinding,
    private val listener: BusinessListAdapter.BusinessContentItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var businessContent: BusinessContent

    init {
        //слушатель клика по элементам списка
        itemBinding.root.setOnClickListener(this)
    }

    fun bind(item: BusinessContent) {
        this.businessContent = item
        itemBinding.tvName.text = item.name
        itemBinding.tvPhone.text = item.phone
        itemBinding.tvPrice.text = item.price
        itemBinding.tvRating.text = item.rating.toString()
    }

    override fun onClick(v: View?) {
        listener.onClickedBusiness(businessContent.id)
    }
}







