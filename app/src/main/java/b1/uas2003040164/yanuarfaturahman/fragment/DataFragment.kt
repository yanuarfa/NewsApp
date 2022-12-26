package b1.uas2003040164.yanuarfaturahman.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import b1.uas2003040164.yanuarfaturahman.NewsAdapter
import b1.uas2003040164.yanuarfaturahman.RClient
import b1.uas2003040164.yanuarfaturahman.databinding.FragmentDataBinding
import b1.uas2003040164.yanuarfaturahman.modeldata.ArticlesData
import b1.uas2003040164.yanuarfaturahman.modeldata.NewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataFragment : Fragment() {
    private var _binding: FragmentDataBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val list = ArrayList<NewsData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvData.setHasFixedSize(true)
        binding.rvData.layoutManager = LinearLayoutManager(context)

        RClient.instances.getNews().enqueue(object : Callback<ArticlesData>{
            override fun onResponse(call: Call<ArticlesData>, response: Response<ArticlesData>) {
                val responseCode = response.code()

                response.body()?.let { list.addAll(it.data) }
                val adapter = NewsAdapter(list)
                binding.rvData.adapter = adapter
            }

            override fun onFailure(call: Call<ArticlesData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}