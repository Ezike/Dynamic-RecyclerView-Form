package ezike.tobenna.petform.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(url: String?) {
    if (url != null) Glide.with(context)
        .load(url)
        .thumbnail(.4f)
        .apply(RequestOptions().placeholder(android.R.color.darker_gray))
        .into(this)
}