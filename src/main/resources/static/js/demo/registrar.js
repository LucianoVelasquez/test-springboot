// Call the dataTables jQuery plugin
$(document).ready(function () {});

async function registrarUsuario() {
  let data = {};
  let repitpasword = document.getElementById("exampleRepeatPassword").value;
  data.name = document.getElementById("exampleFirstName").value;
  data.apellido = document.getElementById("exampleLastName").value;
  data.email = document.getElementById("exampleInputEmail").value;
  data.password = document.getElementById("exampleInputPassword").value;

  if (repitpasword != data.password) {
    return;
  }

  console.log(data);
  const req = await fetch("/api/usuarios", {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });
}
