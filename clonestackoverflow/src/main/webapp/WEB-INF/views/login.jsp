<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Stackoverflow Clone</title>
  <script src="https://accounts.google.com/gsi/client" async></script>
  <script src="https://unpkg.com/jwt-decode/build/jwt-decode.js"></script>
  
  <script>
    function handleCredentialResponse(response) {
      const data = jwt_decode(response.credential)

      const usuario = {
        email: data.email,
        idGoogle: data.sub,
        nome: data.name,
        data_criacao: new Date()
      };
      

      // Enviar os dados do usuario para o backend
      fetch("/logar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
      })
      	.then(response => response.json())  // Analisar a resposta JSON
        .then(data => {
        	const token = data.token; // Extraindo o token do JSON response
        	document.cookie = "authToken=" + token;
            window.location.href = "http://localhost:4200"; // Redirecionar a p�gina atual para a p�gina Angular
        	
        })
        .catch(error => {
        	console.log(error);
          	alert("Erro ao salvar os dados do usuario:" + error);
        });
    }

    window.onload = function () {
      google.accounts.id.initialize({
        client_id: "1091416969329-qdtq2oidvul5okrqoijuc4g81a1sj30p.apps.googleusercontent.com",
        callback: handleCredentialResponse
      });
      google.accounts.id.renderButton(
        document.getElementById("buttonDiv"),
        { theme: "outline", size: "large" }  // atributos de personaliza��o
      );
      //google.accounts.id.prompt(); // tamb�m exibir o One Tap dialog
    }
  </script>

  <style>
    * {
      margin: 0;
      padding: 0;
    }

    body {
      font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;

      height: 100vh;
      color: #1E1B1D;
    }

    header {
      display: flex;
      align-items: center;
      justify-content: space-between;

      padding: .6rem .4rem 1rem;
      max-width: 984px;

      margin: 0 auto;

      border-bottom: 1px solid #F58025;
    }

    .logo {
      display: flex;
      align-items: end;
    }

    .logo h2 {
      font-size: 1.3rem;
      margin-bottom: .8rem;
    }

    img {
      max-width: 56%;
      object-fit: fill;
    }

    main {
      max-width: 984px;

      margin: 0 auto;
      margin-top: 5rem;
    }

    div.title {
      width: 60%;
      position: relative;
    }

    h1 {
      font-size: 4rem;
      color: #1E1B1D;
    }

    span.emphasis {
      color: #F58025;
      font-size: 4.6rem;
    }

    .smaller {
      position: absolute;

      color: #BBBBBB;
      font-size: 2rem;

      text-align: right;

      bottom: -30px;
      left: 5px;
    }
  </style>
</head>

<body>
  <header>
    <div class="logo">
      <img src="https://stackoverflow.design/assets/img/logos/so/logo-stackoverflow.png" alt="Logo Stackoverflow">
      <h2>clone</h2>
    </div>
    <div id="buttonDiv"></div>
  </header>

  <main>
    <div class="title">
      <h1>Aqui voc� pode fazer perguntas sobre <span class="emphasis">TECNOLOGIA</span></h1>
      <h1 class="smaller">e nossa comunidade te ajuda!</h1>
    </div>
  </main>
</body>

</html>