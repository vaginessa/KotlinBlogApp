package blogapp.bittupatel.`in`.kotlinblogapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen : AppCompatActivity() {

    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        splashVideo.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.splashscreen))
        splashVideo.start()

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}
