package com.bookofbrains.shareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bookofbrains.shareapp.Constants
import com.bookofbrains.shareapp.R
import com.bookofbrains.shareapp.showToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_second)

		val bundle: Bundle? = intent.extras

		// Safe Call ?.
		// Safe Call with let   ?.let {  }

		bundle?.let {
			val message = bundle.getString(Constants.USER_MESSAGE_KEY)
			showToast(message)

			txvShowMessage.text = message
		}
	}
}