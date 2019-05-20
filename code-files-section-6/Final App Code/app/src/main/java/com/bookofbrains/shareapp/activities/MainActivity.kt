package com.bookofbrains.shareapp.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.bookofbrains.shareapp.Constants
import com.bookofbrains.shareapp.R
import com.bookofbrains.shareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	companion object {
		val TAG: String = MainActivity::class.java.simpleName
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		btnShowToast.setOnClickListener {
			Log.i(TAG, "Button is Clicked !")
			showToast(resources.getString(R.string.btn_clicked), Toast.LENGTH_LONG)
		}

		btnSendToNextActivity.setOnClickListener {
			val message: String = etUserMessage.text.toString()

			val intent = Intent(this, SecondActivity::class.java)
			intent.putExtra(Constants.USER_MESSAGE_KEY, message)
			startActivity(intent)
		}

		btnShareToOtherApps.setOnClickListener {
			val message: String = etUserMessage.text.toString()

			val intent = Intent()
			intent.action = Intent.ACTION_SEND
			intent.putExtra(Intent.EXTRA_TEXT, message)
			intent.type = "text/plain"

			startActivity(Intent.createChooser(intent, "Share to: "))
		}

		btnShowHobbiesList.setOnClickListener {
			val intent = Intent(this, HobbiesActivity::class.java)
			startActivity(intent)
		}
	}
}
