// Call the dataTables jQuery plugin
$(document).ready(function () {
  updateUsuarios();
  $("#usuarios").DataTable();
});

async function updateUsuarios() {
  const req = await fetch("/api/usuarios", {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "GET",
  });

  const usuarios = await req.json();

  let usuario = "";

  usuarios.map((e) => {
    let eliminar = `<a href="#" onclick="deleteUser(${e.id})" class="btn btn-danger btn-circle btn-sm">
                <i class="fas fa-trash"></i></a>`;
    usuario += `<tr>
      <td>${e.id}</td>
      <td>${e.name}</td>
      <td>${e.email}</td>
      <td>${e.password}</td>
      <td>${eliminar}</td>
    </tr>`;
  });

  document.querySelector("#usuarios tbody").outerHTML = usuario;
}

async function deleteUser(id) {
  const req = await fetch(`/api/usuarios/${id}`, {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "DELETE",
  });
}
