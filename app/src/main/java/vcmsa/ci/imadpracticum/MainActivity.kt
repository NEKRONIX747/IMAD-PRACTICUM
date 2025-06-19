package vcmsa.ci.imadpracticum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
// this is the declaration of my arrays
    companion object {
        val songTitles = ArrayList<String>()
        val artistNames = ArrayList<String>()
        val ratings = ArrayList<Float>()
        val comments = ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//here i have declared and linked additional variables to the xml file
        val titleInput = findViewById<EditText>(R.id.title)
        val artistInput = findViewById<EditText>(R.id.artist)
        val ratingInput = findViewById<EditText>(R.id.rating)
        val commentInput = findViewById<EditText>(R.id.comment)
        val errorText = findViewById<TextView>(R.id.errorText)
// this is the declaration and linking of the buttons for the home screen
        val addButton = findViewById<Button>(R.id.addButton)
        val detailsButton = findViewById<Button>(R.id.detailsButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        addButton.setOnClickListener {
            errorText.text = ""

            val title = titleInput.text.toString().trim()
            val artist = artistInput.text.toString().trim()
            val ratingStr = ratingInput.text.toString().trim()
            val comment = commentInput.text.toString().trim()
            //Author: OPEN AI
            //software: ChatGPT
            //URL:https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChsSEwjS8Z-Hm_2NAxXnlVAGHQ91BBkYACICCAEQABoCZGc&co=1&gclid=CjwKCAjw6s7CBhACEiwAuHQckti8rJoGV8_q3YHJExlxRXS4V9vKAALGGARMCcdYPIxheY8WbzK0PxoCRfgQAvD_BwE&ohost=www.google.com&cid=CAESVeD2prLx1VQw57jXS_9-vOdBQyitrOgGCBI1zpK8eKVgYtvKpMRMpm1Nx2GoxIRsQnSAHV5lM8ifSThK0uc7DaI3BPGHjlteSCfORH9DW6pdJRk-7UM&category=acrcp_v1_40&sig=AOD64_0_GH6oODYHzROveagtrQ-jcReEDQ&q&adurl&ved=2ahUKEwjin5yHm_2NAxUIWUEAHVgXHBwQ0Qx6BAgJEAE
            if (title.isEmpty() || artist.isEmpty() || ratingStr.isEmpty() || comment.isEmpty()) {
                errorText.text = "Please fill in all fields"
                return@setOnClickListener
            }
//Author: OPEN AI
            //software: ChatGPT
            //URL:https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChsSEwjS8Z-Hm_2NAxXnlVAGHQ91BBkYACICCAEQABoCZGc&co=1&gclid=CjwKCAjw6s7CBhACEiwAuHQckti8rJoGV8_q3YHJExlxRXS4V9vKAALGGARMCcdYPIxheY8WbzK0PxoCRfgQAvD_BwE&ohost=www.google.com&cid=CAESVeD2prLx1VQw57jXS_9-vOdBQyitrOgGCBI1zpK8eKVgYtvKpMRMpm1Nx2GoxIRsQnSAHV5lM8ifSThK0uc7DaI3BPGHjlteSCfORH9DW6pdJRk-7UM&category=acrcp_v1_40&sig=AOD64_0_GH6oODYHzROveagtrQ-jcReEDQ&q&adurl&ved=2ahUKEwjin5yHm_2NAxUIWUEAHVgXHBwQ0Qx6BAgJEAE
            val rating = ratingStr.toFloatOrNull()
            if (rating == null) {
                errorText.text = "Rating must be a valid number"
                return@setOnClickListener
            }

            if (rating < 0) {
                errorText.text = "Rating cannot be less than 0"
                return@setOnClickListener
            }

            if (rating > 5) {
                errorText.text = "Rating cannot be more than 5"
                return@setOnClickListener
            }


            songTitles.add(title)
            artistNames.add(artist)
            ratings.add(rating)
            comments.add(comment)

            Toast.makeText(this, "Song added! Total songs: ${songTitles.size}", Toast.LENGTH_SHORT).show()

            // Clear inputs
            titleInput.text.clear()
            artistInput.text.clear()
            ratingInput.text.clear()
            commentInput.text.clear()
            errorText.text = ""
        }
//Author: OPEN AI
        //software: ChatGPT
        //URL:https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChsSEwjS8Z-Hm_2NAxXnlVAGHQ91BBkYACICCAEQABoCZGc&co=1&gclid=CjwKCAjw6s7CBhACEiwAuHQckti8rJoGV8_q3YHJExlxRXS4V9vKAALGGARMCcdYPIxheY8WbzK0PxoCRfgQAvD_BwE&ohost=www.google.com&cid=CAESVeD2prLx1VQw57jXS_9-vOdBQyitrOgGCBI1zpK8eKVgYtvKpMRMpm1Nx2GoxIRsQnSAHV5lM8ifSThK0uc7DaI3BPGHjlteSCfORH9DW6pdJRk-7UM&category=acrcp_v1_40&sig=AOD64_0_GH6oODYHzROveagtrQ-jcReEDQ&q&adurl&ved=2ahUKEwjin5yHm_2NAxUIWUEAHVgXHBwQ0Qx6BAgJEAE
        detailsButton.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}