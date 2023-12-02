package com.example.heartdiseasespredictor;

import androidx.appcompat.app.AppCompatActivity;



        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.os.Bundle;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.HashMap;
        import java.util.Map;


public class Mainstuff extends AppCompatActivity {
    EditText age, sex, cp, restbp, chol, maxbp, exang;
    Button predict;
    TextView result;
    String url = "https://cvdpr0-1.onrender.com/predict";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainstuff);

        age = findViewById(R.id.ageIn);
        sex = findViewById(R.id.sexIn);
        cp = findViewById(R.id.cpIn);
        restbp = findViewById(R.id.restbpIn);
        chol = findViewById(R.id.cholIn);
        maxbp = findViewById(R.id.maxbpIn);
        exang = findViewById(R.id.exangIn);
        predict = findViewById(R.id.predict);
        result = findViewById(R.id.result);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data = jsonObject.getString("prediction");
                                    if (data.equals("1")){
                                        result.setText("There's a high chance you have a heart disease, Please seek medical attention ASAP!");
                                    }
                                    else {
                                        result.setText("You are healthy, Keep up the good habits!");
                                    }
                                } catch(JSONException e){
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(Mainstuff.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams(){
                        Map<String, String> params = new HashMap<String, String>();
                        params.put( "age", age.getText().toString());
                        params.put( "sex", sex.getText().toString());
                        params.put( "cp", cp.getText().toString());
                        params.put( "restbp", restbp.getText().toString());
                        params.put( "chol", chol.getText().toString());
                        params.put( "maxbp", maxbp.getText().toString());
                        params.put( "exang", exang.getText().toString());

                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(Mainstuff.this);
                queue.add(stringRequest);
            }
        });
    }
}