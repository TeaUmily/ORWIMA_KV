package hr.ferit.tumiljanovic.bdayreminder.fragment.my_groups

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.base.BaseFragment
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerAdapter
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper
import kotlinx.android.synthetic.main.fragment_my_groups.*
import javax.inject.Inject

class MyGroupsFragment : BaseFragment(), MyGroupsView {

    @Inject
    lateinit var presenter: MyGroupsPresenter

    @Inject
    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my_groups, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerAdapter = RecyclerAdapter()

        setRecyclerView()
        presenter.getMyGropusInfo()

    }

    private fun setRecyclerView() {
        recycler_my_groups.layoutManager  = GridLayoutManager(context, 2)
        recycler_my_groups.itemAnimator = DefaultItemAnimator()
        recycler_my_groups.adapter = recyclerAdapter
    }

    override fun showMyGroupsInfo(dataList: List<RecyclerWrapper>) {
        recyclerAdapter.addItems(dataList)
    }
}