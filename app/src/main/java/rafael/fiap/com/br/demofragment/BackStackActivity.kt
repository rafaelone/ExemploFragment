package rafael.fiap.com.br.demofragment


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Button
import kotlinx.android.synthetic.main.activity_back_stack.*

class BackStackActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)

        btPrimeiro.setOnClickListener {
            val firstFragment = FirstFragment()
            val bundle = Bundle()
            bundle.putString("msg", "I'm first fragment ")
            firstFragment.arguments = bundle
            changeFragment(firstFragment, "frag1")
        }

        btSegundo.setOnClickListener {
            val secondFragment = SecondFragment()
            val bundle = Bundle()
            bundle.putString("msg", "I'm second  fragment")
            secondFragment.arguments = bundle
            changeFragment(secondFragment, "frag2")
        }
    }

    private fun changeFragment(fragment: Fragment, tag: String){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.containerFragment, fragment )
        ft.addToBackStack(tag)
        ft.commit()
    }


}
