package com.bookofbrains.shareapp.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bookofbrains.shareapp.R
import com.bookofbrains.shareapp.models.Hobby
import com.bookofbrains.shareapp.showToast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbiesList: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

	companion object {
		val TAG: String = HobbiesAdapter::class.java.simpleName
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
		val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
		return MyViewHolder(view)
	}

	override fun getItemCount(): Int {
		return hobbiesList.size
	}

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		val hobby = hobbiesList[position]
		holder.setData(hobby, position)
	}

	inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

		private var pos: Int = 0
		private var currentHobby: Hobby? = null

		init {
			itemView.setOnClickListener {
				currentHobby?.let {
					context.showToast(currentHobby!!.title + " Clicked !")
				}
			}

			itemView.imgShare.setOnClickListener {

				currentHobby?.let {
					val message: String = "My Hobby is : " + currentHobby!!.title

					val intent = Intent()
					intent.action = Intent.ACTION_SEND
					intent.putExtra(Intent.EXTRA_TEXT, message)
					intent.type = "text/plain"
					context.startActivity(Intent.createChooser(intent, "Share to: "))
				}
			}
		}

		fun setData(hobby: Hobby?, position: Int) {

			hobby?.let {
				itemView.txvTitle.text = hobby.title
			}

			this.pos = position
			this.currentHobby = hobby
		}
	}
}
