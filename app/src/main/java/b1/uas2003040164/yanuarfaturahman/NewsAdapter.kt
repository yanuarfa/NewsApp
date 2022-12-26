package b1.uas2003040164.yanuarfaturahman

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import b1.uas2003040164.yanuarfaturahman.databinding.ListDatanewsBinding
import b1.uas2003040164.yanuarfaturahman.modeldata.NewsData
import com.bumptech.glide.Glide

class NewsAdapter(
    private val listNews:ArrayList<NewsData>
):RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(itemView: ListDatanewsBinding):RecyclerView.ViewHolder(itemView.root) {
        private val binding = itemView
        fun bind(newsData: NewsData) {
            with(binding) {
                Glide.with(itemView).load(newsData.poster).into(imgPoster)
                tvTitle.text = newsData.title
                tvDescription.text = newsData.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ListDatanewsBinding.inflate(LayoutInflater.from(parent.context),
            parent, false
            ))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(listNews[position])
    }

    override fun getItemCount(): Int = listNews.size
}