// Mudar texto do parágrafo
function mudarTexto() {
  document.getElementById("paragrafo").innerText = "Um segredo!";
}

// Validação do formulário
function validarFormulario() {
  const nome = document.getElementById("nome").value.trim();
  const email = document.getElementById("email").value.trim();
  const erroDiv = document.getElementById("erroFormulario");

  if (nome === "" || email === "") {
    erroDiv.textContent = "Por favor, preencha todos os campos.";
    return false;
  }

  erroDiv.textContent = "";
  alert("Formulário enviado com sucesso!");
  return true;
}

// Adicionar e remover tarefas
function adicionarTarefa() {
  const input = document.getElementById("novaTarefa");
  const texto = input.value.trim();

  if (texto === "") {
    alert("Digite uma tarefa!");
    return;
  }

  const li = document.createElement("li");
  li.textContent = texto;

  const btnRemover = document.createElement("button");
  btnRemover.textContent = "Remover";
  btnRemover.className = "task-button";
  btnRemover.onclick = function () {
    li.remove();
  };

  li.appendChild(btnRemover);
  document.getElementById("listaTarefas").appendChild(li);

  input.value = "";
}