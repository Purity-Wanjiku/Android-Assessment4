package com.example.assessment.repository

import androidx.lifecycle.LiveData
import com.example.assessment.database.PostDao
import com.example.assessment.models.PostEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PostRepository(private val postDao: PostDao) {
    val allPosts: LiveData<List<PostEntity>> = postDao.getAllPosts()

    suspend fun refreshPosts() {
        return postDao.getAllPosts()

    }

//    val database = ContactsDatabase.getDatabase(ContactsApp.appContext)
//    val dao = database.contactdao()
//    suspend fun saveContact(contact: Contacts){
//        withContext(Dispatchers.IO){
//            dao.insertContact(contact)
//        }
//    }
//    fun fetchContacts(): LiveData<List<Contacts>>{
//        return dao.getAllContacts()
//    }
//
//    fun getContactById(contactId: Int): LiveData<Contacts>{
//        return dao.getContactById(contactId)
//    }
}
