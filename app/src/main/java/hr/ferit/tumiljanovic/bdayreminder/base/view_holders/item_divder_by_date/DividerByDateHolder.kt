package hr.ferit.tumiljanovic.bdayreminder.base.view_holders.item_divder_by_date

import android.support.v7.widget.RecyclerView
import android.view.View
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper
import kotlinx.android.synthetic.main.cell_divider_by_date.view.*

class DividerByDateHolder(itemView: View, private var dataList: List<RecyclerWrapper>) : RecyclerView.ViewHolder(itemView) {


    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {

           var data = dataList[position].data as DividerByDateData
            this.itemView.tvDate.text = data.date
        }

    }


}