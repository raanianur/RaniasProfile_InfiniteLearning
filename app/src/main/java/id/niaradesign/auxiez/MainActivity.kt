package id.niaradesign.auxiez

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi ImageView
        imageView = findViewById(R.id.img)

        // Inisialisasi Handler
        handler = Handler(Looper.getMainLooper())

        // Buat objek Runnable
        runnable = Runnable {
            // Kode yang akan dijalankan setelah 5 detik
            val intent = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Mulai menjalankan Runnable dengan delay 5 detik
        handler.postDelayed(runnable, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Hentikan Runnable ketika Activity dihancurkan
        handler.removeCallbacks(runnable)
    }
}
