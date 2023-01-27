package we.minor.internals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fun AppCompatActivity.makeItFullScreenStatusBarVisible(){
            supportActionBar?.hide()
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)}

        makeItFullScreenStatusBarVisible()
        setContentView(R.layout.activity_main)
    }
}