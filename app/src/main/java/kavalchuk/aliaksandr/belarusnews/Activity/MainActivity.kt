package kavalchuk.aliaksandr.belarusnews.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import kavalchuk.aliaksandr.belarusnews.Adapter.ViewPagerAdapter
import kavalchuk.aliaksandr.belarusnews.Fragment.*
import kavalchuk.aliaksandr.belarusnews.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(tb_main)
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setupViewPager(vp_main)
        tabs_layout!!.setupWithViewPager(vp_main)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(AllNewsFragment(), "All")
        adapter.addFrag(PoliticNewsFragment(), "Politic")
        adapter.addFrag(CompanyNewsFragment(), "Company")
        adapter.addFrag(EconomicsNewsFragment(), "Economics")
        adapter.addFrag(EventNewsFragment(), "Event")
        viewPager.adapter = adapter
    }


}
