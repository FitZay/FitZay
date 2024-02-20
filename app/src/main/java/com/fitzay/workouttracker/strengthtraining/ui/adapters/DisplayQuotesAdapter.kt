package com.fitzay.workouttracker.strengthtraining.ui.adapters

import android.content.*
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fitzay.workouttracker.strengthtraining.R
import com.fitzay.workouttracker.strengthtraining.databinding.DisplayQuoteLayoutBinding
import com.fitzay.workouttracker.strengthtraining.di.Component
import com.fitzay.workouttracker.strengthtraining.domain.models.QuotesModel
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class DisplayQuotesAdapter(
    var context: Context, var data: ArrayList<QuotesModel>
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mData: ArrayList<QuotesModel> = data
    private lateinit var binding: DisplayQuoteLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        binding = DisplayQuoteLayoutBinding.inflate(
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
        holder.cat.text = mData[position].text
        binding.authorName.text = mData[position].author

        binding.icCopy.setOnClickListener {
            val clipboardManager =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText(
                "text",
                mData[position].text + "\n\n" + mData[position].author
            )
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(Component.context, "Text Copied", Toast.LENGTH_SHORT).show()
        }

        binding.icShare.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(
                Intent.EXTRA_SUBJECT,
                mData[position].type
            )
            sharingIntent.putExtra(
                Intent.EXTRA_TEXT,
                mData[position].text + "\n\n" + mData[position].author
            )
            context.startActivity(Intent.createChooser(sharingIntent, "Share app via"))
        }
        binding.icSave.setOnClickListener {
            binding.layoutBottom.visibility = View.GONE
            try {
                val bit = getBitmapFromUiView(binding.llTop)
                if (bit != null) {
                    saveBitmapImage(bit)
                } else {
                    Toast.makeText(
                        Component.context,
                        "Error to save! try to copy or share.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
            }
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

    private fun getBitmapFromUiView(view: View?): Bitmap? {
        val returnedBitmap: Bitmap
        val canvas: Canvas

        try {//Define a bitmap with the same size as the view
            returnedBitmap = Bitmap.createBitmap(view!!.width, view.height, Bitmap.Config.ARGB_8888)
            //Bind a canvas to it
            canvas = Canvas(returnedBitmap)
            //Get the view's background
            val bgDrawable = view.background
            if (bgDrawable != null) {
                //has background drawable, then draw it on the canvas
                bgDrawable.draw(canvas)
            } else {
                //does not have background drawable, then draw white background on the canvas
                canvas.drawColor(Color.WHITE)
            }
            // draw the view on the canvas
            view.draw(canvas)
            return returnedBitmap
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
            return null
        }
    }

    /**Save Bitmap To Gallery
     * @param bitmap The bitmap to be saved in Storage/Gallery*/
    private fun saveBitmapImage(bitmap: Bitmap) {
        val timestamp = System.currentTimeMillis()

        //Tell the media scanner about the new file so that it is immediately available to the user.
        val values = ContentValues()
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png")
        values.put(MediaStore.Images.Media.DATE_ADDED, timestamp)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values.put(MediaStore.Images.Media.DATE_TAKEN, timestamp)
            values.put(
                MediaStore.Images.Media.RELATIVE_PATH,
                "Pictures/" + context.getString(R.string.app_name)
            )
            values.put(MediaStore.Images.Media.IS_PENDING, true)
            val uri =
                context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            if (uri != null) {
                try {
                    val outputStream = context.contentResolver.openOutputStream(uri)
                    if (outputStream != null) {
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                            outputStream.close()
                        } catch (e: Exception) {
                            Log.e("Adapter", "saveBitmapImage: ", e)
                        }
                    }
                    values.put(MediaStore.Images.Media.IS_PENDING, false)
                    context.contentResolver.update(uri, values, null, null)
                    binding.layoutBottom.visibility = View.VISIBLE
                    Toast.makeText(context, "Saved In Gallery", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Log.e("Adapter", "saveBitmapImage: ", e)
                }
            }
        } else {
            val imageFileFolder = File(
                Environment.getExternalStorageDirectory()
                    .toString() + '/' + context.getString(R.string.app_name)
            )
            if (!imageFileFolder.exists()) {
                imageFileFolder.mkdirs()
            }
            val mImageName = "$timestamp.png"
            val imageFile = File(imageFileFolder, mImageName)
            try {
                val outputStream: OutputStream = FileOutputStream(imageFile)
                try {
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
                    outputStream.close()
                } catch (e: Exception) {
                    Log.e("Adapter", "saveBitmapImage: ", e)
                }
                values.put(MediaStore.Images.Media.DATA, imageFile.absolutePath)
                context.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
                binding.layoutBottom.visibility = View.VISIBLE
                Toast.makeText(context, "Saved In Gallery", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("Adapter", "saveBitmapImage: ", e)
            }
        }
    }
}