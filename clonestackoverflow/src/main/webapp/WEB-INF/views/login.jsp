<!DOCTYPE html>
<html lang="en">

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
      console.log(data)

      const usuario = {
        email: data.email,
        idGoogle: data.sub,
        nome: data.name,
        data_criacao: new Date()
      };
      console.log(usuario)

      // Enviar os dados do usu�rio para o backend
      fetch("/logar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(usuario)
      })
        .then(result => {
          alert("Bem-vindo, " + usuario.nome);
          console.log("Dados do usu�rio salvos com sucesso:", result)
        })
        .catch(error => {
          console.error("Erro ao salvar os dados do usu�rio:", error);
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
      <img src="../../../resources/logo-stackoverflow.png" alt="Logo Stackoverflow">
      <h2>clone</h2>
    </div>
    <div id="buttonDiv"></div>
  </header>

  <main>
    <div class="title">
      <h1>Aqui você pode fazer perguntas sobre <span class="emphasis">TECNOLOGIA</span></h1>
      <h1 class="smaller">e nossa comunidade te ajuda!</h1>
    </div>
  </main>
</body>

</html>