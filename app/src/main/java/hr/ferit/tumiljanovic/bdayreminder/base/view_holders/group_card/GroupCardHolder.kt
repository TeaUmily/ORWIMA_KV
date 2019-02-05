package hr.ferit.tumiljanovic.bdayreminder.base.view_holders.group_card

import android.support.v7.widget.RecyclerView
import android.view.View
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper

class GroupCardHolder (itemView: View, private var dataList: List<RecyclerWrapper>) : RecyclerView.ViewHolder(itemView)
{

    private lateinit var data: GroupCardHolderData

    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            data = dataList[position].data as GroupCardHolderData
        }
    }

}