package com.app.wheelpicker

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WheelItemAdapter(private var context: Context, private var props: WheelPickerProperties, private val listener: OnWheelPickerListener): RecyclerView.Adapter<WheelItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = if (props.orientation == LinearLayout.VERTICAL) {
            R.layout.picker_wheel_vertical_item
        } else {
            R.layout.picker_wheel_horizontal_item
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return props.itemsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemSelected = (position == props.selectedItemPos && props.enableItemHighlight && !props.scrolling)

        holder.llPicker.tag = position
        //holder.llPicker.setBackgroundColor(if (itemSelected) props.selectedItemBgColor else props.unselectedItemBgColor)
        if (itemSelected)
            holder.llPicker.background = context.resources.getDrawable(R.drawable.bg_selected_options,null)
        else
            holder.llPicker.background = null

        holder.llPicker.setOnClickListener {
            listener.onItemSelected(it.tag as Int, props.itemsList[position])
        }

        holder.topBorder.visibility = if (itemSelected && props.showDivider) View.VISIBLE else View.INVISIBLE
        holder.topBorder.setBackgroundColor(props.dividerColor)

        holder.bottomBorder.visibility = if (itemSelected && props.showDivider) View.VISIBLE else View.INVISIBLE
        holder.bottomBorder.setBackgroundColor(props.dividerColor)

        val params = holder.itemVal.layoutParams
        if (props.orientation == LinearLayout.VERTICAL) { params.width = props.height } else { params.height = props.height }
        holder.itemVal.layoutParams = params
        holder.itemVal.text = props.itemsList[position]
        holder.itemVal.textSize = props.itemsTxtSize

        if (props.itemsTextStyle != 0) {
            holder.itemVal.setTextAppearance(props.itemsTextStyle)
        }

        holder.itemVal.setTextColor(if (itemSelected) props.selectedItemTxtColor else props.unselectedItemTxtColor)
        holder.itemVal.alpha = if (itemSelected) props.selectedItemTxtAlpha else props.unselectedItemsTxtAlpha

        if (props.itemsTxtBold && !props.itemsTxtItalic) holder.itemVal.setTypeface(holder.itemVal.typeface, Typeface.BOLD)

        if (props.itemsTxtItalic && !props.itemsTxtBold) holder.itemVal.setTypeface(holder.itemVal.typeface, Typeface.ITALIC)

        if (props.itemsTxtBold && props.itemsTxtItalic) holder.itemVal.setTypeface(holder.itemVal.typeface, Typeface.BOLD_ITALIC)
    }

    /**
     * Updates the wheel picker adapter
     * @param props WheelPickerProperties The wheel picker properties
     */
    fun update(props: WheelPickerProperties) {
        this.props = props
        notifyDataSetChanged()
    }

    /**
     * View holder class
     */
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var llPicker: LinearLayout = itemView.findViewById(R.id.ll_wp)
        val topBorder: View = itemView.findViewById(R.id.wp_top_border)
        val bottomBorder: View = itemView.findViewById(R.id.wp_bottom_border)
        val itemVal: TextView = itemView.findViewById(R.id.wp_item)
    }
}