package com.example.firsttask.ui.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firsttask.data.model.ItemVoucherSelectionState
import com.example.firsttask.data.model.ItemVoucherState
import com.example.firsttask.data.repository.RetrofitRepository
import kotlinx.coroutines.launch

class VoucherViewModel : ViewModel() {
    private val retrofitRepository = RetrofitRepository()
    private val itemVoucherSelectionState = ItemVoucherSelectionState()

    private val _voucher = MutableLiveData<ItemVoucherSelectionState>()
    var voucher: LiveData<ItemVoucherSelectionState> = _voucher

    @SuppressLint("SuspiciousIndentation")
    fun fetchVoucher() {
        viewModelScope.launch {

            val response = retrofitRepository.getVouchers()
            val newData = response.map { ItemVoucherState.mapItemVoucher(it) }
            val rvData = itemVoucherSelectionState.copy(data = newData)
            _voucher.postValue(rvData)
        }
    }


    fun onClickItem(itemVoucherState: ItemVoucherState) {
        val itemVoucherStateNew = _voucher.value!!.data.map {
            if (it.id == itemVoucherState.id) {
                val nState =
                    if (it.status == ItemVoucherState.Status.Default) ItemVoucherState.Status.Selected else ItemVoucherState.Status.Default
                val newDataTest = it.copy(status = nState)
                newDataTest
            } else {
                it
            }
        }
        val rvData = itemVoucherSelectionState.copy(data = itemVoucherStateNew)
        _voucher.postValue(rvData)

    }

    fun onClickAllItem() {

        val a = _voucher.value!!.selectedVoucher == _voucher.value!!.data.size
        val itemVoucherStateNew = _voucher.value!!.data.map {
            val nState =
                if (a) ItemVoucherState.Status.Default
                else ItemVoucherState.Status.Selected
            val newDataTest = it.copy(status = nState)
            newDataTest
        }
        val rvData = itemVoucherSelectionState.copy(data = itemVoucherStateNew)
        _voucher.postValue(rvData)
    }

}

