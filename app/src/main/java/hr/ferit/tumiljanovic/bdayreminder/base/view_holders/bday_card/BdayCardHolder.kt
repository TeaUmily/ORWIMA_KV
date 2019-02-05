package hr.ferit.tumiljanovic.bdayreminder.base.view_holders.bday_card


import android.support.v7.widget.RecyclerView
import android.view.View
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerAdapter
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper
import kotlinx.android.synthetic.main.cell_person_bday.view.*

class BdayCardHolder(itemView: View, private var dataList: List<RecyclerWrapper>, var recyclerAdapter: RecyclerAdapter) : RecyclerView.ViewHolder(itemView) {

    private lateinit var data: BdayCardHolderData


    fun onBind(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            data = dataList[position].data as BdayCardHolderData
        }

        itemView.llDetails.visibility = if (data.expanded) View.VISIBLE else View.GONE

        //this.itemView.ivProfilePic = data.image
        this.itemView.tvFullName.text = data.fullName
        var numOfYears = data.years
        this.itemView.tvNumOfYears.text = numOfYears

        handlePresentIdeaExists()
        setUpItemListener()
        setUpNotificationListener()
        setUpOnAddPresentIdeaClick()
        setUpOnRemovePresentIdeaClick()
    }

    private fun setUpOnRemovePresentIdeaClick() {
        this.itemView.bRemove.setOnClickListener{
            recyclerAdapter.getCardChangesListener().onRemovePresentIdea(data.id, data.presentIdea)
        }
    }

    private fun handlePresentIdeaExists() {
        if (!data.presentIdea.isEmpty()) {
            this.itemView.bAdd.visibility = View.GONE
            this.itemView.rlPresentIdea.visibility = View.VISIBLE
            this.itemView.tvPresentIdeaInput.text = data.presentIdea
        }
        else{
            this.itemView.bAdd.visibility = View.VISIBLE
            this.itemView.rlPresentIdea.visibility = View.GONE
        }
    }

    private fun setUpOnAddPresentIdeaClick() {
        this.itemView.bAdd.setOnClickListener {
            recyclerAdapter.getCardChangesListener().onAddPresentIdea(data.id)
        }
    }

    private fun setUpNotificationListener() {
        this.itemView.sNotiffication.isChecked = data.notification
        this.itemView.sNotiffication.setOnClickListener {
            recyclerAdapter.getCardChangesListener().onNotificationCheckChanged(data.id)
        }
    }


    private fun setUpItemListener() {
        this.itemView.setOnClickListener {
            data.expanded = !data.expanded
            recyclerAdapter.notifyItemChanged(position)
        }
    }

}
