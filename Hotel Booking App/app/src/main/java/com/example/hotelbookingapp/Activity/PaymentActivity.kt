package com.example.hotelbookingapp.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.hotelbookingapp.R
import com.example.hotelbookingapp.databinding.ActivityPaymentBinding
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject

class PaymentActivity: Activity(), PaymentResultWithDataListener, ExternalWalletListener {

    lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            onBackPressed()

        }

        binding.payNowBtn.setOnClickListener {
                startPayment()
        }



    }

    private fun startPayment() {

        val api_Key = "rzp_test_85eEePBHsKUJk6"

        val activity: Activity = this
        Checkout.preload(activity)
        val co = Checkout()

        co.setKeyID(api_Key)

        val price_in_subunits = 750*100

        try {
            val options = JSONObject()
            options.put("name","Razorpay Corp")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","http://example.com/image/rzp.jpg")
            options.put("theme.color", "#3399cc");
            options.put("currency","INR")
            options.put("order_id", "")
//            options.put("order_id", "order_DBJOWzybf0sJbb")
            options.put("amount",price_in_subunits)//pass amount in currency subunits

            val retryObj = JSONObject()
            retryObj.put("enabled", true)
            retryObj.put("max_count", 4)
            options.put("retry", retryObj)

            val prefill = JSONObject()
            prefill.put("email","tsharma8738@gmail.com")
            prefill.put("contact","8445578738")

            options.put("prefill",prefill)
            co.open(activity,options)
        }
        catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message, Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, CongratsActivity::class.java)
            startActivity(intent)
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        Toast.makeText(this, "Payment Failed!", Toast.LENGTH_SHORT).show()
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {
        Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
    }
}
