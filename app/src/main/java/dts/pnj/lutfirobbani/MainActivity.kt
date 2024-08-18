package dts.pnj.lutfirobbani

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {

    private lateinit var email: AppCompatEditText
    private lateinit var password: AppCompatEditText
    private lateinit var login: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        login = findViewById(R.id.login)

        login.setOnClickListener {
            val kolomemail = email.text.toString()
            val kolompassword = password.text.toString()

            if (kolomemail == "lutfirobbani369@gmail.com" && kolompassword == "Kaito1412") {
                val intent = Intent(this, Home::class.java).apply {
                    putExtra("nama", "Lutfi Robbani")
                    putExtra("nim", "50422818")
                    putExtra("email", "lutfirobbani369@gmail.com")
                    putExtra("kelas", "2IA24")
                }
                startActivity(intent)
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                email.text?.clear()
                password.text?.clear()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
