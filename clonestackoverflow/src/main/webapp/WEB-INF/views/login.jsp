<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script src="https://accounts.google.com/gsi/client" async></script>
<script src="https://unpkg.com/jwt-decode/build/jwt-decode.js"></script>
<script>
        function handleCredentialResponse(response) {
          const data = jwt_decode(response.credential)
          console.log(data)
          
          const usuario = {
        	email: data.email,
        	idGoogle: data.sub,
        	nome: data.name,
        	data_criacao: new Date()
    	};
          console.log(usuario)
          
       // Enviar os dados do usuário para o backend
          fetch("/logar", {
              method: "POST",
              headers: {
                  "Content-Type": "application/json"
              },
              body: JSON.stringify(usuario)
          })
          .then(response => response.json())
          .then(result => {
              console.log("Dados do usuário salvos com sucesso:", result);
          })
          .catch(error => {
              console.error("Erro ao salvar os dados do usuário:", error);
          });
        }
        
        window.onload = function () {
          google.accounts.id.initialize({
            client_id: "1091416969329-qdtq2oidvul5okrqoijuc4g81a1sj30p.apps.googleusercontent.com",
            callback: handleCredentialResponse
          });
          google.accounts.id.renderButton(
            document.getElementById("buttonDiv"),
            { theme: "outline", size: "large" }  // customization attributes
          );
          google.accounts.id.prompt(); // also display the One Tap dialog
        }
    </script>
</head>
<body>
	<div id="buttonDiv"></div>
</body>
</html>