package sofia.palacios.splash_screena1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Aquí en mi Splash Screen programo para que vaya a la pantalla de inicio
        GlobalScope.launch (Dispatchers.Main){
            //Esperamis 3 segundos antes de cambiar de pantalla
            delay(3000)

            //Cambio de pantalla
            val pantallaSiguiente = Intent(this@MainActivity, pantalla_Inicio::class.java)
            startActivity(pantallaSiguiente)
            //Finalizamos la activity
            finish()
        }
    }
}