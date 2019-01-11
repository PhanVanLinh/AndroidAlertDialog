package vn.linh.androidalertdialog

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_show_alert.setOnClickListener {
            showAlert()
        }

        button_show_alert_with_edittext.setOnClickListener {
            showAlertWithEditText()
        }

        button_show_alert_with_text_input_layout.setOnClickListener {
            showAlertWithTextInputLayout(this@MainActivity)
        }
    }

    private fun showAlert() {
        val alert = AlertDialog.Builder(this)
            .setTitle(getString(R.string.alert))
            .setMessage(getString(R.string.message))
            .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                dialog.cancel()
            }
            .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                dialog.cancel()
            }.create()

        alert.show()
    }

    private fun showAlertWithEditText() {
        val input = EditText(this)
        input.hint = getString(R.string.hint)

        val alert = AlertDialog.Builder(this)
            .setTitle(getString(R.string.alert))
            .setMessage(getString(R.string.message))
            .setView(input)
            .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
                dialog.cancel()
            }
            .setNegativeButton(getString(R.string.no)) { dialog, _ ->
                dialog.cancel()
            }.create()
        alert.show()
    }

    private fun showAlertWithTextInputLayout(context: Context) {
        val textInputLayout = TextInputLayout(context)
        textInputLayout.setPadding(
            resources.getDimensionPixelOffset(R.dimen.dp_19),
            0,
            resources.getDimensionPixelOffset(R.dimen.dp_19),
            0
        )
        val input = EditText(context)
        textInputLayout.hint = "Email"
        textInputLayout.addView(input)

        val alert = AlertDialog.Builder(context)
            .setTitle("Reset Password")
            .setView(textInputLayout)
            .setMessage("Please enter your email address")
            .setPositiveButton("Submit") { dialog, _ ->
                // do some thing with input.text
                dialog.cancel()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.cancel()
            }.create()

        alert.show()
    }
}
