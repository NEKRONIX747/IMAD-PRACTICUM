package vcmsa.ci.imadpracticum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val displayButton = findViewById<Button>(R.id.displayButton)
        val averageButton = findViewById<Button>(R.id.averageButton)
        val returnButton = findViewById<Button>(R.id.returnButton)
        val displayText = findViewById<TextView>(R.id.displayText)
        val averageText = findViewById<TextView>(R.id.averageText)

        //Author: OPEN AI
        //software: ChatGPT
        //URL:https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChsSEwjS8Z-Hm_2NAxXnlVAGHQ91BBkYACICCAEQABoCZGc&co=1&gclid=CjwKCAjw6s7CBhACEiwAuHQckti8rJoGV8_q3YHJExlxRXS4V9vKAALGGARMCcdYPIxheY8WbzK0PxoCRfgQAvD_BwE&ohost=www.google.com&cid=CAESVeD2prLx1VQw57jXS_9-vOdBQyitrOgGCBI1zpK8eKVgYtvKpMRMpm1Nx2GoxIRsQnSAHV5lM8ifSThK0uc7DaI3BPGHjlteSCfORH9DW6pdJRk-7UM&category=acrcp_v1_40&sig=AOD64_0_GH6oODYHzROveagtrQ-jcReEDQ&q&adurl&ved=2ahUKEwjin5yHm_2NAxUIWUEAHVgXHBwQ0Qx6BAgJEAE
        Toast.makeText(this, "Songs received: ${MainActivity.songTitles.size}", Toast.LENGTH_SHORT).show()
// this is where i have initialized the variables and buttons to allow for carry over of information
        displayButton.setOnClickListener {
            var result = ""
            var i = 0
// this will display the information needed once the button has been clicked
            while (i < MainActivity.songTitles.size) {
                result += "Song: ${MainActivity.songTitles[i]}\n"
                result += "Artist: ${MainActivity.artistNames[i]}\n"
                result += "Rating: ${MainActivity.ratings[i]}\n"
                result += "Comment: ${MainActivity.comments[i]}\n\n"
                i++
            }

            displayText.text = if (result.isEmpty()) "No songs in playlist yet." else result
        }

        averageButton.setOnClickListener {
            var total = 0f
            var i = 0

            while (i < MainActivity.ratings.size) {
                total += MainActivity.ratings[i]
                i++
            }
//Author: OPEN AI
            //software: ChatGPT
            //URL:https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChsSEwjS8Z-Hm_2NAxXnlVAGHQ91BBkYACICCAEQABoCZGc&co=1&gclid=CjwKCAjw6s7CBhACEiwAuHQckti8rJoGV8_q3YHJExlxRXS4V9vKAALGGARMCcdYPIxheY8WbzK0PxoCRfgQAvD_BwE&ohost=www.google.com&cid=CAESVeD2prLx1VQw57jXS_9-vOdBQyitrOgGCBI1zpK8eKVgYtvKpMRMpm1Nx2GoxIRsQnSAHV5lM8ifSThK0uc7DaI3BPGHjlteSCfORH9DW6pdJRk-7UM&category=acrcp_v1_40&sig=AOD64_0_GH6oODYHzROveagtrQ-jcReEDQ&q&adurl&ved=2ahUKEwjin5yHm_2NAxUIWUEAHVgXHBwQ0Qx6BAgJEAE
            averageText.text = if (MainActivity.ratings.isNotEmpty()) {
                "Average Rating: %.2f".format(total / MainActivity.ratings.size)
            } else {
                "No ratings yet."
            }
        }
// this will return you to the home page
        returnButton.setOnClickListener {
            finish()
        }
    }
}
