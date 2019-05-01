package ezike.tobenna.petform.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import ezike.tobenna.petform.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        scheduleSplashScreen()
    }

    private fun scheduleSplashScreen() {
        Handler().postDelayed({
            routeToActivity()
        }, 1500L)
    }

    private fun routeToActivity() {
        startActivity(Intent(this@SplashActivity, FormActivity::class.java))
        finish()
    }
}

