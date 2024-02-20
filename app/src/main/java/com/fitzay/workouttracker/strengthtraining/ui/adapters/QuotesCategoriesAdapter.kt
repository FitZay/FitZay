package com.fitzay.workouttracker.strengthtraining.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.QuotesCategoryLayoutBinding
import com.fitzay.workouttracker.strengthtraining.domain.models.QuotesModel
import com.fitzay.workouttracker.strengthtraining.ui.quotes.DisplayQuoteActivity

class QuotesCategoriesAdapter(
    var data: ArrayList<QuotesModel>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mData: ArrayList<QuotesModel> = data
    private lateinit var binding: QuotesCategoryLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        binding = QuotesCategoryLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val lp = binding.root.layoutParams
        if (lp is StaggeredGridLayoutManager.LayoutParams) {
            lp.isFullSpan = false
        }
        return ViewHolder(binding.root)


    }

    override fun onBindViewHolder(holder1: RecyclerView.ViewHolder, position: Int) {

        val holder = holder1 as ViewHolder
        holder.cat.text = mData[position].type

        holder.itemView.setOnClickListener {
            val intent =
                Intent(
                    holder.itemView.context,
                    DisplayQuoteActivity::class.java
                ).apply {
                    putExtra("EXTRA_TYPE", mData[position].type)
                }
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            holder.itemView.context.startActivity(intent)
        }

    }

    // total number of cells
    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var cat: TextView

        init {
            cat = itemView.findViewById(R.id.catText)

        }
    }
}