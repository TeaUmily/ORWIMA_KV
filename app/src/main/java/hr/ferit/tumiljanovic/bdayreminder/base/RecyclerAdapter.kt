package hr.ferit.tumiljanovic.bdayreminder.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper.Companion.TYPE_DIVIDER_BY_DATE
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper.Companion.TYPE_GROUP_CARD
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper.Companion.TYPE_PERSON_BDAY
import hr.ferit.tumiljanovic.bdayreminder.base.view_holders.EmptyViewHolder
import hr.ferit.tumiljanovic.bdayreminder.base.view_holders.bday_card.BdayCardHolder
import hr.ferit.tumiljanovic.bdayreminder.base.view_holders.group_card.GroupCardHolder
import hr.ferit.tumiljanovic.bdayreminder.base.view_holders.group_card.GroupCardHolderData
import hr.ferit.tumiljanovic.bdayreminder.base.view_holders.item_divder_by_date.DividerByDateHolder
import hr.ferit.tumiljanovic.bdayreminder.helpers.BdayCardChangesListener
import javax.inject.Inject

open class RecyclerAdapter @Inject constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var dataList: MutableList<RecyclerWrapper> = mutableListOf()
    private lateinit var cardChangesListener : BdayCardChangesListener


    fun addItems(items: List<RecyclerWrapper>) {
        dataList.clear()
        dataList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            TYPE_PERSON_BDAY -> BdayCardHolder(view, dataList, this)
            TYPE_DIVIDER_BY_DATE -> DividerByDateHolder(view, dataList)
            TYPE_GROUP_CARD -> GroupCardHolder(view, dataList)
            else -> EmptyViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when (viewHolder.itemViewType) {
            TYPE_PERSON_BDAY -> {
                val holder: BdayCardHolder = viewHolder as BdayCardHolder
                holder.onBind(position)
            }
            TYPE_DIVIDER_BY_DATE -> {
                val holder : DividerByDateHolder = viewHolder as DividerByDateHolder
                holder.onBind(position)
            }
            TYPE_GROUP_CARD -> {
                val holder : GroupCardHolder= viewHolder as GroupCardHolder
                holder.onBind(position)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].type
    }

    fun setCardChangesListener(listener: BdayCardChangesListener){
        this.cardChangesListener = listener
    }

    fun getCardChangesListener() = cardChangesListener
}