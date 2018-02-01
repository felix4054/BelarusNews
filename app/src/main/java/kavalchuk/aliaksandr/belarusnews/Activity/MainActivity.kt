package kavalchuk.aliaksandr.belarusnews.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import kavalchuk.aliaksandr.belarusnews.Adapter.ViewPagerAdapter
import kavalchuk.aliaksandr.belarusnews.Fragment.*
import kavalchuk.aliaksandr.belarusnews.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(tb_main)
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        setupViewPager(vp_main)

        tabs_layout!!.setupWithViewPager(vp_main)

//        supportFragmentManager.beginTransaction()
//                .add(R.id.container, AllNewsFragment())
//                .commit()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(AllNewsFragment(), "Последние")
        adapter.addFrag(PoliticNewsFragment(), "Политика")
        adapter.addFrag(CompanyNewsFragment(), "Общество")
        adapter.addFrag(EconomicsNewsFragment(), "Экономика")
        adapter.addFrag(EventNewsFragment(), "Проишествия")
        viewPager.adapter = adapter
    }


}
