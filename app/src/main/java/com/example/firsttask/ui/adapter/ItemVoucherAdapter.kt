package com.example.firsttask.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.firsttask.R
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.model.Item_Voucher
import com.example.firsttask.databinding.ItemLayoutBinding
import com.example.firsttask.ui.view.ButtonClickEvent

class ItemVoucherAdapter() :
    RecyclerView.Adapter<ItemVoucherAdapter.ItemVoucherAdapterViewHolder>() {
    private val item = ArrayList<ItemVoucherState>()
    @SuppressLint("NotifyDataSetChanged")
    fun updateItemData(items: List<ItemVoucherState>) {
        item.clear()
        item.addAll(items)
        notifyDataSetChanged()
    }

    var event: ButtonClickEvent? = null
    var count = 0
    var sum = 0.0
    var minus = 0.0
    var minusSelected = 0

    override fun onBindViewHolder(holder: ItemVoucherAdapterViewHolder, position: Int) {
        holder.bind(item[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemVoucherAdapterViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemVoucherAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    inner class ItemVoucherAdapterViewHolder(private var binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemVoucherState) {
            binding.tvNameVoucher.text = item.name
            binding.tvEXP.text = item.amount.toString()
            binding.tvProvider.text = item.provider
            // change icon
//            if (item.checked) {
//                binding.imgPlus.setImageResource(R.drawable.quantity)
//            }else{
//                binding.imgPlus.setImageResource(R.drawable.plus)
//            }
//            if(item.type ==0 && item.checked ){
//                binding.OnlySelectOne.isVisible
//                binding.imgPlus.setImageResource(R.drawable.plusgray)
//            }

            //handle click plus
//            binding.imgPlus.setOnClickListener {
//                item.checked = !item.checked
//                sum = calTotal()
//                count = countItem()
//                event?.clickItemSGD(sum)
//                event?.clickItem(layoutPosition)
//                notifyItemChanged(layoutPosition)
//            }
//            binding.root.setOnClickListener {
////                viewModel.onClickItem(item)
//            }
//            binding.executePendingBindings()
        }
    }

//    private fun calTotal(): Double {
//        var sum= 0.0
//        item.forEach {
//            if (it.checked && it.type ==1) {
//                sum += it.amountt
//            }
//        }
//        return sum
//    }
//
//    private fun calMinusTotal(): Double {
//        var minus = 0.0
//        item.forEach {
//            if (it.checked) {
//                minus -= it.amountt
//            }
//        }
//        return minus
//    }

//    private fun calMinusSelected(): Int {
//        var minus = 0
//        item.forEach {
//            if (it.checked) {
//                minus--
//            }
//        }
//        return minus
//    }

//    private fun countItem(): Int {
//        var count = 0
//        item.forEach {
//            if (it.checked && it.type ==1) {
//                count++
//            }
//        }
//        return count
//    }
//
//    fun clickSelectedAll(select: Boolean) {
//        item.forEach {
//            it.checked = select
//            sum = calTotal()
//            count = countItem()
//            event?.clickItem(count)
//            event?.clickItemSGD(sum)
//            notifyDataSetChanged()
//        }
//    }
//    // change select to unselect when click
//    fun changeUnselect(select: Boolean) {
//        item.forEach {
//            it.checked = !select
//            minus = calMinusTotal()
//            minusSelected = calMinusSelected()
//            event?.clickItem(minusSelected)
//            event?.clickItemSGD(minus)
//            notifyDataSetChanged()
//        }
//
//    }
}