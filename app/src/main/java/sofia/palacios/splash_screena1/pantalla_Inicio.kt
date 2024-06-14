package sofia.palacios.splash_screena1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class pantalla_Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantalla_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Mandar a llamar a todos los elementos
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val txtContra = findViewById<EditText>(R.id.txtContra)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtDui = findViewById<EditText>(R.id.txtDui)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)

        btnAgregar.setOnClickListener {
            //Validar que los campos no estén vacíos
            if (txtNombre.text.isEmpty()
                || txtContra.text.isEmpty()
                || txtEdad.text.isEmpty()
                || txtCorreo.text.isEmpty()
                || txtDui.text.isEmpty() ) {
                Toast.makeText(this, "Complete los campos vacíos", Toast.LENGTH_SHORT).show()
            }
            else{
                //el simbolo de ! simboliza, si no se cumple la condición entonces la aplicación hará
                if(!txtEdad.text.matches("[0-9]+".toRegex())){

                    Toast.makeText(this, "Solo se pueden agregar números en la edad", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}