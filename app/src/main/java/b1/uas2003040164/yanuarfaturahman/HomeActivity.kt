package b1.uas2003040164.yanuarfaturahman

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import b1.uas2003040164.yanuarfaturahman.databinding.ActivityHomeBinding
import b1.uas2003040164.yanuarfaturahman.fragment.DataFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment()

        supportActionBar?.hide()
    }

    private fun showFragment() {
        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = DataFragment()

        mFragmentTransaction.add(R.id.fl_data,mFragment).commit()
    }
}