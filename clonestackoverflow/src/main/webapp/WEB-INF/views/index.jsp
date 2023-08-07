<!DOCTYPE html>
<html>
<head>
    <title>Login com Conta Google</title>
    <!-- Adicione a biblioteca de autenticação do Google Sign-In -->
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</head>
<body>
    <h1>Login com Conta Google</h1>
    <div class="g-signin2" data-onsuccess="onSignIn" data-theme="dark" data-clientId="100246644784-m2g46vmhi5nq0i8prpkrn8f5ataid5ae.apps.googleusercontent.com"></div>
    
    <script>
        function onSignIn(googleUser) {
        var idToken = googleUser.getAuthResponse().id_token;

        // Enviar o token para o servidor usando uma chamada AJAX
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'caminho_do_servidor', true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                // O servidor retornou uma resposta bem-sucedida
                var response = JSON.parse(xhr.responseText);
                // Trate a resposta do servidor conforme necessário
            }
        };
        var params = 'idToken=' + encodeURIComponent(idToken);
        xhr.send(params);
    }
    </script>
</body>
</html>
