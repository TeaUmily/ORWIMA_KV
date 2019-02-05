package hr.ferit.tumiljanovic.bdayreminder.fragment.upcoming

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.view.ContextThemeWrapper
import android.support.v7.widget.LinearLayoutManager
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import hr.ferit.tumiljanovic.bdayreminder.App
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.base.BaseFragment
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerAdapter
import hr.ferit.tumiljanovic.bdayreminder.base.RecyclerWrapper
import hr.ferit.tumiljanovic.bdayreminder.common.onTextChanged
import hr.ferit.tumiljanovic.bdayreminder.helpers.BdayCardChangesListener
import kotlinx.android.synthetic.main.fragment_upcoming.*
import javax.inject.Inject

class UpcomingFragment : BaseFragment(), UpcomingView, BdayCardChangesListener {

    @Inject
    lateinit var presenter: UpcomingPresenter

    @Inject
    lateinit var recyclerAdapter: RecyclerAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = LinearLayoutManager(App.instance)


        recyclerAdapter.setCardChangesListener(this)

        presenter.getUpcomingBdays()
    }

    override fun showUpcomingBdays(dataList: List<RecyclerWrapper>) {
        recyclerAdapter.addItems(dataList)
    }

    override fun onNotificationCheckChanged(id: String) {
        Toast.makeText(App.instance, "Stanje se promijenilo", Toast.LENGTH_SHORT).show()
    }

    override fun onAddPresentIdea(id: String) {
        showAlertDialog()
    }

    private fun showAlertDialog() {
        val alert = AlertDialog.Builder(ContextThemeWrapper(this.requireContext(), R.style.myDialog))
        var etPresentIdea: EditText = EditText(this.requireContext())

        with(alert) {
            setTitle("Write down present idea")
            etPresentIdea = EditText(context)
            etPresentIdea.inputType = InputType.TYPE_CLASS_TEXT

            setPositiveButton(context.getString(R.string.add)) { dialog, whichButton ->
                if (!etPresentIdea.text.toString().isEmpty()) {
                    presenter.addPresentIdea(etPresentIdea.text.toString())
                    dialog.dismiss()
                }
            }
            setNegativeButton(context.getString(R.string.cancel)) { dialog, whichButton ->
                dialog.dismiss()
            }
        }
        val dialog = alert.create()
        dialog.setView(etPresentIdea)
        dialog.show()
    }

    override fun onRemovePresentIdea(id: String, presentIdea: String) {
        val alert = AlertDialog.Builder(ContextThemeWrapper(this.requireContext(), R.style.myDialog))
        val ideaString = "\" $presentIdea \" ?"
        with(alert) {
            setTitle(getString(R.string.delet_alert_dialog))
            setMessage(ideaString)
            setPositiveButton("YES") { dialog, whichButton ->
                presenter.removePresentIdea(id)
                Toast.makeText(this.context,getString(R.string.present_idea_deleted), Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            setNegativeButton("NO") { dialog, whichButton ->
                dialog.dismiss()
            }

            val dialog = alert.create()
            dialog.show()
        }

    }
}