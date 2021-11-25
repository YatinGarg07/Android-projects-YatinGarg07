package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }int quantity=0;
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped_check);
        CheckBox chocolateCheckBox=(CheckBox) findViewById(R.id.chocolate_check);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();
        boolean hasChocolate=chocolateCheckBox.isChecked();
        EditText nameEditText=(EditText)findViewById(R.id.name_edit_Text);
        String name= nameEditText.getText().toString();
        createOrderSummary(quantity,hasWhippedCream,hasChocolate,name);
    }

    private void createOrderSummary(int quantity,boolean hasWhippedCream,boolean hasChocolate,String name){
        int basePrice=5;
        String priceMessage="Name :"+name;
        if(hasWhippedCream) {priceMessage+="\nAdd Whipped Cream";basePrice+=1;}
        if(hasChocolate){priceMessage+="\nAdd Chocolate";basePrice+=2;}
        priceMessage+="\nQuantity : "+quantity;
        priceMessage+="\nTotal = $"+basePrice*quantity;
        priceMessage+="\n"+getString(R.string.thank_you);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    public void addCoffee(View view) {
        if(quantity==100){
            Toast.makeText(this,"You cannot have more than 100 coffee at a time ",Toast.LENGTH_SHORT).show();
            return;}
            quantity++;
        display(quantity);

    }

    public void removeCoffee(View view) {
        if(quantity==0){
            Toast.makeText(this,"You cannot have less than 1 coffee ",Toast.LENGTH_SHORT).show();
            return;}
            quantity--;
        display(quantity);
    }


}