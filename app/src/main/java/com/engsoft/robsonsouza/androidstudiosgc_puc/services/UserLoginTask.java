package com.engsoft.robsonsouza.androidstudiosgc_puc.services;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
    public static UserLoginTask mAuthTask = null;

    private final String mEmail;
    private final String mPassword;
    private URL url = null;
    BufferedReader reader = null;
    StringBuilder stringBuilder;

    public UserLoginTask(String email, String password) {
        mEmail = email;
        mPassword = password;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.

        try {
            /*
            //Robson Souza.
            //URL para acessar o REST.
            url = new URL("http://192.168.0.5:8090/api/ClienteAluno/"+mEmail+"/"+mPassword);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //Robson Souza.
            //Configura o método para GET
            connection.setRequestMethod("GET");

            //Robson Souza.
            //Especifica o tempo máximo de aguardo em segundos(timeout).
            connection.setReadTimeout(15*1000);
            connection.connect();

            //Robson Souza.
            //Verifica se a conexão foi bem sucedida.
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                //Robson Souza.
                //Lê a resposta do REST.
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuilder = new StringBuilder();

                //Robson Souza.
                //Transforma a resposta em String.
                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    stringBuilder.append(line);
                }

                //Robson Souza.
                //Transforma a resposta em Json.
                JSONObject obj = new JSONObject(stringBuilder.toString());

                //Robson Souza.
                //Recupera o valor da chave "resultado".
                String resultado = obj.getString("resultado");

                //Robson Souza.
                //Retorna true para sucesso(credenciais válidas) e false para falha no login(credenciais invalidas).
                return resultado.equals("True") ? true : false;
            }
            */
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        mAuthTask = null;
        /*
        showProgress(false);

        Context contexto = getApplicationContext();
        String texto;
        int duracao = Toast.LENGTH_SHORT;

        //Robson Souza.
        //Verifica o retorno do REST.
        if (success) {
            //Robson Souza.
            //Caso sucesso do login.
            texto = "SUCESSO. Usuário e senha corretos.";

            //Robson Souza.
            //Exibe mensagem.
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        } else {
            //Robson Souza.
            //Caso falha do login.
            texto = "FALHA. Usuário e/ou senha incorretos.";

            //Robson Souza.
            //Exibe mensagem.
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();

        }
        */
    }

    @Override
    protected void onCancelled() {
        mAuthTask = null;
        /*
        showProgress(false);
        */
    }
}
