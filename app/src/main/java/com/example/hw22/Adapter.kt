package com.example.hw22

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlin.coroutines.coroutineContext

class Adapter(

    var data: MutableList<DataSource>,
    private val listener: OnItemClickListener,

    ) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private lateinit var myListener: OnItemClickListener

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        init {
            itemView.setOnClickListener(this)


        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    /* fun setOnItemClickListener(listener:OnItemClickListener){
         myListener = listener
     }

     */

    // called when the RecycleView needs a new viewHolder, if the user starts scrolling and
    // we need to make a new item visible
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_items, parent, false)
        return ViewHolder(view)
    }

    // binds the data to the items, will be used to take the data from the list and set it to the coresponding view
    // settings the textviews and imageviews
    // the holder parameter will access the views inside the viewholder, textviews and imageviews
    // position = index
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var image: ImageView = holder.itemView.findViewById(R.id.iv_photo)
        var textDescription: TextView = holder.itemView.findViewById(R.id.tv_Description)
        var textName: TextView = holder.itemView.findViewById(R.id.tv_Name)
        //textDescription.text = data[position].description
        //textName.text = data[position].name
        var deleteIcon: ImageView = holder.itemView.findViewById(R.id.iv_delete)

        deleteIcon.setOnClickListener {

            Log.d("tag", "Delete icon touched")
            val dialogBuilder = AlertDialog.Builder(holder.itemView.context)
            dialogBuilder.setMessage("DO you want to delete this item?")

                .setTitle("Deleting an Item")
                .setCancelable(false)
                .setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, id ->


                    data.removeAt(holder.adapterPosition)
                    notifyItemRemoved(holder.adapterPosition)
                    notifyItemRangeChanged(holder.adapterPosition, data.size)

                })
                .setNegativeButton("No", DialogInterface.OnClickListener { dialog, id ->
                    dialog.dismiss()
                })

            val alert = dialogBuilder.create()
            alert.setTitle("Test")
            alert.show()


        }

        holder.itemView.setOnClickListener {
            val snack = Snackbar.make(it,"${textName.text}", Snackbar.LENGTH_LONG)
            snack.show()

        }
        holder.itemView.apply {
            textDescription.text = data[position].description
            textName.text = data[position].name
            var myUrl = data[position].imageUlr

            Glide.with(context)
                .load(myUrl)
                .into(image)
        }
        holder.itemView.setOnLongClickListener {
            Toast.makeText(holder.itemView.context, "${textDescription.text}", Toast.LENGTH_LONG).show()
            return@setOnLongClickListener true
        }
        //itemView contains all the Views inside the activity_items.xml file

    }

    //counts how many items I have in the recycleView
    override fun getItemCount(): Int {
        return data.size
    }
}
