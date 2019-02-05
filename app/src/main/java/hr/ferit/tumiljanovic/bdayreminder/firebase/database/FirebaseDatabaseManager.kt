/*
 * Copyright (c) 2018 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package hr.ferit.tumiljanovic.bdayreminder.firebase.database

import android.net.Uri
import android.util.Log
import com.google.firebase.database.*
import hr.ferit.tumiljanovic.bdayreminder.common.isBirthDateValid
import hr.ferit.tumiljanovic.bdayreminder.model.User
import javax.inject.Inject

private const val KEY_USER = "user"


class FirebaseDatabaseManager @Inject constructor(private val database: FirebaseDatabase) : FirebaseDatabaseInterface {

    override fun createUser(id: String, firstName: String, lastName: String, email: String, password: String, birthDate: String) {
        val user = User(id, firstName, lastName, email, birthDate, password)

        database.reference.child(KEY_USER).child(id).setValue(user)
    }

    override fun getProfile(id: String, onResult: (User) -> Unit) {
        database.reference
                .child(KEY_USER)
                .child(id)
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val user = dataSnapshot.getValue(User::class.java)
                        user?.run { onResult(user) }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        Log.w("Firebase database manager ->", "loadPost:onCancelled", databaseError.toException())
                    }
                })
    }

    override fun addProfileImage(uri: Uri, userId: String) {
        database.reference.child(KEY_USER).child(userId).child("image").setValue(uri.toString())
    }

    override fun removeUser(id: String, onResult: (Boolean) -> Unit) {
        database.reference.child(KEY_USER).child(id).removeValue().addOnCompleteListener {
            onResult(it.isComplete && it.isSuccessful)
        }
    }

}