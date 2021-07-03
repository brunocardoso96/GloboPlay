package dominando.android.globoplay.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dominando.android.globoplay.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}