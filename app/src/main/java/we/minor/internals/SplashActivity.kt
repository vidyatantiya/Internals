package we.minor.internals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        fun AppCompatActivity.makeItFullScreenStatusBarVisible(){
            supportActionBar?.hide()
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)}

        makeItFullScreenStatusBarVisible()


        val time : Long = 2000
            Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, time)

    }
}