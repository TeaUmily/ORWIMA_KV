package hr.ferit.tumiljanovic.bdayreminder.fragment.account_settings

import android.app.Activity.RESULT_OK
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.support.v7.app.AlertDialog
import android.support.v7.view.ContextThemeWrapper
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hr.ferit.tumiljanovic.bdayreminder.App
import hr.ferit.tumiljanovic.bdayreminder.R
import hr.ferit.tumiljanovic.bdayreminder.R.id.*
import hr.ferit.tumiljanovic.bdayreminder.base.BaseFragment
import hr.ferit.tumiljanovic.bdayreminder.model.User
import hr.ferit.tumiljanovic.bdayreminder.screen.registration.RegisterActivity
import hr.ferit.tumiljanovic.bdayreminder.screen.theme_picker.PickThemeActivity
import kotlinx.android.synthetic.main.fragment_account.*
import javax.inject.Inject

class AccountFragment : BaseFragment(), AccountView {

    @Inject
    lateinit var accountPresenter: AccountPresenter

    private lateinit var filePath: Uri

    private var PICK_IMAGE_REQUEST = 71

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accountPresenter.getUserInfo()

        bAddPicture.setOnClickListener {
            chooseImage()
        }

        bChangeThemeColor.setOnClickListener {
            startActivity(Intent(App.instance, PickThemeActivity::class.java))
        }

        tvDeleteAccount.setOnClickListener {
            showOnDeleteDialog()
        }
    }

    private fun showOnDeleteDialog() {
        val alert = AlertDialog.Builder(ContextThemeWrapper(this.requireContext(), R.style.myDialog))

        with(alert) {
            setTitle("Are you sure you want to delete your account?")

            setPositiveButton(context.getString(R.string.yes)) { dialog, whichButton ->
               accountPresenter.deleteAccount()
            }
            setNegativeButton(context.getString(R.string.cancel)) { dialog, whichButton ->
                dialog.dismiss()
            }
        }
        val dialog = alert.create()
        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        accountPresenter.getUserInfo()
    }

    private fun chooseImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.data != null) {
            filePath = data.data
            Glide.with(App.instance)
                    .load(filePath)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivProfilePicture)
        }
        accountPresenter.uploadImage(filePath)

    }

    override fun showUserInfo(user: User) {
        val fullName = user.firstName + " " + user.lastName
        tvFullName.text = fullName
        tvDateOfBirth.text = user.birthDate
        tvEmail.text = user.email
        tvNumOfMyGroups.text = user.myGroups.size.toString()
        tvNumOfJoinedGroups.text = user.joinedGroups.size.toString()
        if (user.image != "") {
            Glide.with(App.instance)
                    .load(user.image)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivProfilePicture)
        }
    }

    override fun onDeleteAccountMessage() {
        Toast.makeText(App.instance, "Account deleted successfully!", Toast.LENGTH_SHORT).show()
        activity?.finish()
    }

    override fun onDeleteErrorMessage() {
        Toast.makeText(App.instance, "Some error occurred", Toast.LENGTH_SHORT).show()

    }



}