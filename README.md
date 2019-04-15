# AndroidStudio.SGC_PUC

Aplicativo para Android desenvolvido em Java e utilizando Android Studio. O aplicativo possui uma tela incial de login que chama um REST para validar as credenciais fornecidas pelo usuário.

## Requisitos

Android Studio 3.1.3.

### Para comunicação do AVD Android Studio (Emulador) com o serviço REST.

Recupere o endereço IP do seu computador(executando o `ipconfig /all` no Windows ou `ifconfig` no Linux).
Utilize o endereço IP recuperado na classe `LoginActivity.java` na linha:
```
url = new URL("http://192.168.0.5:8090/api/ClienteAluno/"+mEmail+"/"+mPassword)
```

Utilize os seguintes e-mails e senhas de teste para efetuar login com sucesso.

Usuários | Senhas
--------- | ------
aluno01@dominio.com.br | 12345
aluno02@dominio.com.br | 12345
aluno03@dominio.com.br | 12345

## Instalando

Basta fazer o download do .ZIP ou via GET.

## Executando

Basta dar o play(executar).
