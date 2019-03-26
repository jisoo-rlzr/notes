package course.intermediate.notes.create

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import course.intermediate.notes.R
import course.intermediate.notes.navigation.NavigationActivity
import kotlinx.android.synthetic.main.activity_create.*

class CreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        intent.getStringExtra(NavigationActivity.FRAGMENT_TYPE_KEY).run {
            textView.text = this
        }
    }
}
